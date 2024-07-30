import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class GUI implements ActionListener {
    JPanel topPanel;
    JPanel leftPanel;
    JPanel midPanel;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel searchPanel;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    JLabel label9;
    JLabel label10;
    JLabel label11;
    JLabel label12;
    JLabel label13;
    JLabel label14;
    JLabel label15;
    JLabel label16;
    JLabel label17;
    JLabel label18;
    JLabel label19;
    JButton searchButton;
    JButton pointsAscButton;
    JButton fposDscButton;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JTextField searchField;
    JTextField locationField;
    JTable driverTable;
    JTable completedRaceTable;
    JTable newRaceTable;
    JTable allRaceTable;
    JTable driverSearchTable;
    JScrollPane scrollPane1;
    JScrollPane scrollPane2;
    JScrollPane scrollPane3;
    JScrollPane scrollPane4;
    JScrollPane scrollPane5;
    JLayeredPane layeredPane;
    LocalDate randomRaceDate;
    ArrayList<ShoferiFormula1> raceDriversData = new ArrayList(10);
    ArrayList<ShoferiFormula1> finalPositions = new ArrayList(10);
    MenaxhimKampionatiFormula1 fcm = new MenaxhimKampionatiFormula1();

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        Border border = BorderFactory.createLineBorder(Color.black, 5);
        this.textFields();
        this.buttons();
        this.labels();
        this.driverTable();
        this.panels();
        JFrame frame = new JFrame();
        frame.setTitle("Menaxhimi i Kampionatit Formula1");
        frame.setDefaultCloseOperation(3);
        frame.getRootPane().setBorder(border);
        frame.setSize(1200, 700);
        frame.getContentPane().setBackground(Color.gray);
        frame.setVisible(true);
        frame.add(this.leftPanel, "West");
        frame.add(this.topPanel, "North");
        frame.add(this.midPanel, "Center");
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void textFields() {
        this.searchField = new JTextField();
        this.searchField.setBounds(20, 60, 280, 30);
        this.locationField = new JTextField();
        this.locationField.setBounds(40, 40, 200, 30);
    }

    public void labels() {
        this.label1 = new JLabel();
        this.label1.setText("Menaxhimi i Kampionatit FORMULA 1");
        this.label1.setBounds(15, 10, 1100, 150);
        this.label1.setFont(new Font("Times New Roman", 1, 40));
        this.label1.setHorizontalAlignment(0);
        this.label1.setForeground(Color.BLACK);
        this.label2 = new JLabel();
        this.label2.setText(">> Statistikat per shoferet <<");
        this.label2.setBounds(241, 20, 500, 50);
        this.label2.setFont(new Font("Arimo", 0, 30));
        this.label2.setForeground(Color.orange);
        this.label3 = new JLabel();
        this.label3.setText(">> Gara rastesore <<");
        this.label3.setBounds(250, 20, 500, 50);
        this.label3.setFont(new Font("Arimo", 0, 30));
        this.label3.setForeground(Color.orange);
        this.label4 = new JLabel();
        this.label4.setText(">> Shto gare <<");
        this.label4.setBounds(340, 20, 500, 50);
        this.label4.setFont(new Font("Arimo", 0, 30));
        this.label4.setForeground(Color.orange);
        this.label5 = new JLabel();
        this.label5.setText(">> Garat e perfunduara <<");
        this.label5.setBounds(300, 20, 500, 50);
        this.label5.setFont(new Font("Arimo", 0, 30));
        this.label5.setForeground(Color.orange);
        this.label7 = new JLabel();
        this.label7.setText("Vendndodhja");
        this.label7.setBounds(40, 15, 100, 20);
        this.label7.setFont(new Font("Poppins", 1, 15));
        this.label7.setForeground(Color.gray);
        this.label9 = new JLabel();
        this.label9.setBorder(BorderFactory.createLineBorder(new Color(135, 59, 75)));
        this.label9.setBounds(40, 100, 860, 100);
        this.label9.add(this.label7);
        this.label9.add(this.locationField);
        this.label17 = new JLabel();
        this.label17.setText(">> Statistikat e shoferit <<");
        this.label17.setBounds(300, 20, 500, 50);
        this.label17.setFont(new Font("Arimo", 0, 30));
        this.label17.setForeground(Color.BLUE);
        this.label18 = new JLabel();
        this.label18.setText(" ~ Vendosni cfare doni te kerkoni! ~ ");
        this.label18.setBounds(250, 250, 500, 50);
        this.label18.setFont(new Font("Arimo", 0, 30));
        this.label18.setForeground(Color.WHITE);
        this.label19 = new JLabel();
        this.label19.setText("~ Ky shofer nuk ekziston! ~");
        this.label19.setBounds(300, 250, 500, 50);
        this.label19.setFont(new Font("Arimo", 0, 30));
        this.label19.setForeground(Color.WHITE);
    }

    public void buttons() {
        this.searchButton = new JButton("Kerko");
        this.searchButton.setBounds(35, 100, 150, 30);
        this.searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.switchPanels(GUI.this.searchPanel);
                if (!GUI.this.searchField.getText().isEmpty()) {
                    for(int i = 0; i < MenaxhimKampionatiFormula1.ShoferiF1.size(); ++i) {
                        if (((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getEmri().equalsIgnoreCase(GUI.this.searchField.getText())) {
                            GUI.this.driverSearch(i);
                            GUI.this.searchPanel.removeAll();
                            GUI.this.searchPanel.add(GUI.this.label17);
                            GUI.this.searchPanel.add(GUI.this.label16);
                            GUI.this.searchPanel.add(GUI.this.scrollPane4);
                            GUI.this.searchPanel.repaint();
                            GUI.this.searchPanel.revalidate();
                            break;
                        }

                        if (i == MenaxhimKampionatiFormula1.ShoferiF1.size() - 1) {
                            GUI.this.searchPanel.removeAll();
                            GUI.this.searchPanel.add(GUI.this.label17);
                            GUI.this.searchPanel.add(GUI.this.label19);
                            GUI.this.searchPanel.repaint();
                            GUI.this.searchPanel.revalidate();
                        }
                    }
                } else {
                    GUI.this.searchPanel.removeAll();
                    GUI.this.searchPanel.add(GUI.this.label17);
                    GUI.this.searchPanel.add(GUI.this.label18);
                    GUI.this.searchPanel.repaint();
                    GUI.this.searchPanel.revalidate();
                }

            }
        });
        this.button1 = new JButton("Statistikat e shoferit");
        this.button1.setBounds(20, 200, 280, 40);
        this.button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.panel1.remove(GUI.this.scrollPane1);
                GUI.this.switchPanels(GUI.this.panel1);
                GUI.this.fcm.loadInfo();
                GUI.this.driverTable();
                GUI.this.panel1.add(GUI.this.scrollPane1);
            }
        });
        this.pointsAscButton = new JButton("Duke u ngritur : Piket");
        this.pointsAscButton.setBounds(40, 120, 200, 30);
        this.pointsAscButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.tableSorter(GUI.this.driverTable, 6, "A");
            }
        });
        this.fposDscButton = new JButton("Duke zbritur : Pozicionet e para");
        this.fposDscButton.setBounds(250, 120, 200, 30);
        this.fposDscButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.tableSorter(GUI.this.driverTable, 3, "D");
            }
        });
        this.button5 = new JButton("Tabela e perditesuar");
        this.button5.setBounds(600, 120, 225, 30);
        this.button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.driverTable();
                GUI.this.panel1.add(GUI.this.scrollPane1);
            }
        });
        this.button2 = new JButton("Shto nje gare te perfunduar");
        this.button2.setBounds(20, 280, 280, 40);
        this.button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.clearData();
                GUI.this.completedRace();
                GUI.this.switchPanels(GUI.this.panel2);
                GUI.this.panel2.remove(GUI.this.label9);
                GUI.this.panel2.add(GUI.this.label3);
                GUI.this.panel2.add(GUI.this.label9);
                GUI.this.panel2.add(GUI.this.button6);
                GUI.this.panel2.add(GUI.this.scrollPane2);
            }
        });
        this.button3 = new JButton("Shto nje gare te re");
        this.button3.setBounds(20, 360, 280, 40);
        this.button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.clearData();
                GUI.this.newRace();
                GUI.this.switchPanels(GUI.this.panel3);
                GUI.this.panel3.remove(GUI.this.label9);
                GUI.this.panel3.add(GUI.this.label4);
                GUI.this.panel3.add(GUI.this.label9);
                GUI.this.panel3.add(GUI.this.button7);
                GUI.this.panel3.add(GUI.this.scrollPane5);
            }
        });
        this.button4 = new JButton("Te gjitha garat");
        this.button4.setBounds(20, 440, 280, 40);
        this.button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.panel4.removeAll();
                GUI.this.fcm.loadInfo();
                GUI.this.allRaces();
                GUI.this.switchPanels(GUI.this.panel4);
                GUI.this.panel4.add(GUI.this.label5);
                GUI.this.panel4.add(GUI.this.scrollPane3);
            }
        });
        this.button6 = new JButton("+ Add Random Race");
        this.button6.setBounds(720, 140, 150, 30);
        this.button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.randomDriverGenerator(6);
                GUI.this.fcm.pointCalc(GUI.this.raceDriversData);
                MenaxhimKampionatiFormula1.GaraF1.add(new GaraFormula1(GUI.this.randomRaceDate, GUI.this.raceDriversData));
                GUI.this.fcm.loadInfo();
                GUI.this.panel2.add(GUI.this.scrollPane2);
            }
        });
        this.button7 = new JButton("+ Shtoni nje gare te rastesishme");
        this.button7.setBounds(700, 140, 180, 30);
        this.button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUI.this.randomDriverGenerator(7);
                GUI.this.fcm.pointCalc(GUI.this.finalPositions);
                MenaxhimKampionatiFormula1.GaraF1.add(new GaraFormula1(GUI.this.randomRaceDate, GUI.this.finalPositions));
                GUI.this.fcm.ruajInfo();
                GUI.this.panel3.add(GUI.this.scrollPane5);
            }
        });
    }

    public void clearData() {
        this.locationField.setText("    ");
    }

    public void driverSearch(int i) {
        this.driverSearchTable = new JTable();
        DefaultTableModel searchTableModel = (DefaultTableModel)this.driverSearchTable.getModel();
        String[] columnNames = new String[]{"Data", "Pozicioni"};
        searchTableModel.setColumnIdentifiers(columnNames);
        String name = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getEmri();
        String country = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getVendndodhja();
        String team = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getEkipi();
        int fpos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getFstPos();
        int spos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getScndPos();
        int tpos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getTrdPos();
        int points = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getDriverPoints();
        int raceCount = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getRaceCount();

        for(int j = 0; j < MenaxhimKampionatiFormula1.GaraF1.size(); ++j) {
            for(int k = 0; k < 10; ++k) {
                if (((ShoferiFormula1)((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(j)).getDriverPositions().get(k)).getEmri().equalsIgnoreCase(name)) {
                    LocalDate date = ((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(j)).getDate();
                    int position = k + 1;
                    Object[] data = new Object[]{date, position};
                    searchTableModel.addRow(data);
                }
            }
        }

        this.searchLabels(name, country, team, fpos, spos, tpos, points, raceCount);
        this.tableSorter(this.driverSearchTable, 0, "D");
        this.driverSearchTable.setBackground(Color.gray);
        this.driverSearchTable.setEnabled(false);
        this.scrollPane4 = new JScrollPane(this.driverSearchTable);
        this.scrollPane4.setBounds(500, 80, 400, 450);
    }

    public void searchLabels(String name, String country, String team, int fpos, int spos, int tpos, int points, int raceCount) {
        this.label10 = new JLabel();
        this.label10.setBounds(10, 10, 400, 150);
        this.label10.setText("Emri: " + name + "    Vendi: " + country + "    Ekipi: " + team);
        this.label10.setFont(new Font("Arimo", 1, 20));
        this.label10.setForeground(Color.blue);
        this.label10.setBackground(Color.black);
        this.label10.setOpaque(true);
        this.label10.setIconTextGap(40);
        this.label10.setHorizontalAlignment(0);
        this.label11 = new JLabel();
        this.label11.setText("Piket totale : " + points);
        this.label11.setFont(new Font("Poppins", 1, 18));
        this.label11.setForeground(new Color(180, 180, 180));
        this.label11.setBounds(35, 180, 350, 50);
        this.label11.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 195, 104)));
        this.label11.setHorizontalAlignment(0);
        this.label12 = new JLabel();
        this.label12.setText("Numri i pozicioneve te para : " + fpos);
        this.label12.setFont(new Font("Poppins", 1, 18));
        this.label12.setForeground(new Color(180, 180, 180));
        this.label12.setBounds(35, 230, 350, 50);
        this.label12.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 195, 104)));
        this.label12.setHorizontalAlignment(0);
        this.label13 = new JLabel();
        this.label13.setText("Numri i pozicioneve te dyta : " + spos);
        this.label13.setFont(new Font("Poppins", 1, 18));
        this.label13.setForeground(new Color(180, 180, 180));
        this.label13.setBounds(35, 280, 350, 50);
        this.label13.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 195, 104)));
        this.label13.setHorizontalAlignment(0);
        this.label14 = new JLabel();
        this.label14.setText("Numri i pozicioneve te treta : " + tpos);
        this.label14.setFont(new Font("Poppins", 1, 18));
        this.label14.setForeground(new Color(180, 180, 180));
        this.label14.setBounds(35, 330, 350, 50);
        this.label14.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 195, 104)));
        this.label14.setHorizontalAlignment(0);
        this.label15 = new JLabel();
        this.label15.setText("Gara totale : " + raceCount);
        this.label15.setFont(new Font("Poppins", 1, 18));
        this.label15.setForeground(new Color(180, 180, 180));
        this.label15.setBounds(35, 380, 350, 50);
        this.label15.setHorizontalAlignment(0);
        this.label16 = new JLabel();
        this.label16.setBorder(BorderFactory.createLineBorder(new Color(48, 48, 48)));
        this.label16.setBounds(40, 80, 420, 450);
        this.label16.add(this.label10);
        this.label16.add(this.label11);
        this.label16.add(this.label12);
        this.label16.add(this.label13);
        this.label16.add(this.label14);
        this.label16.add(this.label15);
    }

    public void driverTable() {
        this.driverTable = new JTable();
        DefaultTableModel driverTableModel = (DefaultTableModel)this.driverTable.getModel();
        String[] columnNames = new String[]{"Emri", "Vendi", "Ekipi", "Pozicione te para", "Pozicione te dyta", "Pozicione te treta", "Piket totale", "Garat e llogaritura"};
        driverTableModel.setColumnIdentifiers(columnNames);

        for(int i = 0; i < MenaxhimKampionatiFormula1.ShoferiF1.size(); ++i) {
            String name = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getEmri();
            String country = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getVendndodhja();
            String team = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getEkipi();
            int fpos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getFstPos();
            int spos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getScndPos();
            int tpos = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getTrdPos();
            int points = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getDriverPoints();
            int raceCount = ((ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(i)).getRaceCount();
            Object[] data = new Object[]{name, country, team, fpos, spos, tpos, points, raceCount};
            driverTableModel.addRow(data);
        }

        this.tableSorter(this.driverTable, 6, "D");
        this.driverTable.setBackground(Color.gray);
        this.driverTable.setEnabled(false);
        this.scrollPane1 = new JScrollPane(this.driverTable);
        this.scrollPane1.setBounds(40, 170, 860, 315);
    }

    public void completedRace() {
        this.completedRaceTable = new JTable();
        DefaultTableModel raceTableModel = (DefaultTableModel)this.completedRaceTable.getModel();
        String[] columnNames = new String[]{"Data", "Pozicioni", "Emri", "Ekipi"};
        raceTableModel.setColumnIdentifiers(columnNames);
        this.randomDateGenerator();

        for(int i = 0; i < this.raceDriversData.size(); ++i) {
            Object[] data = new Object[]{this.randomRaceDate, i + 1, ((ShoferiFormula1)this.raceDriversData.get(i)).getEmri(), ((ShoferiFormula1)this.raceDriversData.get(i)).getEkipi()};
            raceTableModel.addRow(data);
        }

        this.completedRaceTable.setBackground(Color.gray);
        this.completedRaceTable.setEnabled(false);
        this.scrollPane2 = new JScrollPane(this.completedRaceTable);
        this.scrollPane2.setBounds(40, 300, 860, 185);
    }

    public void newRace() {
        this.newRaceTable = new JTable();
        DefaultTableModel newRaceTableModel = (DefaultTableModel)this.newRaceTable.getModel();
        String[] columnNames = new String[]{"Data", "Emri", "Ekipi", "Pozicioni i startit", "Pozicioni i finishit"};
        newRaceTableModel.setColumnIdentifiers(columnNames);
        this.randomDateGenerator();
        int random;
        if (this.raceDriversData.size() != 0) {
            random = (int)(Math.random() * 99.0 + 0.0);
            if (random < 40) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(0));
            } else if (random < 70) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(1));
            } else if (random < 80) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(2));
            } else if (random < 90) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(3));
            } else if (random < 92) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(4));
            } else if (random < 94) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(5));
            } else if (random < 96) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(6));
            } else if (random < 98) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(7));
            } else if (random < 100) {
                this.switchArrayItems((ShoferiFormula1)this.raceDriversData.get(8));
            }
        }

        for(random = 0; random < this.finalPositions.size(); ++random) {
            for(int j = 0; j < this.raceDriversData.size(); ++j) {
                if (((ShoferiFormula1)this.finalPositions.get(random)).getEmri().equals(((ShoferiFormula1)this.raceDriversData.get(j)).getEmri())) {
                    Object[] data = new Object[]{this.randomRaceDate, ((ShoferiFormula1)this.finalPositions.get(random)).getEmri(), ((ShoferiFormula1)this.finalPositions.get(random)).getEkipi(), j + 1, random + 1};
                    newRaceTableModel.addRow(data);
                    break;
                }
            }
        }

        this.newRaceTable.setBackground(Color.gray);
        this.newRaceTable.setEnabled(false);
        this.scrollPane5 = new JScrollPane(this.newRaceTable);
        this.scrollPane5.setBounds(40, 300, 860, 185);
    }

    public void switchArrayItems(ShoferiFormula1 shoferi) {
        this.finalPositions.removeAll(this.finalPositions);
        this.finalPositions.addAll(this.raceDriversData);
        Collections.shuffle(this.finalPositions);
        int itemIndex = this.finalPositions.indexOf(shoferi);
        this.finalPositions.remove(itemIndex);
        this.finalPositions.add(0, shoferi);
    }

    public void allRaces() {
        this.allRaceTable = new JTable();
        DefaultTableModel allRaceTableModel = (DefaultTableModel)this.allRaceTable.getModel();
        String[] columnNames = new String[]{"Data", "Emri", "Pozicionet e para", "Ekipi", "Piket"};
        allRaceTableModel.setColumnIdentifiers(columnNames);

        for(int i = 0; i < MenaxhimKampionatiFormula1.GaraF1.size(); ++i) {
            LocalDate date = ((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(i)).getDate();

            for(int j = 0; j < ((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(i)).getDriverPositions().size(); ++j) {
                Object[] data = new Object[]{date, ((ShoferiFormula1)((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(i)).getDriverPositions().get(j)).getEmri(), j + 1, ((ShoferiFormula1)((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(i)).getDriverPositions().get(j)).getEkipi(), ((ShoferiFormula1)((GaraFormula1)MenaxhimKampionatiFormula1.GaraF1.get(i)).getDriverPositions().get(j)).getDriverPoints()};
                allRaceTableModel.addRow(data);
            }
        }

        this.tableSorter(this.allRaceTable, 0, "A");
        this.allRaceTable.setBackground(Color.gray);
        this.allRaceTable.setEnabled(false);
        this.scrollPane3 = new JScrollPane(this.allRaceTable);
        this.scrollPane3.setBounds(40, 100, 860, 385);
    }

    public void panels() {
        this.layeredPane = new JLayeredPane();
        this.layeredPane.setBounds(0, 0, 960, 618);
        this.topPanel = new JPanel();
        this.topPanel.setLayout((LayoutManager)null);
        this.topPanel.setBackground(new Color(119, 37, 48));
        this.topPanel.setPreferredSize(new Dimension(1280, 150));
        this.topPanel.add(this.label1);
        this.leftPanel = new JPanel();
        this.leftPanel.setBackground(new Color(49, 65, 122));
        this.leftPanel.setLayout((LayoutManager)null);
        this.leftPanel.setPreferredSize(new Dimension(320, 100));
        this.leftPanel.add(this.searchField);
        this.leftPanel.add(this.searchButton);
        this.leftPanel.add(this.button1);
        this.leftPanel.add(this.button2);
        this.leftPanel.add(this.button3);
        this.leftPanel.add(this.button4);
        this.midPanel = new JPanel();
        this.midPanel.setLayout((LayoutManager)null);
        this.midPanel.setBackground(new Color(20, 27, 1));
        this.midPanel.setPreferredSize(new Dimension(960, 618));
        this.midPanel.add(this.layeredPane);
        this.panel1 = new JPanel();
        this.panel1.setLayout((LayoutManager)null);
        this.panel1.setBackground(new Color(35, 35, 35));
        this.panel1.setBounds(0, 0, 960, 618);
        this.panel1.add(this.label2);
        this.panel1.add(this.pointsAscButton);
        this.panel1.add(this.fposDscButton);
        this.panel1.add(this.button5);
        this.panel1.add(this.scrollPane1);
        this.layeredPane.add(this.panel1);
        this.panel2 = new JPanel();
        this.panel2.setLayout((LayoutManager)null);
        this.panel2.setBackground(new Color(35, 35, 35));
        this.panel2.setBounds(0, 0, 960, 618);
        this.layeredPane.add(this.panel2);
        this.panel3 = new JPanel();
        this.panel3.setLayout((LayoutManager)null);
        this.panel3.setBackground(new Color(35, 35, 35));
        this.panel3.setBounds(0, 0, 960, 618);
        this.layeredPane.add(this.panel3);
        this.panel4 = new JPanel();
        this.panel4.setLayout((LayoutManager)null);
        this.panel4.setBackground(new Color(35, 35, 35));
        this.panel4.setBounds(0, 0, 960, 618);
        this.layeredPane.add(this.panel4);
        this.searchPanel = new JPanel();
        this.searchPanel.setLayout((LayoutManager)null);
        this.searchPanel.setBackground(new Color(35, 35, 35));
        this.searchPanel.setBounds(0, 0, 960, 618);
        this.layeredPane.add(this.searchPanel);
    }

    public void switchPanels(JPanel panel) {
        this.layeredPane.removeAll();
        this.layeredPane.add(panel);
        this.layeredPane.repaint();
        this.layeredPane.revalidate();
    }

    public void tableSorter(JTable table, int index, String order) {
        TableRowSorter<TableModel> sorter = new TableRowSorter(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList();
        if (order.equals("A")) {
            sortKeys.add(new RowSorter.SortKey(index, SortOrder.ASCENDING));
        } else {
            sortKeys.add(new RowSorter.SortKey(index, SortOrder.DESCENDING));
        }

        sorter.setSortKeys(sortKeys);
        sorter.sort();
    }

    public void randomDriverGenerator(int button) {
        this.raceDriversData.removeAll(this.raceDriversData);

        for(int i = 0; i < 10; ++i) {
            int random = (int)(Math.random() * (double)(MenaxhimKampionatiFormula1.ShoferiF1.size() - 1) + 0.0);
            ShoferiFormula1 driver = (ShoferiFormula1)MenaxhimKampionatiFormula1.ShoferiF1.get(random);
            if (!this.raceDriversData.contains(driver)) {
                this.raceDriversData.add(driver);
            } else {
                --i;
            }
        }

        if (button == 6) {
            this.completedRace();
        } else if (button == 7) {
            this.newRace();
        }

    }

    public void randomDateGenerator() {
        Random random = new Random();
        int startDay = (int)LocalDate.of(2018, 1, 1).toEpochDay();
        int endDay = (int)LocalDate.now().toEpochDay();
        long randomDay = (long)(startDay + random.nextInt(endDay - startDay));
        this.randomRaceDate = LocalDate.ofEpochDay(randomDay);
    }
}