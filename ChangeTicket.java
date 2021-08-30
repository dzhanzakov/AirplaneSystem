package BigProject;

import BigProject.Classes.Airplanes;
import BigProject.Classes.Tickets;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.Serial;
import java.util.ArrayList;

public class ChangeTicket extends JPanel{
    private GuiCashier parent;
    private JLabel jLabel;
    private JTable table;
    private JComboBox<Integer> indexBox;
    private JScrollPane scrollPane;
    private JButton actionButton;
    private JButton backB;
    private int[] ints;
    private final String[] header = {"ID","flight","name","surname","passport Num","ticket type"};

    public ChangeTicket(GuiCashier parent){
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What Ticket You Want To Change");
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

        });
        add(actionButton);

        backB = new JButton("Cancel");
        backB.setSize(150, 30);
        backB.setLocation(400, 470);
        backB.addActionListener(e -> {
            parent.getChangeTicket().setVisible(false);
            parent.getChangeTicket().generateTable(parent.getTickets(), parent.getAirplanes());
            parent.getMainPageForCashier().setVisible(true);
        });
        add(backB);

    }
    public void generateTable(ArrayList<Tickets> tickets, ArrayList<Airplanes> airplanes){
        Object[][] data = new Object[tickets.size()][6];
        ints = new int[tickets.size()];
        for(int i = 0; i < tickets.size(); i++){
            if(tickets.get(i) != null){
                data[i][0] = tickets.get(i).getId();
                data[i][1] = airplanes.get(tickets.get(i).getFlight_id()).getName() + " " + airplanes.get(tickets.get(i).getFlight_id()).getModel();
                data[i][2] = tickets.get(i).getName();
                data[i][3] = tickets.get(i).getSurname();
                data[i][4] = tickets.get(i).getPassport_number();
                data[i][5] = tickets.get(i).getTicket_type();
                ints[i] = i;
            }
        }
        indexBox.removeAllItems();
        for (int i:ints) {
            indexBox.addItem(i+1);
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
        if (tickets.isEmpty()) jLabel.setText("There Are No Tickets Were Received");
        else jLabel.setText("Choose What Ticket You Want To Change");
    }
}