package IA;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SQL extends JFrame implements ActionListener{
	
	int a = 0;
	String data[] = new String[100];
	int [] numbers = new int[100];
	

		public void select(String sql) throws SQLException {
			DatabaseConnect dbc = new DatabaseConnect();
			Connection conn = (Connection) dbc.getConn();
			
			Statement stat = (Statement) conn.createStatement();
			String sql1 = "select * from ���￨���ݿ�";
			ResultSet result = stat.executeQuery(sql1);
	        
	        try
			{
				while (result.next()) {
				int id = result.getInt("id");
				String sheet_name = result.getString("������sheet name)");
				String character_name = result.getString("����(character name)");
				String player_name = result.getString("���(player name)");
				String character_class = result.getString("ְҵ(character class)");
				int age = result.getInt("����(age)");
				String dwelling_place = result.getString("ס��(dwelling place)");
				String hometown = result.getString("����(hometown)");
				String era = result.getString("ʱ��(era)");
				String gender = result.getString("�Ա�(gender)");
				numbers[a] = id;
				data[a++] = "id:" + id  + "   ������sheet name):" + sheet_name +  "  ����(character name):" + character_name +  "    ���(player name):" + player_name + "   ְҵ(character class):" + character_class + "   ����(age):" + age +  "   ס��(dwelling place):"+ dwelling_place + "  ����(hometown):" + hometown + "   ʱ��(era):" + era + "   �Ա�(gender):" + gender;
				
				result.close();
				stat.close();
				conn.close();
				                     }
				}catch(SQLException a)
				    {
					a.printStackTrace();
					}
			}
	
		static int b = 0;
		static String data2[] = new String[100];
		int count = 0;

	private static final long serialVersionUID = 1L;
	private String[] text_name = {"id", "������sheet name)" , "����(character name)" , "���(player name)" , 
			"����(age)"};
	private JTextField text[] = new JTextField[100];
	private JTextField [] input_name = new JTextField[text_name.length];
	private JButton text2[] = new JButton[text_name.length];
	private JTextField text3[] = new JTextField[100];

	
	
	
	private JTextField [] temp = new JTextField[2];
	private JButton [] select_menu = new JButton[4];
	private String[] select = {"��", "ɾ"  ,"��"};
	static String asa;
		
		
		
		public SQL() throws SQLException {
			
			String sql2 = "";
			select(sql2);
			
			setTitle("���￨��������character sheet Manager");
			this.setBackground(Color.LIGHT_GRAY);
			this.setLocation(500, 300);			
			this.setSize(1300, 350*a);		
	        JPanel date1 = new JPanel();	
	        date1.setLayout(new GridLayout(b + 1, 1, 1, 1)); 
	        
	        JPanel date = new JPanel();
	        date.setLayout(new GridLayout(a + 1, 1, 1, 1));
	        if(b > 0) {
	        	for(int i = 0 ; i < b ; i++) {
	        		text3[i] = new JTextField(data2[i]);
	        		text3[i].setEditable(false);
	        	}
	        	for(int i = 0 ; i < b; i++) {
	            	date1.add(text3[i]);
	            }
	        }else {
	        	
	        	for(int i = 0 ; i < a; i++) {
	            	text[i] = new JTextField(data[i]);
	            	text[i].setEditable(false);
	            }
	            for(int i = 0 ; i < a; i++) {
	            	date.add(text[i]);
	            }
	        }
	        JPanel use = new JPanel();
	        use.setLayout(new GridLayout(1,1 , 6 ,0));
	        for(int i = 0 ; i < text_name.length ; i++) {
	        	text2[i] = new JButton(text_name[i]);
	        }
	        for(int i = 0 ; i < text_name.length ; i++) {
	        	use.add(text2[i]);
	        }
	 
	        JPanel input = new JPanel();
	        input.setLayout(new GridLayout(2,1,6,10));
	        for(int i = 0 ; i < text_name.length ; i++) {
	        	input_name[i] = new JTextField();
	        	input_name[i].setEditable(true);
	        }
	        
	        for(int i = 0 ; i < text_name.length ; i++) {
	        	input.add(input_name[i]);
	        }
	        
	        temp[0] = new JTextField(" ");
	        temp[0].setEditable(false);
	        temp[0].setHorizontalAlignment(JTextField.CENTER);
	        temp[0].setForeground(Color.red);
	        input.add(temp[0]);
	        for(int i = 0 ; i < 3 ; i++) {
	        	select_menu[i] = new JButton(select[i]);
	        }
	        for(int i = 0 ; i < 3 ; i++) {
	        	input.add(select_menu[i]);
	        }
	        if(count == 0) {
	        	temp[1] = new JTextField();
	        }else if(count == 1) {
	        	temp[1] = new JTextField("��ӳɹ�");
	        }else if(count == 2) {
	        	temp[1] = new JTextField("ɾ���ɹ�");
	        }else if(count == 3) {
	        	temp[1] = new JTextField("��ѯ�ɹ�");
	        }
	        
	        temp[1].setEditable(false);
	        temp[1].setHorizontalAlignment(JTextField.CENTER);
	        temp[1].setForeground(Color.RED);
	        input.add(temp[1]);
	        

	        select_menu[0].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ab = e.getActionCommand();
					int n = 0;
					if(ab.equals("��")) {
						for(int i = 0 ; i < 5 ; i++) {
							if(input_name[i].getText().equals(""))
								n++;
						}
						int q = 0;
						if(n == 0) {
							int id = Integer.parseInt(input_name[0].getText());
							for(int i = 0 ; i < a ; i++) {
								if(id == numbers[i]) {
									temp[1].setText("id�ظ�");
									q = 1;
								}
							}
						if(q != 1) {
								String sheet_name = input_name[1].getText();
								String character_name = input_name[2].getText();
								int age = Integer.parseInt(input_name[3].getText());
								String player_name = input_name[4].getText();
								String sql = "insert into ���￨���ݿ� values(" + id +",\'"+ sheet_name +"\',\'" +character_name
										+"\'," + age + ",\'" + player_name + "\')";
								System.out.println(sql);
								try {
									select(sql);
								} catch (SQLException e2) {
									// TODO Auto-generated catch block
									e2.printStackTrace();
								}
								SQL aa = null;
								try {
									aa = new SQL();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								aa.setVisible(true);
								temp[1].setText("��ӳɹ�");
								aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
							}
						}else {
							temp[1].setText("����Ϊ��");
						}
							
						
					}
				}
	        	
	        });
	        select_menu[1].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int exist = 0;
					if(input_name[0].getText().equals("")) {
						temp[1].setText("idΪ��");
					}else {
						int sno = Integer.parseInt(input_name[0].getText());
						for(int i = 0 ; i < a ; i++) {
							if(sno == numbers[i]) {
								exist = 1;
							}
						}
						if(exist == 1) {
							String sql1 = "delete from ���￨���ݿ� where Sno = " + sno;
							try {
								select(sql1);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							SQL aa = null;
							try {
								aa = new SQL();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							aa.setVisible(true);
							temp[1].setText("ɾ���ɹ�");
							aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}else {
							temp[1].setText("����");
						}
					}
					
				}
	        	
	        });
	        select_menu[2].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					
					String sql1 = "";
					int n = 0;
					int temp1 = -1;
					for(int i = 0 ; i < 5 ; i++) {
						if(!input_name[i].getText().equals("")) {
							n++;
							temp1 = i;
						}
					}
					if(n == 0) {
						temp[1].setText("����Ϊ�գ�");
					}else if(n > 1) {
						temp[1].setText("���������");
					}else if(n == 1) {
						if(temp1 == 0) {
							int id = Integer.parseInt(input_name[temp1].getText());
							sql1 = "select * from ���￨���ݿ� where id = " + id;
						}else if(temp1 == 3) {
							int age = Integer.parseInt(input_name[temp1].getText());
							sql1 = "select * from ���￨���ݿ� where ����(age) = " + age;
						}else if(temp1 == 1){
							String sheet_name = input_name[temp1].getText();
							sql1 = "select * from ���￨���ݿ� where ������sheet name) = \'" + sheet_name +"\'"; 
						}else if(temp1 == 2) {
							String character_name = input_name[temp1].getText();
							sql1 = "select * from ���￨���ݿ� where ����(character name) = \'" + character_name +"\'";
						}else if(temp1 == 4) {
							String player_name = input_name[temp1].getText();
							sql1 = "select * from ���￨���ݿ� where ���(player name) = \'" + player_name +"\'"; 
						}
						DatabaseConnect dbc = new DatabaseConnect();
						Connection conn = (Connection) dbc.getConn();
						Statement stat = null;
						
						try {
							stat = (Statement) conn.createStatement();
						}catch(SQLException e2) {
							e2.printStackTrace();
						}
						ResultSet result2 = null;
						try {
							result2 = stat.executeQuery(sql1);
					}catch(SQLException e2) {
						e2.printStackTrace();
					}
					
					try
					{
						while(result2.next())
						{
							int id = result2.getInt("id");
							String sheet_name = result2.getString("������sheet name)");
							String character_name = result2.getString("����(character name)");
							String player_name = result2.getString("���(player name)");
							String character_class = result2.getString("ְҵ(character class)");
							int age = result2.getInt("����(age)");
							String dwelling_place = result2.getString("ס��(dwelling place)");
							String hometown = result2.getString("����(hometown)");
							String era = result2.getString("ʱ��(era)");
							String gender = result2.getString("�Ա�(gender)");
							data2[b++] = "id:" + id  + "������sheet name):" + sheet_name +  "����(character name):" + character_name +  "���(player name):" + player_name + "ְҵ(character class):" + character_class + "  ����(age):" + age +  "  ס��(dwelling place):"+ dwelling_place + " ����(hometown):" + hometown + "  ʱ��(era):" + era + "  �Ա�(gender):" + gender;
							
						}
						result2.close();
						stat.close();
						conn.close();
					}catch(SQLException c)
					{
						c.printStackTrace();
					}
						
						SQL aa = null;
						try {
							aa = new SQL();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						aa.setVisible(true);
						temp[1].setText("��ѯ�ɹ�");
						aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					}
					b = 0;
				}
	        	
	        });
	       
	        
	        getContentPane().setLayout(new BorderLayout(3, 2));
	        if(b > 0) {
	        	getContentPane().add("North" , date1);	
	        }else
	        	getContentPane().add("North" , date);		
	        getContentPane().add("Center" , use);
	        getContentPane().add("South" , input);
	        use.setPreferredSize(new Dimension(0 , 40));
	        input.setPreferredSize(new Dimension(0,60));
		}
		
		public static void main(String[] args) throws SQLException {
			// TODO Auto-generated method stub
			SQL d = new SQL();
			d.setVisible(true);
			d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

	        
		}

	




