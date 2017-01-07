package engine;

import entities.Instrument;
import entities.PnLInfo;

import java.util.Map;

/**
 * Created by vikas on 1/2/2017.
 */
public class SimpleConsoleBasedPnLInfoRendererImpl implements PnLInfoRenderer {
    @Override
    public void render(Map<Instrument, PnLInfo> pnLInfoMap) {
        System.out.println("P r o f i t   &   L o s s   S t a t e m e n t");
        System.out.println("=============================================");
        System.out.println("Symbol" + "\t" + "Description" + "\t" + "Qty" + "\t" +
                "AvgCost" + "\t" + "InvestedAmt" + "\t" + "LTP" + "\t" + "CurrValue" + "\t" +
                "UnrealProfit/Loss" + "\t" + "PnL%");
        pnLInfoMap.forEach((i, p) -> {
            System.out.println(i.getSymbol() + "\t" +
                    i.getName() + "\t" +
                    p.getHolding().getQty() + "\t" +
                    p.getHolding().getAverageCostPrice() + "\t" +
                    p.getHolding().getValue() + "\t" +
                    p.getLtp() + "\t" +
                    p.getCurrentValue() + "\t" +
                    p.getPnlAmount() + "\t" +
                    p.getPnlPercentage());
        });
    }
}
