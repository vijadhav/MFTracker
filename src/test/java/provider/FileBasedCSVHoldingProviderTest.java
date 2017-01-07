package provider;

import entities.Holding;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by vikas on 1/7/2017.
 */
public class FileBasedCSVHoldingProviderTest {

    private FileBasedCSVHoldingProvider holdingProvider;

    @Before
    public void init() {
        holdingProvider = new FileBasedCSVHoldingProvider("src/test/resources/eq_portfolio.csv");
    }

    @Test
    public void SampleICICIDirectHoldingsLoaderTest() {

        List<Holding> holdings = holdingProvider.getHoldings();
        holdings.forEach(h -> System.out.println(ToStringBuilder.reflectionToString(h)));
    }

}
