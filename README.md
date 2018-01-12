Dears,

This is a simple site hosted for free on Heroku (https://expedia-assignment-01.herokuapp.com/) that consumes API as a server-side call and displays returned data in a table,

The site uses java as programming language, spring MVC framework, it has one controler, one view, and one service class.

In the first step the controller takes query parameters in the url and pass it to the service, and the service use the query parameters on the API call.

on the view, the UI support one filter (destinationName) but you can try any one directly from the URL.

to set the project on you local machine just download the project as ZIP file, and import it as archive file on eclipse, then run it on tomcat servet.
or you can use ubuntu terminal, 
download project, extract it, change directory to be in the extracted folder,
then run "mvn package"
and then run "java -jar target/dependency/webapp-runner.jar target/Expedia-Hotels.war"
