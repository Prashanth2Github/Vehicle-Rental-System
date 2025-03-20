# Vehicle Rental System

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Folder Structure](#folder-structure)
- [Installation Guide](#installation-guide)
- [Database Setup](#database-setup)
- [Running the Application](#running-the-application)
- [Contributing](#contributing)
- [License](#license)

## Project Overview
The **Vehicle Rental System** is a Java-based application designed to facilitate vehicle rentals. It provides functionalities for user management, vehicle management, rental processing, payments, and location management.

## Features
- User authentication and management
- Vehicle addition, update, and removal
- Rental booking and tracking
- Payment processing
- Location-based vehicle availability
- Invoice generation

## Technologies Used
- **Java (Swing for UI)**
- **Oracle Database (JDBC for connection)**
- **Gradle (Build tool)**
- **GitHub (Version Control)**
- **VSCode (IDE)**


## Installation Guide
1. **Clone the Repository**
   ```sh
   git clone https://github.com/Prashanth2Github/Vehicle-Rental-System.git
   cd Vehicle-Rental-System
   ```
2. **Set Up Java Environment**
   - Ensure **Java JDK 17+** is installed and configured.
   ```sh
   java -version
   ```
3. **Install Oracle Database**
   - Download and install [OracleXE213_Win64](https://www.oracle.com/database/technologies/xe-downloads.html)
   - Configure `ojdbc8.jar` for JDBC.

## Database Setup
1. **Create the Database**
   - Execute the SQL script inside `resources/database.sql` in Oracle SQL Developer.
2. **Update Configuration**
   - Modify `config/config.properties` with your database credentials.

## Running the Application
1. **Build and Run with Gradle**
   ```sh
   gradle build
   gradle run
   ```
2. **Run from VSCode**
   - Open the project in VSCode.
   - Run `Main.java` using the Run option.

## Contributing
Feel free to fork this project, create a feature branch, and submit a pull request.

## License
This project is licensed under the MIT License.
