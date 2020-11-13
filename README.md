# Task 

## Implementation details.
The project was created on Java in IntelliJ IDEA in compliance with the SOLID principles. 
The technologies used in the project are as follows: 
- Spring Boot;
- Maven for assembling the project;
- Configure the check style plugin.



### Start instructions
Clone the project from this repository.
Install MySQL Workbench, and add all the necessary properties to the application.properties folder to connect to the database. 
To check the filtering of a query in the database, you need to encode it using the `URLEncoder` class and the `encode` method using the `StandardCharsets.UTF_8` as one of method parameters.
Add the dependency for Mockito to Mockito file.
When displaying information, is used pagination, forming url, it is possible to enter which page number to display and how many items there will be on the page using page=... &size=... .
If this is not specified, then the default implementation will work.


## Author.
[Kostiantyn Vorobiov](https://github.com/KostiantynVorobiov)