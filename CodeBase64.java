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
//               ���汣��             ����BUG 
//       ��Ի:  
//               д��¥��д�ּ䣬д�ּ������Ա��  
//               ������Աд�������ó��򻻾�Ǯ��  
//               ����ֻ���������������������ߣ�  
//               ��������ո��գ����������긴�ꡣ  
//               ��Ը�������Լ䣬��Ը�Ϲ��ϰ�ǰ��  
//               ���۱������Ȥ���������г���Ա��  
//               ����Ц��߯��񲣬��Ц�Լ���̫����  
//               ��������Ư���ã��ĸ���ó���Ա�� 

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
	public static JLabel encoder_main = new JLabel("����");
	public static JLabel decoder_main = new JLabel("����");
	public static JLabel encoder_second = new JLabel("����Ҫ���ܵ�����");
	public static JLabel decoder_second = new JLabel("����Ҫ���ܵ�����");
	public static JLabel encoder_third = new JLabel("���ܵ����ݵ�����");
	public static JLabel decoder_third = new JLabel("���ܵ����ݵ�����");
	public static JLabel picture1 = new JLabel();
	public static JLabel picture2 = new JLabel();
	public static JTextArea ET = new JTextArea();//ET=EncoderText
	public static JTextArea DT = new JTextArea();//DT=DecoderText
	public static JTextArea CET = new JTextArea();//CET=CompletelyEncoderText
	public static JTextArea CDT = new JTextArea();//CAT=CompletelyDecoderText
	public static JTextArea DTP = new JTextArea();//DTP=DecoderTextPicture
	public static JTextArea CETP = new JTextArea();//CETP=CompletelyEncoderTextPicture
	public static JButton encoder = new JButton("����");
	public static JButton decoder = new JButton("����");
	public static JButton decoder2 = new JButton("����");//Base64תͼƬ������
	public static JButton encoder2 = new JButton("����");//ͼƬתBase64������
	public static JButton AddFile = new JButton("���");	//���ͼƬ������תBase64
	//�����ǹ��������
	public static JScrollPane encoder_jsp = new JScrollPane(ET);//jsp=JScrollPane
	public static JScrollPane decoder_jsp = new JScrollPane(DT);
	public static JScrollPane encoder_jsp_c = new JScrollPane(CET);//jsp_c=JScrollPane_Complete
	public static JScrollPane decoder_jsp_c = new JScrollPane(CDT);
	public static JScrollPane top_jsp = new JScrollPane(DTP);
	public static JScrollPane down2_jsp = new JScrollPane(CETP);
	public static JMenuBar menubar =new JMenuBar();
	public static JMenu menu1 = new JMenu("Base64");
	public static JMenu menu2 = new JMenu("Base64תͼƬ");
	public static JMenu menu3 = new JMenu("ͼƬתBase64");

	//���ɽ��ܺ��ͼƬ
	public static String PictureName;
	public static Image img;

	public static String EncoderImagePath;

    public static void main(String[] args) {
		Pane1();
		UI();

		//String a = ImageToBase64("./1.jpg");
		//System.out.println(a);
		 
		 //�˵���ť���¼�����

		 //menu1���¼�����
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

		//menu2���¼�����
		 menu2.addMenuListener(new MenuListener() {
           public void menuSelected(MenuEvent e) {//ѡ��
			   //System.out.println("This is Menu2's UI Pane");
			   Pane2();
           }
           public void menuDeselected(MenuEvent e) {//ȡ��ѡ��
			   Pane2();
           }
           public void menuCanceled(MenuEvent e) {
           }
         });

		 //menu3���¼�����
		 menu3.addMenuListener(new MenuListener(){
			public void menuSelected(MenuEvent e){
				Pane3();
			}
			public void menuDeselected(MenuEvent e){
				
			}
			public void menuCanceled(MenuEvent e){
				
			}
		 });

//���ܰ�ť��Ӽ��ܺ�������
		encoder.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				String goal = ET.getText();
				EnCode(goal);
			}
		});

