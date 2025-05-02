#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp kostple.product.default --module-path kostple.product.default -m kostple.product.default 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE kostple_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_default') \gexec" | psql "postgresql://:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://:@localhost/kostple_product_default"
done

wait