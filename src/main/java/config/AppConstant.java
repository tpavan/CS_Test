package config;

import io.cucumber.java.sl.In;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;

public class AppConstant {

    public static String APP_ENV;
    public static String Test_User="ADMIN";
    public static final String APP_PATH = System.getProperty("user.dir");

    /**
     * API EndPoint Constants
     */
    public static String validate = "/validate";
    public static String validateBatch = "/validateBatch";

    /**
     * Response Constants
     */
    public static Integer OK_STATUS_CODE = 200;
    public static Integer CREATED_STATUS_CODE =201;
    public static Integer BAD_REQEST_STATUS_CODE=400;

    static {
        if(Objects.nonNull(APP_ENV = System.getProperty("env"))){
            if(!System.getProperty("env").isEmpty()){
                APP_ENV = System.getProperty("env");
           }else{
                APP_ENV = "qa";
            }
        }else{
            APP_ENV = "qa";
        }
    }

    enum Environment {
        QA,
        INT,
        PROD;
    }
}
