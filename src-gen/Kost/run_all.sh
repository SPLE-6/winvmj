#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE kostple_product_kost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_kost') \gexec" | psql "postgresql://postgres:AdistaAthar@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:AdistaAthar@localhost/kostple_product_kost"
done

java -cp kostple.product.kost --module-path kostple.product.kost -m kostple.product.kost &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait