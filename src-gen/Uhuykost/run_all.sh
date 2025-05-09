#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE kostple_product_uhuykost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_uhuykost') \gexec" | psql "postgresql://postgres:@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:@localhost/kostple_product_uhuykost"
done

java -cp kostple.product.uhuykost --module-path kostple.product.uhuykost -m kostple.product.uhuykost &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait