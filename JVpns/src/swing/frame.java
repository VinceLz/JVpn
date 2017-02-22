package swing;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import vpn.JVpn;
import vpn.JVpn.eDll;

public class frame {

	private JFrame frame;
	private JButton button;
	private JButton button_1;
	private JPasswordField passwordField;
	public String yzm;
	private JTextField textField;
	private JLabel label_2;
	private int re;
	private JButton button_2;
	private Properties properties;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame window = new frame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u767B\u5F55");
		frame.setResizable(false);
		frame.setBounds(100, 100, 535, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(78, 54, 72, 18);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(78, 147, 45, 18);
		frame.getContentPane().add(label_1);

		final JButton btnNewButton = new JButton("登录");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				String usrname = textField.getText();
				String pwd = passwordField.getText();

				String resu = vpn.Util.sendGet("http://172.16.120.237:8080/carshop/vpn.action",
						"username=" + usrname + "&password=" + pwd + "&yz=" + yzm);

				System.out.println(resu);
				String[] split = resu.split(",");
				if (split[0].equals("200")) {
					JVpn.eDll.INSTANCE2.createVpn("CMCC", split[1], split[2], split[3], 1);
					re = JVpn.eDll.INSTANCE2.AddConnection("CMCC", "", "", split[1], split[2], "");
					if (re == 0) {
						JVpn.eDll.INSTANCE2.dialog(1);
						label_2.setText("剩余天数:"+split[4]);
						label_2.setVisible(true);
						button_2.setVisible(false);
						button_1.setVisible(false);
						properties.setProperty("username", split[1]);
						properties.setProperty("passwd", split[2]); 
						 
						System.out.println(properties.getProperty("username"));
					}
				} else {
					btnNewButton.setEnabled(true);
					JVpn.eDll.INSTANCE2.dialog(0);
				}
				Data.keyval = eDll.INSTANCE2.getRasCode();
			}
		});
		btnNewButton.setBounds(96, 231, 72, 40);
		frame.getContentPane().add(btnNewButton);

		button = new JButton("\u9000\u51FA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("rasdial CMCC /disconnect");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JVpn.eDll.INSTANCE2.close(Data.keyval);
				frame.dispose();
			}

		});
		button.setBounds(307, 231, 72, 40);
		frame.getContentPane().add(button);

		button_1 = new JButton("\u5145\u503C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chongzhi cz = new chongzhi(frame.this.frame);
				cz.frame.setVisible(true);
				frame.this.frame.setEnabled(false);
			}
		});
		button_1.setBounds(423, 136, 72, 40);
		frame.getContentPane().add(button_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(137, 144, 151, 24);
		frame.getContentPane().add(passwordField);

		button_2 = new JButton("\u6CE8\u518C");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuce window = new zhuce(frame.this.frame);
				window.frame.setVisible(true);
				frame.this.frame.setEnabled(false);
			}
		});
		frame.addWindowListener(new WindowListener() {

			

			public void windowOpened(WindowEvent e) {
				// ��ȡӲ������
				yzm = JVpn.eDll.INSTANCE2.getYzm();
				// ���ر��������
				System.out.println("asadas");
				InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("key.propertys");
				properties = new Properties();
				try {
					properties.load(resourceAsStream);
					String user = properties.getProperty("username");
					String pwd = properties.getProperty("passwd");
					textField.setText(pwd);
					passwordField.setText(pwd);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowDeactivated(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				System.out.println("�ر�");
				try {
					Runtime.getRuntime().exec("rasdial CMCC /disconnect");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JVpn.eDll.INSTANCE2.close(Data.keyval);
			}

			public void windowClosed(WindowEvent e) {

			}

			public void windowActivated(WindowEvent e) {

			}
		});
		button_2.setBounds(423, 43, 72, 40);
		frame.getContentPane().add(button_2);

		textField = new JTextField();
		textField.setBounds(137, 51, 151, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JCheckBox checkBox = new JCheckBox("\u4FDD\u5B58\u5BC6\u7801");
		checkBox.setSelected(true);
		checkBox.setBounds(311, 143, 102, 27);
		frame.getContentPane().add(checkBox);
		label_2 = new JLabel("11");
		label_2.setBounds(78, 100, 72, 18);
		frame.getContentPane().add(label_2);
		label_2.setVisible(false);
	}
}
