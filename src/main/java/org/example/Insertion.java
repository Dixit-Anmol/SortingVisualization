package org.example;

import javax.swing.*;
import java.awt.*;

public class Insertion extends JPanel {
    int currentIndex =-1;
    int comparingIndex =-1;

    // Start the sorting visualization
    Insertion() {
        JFrame frame = new JFrame("Insertion Sort");
        frame.setSize(WIDTH, HEIGHT + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setVisible(true);

        new Thread(() -> {
            try {
                sort(Main.arr);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    /* Function to sort array using insertion sort */
    void sort(int arr[]) throws InterruptedException {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            repaint();
            Thread.sleep(50);

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;

            }
            arr[j + 1] = key;

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
                g.setColor(Color.PINK); // Default color
            }
            g.fillRect(i * barWidth, HEIGHT - arr[i], barWidth, arr[i]);
            g.setColor(Color.BLACK);
            g.drawRect(i * barWidth, HEIGHT - arr[i], barWidth, arr[i]);
        }
    }

}
