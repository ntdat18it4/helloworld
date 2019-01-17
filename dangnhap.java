package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class dangnhap extends JFrame {
	private	Connection conn;
	private Statement stm;
	private JPanel contentPane;
	private JTextField tftaikhoan;
	private JPasswordField tfmatkhau;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap frame = new dangnhap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public dangnhap() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbldangnhap = new JLabel("Tài khoản");
		lbldangnhap.setBounds(35, 62, 56, 16);
		contentPane.add(lbldangnhap);
		
		JLabel lblmatkhau = new JLabel("Mật khẩu");
		lblmatkhau.setBounds(35, 131, 56, 16);
		contentPane.add(lblmatkhau);
		
		tftaikhoan = new JTextField();
		tftaikhoan.setBounds(147, 59, 157, 22);
		contentPane.add(tftaikhoan);
		tftaikhoan.setColumns(10);
		
		tfmatkhau = new JPasswordField();
		tfmatkhau.setBounds(147, 128, 157, 22);
		contentPane.add(tfmatkhau);
		
		JButton btndangnhap = new JButton("Đăng nhập");
		btndangnhap.setBounds(114, 200, 97, 25);
		contentPane.add(btndangnhap);
		
		JButton btnthoat = new JButton("Thoát");
		btnthoat.setBounds(251, 200, 97, 25);
		contentPane.add(btnthoat);
		btnthoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btndangnhap.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					Connection conn = DriverManager.getConnection("jdbc:sqlserver://MAYTINH\\SQLEXPRESS;databaseName=quanlybenhnhan;integratedSecurity=TRUE");
					if (tftaikhoan.getText().equals("")||tfmatkhau.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Nhập lại.");
					else
					{
					PreparedStatement st = conn.prepareStatement("Select * from taikhoan where taikhoan=? and matkhau=?");
					st.setString(1, tftaikhoan.getText());
					st.setString(2, tfmatkhau.getText());
					ResultSet rs = st.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công.");
					new thongtinbn("Thông tin bệnh nhân");
						}
					else JOptionPane.showMessageDialog(null, "Đăng nhập thất bại.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
	}
}
