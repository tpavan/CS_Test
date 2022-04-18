package domain.requests.trade;


import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;

public class TradeReqestDTO {

    @SerializedName("amount1")
    private Double mAmount1;
    @SerializedName("amount2")
    private Double mAmount2;
    @SerializedName("ccyPair")
    private String mCcyPair;
    @SerializedName("customer")
    private String mCustomer;
    @SerializedName("direction")
    private String mDirection;
    @SerializedName("legalEntity")
    private String mLegalEntity;
    @SerializedName("rate")
    private Double mRate;
    @SerializedName("tradeDate")
    private String mTradeDate;
    @SerializedName("trader")
    private String mTrader;
    @SerializedName("type")
    private String mType;
    @SerializedName("valueDate")
    private String mValueDate;

    public Double getAmount1() {
        return mAmount1;
    }

    public void setAmount1(Double amount1) {
        mAmount1 = amount1;
    }

    public Double getAmount2() {
        return mAmount2;
    }

    public void setAmount2(Double amount2) {
        mAmount2 = amount2;
    }

    public String getCcyPair() {
        return mCcyPair;
    }

    public void setCcyPair(String ccyPair) {
        mCcyPair = ccyPair;
    }

    public String getCustomer() {
        return mCustomer;
    }

    public void setCustomer(String customer) {
        mCustomer = customer;
    }

    public String getDirection() {
        return mDirection;
    }

    public void setDirection(String direction) {
        mDirection = direction;
    }

    public String getLegalEntity() {
        return mLegalEntity;
    }

    public void setLegalEntity(String legalEntity) {
        mLegalEntity = legalEntity;
    }

    public Double getRate() {
        return mRate;
    }

    public void setRate(Double rate) {
        mRate = rate;
    }

    public String getTradeDate() {
        return mTradeDate;
    }

    public void setTradeDate(String tradeDate) {
        mTradeDate = tradeDate;
    }

    public String getTrader() {
        return mTrader;
    }

    public void setTrader(String trader) {
        mTrader = trader;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getValueDate() {
        return mValueDate;
    }

    public void setValueDate(String valueDate) {
        mValueDate = valueDate;
    }

}
