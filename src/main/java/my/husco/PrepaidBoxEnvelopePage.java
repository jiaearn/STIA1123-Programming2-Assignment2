package my.husco;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

public class PrepaidBoxEnvelopePage extends JFrame implements ActionListener {

    JRadioButton yes, no, eS, eL, pBS, pBM, pBL;
    JLabel l1, l2, l3;
    ButtonGroup bg = new ButtonGroup();
    JButton conT, save, mainMenu, reset;
    JFrame frame;
    JTable table;
    JScrollPane sp;
    JTextField quantity;

    public PrepaidBoxEnvelopePage() {

        l1 = new JLabel();
        l1.setText("Are you sure want to enter Prepaid Box & Envelope?");
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
        setTitle("Prepaid Box & Envelope");
        setLayout(null);
        setLocation(650, 250);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 210);

    }

    public void PrepaidBoxEnvelopeMenu() {

        frame = new JFrame();

        l2 = new JLabel();
        l2.setBounds(20, 140, 160, 50);
        l2.setText("Please select a type : ");
        frame.add(l2);

        eS = new JRadioButton("Envelope S (ES)");
        eS.setBounds(160, 155, 150, 20);
        bg.add(eS);
        frame.add(eS);

        eL = new JRadioButton("Envelope L (EL)");
        eL.setBounds(160, 175, 150, 20);
        bg.add(eL);
        frame.add(eL);

        pBS = new JRadioButton("Prepaid Box S (PBS)");
        pBS.setBounds(160, 195, 150, 20);
        bg.add(pBS);
        frame.add(pBS);

        pBM = new JRadioButton("Prepaid Box M (PBM)");
        pBM.setBounds(160, 215, 150, 20);
        bg.add(pBM);
        frame.add(pBM);

        pBL = new JRadioButton("Prepaid Box L (PBL)");
        pBL.setBounds(160, 235, 150, 20);
        bg.add(pBL);
        frame.add(pBL);

        l3 = new JLabel();
        l3.setBounds(20, 270, 160, 50);
        l3.setText("Please enter quantity : ");
        frame.add(l3);

        quantity = new JTextField();
        quantity.setBounds(160, 285, 150, 25);
        frame.add(quantity);

        save = new JButton("Save");
        save.setBounds(260, 335, 110, 30);
        save.addActionListener(this);
        frame.add(save);

        reset = new JButton("Reset");
        reset.setBounds(95, 335, 110, 30);
        reset.addActionListener(this);
        frame.add(reset);

        mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(650, 335, 125, 30);
        mainMenu.addActionListener(this);
        frame.add(mainMenu);

        String[] standardType = {"Type", "Envelope S (ES)", "Envelope L (EL)", "Prepaid Box S (PBS)", "Prepaid Box M (PBM)", "Prepaid Box L (PBL)"};
        String[][] data =
                {
                        {"Size", "280mm x 200mm", "380mm x 320mm", "380mm x 250mm x 80mm", "340mm x 250mm x 150mm", "380mm x 320mm x 200mm"},
                        {"Max Weight", "500g", "1kg", "2kg", "5kg", "10kg"},
                        {"Price", "RM 7.31", "RM 10.49", "RM 13.78", "RM 21.20", "RM 31.80"}
                };

        table = new JTable(data, standardType);

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
        sp.setBounds(10, 10, 900, 123);
        frame.add(sp);

        frame.setTitle("Prepaid Box & Envelope");
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setSize(930, 440);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == conT) {
            if (yes.isSelected()) {
                PrepaidBoxEnvelopeMenu();
                this.dispose();
            }
            if (no.isSelected()) {
                new MenuPage();
                this.dispose();
            }
        }

        if (e.getSource() == save) {
            if (bg.getSelection() == null || quantity.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Some questions have not been filled.", "Prepaid Box & Envelope", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, "Data has been saved.", "Prepaid Box & Envelope", JOptionPane.INFORMATION_MESSAGE);
                bg.clearSelection();
                quantity.setText(null);}
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
