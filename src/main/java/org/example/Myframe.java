package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.example.Main.*;

public class Myframe extends JFrame implements ActionListener {
    ImageIcon image = new ImageIcon("E:\\IMP Docs\\IMG_20230521_221901_364-removebg-preview.png");
    JLabel label = new JLabel();
    JButton button = new JButton();
    JButton button2 = new JButton();
    String[] options = {"Bubble Sort", "Selection Sort", "Insertion Sort" ,"Merge Sort"};
    JComboBox<String> comboBox = new JComboBox<>(options);
    Myframe(){
        this.setTitle("Sorting Visualizer"); //sets title on nav bar
        this.setSize(600,600); //sets dimesnions
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close on clicking cross icon

        //this.setResizable(false); //sets resize impossible


        this.setIconImage(image.getImage());

        this.getContentPane().setBackground(Color.pink);


        label.setText("Sorting Visualizer");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setBackground(Color.PINK);
        label.setVisible(true);
        label.setFont(new Font("Times New Roman",Font.BOLD,20));
        label.setForeground(Color.black);
        label.setOpaque(true);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(150, 50, 300, 50);
        label.setIcon(image);
        this.add(label);



        comboBox.setBounds(225, 200, 150, 30);
        comboBox.addActionListener(this);
        comboBox.setBackground(Color.WHITE);
        // Add to a container
        this.add(comboBox);

        //Button
        button.setBounds(250, 250, 100, 30);
        //button.setHorizontalAlignment(JButton.CENTER);
        button.addActionListener(this);
        button.setText("SUBMIT");
        button.setFocusable(false);
        button.setBackground(Color.WHITE);

        button2.setBounds(200, 100, 200, 30);
        //button.setHorizontalAlignment(JButton.CENTER);
        button2.addActionListener(this);
        button2.setText("Generate Random Array");
        button2.setFocusable(false);
        button2.setBackground(Color.WHITE);
//        button.setIcon(image);
        this.add(button);
        this.add(button2);
        this.setLayout(null);
        this.setVisible(true);//sets visibility

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button){
            String selectedOption = (String) comboBox.getSelectedItem();

            switch (selectedOption) {
                case "Bubble Sort":
                    //JOptionPane.showMessageDialog(this, "You Selected Bubble Sort " );
                    Bubble b = new Bubble();
                    break;

                case "Selection Sort":
                    //JOptionPane.showMessageDialog(this, "You Selected Selection Sort ");
                    Selection s = new Selection();
                    break;

                case "Insertion Sort":
                    JOptionPane.showMessageDialog(this, "Insertion Sort is not yet available");
                    //Insertion i = new Insertion();
                    break;

                case "Merge Sort":
                    JOptionPane.showMessageDialog(this, "Merge Sort is not yet available");
                    break;

                default:
                    JOptionPane.showMessageDialog(this, "No action selected.");
                    break;
        }

    }if(e.getSource()==button2){
            arr = generateRandomArray(50);
            JOptionPane.showMessageDialog(this, "Random Array is Generated");
        }
}}
