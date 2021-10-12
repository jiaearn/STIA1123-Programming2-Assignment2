package my.husco;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class PosEkspresPage extends JFrame implements ActionListener {

    JRadioButton yes, no, lG, lE, lD, lK;
    JLabel l1, l2, l3;
    ButtonGroup bg = new ButtonGroup();
    JButton conT, save, mainMenu, reset;
    JFrame frame;
    JTable table;
    JScrollPane sp;
    JTextField quantity;

    public PosEkspresPage() {

        l1 = new JLabel();
        l1.setText("Are you sure want to enter Pos Ekspres?");
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
        setTitle("Pos Ekspres");
        setLayout(null);
        setLocation(650, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 210);

    }

    public void PosEkspresMenu(){

        frame = new JFrame();

        l2 = new JLabel();
        l2.setBounds(20, 170, 160, 50);
        l2.setText("Please select a type : ");
        frame.add(l2);

        lG = new JRadioButton("LG");
        lG.setBounds(160, 185, 150, 20);
        bg.add(lG);
        frame.add(lG);

        lE = new JRadioButton("LE (C5)");
        lE.setBounds(160, 205, 150, 20);
        bg.add(lE);
        frame.add(lE);

        lD = new JRadioButton("LD (B4)");
        lD.setBounds(160, 225, 150, 20);
        bg.add(lD);
        frame.add(lD);

        lK = new JRadioButton("LK");
        lK.setBounds(160, 245, 150, 20);
        bg.add(lK);
        frame.add(lK);

        l3 = new JLabel();
        l3.setBounds(20, 280, 160, 50);
        l3.setText("Please enter quantity : ");
        frame.add(l3);

        quantity = new JTextField();
        quantity.setBounds(160, 295, 150, 25);
        frame.add(quantity);

        save = new JButton("Save");
        save.setBounds(260, 345, 110, 30);
        save.addActionListener(this);
        frame.add(save);

        reset = new JButton("Reset");
        reset.setBounds(95, 345, 110, 30);
        reset.addActionListener(this);
        frame.add(reset);

        mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(650, 345, 125, 30);
        mainMenu.addActionListener(this);
        frame.add(mainMenu);

        String[] standardType = {"Type", "LG", "LE(C5)", "LD(B4)", "LK"};
        String[][] data =
                {
                        {"Size", "220mm x 110mm", "229mm x 162mm", "353mm x 250mm", "340mm x 250mm"},
                        {"Max Weight", "100gm", "250gm", "500gm", "1000gm"},
                        {"Max Thickness", "3mm", "5mm", "10mm", "25mm"},
                        {"Price", "RM 3.18", "RM 3.71", "RM 4.77", "RM 7.42"}
                };

        table = new JTable(data,standardType);

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
        sp.setBounds(10, 10, 900, 153);
        frame.add(sp);

        frame.setTitle("Pos Ekspres");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(930, 450);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == conT) {
            if (yes.isSelected()) {
                PosEkspresMenu();
                this.dispose();
            }
            if (no.isSelected()) {
                new MenuPage();
                this.dispose();
            }
        }

        if (e.getSource() == save) {
            if (bg.getSelection() == null || quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some questions have not been filled.", "Pos Ekspres", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Data has been saved.", "Pos Ekspres", JOptionPane.INFORMATION_MESSAGE);
                bg.clearSelection();
                quantity.setText(null);
            }
        }
        if (e.getSource() == mainMenu) {
            new MenuPage();
            frame.dispose();
        }
        if (e.getSource() == reset) {
            bg.clearSelection();
            quantity.setText(null);
        }

    }

}
