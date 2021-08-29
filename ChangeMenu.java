package BigProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeMenu extends JPanel {
    private final Gui parent;
    private JLabel jLabel;
    private final JButton changeAirplane;
    private final JButton changeCity;
    private final JButton changeFlight;
    private final JButton cancel;

    public ChangeMenu(Gui parent){
        this.parent = parent;
        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose What To Change");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(250,100);
        add(jLabel);

        changeAirplane = new JButton("Change Airplane");
        changeAirplane.setSize(350, 30);
        changeAirplane.setLocation(170, 150);
        changeAirplane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getChangeAirplane().generateTable(parent.getAirplanes());
                parent.getChangeAirplane().setVisible(true);
                parent.getChangeMenu().setVisible(false);
            }
        });
        add(changeAirplane);

        changeCity = new JButton("Change City");
        changeCity.setSize(350, 30);
        changeCity.setLocation(170, 200);
        changeCity.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(changeCity);

        changeFlight = new JButton("Change Flight");
        changeFlight.setSize(350,30);
        changeFlight.setLocation(170, 250);
        changeFlight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        add(changeFlight);

        cancel = new JButton("Cancel");
        cancel.setSize(350, 30);
        cancel.setLocation(170, 300);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateMenu().setVisible(false);
                parent.getChangeMenu().setVisible(false);
                parent.getMain().setVisible(true);
            }
        });
        add(cancel);
    }
}
