## Usage
This project is used in conjunction with the frontend project: 
https://github.com/Team-Irie/Restaurant-Reservation-System-Frontend

Before use 
    Ensure that a postgres database is prepared to connect to the application
        - this application utilizes postgresql 15 insure it is installed if you are testing locally
    Ensure that a Yelp API key is prepared

Enter the information for the postgres db in application.properties

Enter the Yelp API Key in the SearchYelpService

Build the project and run before connecting to the frontend project

# UPDATING FROM SPRING BOOT V2.6.3

 - UPGRADE GRADLE to 7.4.2 PRIOR TO UPGRADING TO SPRING BOOT 2.7
 - ENSURE THAT THE PROJECT IS UTILIZING JAVA 17
 - ENSURE GRADLE IS USING JAVA 17 IN BUILD.GRADLE AND IN THE COMPILER
 - TO DO THIS GOTO FILE>SETTINGS>BUILD, EXECUTION, DEPLOYMENT>GRADLE AND SELECT SDK 17
 - UPDATE TO V2.7.12 BEFORE UPDATING TO V3.0.0
 - AFTER UPDATING TO V3.0.0 CHECK FOR ALL INSTANCES OF JAVAX.PERSISTENCE AND REPLACE WITH JAKARTA.PERSISTENCE 