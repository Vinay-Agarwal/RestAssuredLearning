package apiAuto;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class E2E_Test {

        @Test
        public void basicTest() {
            String userId = "0c2806c0-2650-4274-a22b-6fe461241dad";
            String userName = "hellobhai2";
            String password = "Testrest@123";
            String baseUrl = "https://bookstore.toolsqa.com";

            RestAssured.baseURI = baseUrl;
            RequestSpecification request = RestAssured.given();

            request.header("Content-Type", "application/json");

            Response response = request.body("{ \"userName\":\"" + userName + "\", \"password\":\"" + password + "\"}")
                    .post("/Account/v1/GenerateToken");

            Assert.assertEquals(response.getStatusCode(), 200);

            String jsonString = response.asString();
            Assert.assertTrue(jsonString.contains("token"));
            String token = JsonPath.from(jsonString).get("token");

            response = request.get("/BookStore/v1/Books");
            jsonString = response.asString();

            List<Map<String, String>> books = JsonPath.from(jsonString).get("books");
            String bookId = books.get(0).get("isbn");
            System.out.println(bookId);
        }
}
