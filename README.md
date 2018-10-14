# Customer API 

This is a web service that utilizes HATEOAS for it to be ready for hypermedia-driven site (a site that provides information to navigate the site’s REST interfaces dynamically by including hypermedia links with the responses).

### URL
* List of Customers      ```/v1.0.0/customers```
* Single Customer        ```/v1.0.0/customers/:id```

### Method
* GET

### URL Params
* Required: id=[String]   ```example: id=C1``` 

### Success Response
* Code : 200
* Content : 
```
[
    {
        "customerId": "C1",
        "firstName": "First Name 1",
        "lastName": "Last Name 1",
        "address": "Address 1",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/v1.0.0/customers/C1"
            }
        ]
    },
    {
        "customerId": "C2",
        "firstName": "First Name 2",
        "lastName": "Last Name 2",
        "address": "Address 2",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/v1.0.0/customers/C2"
            }
        ]
    },
    {
        "customerId": "C3",
        "firstName": "First Name 3",
        "lastName": "Last Name 3",
        "address": "Address 3",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/v1.0.0/customers/C3"
            }
        ]
    },
    {
        "customerId": "C4",
        "firstName": "First Name 4",
        "lastName": "Last Name 4",
        "address": "Address 4",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/v1.0.0/customers/C4"
            }
        ]
    },
    {
        "customerId": "C5",
        "firstName": "First Name 5",
        "lastName": "Last Name 5",
        "address": "Address 5",
        "links": [
            {
                "rel": "self",
                "href": "http://localhost:8080/v1.0.0/customers/C5"
            }
        ]
    }
]
```

### Error Response
* When Customer ID is not found (e.g. id = C6)
```
{
    "timestamp": "2018-10-14T13:23:37.840+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "Customer with ID C6 not found! ",
    "path": "/v1.0.0/customers/C6"
}
```


### Built With

* [Spring](https://spring.io/guides/gs/rest-service/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Spring HATEOAS](https://spring.io/projects/spring-hateoas) - specific implementation used for Spring
* Mock data is provided using a stub repository


### Versioning

Used [SemVer](http://semver.org/) for versioning. 