//���ܰ�ť��ӽ��ܺ�������
		decoder.addActionListener(new ActionListener(){
			@Override
				public void actionPerformed(ActionEvent e){
					String goal = DT.getText();
					DeCode(goal);
				}
		});

		//Base64תͼƬ��ť���ܺ���
	decoder2.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e){
				String goal = DTP.getText();
				PictureName = UUID.randomUUID().toString();
				boolean b = Base64ToImage(goal);//bֻ��Ϊ��ִ��Base64ToImage������д�ģ�����ҪĿ��Ҳ��Ϊ�˼��goal�ĸ�ʽ�Ƿ����Base64����
				System.out.println(b);
				
				ImageIcon imageIcon = new ImageIcon("./OutputStreamFiles/images/"+PictureName+".png"); // load the image to a imageIcon
				Image image = imageIcon.getImage(); // transform it 
				Image newimg = image.getScaledInstance(600, 600,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
				imageIcon = new ImageIcon(newimg);  // transform it back

				picture1.setBounds(200,5,600,600);
				picture1.setIcon(imageIcon);//�ļ�·��
				down.add(picture1);
				down.repaint();
			}
	});

//����ļ���ť���¼���Ӧ
	AddFile.addActionListener(new ActionListener(){
		@Override
			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand().equals("open")){
					JFileChooser jfc = new JFileChooser();
					jfc.showOpenDialog(wd);//��ʾ�򿪵��ļ��Ի���
					File f = jfc.getSelectedFile();//ʹ���ļ����ȡѡ����ѡ����ļ�
					String s = f.getAbsolutePath();//����·����
					EncoderImagePath = s;
					//System.out.println(s);

					ImageIcon imageIcon = new ImageIcon(s); // load the image to a imageIcon
					Image image = imageIcon.getImage(); // transform it 
					Image newimg = image.getScaledInstance(500, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
					imageIcon = new ImageIcon(newimg);  // transform it back

					picture2.setBounds(240,80,500,500);
					picture2.setIcon(imageIcon);//�ļ�·��
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

//UI��ʼ������
	public static void UI(){

//��������
		wd.add(jsplit);//���뵽�����

		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		
		wd.setJMenuBar(menubar);
		wd.setTitle("Base64������");
		wd.setSize(1000,800);
		wd.setResizable(false);//ȡ���û��������ڴ�С���̶����ڴ�С
		wd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳�

		ImageIcon imageIcon=new ImageIcon("./Images/Title.png");
		wd.setIconImage(imageIcon.getImage());

		//FlowLayout FL = new FlowLayout();
		//wd.setLayout(null);	
		wd.setVisible(true);
	}

//Pane1��Base64
	public static void Pane1(){

		//FlowLayout FL = new FlowLayout();
		//left.setBackground(Color.red);
		//right.setBackground(Color.blue);
		left.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��
		right.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��
		//wd.add(left);
		//wd.add(right);

	//��ʼ��һЩJLabel
	encoder_main.setBounds(220,20,100,30);//(x,y,width,height)
	decoder_main.setBounds(220,20,100,30);//(x,y,width,height)

	Font main_font = new Font("",Font.PLAIN,30);

	encoder_main.setFont(main_font);
	decoder_main.setFont(main_font);
	
	Font second_third_font = new Font("",Font.PLAIN,15);

	encoder_second.setBounds(5,50,120,25);//(x,y,width,height)���õ�����JLabel�Ĵ�С��λ�ã������������ݵĴ�С
	decoder_second.setBounds(5,50,120,25);//(x,y,width,height)
	encoder_second.setFont(second_third_font);
	decoder_second.setFont(second_third_font);

	encoder_third.setBounds(5,390,120,25);//(x,y,width,height)
	decoder_third.setBounds(5,390,120,25);//(x,y,width,height)
	encoder_third.setFont(second_third_font);
	decoder_third.setFont(second_third_font);

	//��ʼ��һЩJTextArea
	//ET.setBounds(5,60,280,150);
	//DT.setBounds(5,60,300,150);
	ET.setLineWrap(true);        //�����Զ����й��� 
	ET.setWrapStyleWord(true);            // ������в����ֹ���
	DT.setLineWrap(true);        //�����Զ����й��� 
	DT.setWrapStyleWord(true);            // ������в����ֹ���

	//CET.setBounds(5,240,300,150);
	//CDT.setBounds(5,240,300,150);
	CET.setLineWrap(true);        //�����Զ����й��� 
	CET.setWrapStyleWord(true);            // ������в����ֹ���
	CDT.setLineWrap(true);        //�����Զ����й��� 
	CDT.setWrapStyleWord(true);            // ������в����ֹ���

	//��ʼ��һЩJButton
	Font ButtonFont = new Font("",Font.PLAIN,15);//��������Ĵ�С�������ʽ��
	encoder.setFont(ButtonFont);
	decoder.setFont(ButtonFont);
	encoder.setBounds(400,50,80,20);
	decoder.setBounds(400,50,80,20);

	//��ʼ��һЩJScrollPane
	encoder_jsp.setBounds(5,80,480,300);//��������jsp�Ĵ�С�͵�ͬ������ET�Ĵ�С��ET�Ǹ�����jsp�����
	encoder_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
	decoder_jsp.setBounds(5,80,480,300);
	decoder_jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	encoder_jsp_c.setBounds(5,420,480,300);
	encoder_jsp_c.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	decoder_jsp_c.setBounds(5,420,480,300);
	decoder_jsp_c.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

//�ָ�JFrame�ķָ��ߣ�JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,left,right);//�����һ�������ǿ��Ʒָ�����ֱ���ڶ��������ǵ�����ҷ�и����ķָ���ʱ�������ڵ�����Ƿ�����ŷָ��ߵ���ҷ����̬�ı��С������������������ҷָ���ɺ�ָ������߸�����ĸ�������
		jsplit.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		jsplit.setLeftComponent(left);
		jsplit.setRightComponent(right);
		jsplit.setDividerLocation(490);//�ָ��ߵ�λ��  Ҳ���ǳ�ʼλ��
		jsplit.setOneTouchExpandable(false); //�Ƿ��չ��������
		jsplit.setDividerSize(3);//���÷ָ��ߵĿ�� ����Ϊ��λ
		jsplit.setEnabled(false);//���÷ָ��߲����϶�

//Jpane����
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

//Pane2��Base64תͼƬ
	public static void Pane2(){
		top.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��
		down.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��

	//��ʼ��һЩJLabel
	encoder_main.setBounds(0,0,800,30);//(x,y,width,height)

	Font main_font = new Font("",Font.PLAIN,20);

	encoder_main.setFont(main_font);
	encoder_main.setText("����:(ps:���ɵ�ͼƬ�ᱻ�����������Ŀ¼�µ�./OutputStreamFiles/images/��)");
	
	Font second_third_font = new Font("",Font.PLAIN,15);

	decoder_third.setBounds(0,0,120,25);//(x,y,width,height)
	decoder_third.setFont(second_third_font);
	decoder_third.setText("���ܵ���������:");

	//��ʼ��һЩJTextArea
	DTP.setLineWrap(true);        //�����Զ����й��� 
	DTP.setWrapStyleWord(true);            // ������в����ֹ���

	//��ʼ��һЩJScrollPane
	top_jsp.setViewportView(DTP);
	top_jsp.setBounds(5,35,970,110);//��������jsp�Ĵ�С�͵�ͬ������ET�Ĵ�С��ET�Ǹ�����jsp�����
	top_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ

	//��ʼ��һЩJButton
	Font ButtonFont = new Font("",Font.PLAIN,15);//��������Ĵ�С�������ʽ��
	decoder2.setFont(ButtonFont);
	decoder2.setBounds(880,10,80,20);
	//decoder.setText("����");

		//�ָ�JFrame�ķָ��ߣ�JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT/*,true,top,down*/);//�����һ�������ǿ��Ʒָ�����ֱ���ڶ��������ǵ�����ҷ�и����ķָ���ʱ�������ڵ�����Ƿ�����ŷָ��ߵ���ҷ����̬�ı��С������������������ҷָ���ɺ�ָ������߸�����ĸ�������
		jsplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jsplit.setTopComponent(top);
		jsplit.setBottomComponent(down);
		jsplit.setDividerLocation(150);//�ָ��ߵ�λ��  Ҳ���ǳ�ʼλ��
		jsplit.setOneTouchExpandable(false); //�Ƿ��չ��������
		jsplit.setDividerSize(3);//���÷ָ��ߵĿ�� ����Ϊ��λ
		jsplit.setEnabled(false);//���÷ָ��߲����϶�

		top.add(encoder_main);
		top.add(top_jsp);
		top.add(decoder2);
		down.add(decoder_third);
	}

	//Pane3��ͼƬתBase64
	public static void Pane3(){
		top2.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��
		down2.setLayout(null);//Ϊnull�����Զ�����������Ĵ�Сλ��

		//��ʼ��һЩJLabel
		encoder_main.setBounds(430,0,120,30);

		Font main_font = new Font("",Font.PLAIN,30);

		encoder_main.setFont(main_font);
		encoder_main.setText("����ͼƬ");

		Font second_third_font = new Font("",Font.PLAIN,15);

		encoder_second.setBounds(375,30,300,30);//(x,y,width,height)
		encoder_second.setFont(second_third_font);
		encoder_second.setText("�������Ҫ���ܵ�ͼƬ�ٵ������");
		encoder_third.setBounds(0,0,300,30);
		encoder_third.setFont(second_third_font);
		encoder_third.setText("���ܵ��������£�");

		//��ʼ��һЩJTextArea
		CETP.setLineWrap(true);        //�����Զ����й��� 
		CETP.setWrapStyleWord(true);            // ������в����ֹ���

		//��ʼ��һЩJScrollPane
		down2_jsp.setViewportView(CETP);
		down2_jsp.setBounds(5,30,970,110);//��������jsp�Ĵ�С�͵�ͬ������ET�Ĵ�С��ET�Ǹ�����jsp�����
		down2_jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ

		//��ʼ��һЩJButton
		Font ButtonFont = new Font("",Font.PLAIN,16);//��������Ĵ�С�������ʽ��
		encoder2.setFont(ButtonFont);
		encoder2.setBounds(520,55,80,20);
		AddFile.setFont(ButtonFont);
		AddFile.setBounds(380,55,80,20);
		AddFile.setActionCommand("open");

		//�ָ�JFrame�ķָ��ߣ�JSplitPane
		//JSplitPane jsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT/*,true,top,down*/);//�����һ�������ǿ��Ʒָ�����ֱ���ڶ��������ǵ�����ҷ�и����ķָ���ʱ�������ڵ�����Ƿ�����ŷָ��ߵ���ҷ����̬�ı��С������������������ҷָ���ɺ�ָ������߸�����ĸ�������
		jsplit.setOrientation(JSplitPane.VERTICAL_SPLIT);
		jsplit.setTopComponent(top2);
		jsplit.setBottomComponent(down2);
		jsplit.setDividerLocation(585);//�ָ��ߵ�λ��  Ҳ���ǳ�ʼλ��
		jsplit.setOneTouchExpandable(false); //�Ƿ��չ��������
		jsplit.setDividerSize(3);//���÷ָ��ߵĿ�� ����Ϊ��λ
		jsplit.setEnabled(false);//���÷ָ��߲����϶�

		top2.add(encoder_main);
		top2.add(encoder_second);
		top2.add(encoder2);
		top2.add(AddFile);
		down2.add(down2_jsp);
		down2.add(encoder_third);
	}

	//���ܺ���
	public static void EnCode(String goal){
		Base64.Encoder encoder = Base64.getEncoder();
		byte[] encode = encoder.encode(goal.getBytes());
		System.out.println("�����ܺ�����ݡ�" + new String(encode));
		CET.setText(new String(encode));
	}

	//���ܺ���
	public static void DeCode(String goal){
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] decode =decoder.decode(goal);
		System.out.println("�����ܺ�����ݡ�" + new String(decode));
		CDT.setText(new String(decode));
	}
	
	/*
	imgstr base64�����ַ���
	*/
	//Base64תͼƬ�Ľ��ܺ���
	public static boolean Base64ToImage(String imgstr){
		if (imgstr == null){
			return false;
		}
		//System.out.println(imgstr);
		Base64.Decoder decoder = Base64.getDecoder();
		try{
			//����
			byte[] goal = decoder.decode(imgstr);
			//��������
			for (int i = 0 ; i < goal.length  ; ++i ){
				if (goal[i] < 0){
					goal[i] += 256;
				}
			}

			//�����ļ����ļ��в����ھ��Զ�����
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
	//ͼƬתBase64���ܺ���
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
		// ����
		Base64.Encoder encoder = Base64.getEncoder();
		return encoder.encodeToString(goal);
	}
}