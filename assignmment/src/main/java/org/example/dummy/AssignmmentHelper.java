package org.example.assignmment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.assignmment.pojos.CreateEmployeeResponse;
import org.example.assignmment.pojos.assignmmentRequest;
import org.example.assignmment.pojos.assignmmentResponse;
import org.example.assignmment.pojos.GetEmployeeResponse;

public class assignmmentHelper {
    public static String baseUrl = "http://assignmment.restapiexample.com/";
    String pathParam;
    String finalUrl;

    public GetEmployeeResponse getEmployee(int id) throws JsonProcessingException {
        pathParam = "api/v1/employee/";
        finalUrl = baseUrl+pathParam+id;
        System.out.println("hitting url: "+ finalUrl);

        Response response = RestAssured.get(finalUrl);
        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+ statusCode);
        ObjectMapper objectMapper = new ObjectMapper();
        GetEmployeeResponse getEmployeeResponse = objectMapper.readValue(response.prettyPrint(), GetEmployeeResponse.class);
        return getEmployeeResponse;

    }
    public CreateEmployeeResponse createEmployee(String name, String sal, String age) throws JsonProcessingException {
        pathParam = "api/v1/create";
        finalUrl = baseUrl+pathParam;

        assignmmentRequest assignmmentRequest = new assignmmentRequest();
        assignmmentRequest.setAge(age);
        assignmmentRequest.setName(name);
        assignmmentRequest.setSalary(sal);
        System.out.println("hitting url: "+ finalUrl);

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(assignmmentRequest)
                .post(finalUrl);
        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+ statusCode);

        ObjectMapper objectMapper = new ObjectMapper();
        CreateEmployeeResponse createEmployeeResponse = objectMapper.readValue(response.prettyPrint(), CreateEmployeeResponse.class);
        return createEmployeeResponse;

    }

    public assignmmentResponse deleteEmployee(int id) throws JsonProcessingException {
        pathParam = "delete/";
        finalUrl = baseUrl+pathParam+id;
        System.out.println("hitting url: "+ finalUrl);

        Response response = RestAssured.get(finalUrl);
        int statusCode = response.getStatusCode();
        System.out.println("status code is : "+ statusCode);
        ObjectMapper objectMapper = new ObjectMapper();
        assignmmentResponse assignmmentResponse = objectMapper.readValue(response.prettyPrint(), assignmmentResponse.class);
        return assignmmentResponse;

    }

}
