package BigProject.AdminSideClasses.DeletePageClasses;

import BigProject.GeneralClasses.Flights;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class DeleteFlight extends JPanel {
    private GuiAdmin parent;
    private JLabel jLabel;
    private ArrayList<Flights> flights;
    private String[] header = {"ID", "aircraft_id", "departure_city_id", "arrival_city_id", "departure_time", "economy_place_price", "business_place_price"};
    private JTable table;
    private JScrollPane scrollPane;
    private JComboBox<Integer> indexBox;
    private JButton actionButton;
    private JButton backB;
    private int[] ints;

    public DeleteFlight(GuiAdmin parent) {
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel();
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(400, 30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        indexBox = new JComboBox<>();
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

        actionButton = new JButton("Change");
        actionButton.setSize(150, 30);
        actionButton.setLocation(150, 470);
        actionButton.addActionListener(e -> {
            int index = indexBox.getItemAt(indexBox.getSelectedIndex());
            Flights f = new Flights();
            f.setId(index);
            parent.deleteFlight(f);
            indexBox.setSelectedIndex(0);
            parent.getDeleteFlight().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getDeleteFlight().setVisible(false);
            parent.getDeleteMenu().setVisible(true);
        });
        add(backB);
    }
    public void generateTable(ArrayList<Flights> flights) {
        Object[][] data = new Object[flights.size()][7];
        indexBox.removeAllItems();
        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i) != null) {
                data[i][0] = flights.get(i).getId();
                data[i][1] = flights.get(i).getAirplane_id();
                data[i][2] = flights.get(i).getDeparture_city_id();
                data[i][3] = flights.get(i).getArrival_city_id();
                data[i][4] = flights.get(i).getDeparture_time();
                data[i][5] = flights.get(i).getEconomy_place_price();
                data[i][6] = flights.get(i).getBusiness_place_price();
                indexBox.addItem(flights.get(i).getId());
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (flights.isEmpty()) jLabel.setText("No Flights Were Received");
        else jLabel.setText("Choose What Flight You Want To Delete");
    }
}