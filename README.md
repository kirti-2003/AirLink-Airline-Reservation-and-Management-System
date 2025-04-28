Project Description
AirLink: Airline Reservation and Management System is a Java-based desktop application developed using Apache NetBeans IDE. The system facilitates the complete management of an airline's operations like flight booking, customer management, flight details, billing, and ticket cancellation.
The application uses MySQL as the backend database to store and retrieve all airline-related information efficiently. The database connection is established through JDBC.

Key Modules and How It Works

1.Login System (Login.java)
Users must first log in with a username and password.
Valid credentials are verified from the login table in the MySQL database.
Upon successful login, the user is redirected to the Home screen.

2.Home Dashboard (Home.java)
A graphical interface (JFrame) providing a menu to access various modules like Add Customer, Book Flight, Journey Details, Cancel Ticket, Boarding Pass, and Billing.

3.Customer Management (AddCustomer.java)
Adds new customer details like name, nationality, phone, address, gender, and Aadhar number.
Data is stored in the passenger table in MySQL.

4.Flight Information Display (FlightInfo.java)
Fetches and displays all available flights from the flight table.
Helps users choose flights based on source and destination.

5.Flight Booking (BookFlight.java)
Customers can book flights by providing their Aadhar number.
The system fetches personal details and allows selection of flights based on source and destination.
Booking details like flight name, code, date, and price are saved into the reservation table.
Each booking generates a unique PNR (Passenger Name Record) and Ticket Number.

6.Journey Details (JourneyDetails.java)
Allows users to view detailed journey information by entering the PNR number.

7.Boarding Pass Generation (BoardingPass.java)
By providing a PNR number, the boarding pass is generated with complete passenger and flight details.

8.Ticket Cancellation (Cancel.java)
Users can cancel tickets by entering the PNR number.
Cancellation details are inserted into the cancel table and simultaneously removed from the reservation table.

9.Bill Checking (CheckBill.java)
Users can check the payment details linked to a specific PNR.
Displays ticket price, flight details, and passenger information.

10.Database Connectivity (Conn.java)
A reusable connection class using JDBC to connect the application to the MySQL database named airlinemanagementsystem.

11.Technologies Used
Frontend (GUI): Java Swing (JFrame, JPanel, JTable, etc.)
Backend Database: MySQL
Development Environment: Apache NetBeans
Libraries:
net.proteanit.sql.DbUtils for directly displaying SQL results into tables.

