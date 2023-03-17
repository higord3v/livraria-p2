package entities;

public class Taxes {
    private int ISS;
    private int XLP;

    public Taxes(int ISS, int XLP) {
        this.ISS = ISS;
        this.XLP = XLP;
    }

    public int getISS() {
        return ISS;
    }

    public void setISS(int ISS) {
        this.ISS = ISS;
    }

    public int getXLP() {
        return XLP;
    }

    public void setXLP(int XLP) {
        this.XLP = XLP;
    }
}
