package rates;

import entities.Instrument;

/**
 * Created by vikas on 12/24/2016.
 */
public interface PriceProvider {
    double getPrice(Instrument i);
}
