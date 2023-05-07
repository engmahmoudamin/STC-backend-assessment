# STC-backend-assessment

### This repo consists of three parts:

1- Problem Solving Task: The solution of this task will be found inside
problem.solving directory

2- Database query Task: All scripts of this task will be found inside
database-query directory

3- System design Task: The project of this task will be found inside
system-design directory


### System Design APIS:
##### Run steps:
    1- generate the jar file by using mvn install -DskipTests
    2- build docker image by using the following command in the project directory docker build -t stc-demo-api.jar .
    3- the last step run docker-compose up -d

##### To Test APIS:
    There is postman collection in postman-collections directory to use in test the apis
    - I created 5 Controllers
        1- TestApi: to test that the project is running (for testing purpose only)
        2- PermissionGroupApi: to create groups and fetch all groups
        3- PermissionApi: to create permissions and fetch all groups
        4- ItemApi: to create items [space/folder]
        5- FileApi: to create files , retrieve file metadata and download files

###### Note: the apis will run on port 8088, and I used only rest apis.