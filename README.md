# KeywardDrivenProject_01

A Java + Selenium + TestNG based keyword-driven test automation framework.
It allows you to write test steps in a .csv file and run automated test cases by interpreting those steps.

# Features
⚡️ Supports OpenBrowser, NavigateTo, Click, Type, and VerifyText keywords

📄 Enables test case execution from external CSV files

🕹️ Uses ThreadLocal WebDriver for parallel test execution

🧹 Centralized keyword management

🔍 Supports common locators: id=, name=, xpath=, and cssSelector

✅ Enables quick test case creation without coding





# 🏁 Getting Started

✅ Prerequisites

Java 11 or later

Maven

TestNG

ChromeDriver (or any other WebDriver)


# Project Structure
project/

├─ src/main/java/

│  └─ keywords/

│       └─ KeywordExecutor.java

│  └─ utils/

│       └─ CSVReader.java

├─ src/test/java/

│  └─ tests/

│       └─ KeywordDrivenTest.java

├─ src/main/resources/

│       └─ loginTest.csv

├─ pom.xml


# ⚡️ Usage

1️⃣ Prepare the .csv test data

Example: src/main/resources/loginTest.csv

Login,OpenBrowser,chrome,

Login,NavigateTo,https://example.com,

Login,Type,id=username,admin

Login,Type,id=password,admin123

Login,Click,id=loginButton,

Login,VerifyText,xpath=//h1,Welcome


2️⃣ Run the Test

Execute via TestNG:

mvn test
