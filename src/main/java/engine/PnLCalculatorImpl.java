package engine;

import entities.Holding;
import entities.Instrument;
import entities.PnLInfo;
import rates.PriceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by vikas on 12/24/2016.
 */
public class PnLCalculatorImpl implements PnLCalculator {

    private PriceProvider priceProvider;

    @Override
    public Map<Instrument, PnLInfo> calculatePnL(List<Holding> holdings) {

        Map<Instrument, PnLInfo> pnl = new HashMap<>();
        holdings.forEach(h -> {
            PnLInfo p = new PnLInfo();
            p.setHolding(h);
            p.setLtp(priceProvider.getPrice(h.getInstrument()));
            p.setCurrentValue(p.getLtp() * h.getQty());
            calculatePercentage(p);
            pnl.put(h.getInstrument(), p);
        });

        return pnl;
    }

    private void calculatePercentage(PnLInfo p) {
        double diff = p.getCurrentValue() - p.getHolding().getValue();
        double pct = abs(diff) / p.getHolding().getValue() * 100;

        if(p.getCurrentValue() > p.getHolding().getValue())
            pct *= -1;

        p.setPnlAmount(diff);
        p.setPnlPercentage(pct);
    }

    public PriceProvider getPriceProvider() {
        return priceProvider;
    }

    public void setPriceProvider(PriceProvider priceProvider) {
        this.priceProvider = priceProvider;
    }
}
