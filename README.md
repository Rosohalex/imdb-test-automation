# IMDB Test Automation Project

Automated regression test for IMDB search and navigation functionality.

## Technologies Used
- Java 17
- Gradle
- Selenide
- TestNG
- Allure Reports

## Prerequisites
- JDK 17 or higher
- Chrome browser

## Setup and Execution

### Clone the repository
```bash
git clone https://github.com/Rosohalex/imdb-test-automation.git
cd imdb-test-automation
```

### Run tests
```bash
./gradlew clean test
```

### Generate Allure report
```bash
./gradlew allureReport
./gradlew allureServe
```

## Test Scenario
1. Open imdb.com
2. Search for "QA"
3. Save the first title from dropdown
4. Click on first result
5. Verify page title matches saved title
6. Verify more than 3 cast members
7. Click on 3rd cast member
8. Verify correct profile opened
