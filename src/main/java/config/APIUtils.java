package config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.io.IOException;
import java.net.InetAddress;

/**
 * APIUtils class contains utility method to access API
 */
public class APIUtils {

   static {
         RestAssured.baseURI = "http://localhost:12345";
    }

    /**
     * Validate host system is reachable or not
     * @param timeout
     * @return
     */
    public static boolean isIpReachable(int timeout){
        boolean state = false;

        try {
            state = InetAddress.getByName("http://localhost:12345").isReachable(timeout);
        } catch (IOException e) {
            //Parse error here
        }
        return state;
    }


    /**
     * Create Post call
     * @param resquestPayload
     * @param endPoint
     * @return
     */
    public static Response postCall(String resquestPayload, String endPoint){
        return RestAssured.given().relaxedHTTPSValidation()
                .filter(new ResponseLoggingFilter())
                .filter(new RequestLoggingFilter())
                .header("Content-type", "application/json")
                .and()
                .body(resquestPayload)
                .when()
                .post(endPoint)
                .then()
                .extract().response();
    }
}
