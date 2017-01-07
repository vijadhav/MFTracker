package entities;

/**
 * Created by vikas on 12/24/2016.
 */
public class Holding {

    private Instrument instrument;

    private long qty;

    private double averageCostPrice;

    private double value;

    private static long LOT_SIZE = 1;

    public Holding() {}

    public Holding(Instrument instrument, long qty, double averageCostPrice) {
        this.instrument = instrument;
        this.qty = qty;
        this.averageCostPrice = averageCostPrice;
        this.value = qty * averageCostPrice;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public long getQty() {
        return qty;
    }

    public void setQty(long qty) {
        this.qty = qty;
    }

    public double getAverageCostPrice() {
        return averageCostPrice;
    }

    public void setAverageCostPrice(double averageCostPrice) {
        this.averageCostPrice = averageCostPrice;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Holding{" +
                "instrument=" + instrument +
                ", qty=" + qty +
                ", averageCostPrice=" + averageCostPrice +
                ", value=" + value +
                '}';
    }
}
