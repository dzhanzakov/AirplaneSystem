package BigProject.DeletePageClasses;

import BigProject.GuiAdmin;

import javax.swing.*;
import java.awt.*;

public class DeleteMenu extends JPanel {
    private final GuiAdmin parent;
    private JLabel jLabel;
    private final JButton deleteAirplane;
    private final JButton deleteCity;
    private final JButton deleteFlight;
    private final JButton cancel;

    public DeleteMenu(GuiAdmin parent){
        this.parent = parent;
        setSize(700,600);
        setLayout(null);

        jLabel = new JLabel("Choose What To Delete");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(250,100);
        add(jLabel);

        deleteAirplane = new JButton("Delete Airplane");
        deleteAirplane.setSize(350, 30);
        deleteAirplane.setLocation(170, 150);
        deleteAirplane.addActionListener(e -> {
            parent.getDeleteAirplane().generateTable(parent.getAirplanes());
            parent.getDeleteMenu().setVisible(false);
            parent.getDeleteAirplane().setVisible(true);
        });
        add(deleteAirplane);

        deleteCity = new JButton("Delete City");
        deleteCity.setSize(350, 30);
        deleteCity.setLocation(170, 200);
        deleteCity.addActionListener(e -> {
            parent.getDeleteCity().generateTable(parent.getCities());
            parent.getDeleteMenu().setVisible(false);
            parent.getDeleteCity().setVisible(true);
        });
        add(deleteCity);

        deleteFlight = new JButton("Delete Flight");
        deleteFlight.setSize(350,30);
        deleteFlight.setLocation(170, 250);
        deleteFlight.addActionListener(e -> {
            parent.getDeleteFlight().generateTable(parent.getFlights());
            parent.getDeleteMenu().setVisible(false);
            parent.getDeleteFlight().setVisible(true);
        });
        add(deleteFlight);

        cancel = new JButton("Cancel");
        cancel.setSize(350, 30);
        cancel.setLocation(170, 300);
        cancel.addActionListener(e -> {
            parent.getDeleteMenu().setVisible(false);
            parent.getMain().setVisible(true);
        });
        add(cancel);
    }
}
