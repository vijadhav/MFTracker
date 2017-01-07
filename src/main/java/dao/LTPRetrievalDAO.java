package dao;

import entities.Instrument;
import entities.StockPrice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 12/25/2016.
 */
public class LTPRetrievalDAO implements SecurityPriceRetrievalDAO {

    private PriceRetrievalService priceRetrievalService;

    public LTPRetrievalDAO(PriceRetrievalService priceRetrievalService) {
        this.priceRetrievalService = priceRetrievalService;
    }

    public LTPRetrievalDAO() {
    }

    @Override
    public StockPrice queryPrice(Instrument instrument) {
        return priceRetrievalService.getQuote(instrument.getSymbol());
    }

    @Override
    public Map<Instrument, StockPrice> queryPrice(List<Instrument> instruments) {
        Map<Instrument, StockPrice> stockPriceMap = new HashMap<>();

        instruments.forEach(i -> {
            stockPriceMap.put(i, priceRetrievalService.getQuote(i.getSymbol()));
        });

        return stockPriceMap;
    }

    public PriceRetrievalService getPriceRetrievalService() {
        return priceRetrievalService;
    }

    public void setPriceRetrievalService(PriceRetrievalService priceRetrievalService) {
        this.priceRetrievalService = priceRetrievalService;
    }
}
