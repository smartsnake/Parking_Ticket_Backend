## Parking Ticket Backend

RESTful API that interacts with a MongoDB database containing an arbitrary point document structure. Implemented in Java with Spring Boot and Maven.  For dev mode `application.properties` needs to have the line `spring.profiles.active=dev`, and the server looks for a MongoDB named `pointTest` on `localhost:27017` without login credentials required (MongoDB defaults).  The collection of invoice documents inside `pointTest` must be named `pointTest`.  This is a proof of concept project therefore no care was taken to conceal login creditials as they are no longer valid as of making this repository public.

# Example Point JSON structure
```
{
  "lat" : 57.8907,
  "lon" : 27.9876,
  "time" : 12345678987654
}
```
  
 # HTTP requests
 
 ## List All Points
`curl -i -s -X GET http://localhost:8080/points/`
 ## Get points within time
 `curl -i -s -X GET http://localhost:8080/points?time1={time1}&time2={time2}`
 ## Create Point
 `curl -i -s -H "Content-Type: application/json" -X POST -d '{Point JSON payload}' http://localhost:8080/point/`

