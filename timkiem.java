package GiaoDien;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class timkiem extends JFrame {

	private JPanel contentPane;
	private JTextField tften;
	private JTextField tfgioitinh;
	thongtinbn ttbn;

	public timkiem(thongtinbn bn) {
		setTitle("TÌm Kiếm");
		ttbn = bn;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblten = new JLabel("Tên :");
		lblten.setBounds(22, 55, 56, 16);
		contentPane.add(lblten);
		
		JLabel lblgioitinh = new JLabel("Giới tính :");
		lblgioitinh.setBounds(22, 132, 56, 16);
		contentPane.add(lblgioitinh);
		
		tften = new JTextField();
		tften.setBounds(174, 52, 116, 22);
		contentPane.add(tften);
		tften.setColumns(10);
		
		tfgioitinh = new JTextField();
		tfgioitinh.setBounds(174, 129, 116, 22);
		contentPane.add(tfgioitinh);
		tfgioitinh.setColumns(10);
		
		JButton btntimkiem = new JButton("Tìm kiếm");
		btntimkiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String ten = tften.getText();
				String gt = tfgioitinh.getText();
				bn.timkiem(ten, gt);
			}
		});
		btntimkiem.setBounds(113, 185, 97, 25);
		contentPane.add(btntimkiem);
		
		JButton btnthoat = new JButton("Thoát");
		btnthoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 dispose();
			}
		});
		btnthoat.setBounds(237, 185, 97, 25);
		contentPane.add(btnthoat);
		this.setSize(445,306);
		this.setVisible(true);
	}
	
}
