package dao;

import com.google.gson.Gson;
import entities.GoogleFinanceJson;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by vikas on 1/2/2017.
 */
public class GooglePriceRetrievalServiceImplTest {

    PriceRetrievalService priceRetrievalService = new GooglePriceRetrievalServiceImpl();

    @Test
    public void JSonReaderTest() {
        String jsonString = "{ \"id\": \"675530\" ,\"t\" : \"INFY\" ,\"e\" : \"NSE\" ,\"l\" : \"1,002.00\" ,\"l_fix\" : \"1002.00\" ,\"l_cur\" : \"₹1,002.00\" ,\"s\": \"0\" ,\"ltt\":\"1:01PM GMT+5:30\" ,\"lt\" : \"Jan 2, 1:01PM GMT+5:30\" ,\"lt_dts\" : \"2017-01-02T13:01:38Z\" ,\"c\" : \"-8.60\" ,\"c_fix\" : \"-8.60\" ,\"cp\" : \"-0.85\" ,\"cp_fix\" : \"-0.85\" ,\"ccol\" : \"chr\" ,\"pcls_fix\" : \"1010.6\" }";

        Gson gson = new Gson();
        GoogleFinanceJson json = gson.fromJson(jsonString, GoogleFinanceJson.class);

        System.out.println(json);
    }

    @Test
    public void GetGoogleFinanceQuoteTest() {
        String googleFinanceURL = "http://finance.google.com/finance/info?client=ig&q=NSE%3A";
        String symbol = "INFY";

        try {
            InputStream inputStream = new URL(googleFinanceURL+symbol).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            int cp;
            while( (cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            String sbs = sb.toString();
            System.out.println(sbs);

            String jsonString = sbs.substring(sbs.indexOf('{'), sbs.lastIndexOf('}')+1);

            Gson gson = new Gson();
            GoogleFinanceJson json = gson.fromJson(jsonString, GoogleFinanceJson.class);

            System.out.println(json);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void GoogleFinancePriceRetrievalServiceImplTest() {
        System.out.println( priceRetrievalService.getQuote("INFY") );
        System.out.println( priceRetrievalService.getQuote("TCS") );
    }

}
