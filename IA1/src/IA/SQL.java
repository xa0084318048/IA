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
			String sql1 = "select * from 人物卡数据库";
			ResultSet result = stat.executeQuery(sql1);
	        
	        try
			{
				while (result.next()) {
				int id = result.getInt("id");
				String sheet_name = result.getString("表名（sheet name)");
				String character_name = result.getString("姓名(character name)");
				String player_name = result.getString("玩家(player name)");
				String character_class = result.getString("职业(character class)");
				int age = result.getInt("年龄(age)");
				String dwelling_place = result.getString("住地(dwelling place)");
				String hometown = result.getString("故乡(hometown)");
				String era = result.getString("时代(era)");
				String gender = result.getString("性别(gender)");
				numbers[a] = id;
				data[a++] = "id:" + id  + "   表名（sheet name):" + sheet_name +  "  姓名(character name):" + character_name +  "    玩家(player name):" + player_name + "   职业(character class):" + character_class + "   年龄(age):" + age +  "   住地(dwelling place):"+ dwelling_place + "  故乡(hometown):" + hometown + "   时代(era):" + era + "   性别(gender):" + gender;
				
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
	private String[] text_name = {"id", "表名（sheet name)" , "姓名(character name)" , "玩家(player name)" , 
			"年龄(age)"};
	private JTextField text[] = new JTextField[100];
	private JTextField [] input_name = new JTextField[text_name.length];
	private JButton text2[] = new JButton[text_name.length];
	private JTextField text3[] = new JTextField[100];

	
	
	
	private JTextField [] temp = new JTextField[2];
	private JButton [] select_menu = new JButton[4];
	private String[] select = {"增", "删"  ,"查"};
	static String asa;
		
		
		
		public SQL() throws SQLException {
			
			String sql2 = "";
			select(sql2);
			
			setTitle("人物卡管理器（character sheet Manager");
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
	        	temp[1] = new JTextField("添加成功");
	        }else if(count == 2) {
	        	temp[1] = new JTextField("删除成功");
	        }else if(count == 3) {
	        	temp[1] = new JTextField("查询成功");
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
					if(ab.equals("增")) {
						for(int i = 0 ; i < 5 ; i++) {
							if(input_name[i].getText().equals(""))
								n++;
						}
						int q = 0;
						if(n == 0) {
							int id = Integer.parseInt(input_name[0].getText());
							for(int i = 0 ; i < a ; i++) {
								if(id == numbers[i]) {
									temp[1].setText("id重复");
									q = 1;
								}
							}
						if(q != 1) {
								String sheet_name = input_name[1].getText();
								String character_name = input_name[2].getText();
								int age = Integer.parseInt(input_name[3].getText());
								String player_name = input_name[4].getText();
								String sql = "insert into 人物卡数据库 values(" + id +",\'"+ sheet_name +"\',\'" +character_name
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
								temp[1].setText("添加成功");
								aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							
							}
						}else {
							temp[1].setText("输入为空");
						}
							
						
					}
				}
	        	
	        });
	        select_menu[1].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int exist = 0;
					if(input_name[0].getText().equals("")) {
						temp[1].setText("id为空");
					}else {
						int sno = Integer.parseInt(input_name[0].getText());
						for(int i = 0 ; i < a ; i++) {
							if(sno == numbers[i]) {
								exist = 1;
							}
						}
						if(exist == 1) {
							String sql1 = "delete from 人物卡数据库 where Sno = " + sno;
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
							temp[1].setText("删除成功");
							aa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						}else {
							temp[1].setText("错误");
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
						temp[1].setText("输入为空！");
					}else if(n > 1) {
						temp[1].setText("别输入多项");
					}else if(n == 1) {
						if(temp1 == 0) {
							int id = Integer.parseInt(input_name[temp1].getText());
							sql1 = "select * from 人物卡数据库 where id = " + id;
						}else if(temp1 == 3) {
							int age = Integer.parseInt(input_name[temp1].getText());
							sql1 = "select * from 人物卡数据库 where 年龄(age) = " + age;
						}else if(temp1 == 1){
							String sheet_name = input_name[temp1].getText();
							sql1 = "select * from 人物卡数据库 where 表名（sheet name) = \'" + sheet_name +"\'"; 
						}else if(temp1 == 2) {
							String character_name = input_name[temp1].getText();
							sql1 = "select * from 人物卡数据库 where 姓名(character name) = \'" + character_name +"\'";
						}else if(temp1 == 4) {
							String player_name = input_name[temp1].getText();
							sql1 = "select * from 人物卡数据库 where 玩家(player name) = \'" + player_name +"\'"; 
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
							String sheet_name = result2.getString("表名（sheet name)");
							String character_name = result2.getString("姓名(character name)");
							String player_name = result2.getString("玩家(player name)");
							String character_class = result2.getString("职业(character class)");
							int age = result2.getInt("年龄(age)");
							String dwelling_place = result2.getString("住地(dwelling place)");
							String hometown = result2.getString("故乡(hometown)");
							String era = result2.getString("时代(era)");
							String gender = result2.getString("性别(gender)");
							data2[b++] = "id:" + id  + "表名（sheet name):" + sheet_name +  "姓名(character name):" + character_name +  "玩家(player name):" + player_name + "职业(character class):" + character_class + "  年龄(age):" + age +  "  住地(dwelling place):"+ dwelling_place + " 故乡(hometown):" + hometown + "  时代(era):" + era + "  性别(gender):" + gender;
							
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
						temp[1].setText("查询成功");
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

	




