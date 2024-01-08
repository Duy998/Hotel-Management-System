# Start MySQL by command line #
### Create network
docker network create employee-mysql

### List network
docker network ls

### Start MyQSL server
docker container run --name mysqldb --network employee-mysql -e MYSQL_ROOT_PASSWORD=12345 -e MYSQL_DATABASE=hotel -d mysql:8

### List docker container
docker container ls

### Access docker container
docker exec -it [CONTAINER ID] /bin/bash

### Login mySQL
bash-4.4# mysql -p12345

### Check if table 'hotel' is created
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| hotel              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)

mysql>