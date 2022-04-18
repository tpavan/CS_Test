package flows;

import config.APIUtils;
import config.AppConstant;
import io.restassured.response.Response;

import java.util.HashMap;

public class TradeService {

    private static Response response;

    public static Response validateSingleTrade(String requestPayload){
        response =  APIUtils.postCall(requestPayload, AppConstant.validate);
        System.out.println("Response from validate Single Trade : "+ response.prettyPrint());
        return response;
    }

    public static Response validateSingleTrade(HashMap<String, String> dateMap){
        String requestPayload = dateMap.get("RequestBody");
        response =  APIUtils.postCall(requestPayload, AppConstant.validate);
        return response;
    }

    public static Response validateBatchTrade(String requestPayload){
        response =  APIUtils.postCall(requestPayload,AppConstant.validateBatch);
        System.out.println("Response from validate Batch Trade : " +response.prettyPrint());
        return response;
    }
}
