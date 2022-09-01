//                                  ____
//                             _o O0O o_
//                          _ o o  O  o o _  
//                        o8*8*8*8*8*8*8o  
//                         8 8 "    .    " 8 8  
//                          (   |  - _ -   |  )   
//                            O  \  =  /  O  
//                    _______/`-------'\_______  
//                  /.     '   \ \ |    | / /   `    .\  
//                 /     \ \ | | |   :   | | | / /     \  
//               / _ |  |  |  |  |  -:-  |  |  |  |  | _ \  
//                |    |    \   \  \ - /  /   /    |    |  
//                 |   \ _ |   ' ' \---/' '      |    |  
//                    \  . - \__   `-`   ___/-.  /  
//                 ___` .  .'   /  --.-- \ ` .  .  ___  
//              .""  ' <  `.___\_<|>_/___. ' > ' "".  
//            |  |   :  ` -  \` .; `\ _ /` ;. `/  -  `  :  |  |  
//               \ \   ` - .  \_ __\ /__ _/   . - `  /  /  
//   ======`-.____`-.___\_____/___.-`____.-'======  
//                              ` = - - = '
//         ...............................................................  
//               佛祖保佑             永无BUG 
//       佛曰:  
//               写字楼里写字间，写字间里程序员；  
//               程序人员写程序，又拿程序换酒钱。  
//               酒醒只在网上坐，酒醉还来网下眠；  
//               酒醉酒醒日复日，网上网下年复年。  
//               但愿老死电脑间，不愿鞠躬老板前；  
//               奔驰宝马贵者趣，公交自行程序员。  
//               别人笑我忒疯癫，我笑自己命太贱；  
//               不见满街漂亮妹，哪个归得程序员？ 

import java.util.*;
import java.io.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class CodeBase64 {
	public static JFrame wd = new JFrame();//wd=window
	public static JSplitPane jsplit = new JSplitPane();
	public static JPanel left =new JPanel();
	public static JPanel right = new JPanel();
	public static JPanel top = new JPanel();
	public static JPanel down = new JPanel();
	public static JPanel top2 = new JPanel();
	public static JPanel down2 = new JPanel();
	public static JLabel encoder_main = new JLabel("加密");
	public static JLabel decoder_main = new JLabel("解密");
	public static JLabel encoder_second = new JLabel("输入要加密的内容");
	public static JLabel decoder_second = new JLabel("输入要解密的内容");
	public static JLabel encoder_third = new JLabel("加密的内容的如下");
	public static JLabel decoder_third = new JLabel("解密的内容的如下");
	public static JLabel picture1 = new JLabel();
	public static JLabel picture2 = new JLabel();
	public static JTextArea ET = new JTextArea();//ET=EncoderText
	public static JTextArea DT = new JTextArea();//DT=DecoderText
	public static JTextArea CET = new JTextArea();//CET=CompletelyEncoderText
	public static JTextArea CDT = new JTextArea();//CAT=CompletelyDecoderText
	public static JTextArea DTP = new JTextArea();//DTP=DecoderTextPicture
	public static JTextArea CETP = new JTextArea();//CETP=CompletelyEncoderTextPicture
	public static JButton encoder = new JButton("加密");
	public static JButton decoder = new JButton("解密");
	public static JButton decoder2 = new JButton("生成");//Base64转图片的生成
	public static JButton encoder2 = new JButton("生成");//图片转Base64的生成
	public static JButton AddFile = new JButton("添加");	//添加图片，用来转Base64
	//以下是滚动条组件
	public static JScrollPane encoder_jsp = new JScrollPane(ET);//jsp=JScrollPane
	public static JScrollPane decoder_jsp = new JScrollPane(DT);
	public static JScrollPane encoder_jsp_c = new JScrollPane(CET);//jsp_c=JScrollPane_Complete
	public static JScrollPane decoder_jsp_c = new JScrollPane(CDT);
	public static JScrollPane top_jsp = new JScrollPane(DTP);
	public static JScrollPane down2_jsp = new JScrollPane(CETP);
	public static JMenuBar menubar =new JMenuBar();
	public static JMenu menu1 = new JMenu("Base64");
	public static JMenu menu2 = new JMenu("Base64转图片");
	public static JMenu menu3 = new JMenu("图片转Base64");

	//生成解密后的图片
	public static String PictureName;
	public static Image img;

	public static String EncoderImagePath;

    public static void main(String[] args) {
		Pane1();
		UI();

		//String a = ImageToBase64("./1.jpg");
		//System.out.println(a);
		 
		 //菜单按钮的事件监听

		 //menu1的事件监听
		 menu1.addMenuListener(new MenuListener() {
           public void menuSelected(MenuEvent e) {
			   //System.out.println("This is Menu1's UI Pane");
			   Pane1();
           }
           public void menuDeselected(MenuEvent e) {
			   Pane1();
           }
           public void menuCanceled(MenuEvent e) {

           }
         });

		//menu2的事件监听
		 menu2.addMenuListener(new MenuListener() {
           public void menuSelected(MenuEvent e) {//选定
			   //System.out.println("This is Menu2's UI Pane");
			   Pane2();
           }
           public void menuDeselected(MenuEvent e) {//取消选定
			   Pane2();
           }
           public void menuCanceled(MenuEvent e) {
           }
         });

		 //menu3的事件监听
		 menu3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e){
				Pane3();
			}
			public void menuDeselected(MenuEvent e){
				
			}
			public void menuCanceled(MenuEvent e){
				
			}
		 });

