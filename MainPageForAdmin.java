package BigProject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageForAdmin extends JPanel {
    private Gui parent;
    private JLabel jLabel;
    private JButton createButton;
    private JButton changeButton;
    private JButton deleteButton;
    private JButton exitButton;

    public MainPageForAdmin(Gui parent){
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
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMain().setVisible(false);
                parent.getCreateMenu().setVisible(true);
            }
        });
        add(createButton);

        changeButton = new JButton("Change");
        changeButton.setSize(350, 30);changeButton.setLocation(170, 200);
        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getMain().setVisible(false);
                parent.getChangeMenu().setVisible(true);

            }
        });
        add(changeButton);

        deleteButton = new JButton("Delete");
        deleteButton.setSize(350, 30);
        deleteButton.setLocation(170, 250);
        add(deleteButton);

        exitButton = new JButton("Exit");
        exitButton.setSize(350, 30); exitButton.setLocation(170, 300); add(exitButton);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
