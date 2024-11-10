# Automated Login Tests for Heroku App

This project contains automated tests for verifying login functionality on [Heroku's login page](http://the-internet.herokuapp.com/login). The project includes two test cases: one for a successful login and another for a failed login attempt.

## Project Structure

- **Language**: Java
- **Framework**: Selenium WebDriver
- **Build Tool**: Maven

## Tests Implemented

1. **Successful Login Test**  
   Verifies that a user can log in with valid credentials.

2. **Failed Login Test**  
   Verifies that the login attempt fails when using invalid credentials.

## Prerequisites

- **Java**: Ensure Java 17 or higher is installed.
- **Maven**: Required to build and run the project.
- **Browser Chrome**: The browser chrome should be version 130

## Project Setup

1. Clone or download the project.
2. Ensure you have Java and Maven installed and configured in your system's PATH.
3. Navigate to the project directory in a terminal.

## Running the Tests

To execute the tests, run the following Maven command:

```bash
mvn clean test
