#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE kostple_product_clarence' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_clarence') \gexec" | psql "postgresql://sple:sple@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://sple:sple@localhost/kostple_product_clarence"
done

java -cp kostple.product.clarence --module-path kostple.product.clarence -m kostple.product.clarence &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait