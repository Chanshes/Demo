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
	 * �Զ��������
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private JButton add,change,delete;
	private JTextField jid,jtn,jsd,jtan,jtans,jtax;
	DefaultTableModel tableModel;
	Connect cn = new Connect();
	Object[][] data = cn.getBase();
	String[] header =  new String[] { "ѧ��", "����", "����", "�Ա�", "ѧԺ", "�༶"};
	
	public StuBase(){
		super();
		this.setTitle("ѧ����Ϣ��ѯ");
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
		 lbid.setText("ѧ��:");
		 lbid.setForeground(Color.red);
		 lbid.setBounds(30,30,80,30);
		 lbid.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 cp.add(lbid);
		 
		 jid = new JTextField();
		 jid.setBounds(110,30,200,30);
		 jid.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jid);
		 
		 JLabel lbna = new JLabel();
		 lbna.setText("����:");
		 lbna.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 lbna.setForeground(Color.red);
		 lbna.setBounds(350,30,80,30);
		 cp.add(lbna);
		 
		 jtn = new JTextField();
		 jtn.setBounds(430,30,200,30);
		 jtn.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jtn);
		 
		 JLabel lsd = new JLabel();
		 lsd.setText("ѧԺ:");
		 lsd.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 lsd.setForeground(Color.red);
		 lsd.setBounds(30,130,80,30);
		 cp.add(lsd);
		 
		 jsd = new JTextField();
		 jsd.setBounds(110,130,200,30);
		 jsd.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jsd);

		 JLabel lba = new JLabel();
		 lba.setText("����:");
		 lba.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 lba.setForeground(Color.red);
		 lba.setBounds(350,130,80,30);
		 cp.add(lba);
		 
		 jtan = new JTextField();
		 jtan.setBounds(430,130,200,30);
		 jtan.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jtan);
		 
		 JLabel lbs = new JLabel();
		 lbs.setText("�༶:");
		 lbs.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 lbs.setForeground(Color.red);
		 lbs.setBounds(30,230,80,30);
		 cp.add(lbs);
		 
		 jtans = new JTextField();
		 jtans.setBounds(430,230,200,30);
		 jtans.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jtans);
		 

		 JLabel lbsx = new JLabel();
		 lbsx.setText("�Ա�:");
		 lbsx.setFont(new Font("΢���ź�", Font.BOLD, 26));
		 lbsx.setForeground(Color.red);
		 lbsx.setBounds(350,230,80,30);
		 cp.add(lbsx);
		 
		 jtax = new JTextField();
		 jtax.setBounds(110,230,200,30);
		 jtax.setFont(new Font("����", Font.PLAIN, 20));
		 cp.add(jtax);
		 
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 300, 500, 200);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane);
		
		tableModel = new DefaultTableModel(data,header);
		table = new JTable(tableModel);
		table.setRowSorter(new TableRowSorter<>(tableModel));
		scrollPane.setViewportView(table);//����һ���ӿڣ�������������������ͼ
		
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
		
		add = new JButton("���ѧ����Ϣ");
		add.setFont(new Font("����", Font.PLAIN, 16));
		add.setBounds(540,310,140,30);
		getContentPane().add(add);
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//���ѧ����Ϣ���壺
				setVisible(false);
				AddStudentBase ad = new AddStudentBase();
				ad.setVisible(true);
			}
		});
		
		change = new JButton("�޸�ѧ����Ϣ");
		change.setFont(new Font("����", Font.PLAIN, 16));
		change.setBounds(540,380,140,30);
		getContentPane().add(change);
		change.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//�޸�ѧ����Ϣ���壺
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					Object oid = tableModel.getValueAt(selectedRow, 0);
					setVisible(false);
					ChangeBase cb = new ChangeBase(oid.toString());
					cb.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "����û��ѡ��");
				}
			}
		});
		
		delete = new JButton("ɾ��ѧ����Ϣ");
		delete.setFont(new Font("����", Font.PLAIN, 16));
		delete.setBounds(540,450,140,30);
		getContentPane().add(delete);
		delete.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				//ɾ��ָ���е�ѧ����Ϣ��
				int selectedRow = table.getSelectedRow();
				if(selectedRow != -1){
					int answer1 = JOptionPane.showConfirmDialog(null, "ȷ��ɾ����", "ɾ��ѧ��", JOptionPane.YES_NO_OPTION);
					if(answer1 == 0){
						Object oid = tableModel.getValueAt(selectedRow, 0);
						tableModel.removeRow(selectedRow);
						cn.deletebase(oid.toString());
						JOptionPane.showMessageDialog(null, "�ɹ�ɾ��ѧ��Ϊ"+oid.toString()+"��ͬѧ��");
						jid.setText("");
						jtn.setText("");
						jtan.setText("");
						jtans.setText("");
						jsd.setText("");
						jtax.setText("");
						int answer2 = JOptionPane.showConfirmDialog(null, "�Ƿ�ͬ��ɾ���˺��Լ���Ϣ��", "ɾ����Ϣ", JOptionPane.YES_NO_OPTION);
						if(answer2 == 0){
							cn.deleteacount(oid.toString());
							cn.deletecourse(oid.toString());
							JOptionPane.showMessageDialog(null, "�ѳɹ�ɾ����");
						}
					}	
				}else {
					JOptionPane.showMessageDialog(null, "����û��ѡ��");
				}
			}
		});
	}
	
	public static void main(String args []){
		StuBase ja = new StuBase();
		ja.setVisible(true);
	}
}
