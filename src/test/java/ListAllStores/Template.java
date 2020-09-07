package ListAllStores;

import java.util.List;
import java.util.Map;

import static ListAllStores.Requests.getToken;
import static ListAllStores.Requests.listAllStores;

public class Template extends BaseClass{

    public static String testCase (Map<String, Object> params) throws Exception {

        String body = "[" + getToken(requestUrlLogin) + "]";
        String authToken = String.valueOf(getValuesForGivenKey(body, "token"));
        log.info(authToken);
        List<String> responce = listAllStores(requestUrl, authToken, params, 200);
        log.info(String.valueOf(responce));
        return responce.get(1);
    }

    public static String testCaseNegative (Map<String, Object> params) throws Exception {

        String body = "[" + getToken(requestUrlLogin) + "]";
        String authToken = String.valueOf(getValuesForGivenKey(body, "token"));
        log.info(authToken);
        List<String> responce = listAllStores(requestUrl, "454874841548", params, 403);
        log.info(String.valueOf(responce));
        return responce.get(1);
    }
}
