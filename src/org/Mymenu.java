package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by jingbao on 18-1-4.
 */
public class Mymenu extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mymenu frame = new Mymenu();
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
    public Mymenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("     \u8BF7\u9009\u62E9\u60A8\u8981\u7684\u529F\u80FD");
        lblNewLabel.setBounds(99, 10, 191, 62);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("\u6DFB\u52A0");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Myinsert text=new Myinsert();
                text.setVisible(true);

            }
        });
        btnNewButton.setBounds(56, 73, 98, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u5220\u9664");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Mydelete text=new Mydelete();
                text.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(214, 73, 93, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u67E5\u627E");
        btnNewButton_2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                MYselect text=new MYselect();
                text.setVisible(true);
            }
        });
        btnNewButton_2.setBounds(56, 166, 93, 23);
        contentPane.add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("\u7F16\u8F91");
        btnNewButton_3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                Myupdate text=new Myupdate();
                text.setVisible(true);
            }
        });
        btnNewButton_3.setBounds(214, 166, 93, 23);
        contentPane.add(btnNewButton_3);
    }

}
