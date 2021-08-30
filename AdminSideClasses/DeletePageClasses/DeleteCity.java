package BigProject.AdminSideClasses.DeletePageClasses;

import BigProject.GeneralClasses.Cities;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DeleteCity extends JPanel {
    private final GuiAdmin parent;
    private final JLabel jLabel;
    private String[] header = {"ID", "Name", "Country", "Short Name"};
    private JScrollPane scrollPane;
    private JComboBox<Integer> indexBox;
    private JButton actionButton;
    private JButton backB;
    private int[] ints;
    private JTable table;

    public DeleteCity(GuiAdmin parent){
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel();
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        indexBox = new JComboBox();
        indexBox.setSize(100, 30);
        indexBox.setLocation(300, 420);
        add(indexBox);

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

        actionButton = new JButton("Delete");
        actionButton.setSize(150, 30);
        actionButton.setLocation(150, 470);
        actionButton.addActionListener(e -> {
            int index = indexBox.getItemAt(indexBox.getSelectedIndex());
            Cities c = new Cities();
            c.setId(index);
            parent.deleteCity(c);
            indexBox.setSelectedIndex(0);
            parent.getDeleteCity().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getDeleteCity().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(backB);
    }
    public void generateTable(ArrayList<Cities> cities) {
        Object[][] data = new Object[cities.size()][4];
        indexBox.removeAllItems();
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) != null) {
                data[i][0] = cities.get(i).getId();
                data[i][1] = cities.get(i).getName();
                data[i][2] = cities.get(i).getCountry();
                data[i][3] = cities.get(i).getShort_name();
                indexBox.addItem(cities.get(i).getId());
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (cities.isEmpty()) jLabel.setText("No Cities Were Received");
        else jLabel.setText("Choose What City You Want To Delete");
    }
}
