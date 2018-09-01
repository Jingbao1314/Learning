package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jingbao on 18-1-4.
 */
public class MYselect extends JFrame{
    private Student myresult;

    private JPanel contentPane;
    private JTextArea textArea_2;

    public Student getMyresult() {
        return myresult;
    }

    public void setMyresult(Student myresult) {
        this.myresult = myresult;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MYselect frame = new MYselect();
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
    public MYselect() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(2);
//
        JTextArea textArea = new JTextArea();
        textArea.setBounds(216, 91, -170, 24);
        contentPane.add(textArea);

        JTextArea textArea_1 = new JTextArea();
        textArea_1.setBounds(151, 128, -90, 24);
        contentPane.add(textArea_1);

        JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u67E5\u627E\u5B66\u751F\u7684\u5B66\u53F7");
        lblNewLabel.setBounds(28, 120, 161, 15);
        contentPane.add(lblNewLabel);

        textArea_2 = new JTextArea();
        textArea_2.setBounds(227, 116, 63, 24);
        contentPane.add(textArea_2);

        JButton btnNewButton = new JButton("\u786E\u5B9A");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Student student=JDBCmothed.select(textArea_2.getText());
                //student=null;
                if(student.getFlag()==1){
                    //System.out.println("查询失败，请检查用户名");
                    System.out.println("查询成功");
                    Myresult frame = new Myresult(student);

                    frame.setVisible(true);
                }else{
                    System.out.println("查询失败，请检查用户名");
                }
            }
        });
        btnNewButton.setBounds(300, 116, 93, 23);
        contentPane.add(btnNewButton);
    }
}
