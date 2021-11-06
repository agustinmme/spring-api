# spring-api
- Simple API Profile Register,login,edit,remove.
- 👨‍💻 end-points:
- http://localhost:8080/api-test/login - POST - BODY:"email":"XXX","password":"XXX"
- http://localhost:8080/api-test/api-test/user/register - POST - BODY:"name":"XXX", "lastname":"XXX","phone":"XXX","email":"XXX","password":"XXX"
- http://localhost:8080/api-test/user/{id} - DELETE - HEADER=> Authorization: Token
- http://localhost:8080/api-test/users - GET - HEADER=> Authorization: Token 
Next uppdate : Add return errors && GetById.
