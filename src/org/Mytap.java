package org;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mytap extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mytap frame = new Mytap();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mytap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(2);
		JLabel lblNewLabel = new JLabel("    \u64CD\u4F5C\u6210\u529F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 50));
		lblNewLabel.setBounds(21, 77, 303, 61);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u9000\u51FA ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mytap.this.dispose();
			}
		});
		btnNewButton.setBounds(63, 180, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Mytap.this.toBack();
				
			}
		});
		button.setBounds(237, 180, 93, 23);
		contentPane.add(button);
	}
}
