echo SELECT 'CREATE DATABASE kostple_product_uhuykost' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_uhuykost') \gexec | psql "postgresql://postgres:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:@localhost/kostple_product_uhuykost"

java -cp kostple.product.uhuykost --module-path kostple.product.uhuykost -m kostple.product.uhuykost