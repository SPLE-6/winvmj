echo SELECT 'CREATE DATABASE kostple_product_basic' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_basic') \gexec | psql "postgresql://sple:sple@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://sple:sple@localhost/kostple_product_basic"

java -cp kostple.product.basic --module-path kostple.product.basic -m kostple.product.basic