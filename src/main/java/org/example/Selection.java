package org.example;

import javax.swing.*;
import java.awt.*;

public class Selection extends JPanel {

    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    int currentIndex = -1;
    int comparingIndex = -1;


    Selection() {
        JFrame frame = new JFrame("Selection Sort");
        frame.setSize(WIDTH, HEIGHT + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

        new Thread(() -> {
            try {
                selection(Main.arr);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    void selection(int[] arr) throws InterruptedException {
        int min = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    currentIndex = j;
                    comparingIndex = j+1;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    repaint();
                    Thread.sleep(50);
                }
            }
        }
    }
    // Drawing the array bars
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] arr = Main.arr;  // Access global array
        int barWidth = WIDTH / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (i == currentIndex) {
                g.setColor(Color.RED); // Currently selected bar
            } else if (i == comparingIndex) {
                g.setColor(Color.GREEN); // Currently compared bar
            } else {
                g.setColor(Color.BLUE); // Default color
            }
            g.fillRect(i * barWidth, HEIGHT - arr[i], barWidth, arr[i]);
            g.setColor(Color.BLACK);
            g.drawRect(i * barWidth, HEIGHT - arr[i], barWidth, arr[i]);
        }
    }


}
