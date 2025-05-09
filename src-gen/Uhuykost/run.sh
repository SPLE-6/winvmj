#!/bin/bash
source ~/.zshrc  

cleanup() {
    pkill -P $$
    rm java.log
    exit 1
}

trap cleanup SIGINT

java -cp kostple.product.uhuykost --module-path kostple.product.uhuykost -m kostple.product.uhuykost 2>&1 | tee java.log &
JAVA_PID=$!
TEE_PID=$(pgrep -n tee)
tail -f java.log --pid=$TEE_PID | while read -r LINE; do
    if [[ "$LINE" == *"== CREATING OBJECTS AND BINDING ENDPOINTS =="* ]]; then
        break
    fi
done

echo "SELECT 'CREATE DATABASE kostple_product_uhuykost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_uhuykost') \gexec" | psql "postgresql://postgres:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:@localhost/kostple_product_uhuykost"
done

wait