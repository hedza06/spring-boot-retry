# Spring Boot Retry Mechanism
This project demonstrates use of Spring Boot retry mechanism. Retry mechanism is very
useful when you use services that produces real-time data. If service fails due to network
error or for example SQL exception (or some other exception) this technique retries job 
execution for given number of attempts. 

## Setup retry
Retry technique can be applied using `@Retryable` annotation. When you use this annotation
you have to provide minimum two annotation parameters (arguments). First is `value` that
defines target exception and second is `maxAttempts` that define maximum number of attempts. 
Example is shown in class `ExternalService.java`.

## Define number of attempts
Number of attempts are defined by annotation parameter `maxAttempts`. By default, `maxAttempts`
are three. 

## Define backoff (delay for next attempt) 
Backoff represents delay for next attempt and it's defined in milliseconds. Backoff is third
parameter of `@Retryable` annotation. 

## Running application
1. Create database `retries`
2. Open terminal and navigate to project directory
3. Type command: `mvn clean install -DskipTest`
4. Run project

## Running tests
1. Open terminal and navigate to project directory
2. Type command: `mvn test`

## Author
Heril Muratović  
Software Engineer  
<br>
**Mobile**: +38269657962  
**E-mail**: hedzaprog@gmail.com  
**Skype**: hedza06  
**Twitter**: hedzakirk  
**LinkedIn**: https://www.linkedin.com/in/heril-muratovi%C4%87-021097132/  
**StackOverflow**: https://stackoverflow.com/users/4078505/heril-muratovic
