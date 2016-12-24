package dao;

import entities.StockPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 12/25/2016.
 */
public interface SecurityPriceRetrievalDAO {
    StockPrice queryPrice(String secId);
    Map<String, StockPrice> queryPrice(List<String> secIds);
}
