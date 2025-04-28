
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;


public class CheckBill extends JFrame implements ActionListener {
     JTextField textfield;
    JTable table;
    JLabel label, FlightCode, Price, JourneyD, JourneyT, UName, lables;

  

    CheckBill() {
        initialize();
    }

    private void initialize() {
        setTitle("Payment Details");
        getContentPane().setBackground(Color.white);
        setSize(900, 600);
        setLayout(null);

        JLabel Fcode = new JLabel("PNR NUMBER");
        Fcode.setFont(new Font("Times New Roman", Font.BOLD, 18));
        Fcode.setBounds(180, 160, 150, 26);
        add(Fcode);
        
        textfield = new JTextField();
        textfield.setBounds(320, 160, 150, 26);
        textfield.setFont(new Font("Times New Roman", Font.BOLD, 16));
        add(textfield);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 300, 800, 200);
        add(scrollPane);

        JButton show = new JButton("Show");
        show.setFont(new Font("Times New Roman", Font.BOLD, 16));
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(500, 160, 150, 24);
        show.addActionListener(this);
        add(show);

        label = new JLabel("Check Payment Details");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("Times New Roman", Font.BOLD, 33));
        label.setBounds(250, 20, 400, 40);
        add(label);
        
        FlightCode = new JLabel(" ");
        FlightCode.setForeground(Color.black);
        FlightCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
        FlightCode.setBounds(100, 270, 100, 26);
        add(FlightCode);

        Price = new JLabel(" ");
        Price.setForeground(Color.black);
        Price.setFont(new Font("Times New Roman", Font.BOLD, 16));
        Price.setBounds(220, 270, 100, 26);
        add(Price);

        JourneyD = new JLabel(" ");
        JourneyD.setForeground(Color.black);
        JourneyD.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JourneyD.setBounds(340, 270, 120, 26);
        add(JourneyD);

        JourneyT = new JLabel(" ");
        JourneyT.setForeground(Color.black);
        JourneyT.setFont(new Font("Times New Roman", Font.BOLD, 16));
        JourneyT.setBounds(470, 270, 120, 26);
        add(JourneyT);
        UName = new JLabel("");
        UName.setForeground(Color.black);
        UName.setFont(new Font("Times New Roman", Font.BOLD, 16));
        UName.setBounds(600, 270, 100, 26);
        add(UName);

        lables = new JLabel(" ");
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/flying.png"));
        Image i2 = ic.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(i2);
        lables.setIcon(ic1);
        lables.setBounds(0, 0, 900, 600);
        add(lables);

        setLocation(200, 50);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String fc = textfield.getText();
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select TICKET,price,ddate,timing,name from reservation where PNR = '" + fc + "' ");
            if (!rs.isBeforeFirst()) { // empty
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();

    }
    
}
      public static void main(String args[]) {
        new CheckBill();
    }
}