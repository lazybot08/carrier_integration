# Carrier Integration System

This project is a Carrier Integration System designed to manage shipments, tracking, and quotes for a logistics company. It provides APIs for creating shipments, tracking their status, and obtaining quotes.

## Features:

- **Get All Shipments:** Retrieves all existing shipments stored in the system.
- **Create Shipment:** Allows users to create new shipments with detailed information including sender, recipient, origin, destination, weight, and package type.
- **Update Shipment:** Updates existing shipment details such as sender, recipient, origin, destination, weight, and package type.

- **Get All Trackings:** Retrieves all tracking information for shipments available in the system.
- **Get Tracking By ID:** Retrieves tracking information for a specific shipment identified by its ID.
- **Update Tracking By ID:** Updates tracking information for a specific shipment identified by its ID.

- **Get All Quotes:** Retrieves all available quotes for shipments based on origin, destination, weight, and package type.
- **Add Quote:** To add new quotes for shipments in the system.

## Technologies Used

- Java
- Spring Boot
- Spring Data MongoDB
- MongoDB (or any other supported database)
- RESTful APIs

## Setup Instructions:

- JDK 8 or higher installed on your system
- Maven installed on your system
- MongoDB or any other supported database installed and running

## Steps to Run:

1. Clone the repository to your local machine:

    ```bash
    git clone https://github.com/lazybot08/carrier_integration.git
    ```

2. Navigate to the project directory:

    ```bash
    cd carrier-integration-system
    ```

3. Update the `application.properties` file in the `src/main/resources` directory with your MongoDB configurations.

4. Build and run the project using Maven:

    ```bash
    mvn clean spring-boot:run
    ```

5. Access the APIs using a REST client or browser at the following base URL:

    [http://localhost:8080/](http://localhost:8080/)

## API Documentation

The API documentation for each endpoint can be found in the respective controller classes. Detailed usage examples and request/response formats are provided within the documentation.

[Documentation (with pictures)](https://drive.google.com/drive/folders/1rAV5BU6ohceq57m4txR5GRBShxfKY8Fx?usp=sharing)
