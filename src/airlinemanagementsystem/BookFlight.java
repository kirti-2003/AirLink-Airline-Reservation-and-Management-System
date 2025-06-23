
package airlinemanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;



public class BookFlight extends JFrame implements ActionListener{
    
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode,labeltiming,labelprice;
    JButton bookflight, fetchButton, flight;
    Choice source,destination;
    JDateChooser dcdate;
     public BookFlight() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 80, 150, 25);
        add(tfaadhar);
        
        fetchButton = new JButton("Fetch User");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
       fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 330, 150, 25);       
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);       
        add(destination);
        
        try {
            Conn c = new Conn();
            String query = "select * from flight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 430, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220, 480, 150, 25);
        add(labelfcode);
        
        JLabel lbltiming = new JLabel("Timings");
        lbltiming.setBounds(60, 530, 150, 25);
        lbltiming.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lbltiming);
        
        labeltiming = new JLabel();
        labeltiming.setBounds(220, 530, 150, 25);
        add(labeltiming);
        
         JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 580, 150, 25);
        lblprice.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lblprice);
        
        labelprice = new JLabel();
        labelprice.setBounds(220, 580, 150, 25);
        add(labelprice);
        
        
        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 630, 150, 25);
        lbldate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220, 630, 150, 25);
        add(dcdate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(380, 630, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);
        
        setVisible(true);
        setSize(1100,800);
        setLocation(200, 20);

}   
      @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==fetchButton) {
        String aadhar = tfaadhar.getText();
       
        
        try {
            Conn c = new Conn();
            
            String query = "select * from passenger where aadhar='"+aadhar+"'";
        
            ResultSet rs= c.s.executeQuery(query);
            if (rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
            }else{
             JOptionPane.showMessageDialog(null, "User doesnot exist");
   
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    } else if(ae.getSource()==flight) {
        String src=source.getSelectedItem();
        String dest=destination.getSelectedItem();
       
        
        try {
            Conn c = new Conn();
            
            String query = "select * from flight where source='"+src+"'and destination='"+dest+"'";
        
            ResultSet rs= c.s.executeQuery(query);
            if (rs.next()){
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
               labeltiming.setText(rs.getString("timing"));
                labelprice.setText(rs.getString("price"));
            }else{
             JOptionPane.showMessageDialog(null, "No Flights Found");
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }else{
       Random random=new Random();
      String aadhar=tfaadhar.getText();
      String name= tfname.getText();
      String nationality=tfnationality.getText();
      String flightname= labelfname.getText();
      String flightcode=labelfcode.getText();
      String src= source.getSelectedItem();
      String dest=destination.getSelectedItem();
      String ddate= ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
      String timing=labeltiming.getText();
      String price=labelprice.getText();
       try {
            Conn c = new Conn();
            
              if (aadhar.isEmpty() || name.isEmpty() || nationality.isEmpty() || flightname.isEmpty() || flightcode.isEmpty() || src.isEmpty() || dest.isEmpty() || ddate.isEmpty()|| timing.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled");
                return;
            }
            if (!aadhar.matches("\\d{12}")) {
        JOptionPane.showMessageDialog(null, "Please enter a valid 12-digit Aadhaar number.");
        return;
    }
            if (dcdate.getDate() == null) {
        JOptionPane.showMessageDialog(null, "Please select a valid travel date.");
        return;
    }
    
    if (dcdate.getDate().before(new java.util.Date())) {
        JOptionPane.showMessageDialog(null, "Travel date cannot be in the past.");
        return;
    }

  
String pnr = "PNR-" + random.nextInt(1000000);
String ticket = "TIC-" + random.nextInt(10000);

// Your other variables like aadhar, name, etc., remain the same

String query = "INSERT INTO reservation VALUES('" + pnr + "', '" + ticket + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dest + "', '" + ddate + "', '" + timing + "', '" + price + "')";

c.s.executeUpdate(query);

// Show the PNR in a dialog box
JOptionPane.showMessageDialog(null, "Ticket Booked Successfully!\nYour PNR: " + pnr);

// Optionally, copy it to clipboard
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(pnr), null);

// Hide the form or return to home
setVisible(false);

            
}         catch (Exception e) {
            e.printStackTrace();
        }
            
        }  
    
    }

public static void main(String []args){
    new BookFlight();

}

  
    
}
