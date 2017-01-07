package dao;

import com.google.gson.Gson;
import entities.GoogleFinanceJson;
import entities.StockPrice;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by vikas on 1/2/2017.
 */
public class GooglePriceRetrievalServiceImpl implements PriceRetrievalService {

    private static String GOOGLE_FINANCE_URL = "http://finance.google.com/finance/info?client=ig&q=NSE%3A";

    private static char JSON_OBJ_START = '{';

    private static char JSON_OBJ_END = '}';

    @Override
    public StockPrice getQuote(String symbol) {
        String s = symbol.replaceAll("&", "%26");
        String stringBuffer = "";
        try {
            InputStream inputStream = new URL(GOOGLE_FINANCE_URL+s).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            stringBuffer = sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        // System.out.println(sbs);
        String jsonString = stringBuffer.substring(stringBuffer.indexOf(JSON_OBJ_START),
                stringBuffer.lastIndexOf(JSON_OBJ_END) + 1);

        Gson gson = new Gson();
        GoogleFinanceJson json = gson.fromJson(jsonString, GoogleFinanceJson.class);

        StockPrice stockPrice = new StockPrice(symbol);
        stockPrice.setLtp(new Double(json.getL_fix()));
        stockPrice.setChng(new Double(json.getC_fix()));
        stockPrice.setChngPct(new Double(json.getCp_fix()));

        return stockPrice;
    }
}
