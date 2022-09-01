# rest-exception-handler
This project describe how to handle exception on spring boot rest api

#HOW TO IMPLEMENT ERROR HANDLING FOR SPRING BOOT REST API
Prerequisite
1. Understand Exception
2. Understand Handler component(try, catch and finaly)
3. Understand Constructing exception in plain java
4. Understand concept how to throw exception and handler by try, catch and finaly block(if not see my previous tutorial = https://youtu.be/CGaGuyhckus)
5. you have spring boot which can consume and produce json


Let's jump right in
Exception Level
1. exception in class using @ExceptionHandler= annotation is only active for that particular class where it is declared.
   - create class ResourceNotFoundException in package exception which extend RuntimeException
   - create exception handler inside Employee controller
   - use exception when user to find employee by id, which data not already exists.
   - try to run app
   - try to use exception handle in class DepartementController(not working because, annotation is only active for that particular class where it is declared)

How to define one exception but can use in whole application??
2. A global exception handler using @ExceptionHandler along with @RestControllerAdvice= provides a standard way of handling exceptions throughout the application.  In addition, it considerably reduces the amount of code written for exception handling.
   - Create GlobalErrorHandler class
   - add annotation @RestControllerAdvice
   - collect common occurs exception(ResourceNotFoundException, ResourceAlreadyExistException)this exception commun occurs in all controller
   - Create class ResourceAlreadyExistException which extend RuntimeException
   - create class ResourceNotFoundException which extend RuntimeExcpetion
   - Create Error Message, to define a description to send to the client(statusCode, message, date)
   - Create method in GlobalErrorHandler class
   - try to use ResourceNotFoundException in DepartementController class
   - try to use  ResourceNotFoundException in EmployeeController class
   - try to run app
   - with one ResourceNotFoundException can handle exception in whole app.
