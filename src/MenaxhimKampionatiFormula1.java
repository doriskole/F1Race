
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Locale.Category;

public class MenaxhimKampionatiFormula1 implements Serializable, MenaxhimKampionati {
    private static final long serialVersionUID = 1L;
    String shoferiEmri;
    String shoferiEkipi;
    String shoferiVendndodhja;
    int fstPos;
    int scndPos;
    int trdPos;
    int driverPoints;
    int raceCount;
    private static final Locale defaultFormattingLocale;
    private static final String defaultDateFormat;
    private static final DateTimeFormatter dateFormatter;
    static ArrayList<ShoferiFormula1> ShoferiF1;
    static ArrayList<GaraFormula1> GaraF1;
    static int[] ArrPiket;
    static ArrayList<ShoferiFormula1> raceDrivers;
    static Scanner input;

    static {
        defaultFormattingLocale = Locale.getDefault(Category.FORMAT);
        defaultDateFormat = DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, (FormatStyle)null, IsoChronology.INSTANCE, defaultFormattingLocale);
        dateFormatter = DateTimeFormatter.ofPattern(defaultDateFormat, defaultFormattingLocale);
        ShoferiF1 = new ArrayList();
        GaraF1 = new ArrayList();
        ArrPiket = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        raceDrivers = new ArrayList(10);
        input = new Scanner(System.in);
    }

    public MenaxhimKampionatiFormula1() {
    }

    public void krijoShofer() {
        while(true) {
            try {
                System.out.print("Shkruani emrin e shoferit : ");
                this.shoferiEmri = input.next();
                if (!this.shoferiEmri.matches("[a-z || A-Z ]+")) {
                    System.out.println("Emri s'mund te permbaje numra!");
                    return;
                }

                boolean loop = false;
                Iterator var3 = ShoferiF1.iterator();

                ShoferiFormula1 driver;
                while(var3.hasNext()) {
                    driver = (ShoferiFormula1)var3.next();
                    if (driver.getEmri().equalsIgnoreCase(this.shoferiEmri)) {
                        loop = true;
                        break;
                    }
                }

                if (!loop) {
                    while(true) {
                        System.out.print("Shkruani ekipin e shoferit: ");
                        this.shoferiEkipi = input.next();
                        if (!this.shoferiEkipi.matches("[a-z || A-Z ]+")) {
                            System.out.println("Ekipi s'mund te permbaje numra!");
                            return;
                        }

                        loop = false;
                        var3 = ShoferiF1.iterator();

                        while(var3.hasNext()) {
                            driver = (ShoferiFormula1)var3.next();
                            if (driver.getEkipi().equalsIgnoreCase(this.shoferiEkipi)) {
                                loop = true;
                                break;
                            }
                        }

                        if (!loop) {
                            System.out.print("Shkruani vendndodhjen e shoferit : ");
                            this.shoferiVendndodhja = input.next();
                            if (!this.shoferiVendndodhja.matches("[a-z || A-Z ]+")) {
                                System.out.println("Vendndodhja s'mund te permbaje numra!");
                                return;
                            }

                            System.out.print("Shkruani numrin e vendeve te para:");
                            this.fstPos = input.nextInt();
                            System.out.print("Shkruani numrin e vendeve te dyta : ");
                            this.scndPos = input.nextInt();
                            System.out.print("Shkruani numrin e vendeve te treta : ");
                            this.trdPos = input.nextInt();
                            System.out.print("Shkruani piket totale te shoferit : ");
                            this.driverPoints = input.nextInt();

                            while(true) {
                                System.out.print("Shkruani numrin total te garave te shoferit: ");
                                this.raceCount = input.nextInt();
                                if (this.fstPos + this.scndPos + this.trdPos <= this.raceCount) {
                                    input.nextLine();
                                    ShoferiF1.add(new ShoferiFormula1(this.shoferiEmri, this.shoferiVendndodhja, this.shoferiEkipi, this.fstPos, this.scndPos, this.trdPos, this.driverPoints, this.raceCount));
                                    System.out.println("\n >> Shoferi i ri u shtua me sukses!");
                                    return;
                                }

                                System.out.println(" >>>Numri i garave nuk mund te jete me i vogel se shuma e vendeve te para ,te dyta ,te treta!");
                            }
                        }

                        System.out.println(this.shoferiEkipi + " Ekipi e ka nje shofer!");
                    }
                }

                System.out.println(this.shoferiEmri + " " + "ekziston tashme ne sistem!");
            } catch (Exception var4) {
                System.out.println(" >> Ju lutem vendosni vlera te pranueshme!");
                return;
            }
        }
    }

    public void fshiShofer() {
        Iterator<ShoferiFormula1> itr = ShoferiF1.iterator();

        try {
            System.out.print("Shkruani emrin e shoferit: ");
            String shoferiEmri = input.next();

            while(itr.hasNext()) {
                ShoferiFormula1 Dr1 = (ShoferiFormula1)itr.next();
                if (Dr1.getEmri().equals(shoferiEmri)) {
                    itr.remove();
                    System.out.println(" >>Shoferi u fshi me sukses!");
                    break;
                }
            }
        } catch (Exception var4) {
            System.out.println("Ju lutem vendosni vlere te pranueshme!");
        }

    }

    public void ndryshoShofer() {
        try {
            System.out.print("Shkruani emrin e shoferit: ");
            this.shoferiEmri = input.next();

            for(int i = 0; i < ShoferiF1.size(); ++i) {
                if (((ShoferiFormula1)ShoferiF1.get(i)).getEmri().equalsIgnoreCase(this.shoferiEmri)) {
                    System.out.println("Shkruani emrin e shoferit te ri per skuadren " + ((ShoferiFormula1)ShoferiF1.get(i)).getEkipi() + " : ");
                    String newShoferiEmri = input.next();
                    System.out.print("Shkruani vendndodhjen e shoferit te ri : ");
                    this.shoferiVendndodhja = input.next();
                    System.out.print("Shkruani numrin e vendeve te para : ");
                    this.fstPos = input.nextInt();
                    System.out.print("Shkruani numrin e vendeve te dyta : ");
                    this.scndPos = input.nextInt();
                    System.out.print("Shkruani numrin e vendeve te treta : ");
                    this.trdPos = input.nextInt();
                    System.out.print("Shkruani piket totale te shoferit : ");
                    this.driverPoints = input.nextInt();

                    while(true) {
                        System.out.print("Shkruani numrin total te garave: ");
                        this.raceCount = input.nextInt();
                        if (this.fstPos + this.scndPos + this.trdPos <= this.raceCount) {
                            ((ShoferiFormula1)ShoferiF1.get(i)).setEmri(newShoferiEmri);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setVendndodhja(this.shoferiVendndodhja);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setFstPos(this.fstPos);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setScndPos(this.scndPos);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setTrdPos(this.trdPos);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setDriverPoints(this.driverPoints);
                            ((ShoferiFormula1)ShoferiF1.get(i)).setRaceCount(this.raceCount);
                            System.out.println(" >> Emri i shoferit te ri u perditesua me sukses!");
                            return;
                        }

                        System.out.println(">>Numri i garave nuk mund te jete me i vogel se shuma e vendeve te para ,te dyta ,te treta!");
                    }
                }
            }
        } catch (Exception var3) {
            System.out.println(" >> Shoferi nuk ekziston");
        }

    }

    public void shfaqStatistikat() {
        try {
            System.out.print("Shkruani emrin e shoferit: ");
            String shoferiEmri = input.next();

            for(int i = 0; i <= ShoferiF1.size(); ++i) {
                if (((ShoferiFormula1)ShoferiF1.get(i)).getEmri().equalsIgnoreCase(shoferiEmri)) {
                    System.out.println("\n >> Statistikat e " + shoferiEmri);
                    System.out.println("+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+");
                    System.out.format("| %-20s| %-15s| %-15s| %-12s| %-12s| %-12s| %-15s | %-15s|", "Emri", "Vendndodhja", "Ekipi", "Nr.1st", " Nr. 2nd ", " Nr. 3rd .", "Piket totale", "Garart totale");
                    System.out.println("|====================================================================================================================================|");
                    System.out.println(ShoferiF1.get(i));
                    break;
                }
            }
        } catch (Exception var3) {
            System.out.println(" >>Ky shofer nuk ekziston! ");
        }

    }

    public void shfaqTabelen() {
        int driversCount = 0;
        int carCount = 0;
        if (ShoferiF1.size() == 0) {
            System.out.println(" >> Nuk ka te dhena akoma");
        } else {
            this.renditTabelen();
            System.out.println(" >>Tabela e Formula 1 2023");
            System.out.println("+---------------------+----------------+----------------+-------------+-------------+-------------+-----------------+----------------+");
            System.out.format("| %-20s| %-15s| %-15s| %-12s| %-12s| %-12s| %-15s | %-15s|", "Emri", "Vendndodhja", "Ekipi", "Nr.1st", " Nr. 2nd ", " Nr. 3rd .", "Piket totale", "Garart totale");
            System.out.println("|====================================================================================================================================|");

            for(int i = 0; i < ShoferiF1.size(); ++i) {
                System.out.println(ShoferiF1.get(i));
                ++driversCount;
                ++carCount;
            }

            System.out.println(" | Shofere Total : " + driversCount);
            System.out.println(" | Makina Totale : " + carCount);
        }

    }

    public void renditTabelen() {
        Collections.sort(ShoferiF1, ShoferiFormula1.fstPosComparator);
        Collections.sort(ShoferiF1, ShoferiFormula1.pointsComparator);
    }

    public void shtoGare() {
        while(true) {
            System.out.println("Data e gares : Shkruani garen ne formatin (dd/mm/yy) ");
            String inputDate = input.next();

            LocalDate raceDate;
            try {
                raceDate = LocalDate.parse(inputDate, dateFormatter);
            } catch (DateTimeParseException var5) {
                System.out.println("Date e pasakte: " + inputDate);
                continue;
            }

            for(int i = 0; i < 10; ++i) {
                System.out.print("Shkruani emrin e shoferit ne vendin " + (i + 1) + " : ");
                String shoferiEmri = input.next().toUpperCase();

                for(int j = 0; j < ShoferiF1.size(); ++j) {
                    if (((ShoferiFormula1)ShoferiF1.get(j)).getEmri().equalsIgnoreCase(shoferiEmri)) {
                        if (Arrays.asList(raceDrivers).contains(shoferiEmri)) {
                            raceDrivers.add((ShoferiFormula1)ShoferiF1.get(j));
                        } else {
                            System.out.println(" >> Emri eshte shkruar me pare!");
                            --i;
                        }
                        break;
                    }

                    if (j == ShoferiF1.size() - 1) {
                        System.out.println(" >> Ky shofer nuk ekziston!");
                        --i;
                    }
                }
            }

            this.pointCalc(raceDrivers);
            GaraF1.add(new GaraFormula1(raceDate, raceDrivers));
            System.out.println("\n >> Gara u shtua me sukses!");
            System.out.println(" >> Tabela  e Formula 1 u perditesua me sukses!");
            return;
        }
    }

    public void pointCalc(ArrayList drivers) {
        for(int i = 0; i < 10; ++i) {
            for(int j = 0; j < ShoferiF1.size(); ++j) {
                if (((ShoferiFormula1)ShoferiF1.get(j)).equals(drivers.get(i))) {
                    ((ShoferiFormula1)ShoferiF1.get(j)).setDriverPoints(((ShoferiFormula1)ShoferiF1.get(j)).getDriverPoints() + ArrPiket[i]);
                    ((ShoferiFormula1)ShoferiF1.get(j)).setRaceCount(((ShoferiFormula1)ShoferiF1.get(j)).getRaceCount() + 1);
                    if (i + 1 == 1) {
                        ((ShoferiFormula1)ShoferiF1.get(j)).setFstPos(((ShoferiFormula1)ShoferiF1.get(j)).getFstPos() + 1);
                    } else if (i + 1 == 2) {
                        ((ShoferiFormula1)ShoferiF1.get(j)).setScndPos(((ShoferiFormula1)ShoferiF1.get(j)).getScndPos() + 1);
                    } else if (i + 1 == 3) {
                        ((ShoferiFormula1)ShoferiF1.get(j)).setTrdPos(((ShoferiFormula1)ShoferiF1.get(j)).getTrdPos() + 1);
                    }
                    break;
                }
            }
        }

    }

    public void ruajInfo() {
        this.writeFile(new File("F1DriverData.ser"), ShoferiF1);
        this.writeFile(new File("F1RaceData.ser"), GaraF1);
    }

    public void writeFile(File writer, ArrayList arrList) {
        try {
            FileOutputStream writeData = new FileOutputStream(writer);
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);
            writeStream.writeObject(arrList);
            writeStream.flush();
            writeStream.close();
            System.out.println(" >> " + writer + " File u perditesua!");
        } catch (IOException var5) {
            var5.printStackTrace();
        }

    }

    public void loadInfo() {
        try {
            FileInputStream readData = new FileInputStream("F1DriverData.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            ShoferiF1 = (ArrayList)readStream.readObject();
            readStream.close();
            readData = new FileInputStream("F1RaceData.ser");
            readStream = new ObjectInputStream(readData);
            GaraF1 = (ArrayList)readStream.readObject();
            readStream.close();
            System.out.println("\n >>Te dhenat e meparshme u ngarkuan me sukses!");
        } catch (ClassNotFoundException | IOException var3) {
            var3.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MenaxhimKampionatiFormula1 fcm = new MenaxhimKampionatiFormula1();
        fcm.loadInfo();
        boolean looper = true;

        while(looper) {
            System.out.println("======FORMULA 1======");
            System.out.println("A-Krijo shofer");
            System.out.println("B-Fshi shofer");
            System.out.println("C-Ndrysho shofer");
            System.out.println("D-Shfaq statistikat");
            System.out.println("E-Shfaq tabelen");
            System.out.println("F-Shto Gare ");
            System.out.println("G-Ruaj Info");
            System.out.println("X-Dil nga programi");
            System.out.println("H-Shfaq GUI");
            System.out.print("Shkruani zgjedhjen tuaj: ");
            String option = input.next().toUpperCase();
            System.out.println("***********************************************************************");
            if (option.equals("X")) {
                looper = false;
                fcm.ruajInfo();
            } else {
                fcm.lexoshkr(option);
            }
        }

    }

    void lexoshkr(String option) {
        if (option.equals("A")) {
            this.krijoShofer();
        } else if (option.equals("B")) {
            this.fshiShofer();
        } else if (option.equals("C")) {
            this.ndryshoShofer();
        } else if (option.equals("D")) {
            this.shfaqStatistikat();
        } else if (option.equals("E")) {
            this.shfaqTabelen();
        } else if (option.equals("F")) {
            this.shtoGare();
        } else if (option.equals("G")) {
            this.ruajInfo();
        } else if (option.equals("H")) {
            new GUI();
        } else {
            System.out.println(" >> Zgjedhja juaj nuk eshte e sakte!");
        }

    }
}
