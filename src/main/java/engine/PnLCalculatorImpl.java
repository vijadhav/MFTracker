package engine;

import dao.SecurityPriceRetrievalDAO;
import entities.Holding;
import entities.Instrument;
import entities.PnLInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Math.abs;

/**
 * Created by vikas on 12/24/2016.
 */
public class PnLCalculatorImpl implements PnLCalculator {

    private SecurityPriceRetrievalDAO securityPriceRetrievalDAO;

    public PnLCalculatorImpl() {
    }

    public PnLCalculatorImpl(SecurityPriceRetrievalDAO securityPriceRetrievalDAO) {
        this.securityPriceRetrievalDAO = securityPriceRetrievalDAO;
    }

    @Override
    public Map<Instrument, PnLInfo> calculatePnL(List<Holding> holdings) {

        Map<Instrument, PnLInfo> pnl = new HashMap<>();
        holdings.forEach(h -> {
            PnLInfo p = new PnLInfo();
            p.setHolding(h);
            p.setLtp((securityPriceRetrievalDAO.queryPrice(
                    h.getInstrument()).getLtp()));
            p.setCurrentValue(p.getLtp() * h.getQty());
            calculatePercentage(p);
            pnl.put(h.getInstrument(), p);
        });

        return pnl;
    }

    private void calculatePercentage(PnLInfo p) {
        double diff = p.getCurrentValue() - p.getHolding().getValue();
        double pct = (abs(diff) / p.getHolding().getValue()) * 100;

        if(p.getCurrentValue() < p.getHolding().getValue())
            pct *= -1;

        p.setPnlAmount(diff);
        p.setPnlPercentage(pct);
    }

    public SecurityPriceRetrievalDAO getSecurityPriceRetrievalDAO() {
        return securityPriceRetrievalDAO;
    }

    public void setSecurityPriceRetrievalDAO(SecurityPriceRetrievalDAO securityPriceRetrievalDAO) {
        this.securityPriceRetrievalDAO = securityPriceRetrievalDAO;
    }
}
