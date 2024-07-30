import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class GaraFormula1 implements Serializable {
    LocalDate date;
    ArrayList<ShoferiFormula1> raceDrivers = new ArrayList(10);

    public GaraFormula1(LocalDate date, ArrayList raceDrivers) {
        this.date = date;
        this.raceDrivers = raceDrivers;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDriverPositions(ArrayList raceDrivers) {
        this.raceDrivers = raceDrivers;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public ArrayList<ShoferiFormula1> getDriverPositions() {
        return this.raceDrivers;
    }
}
