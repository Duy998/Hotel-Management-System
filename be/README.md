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