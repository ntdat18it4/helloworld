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
	import javax.swing.JTextField;
	import javax.swing.JButton;

	public class chinhsua extends JFrame {

		Connection conn;
		Statement stm;
		ResultSet rst;
		
		private JPanel contentPane;
		private JTextField tfmabn;
		private JTextField tfhoten;
		private JTextField tfgioitinh;
		private JTextField tftuoi;
		private JTextField tfdiachi;
		private JTextField tfngay;
		private JTextField tfbenhly;
		private JTextField tfcmnd;
		thongtinbn ttbn;
		
		public chinhsua(thongtinbn bn, String mabn, String hoten, String gioitinh, String tuoi, String cmnd, String diachi, String ngay, String benhly) {
			setTitle("Chỉnh Sửa");
			ttbn = bn;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 408, 541);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JLabel lblmabn = new JLabel("Mã bệnh nhân :");
			lblmabn.setBounds(25, 13, 90, 16);
			contentPane.add(lblmabn);
			
			JLabel lblhoten = new JLabel("Họ tên :");
			lblhoten.setBounds(25, 59, 56, 16);
			contentPane.add(lblhoten);
			
			JLabel lblgioitinh = new JLabel("Giới tính :");
			lblgioitinh.setBounds(25, 109, 56, 16);
			contentPane.add(lblgioitinh);
			
			JLabel lbltuoi = new JLabel("Tuổi :");
			lbltuoi.setBounds(25, 156, 56, 16);
			contentPane.add(lbltuoi);
			
			JLabel lblcmnd = new JLabel("Số CMND :");
			lblcmnd.setBounds(25, 208, 67, 16);
			contentPane.add(lblcmnd);
			
			JLabel lbldiachi = new JLabel("Địa chỉ :");
			lbldiachi.setBounds(25, 262, 56, 16);
			contentPane.add(lbldiachi);
			
			JLabel lblngay = new JLabel("Ngày nhập viện :");
			lblngay.setBounds(25, 316, 97, 16);
			contentPane.add(lblngay);
			
			JLabel lblbenhly = new JLabel("Bệnh lý :");
			lblbenhly.setBounds(25, 376, 56, 16);
			contentPane.add(lblbenhly);
			
			tfmabn = new JTextField(mabn);
			tfmabn.setBounds(160, 10, 116, 22);
			contentPane.add(tfmabn);
			tfmabn.setColumns(10);
			
			tfhoten = new JTextField(hoten);
			tfhoten.setBounds(160, 56, 116, 22);
			contentPane.add(tfhoten);
			tfhoten.setColumns(10);
			
			tfgioitinh = new JTextField(gioitinh);
			tfgioitinh.setBounds(160, 106, 116, 22);
			contentPane.add(tfgioitinh);
			tfgioitinh.setColumns(10);
			
			tftuoi = new JTextField(tuoi);
			tftuoi.setBounds(160, 153, 116, 22);
			contentPane.add(tftuoi);
			tftuoi.setColumns(10);
			
			tfdiachi = new JTextField(diachi);
			tfdiachi.setBounds(160, 259, 116, 22);
			contentPane.add(tfdiachi);
			tfdiachi.setColumns(10);
			
			tfngay = new JTextField(ngay);
			tfngay.setBounds(160, 313, 116, 22);
			contentPane.add(tfngay);
			tfngay.setColumns(10);
			
			tfbenhly = new JTextField(benhly);
			tfbenhly.setBounds(160, 373, 116, 22);
			contentPane.add(tfbenhly);
			tfbenhly.setColumns(10);
			
			tfcmnd = new JTextField(cmnd);
			tfcmnd.setBounds(160, 205, 116, 22);
			contentPane.add(tfcmnd);
			tfcmnd.setColumns(10);
			
			JButton btncapnhat = new JButton("Cập Nhật");
			btncapnhat.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
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
						
						String sql = "update benhnhan set hoten='"+hoten+"',gioitinh='"+gioitinh+"',tuoi="+tuoi+", cmnd="+cmnd+", diachi='"+diachi+"', ngaynhapvien='"+ngay+"', benhly='"+benhly+"' where mabn="+mabn+"";
						Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
						conn = DriverManager.getConnection("jdbc:sqlserver://MAYTINH\\SQLEXPRESS;databaseName=quanlybenhnhan;integratedSecurity=TRUE");
						stm = conn.createStatement();
						stm.executeUpdate(sql);
						ttbn.reload();
						ttbn.model.fireTableDataChanged();
					} catch ( Exception e) {
						e.printStackTrace();
					}
				}
			});
			btncapnhat.setBounds(87, 442, 97, 25);
			contentPane.add(btncapnhat);
			
			JButton btnthoat = new JButton("Thoát");
			btnthoat.setBounds(229, 442, 97, 25);
			contentPane.add(btnthoat);
		    btnthoat.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					 dispose();
				}
			});
			this.setSize(445,550);
			this.setVisible(true);
		}

	}
