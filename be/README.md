# hotel-management-system

#=============run project=================
install mmysql workbench 8.0.1 and create database with name hotel
run command: mvn clean install spring-boot:run

#==========================================
KIll port 

netstat -ano | findstr :8085
TCP    0.0.0.0:8085           0.0.0.0:0              LISTENING       1004
TCP    [::]:8085              [::]:0                 LISTENING       1004
PS D:\1.BT_NOKIA\github_project\Hotel-Management-System\be> taskkill /PID 1004 /F       
SUCCESS: The process with PID 1004 has been terminated.
#==========================================

# Build backend image and run docker container

## Make sure db host is mysqldb: spring.datasource.url=jdbc:mysql://mysqldb/hotel (file application.properties)
## Check if docker network employee-mysql is created
docker network ls

## If docker network employee-mysql is not created, create it
docker network create employee-mysql

## Check if MyQSL server mysqldb is started
docker container ls

## If MyQSL server mysqldb is not started, start it (wait few minutes for the server fully started)
docker container run --name mysqldb --network employee-mysql -e MYSQL_ROOT_PASSWORD=12345 -e MYSQL_DATABASE=hotel -d mysql:8

## Build hotel-management-system image
docker build --tag hotel-management-system .

## Start backend app
docker run --network employee-mysql --publish 8085:8085  hotel-management-system

## Test
http://localhost:8085/api/user