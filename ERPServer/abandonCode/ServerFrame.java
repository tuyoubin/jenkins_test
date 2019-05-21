package runner;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rmi.RemoteHelper;

public class ServerFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private RemoteHelper remoteHelper;
	
	public static void main(String[] args) {
		new ServerFrame();
	}
	
	public ServerFrame() {
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		
		JTextField textField = new JTextField("服务器启动中……");
		textField.setFont(new Font("Serif", Font.PLAIN, 56));
		textField.setEditable(false);
		panel.add(textField);
		
		invokeServerRunner();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void invokeServerRunner() {
		remoteHelper = new RemoteHelper();
	}

}
