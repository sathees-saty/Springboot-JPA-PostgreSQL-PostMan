# Springboot-JPA-PostgreSQL-PostMan
Spring Boot + Spring Data JPA + PostgreSQL + Postman Example - USERS

Use spring initializr to create a new Spring boot project with the name: springboot-postgresql-jpa-hibernate-crud-user
Add postgres, JPA, web, Thymeleaf as dependency
Check Maven Dependencies - pom.xml file
Add below dependency - important:
<dependency>
        <groupId>jakarta.validation</groupId>
        <artifactId>jakarta.validation-api</artifactId>
    </dependency>

Configure PostgreSQL Database in application.properties file 
Create JPA Entity - User.java
Important:
Use @GeneratedValue(strategy = GenerationType.SEQUENCE)
In Emplyee POJO class for Primary key id
Instead of 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
Create Spring Data Repository - UserRepository.java
Create Spring Rest Controller - EmployeeController.java
Create Exception(Error) Handling for RESTful Services - ResourceNotFoundException
Customizing Error Response Structure - ErrorDetails
Create GlobalExceptionHandler Class
Running Application 
– Important Application class should be in root package to access Postgres
S. No	API Name	HTTP method	Path	Status code	Description
1	GET users	GET	http://localhost:8080/api/v1/users	200 (OK)	All users are fetched
2	POST users	POST	http://localhost:8080/api/v1/users	201 (Created)	A user is created
3	GET user	GET	http://localhost:8080/api/v1/users/1	200 (OK)	A user is fetched
4	PUT User	PUT	http://localhost:8080/api/v1/users/1	200 (OK)	A user is updated
5	DEELETE User	DELETE	http://localhost:8080/api/v1/users/1	200 (OK)	A user is created

1. Get all Users REST API
The GET method is used to retrieve data from the server
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/users
Output:
[
    {
        "id": 1,
        "firstName": "jothi",
        "lastName": "kumar",
        "emailId": " jothikumar@gmail.com"
    },
    {
        "id": 2,
        "firstName": "ramesh",
        "lastName": "kumar",
        "emailId": " rameshkumar@gmail.com"
    },
    {
        "id": 3,
        "firstName": "shiva",
        "lastName": "kumar",
        "emailId": " shivahkumar@gmail.com"
    }
]

2. Get Employee by ID REST API
HTTP Method: GET 
Request URL: http://localhost:8080/api/v1/users/1
Output:
{
    "id": 1,
    "firstName": "jothi",
    "lastName": "kumar",
    "emailId": " jothikumar@gmail.com"
}

1. Create Employee REST API
The POST method sends data to the server and creates a new resource. 
Important:
Use @GeneratedValue(strategy = GenerationType.SEQUENCE)
In Emplyee POJO class for Primary key id
Instead of 
@GeneratedValue(strategy = GenerationType.IDENTITY) 
HTTP Method: POST 
Request URL: http://localhost:8080/api/v1/users 
Input: Body -> raw
{
"firstName": "shiva",
"lastName": "kumar",
"emailId": " shivahkumar@gmail.com"
}

Ouptut:
{
    "id": 3,
    "firstName": "shiva",
    "lastName": "kumar",
    "emailId": " shivahkumar@gmail.com"
}
4. Update Employee REST API
The PUT method is most often used to update an existing resource.
HTTP Method: PUT 
Body - Raw
Request URL: http://localhost:8080/api/v1/users/3
{
"firstName": "kalai",
"lastName": "kumar",
"emailId": " kalaikumar@gmail.com"
}

The DELETE method is used to delete a resource specified by its URI.
5. Delete Employee REST API
HTTP Method: DELETE 
Request URL: http://localhost:8080/api/v1/users/3
{
    "deleted": true
}

SQL query to create table:
Table: public.employees

DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    id bigint NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    last_name text COLLATE pg_catalog."default" NOT NULL,
    email_address text COLLATE pg_catalog."default" NOT NULL,
    email_id character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
 OWNER to postgres;
	
commit;
