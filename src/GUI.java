import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class GUI implements ActionListener {
    private JPanel topPanel, leftPanel, midPanel, searchPanel, panel1, panel2, panel3, panel4;
    private JLabel label1, label2, label3, label4, label5, label7, label9, label10, label11, label12, label13, label14, label15, label16, label17, label18, label19;
    private JButton searchButton, pointsAscButton, fposDscButton, button1, button2, button3, button4, button5, button6, button7;
    private JTextField searchField, locationField;
    private JTable driverTable, completedRaceTable, newRaceTable, driverSearchTable;
    private JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4, scrollPane5;

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Menaxhimi i Kampionatit Formula 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 700);

        createComponents();
        addComponentsToFrame(frame);

        frame.setVisible(true);
    }

    private void createComponents() {
        textFields();
        buttons();
        labels();
        driverTable();
        panels();

        Border emptyBorder = BorderFactory.createEmptyBorder();
        topPanel.setBorder(emptyBorder);
        leftPanel.setBorder(emptyBorder);
        midPanel.setBorder(emptyBorder);
    }

    private void addComponentsToFrame(JFrame frame) {
        frame.add(leftPanel, BorderLayout.WEST);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(midPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    private void textFields() {
        searchField = new JTextField();
        searchField.setBounds(20, 60, 280, 30);
        searchField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        searchField.setBackground(new Color(245, 245, 245));
        searchField.setForeground(Color.DARK_GRAY);

        locationField = new JTextField();
        locationField.setBounds(40, 40, 200, 30);
        locationField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        locationField.setBackground(new Color(245, 245, 245));
        locationField.setForeground(Color.DARK_GRAY);
    }

    private void labels() {
        label1 = createLabel("Menaxhimi i Kampionatit FORMULA 1", 36, Color.WHITE);
        label1.setBounds(15, 10, 1100, 100);

        label2 = createLabel(">> Statistikat per shoferet <<", 24, Color.ORANGE);
        label2.setBounds(241, 20, 500, 50);

        label3 = createLabel(">> Gara rastesore <<", 24, Color.ORANGE);
        label3.setBounds(250, 20, 500, 50);

        label4 = createLabel(">> Shto gare <<", 24, Color.ORANGE);
        label4.setBounds(340, 20, 500, 50);

        label5 = createLabel(">> Garat e perfunduara <<", 24, Color.ORANGE);
        label5.setBounds(300, 20, 500, 50);

        label7 = createLabel("Vendndodhja", 16, Color.GRAY);
        label7.setBounds(40, 15, 100, 20);

        label9 = new JLabel();
        label9.setBorder(BorderFactory.createLineBorder(new Color(135, 59, 75)));
        label9.setBounds(40, 100, 860, 100);
        label9.add(label7);
        label9.add(locationField);

        label17 = createLabel(">> Statistikat e shoferit <<", 24, Color.BLUE);
        label17.setBounds(300, 20, 500, 50);

        label18 = createLabel(" ~ Vendosni cfare doni te kerkoni! ~ ", 24, Color.WHITE);
        label18.setBounds(250, 250, 500, 50);

        label19 = createLabel("~ Ky shofer nuk ekziston! ~", 24, Color.WHITE);
        label19.setBounds(300, 250, 500, 50);
    }

    private JLabel createLabel(String text, int fontSize, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        label.setForeground(color);
        return label;
    }

    private void buttons() {
        searchButton = createButton("Kerko", 35, 100, 150, 30);
        button1 = createButton("Statistikat e shoferit", 20, 200, 280, 40);
        pointsAscButton = createButton("Duke u ngritur : Piket", 40, 120, 200, 30);
        fposDscButton = createButton("Duke zbritur : Pozicionet e para", 250, 120, 200, 30);
        button5 = createButton("Tabela e perditesuar", 600, 120, 225, 30);
        button2 = createButton("Shto nje gare te perfunduar", 20, 280, 280, 40);
        button3 = createButton("Shto nje gare te re", 20, 360, 280, 40);
        button4 = createButton("Te gjitha garat", 20, 440, 280, 40);
        button6 = createButton("+ Add Random Race", 720, 140, 150, 30);
        button7 = createButton("+ Shtoni nje gare te rastesishme", 700, 140, 180, 30);
    }

    private JButton createButton(String text, int x, int y, int width, int height) {
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.setBackground(new Color(60, 63, 65));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(255, 195, 104), 2));
        button.addActionListener(this);
        return button;
    }

    private void panels() {
        topPanel = new JPanel(null);
        topPanel.setPreferredSize(new Dimension(1200, 150));
        topPanel.setBackground(new Color(30, 30, 30));
        topPanel.add(label1);

        leftPanel = new JPanel(null);
        leftPanel.setPreferredSize(new Dimension(320, 700));
        leftPanel.setBackground(new Color(40, 40, 40));
        leftPanel.add(button1);
        leftPanel.add(button2);
        leftPanel.add(button3);
        leftPanel.add(button4);
        leftPanel.add(pointsAscButton);
        leftPanel.add(fposDscButton);
        leftPanel.add(button5);

        midPanel = new JPanel(new CardLayout());
        midPanel.setBackground(new Color(50, 50, 50));

        panel1 = new JPanel(null);
        panel1.setBackground(new Color(50, 50, 50));
        panel1.add(scrollPane1);

        panel2 = new JPanel(null);
        panel2.setBackground(new Color(50, 50, 50));
        panel2.add(label3);
        panel2.add(label9);
        panel2.add(button6);
        panel2.add(scrollPane2);

        panel3 = new JPanel(null);
        panel3.setBackground(new Color(50, 50, 50));
        panel3.add(label4);
        panel3.add(label9);
        panel3.add(button7);
        panel3.add(scrollPane5);

        panel4 = new JPanel(null);
        panel4.setBackground(new Color(50, 50, 50));
        panel4.add(label5);
        panel4.add(scrollPane3);

        midPanel.add(panel1, "panel1");
        midPanel.add(panel2, "panel2");
        midPanel.add(panel3, "panel3");
        midPanel.add(panel4, "panel4");
    }

    private void driverTable() {
        driverTable = new JTable();
        DefaultTableModel driverTableModel = (DefaultTableModel) driverTable.getModel();
        String[] columnNames = {"Emri", "Vendi", "Ekipi", "Pozicione te para", "Pozicione te dyta", "Pozicione te treta", "Piket totale", "Garat e llogaritura"};
        driverTableModel.setColumnIdentifiers(columnNames);

        driverTable.setBackground(new Color(60, 63, 65));
        driverTable.setForeground(Color.WHITE);
        driverTable.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        driverTable.setRowHeight(25);
        driverTable.getTableHeader().setBackground(new Color(60, 63, 65));
        driverTable.getTableHeader().setForeground(Color.WHITE);
        driverTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        scrollPane1 = new JScrollPane(driverTable);
        scrollPane1.setBounds(20, 80, 860, 220);
        scrollPane1.setBackground(new Color(60, 63, 65));
        scrollPane1.setBorder(BorderFactory.createLineBorder(new Color(255, 195, 104)));

        completedRaceTable = new JTable();
        DefaultTableModel completedRaceTableModel = (DefaultTableModel) completedRaceTable.getModel();
        completedRaceTableModel.setColumnIdentifiers(columnNames);
        scrollPane2 = new JScrollPane(completedRaceTable);
        scrollPane2.setBounds(20, 80, 860, 220);
        scrollPane2.setBackground(new Color(60, 63, 65));
        scrollPane2.setBorder(BorderFactory.createLineBorder(new Color(255, 195, 104)));

        newRaceTable = new JTable();
        DefaultTableModel newRaceTableModel = (DefaultTableModel) newRaceTable.getModel();
        newRaceTableModel.setColumnIdentifiers(columnNames);
        scrollPane3 = new JScrollPane(newRaceTable);
        scrollPane3.setBounds(20, 80, 860, 220);
        scrollPane3.setBackground(new Color(60, 63, 65));
        scrollPane3.setBorder(BorderFactory.createLineBorder(new Color(255, 195, 104)));

        driverSearchTable = new JTable();
        DefaultTableModel driverSearchTableModel = (DefaultTableModel) driverSearchTable.getModel();
        driverSearchTableModel.setColumnIdentifiers(columnNames);
        scrollPane4 = new JScrollPane(driverSearchTable);
        scrollPane4.setBounds(20, 60, 860, 220);
        scrollPane4.setBackground(new Color(60, 63, 65));
        scrollPane4.setBorder(BorderFactory.createLineBorder(new Color(255, 195, 104)));
    }
}
