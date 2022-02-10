# JSON Parser

## Overview
This project takes a list of JSON strings and uses the Jackson library to parse them into objects. Then it calculates a sum of the values for each category.
This is a proof of concept project to learn about the Jackson library and get experience with JSON serialization.

### Technologies
The project is written in Java (v. 11.0.8) using the Spring Boot framework (v. 2.4.5) and Jackson (v. 2.12.4).

### Run the JSON Parser
1. Go to the project run configurations, and choose "JsonParserApplication" as the Main Class.
2. Run the application
3. Open a new browser window and visit: http://localhost:8080 where it will display the sum of values by category.

### Future Enhancements
With more time, here are some future enhancements I would add to the project:
1. Reading the records from a stream instead of a .json file
2. Be able to interact with the REST API more and have the user input values from the webpage
3. Change the output results from a formatted String to an Object
4. Parse the input timestamps into a Timestamp object

### Final Thoughts
The Jackson library provides an easy to use serialization tool that can convert json strings to Java objects. There are also plenty of resources available online since it is widely accepted in the Java community.
