import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LogingFrom {

	private JFrame frame;
	private JTextField textname;
	private JTextField textaddress;
	private JTextField textage;
	private JTextField textmobile;
	private JTextField textemail;
	private JTextField textpassword;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogingFrom window = new LogingFrom();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LogingFrom() {
		initialize();
		Connect();
		table_load();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	public void Connect()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/users","root","saif");

		}
		catch (ClassNotFoundException ex)
		{
			
		}
		catch(SQLException ex)
		{
			
		}
	}
	 public void table_load()
		
		{
			try 
			{
				pst = con.prepareStatement("select * from Registration");
				rs = pst.executeQuery();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	

	/**
	 * Initialize the contents of the frame.
	 */
	    private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Saif Ansari\\Pictures\\download.png"));
		frame.setBounds(100, 100, 626, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(20, 70, 75, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		textname = new JTextField();
		textname.setColumns(10);
		textname.setBounds(127, 70, 163, 32);
		frame.getContentPane().add(textname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Address:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(20, 142, 92, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(127, 124, 163, 67);
		frame.getContentPane().add(textaddress);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Age:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_1.setBounds(20, 228, 92, 26);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textage = new JTextField();
		textage.setColumns(10);
		textage.setBounds(127, 222, 163, 32);
		frame.getContentPane().add(textage);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Gender:");
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_2.setBounds(20, 278, 92, 26);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JRadioButton rbmale = new JRadioButton("Male");
		buttonGroup.add(rbmale);
		rbmale.setForeground(Color.WHITE);
		rbmale.setFont(new Font("Tahoma", Font.BOLD, 17));
		rbmale.setBackground(Color.BLACK);
		rbmale.setBounds(121, 278, 75, 23);
		frame.getContentPane().add(rbmale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		buttonGroup.add(rbFemale);
		rbFemale.setForeground(Color.WHITE);
		rbFemale.setFont(new Font("Tahoma", Font.BOLD, 17));
		rbFemale.setBackground(Color.BLACK);
		rbFemale.setBounds(198, 278, 92, 23);
		frame.getContentPane().add(rbFemale);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Mobile No:");
		lblNewLabel_1_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_3.setBounds(20, 328, 102, 26);
		frame.getContentPane().add(lblNewLabel_1_1_3);
		
		textmobile = new JTextField();
		textmobile.setColumns(10);
		textmobile.setBounds(127, 328, 163, 32);
		frame.getContentPane().add(textmobile);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Email:");
		lblNewLabel_1_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_4.setBounds(20, 385, 81, 26);
		frame.getContentPane().add(lblNewLabel_1_1_4);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(127, 385, 163, 32);
		frame.getContentPane().add(textemail);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Password:");
		lblNewLabel_1_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_1_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1_5.setBounds(20, 444, 102, 26);
		frame.getContentPane().add(lblNewLabel_1_1_5);
		
		textpassword = new JTextField();
		textpassword.setColumns(10);
		textpassword.setBounds(127, 444, 163, 32);
		frame.getContentPane().add(textpassword);
		
		JButton btnLoging = new JButton("Loging");
		btnLoging.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/users","root","saif");
					String query="insert into Registration values(?,?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
				 	ps.setString(1, textname.getText());
				 	
				 	ps.setString(2, textaddress.getText());
				 	
				   // ps.setInt(3, Integer.parseInt(textage.getText()));
				 	
				 	String ag=textage.getText();
				 	int agi=Integer.parseInt(ag);
				 	ps.setInt(3, agi);
				 	
				    if(rbmale.isSelected())
				    ps.setString(4, rbmale.getText());
		             else
					ps.setString(4, rbFemale.getText());
					ps.setString(5, textmobile.getText());
				 	ps.setString(6, textemail.getText());
				 	ps.setInt(7, Integer.parseInt(textpassword.getText()));
				 	
				 	int i= ps.executeUpdate();
				 	JOptionPane.showMessageDialog(btnLoging,i+ "Recored Add!!!!!!!!");
				 	ps.close();
				 	con.close();
					 	
				} catch (Exception e1) {
					
					e1.printStackTrace();
				} 
			
			}
		});
		btnLoging.setForeground(Color.BLACK);
		btnLoging.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLoging.setBounds(20, 511, 102, 39);
		frame.getContentPane().add(btnLoging);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textname.setText("");
				textaddress.setText("");
				textage.setText("");
				textmobile.setText("");
				textemail.setText("");
				textpassword.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnLogout.setForeground(Color.BLACK);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogout.setBounds(170, 511, 102, 39);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblNewLabel = new JLabel("MyRegistration From");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(127, 11, 346, 50);
		frame.getContentPane().add(lblNewLabel);
	}

}
