echo SELECT 'CREATE DATABASE kostple_product_deltalaporan' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'kostple_product_deltalaporan') \gexec | psql "postgresql://postgres:@localhost"
for %%G in (sql/*.sql) do psql -a -f sql/%%G "postgresql://postgres:@localhost/kostple_product_deltalaporan"

java -cp kostple.product.deltalaporan --module-path kostple.product.deltalaporan -m kostple.product.deltalaporan