package domain;

import config.JSONUtils;
import config.TradeRequest;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TradeRequestImpl {

   // private String appPath = AppConstant.APP_PATH+File.separator+"properties"+File.separator+"env";

    public TradeRequest loadTradeRequest(String file, String directory) throws FileNotFoundException {
        //String filePath = appPath+File.separator+AppConstant.APP_PATH+File.separator+"data"+File.separator+file;
        return JSONUtils.getDomainInstance(new FileReader(new File("filePath")),TradeRequest.class);
    }

    public TradeRequest loadBatchTradeRequest(String file, String directory){
        return JSONUtils.getDomainInstance("",TradeRequest.class);
    }

    public TradeRequest loadTradeRequestString(String jsonString){
        return JSONUtils.getDomainInstance(jsonString,TradeRequest.class);
    }

    public TradeRequest loadBatchTradeRequestString(String jsonString){
        return JSONUtils.getDomainInstance(jsonString,TradeRequest.class);
    }

    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\ptuptewar\\Repo\\WebTAF\\properties\\env\\qa\\templates\\requests\\validate_trade.json");
        String fileContent = FileUtils.readFileToString(file);
        System.out.println(fileContent);
        TradeRequest request = new TradeRequestImpl().loadTradeRequestString(fileContent);
    }

}
