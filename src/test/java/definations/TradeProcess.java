package definations;

import config.AppConstant;
import config.DateUtil;
import config.ExcelParser;
import flows.TradeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;

public class TradeProcess {

    private Response response;

    @Given("^trade service is up and running")
    public void trade_service_is_up_and_running()  throws Exception{
        //TODO
        // Write code to validate service health check
    }

    @When("create single trade request")
    public void create_single_trade_request() throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Test_Data");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @When("create single trade request for value date {string}")
    public void create_single_trade_request_value_date(String tradeType) throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Scenario_1");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        String requestPayload = testDataSheet.get("RequestBody");
        requestPayload = requestPayload.replace("$valueDate", DateUtil.getPastDate(10));
        requestPayload = requestPayload.replace("$tradeDate", DateUtil.getFutureDate(10));
        requestPayload = requestPayload.replace("$type", tradeType);
        testDataSheet.put("RequestBody",requestPayload);
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @When("create single trade request for value date {string} with {string}")
    public void create_single_trade_request_value_date(String tradeType,String currency) throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Scenario_3");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        String requestPayload = testDataSheet.get("RequestBody");
        requestPayload = requestPayload.replace("$valueDate", DateUtil.getPastDate(10));
        requestPayload = requestPayload.replace("$tradeDate", DateUtil.getFutureDate(10));
        requestPayload = requestPayload.replace("$ccyPair", currency);
        requestPayload = requestPayload.replace("$type", tradeType);
        testDataSheet.put("RequestBody",requestPayload);
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @When("create single trade request for weekend with value date {string}")
    public void create_single_trade_request_value_date_weekend(String tradeType) throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Scenario_2");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        String requestPayload = testDataSheet.get("RequestBody");
        requestPayload = requestPayload.replace("$valueDate", DateUtil.getUpcomingWeekendDate());
        requestPayload = requestPayload.replace("$tradeDate", DateUtil.getFutureDate(1));
        requestPayload = requestPayload.replace("$type", tradeType);
        testDataSheet.put("RequestBody",requestPayload);
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @When("create single trade request for weekend with value date {string} and legal entity {string}")
    public void create_single_trade_request_value_date_weekend_with_entity(String tradeType,String entity) throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Scenario_3");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        String requestPayload = testDataSheet.get("RequestBody");
        requestPayload = requestPayload.replace("$valueDate", DateUtil.getPastDate(10));
        requestPayload = requestPayload.replace("$tradeDate", DateUtil.getFutureDate(10));
        requestPayload = requestPayload.replace("$type", tradeType);
        requestPayload = requestPayload.replace("$legalEntity", entity);
        testDataSheet.put("RequestBody",requestPayload);
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @When("create batch trade request for {string}")
    public void create_batch_trade_request(String tradeType) throws IOException {
        ExcelParser ep = new ExcelParser("Trade_Data.xlsx", "bookTrade","Scenario_6");
        HashMap<String, String> testDataSheet =  ep.readTestData();
        String requestPayload = testDataSheet.get("RequestBody");
        requestPayload = requestPayload.replace("$valueDate", DateUtil.getPastDate(10));
        requestPayload = requestPayload.replace("$tradeDate", DateUtil.getFutureDate(10));
        requestPayload = requestPayload.replace("$type", tradeType);
        testDataSheet.put("RequestBody",requestPayload);
        response = TradeService.validateSingleTrade(testDataSheet);
    }

    @Then("^validate single trade request response")
    public void validate_single_trade_request_response(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
    }

    @Then("validate batch trade request response")
    public void validate_batch_trade_request_response(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
    }

    @Then("validate value date cannot be before trade date")
    public void validate_value_date_cannot_be_before_trade_date(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getBody().jsonPath().get("status").equals("ERROR"));
        Assert.assertTrue("Validation missing for Value date and Trade date ", response.getBody().jsonPath().get("messages").toString().contains("null"));
    }

    @Then("value date cannot fall on weekend")
    public void value_date_cannot_fall_on_weekend(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Validation failed for weekend value date", response.getBody().jsonPath().get("messages").toString().contains("Saturday/Sunday"));
    }

    @Then("validate legal entity is {string}")
    public void value_leagal_Enity_in_trade(String leagEntity){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Validation missing for leagal entity", !response.getBody().jsonPath().get("messages").toString().contains("SUCCESS"));
    }
    @Then("service validation for incorrect currency")
    public void value_leagal_Enity_in_trade(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Invalid currency pair is used in request", JsonPath.from(response.prettyPrint()).get("$.").toString().contains("Invalid"));
    }

    @Then("only one legal entity is used {string}")
    public void only_one_legal_entity_is_used(String string){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
    }

    @Then("validate trade style as {string}")
    public void check_trade_style_as(String string){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
    }

    @Then("validate expiryDate and premium date shall be before deliveryDate")
    public void validateExpiryDateAndPremiumDate(){
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
        Assert.assertTrue("Trade request failed", response.getStatusCode() == AppConstant.OK_STATUS_CODE);
    }
}
