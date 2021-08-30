package BigProject.ChangePageClasses;

import BigProject.Classes.Cities;
import BigProject.GuiAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class ChangeCity extends JPanel {
    private final GuiAdmin parent;
    private final JLabel jLabel;
    private ArrayList<Cities> cities;
    private String[] header = {"ID", "Name", "Country", "Short Name"};
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<Integer> indexBox;
    private JButton actionButton;
    private JButton backB;
    private int[] ints;

    public ChangeCity(GuiAdmin parent) {
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What City You Want Change");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(250, 100);
        add(jLabel);

        indexBox = new JComboBox();
        indexBox.setSize(100, 30);
        indexBox.setLocation(300, 420);
        add(indexBox);

        cities = parent.getCities();

        table = new JTable() {
            @Serial
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setFont(new Font("Calibri", Font.PLAIN, 13));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(500, 250);
        scrollPane.setLocation(100, 150);
        add(scrollPane);

        actionButton = new JButton("Change");
        actionButton.setSize(150, 30);
        actionButton.setLocation(150, 470);
        actionButton.addActionListener(e -> {
            parent.getChangeCityValues().setId(indexBox.getSelectedIndex() + 1);
            parent.getChangeCityValues().setVisible(true);
            parent.getChangeCity().setVisible(false);
        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getChangeCity().setVisible(false);
            parent.getChangeMenu().setVisible(true);
        });
        add(backB);
    }

    public void generateTable(ArrayList<Cities> cities) {
        Object[][] data = new Object[cities.size()][4];
        ints = new int[cities.size()];
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null) {
                data[i][0] = cities.get(i).getId();
                data[i][1] = cities.get(i).getName();
                data[i][2] = cities.get(i).getCountry();
                data[i][3] = cities.get(i).getShort_name();
                ints[i] = i;
            }
        }
        indexBox.removeAllItems();
        for (int i:ints) {
            indexBox.addItem(i+1);
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (cities.isEmpty()) jLabel.setText("There Are No Cities Were Received");
        else jLabel.setText("Choose What City You Want To Change");
    }
}

