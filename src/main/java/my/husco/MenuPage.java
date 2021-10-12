package my.husco;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPage extends JFrame implements ActionListener {

    JLabel l1;
    JButton nextDay, sameDay, prepaidBox, posEkspres, printR;
    JMenu menu, submenu;
    JMenuBar menuBar;
    JMenuItem menuItem1, menuItem2, menuItem3, menuItem4, menuItem5, menuItem6;
    JCheckBox checkBox;

    public MenuPage() {

        l1 = new JLabel();
        l1.setBounds(30, 25, 450, 50);
        l1.setText("Welcome to Pos Laju Malaysia");
        l1.setFont(new Font(l1.getFont().getName(), l1.getFont().getStyle(), 15));
        add(l1);

        menuBar = new JMenuBar();

        checkBox = new JCheckBox("Hide/Unhide Menu Bar");
        checkBox.setBounds(5, 5, 200, 20);
        checkBox.addActionListener(this);
        add(checkBox);

        menu = new JMenu("Menu");
        menuBar.add(menu);

        menuItem1 = new JMenuItem("Log Out");
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        menuItem2 = new JMenuItem("Exit");
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        menu = new JMenu("Help");
        menuBar.add(menu);

        submenu = new JMenu("Help?");
        menuItem3 = new JMenuItem("How to run this program?");
        menuItem3.addActionListener(this);
        submenu.add(menuItem3);
        menu.add(submenu);

        menuItem4 = new JMenuItem("Check for Updates");
        menuItem4.addActionListener(this);
        menu.add(menuItem4);

        menuItem5 = new JMenuItem("Contact Us");
        menuItem5.addActionListener(this);
        menu.add(menuItem5);

        menuItem6 = new JMenuItem("About Us");
        menuItem6.addActionListener(this);
        menu.add(menuItem6);

        nextDay = new JButton("Next-Day Delivery");
        nextDay.setBounds(55, 85, 180, 40);
        add(nextDay);
        nextDay.addActionListener(this);

        sameDay = new JButton("Same-Day Delivery");
        sameDay.setBounds(55, 135, 180, 40);
        add(sameDay);
        sameDay.addActionListener(this);

        prepaidBox = new JButton("Prepaid Box & Envelope");
        prepaidBox.setBounds(55, 185, 180, 40);
        add(prepaidBox);
        prepaidBox.addActionListener(this);

        posEkspres = new JButton("Pos Ekspres");
        posEkspres.setBounds(55, 235, 180, 40);
        add(posEkspres);
        posEkspres.addActionListener(this);

        printR = new JButton("Receipt");
        printR.setBounds(55, 285, 180, 40);
        add(printR);
        printR.addActionListener(this);

        setResizable(false);
        setTitle("Pos Laju Malaysia");
        setLayout(null);
        setLocation(650, 250); //frame location
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setJMenuBar(menuBar);
        setSize(300, 410); //size of frame

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JTextArea jta = new JTextArea(5, 15);
        jta.setEditable(false);

        if (checkBox.isSelected()) {
            menuBar.setVisible(false);
        }
        else {
            menuBar.setVisible(true);
        }

        if (e.getSource() == nextDay) {
            new NextDayPage();
            this.dispose();
        }

        if (e.getSource() == sameDay) {
            new SameDayPage();
            this.dispose();
        }

        if (e.getSource() == prepaidBox) {
            new PrepaidBoxEnvelopePage();
            this.dispose();
        }

        if (e.getSource() == posEkspres) {
            new PosEkspresPage();
            this.dispose();
        }

        if (e.getSource() == printR) {
            JOptionPane.showMessageDialog(null, "List is empty.", "Receipt", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == menuItem1) {
            new LoginPage();
            this.dispose();
        }

        if (e.getSource() == menuItem2) {
            QuitMenu quitMenu = new QuitMenu();
            quitMenu.quitMenu1();
            this.dispose();
        }

        if (e.getSource() == menuItem3) {
            String msg =
                    "Step : " +
                    "\n1. Choose your service by click the button that you want to proceed." +
                    "\n2. Fulfil the form that have been provided for the service." +
                    "\n3. Click \"Save\". Then the data will be saved into system and system will calculate the total price for each service."+
                    "\n4. Back to \"Main Menu\". Choose another service if you want otherwise you can click the button \"Receipt\" to print the receipt." +
                    "\n5. After finish, you can log out your account at the menu bar." +
                    "\nThank you for choosing our system.";
            jta.setText(msg);
            JOptionPane.showMessageDialog(null, jta, "How to run this program?", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == menuItem4) {
            JOptionPane.showMessageDialog(this, "You are on the latest version.", "You're up to date!", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == menuItem5) {
            JOptionPane.showMessageDialog(this, "Call Our Service Centre. \n 017-*******", "Contact Us", JOptionPane.INFORMATION_MESSAGE);
        }

        if (e.getSource() == menuItem6) {
            String msg = "This system is designed by team Husco. \n\n Our Team Members: \n 1. Tan Jia Earn \n 2. Wong Fang Man \n\n";
            jta.setText(msg);
            JOptionPane.showMessageDialog(null, jta, "About Us", JOptionPane.INFORMATION_MESSAGE);
        }

    }

}
