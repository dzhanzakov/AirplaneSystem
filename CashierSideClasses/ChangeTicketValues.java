package BigProject.CashierSideClasses;

import BigProject.GeneralClasses.Cities;
import BigProject.GeneralClasses.Flights;
import BigProject.GeneralClasses.Tickets;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChangeTicketValues extends JPanel {
    private GuiCashier parent;
    private int id;

    private JLabel jLabel;
    private JLabel nameL;
    private JLabel surnameL;
    private JLabel fiL;
    private JLabel pnL;
    private JLabel ttL;

    private JTextField nameT;
    private JTextField surnameT;
    private JComboBox<String> fiT;
    private JTextField pnT;
    private JTextField ttT;

    private JButton addB;
    private JButton backB;

    public ChangeTicketValues(GuiCashier p){
        this.parent = p;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Insert New Values Of The Ticket");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        nameL = new JLabel("Name:");
        nameL.setSize(300, 30);
        nameL.setLocation(100, 150);
        add(nameL);
        surnameL = new JLabel("Surname:");
        surnameL.setSize(300, 30);
        surnameL.setLocation(100, 200);
        add(surnameL);
        fiL = new JLabel("Flight Id:");
        fiL.setSize(300, 30);
        fiL.setLocation(100, 250);
        add(fiL);
        pnL = new JLabel("Passport Number:");
        pnL.setSize(300, 30);
        pnL.setLocation(100, 300);
        add(pnL);
        ttL = new JLabel("Ticket Type:");
        ttL.setSize(300, 30);
        ttL.setLocation(100, 350);
        add(ttL);

        nameT = new JTextField();
        nameT.setSize(300, 30);
        nameT.setLocation(250, 150);
        add(nameT);
        surnameT = new JTextField();
        surnameT.setSize(300, 30);
        surnameT.setLocation(250, 200);
        add(surnameT);
        fiT = new JComboBox<>();
        fiT.setSize(300, 30);
        fiT.setLocation(250, 250);
        add(fiT);
        pnT = new JTextField();
        pnT.setSize(300, 30);
        pnT.setLocation(250, 300);
        add(pnT);
        ttT = new JTextField();
        ttT.setSize(300, 30);
        ttT.setLocation(250, 350);
        add(ttT);

        addB = new JButton("Add");
        addB.setSize(100, 30);
        addB.setLocation(200, 400);
        addB.addActionListener(e -> {
            int fi = fiT.getSelectedIndex() + 1;
            String name = nameT.getText();
            String surname = surnameT.getText();
            String pn = pnT.getText();
            String tt = ttT.getText();
            try{
                Tickets ticket = new Tickets(id, fi, name, surname, pn, tt);
                parent.updateTicket(ticket);
            }catch (Exception ex){ex.printStackTrace();}
            nameT.setText(null);
            surnameT.setText(null);
            fiT.setSelectedIndex(0);
            pnT.setText(null);
            ttT.setText(null);
        });
        add(addB);

        backB = new JButton("Cancel");
        backB.setSize(100, 30);
        backB.setLocation(350, 400);
        backB.addActionListener(e -> {
            parent.getChangeTicketValues().setVisible(false);
            parent.getChangeTicket().generateTable(parent.getTickets(), parent.getAirplanes());
            parent.getChangeTicket().setVisible(true);
        });
        add(backB);

    }
    protected void setId(int id){
        this.id = id;
    }

    public void updateBoxes(ArrayList<Flights> flights, ArrayList<Cities> cities) {
        fiT.removeAllItems();
        for(Flights f:flights){
            fiT.addItem(cities.get(f.getDeparture_city_id()).getName() + " To " + cities.get(f.getArrival_city_id()).getName() + " " + f.getDeparture_time());
        }
    }
}
