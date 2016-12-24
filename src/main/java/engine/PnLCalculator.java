package engine;

import entities.Holding;
import entities.Instrument;
import entities.PnLInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by vikas on 12/24/2016.
 */
public interface PnLCalculator {

    Map<Instrument, PnLInfo> calculatePnL(List<Holding> holdings);
}
