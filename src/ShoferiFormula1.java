import java.io.Serializable;
import java.util.Comparator;

public class ShoferiFormula1 extends Shoferi implements Serializable {
    int fstPos;
    int scndPos;
    int trdPos;
    int raceCount;
    int driverPoints;
    public static Comparator<ShoferiFormula1> fstPosComparator = new Comparator<ShoferiFormula1>() {
        public int compare(ShoferiFormula1 d1, ShoferiFormula1 d2) {
            int driver1FstPos = d1.getFstPos();
            int driver2FstPos = d2.getFstPos();
            return driver2FstPos - driver1FstPos;
        }
    };
    public static Comparator<ShoferiFormula1> pointsComparator = new Comparator<ShoferiFormula1>() {
        public int compare(ShoferiFormula1 d1, ShoferiFormula1 d2) {
            int driver1Points = d1.getDriverPoints();
            int driver2Points = d2.getDriverPoints();
            return driver2Points - driver1Points;
        }
    };

    public ShoferiFormula1(String emri, String vendndodhja, String ekipi, int fstPos, int scndPos, int trdPos, int driverPoints, int raceCount) {
        super(emri, vendndodhja, ekipi);
        this.fstPos = fstPos;
        this.scndPos = scndPos;
        this.trdPos = trdPos;
        this.driverPoints = driverPoints;
        this.raceCount = raceCount;
    }

    public void setFstPos(int fstPos) {
        this.fstPos = fstPos;
    }

    public void setScndPos(int scndPos) {
        this.scndPos = scndPos;
    }

    public void setTrdPos(int trdPos) {
        this.trdPos = trdPos;
    }

    public void setDriverPoints(int driverPoints) {
        this.driverPoints = driverPoints;
    }

    public void setRaceCount(int raceCount) {
        this.raceCount = raceCount;
    }

    public int getFstPos() {
        return this.fstPos;
    }

    public int getScndPos() {
        return this.scndPos;
    }

    public int getTrdPos() {
        return this.trdPos;
    }

    public int getDriverPoints() {
        return this.driverPoints;
    }

    public int getRaceCount() {
        return this.raceCount;
    }

    public String toString() {
        return String.format("| %-20s| %-15s| %-15s|%12d |%12d |%12d | %15d |%15d |", this.emri, this.vendndodhja, this.ekipi, this.fstPos, this.scndPos, this.trdPos, this.driverPoints, this.raceCount) + "\n+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+";
    }
}
