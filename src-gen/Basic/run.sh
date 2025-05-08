#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp kostple.product.basic --module-path kostple.product.basic -m kostple.product.basic 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE kostple_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_basic') \gexec" | psql "postgresql://postgres:AdistaAthar@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:AdistaAthar@localhost/kostple_product_basic"
done

wait