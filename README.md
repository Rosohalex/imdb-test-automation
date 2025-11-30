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
2. Search for "QA" with the search bar
3. When dropdown opens, save the name of the first title
4. Click on the first title
5. Verify that page title matches the one saved from the dropdown
6. Verify there are more than 3 members in the "top cast section"
7. Click on the 3rd profile in the "top cast section"
8. Verify that correct profile have opened