//加密按钮添加加密函数方法
		encoder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String goal = ET.getText();
				EnCode(goal);
			}
		});

//解密按钮添加解密函数方法
		decoder.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e){
					String goal = DT.getText();
					DeCode(goal);
				}
		});

		//Base64转图片按钮解密函数
	decoder2.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e){
				String goal = DTP.getText();
				PictureName = UUID.randomUUID().toString();
				boolean b = Base64ToImage(goal);//b只是为了执行Base64ToImage函数而写的，其主要目的也是为了检测goal的格式是否符合Base64编码
				System.out.println(b);
				
				ImageIcon imageIcon = new ImageIcon("./OutputStreamFiles/images/"+PictureName+".png"); // load the image to a imageIcon
				Image image = imageIcon.getImage(); // transform it 
				Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				imageIcon = new ImageIcon(newimg);  // transform it back

				picture1.setBounds(200,5,600,600);
				picture1.setIcon(imageIcon);//文件路径
				down.add(picture1);
				down.repaint();
			}
	});

//添加文件按钮的事件响应
	AddFile.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand().equals("open")){
					JFileChooser jfc = new JFileChooser();
					jfc.showOpenDialog(wd);//显示打开的文件对话框
					File f = jfc.getSelectedFile();//使用文件类获取选择器选择的文件
					String s = f.getAbsolutePath();//返回路径名
					EncoderImagePath = s;
					//System.out.println(s);

					ImageIcon imageIcon = new ImageIcon(s); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					imageIcon = new ImageIcon(newimg);  // transform it back

					picture2.setBounds(240,80,500,500);
					picture2.setIcon(imageIcon);//文件路径
					top2.add(picture2);
					top2.repaint();
				}
			}
	});

	encoder2.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e){
				String CompletelyEncoder = ImageToBase64(EncoderImagePath);
				CETP.setText(CompletelyEncoder);
			}
	});

    }

//UI初始化设置
	public static void UI(){

//窗口设置
		wd.add(jsplit);//加入到面板中

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		
		wd.setJMenuBar(menubar);
		wd.setTitle("Base64编码器");
		wd.setSize(1000,800);
		wd.setResizable(false);//取消用户调整窗口大小，固定窗口大小
		wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗口退出

		ImageIcon imageIcon=new ImageIcon("./Images/Title.png");
		wd.setIconImage(imageIcon.getImage());

		//FlowLayout FL = new FlowLayout();
		//wd.setLayout(null);	
		wd.setVisible(true);
	}

