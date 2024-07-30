import java.io.Serializable;

public abstract class Shoferi implements Serializable {
    String emri;
    String vendndodhja;
    String ekipi;

    public Shoferi(String emri, String vendndodhja, String ekipi) {
        this.emri = emri;
        this.vendndodhja = vendndodhja;
        this.ekipi = ekipi;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public void setVendndodhja(String vendndodhja) {
        this.vendndodhja = vendndodhja;
    }

    public void setEkipi(String ekipi) {
        this.ekipi = ekipi;
    }

    public String getEmri() {
        return this.emri;
    }

    public String getVendndodhja() {
        return this.vendndodhja;
    }

    public String getEkipi() {
        return this.ekipi;
    }
}
