package BigProject.AdminSideClasses.ChangePageClasses;

import BigProject.GeneralClasses.Cities;
import BigProject.AdminSideClasses.GuiAdmin;

import javax.swing.*;
import java.awt.*;

public class ChangeCityValues extends JPanel {
    private final GuiAdmin parent;

    private JLabel jLabel;
    private JLabel nameL;
    private JLabel countryL;
    private JLabel snL;

    private JTextField nameT;
    private JTextField countryT;
    private JTextField snT;
    private JButton updateB;
    private JButton cancelB;

    private int id;

    public ChangeCityValues(GuiAdmin parent){
        this.parent = parent;

        setSize(700,600);
        setLayout(null);

        jLabel = new JLabel("Insert Parameters of The City");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300, 30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        nameL = new JLabel("Name:");
        nameL.setSize(300, 30);
        nameL.setLocation(200, 150);
        add(nameL);
        countryL = new JLabel("Country:");
        countryL.setSize(300,30);
        countryL.setLocation(200,200);
        add(countryL);
        snL = new JLabel("Short Name:");
        snL.setSize(300,30);
        snL.setLocation(175,250);
        add(snL);

        nameT = new JTextField();
        nameT.setSize(300, 30);
        nameT.setLocation(250, 150);
        add(nameT);
        countryT = new JTextField();
        countryT.setSize(300,30);
        countryT.setLocation(250,200);
        add(countryT);
        snT = new JTextField();
        snT.setSize(300,30);
        snT.setLocation(250,250);
        add(snT);

        updateB = new JButton("Update");
        updateB.setSize(100,30);
        updateB.setLocation(200,350);
        updateB.addActionListener(e -> {
            String name = nameT.getText();
            String country = countryT.getText();
            String sn = snT.getText();
            try{
                Cities city = new Cities(id, name, country, sn);
                parent.updateCity(city);
            }catch (Exception exception){
                exception.printStackTrace();
            }
            nameT.setText(null);
            countryT.setText(null);
            snT.setText(null);
        });
        add(updateB);

        cancelB = new JButton("Cancel");
        cancelB.setSize(100,30);
        cancelB.setLocation(350,350);
        cancelB.addActionListener(e -> {
            parent.getChangeCityValues().setVisible(false);
            parent.getChangeCity().setVisible(true);
        });
        add(cancelB);
    }
    protected void setId(int id){
        this.id = id;
    }
}
