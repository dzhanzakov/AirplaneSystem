package BigProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateMenu extends JPanel {
    private JLabel jLabel;
    private final Gui parent;
    private final JButton createAirplane;
    private final JButton createCity;
    private final JButton createFlight;
    private final JButton cancel;

    public CreateMenu(Gui parent){
        this.parent = parent;
        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What To Create");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(250,100);
        add(jLabel);

        createAirplane = new JButton("Create Airplane");
        createAirplane.setSize(350, 30);
        createAirplane.setLocation(170, 150);
        createAirplane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateMenu().setVisible(false);
                parent.getCreateAirplane().setVisible(true);
            }
        });
        add(createAirplane);

        createCity = new JButton("Create City");
        createCity.setSize(350, 30);
        createCity.setLocation(170, 200);
        createCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateMenu().setVisible(false);
                parent.getCreateAirplane().setVisible(false);
                parent.getCreateCity().setVisible(true);
            }
        });
        add(createCity);

        createFlight = new JButton("Create Flight");
        createFlight.setSize(350,30);
        createFlight.setLocation(170, 250);
        createFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateMenu().setVisible(false);
                parent.getCreateFlight().setVisible(true);
            }
        });
        add(createFlight);

        cancel = new JButton("Cancel");
        cancel.setSize(350, 30);
        cancel.setLocation(170, 300);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateMenu().setVisible(false);
                parent.getMain().setVisible(true);
            }
        });
        add(cancel);
    }
}
