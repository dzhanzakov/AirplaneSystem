package BigProject.AdminSideClasses.CreatePageClasses;

import BigProject.GeneralClasses.Airplanes;
import BigProject.GeneralClasses.Cities;
import BigProject.GeneralClasses.Flights;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateFlight extends JPanel {
    private GuiAdmin parent;
    private JLabel jLabel;

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
    private ArrayList<Airplanes> airplanes;
    private ArrayList<Cities> cities;

    private JButton addB;
    private JButton backB;

    public CreateFlight(GuiAdmin parent) {
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Insert Parameters of the New Flight");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
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

        cities = parent.getCities();
        airplanes = parent.getAirplanes();

//        String[] airplanesArray = new String[airplanes.size()];
//        int j = 0;
//        for(Airplanes a:airplanes) {
//            airplanesArray[j] = a.getName() + " " + a.getModel();
//            j++;
//        }


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

        addB = new JButton("Add");
        addB.setSize(150,30);
        addB.setLocation(150, 450);
        addB.addActionListener(e -> {
            int ai = Integer.parseInt(aiT.getItemAt(aiT.getSelectedIndex()).substring(0,1));
            int dci = Integer.parseInt(dciT.getItemAt(dciT.getSelectedIndex()).substring(0,1));;
            int aci = Integer.parseInt(aciT.getItemAt(aciT.getSelectedIndex()).substring(0,1));;
            String dt = dtT.getText();
            String epp = eppT.getText();
            String bpp = bppT.getText();
            try{
                int eppI = Integer.parseInt(epp);
                int bppI = Integer.parseInt(bpp);
                Flights flight = new Flights(-1, ai, dci, aci, dt, eppI, bppI);
                parent.addFlight(flight);
            }catch (Exception ex){ex.printStackTrace();}
            aiT.setSelectedIndex(0);
            dciT.setSelectedIndex(0);
            aciT.setSelectedIndex(0);
            dtT.setText(null);
            eppT.setText(null);
            bppT.setText(null);
        });
        add(addB);

        backB = new JButton("Cancel");
        backB.setSize(150,30);
        backB.setLocation(350,450);
        backB.addActionListener(e -> {
            parent.getCreateFlight().setVisible(false);
            parent.getCreateMenu().setVisible(true);
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
}
