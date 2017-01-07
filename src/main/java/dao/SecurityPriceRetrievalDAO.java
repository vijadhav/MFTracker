package dao;

import entities.Instrument;
import entities.StockPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 12/25/2016.
 */
public interface SecurityPriceRetrievalDAO {
    StockPrice queryPrice(Instrument instrument);
    Map<Instrument, StockPrice> queryPrice(List<Instrument> instruments);
}
