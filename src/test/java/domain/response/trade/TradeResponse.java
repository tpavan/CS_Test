package domain.response.trade;

import io.cucumber.messages.internal.com.google.gson.annotations.SerializedName;

public class TradeResponse {

    @SerializedName("messages")
    private Object mMessages;
    @SerializedName("status")
    private String mStatus;

    public Object getMessages() {
        return mMessages;
    }

    public void setMessages(Object messages) {
        mMessages = messages;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

}
