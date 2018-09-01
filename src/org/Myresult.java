package org;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jingbao on 18-1-4.
 */
public class Myresult extends JFrame{
    private Student result;
    private JPanel contentPane;
    private JTextPane textPane;
    private JTextPane textPane_1;
    private JTextPane textPane_2;
    private JTextPane textPane_3;
    private JTextPane textPane_4;
    private JLabel lblNewLabel;
    private JLabel lblId;
    private JLabel label;
    private JTextPane textPane_5;
    private JLabel label_1;
    private JLabel label_2;
    private JLabel label_3;
    private JTextPane textPane_6;
    private JRadioButton rdbtnNewRadioButton;

    public Student getResult() {
        return result;
    }

    public void setResult(Student result) {
        this.result = result;
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Mytext frame = new Mytext();
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
    public Myresult(Student student) {
//        student.setName(textPane_2.getText());
//        //student.setId(Integer.parseInt(textPane_3.getText()));
//        if(textPane_3.getText()!=null){
//            student.setId(Integer.parseInt(textPane_3.getText()));
//        }
//        student.setMajor(textPane_3.getText());
//        student.setState(textPane_5.getText());
//        student.setMajor(textPane_4.getText());
//        student.setEntrance(textPane_6.getText());
//        student.setSex(rdbtnNewRadioButton.getText());
        this.result=student;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 364);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(2);
        textPane = new JTextPane();
        textPane.setBounds(301, 169, -141, 21);
        textPane.setText(result.getName());
        contentPane.add(textPane);


        textPane_1 = new JTextPane();
        textPane_1.setBounds(244, 169, -91, 21);
        contentPane.add(textPane_1);

        textPane_2 = new JTextPane();
        textPane_2.setBounds(160, 51, 89, 21);
        textPane_2.setText(result.getName());
        contentPane.add(textPane_2);

        textPane_3 = new JTextPane();
        textPane_3.setBounds(160, 92, 89, 21);
        textPane_3.setText(Integer.toString(result.getId()));
        contentPane.add(textPane_3);

        textPane_4 = new JTextPane();
        textPane_4.setBounds(160, 128, 89, 21);
        textPane_4.setText(result.getMajor());
        contentPane.add(textPane_4);

        lblNewLabel = new JLabel("\u59D3\u540D");
        lblNewLabel.setBounds(99, 57, 54, 15);
        contentPane.add(lblNewLabel);

        lblId = new JLabel("ID");
        lblId.setBounds(99, 92, 54, 15);
        contentPane.add(lblId);

        label = new JLabel("\u4E13\u4E1A");
        label.setBounds(96, 134, 54, 15);
        contentPane.add(label);

        textPane_5 = new JTextPane();
        textPane_5.setBounds(160, 169, 89, 21);
        textPane_5.setText(result.getState());
        contentPane.add(textPane_5);

        label_1 = new JLabel("\u5728\u5B66\u72B6\u6001");
        label_1.setBounds(99, 169, 54, 15);
        contentPane.add(label_1);

        label_2 = new JLabel("\u6027\u522B");
        label_2.setBounds(96, 228, 54, 15);
        contentPane.add(label_2);

        rdbtnNewRadioButton = new JRadioButton("\u7537");
        rdbtnNewRadioButton.setBounds(160, 224, 59, 23);
        rdbtnNewRadioButton.setText(result.getSex());
        contentPane.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u5973");
        rdbtnNewRadioButton_1.setBounds(221, 224, 121, 23);
        contentPane.add(rdbtnNewRadioButton_1);

        JButton btnNewButton = new JButton("\u8FD4\u56DE");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Myresult.this.toBack();
            }
        });
        btnNewButton.setBounds(156, 272, 93, 23);
        contentPane.add(btnNewButton);

        label_3 = new JLabel("\u5165\u5B66\u65E5\u671F ");
        label_3.setBounds(99, 203, 54, 15);
        contentPane.add(label_3);

        textPane_6 = new JTextPane();
        textPane_6.setBounds(160, 200, 89, 21);
        textPane_6.setText(result.getEntrance());
        contentPane.add(textPane_6);
    }


}
