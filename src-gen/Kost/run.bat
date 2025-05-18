echo SELECT 'CREATE DATABASE kostple_product_kost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_kost') \gexec | psql "postgresql://postgres:AdistaAthar@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:AdistaAthar@localhost/kostple_product_kost"

java -cp kostple.product.kost --module-path kostple.product.kost -m kostple.product.kost