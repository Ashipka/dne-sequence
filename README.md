## **DNE Sequence Checker**

This is a simple Spring Boot application that provides an endpoint for checking whether an array of integers contains a DNE sequence.

DNE sequence is a subsequence ai, aj, ak, such that i \< j \< k and ai \< ak \< aj

## **Getting Started**

To get started with the application, you can follow these steps:

1.  Clone the repository to your local machine: **git clone https://github.com/Ashipka/dne-sequence.git**
2.  Navigate to the project directory: **cd dne-sequence**
3.  Build the project using Maven: **mvn clean install**
4.  Run the application: **java -jar target/dne-sequence-1.0-SNAPSHOT.jar**  
     

The application should now be running on port 10000.

## **Usage**

To use the application, you can make a **POST** request to the **/server** endpoint with a JSON payload containing an array of integers.

For example, to check if the array **\[1, 2, 3, 4, 5\]** contains a DNE sequence, you can send the following request:

`POST /server HTTP/1.1 Content-Type: application/json {  "seq": [1, 2, 3, 4, 5] }`

The response will be a boolean indicating whether the array contains a DNE sequence.

## **Testing**

To run the unit tests for the application, you can use the following command:

bashCopy code

`mvn test`

This will run all the JUnit tests in the project.

## **Contributing**

If you'd like to contribute to the project, feel free to fork the repository and submit a pull request.
