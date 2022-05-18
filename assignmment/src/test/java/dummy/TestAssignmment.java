package assignmment;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.assignmment.assignmmentHelper;
import org.example.assignmment.pojos.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testassignmment {
    assignmmentHelper assignmmentHelper = new assignmmentHelper();

    String name = "AIs";
    String sal = "12000";
    String age = "32";

    int employeeId =10; // we can give input here

    @Test
    public void testCreateEmployee() throws JsonProcessingException {

        CreateEmployeeResponse employee = assignmmentHelper.createEmployee(name, sal, age);
        Assert.assertEquals(employee.getStatus(),"success", "Status is not as expected" );
        EmployeeCreateResponseData data = employee.getData();
        Assert.assertEquals(data.getName(),name, "name is wrong");
        Assert.assertEquals(data.getAge(),age, "age is wrong");
        Assert.assertEquals(data.getSalary(),sal, "sal is wrong");

    }

    @Test
    public void testGetEmployee() throws JsonProcessingException {

        GetEmployeeResponse getEmployeeResponse = assignmmentHelper.getEmployee(employeeId);
        Assert.assertEquals(getEmployeeResponse.getStatus(),"success", "Status is not as expected" );

        GetEmployeeResponseData data = getEmployeeResponse.getData();
        Assert.assertEquals(data.getId(), String.valueOf(employeeId), "This not the id requested");
        Assert.assertEquals(getEmployeeResponse.getStatus(), "success", "status is not same");

    }
    @Test
    public void testDeleteEmployee() throws JsonProcessingException {


        assignmmentResponse assignmmentResponse = assignmmentHelper.deleteEmployee(employeeId);
        Assert.assertEquals(assignmmentResponse.getStatus(),"success", "Status is not as expected" );

        assignmmentResponse.getMessage();
    }

    /**
    @Test
    public void testCreateEmployee() throws JsonProcessingException {

        assignmmentResponse employee = assignmmentHelper.createEmployee(name, sal, age);
        Integer employeeId = employee.getData().getId();

        assignmmentResponse getEmployeeResponse = assignmmentHelper.getEmployee(employeeId);
        Data data = getEmployeeResponse.getData();
        Assert.assertEquals(data.getEmployeeName(),name, "name is wrong");
        Assert.assertEquals(data.getEmployeeAge(),age, "age is wrong");
        Assert.assertEquals(data.getEmployeeSalary(),sal, "sal is wrong");

        assignmmentResponse assignmmentResponse = assignmmentHelper.deleteEmployee(employeeId);
        assignmmentResponse.getMessage();
    }
    **/
}
