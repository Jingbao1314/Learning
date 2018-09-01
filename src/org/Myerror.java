package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jingbao on 18-1-4.
 */
public class Myerror extends JFrame{

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
    public Myerror() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(2);

        JLabel lblNewLabel = new JLabel("    \u64CD\u4F5C\u5931\u8d25");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 50));
        lblNewLabel.setBounds(21, 77, 303, 61);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("\u9000\u51FA ");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Myerror.this.dispose();
            }
        });
        btnNewButton.setBounds(63, 180, 93, 23);
        contentPane.add(btnNewButton);

        JButton button = new JButton("\u8FD4\u56DE");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Myerror.this.toBack();

            }
        });
        button.setBounds(237, 180, 93, 23);
        contentPane.add(button);
    }
}
