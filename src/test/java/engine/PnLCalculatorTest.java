package engine;

import dao.GooglePriceRetrievalServiceImpl;
import dao.LTPRetrievalDAO;
import dao.SecurityPriceRetrievalDAO;
import entities.Holding;
import entities.Instrument;
import entities.PnLInfo;
import entities.StockPrice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import provider.FileBasedCSVHoldingProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by vikas on 12/24/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class PnLCalculatorTest {

    private PnLCalculator pnLCalculator;

    private List<Holding> holdings;

    @Mock
    private SecurityPriceRetrievalDAO mockSecurityPriceRetrievalDAO;

    @Test
    public void SimpleStockPriceRetrievalMockTest() {

        Instrument googl = new Instrument("GOOGL");
        Instrument appl  = new Instrument("APPL");

        StockPrice googl_price = new StockPrice("GOOGL"); googl_price.setLtp(400.0);
        StockPrice appl_price  = new StockPrice("APPL"); appl_price.setLtp(300.0);

        holdings = new ArrayList<>();

        Holding h1 = new Holding(googl, 1000, 200.0);
        Holding h2 = new Holding(appl,  500,  50.0);

        holdings.add(h1); holdings.add(h2);

        when(mockSecurityPriceRetrievalDAO.queryPrice(googl)).thenReturn(googl_price);
        when(mockSecurityPriceRetrievalDAO.queryPrice(appl)).thenReturn(appl_price);
        pnLCalculator = new PnLCalculatorImpl(mockSecurityPriceRetrievalDAO);

        System.out.println(mockSecurityPriceRetrievalDAO.queryPrice(new Instrument("GOOGL")).getLtp());
        System.out.println(mockSecurityPriceRetrievalDAO.queryPrice(new Instrument("APPL")).getLtp());
        Map<Instrument, PnLInfo> pnl = pnLCalculator.calculatePnL(holdings);
        pnl.forEach((i, p) -> System.out.println(i + " ==> " + p));
    }

    @Test
    public void SimpleEQPortFolioPnLCalculationTest() {
        SecurityPriceRetrievalDAO securityPriceRetrievalDAO =
                new LTPRetrievalDAO(new GooglePriceRetrievalServiceImpl());

        holdings = (new FileBasedCSVHoldingProvider("src/test/resources/eq_portfolio.csv")).getHoldings();
        pnLCalculator = new PnLCalculatorImpl(securityPriceRetrievalDAO);

        Map<Instrument, PnLInfo> pnl = pnLCalculator.calculatePnL(holdings);
        System.out.println("Symbol,Qty,Price,Amt,LTP,Value,PnL,PnL%");
        pnl.forEach((i, p) -> {
            System.out.println(i.getSymbol() + "," +
                    p.getHolding().getQty() + "," +
                    p.getHolding().getAverageCostPrice() + "," +
                    p.getHolding().getValue() + "," +
                    p.getLtp() + "," +
                    p.getCurrentValue() + "," +
                    p.getPnlAmount() + "," +
                    p.getPnlPercentage());
        });
    }
}
