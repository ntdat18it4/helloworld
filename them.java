package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class them extends JFrame {
	Connection conn;
	Statement stm;
	ResultSet rst;
	
	private JPanel contentPane;
	private JTextField tfmabn;
	private JTextField tfhoten;
	private JTextField tfgioitinh;
	private JTextField tftuoi;
	private JTextField tfcmnd;
	private JTextField tfdiachi;
	private JTextField tfngay;
	private JTextField tfbenhly;
	thongtinbn ttbn;

	public them(thongtinbn bn) {
		setTitle("Thêm");
		ttbn = bn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblmabn = new JLabel("Mã bệnh nhân :");
		lblmabn.setBounds(12, 23, 102, 16);
		contentPane.add(lblmabn);
		
		JLabel lblhoten = new JLabel("Họ tên :");
		lblhoten.setBounds(12, 71, 56, 16);
		contentPane.add(lblhoten);
		
		JLabel lblgioitinh = new JLabel("Giới tính :");
		lblgioitinh.setBounds(12, 121, 56, 16);
		contentPane.add(lblgioitinh);
		
		JLabel lblcmnd = new JLabel("Số CMND :");
		lblcmnd.setBounds(12, 232, 67, 16);
		contentPane.add(lblcmnd);
		
		JLabel lbldiachi = new JLabel("Địa chỉ :");
		lbldiachi.setBounds(12, 292, 56, 16);
		contentPane.add(lbldiachi);
		
		JLabel lbltuoi = new JLabel("Tuổi :");
		lbltuoi.setBounds(12, 179, 56, 16);
		contentPane.add(lbltuoi);
		
		JLabel lblngay = new JLabel("Ngày nhập viện :");
		lblngay.setBounds(12, 354, 102, 16);
		contentPane.add(lblngay);
		
		JLabel lblbenhly = new JLabel("Bệnh lý :");
		lblbenhly.setBounds(12, 415, 56, 16);
		contentPane.add(lblbenhly);
		
		tfmabn = new JTextField();
		tfmabn.setBounds(177, 20, 116, 22);
		contentPane.add(tfmabn);
		tfmabn.setColumns(10);
		
		tfhoten = new JTextField();
		tfhoten.setBounds(177, 68, 116, 22);
		contentPane.add(tfhoten);
		tfhoten.setColumns(10);
		
		tfgioitinh = new JTextField();
		tfgioitinh.setBounds(177, 118, 116, 22);
		contentPane.add(tfgioitinh);
		tfgioitinh.setColumns(10);
		
		tftuoi = new JTextField();
		tftuoi.setBounds(177, 176, 116, 22);
		contentPane.add(tftuoi);
		tftuoi.setColumns(10);
		
		tfcmnd = new JTextField();
		tfcmnd.setBounds(177, 229, 116, 22);
		contentPane.add(tfcmnd);
		tfcmnd.setColumns(10);
		
		tfdiachi = new JTextField();
		tfdiachi.setBounds(177, 289, 116, 22);
		contentPane.add(tfdiachi);
		tfdiachi.setColumns(10);
		
		tfngay = new JTextField();
		tfngay.setBounds(177, 351, 116, 22);
		contentPane.add(tfngay);
		tfngay.setColumns(10);
		
		tfbenhly = new JTextField();
		tfbenhly.setBounds(177, 412, 116, 22);
		contentPane.add(tfbenhly);
		tfbenhly.setColumns(10);
		
		JButton btnthem = new JButton("Thêm");
		btnthem.setBounds(109, 465, 97, 25);
		contentPane.add(btnthem);
		btnthem.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String mabn = tfmabn.getText();
					String hoten = tfhoten.getText();
					String gioitinh = tfgioitinh.getText();
					String tuoi = tftuoi.getText();
					String cmnd = tfcmnd.getText();
					String diachi = tfdiachi.getText();
					String ngay = tfngay.getText();
					String benhly = tfbenhly.getText();
					
					String sql = "Insert into benhnhan values ("+mabn+",'"+hoten+"','"+gioitinh+"',"+tuoi+","+cmnd+",'"+diachi+"','"+ngay+"','"+benhly+"')";
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					conn = DriverManager.getConnection("jdbc:sqlserver://MAYTINH\\SQLEXPRESS;databaseName=quanlybenhnhan;integratedSecurity=TRUE");
					stm = conn.createStatement();
					stm.executeUpdate(sql);
					ttbn.reload();
					ttbn.model.fireTableDataChanged();
				} catch ( Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi");
				}
			}
		});
		
		JButton lblthoat = new JButton("Thoát");
		lblthoat.setBounds(231, 465, 97, 25);
		contentPane.add(lblthoat);
		lblthoat.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				 dispose();
			}
		});
		this.setSize(445,550);
		this.setVisible(true);
	}

}
