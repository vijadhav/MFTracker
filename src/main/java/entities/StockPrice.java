package entities;

import java.util.List;

/**
 * Created by vikas on 12/25/2016.
 */
public class StockPrice {

    private String symbol;
    private List<String> otherIds;

    private double ltp;
    private double lastClose;
    private double chng;
    private double chngPct;

    private double dayHigh;
    private double dayLow;
    private double yearHigh;
    private double yearLow;

    public StockPrice(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<String> getOtherIds() {
        return otherIds;
    }

    public void setOtherIds(List<String> otherIds) {
        this.otherIds = otherIds;
    }

    public double getLtp() {
        return ltp;
    }

    public void setLtp(double ltp) {
        this.ltp = ltp;
    }

    public double getLastClose() {
        return lastClose;
    }

    public void setLastClose(double lastClose) {
        this.lastClose = lastClose;
    }

    public double getChng() {
        return chng;
    }

    public void setChng(double chng) {
        this.chng = chng;
    }

    public double getChngPct() {
        return chngPct;
    }

    public void setChngPct(double chngPct) {
        this.chngPct = chngPct;
    }

    public double getDayHigh() {
        return dayHigh;
    }

    public void setDayHigh(double dayHigh) {
        this.dayHigh = dayHigh;
    }

    public double getDayLow() {
        return dayLow;
    }

    public void setDayLow(double dayLow) {
        this.dayLow = dayLow;
    }

    public double getYearHigh() {
        return yearHigh;
    }

    public void setYearHigh(double yearHigh) {
        this.yearHigh = yearHigh;
    }

    public double getYearLow() {
        return yearLow;
    }

    public void setYearLow(double yearLow) {
        this.yearLow = yearLow;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "symbol='" + symbol + '\'' +
                ", ltp=" + ltp +
                ", chng=" + chng +
                ", chngPct=" + chngPct +
                '}';
    }
}
