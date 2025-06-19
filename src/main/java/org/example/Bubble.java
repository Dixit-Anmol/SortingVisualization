package org.example;

import javax.swing.*;
import java.awt.*;

public class Bubble extends JPanel {

    private final int WIDTH = 800;
    private final int HEIGHT = 400;
    int currentIndex = -1;
    int comparingIndex = -1;

    // Start the sorting visualization
    Bubble() {
        JFrame frame = new JFrame("Bubble Sort");
        frame.setSize(WIDTH, HEIGHT + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        frame.add(this);
        frame.setVisible(true);

        new Thread(() -> {
            try {
                bubbleSort(Main.arr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    // Bubble Sort with visualization
    public void bubbleSort(int[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    currentIndex = j;
                    comparingIndex = j+1;
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

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
