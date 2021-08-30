package BigProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainPageForCashier extends JPanel {
    private GuiCashier parent;
    private JLabel jLabel;
    private final JButton createButton;
    private JButton changeButton;
    private JButton deleteButton;
    private JButton exitButton;

    public MainPageForCashier(GuiCashier parent){
        this.parent = parent;
        setSize(700, 600);
        setLayout(null);

        jLabel = new JLabel("Choose The Action:");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(350, 30);
        jLabel.setLocation(270, 100);
        add(jLabel);

        createButton = new JButton("Create");
        createButton.setSize(350, 30);createButton.setLocation(170,150);
        createButton.addActionListener(e -> {
            parent.getMainPageForCashier().setVisible(false);
            parent.getCreateTicket().updateBoxes(parent.getFlights(), parent.getCities());
            parent.getCreateTicket().setVisible(true);
        });
        add(createButton);

        changeButton = new JButton("Edit");
        changeButton.setSize(350, 30);
        changeButton.setLocation(170, 200);
        changeButton.addActionListener(e -> {
            parent.getChangeTicket().generateTable(parent.getTickets(), parent.getAirplanes());
            parent.getMainPageForCashier().setVisible(false);
            parent.getChangeTicket().setVisible(true);
        });
        add(changeButton);

        deleteButton = new JButton("Delete");
        deleteButton.setSize(350, 30);
        deleteButton.setLocation(170, 250);
        deleteButton.addActionListener(e -> {

        });
        add(deleteButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(350, 30); exitButton.setLocation(170, 300); add(exitButton);
        exitButton.addActionListener(e -> {
            try {
                parent.getSocket().close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });
    }

}
