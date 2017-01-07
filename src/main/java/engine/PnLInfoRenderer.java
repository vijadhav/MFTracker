package engine;

import entities.Instrument;
import entities.PnLInfo;

import java.util.Map;

/**
 * Created by vikas on 1/2/2017.
 */
public interface PnLInfoRenderer {

    public void render(Map<Instrument, PnLInfo> pnLInfoMap);
}
