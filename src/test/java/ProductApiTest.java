package fakestoreapi;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductApiTest {

    @Test
    public void testGetProducts() {
        Response response = RestAssured
                .given()
                .when()
                .get("https://fakestoreapi.com/products");

        int statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);

        // OBS! Lokalt borde det ge 200, men på GitHub Actions kan det ge 403
        assertEquals(200, statusCode, "Förväntad statuskod 200 vid lokalt körning");
    }
}