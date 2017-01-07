package engine;

import entities.Holding;
import entities.HoldingProvider;
import entities.Instrument;
import entities.PnLInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 1/2/2017.
 */
public class PortfolioProcessorImpl implements PortfolioProcessor {

    private PnLCalculator pnLCalculator;

    private List<Holding> holdings;

    private PnLInfoRenderer pnLInfoRenderer;

    @Override
    public void process(HoldingProvider holdingProvider) {
        holdings = holdingProvider.getHoldings();

        Map<Instrument, PnLInfo> pnl = pnLCalculator.calculatePnL(holdings);

        pnLInfoRenderer.render(pnl);
    }

    public PnLCalculator getPnLCalculator() {
        return pnLCalculator;
    }

    public void setPnLCalculator(PnLCalculator pnLCalculator) {
        this.pnLCalculator = pnLCalculator;
    }

    public List<Holding> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<Holding> holdings) {
        this.holdings = holdings;
    }

    public PnLInfoRenderer getPnLInfoRenderer() {
        return pnLInfoRenderer;
    }

    public void setPnLInfoRenderer(PnLInfoRenderer pnLInfoRenderer) {
        this.pnLInfoRenderer = pnLInfoRenderer;
    }
}
