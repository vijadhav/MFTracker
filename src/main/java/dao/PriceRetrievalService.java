package dao;

import entities.StockPrice;

/**
 * Created by vikas on 1/2/2017.
 */
public interface PriceRetrievalService {

    StockPrice getQuote(String symbol);
}
