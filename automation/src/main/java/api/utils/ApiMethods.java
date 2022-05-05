package api.utils;

import java.util.HashMap;
import java.util.Map;

public class ApiMethods {

    public static Map<String, String> getBaseHeaders(String clientId, String contentType, String deviceId,
                                                     String applicationId) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + clientId);
        headers.put("Content-Type", contentType);
        headers.put("deviceId", deviceId);
        headers.put("applicationId", applicationId);
        return headers;
    }

    public static Map<String, String> getBearerHeaders(String authorization, String contentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + authorization);
        headers.put("Content-Type", contentType);
        return headers;
    }

    public static Map<String, String> getContentTypeHeaders(String contentType) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", contentType);
        return headers;
    }
}