//Pane1：Base64
	public static void Pane1(){

		//FlowLayout FL = new FlowLayout();
		//left.setBackground(Color.red);
		//right.setBackground(Color.blue);
		left.setLayout(null);//为null才能自定义设置组件的大小位置
		right.setLayout(null);//为null才能自定义设置组件的大小位置
		//wd.add(left);
		//wd.add(right);

	//初始化一些JLabel
	encoder_main.setBounds(220,20,100,30);//(x,y,width,height)
	decoder_main.setBounds(220,20,100,30);//(x,y,width,height)

	Font main_font = new Font("",Font.PLAIN,30);

	encoder_main.setFont(main_font);
	decoder_main.setFont(main_font);
	
	Font second_third_font = new Font("",Font.PLAIN,15);

	encoder_second.setBounds(5,50,120,25);//(x,y,width,height)设置的整个JLabel的大小和位置，不是里面内容的大小
	decoder_second.setBounds(5,50,120,25);//(x,y,width,height)
	encoder_second.setFont(second_third_font);
	decoder_second.setFont(second_third_font);

	encoder_third.setBounds(5,390,120,25);//(x,y,width,height)
	decoder_third.setBounds(5,390,120,25);//(x,y,width,height)
	encoder_third.setFont(second_third_font);
	decoder_third.setFont(second_third_font);

	//初始化一些JTextArea
	//ET.setBounds(5,60,280,150);
	//DT.setBounds(5,60,300,150);
	ET.setLineWrap(true);        //激活自动换行功能 
	ET.setWrapStyleWord(true);            // 激活断行不断字功能
	DT.setLineWrap(true);        //激活自动换行功能 
	DT.setWrapStyleWord(true);            // 激活断行不断字功能

	//CET.setBounds(5,240,300,150);
	//CDT.setBounds(5,240,300,150);
	CET.setLineWrap(true);        //激活自动换行功能 
	CET.setWrapStyleWord(true);            // 激活断行不断字功能
	CDT.setLineWrap(true);        //激活自动换行功能 
	CDT.setWrapStyleWord(true);            // 激活断行不断字功能

	//初始化一些JButton
	Font ButtonFont = new Font("",Font.PLAIN,15);//设置字体的大小，字体格式等
	encoder.setFont(ButtonFont);
	decoder.setFont(ButtonFont);
	encoder.setBounds(400,50,80,20);
	decoder.setBounds(400,50,80,20);

	//初始化一些JScrollPane
	encoder_jsp.setBounds(5,80,480,300);//这里设置jsp的大小就等同于设置ET的大小，ET是跟随在jsp里面的
	encoder_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示
	decoder_jsp.setBounds(5,80,480,300);
	decoder_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	encoder_jsp_c.setBounds(5,420,480,300);
	encoder_jsp_c.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	decoder_jsp_c.setBounds(5,420,480,300);
	decoder_jsp_c.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//分割JFrame的分割线，JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,left,right);//这里第一个参数是控制分割线竖直，第二个参数是当你拖曳切割面版的分隔线时，窗口内的组件是否会随着分隔线的拖曳而动态改变大小，最后两个参数就是我分割完成后分割线两边各添加哪个容器。
		jsplit.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jsplit.setLeftComponent(left);
		jsplit.setRightComponent(right);
		jsplit.setDividerLocation(490);//分割线的位置  也就是初始位置
		jsplit.setOneTouchExpandable(false); //是否可展开或收起
		jsplit.setDividerSize(3);//设置分割线的宽度 像素为单位
		jsplit.setEnabled(false);//设置分割线不可拖动

//Jpane设置
		left.add(encoder_main);
		left.add(encoder_second);
		left.add(encoder_third);
		//left.add(ET);
		left.add(encoder_jsp);
		//left.add(CET);
		left.add(encoder_jsp_c);
		left.add(encoder);
		right.add(decoder_main);
		right.add(decoder_second);
		right.add(decoder_third);
		//right.add(DT);
		right.add(decoder_jsp);
		//right.add(CDT);
		right.add(decoder_jsp_c);
		right.add(decoder);
	}

