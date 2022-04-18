package config;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * JSONUtils class contains all utility methods for JSON CRUD operations
 */
public class JSONUtils {

    /**
     * Method returns JSON Array
     * @param JSONString
     * @param SJONPath
     */
    public static void getJsonArray(String JSONString,String SJONPath){

    }

    /**
     * Method returns JSON Oject for provided String
     * @param JSONString
     * @param SJONPath
     */
    public static void getJsonObject(String JSONString,String SJONPath){

    }

    /**
     * Method returns String for provided JSON path
     * @param JSONString
     * @param SJONPath
     */
    public static void getJsonInString(String JSONString,String SJONPath){

    }

    /**
     * Return Class instance for provided <T> for serialized JSON String
     * @param JSONString
     * @param ClassObj
     * @param <T>
     * @return
     */
    public static <T> T getDomainInstance(String JSONString,Class<T> ClassObj){
        return new Gson().fromJson(JSONString, ClassObj);
    }

    /**
     * Return Class instance for provided <T> for serialized JSON String
     * @param JSONReader
     * @param ClassObj
     * @param <T>
     * @return
     */
    public static <T> T getDomainInstance(Reader JSONReader, Class<T> ClassObj){
        return new Gson().fromJson(JSONReader, ClassObj);
    }

    public static void main(String[] args) throws IOException {
       String fileContnet = FileUtils.readFileToString(new File("C:\\Users\\ptuptewar\\Repo\\WebTAF\\properties\\env\\qa\\templates\\requests\\validate_trade.json"));
        TradeRequest tradeRequest = getDomainInstance(fileContnet,TradeRequest.class);
    }
}
