package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vikas on 12/24/2016.
 */
public class Instrument {

    private String isin;
    private String symbol;
    private String name;
    private Map<AssetCodeType, String> identifier = new HashMap<>();
    private String issuer;

    public Instrument(String symbol) {
        this.symbol = symbol;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public Map<AssetCodeType, String> getAllIdentifiers() {
        return identifier;
    }

    public String getIdentifier(AssetCodeType type) {
        return identifier.get(type);
    }

    public void setIdentifier(AssetCodeType type, String value) {
        identifier.put(type, value);
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof Instrument))
            return false;

        if(this.symbol.equalsIgnoreCase(((Instrument) obj).symbol))
            return true;

        return false;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "isin='" + isin + '\'' +
                ", symbol='" + symbol + '\'' +
                ", identifier=" + identifier +
                ", name=" + name +
                ", issuer='" + issuer + '\'' +
                '}';
    }
}
