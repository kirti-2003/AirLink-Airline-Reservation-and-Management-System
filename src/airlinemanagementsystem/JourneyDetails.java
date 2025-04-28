
package airlinemanagementsystem;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener{
   JTable table;
   JTextField jpnr;
   JButton show;
    public JourneyDetails() {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel pnr=new JLabel("PNR details");
        pnr.setBounds(50,50,100,25);
        pnr.setFont(new Font("Times New Roman",Font.PLAIN,16));
        add(pnr);
        
        jpnr=new JTextField();
        jpnr.setBounds(160,50,120,25);
        add(jpnr);
        
        show=new JButton("Show Details");
         show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290, 50, 120, 25);
        show.addActionListener(this);
        add(show);
        
        
        table = new JTable();
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 100, 800, 150);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        
        setSize(800, 500);
        setLocation(400, 200);
        setVisible(true);
    }
       @Override
    public void actionPerformed(ActionEvent ae) {
     try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where PNR = '"+jpnr.getText()+"'");
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(null, "No Information Found");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            e.printStackTrace();
        }  }
    
     public static void main(String []args){
         new JourneyDetails();
     }

  
    
}
