package entities;

/**
 * Created by vikas on 12/24/2016.
 */
public class PnLInfo {

    private Holding holding;

    private double ltp;

    private double currentValue;

    private double pnlAmount;

    private double pnlPercentage;

    public Holding getHolding() {
        return holding;
    }

    public void setHolding(Holding holding) {
        this.holding = holding;
    }

    public double getLtp() {
        return ltp;
    }

    public void setLtp(double ltp) {
        this.ltp = ltp;
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    public double getPnlAmount() {
        return pnlAmount;
    }

    public void setPnlAmount(double pnlAmount) {
        this.pnlAmount = pnlAmount;
    }

    public double getPnlPercentage() {
        return pnlPercentage;
    }

    public void setPnlPercentage(double pnlPercentage) {
        this.pnlPercentage = pnlPercentage;
    }

    @Override
    public String toString() {
        return "PnLInfo{" +
                "holding=" + holding +
                ", ltp=" + ltp +
                ", currentValue=" + currentValue +
                ", pnlAmount=" + pnlAmount +
                ", pnlPercentage=" + pnlPercentage +
                '}';
    }
}
