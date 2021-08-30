package BigProject.AdminSideClasses.CreatePageClasses;

import BigProject.GeneralClasses.Cities;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCity extends JPanel {
    private final GuiAdmin parent;
    private final JLabel jLabel;
    private final JLabel nameL;
    private final JLabel countryL;
    private final JTextField countryT;
    private final JLabel snL;
    private final JTextField snT;
    private final JTextField nameT;
    private final JButton addB;
    private final JButton backB;

    public CreateCity(GuiAdmin parent){
        this.parent = parent;

        setSize(700,600);
        setLayout(null);

        jLabel = new JLabel("Insert Parameters of The New City");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        nameL = new JLabel("Name:");
        nameL.setSize(300,30);
        nameL.setLocation(170,150);
        add(nameL);
        countryL = new JLabel("Country:");
        countryL.setSize(300,30);
        countryL.setLocation(170, 200);
        add(countryL);
        snL = new JLabel("Short Name:");
        snL.setSize(300,30);
        snL.setLocation(170, 250);
        add(snL);
        nameT = new JTextField();
        nameT.setSize(300,30);
        nameT.setLocation(250, 150);
        add(nameT);
        countryT = new JTextField();
        countryT.setSize(300,30);
        countryT.setLocation(250, 200);
        add(countryT);
        snT = new JTextField();
        snT.setSize(300,30);
        snT.setLocation(250, 250);
        add(snT);

        addB = new JButton("Add");
        addB.setSize(100,30);
        addB.setLocation(200,300);
        addB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameT.getText();
                String country = countryT.getText();
                String sn = snT.getText();
                try{
                    Cities city = new Cities(-1,name,country,sn);
                    parent.addCity(city);
                }catch (Exception ex) {ex.printStackTrace();}
                nameT.setText(null);
                countryT.setText(null);
                snT.setText(null);
            }
        });
        add(addB);
        backB = new JButton("Cancel");
        backB.setSize(100, 30);
        backB.setLocation(400, 300);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getCreateCity().setVisible(false);
                parent.getCreateMenu().setVisible(true);
            }
        });
        add(backB);
    }
}
