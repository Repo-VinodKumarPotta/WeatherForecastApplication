# WeatherForecastApplication
The purpose of this Microservice is to fetch weather forecast for next 5 days from OpenWeather API.

## Built With

1. IntelliJ IDEA (2019.3)
2. Spring Boot (2.4.6)
3. Java 8 
4. Maven (3.6.3)
5. Junit 
6. Mockito

## Getting Started

Please follow below steps to import and run the project. 

1. Open IntelliJ IDEA
2. Goto VCS and click on "Get from Version Control" 
3. Select Git and enter Git master repository URL (https://github.com/Repo-VinodKumarPotta/WeatherForecastApplication.git)
4. Goto terminal and run "mvn clean install package -U"
5. Once the build is successful then navigate to target folder and run below command 

    java -jar weatherforecast-0.0.1-SNAPSHOT.jar

## Usage

Once application is started successfully. Please use swagger-ui (http://<hostname>:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/) to access API methods. 

I have also uploaded postman collection for your reference. 

Weather forecast data will be retrieved,
1. Zip Code + Country Code
2. Zip Code alone

## Contact

Vinod Kumar Potta

vinodkumar.potta@outlook.com

Project Link: https://github.com/Repo-VinodKumarPotta/WeatherForecastApplication.git

Branch Name: master 
