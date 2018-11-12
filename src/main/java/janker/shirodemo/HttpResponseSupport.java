package janker.shirodemo;

import net.sf.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author CatalpaFlat
 * @date Created in 2018/4/7 下午7:59
 */
public class HttpResponseSupport {
    private HttpResponseSupport() {
    }

    private static JSONObject responseJson;
    private static JSONObject responseErrorJson;

    static {
        responseJson = new JSONObject();
        responseErrorJson = new JSONObject();
    }

    public static ResponseEntity<Object> success(String msg, String reason) {
        responseJson.put("message", msg);
        responseJson.put("reason", reason);
        return obtainResponseEntity(HttpStatus.OK, responseJson);
    }

    public static ResponseEntity<Object> success(Object obj) {
        return obtainResponseEntity(HttpStatus.OK, obj);
    }

    public static ResponseEntity<Object> error(HttpStatus httpStatus, String msg, Object obj) {
        JSONObject tempJSON = new JSONObject();
        tempJSON.put("type", httpStatus.getReasonPhrase());
        tempJSON.put("message", msg);
        tempJSON.put("reason", obj);
        responseErrorJson.put("error", tempJSON);
        return obtainResponseEntity(httpStatus, responseErrorJson);
    }

    private static ResponseEntity<Object> obtainResponseEntity(HttpStatus httpStatus, Object response) {
        return new ResponseEntity<>(response, httpStatus);
    }
}
