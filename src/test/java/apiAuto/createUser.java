package apiAuto;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class createUser {
    public  static  void main(String[] args){
        RestAssured.baseURI = "https://demoqa.com/Account/v1";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", "hellobhai2");
        requestParams.put("password", "Testrest@123");
        request.header("Content-Type", "application/json");
        request.header("Authorization","JWT 1234");
        request.body(requestParams.toJSONString());

        Response res = request.post("/User");
        Assert.assertEquals(res.statusCode(),201);

        String userId = res.getBody().jsonPath().getString("userID");
        System.out.println(userId);

    }
}
