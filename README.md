# RELEASE NOTES
This API is built using
1. JAVA 1.8.
2. Maven 3.5.2

# How to build the application
1. Clone the project on any local disk
2. Go in RockPaperScissor director
3. Run mvn clean install

# How to start 
1. Go in RockPaperScissor director
2. Run java -jar target/RockPaperScissor-0.0.1-SNAPSHOT.jar, this will start the server

# How to play game
Use following API via postman
1. http://localhost:8080/rock - for user action as rock
2. http://localhost:8080/paper - for user action as paper
3. http://localhost:8080/scissor - for user action as scissor
4. Use header Content-Type:application/json

or use following postman link for fetching my collection
- https://www.getpostman.com/collections/e230a1fd80a1ced0e270

# Notes
1. With each call API will return user and computer input along with number of winning for either
2. You can play game any number of times
3. As soon as a player (computer/human) reaches 3 wins current game will finish and next call will initiate a new game
4. Please see sample responses for some of the responses
5. Refer sample responses inside sample folder