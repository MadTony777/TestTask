package ListAllStores;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseClass {
    static String requestUrl = "https://dairy.intrtl.tech/api/v1/stores/?limit=100";
    static String requestUrlLogin = "https://dairy.intrtl.tech/api/v1/auth/login";
    public static Logger log = LoggerFactory.getLogger(UnitTests.class);
    public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((JSONObject) jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }
}


