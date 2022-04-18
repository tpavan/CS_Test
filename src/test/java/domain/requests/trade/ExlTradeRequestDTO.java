package domain.requests.trade;

import java.util.HashMap;

public class ExlTradeRequestDTO {
    private static String TC_ID;
    private static String Step;
    private static String TC_Name;
    private static String Description;
    private static String RequestBody;
    private static String Validations;
    private static String StatusCode;

    public static String getStatusCode() {
        return StatusCode;
    }

    public static void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }

    public String getTC_ID() {
        return TC_ID;
    }

    public void setTC_ID(String TC_ID) {
        this.TC_ID = TC_ID;
    }

    public String getStep() {
        return Step;
    }

    public void setStep(String step) {
        Step = step;
    }

    public String getTC_Name() {
        return TC_Name;
    }

    public void setTC_Name(String TC_Name) {
        this.TC_Name = TC_Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getRequestBody() {
        return RequestBody;
    }

    public void setRequestBody(String requestBody) {
        RequestBody = requestBody;
    }

    public String getValidations() {
        return Validations;
    }

    public void setValidations(String validations) {
        Validations = validations;
    }

    public static ExlTradeRequestDTO ExlTradeRequestDTO(HashMap<String,String> datMap){
        ExlTradeRequestDTO dto = new ExlTradeRequestDTO();
        TC_ID = datMap.get("TC_ID");
        Step = datMap.get("Step");
        TC_Name = datMap.get("TC_Name");
        Description = datMap.get("Description");
        RequestBody = datMap.get("RequestBody");
        Validations = datMap.get("Validations");
        StatusCode = datMap.get("StatusCode");
        return dto;
    }


}
