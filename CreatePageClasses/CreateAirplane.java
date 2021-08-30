package BigProject.CreatePageClasses;

import BigProject.Classes.Airplanes;
import BigProject.GuiAdmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateAirplane extends JPanel {
    private final GuiAdmin parent;
    private JLabel jLabel;
    private JLabel nameL;
    private JLabel modelL;
    private JLabel bccL;
    private JLabel eccL;
    private JTextField nameT;
    private JTextField modelT;
    private JTextField bccT;
    private JTextField eccT;
    private JButton addB;
    private JButton backB;

    public CreateAirplane(GuiAdmin parent){
        this.parent = parent;

        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Insert Parameters of The New Airplane");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(200, 100);
        add(jLabel);

        nameL = new JLabel("Name:");
        nameL.setSize(300,30);
        nameL.setLocation(200,150);
        add(nameL);
        modelL = new JLabel("Model:");
        modelL.setSize(300,30);
        modelL.setLocation(200, 200);
        add(modelL);
        bccL = new JLabel("business_class_capacity:");
        bccL.setSize(300,30);
        bccL.setLocation(100, 250);
        add(bccL);
        eccL = new JLabel("economy_class_capacity:");
        eccL.setSize(300,30);
        eccL.setLocation(100, 300);
        add(eccL);

        nameT = new JTextField();
        nameT.setSize(300,30);
        nameT.setLocation(250, 150);
        add(nameT);
        modelT = new JTextField();
        modelT.setSize(300,30);
        modelT.setLocation(250, 200);
        add(modelT);
        bccT = new JTextField();
        bccT.setSize(300,30);
        bccT.setLocation(250, 250);
        add(bccT);
        eccT = new JTextField();
        eccT.setSize(300,30);
        eccT.setLocation(250, 300);
        add(eccT);

        addB = new JButton("Add");
        addB.setSize(100, 30);
        addB.setLocation(200, 350);
        addB.addActionListener(e -> {
            String name = nameT.getText();
            String model = modelT.getText();
            String bcc = bccT.getText();
            String ecc = eccT.getText();
            try{
                int bccI = Integer.parseInt(bcc);
                int eccI = Integer.parseInt(ecc);
                Airplanes airplane = new Airplanes(0, name, model, bccI, eccI);
                parent.addAirplane(airplane);
            }catch (Exception exception) { exception.printStackTrace(); }
            nameT.setText(null);
            modelT.setText(null);
            bccT.setText(null);
            eccT.setText(null);
        });
        add(addB);

        backB = new JButton("Cancel");
        backB.setSize(100, 30);
        backB.setLocation(350, 350);
        backB.addActionListener(e -> {
            parent.getCreateAirplane().setVisible(false);
            parent.getCreateMenu().setVisible(true);
        });
        add(backB);
    }
}
