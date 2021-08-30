package BigProject.DeletePageClasses;

import BigProject.Classes.Airplanes;
import BigProject.GuiAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DeleteAirplane extends JPanel {
    private final GuiAdmin parent;
    private final JLabel jLabel;
    private final String[] header = {"ID", "Name", "Model", "Business CC", "Economy CC"};
    private JComboBox<Integer> indexBox;
    private JTable table;
    private JScrollPane scrollPane;

    private JButton actionButton;
    private JButton backB;
    private int[] ints;

    public DeleteAirplane(GuiAdmin parent) {
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What Airplane You Want To Delete");
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

        actionButton = new JButton("Delete");
        actionButton.setSize(150, 30);
        actionButton.setLocation(150, 470);
        actionButton.addActionListener(e -> {
            int index = indexBox.getSelectedIndex() + 1;
            Airplanes airplane = new Airplanes();
            airplane.setId(index);
            parent.deleteAirplane(airplane);
            indexBox.setSelectedIndex(0);
            parent.getDeleteAirplane().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getDeleteAirplane().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(backB);

    }

    public void generateTable(ArrayList<Airplanes> airplanes) {
        Object[][] data = new Object[airplanes.size()][5];
        ints = new int[airplanes.size()];
        for (int i = 0; i < airplanes.size(); i++) {
            if (airplanes.get(i) != null) {
                data[i][0] = airplanes.get(i).getId();
                data[i][1] = airplanes.get(i).getName();
                data[i][2] = airplanes.get(i).getModel();
                data[i][3] = airplanes.get(i).getBusiness_class_capacity();
                data[i][4] = airplanes.get(i).getEconomy_class_capacity();
                ints[i] = i;
            }
        }
        indexBox.removeAllItems();
        for (int i : ints) {
            indexBox.addItem(i + 1);
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (airplanes.isEmpty()) jLabel.setText("No Airplanes Were Received");
        else jLabel.setText("Choose What Airplane To Change");
    }
}
