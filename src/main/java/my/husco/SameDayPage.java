package my.husco;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class SameDayPage extends JFrame implements ActionListener {

    JRadioButton yes, no,localT,crossT;
    JLabel l1, l2,l3, l4;
    ButtonGroup bg = new ButtonGroup();
    JButton conT, save, mainMenu, reset;
    JFrame frame;
    JTable table;
    JScrollPane sp;
    JTextField weight, quantity;

    public SameDayPage() {

        l1 = new JLabel();
        l1.setText("Are you sure want to enter Same-Day Delivery?");
        add(l1);
        l1.setBounds(25, 5, 450, 50);

        yes = new JRadioButton("YES");
        yes.setSelected(true);
        yes.setBounds(50, 55, 100, 20);
        bg.add(yes);
        add(yes);

        no = new JRadioButton("NO");
        no.setBounds(50, 85, 100, 20);
        bg.add(no);
        add(no);

        conT = new JButton("Continue");
        conT.setBounds(125, 115, 100, 40);
        add(conT);
        conT.addActionListener(this);

        setResizable(false);
        setTitle("Same-Day Delivery");
        setLayout(null);
        setLocation(650, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 210);

    }

    public void SameDayMenu() {

        frame = new JFrame();

        l2 = new JLabel();
        l2.setBounds(20, 200, 180, 50);
        l2.setText("Please select a town : ");
        frame.add(l2);

        localT = new JRadioButton("Local Town");
        localT.setBounds(180, 215, 150, 20);
        bg.add(localT);
        frame.add(localT);

        crossT = new JRadioButton("Cross Town");
        crossT.setBounds(180, 235, 150, 20);
        bg.add(crossT);
        frame.add(crossT);

        l3 = new JLabel();
        l3.setBounds(20, 270, 180, 50);
        l3.setText("Please enter weight (gm) : ");
        frame.add(l3);

        weight = new JTextField();
        weight.setBounds(180, 285, 150, 25);
        frame.add(weight);

        l4 = new JLabel();
        l4.setBounds(20, 320, 180, 50);
        l4.setText("Please enter quantity : ");
        frame.add(l4);

        quantity = new JTextField();
        quantity.setBounds(180, 335, 150, 25);
        frame.add(quantity);

        save = new JButton("Save");
        save.setBounds(260, 385, 110, 30);
        save.addActionListener(this);
        frame.add(save);

        reset = new JButton("Reset");
        reset.setBounds(95, 385, 110, 30);
        reset.addActionListener(this);
        frame.add(reset);

        mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(650, 385, 125, 30);
        mainMenu.addActionListener(this);
        frame.add(mainMenu);

        String[] packageType = {"", "", "Local Town", "", "", "Cross Town", ""};
        String[][] data =
                {
                        {"Weight", "Domestic Charge", "Surcharge", "Total", "Domestic Charge", "Surcharge", "Total"},
                        {"Below 500gm", "4.90", "6.00", "10.90", "5.40", "7.50", "12.90"},
                        {"500gm - 750gm", "5.70", "6.00", "11.70", "6.40", "7.50", "13.90"},
                        {"750gm - 1kg  ", "6.50", "6.00", "12.50", "7.40", "7.50", "14.90"},
                        {"", "", "", "", "", "", "All charges in RM"},
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
        sp.setBounds(10, 10, 900, 183);
        frame.add(sp);

        frame.setTitle("Same-Day Delivery");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(930, 490);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == conT) {
            if (yes.isSelected()) {
                SameDayMenu();
                this.dispose();
            }
            if (no.isSelected()) {
                new MenuPage();
                this.dispose();
            }
        }

        if (e.getSource() == save) {
            if (bg.getSelection()==null||weight.getText().isEmpty() ||quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some questions have not been filled.", "Same-Day Delivery", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Data has been saved.", "Same-Day Delivery", JOptionPane.INFORMATION_MESSAGE);
                bg.clearSelection();
                weight.setText(null);
                quantity.setText(null);
            }
        }
        if (e.getSource() == mainMenu) {
            new MenuPage();
            frame.dispose();
        }
        if (e.getSource() == reset) {
            bg.clearSelection();
            weight.setText(null);
            quantity.setText(null);
        }

    }

}
