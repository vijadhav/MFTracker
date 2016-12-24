package entities;

import java.util.Map;

/**
 * Created by vikas on 12/24/2016.
 */
public class Instrument {

    private String isin;
    private Map<AssetCodeType, String> identifier;
    private String issuer;

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Map<AssetCodeType, String> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Map<AssetCodeType, String> identifier) {
        this.identifier = identifier;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

}
