package ListAllStores;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Requests {

    static String getToken(String url) {
        String body = "{\n" +
                "  \"login\": \"testlogin123\",\n" +
                "  \"password\": \"testlogin123\"\n" +
                "}";
        Response response = RestAssured.given().body(body).post(url);
        response.then().statusCode(200);
        return response.body().asString();
    }


    static List<String> listAllStores(String url, String token, Map<String, Object> params, int statusCode) {
        Response response = RestAssured.given().log().all().header("Authorization", "Bearer " + token.substring(1, token.length() -1)).queryParams(params).get(url);
        response.then().statusCode(statusCode);
        List<String> results = new ArrayList<>();
        results.add(0, response.body().asString());
        results.add(1, String.valueOf(response.statusCode()));
        return results;
    }
}
