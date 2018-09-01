package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jingbao on 18-1-4.
 */
public class Myupdate extends JFrame{
    private JPanel contentPane;
    private JTextPane textPane;
    private JTextPane textPane_1;
    private JTextPane textPane_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Myupdate frame = new Myupdate();
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
    public Myupdate() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        JLabel mylblNewLabel = new JLabel("请输入修改学生的学号");//学号
        mylblNewLabel.setBounds(95, 4, 200, 15);
        contentPane.add(mylblNewLabel);

        JLabel lblNewLabel = new JLabel("学号");//学号
        lblNewLabel.setBounds(95, 54, 54, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("\u4E13\u4E1A");
        lblNewLabel_1.setBounds(95, 104, 54, 15);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u5728\u5B66\u72B6\u6001");
        lblNewLabel_2.setBounds(95, 150, 54, 15);
        contentPane.add(lblNewLabel_2);

        textPane = new JTextPane();
        textPane.setBounds(192, 54, 92, 21);
        contentPane.add(textPane);

        textPane_1 = new JTextPane();
        textPane_1.setBounds(192, 104, 92, 21);
        contentPane.add(textPane_1);

        textPane_2 = new JTextPane();
        textPane_2.setBounds(192, 144, 92, 21);
        contentPane.add(textPane_2);

        JButton btnNewButton = new JButton("\u63D0\u4EA4");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Mytap frame = new Mytap();
                Student stu=new Student();
                stu.setId(Integer.parseInt(textPane.getText()));
                stu.setMajor(textPane_1.getText());
                stu.setState(textPane_2.getText());
                JDBCmothed.update(stu);
                frame.setVisible(true);

                System.out.println("修改成功");

            }
        });
        btnNewButton.setBounds(95, 214, 93, 23);
        contentPane.add(btnNewButton);
    }
}
