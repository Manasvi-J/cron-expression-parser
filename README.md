Cron Expression Parser
Cron is a widely-used Unix utility designed for scheduling commands to be executed automatically at specific intervals. This command line application is capable of parsing a cron string, which represents the desired schedule, and then expanding each field to display the exact times when the specified command will run.

Problem Description
The application takes a cron string as input and generates a formatted table with the field name and corresponding times as output. For example:

Input: */15 0 1,15 * 1-5 /usr/bin/find

Output:
minute      0 15 30 45
hour        0
dayOfMonth  1 15
month       1 2 3 4 5 6 7 8 9 10 11 12
dayOfWeek   1 2 3 4 5
command     /usr/bin/find

How to Run
To run the application, follow these steps:

Clone the repository to your local machine.
Navigate to the project directory.
Build the project using Maven:

mvn clean install

Run the JAR file with the cron string as a single argument:

java -jar target/cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
Running Tests
To run the tests for the application, execute the following command in the project directory:
mvn test
Dependencies
The application requires Java and Maven to be installed on your machine.

Contributors
Manasvi
