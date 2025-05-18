#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE kostple_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_basic') \gexec" | psql "postgresql://sple:sple@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://sple:sple@localhost/kostple_product_basic"
done

java -cp kostple.product.basic --module-path kostple.product.basic -m kostple.product.basic &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait