echo SELECT 'CREATE DATABASE kostple_product_default' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_default') \gexec | psql "postgresql://postgres:AdistaAthar@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:AdistaAthar@localhost/kostple_product_default"

java -cp kostple.product.default --module-path kostple.product.default -m kostple.product.default