//Pane2：Base64转图片
	public static void Pane2(){
		top.setLayout(null);//为null才能自定义设置组件的大小位置
		down.setLayout(null);//为null才能自定义设置组件的大小位置

	//初始化一些JLabel
	encoder_main.setBounds(0,0,800,30);//(x,y,width,height)

	Font main_font = new Font("",Font.PLAIN,20);

	encoder_main.setFont(main_font);
	encoder_main.setText("解密:(ps:生成的图片会被保存在软件根目录下的./OutputStreamFiles/images/下)");
	
	Font second_third_font = new Font("",Font.PLAIN,15);

	decoder_third.setBounds(0,0,120,25);//(x,y,width,height)
	decoder_third.setFont(second_third_font);
	decoder_third.setText("解密的内容如下:");

	//初始化一些JTextArea
	DTP.setLineWrap(true);        //激活自动换行功能 
	DTP.setWrapStyleWord(true);            // 激活断行不断字功能

	//初始化一些JScrollPane
	top_jsp.setViewportView(DTP);
	top_jsp.setBounds(5,35,970,110);//这里设置jsp的大小就等同于设置ET的大小，ET是跟随在jsp里面的
	top_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示

	//初始化一些JButton
	Font ButtonFont = new Font("",Font.PLAIN,15);//设置字体的大小，字体格式等
	decoder2.setFont(ButtonFont);
	decoder2.setBounds(880,10,80,20);
	//decoder.setText("生成");

		//分割JFrame的分割线，JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT/*,true,top,down*/);//这里第一个参数是控制分割线竖直，第二个参数是当你拖曳切割面版的分隔线时，窗口内的组件是否会随着分隔线的拖曳而动态改变大小，最后两个参数就是我分割完成后分割线两边各添加哪个容器。
		jsplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jsplit.setTopComponent(top);
		jsplit.setBottomComponent(down);
		jsplit.setDividerLocation(150);//分割线的位置  也就是初始位置
		jsplit.setOneTouchExpandable(false); //是否可展开或收起
		jsplit.setDividerSize(3);//设置分割线的宽度 像素为单位
		jsplit.setEnabled(false);//设置分割线不可拖动

		top.add(encoder_main);
		top.add(top_jsp);
		top.add(decoder2);
		down.add(decoder_third);
	}

	//Pane3：图片转Base64
	public static void Pane3(){
		top2.setLayout(null);//为null才能自定义设置组件的大小位置
		down2.setLayout(null);//为null才能自定义设置组件的大小位置

		//初始化一些JLabel
		encoder_main.setBounds(430,0,120,30);

		Font main_font = new Font("",Font.PLAIN,30);

		encoder_main.setFont(main_font);
		encoder_main.setText("加密图片");

		Font second_third_font = new Font("",Font.PLAIN,15);

		encoder_second.setBounds(375,30,300,30);//(x,y,width,height)
		encoder_second.setFont(second_third_font);
		encoder_second.setText("请先添加要加密的图片再点击生成");
		encoder_third.setBounds(0,0,300,30);
		encoder_third.setFont(second_third_font);
		encoder_third.setText("加密的内容如下：");

		//初始化一些JTextArea
		CETP.setLineWrap(true);        //激活自动换行功能 
		CETP.setWrapStyleWord(true);            // 激活断行不断字功能

		//初始化一些JScrollPane
		down2_jsp.setViewportView(CETP);
		down2_jsp.setBounds(5,30,970,110);//这里设置jsp的大小就等同于设置ET的大小，ET是跟随在jsp里面的
		down2_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//默认的设置是超过文本框才会显示滚动条，以下设置让滚动条一直显示

		//初始化一些JButton
		Font ButtonFont = new Font("",Font.PLAIN,16);//设置字体的大小，字体格式等
		encoder2.setFont(ButtonFont);
		encoder2.setBounds(520,55,80,20);
		AddFile.setFont(ButtonFont);
		AddFile.setBounds(380,55,80,20);
		AddFile.setActionCommand("open");

		//分割JFrame的分割线，JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT/*,true,top,down*/);//这里第一个参数是控制分割线竖直，第二个参数是当你拖曳切割面版的分隔线时，窗口内的组件是否会随着分隔线的拖曳而动态改变大小，最后两个参数就是我分割完成后分割线两边各添加哪个容器。
		jsplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jsplit.setTopComponent(top2);
		jsplit.setBottomComponent(down2);
		jsplit.setDividerLocation(585);//分割线的位置  也就是初始位置
		jsplit.setOneTouchExpandable(false); //是否可展开或收起
		jsplit.setDividerSize(3);//设置分割线的宽度 像素为单位
		jsplit.setEnabled(false);//设置分割线不可拖动

		top2.add(encoder_main);
		top2.add(encoder_second);
		top2.add(encoder2);
		top2.add(AddFile);
		down2.add(down2_jsp);
		down2.add(encoder_third);
	}

	//加密函数
	public static void EnCode(String goal){
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encode = encoder.encode(goal.getBytes());
		System.out.println("【加密后的数据】" + new String(encode));
		CET.setText(new String(encode));
	}

	//解密函数
	public static void DeCode(String goal){
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decode =decoder.decode(goal);
		System.out.println("【解密后的数据】" + new String(decode));
		CDT.setText(new String(decode));
	}
	
	/*
	imgstr base64编码字符串
	*/
	//Base64转图片的解密涵数
	public static boolean Base64ToImage(String imgstr){
		if (imgstr == null){
			return false;
		}
		//System.out.println(imgstr);
		Base64.Decoder decoder = Base64.getDecoder();
		try{
			//解密
			byte[] goal = decoder.decode(imgstr);
			//处理数据
			for (int i = 0 ; i < goal.length  ; ++i ){
				if (goal[i] < 0){
					goal[i] += 256;
				}
			}

			//保存文件，文件夹不存在就自动创建
			File temFile = new File("./OutputStreamFiles/images/"+PictureName+".png");
			if (!temFile.getParentFile().exists()){
				temFile.getParentFile().mkdirs();
			}
			OutputStream out = new FileOutputStream(temFile);
			out.write(goal);
			out.flush();
			out.close();
			//out.flush();
			return true;
		}
		catch (Exception e){
			return false;
		}
	}

	/*
		
	*/
	//图片转Base64加密函数
	public static String ImageToBase64(String imgpath) {
		InputStream inputStream = null;
		byte[] goal = null;
		try {
			inputStream = new FileInputStream(imgpath);
			goal = new byte[inputStream.available()];
			inputStream.read(goal);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加密
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(goal);
	}
}