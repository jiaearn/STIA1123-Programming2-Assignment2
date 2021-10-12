package my.husco;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class NextDayPage extends JFrame implements ActionListener {

    JRadioButton yes, no, document, parcel, z1, z2, z3, z4, z5;
    JLabel l1, l2, l3, l4, l5;
    ButtonGroup bg1, bg2, bg3;
    JButton conT, save, mainMenu, reset;
    JFrame frame;
    JTable table;
    JScrollPane sp;
    JTextField weight, quantity;

    public NextDayPage() {

        l1 = new JLabel();
        l1.setText("Are you sure want to enter Next-Day Delivery?");
        add(l1);
        l1.setBounds(25, 5, 450, 50);

        yes = new JRadioButton("YES");
        yes.setSelected(true);
        yes.setBounds(50, 55, 100, 20);
        bg1 = new ButtonGroup();
        bg1.add(yes);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(50, 85, 100, 20);
        bg1.add(no);
        add(no);

        conT = new JButton("Continue");
        conT.setBounds(125, 115, 100, 40);
        add(conT);
        conT.addActionListener(this);

        setResizable(false);
        setTitle("Next-Day Delivery");
        setLayout(null);
        setLocation(650, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 210);

    }

    public void NextDayMenu() {

        frame = new JFrame();
        bg2 = new ButtonGroup();
        bg3 = new ButtonGroup();

        l2 = new JLabel();
        l2.setBounds(20, 260, 180, 50);
        l2.setText("Please select a type : ");
        frame.add(l2);

        document = new JRadioButton("Document");
        document.setBounds(180, 275, 150, 20);
        bg2.add(document);
        frame.add(document);

        parcel = new JRadioButton("Parcel");
        parcel.setBounds(180, 295, 150, 20);
        bg2.add(parcel);
        frame.add(parcel);

        l3 = new JLabel();
        l3.setBounds(20, 330, 180, 50);
        l3.setText("Please select a zone : ");
        frame.add(l3);

        z1 = new JRadioButton("Zone 1: City");
        z1.setBounds(180, 345, 400, 20);
        bg3.add(z1);
        frame.add(z1);

        z2 = new JRadioButton("Zone 2: In Peninsular Malaysia, Sarawak and Sabah");
        z2.setBounds(180, 365 ,400, 20);
        bg3.add(z2);
        frame.add(z2);

        z3 = new JRadioButton("Zone 3: Between Sabah and Sarawak");
        z3.setBounds(180, 385, 400, 20);
        bg3.add(z3);
        frame.add(z3);

        z4 = new JRadioButton("Zone 4: Between Peninsular Malaysia and Sarawak");
        z4.setBounds(180, 405, 400, 20);
        bg3.add(z4);
        frame.add(z4);

        z5 = new JRadioButton("Zone 5: Between Peninsular Malaysia and Sabah");
        z5.setBounds(180, 425, 400, 20);
        bg3.add(z5);
        frame.add(z5);

        l4 = new JLabel();
        l4.setBounds(20, 460, 180, 50);
        l4.setText("Please enter weight (gm) : ");
        frame.add(l4);

        weight = new JTextField();
        weight.setBounds(180, 475, 150, 25);
        frame.add(weight);

        l5 = new JLabel();
        l5.setBounds(20, 510, 180, 50);
        l5.setText("Please enter quantity : ");
        frame.add(l5);

        quantity = new JTextField();
        quantity.setBounds(180, 525, 150, 25);
        frame.add(quantity);

        reset = new JButton("Reset");
        reset.setBounds(95, 575, 110, 30);
        reset.addActionListener(this);
        frame.add(reset);

        save = new JButton("Save");
        save.setBounds(260, 575, 110, 30);
        save.addActionListener(this);
        frame.add(save);

        mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(650, 575, 125, 30);
        mainMenu.addActionListener(this);
        frame.add(mainMenu);

        String[] packageType = {"", "Document (below 2kg)" ,"", "Parcel (above 2kg)", ""};
        String[][] data =
                {
                        {"Zone", "First 500gm", "Subsequent 250gm", "2.001-2.5kg", "Subsequent 500gm"},
                        {"Zone 1", "4.90", "0.80", "10.50", "0.50"},
                        {"Zone 2", "5.40", "1.00", "16.00", "2.00"},
                        {"Zone 3", "6.90", "1.50", "21.00", "3.00"},
                        {"Zone 4", "7.40", "1.50", "26.00", "3.50"},
                        {"Zone 5", "7.90", "2.00", "31.00", "4.00"},
                        {"", "", "", "", "All charges in RM"},
                };

        table = new JTable(data, packageType);

        JTableHeader header = table.getTableHeader();
        int headerHeight = 30;
        header.setPreferredSize(new Dimension(100, headerHeight));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setRowHeight(30);
        table.setEnabled(false);
        sp = new JScrollPane(table);
        sp.setBounds(10, 10, 900, 243);
        frame.add(sp);

        frame.setTitle("Next-Day Delivery");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(930, 680);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == conT) {
            if (yes.isSelected()) {
                NextDayMenu();
                this.dispose();
            }
            if (no.isSelected()) {
                new MenuPage();
                this.dispose();
            }
        }

        if (e.getSource() == save) {
            if (bg2.getSelection() == null || bg3.getSelection() == null || weight.getText().isEmpty() || quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some questions have not been filled.", "Next-Day Delivery", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Data has been saved.", "Next-Day Delivery", JOptionPane.INFORMATION_MESSAGE);
                bg2.clearSelection();
                bg3.clearSelection();
                weight.setText(null);
                quantity.setText(null);
            }
        }
        if (e.getSource() == mainMenu) {
            new MenuPage();
            frame.dispose();
        }
        if (e.getSource() == reset) {
            bg2.clearSelection();
            bg3.clearSelection();
            weight.setText(null);
            quantity.setText(null);
        }

    }

}
