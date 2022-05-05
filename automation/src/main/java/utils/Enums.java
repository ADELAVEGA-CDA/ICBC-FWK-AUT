package utils;

public class Enums {
    public enum DIRECTION {
        DOWN, UP, LEFT, RIGHT;
    }

    public enum StatusCode {
        OK(200),
        CREATED(201),
        MOVED_PERMANENTLY(301),
        SEE_OTHER(303),
        BAD_REQUEST(400),
        UNAUTHORIZED(401),
        FORBIDDEN(403),
        NOT_FOUND(404),
        NOT_ALLOWED(405),
        PROXY_AUTHENTICATION_REQUIRED(407),
        INTERNAL_SERVER(500),
        BAD_GATEWAY(502),
        SERVICE_UNAVAILABLE(503),
        GATEWAY_TIMEOUT(504);

        public int code;

        StatusCode(int code){ this.code = code; }
    }

    public enum XpathAxes {
        XPATH_ANCESTOR("/ancestor::*"),
        XPATH_ANCESTOR_OR_SELF("/ancestor-or-self::*"),
        XPATH_ATTRIBUTE("/attribute::*"),
        XPATH_CHILD("/child::*"),
        XPATH_DESCENDANT("/descendant::*"),
        XPATH_DESCENDANT_OR_SELF("/descendant-or-self::*"),
        XPATH_FOLLOWING("/following::*"),
        XPATH_FOLLOWING_SIBLING("/following-sibling::*"),
        XPATH_NAMESPACE("/namespace"),
        XPATH_PARENT("/parent::*"),
        XPATH_PRECEDING("/preceding::*"),
        XPATH_PRECEDING_SIBLING("/preceding-sibling::*"),
        XPATH_SELF("/self::*");

        public String text;

        XpathAxes(String value) {this.text = value;}
    }
}
