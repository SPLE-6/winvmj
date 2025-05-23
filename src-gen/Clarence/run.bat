echo SELECT 'CREATE DATABASE kostple_product_clarence' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_clarence') \gexec | psql "postgresql://sple:sple@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://sple:sple@localhost/kostple_product_clarence"

java -cp kostple.product.clarence --module-path kostple.product.clarence -m kostple.product.clarence