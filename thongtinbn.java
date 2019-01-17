package GiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class thongtinbn extends JFrame implements ActionListener,MouseListener {
	
	Connection conn;
	Statement stm;
	ResultSet rst;
	Vector VData = new Vector();
	Vector VTitle = new Vector();
	JScrollPane tableResult;
	DefaultTableModel model;
	JTable tb = new JTable();
	JButton  btnsua, btnxoa, btnthem, btntim;
	JTextField tftim;
	int selectedrow = 0;
	public thongtinbn(String s) {
		super(s);
		try
		{
			tftim = new JTextField("20");
			JPanel p = new JPanel();
			btnsua = new JButton("Chỉnh sửa");
			btnsua.addActionListener(this);
			btnxoa = new JButton("Xóa");
			btnxoa.addActionListener(this);
			btnthem = new JButton("Thêm");
			btnthem.addActionListener(this);
			btntim = new JButton("Tìm kiếm");
			btntim.addActionListener(this);
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://MAYTINH\\SQLEXPRESS;databaseName=quanlybenhnhan;integratedSecurity=TRUE");
			stm = conn.createStatement();
			p.add(btnsua);
			p.add(btnxoa);
			p.add(btnthem);
			p.add(btntim);
			
			getContentPane().add(p, "South");
			reload();
			model = new DefaultTableModel(VData,VTitle);
			tb = new JTable(model);
			tb.addMouseListener(this);
			tableResult = new JScrollPane(tb);
			this.getContentPane().add(tableResult, "Center");
			this.setSize(1300, 700);
			this.setVisible(true);
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void reload()
	{
		try
		{
			VTitle.clear();
			VData.clear();
			ResultSet rst = stm.executeQuery("select * from benhnhan");
			ResultSetMetaData rstmeta = rst.getMetaData();
			int num_column = rstmeta.getColumnCount();
			VTitle.add("STT");
			for (int i=1;i<=num_column;i++)
			{
				VTitle.add(rstmeta.getColumnLabel(i));
			}
			int stt=0;
			while (rst.next())
			{
				stt++;
				Vector row = new Vector(num_column);
				row.add(String.valueOf(stt));
				for (int i=1;i<=num_column;i++)
					row.add(rst.getString(i));
					VData.add(row);
			}
			rst.close();
		}
		catch (Exception e1)
		{
			System.out.println(e1.getMessage());
		}
	}
	public void xoa()
	{
		try
		{
			Vector st = (Vector)VData.elementAt(selectedrow);
			stm.executeUpdate("Delete from benhnhan where mabn = '"+st.elementAt(1)+"'");
			VData.remove(selectedrow);
			model.fireTableDataChanged();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public void timkiem(String ten, String gt)
	{
		try {
			VTitle.clear();
			VData.clear();
			String sql = "select * from benhnhan where hoten like '%"+ten+"%' and gioitinh like '%"+gt+"%'" ;
			ResultSet rst = stm.executeQuery(sql);
			ResultSetMetaData rstmeta = rst.getMetaData();
			int num_column = rstmeta.getColumnCount();
			int STT=0;
			while (rst.next())
			{
				STT++;
				Vector row = new Vector(num_column);
				row.add(String.valueOf(STT));
				for (int i=1;i<=num_column;i++)
					row.add(rst.getString(i));
				VData.add(row);
			}
			rst.close();
			model.fireTableDataChanged();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
public static void main(String[] args) {
	new thongtinbn("Thông tin bệnh nhân");
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getActionCommand().equals("Xóa"))
	{
		xoa();
	}
	if(e.getActionCommand().equals("Tìm kiếm"))
	{
		new timkiem(this);
	}
	if(e.getActionCommand().equals("Chỉnh sửa"))
	{
		Vector bn = (Vector) VData.elementAt(selectedrow);
		new chinhsua(this, (String)bn.elementAt(1), (String)bn.elementAt(2), (String)bn.elementAt(3), (String)bn.elementAt(4), (String)bn.elementAt(5), (String)bn.elementAt(6), (String)bn.elementAt(7), (String)bn.elementAt(8));
	}
	if(e.getActionCommand().equals("Thêm"))
	{
		new them(this);
	}
}
@Override
public void mouseClicked(MouseEvent arg0) {
	// TODO Auto-generated method stub
		selectedrow = tb.getSelectedRow();
}
@Override
public void mouseEntered(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}

}
