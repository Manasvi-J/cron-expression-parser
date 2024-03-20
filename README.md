# Cron Expression Parser


Cron is a versatile Unix tool crafted for automating command execution at predetermined intervals. This command-line application specializes in parsing cron strings, which encapsulate desired schedules, and subsequently elucidating each field to unveil the precise timings when the designated command is set to execute.

## Overview

The application takes a cron string as input and outputs a formatted table showing the schedule for each field along with the command to be executed. Each field in the cron string corresponds to a specific time unit: minute, hour, day of month, month, and day of week.

For example, given the cron string `"*/15 0 1,15 * 1-5 /usr/bin/find"`, the output will be:

```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```

## Usage

To use this application, follow these steps:

1. Clone the repository to your local machine.
2. Build the project using Maven or your preferred build tool.
```
mvn clean install
```
3. Run the application with the cron string as a single argument:

```
java -jar target/cron-parser-1.0-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"
```

4. View the output showing the expanded schedule for each field.

## Running Tests

To run the tests for the application, execute the following command in the project directory:

```
mvn test
```

## Requirements

- Java 8 or higher
- Maven (for building the project)

## Project Structure

The project follows a standard Maven directory structure:


```
cronparser/
│
├── src/
│   ├── main/
│   │   ├── java/               # Application source code
│   │   │   ├── com/
│   │   │   │   ├── deliveroo/
│   │   │   │   │   ├── cronparser/
│   │   │   │   │   │   ├── manager/
│   │   │   │   │   │   │   ├── CronExpressionParsingManager.java
│   │   │   │   │   │   │   └── IParsingManager.java
│   │   │   │   │   │   ├── model/
│   │   │   │   │   │   │   ├── CronExpressionResponse.java
│   │   │   │   │   │   │   └── CronField.java
│   │   │   │   │   │   └── parser/
│   │   │   │   │   │   │   ├── AsteriskParser.java
│   │   │   │   │   │   │   ├── CommaSeparatedValuesParser.java
│   │   │   │   │   │   │   ├── NumberParser.java
│   │   │   │   │   │   │   ├── Parser.java
│   │   │   │   │   │   │   ├── RangeParser.java
│   │   │   │   │   │   │   ├── StepIncrementParser.java
│   │   │   │   │   │   │   └── IncrementParser.java
│   │   │   │   │   │   └── CronParser.java
│   │   │   │   │   └── Main.java (entry point if needed)
│   │   └── resources/
│   │       └── (if any configuration files or resources)
│   └── test/
│       ├── java/           # Unit tests
│       │   ├── com/
│       │   │   ├── deliveroo/
│       │   │   │   ├── cronparser/
│       │   │   │   │   ├── manager/
│       │   │   │   │   │   ├── CronExpressionParsingManagerTest.java
│       │   │   │   │   │
│       │   │   │   │   ├── model/
│       │   │   │   │   │   └── CronExpressionResponseTest.java
│       │   │   │   │   └── parser/
│       │   │   │   │   │   ├── AsteriskParserTest.java
│       │   │   │   │   │   ├── CommaSeparatedValuesParserTest.java
│       │   │   │   │   │   ├── NumberParserTest.java
│       │   │   │   │   │   ├── RangeParserTest.java
│       │   │   │   │   │   ├── StepIncrementParserTest.java
│       │   │   │   │   └── CronParserTest.java
│       └── resources/
│           └── (if any test resources)
├── pom.xml                  # Maven project configuration
└── README.md                # Project documentation
```

## Contributing

Contributions are welcome! Please feel free to submit issues or pull requests if you encounter any problems or have suggestions for improvements.
