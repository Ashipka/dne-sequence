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

For example:

$ curl -X POST http://localhost:10000/server -H  
"content-type:application/json" -d '{"seq":\[1,2,3\]}'  
// Result: false

$ curl -X POST http://localhost:10000/server -H  
"content-type:application/json" -d '{"seq":\[1,3,2\]}'  
// Result: true

## **Testing**

To run the unit tests for the application, you can use the following command:

bashCopy code

`mvn test`

This will run all the JUnit tests in the project.

## **Efficiency**

The space complexity of this algorithm is O(n) and the time complexity is also O(n).

## **Contributing**

If you'd like to contribute to the project, feel free to fork the repository and submit a pull request.
