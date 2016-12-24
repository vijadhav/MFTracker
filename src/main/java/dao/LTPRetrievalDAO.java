package dao;

import entities.StockPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 12/25/2016.
 */
public class LTPRetrievalDAO implements SecurityPriceRetrievalDAO {
    @Override
    public StockPrice queryPrice(String secId) {
        return null;
    }

    @Override
    public Map<String, StockPrice> queryPrice(List<String> secIds) {
        return null;
    }
}
