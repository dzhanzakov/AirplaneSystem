package BigProject.AdminSideClasses.ChangePageClasses;

import BigProject.GeneralClasses.Airplanes;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class ChangeAirplane extends JPanel {
    private final GuiAdmin parent;
    private final JLabel jLabel;
    private ArrayList<Airplanes> airplanes;
    private String[] header = {"ID", "Name", "Model", "Business CC", "Economy CC"};
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<Integer> indexBox;
    private JButton actionButton;
    private JButton backB;

    public ChangeAirplane(GuiAdmin parent) {
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What Airplane To Change");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(250, 100);
        add(jLabel);

        indexBox = new JComboBox();
        indexBox.setSize(100, 30);
        indexBox.setLocation(300, 420);
        add(indexBox);

//        airplanes = parent.getAirplanes();

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
            parent.getChangeAirplaneValues().setId(indexBox.getItemAt(indexBox.getSelectedIndex()));
            parent.getChangeAirplaneValues().setVisible(true);
            parent.getChangeAirplane().setVisible(false);
        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getChangeAirplane().setVisible(false);
            parent.getChangeMenu().setVisible(true);
        });
        add(backB);
    }

    public void generateTable(ArrayList<Airplanes> airplanes) {
        Object[][] data = new Object[airplanes.size()][5];
        indexBox.removeAllItems();
        for (int i = 0; i < airplanes.size(); i++) {
            if (airplanes.get(i) != null) {
                data[i][0] = airplanes.get(i).getId();
                data[i][1] = airplanes.get(i).getName();
                data[i][2] = airplanes.get(i).getModel();
                data[i][3] = airplanes.get(i).getBusiness_class_capacity();
                data[i][4] = airplanes.get(i).getEconomy_class_capacity();
                indexBox.addItem(airplanes.get(i).getId());
            }
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (airplanes.isEmpty()) jLabel.setText("There Are No Airplanes Were Received");
        else jLabel.setText("Choose What Airplane To Change");
    }
}
