package login.teacher;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import mysql.Connect;

public class StuBase extends JFrame{
	/**
	 * 自定义表格测试
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JButton add,change,delete;
	private JTextField jid,jtn,jsd,jtan,jtans,jtax;
	DefaultTableModel tableModel;
	Connect cn = new Connect();
	Object[][] data = cn.getBase();
	String[] header =  new String[] { "学号", "姓名", "年龄", "性别", "学院", "班级"};
	
	public StuBase(){
		super();
		this.setTitle("学生信息查询");
		this.setSize(700,540);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jpbg = new JPanel();
		 setContentPane(jpbg);
		 GridLayout gird = new GridLayout(3,0);
		 jpbg.setLayout(gird);
		 ImageIcon img = new ImageIcon("images\\4.jfif");
		 JLabel imgLabel = new JLabel(img);
		 getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//, new Integer(Integer.MIN_VALUE)
		 imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		 getLayeredPane().setLayout(null);
		 jpbg.setOpaque(false);
		 this.setLayout(null);
		 
		 Container cp = getContentPane();

		 JLabel lbid = new JLabel();
		 lbid.setText("学号:");
		 lbid.setForeground(Color.red);
		 lbid.setBounds(30,30,80,30);
		 lbid.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 cp.add(lbid);
		 
		 jid = new JTextField();
		 jid.setBounds(110,30,200,30);
		 jid.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jid);
		 
		 JLabel lbna = new JLabel();
		 lbna.setText("姓名:");
		 lbna.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbna.setForeground(Color.red);
		 lbna.setBounds(350,30,80,30);
		 cp.add(lbna);
		 
		 jtn = new JTextField();
		 jtn.setBounds(430,30,200,30);
		 jtn.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jtn);
		 
		 JLabel lsd = new JLabel();
		 lsd.setText("学院:");
		 lsd.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lsd.setForeground(Color.red);
		 lsd.setBounds(30,130,80,30);
		 cp.add(lsd);
		 
		 jsd = new JTextField();
		 jsd.setBounds(110,130,200,30);
		 jsd.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jsd);

		 JLabel lba = new JLabel();
		 lba.setText("年龄:");
		 lba.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lba.setForeground(Color.red);
		 lba.setBounds(350,130,80,30);
		 cp.add(lba);
		 
		 jtan = new JTextField();
		 jtan.setBounds(430,130,200,30);
		 jtan.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jtan);
		 
		 JLabel lbs = new JLabel();
		 lbs.setText("班级:");
		 lbs.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbs.setForeground(Color.red);
		 lbs.setBounds(30,230,80,30);
		 cp.add(lbs);
		 
		 jtans = new JTextField();
		 jtans.setBounds(430,230,200,30);
		 jtans.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jtans);
		 

		 JLabel lbsx = new JLabel();
		 lbsx.setText("性别:");
		 lbsx.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbsx.setForeground(Color.red);
		 lbsx.setBounds(350,230,80,30);
		 cp.add(lbsx);
		 
		 jtax = new JTextField();
		 jtax.setBounds(110,230,200,30);
		 jtax.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jtax);
		 
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 300, 500, 200);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		
		tableModel = new DefaultTableModel(data,header);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		scrollPane.setViewportView(table);//创建一个视口，并在括号内设置其视图
		
		TableColumn column = null;
		column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(100);
		column = table.getColumnModel().getColumn(1);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(2);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(3);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(4);
		column.setPreferredWidth(100);
		column = table.getColumnModel().getColumn(5);
		column.setPreferredWidth(100);
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow();
				Object oid = tableModel.getValueAt(selectedRow, 0);
				Object otn = tableModel.getValueAt(selectedRow, 1);
				Object otan = tableModel.getValueAt(selectedRow, 2);
				Object otans = tableModel.getValueAt(selectedRow, 3);		
				Object osd = tableModel.getValueAt(selectedRow, 4);
				Object otax = tableModel.getValueAt(selectedRow, 5);

				jid.setText(oid.toString());
				jtn.setText(otn.toString());
				jtan.setText(otan.toString());
				jtans.setText(otans.toString());
				jsd.setText(osd.toString());
				jtax.setText(otax.toString());
			}
		});
		
		add = new JButton("添加学生信息");
		add.setFont(new Font("宋体", Font.PLAIN, 16));
		add.setBounds(540,310,140,30);
		getContentPane().add(add);
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//添加学生信息窗体：
				setVisible(false);
				AddStudentBase ad = new AddStudentBase();
				ad.setVisible(true);
			}
		});
		
		change = new JButton("修改学生信息");
		change.setFont(new Font("宋体", Font.PLAIN, 16));
		change.setBounds(540,380,140,30);
		getContentPane().add(change);
		change.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//修改学生信息窗体：
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					Object oid = tableModel.getValueAt(selectedRow, 0);
					setVisible(false);
					ChangeBase cb = new ChangeBase(oid.toString());
					cb.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "您还没有选择！");
				}
			}
		});
		
		delete = new JButton("删除学生信息");
		delete.setFont(new Font("宋体", Font.PLAIN, 16));
		delete.setBounds(540,450,140,30);
		getContentPane().add(delete);
		delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//删除指定行的学生信息：
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					int answer1 = JOptionPane.showConfirmDialog(null, "确定删除？", "删除学生", JOptionPane.YES_NO_OPTION);
					if(answer1 == 0){
						Object oid = tableModel.getValueAt(selectedRow, 0);
						tableModel.removeRow(selectedRow);
						cn.deletebase(oid.toString());
						JOptionPane.showMessageDialog(null, "成功删除学号为"+oid.toString()+"的同学！");
						jid.setText("");
						jtn.setText("");
						jtan.setText("");
						jtans.setText("");
						jsd.setText("");
						jtax.setText("");
						int answer2 = JOptionPane.showConfirmDialog(null, "是否同步删除账号以及信息？", "删除信息", JOptionPane.YES_NO_OPTION);
						if(answer2 == 0){
							cn.deleteacount(oid.toString());
							cn.deletecourse(oid.toString());
							JOptionPane.showMessageDialog(null, "已成功删除！");
						}
					}	
				}else {
					JOptionPane.showMessageDialog(null, "您还没有选择！");
				}
			}
		});
	}
	
	public static void main(String args []){
		StuBase ja = new StuBase();
		ja.setVisible(true);
	}
}
