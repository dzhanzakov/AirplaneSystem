package BigProject.AdminSideClasses.ChangePageClasses;

import BigProject.GeneralClasses.Airplanes;
import BigProject.GeneralClasses.Cities;
import BigProject.GeneralClasses.Flights;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChangeFlightValues extends JPanel {
    private final GuiAdmin parent;

    private final JLabel aiL;
    private final JLabel dciL;
    private final JLabel aciL;
    private final JLabel dtL;
    private final JLabel eppL;
    private final JLabel bppL;

    private JComboBox<String> aiT; //aircraft_id
    private JComboBox<String> dciT;
    private JComboBox<String> aciT;
    private JTextField dtT;
    private JTextField eppT;
    private JTextField bppT;

    private JLabel jLabel;

    private JButton updateButton;
    private JButton backB;

    private int id;

    public ChangeFlightValues(GuiAdmin parent){
        this.parent = parent;

        setSize(700,600);
        setLayout(null);

        jLabel = new JLabel("Insert New Parameters of The Flight");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        aiL = new JLabel("airplane id:");
        aiL.setSize(300,30);
        aiL.setLocation(185,150);
        add(aiL);
        dciL = new JLabel("departure city id:");
        dciL.setSize(300,30);
        dciL.setLocation(150, 200);
        add(dciL);
        aciL = new JLabel("arrival city id:");
        aciL.setSize(300,30);
        aciL.setLocation(170, 250);
        add(aciL);
        dtL = new JLabel("departure time:");
        dtL.setSize(300,30);
        dtL.setLocation(160,300);
        add(dtL);
        eppL = new JLabel("economy place price:");
        eppL.setSize(300,30);
        eppL.setLocation(125, 350);
        add(eppL);
        bppL = new JLabel("business place price:");
        bppL.setSize(300,30);
        bppL.setLocation(125, 400);
        add(bppL);

        aiT = new JComboBox();
        aiT.setSize(300,30);
        aiT.setLocation(250,150);
        add(aiT);

        dciT = new JComboBox();
        dciT.setSize(300,30);
        dciT.setLocation(250, 200);
        add(dciT);
        aciT = new JComboBox();
        aciT.setSize(300,30);
        aciT.setLocation(250,250);
        add(aciT);
        dtT = new JTextField();
        dtT.setSize(300,30);
        dtT.setLocation(250, 300);
        add(dtT);
        eppT = new JTextField();
        eppT.setSize(300,30);
        eppT.setLocation(250,350);
        add(eppT);
        bppT = new JTextField();
        bppT.setSize(300,30);
        bppT.setLocation(250,400);
        add(bppT);

        updateButton = new JButton("Update");
        updateButton.setSize(150,30);
        updateButton.setLocation(150, 450);
        updateButton.addActionListener(e -> {
            int ai = Integer.parseInt(aiT.getItemAt(aiT.getSelectedIndex()).substring(0,1));
            int dci = Integer.parseInt(dciT.getItemAt(dciT.getSelectedIndex()).substring(0,1));
            int aci = Integer.parseInt(aciT.getItemAt(aciT.getSelectedIndex()).substring(0,1));
            String dt = dtT.getText();
            String epp = eppT.getText();
            String bpp = bppT.getText();
            try {
                int eppI = Integer.parseInt(epp);
                int bppI = Integer.parseInt(bpp);
                Flights flight = new Flights(id, ai, dci, aci, dt, eppI, bppI);
                parent.updateFlight(flight);
            }catch (Exception exc){exc.printStackTrace();}
            aiT.setSelectedIndex(0);
            dciT.setSelectedIndex(0);
            aciT.setSelectedIndex(0);
            dtT.setText(null);
            eppT.setText(null);
            bppT.setText(null);
        });
        add(updateButton);

        backB = new JButton("Cancel");
        backB.setSize(150,30);
        backB.setLocation(350,450);
        backB.addActionListener(e -> {
            parent.getChangeFlightValues().setVisible(false);
            parent.getChangeFlight().setVisible(true);
        });
        add(backB);
    }
    public void updateBoxes(ArrayList<Cities> cities, ArrayList<Airplanes> airplanes){
        aciT.removeAllItems();
        aiT.removeAllItems();
        dciT.removeAllItems();
        for (Cities city : cities) {
            aciT.addItem(city.getId() + " " + city.getName() + " " + city.getShort_name());
        }
        for (Cities city : cities) {
            dciT.addItem(city.getId() + " " + city.getName() + " " + city.getShort_name());
        }
        for (Airplanes airplane : airplanes) {
            aiT.addItem(airplane.getId() + " " +airplane.getName() + " " + airplane.getModel());
        }
    }
    protected void setId(int id){
        this.id = id;
    }
}
