#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp kostple.product.clarence --module-path kostple.product.clarence -m kostple.product.clarence 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE kostple_product_clarence' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_clarence') \gexec" | psql "postgresql://sple:sple@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://sple:sple@localhost/kostple_product_clarence"
done

wait