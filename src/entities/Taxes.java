package entities;

public class Taxes {
    private int ISS;
    private int XLP;
    private double SAH;

    public Taxes(int ISS, int XLP) {
        this.ISS = ISS;
        this.XLP = XLP;
    }

    public Taxes() {
        this.ISS = 30;
        this.XLP = 5;
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

    public double getSAH(double price) {
        this.calculateSAH(price);
        return this.SAH;
    }

    private void calculateSAH(double price) {
        if (price <= 50) {
            this.SAH = 5;
            return;
        }else if (price <= 150) {
            this.SAH = 2.5;
            return;
        }else {
            this.SAH = 0;
        }
    }
}
