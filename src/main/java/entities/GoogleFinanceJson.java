package entities;

/**
 * Created by vikas on 1/2/2017.
 */
public class GoogleFinanceJson {
    // id
    private String id;

    // ticker
    private String t;

    // exchange
    private String e;

    // last_price
    private String l;

    // ?
    private String l_fix;

    // curr price?
    private String l_cur;

    // last trade time
    private String ltt;

    // ?
    private String lt;

    // change
    private double c;

    // change %
    private double cp;

    private double c_fix;

    // change %
    private double cp_fix;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getL_fix() {
        return l_fix;
    }

    public void setL_fix(String l_fix) {
        this.l_fix = l_fix;
    }

    public String getL_cur() {
        return l_cur;
    }

    public void setL_cur(String l_cur) {
        this.l_cur = l_cur;
    }

    public String getLtt() {
        return ltt;
    }

    public void setLtt(String ltt) {
        this.ltt = ltt;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getCp() {
        return cp;
    }

    public void setCp(double cp) {
        this.cp = cp;
    }

    public double getC_fix() {
        return c_fix;
    }

    public void setC_fix(double c_fix) {
        this.c_fix = c_fix;
    }

    public double getCp_fix() {
        return cp_fix;
    }

    public void setCp_fix(double cp_fix) {
        this.cp_fix = cp_fix;
    }

    @Override
    public String toString() {
        return "GoogleFinanceJson{" +
                "id='" + id + '\'' +
                ", t='" + t + '\'' +
                ", e='" + e + '\'' +
                ", l=" + l +
                ", l_fix=" + l_fix +
                ", l_cur=" + l_cur +
                ", ltt='" + ltt + '\'' +
                ", lt='" + lt + '\'' +
                ", c=" + c +
                ", cp=" + cp +
                ", c_fix=" + c_fix +
                ", cp_fix=" + cp_fix +
                '}';
    }
}
