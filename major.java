/*
大作业：个人所得税计算器

个人所得税每月交一次，底线是1600元/月，也就是超过了1600元的月薪才开始计收个人所得税。个人所得税税率表一（工资、薪金所得适用）
级数----------全月应纳税所得额----------税率（％）
1--------------不超过500元的----------------5
2----------超过500元至2000元的部分-- --------10
3----------超过2000元至5000元的部分----------15
4----------超过5000元至20000元的部分---------20
5----------超过20000元至40000元的部分-------25
6----------超过40000元至60000元的部分-------30
7----------超过60000元至80000元的部分-------35
8----------超过80000元至100000元的部分------40
9----------超过100000元的部分----------------45
要求：输入工资计算出纳税金额。


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//导入系统包

public class major 
{
	public static void main(String[] args)//主程序
	{
		QueRen queRen = new QueRen();
		queRen.show();//显示QueRen窗口
		queRen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//监听QueRen窗口关闭
	}
	static class QueRen extends JFrame implements ActionListener//定义一个窗口显示程序信息和制作信息
	{
		private JButton qrJButton = new JButton("开始使用");
		private JLabel qrJLabel1 = new JLabel("欢迎使用个人所得税计算器");
		private JLabel qrJLabel2 = new JLabel("BY：XDYM11235");
		
		public QueRen()
		{
			setLocationRelativeTo(null);//窗口居中
			setTitle("注意！");//标题
			setSize(400, 300);//设置窗口大小
			Container cp = this.getContentPane();
			cp.setLayout(null);
			qrJLabel1.setBounds(new Rectangle(110,15,156,34));
			qrJButton.setBounds(new Rectangle(140,155,100,34));
			cp.add(qrJLabel1);
			cp.add(qrJButton);
			qrJButton.addActionListener(this);//监听按钮事件
			show();
		}
		public void actionPerformed(ActionEvent e)//按钮qrJButton事件响应
		{
			Page page = new Page();
			page.show();//显示Page窗口
			dispose();//关闭QueRen窗口，并销毁
			page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//监听Page窗口关闭
		}
		
	}
	static class Page extends JFrame implements ActionListener//定义Page窗口信息
	{
		private static final int CENTER = 0;
		private JTextField gettext = new JTextField(10);
		private JTextField outtext = new JTextField(15);
		private JButton paybutton = new JButton("计算个人所得税");
		Page() 
		{			
			setLocationRelativeTo(null);//窗口居中
			setTitle("个人所得税计算器v1.1");//标题
			setSize(400,300);//设置窗口大小
			Container cp = this.getContentPane();
			cp.setLayout(null);
			gettext.setBounds(new Rectangle(150, 50, 100, 34));
			paybutton.setBounds(new Rectangle(125, 94, 150, 34));
			outtext.setBounds(new Rectangle(125, 138, 150, 34));
			outtext.setHorizontalAlignment(CENTER);//居中
			cp.add(gettext);
			gettext.setText("0");
			cp.add(paybutton);
			cp.add(outtext);//接收计算结果
			outtext.setEditable(false);
			paybutton.addActionListener(this);
			show();
		}
		public void actionPerformed(ActionEvent e)//按钮paybutton事件响应
		{
			double text1 = 0;
			text1 = Double.parseDouble(gettext.getText());
			if(text1 >= 0 && text1 <= 1600)//判断输入数字大小并进行计算
			{
				outtext.setText("您好，您不需要纳税");
			}
			else if (text1 > 1600 && text1 <= 2100)
			{
				text1 = text1 - 1600;
				text1 = 0.05 * text1;
				outtext.setText((text1 + " "));
			}
			else if (text1 > 2100 && text1 <= 3600) 
			{
				text1 = text1 - 2100;
				text1 = 0.1 * text1 + 25;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 3600 && text1 <=6600) 
			{
				text1 = text1 - 3600;
				text1 = 0.15 * text1 + 175;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 6600 && text1 <=21600)
			{
				text1 = text1 - 6600;
				text1 = 0.2 * text1 + 625;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 21600 && text1 <= 41600)
			{
				text1 = text1 - 21600;
				text1 = 0.25 * text1 + 3625;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 41600 && text1 <= 61600)
			{
				text1 = text1 - 41600;
				text1 = 0.3 * text1 + 8625;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 61600 && text1 <= 81600)
			{
				text1 = text1 - 61600;
				text1 = 0.35 * text1 + 14625;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 81600 && text1 <= 101600)
			{
				text1 = text1 - 81600;
				text1 = 0.4 * text1 + 21625;
				outtext.setText((text1 + ""));
			}
			else if (text1 > 101600)
			{
				text1 = 0.45 * text1 + 29625;
				outtext.setText((text1 + ""));
			}
			else 
			{
				jab jab1 = new jab();
				jab1.show();//显示jab窗口
				dispose();//关闭Page窗口，并销毁
				jab1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//监听jab窗口关闭
			}
		}
	}
	static class jab extends JFrame implements ActionListener//定义jab窗口
	{
		private JLabel Label1 = new JLabel("输入非法，请重输！");
		private JButton jButton1 = new JButton("确认");
		public jab()
		{
			setLocationRelativeTo(null);//窗口居中
			setTitle("错误");//标题
			setSize(400,300);//窗口大小
			Container cp = this.getContentPane();
			cp.setLayout(null);
			Label1.setBounds(new Rectangle(135, 50, 200, 40));
			jButton1.setBounds(new Rectangle(100, 100, 200, 40));
			cp.add(Label1);
			cp.add(jButton1);
			jButton1.addActionListener(this);//监视jab窗口
			show();
		}
		public void actionPerformed(ActionEvent arg0)//按钮jButton1事件响应
		{
			Page page = new Page();
			page.show();//显示Page窗口
			dispose();//关闭窗口，并销毁
			page.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//监听窗口Page关闭
		}
	}
	
}
