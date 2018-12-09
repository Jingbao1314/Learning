package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jingbao on 18-1-4.
 */
public class Mydelete extends JFrame{

    private JPanel contentPane;
    private JTextPane textPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mydelete frame = new Mydelete();
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
    public Mydelete() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(2);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        textPane = new JTextPane();
        textPane.setBounds(208, 106, 78, 21);
        contentPane.add(textPane);

        JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u4F60\u8981\u5220\u9664\u7684\u5B66\u751F\u5B66\u53F7");
        lblNewLabel.setBounds(32, 81, 223, 73);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("\u786E\u5B9A");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                int flag=JDBCmothed.delete(textPane.getText());
                if(flag==0){
                    System.out.println("删除失败，请检查ID");
                }else{
                    System.out.println("删除成功");
                    Mytap frame = new Mytap();
                    frame.setVisible(true);
                }
            }
        });
        btnNewButton.setBounds(292, 106, 93, 23);
        contentPane.add(btnNewButton);
    }

}
