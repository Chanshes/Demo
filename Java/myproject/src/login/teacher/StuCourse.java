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

public class StuCourse extends JFrame{
	/**
	 * 自定义表格测试
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JButton add,change,delete;
	private JTextField jd1,jd2,jd3,jd4,jd5,jd6,jd7,jd8,jd9;
	DefaultTableModel tableModel;
	Connect cn = new Connect();
	Object[][] data = cn.getCourses();
	String[] header =  new String[] { "学号", "姓名", "学期", "文学", "高数", "英语", "物联网", "健康", "Java"};
	
	public StuCourse(){
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
		 ImageIcon img = new ImageIcon("images\\night.jpg");
		 JLabel imgLabel = new JLabel(img);
		 getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));//, new Integer(Integer.MIN_VALUE)
		 imgLabel.setBounds(0,0,img.getIconWidth(), img.getIconHeight());
		 getLayeredPane().setLayout(null);
		 jpbg.setOpaque(false);
		 this.setLayout(null);
		 
		 Container cp = getContentPane();

		 JLabel lb1 = new JLabel();
		 lb1.setText("学号:");
		 lb1.setForeground(Color.red);
		 lb1.setBounds(30,30,80,30);
		 lb1.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 cp.add(lb1);
		 
		 jd1 = new JTextField();
		 jd1.setBounds(110,30,200,30);
		 jd1.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd1);
		 
		 JLabel lbna = new JLabel();
		 lbna.setText("姓名:");
		 lbna.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbna.setForeground(Color.red);
		 lbna.setBounds(350,30,80,30);
		 cp.add(lbna);
		 
		 jd2 = new JTextField();
		 jd2.setBounds(430,30,200,30);
		 jd2.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd2);
		 
		 JLabel lsd = new JLabel();
		 lsd.setText("学期:");
		 lsd.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lsd.setForeground(Color.red);
		 lsd.setBounds(200,80,80,30);
		 cp.add(lsd);
		 
		 jd3 = new JTextField();
		 jd3.setBounds(300,80,100,30);
		 jd3.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd3);
		 
		 JLabel la = new JLabel();
		 la.setText("文学");
		 la.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 la.setForeground(Color.red);
		 la.setBounds(30,130,80,30);
		 cp.add(la);
		 
		 jd4 = new JTextField();
		 jd4.setBounds(110,130,200,30);
		 jd4.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd4);
		 
		 JLabel lba = new JLabel();
		 lba.setText("高数:");
		 lba.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lba.setForeground(Color.red);
		 lba.setBounds(350,130,80,30);
		 cp.add(lba);
		 
		 jd5 = new JTextField();
		 jd5.setBounds(430,130,200,30);
		 jd5.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd5);
		 
		 JLabel lbs = new JLabel();
		 lbs.setText("英语:");
		 lbs.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbs.setForeground(Color.red);
		 lbs.setBounds(30,190,80,30);
		 cp.add(lbs);
		 
		 jd6 = new JTextField();
		 jd6.setBounds(110,190,200,30);
		 jd6.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd6);
		 
		 JLabel lbsx = new JLabel();
		 lbsx.setText("物联网:");
		 lbsx.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbsx.setForeground(Color.red);
		 lbsx.setBounds(340,190,100,30);
		 cp.add(lbsx);
		 
		 jd7 = new JTextField();
		 jd7.setBounds(430,190,200,30);
		 jd7.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd7);
		 
		 JLabel lbsi = new JLabel();
		 lbsi.setText("健康:");
		 lbsi.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbsi.setForeground(Color.red);
		 lbsi.setBounds(30,250,80,30);
		 cp.add(lbsi);
		 
		 jd8 = new JTextField();
		 jd8.setBounds(110,250,200,30);
		 jd8.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd8);
		 
		 JLabel lbi = new JLabel();
		 lbi.setText("Java");
		 lbi.setFont(new Font("微软雅黑", Font.BOLD, 26));
		 lbi.setForeground(Color.red);
		 lbi.setBounds(340,250,100,30);
		 cp.add(lbi);
		 
		 jd9 = new JTextField();
		 jd9.setBounds(430,250,200,30);
		 jd9.setFont(new Font("宋体", Font.PLAIN, 20));
		 cp.add(jd9);
		 
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
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(5);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(6);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(7);
		column.setPreferredWidth(50);
		column = table.getColumnModel().getColumn(8);
		column.setPreferredWidth(50);
		
		table.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				int selectedRow = table.getSelectedRow();
				Object o0 = tableModel.getValueAt(selectedRow, 0);
				Object o1 = tableModel.getValueAt(selectedRow, 1);
				Object o2 = tableModel.getValueAt(selectedRow, 2);
				Object o3 = tableModel.getValueAt(selectedRow, 3);		
				Object o4= tableModel.getValueAt(selectedRow, 4);
				Object o5 = tableModel.getValueAt(selectedRow, 5);
				Object o6 = tableModel.getValueAt(selectedRow, 6);
				Object o7 = tableModel.getValueAt(selectedRow, 7); 
				Object o8 = tableModel.getValueAt(selectedRow, 8);
				jd1.setText(o0.toString());
				jd2.setText(o1.toString());
				jd3.setText(o2.toString());
				jd4.setText(o3.toString());
				jd5.setText(o4.toString());
				jd6.setText(o5.toString());
				jd7.setText(o6.toString());
				jd8.setText(o7.toString());
				jd9.setText(o8.toString());
			}
		});
		
		add = new JButton("添加成绩信息");
		add.setFont(new Font("宋体", Font.PLAIN, 16));
		add.setBounds(540,310,140,30);
		getContentPane().add(add);
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//添加学生成绩窗体：
				setVisible(false);
				AddStuCourse ad = new AddStuCourse();
				ad.setVisible(true);
			}
		});
		
		change = new JButton("修改学生成绩");
		change.setFont(new Font("宋体", Font.PLAIN, 16));
		change.setBounds(540,380,140,30);
		getContentPane().add(change);
		
		change.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				//修改学生成绩窗体：
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					Object oid = tableModel.getValueAt(selectedRow, 0);
					Object oterm = tableModel.getValueAt(selectedRow, 2);
					setVisible(false);
					ChangeCourse cc = new ChangeCourse(oid.toString(), oterm.toString());
					cc .setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "您还没有选择！");
				}
			}
		});
		
		delete = new JButton("删除学生成绩");
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
					int answer1 = JOptionPane.showConfirmDialog(null, "确定删除？", "删除", JOptionPane.YES_NO_OPTION);
					if(answer1 == 0){
						Object oid = tableModel.getValueAt(selectedRow, 0);
						Object oterm = tableModel.getValueAt(selectedRow, 2);
						tableModel.removeRow(selectedRow);	
						cn.deletecourse(oid.toString(), oterm.toString());
						JOptionPane.showMessageDialog(null, "成功删除学号为"+oid.toString()+"第"+ oterm.toString() +"学期的成绩！");
						jd1.setText("");
						jd2.setText("");
						jd3.setText("");
						jd4.setText("");
						jd5.setText("");
						jd6.setText("");
						jd7.setText("");
						jd8.setText("");
						jd9.setText("");
					}	
				}else {
					JOptionPane.showMessageDialog(null, "您还没有选择！");
				}
			}
		});
	}
	
	public static void main(String args []){
		StuCourse sc = new StuCourse();
		sc.setVisible(true);
	}
}

