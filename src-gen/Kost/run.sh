#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp kostple.product.kost --module-path kostple.product.kost -m kostple.product.kost 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE kostple_product_kost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_kost') \gexec" | psql "postgresql://postgres:AdistaAthar@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:AdistaAthar@localhost/kostple_product_kost"
done

wait