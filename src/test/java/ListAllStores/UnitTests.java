package ListAllStores;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.assertThat;

public class UnitTests extends Template {
    @Test
    public void test1() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("last_store_id", 1);
        params.put("no_total", true);
        params.put("limit", 1);
        params.put("offset", 100);
        params.put("sort", "string");
        String body = testCase(params);
        assertThat(body,(matchesJsonSchemaInClasspath("example1.json")));
    }

    @Test
    public void test2() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("last_store_id", 1);
        params.put("no_total", true);
        params.put("limit", 1);
        params.put("offset", 100);
        params.put("sort", "string");
        params.put("id", Arrays.asList(1, 2, 3));
        String body = testCase(params);
        assertThat(body,(matchesJsonSchemaInClasspath("example1.json")));
    }

    @Test
    public void test3() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("last_store_id", 1);
        params.put("no_total", true);
        params.put("limit", 1);
        params.put("offset", 100);
        params.put("sort", "string");
        params.put("id", Arrays.asList(1, 2, 3));
        params.put("name", Arrays.asList("Имя", "ИмЯ", "имЯ"));
        params.put("address", Arrays.asList("Мира", "Ленина", "Пушкина"));
        params.put("city_name", Arrays.asList("Волгоград", "Москва", "Омск"));
        params.put("store_type_id", Arrays.asList("Магнит", "Пятерочка"));
        String body = testCase(params);
        assertThat(body,(matchesJsonSchemaInClasspath("example1.json")));
    }



    @Test
    public void test4WrongToken() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("last_store_id", 1);
        params.put("no_total", true);
        params.put("limit", 1);
        params.put("offset", 100);
        params.put("sort", "string");
        String statusCode = testCaseNegative(params);
        assertThat(statusCode,containsString("403"));
    }
}
