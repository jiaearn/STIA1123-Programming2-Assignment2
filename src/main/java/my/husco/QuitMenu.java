package my.husco;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitMenu extends JFrame implements ActionListener {

    JButton yes, no, no2;
    JLabel l;

    public void quitMenu1() {

        l = new JLabel();
        l.setText("Do you want to Exit?");
        add(l);
        l.setBounds(25, 5, 450, 50);

        yes = new JButton("Yes.");
        yes.setSelected(true);
        yes.setBounds(50, 65, 75, 35);
        yes.addActionListener(this);
        add(yes);

        no = new JButton("No.");
        no.setBounds(150, 65, 75, 35);
        no.addActionListener(this);
        add(no);

        no2 = new JButton("No.");
        no2.setBounds(150, 65, 75, 35);
        no2.addActionListener(this);
        add(no2);

        setResizable(false);
        setTitle("Confirm");
        setLayout(null);
        setLocation(650, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 175);

    }

    public void quitMenu2(){

        l = new JLabel();
        l.setText("Do you want to Exit?");
        add(l);
        l.setBounds(25, 5, 450, 50);

        yes = new JButton("Yes.");
        yes.setSelected(true);
        yes.setBounds(50, 65, 75, 35);
        yes.addActionListener(this);
        add(yes);

        no2 = new JButton("No.");
        no2.setBounds(150, 65, 75, 35);
        no2.addActionListener(this);
        add(no2);

        setResizable(false);
        setTitle("Confirm");
        setLayout(null);
        setLocation(650, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(275, 175);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == yes) {
            System.exit(0);
            JOptionPane.showMessageDialog(this, "Thank you and Bye. ", "Pos Laju Malaysia", JOptionPane.INFORMATION_MESSAGE);
        }
        if (e.getSource() == no) {
            new MenuPage();
            this.dispose();
        }
        if (e.getSource() == no2) {
            new LoginPage();
            this.dispose();
        }

    }

}
