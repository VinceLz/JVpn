package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.event.ActionEvent;

public class chongzhi {

	public JFrame frame;
	private JFrame zhu;
	

	/**
	 * Create the application.
	 */
	public chongzhi(JFrame z) {
		this.zhu=z;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 399, 335);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u5145\u503C");
		label.setBounds(165, 13, 72, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setBounds(32, 79, 72, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u5361\u5BC6");
		label_2.setBounds(32, 163, 63, 18);
		frame.getContentPane().add(label_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(100, 76, 218, 24);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(100, 160, 218, 24);
		frame.getContentPane().add(formattedTextField_1);
		
		JButton button = new JButton("\u5145\u503C");
		button.setBounds(75, 230, 63, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhu.setEnabled(true);
				chongzhi.this.frame.dispose();
			}
		});
		frame.addWindowListener(new WindowListener() {
			
			public void windowOpened(WindowEvent e) {
				
			}
			
			public void windowIconified(WindowEvent e) {
				
			}
			
			public void windowDeiconified(WindowEvent e) {
				
			}
			
			public void windowDeactivated(WindowEvent e) {
				
			}
			
			public void windowClosing(WindowEvent e) {
				zhu.setEnabled(true);
			}
			
			public void windowClosed(WindowEvent e) {
				
			}
			
			public void windowActivated(WindowEvent e) {
				
			}
		});
		button_1.setBounds(255, 230, 63, 27);
		frame.getContentPane().add(button_1);
	}

}
