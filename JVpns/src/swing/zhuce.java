package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;

public class zhuce {

	public JFrame frame;
	private JFrame zhu;
	/**
	 * Create the application.
	 */
	public zhuce(JFrame z) {
		this.zhu=z;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 420, 293);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setBounds(69, 73, 72, 18);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u6CE8\u518C");
		label_1.setBounds(182, 13, 72, 18);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D");
		label_2.setBounds(69, 140, 72, 18);
		frame.getContentPane().add(label_2);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(155, 70, 142, 24);
		frame.getContentPane().add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(155, 137, 142, 24);
		frame.getContentPane().add(formattedTextField_1);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.setBounds(93, 192, 63, 27);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhu.setEnabled(true);
				zhuce.this.frame.dispose();
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
		button_1.setBounds(250, 192, 63, 27);
		frame.getContentPane().add(button_1);
	}

}
