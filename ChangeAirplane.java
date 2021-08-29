package BigProject;

import BigProject.Classes.Airplanes;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeAirplane extends JPanel {
    private final Gui parent;
    private final JLabel jLabel;
    private ArrayList<Airplanes> airplanes;
    private String[] header = {"ID","Name","Model","Business CC", "Economy CC"};
    private JTable table;
    private JScrollPane scrollPane;
    private JButton backB;

    public ChangeAirplane(Gui parent){
        this.parent = parent;

        setSize(700,600);
        setLayout(null);

        jLabel = new JLabel("Choose What To Change");
        jLabel.setFont(new Font("Calibri", Font.BOLD, 18));
        jLabel.setSize(300,30);
        jLabel.setLocation(250,100);
        add(jLabel);

        airplanes = parent.getAirplanes();

        table = new JTable(){
            private static final long serialVersionUID = 1L;

            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setFont(new Font("Calibri", Font.PLAIN, 13));
        table.setRowHeight(30);

        scrollPane = new JScrollPane(table);
        scrollPane.setSize(500,250);
        scrollPane.setLocation(100,150);
        add(scrollPane);

        backB = new JButton("Cancel");
        backB.setSize(300,30);
        backB.setLocation(200, 500);
        backB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.getChangeAirplane().setVisible(false);
                parent.getChangeMenu().setVisible(true);
            }
        });
        add(backB);
    }
    public void generateTable(ArrayList<Airplanes> airplanes){
        Object[][] data = new Object[airplanes.size()][5];
        for(int i = 0; i < airplanes.size(); i++) {
            if (airplanes.get(i) != null) {
                data[i][0] = airplanes.get(i).getId();
                data[i][1] = airplanes.get(i).getName();
                data[i][2] = airplanes.get(i).getModel();
                data[i][3] = airplanes.get(i).getBusiness_class_capacity();
                data[i][4] = airplanes.get(i).getEconomy_class_capacity();
            }
        }
        DefaultTableModel model = new DefaultTableModel(data, header);
        table.setModel(model);
    }

}
