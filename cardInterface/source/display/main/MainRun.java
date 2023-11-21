package lab11.baitap.bai3.cardInterface.source.display.main;

import lab11.baitap.bai3.card.Card;
import lab11.baitap.bai3.cardInterface.source.behavior.SortAndShuffle2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainRun extends JFrame {
    private Panel panel;

    public MainRun() {
        // Thiết lập cửa sổ chính
        setTitle("Deck sorting program:");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1315, 634);
        setResizable(false);

        // Đặt cửa sổ ở giữa màn hình
        setLocationRelativeTo(null);

        // Tạo panel hiển thị
        panel = new Panel();
        panel.startPanelThread();

        add(panel);

        // Tạo panel nút
        JPanel buttonPanel = new JPanel();

        // Tạo nút sort
        JButton sortButton = new JButton("Sorting");
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Sort();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonPanel.add(sortButton);

        // Tạo nút shuffle
        JButton shuffleButton = new JButton("Shuffling");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Shuffle();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        buttonPanel.add(shuffleButton);

        // Đặt panel nút vào cửa sổ chính
        add(buttonPanel, BorderLayout.SOUTH);

        // Tạo button close
        JButton closeButton = new JButton("Exit");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hỏi người dùng có muốn thoát không
                int result = JOptionPane.showConfirmDialog(panel,
                        "Do you want to exit the program?",
                        "Exit program:",
                        JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn "Yes", thoát chương trình
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        buttonPanel.add(closeButton);


        // Hiển thị cửa sổ chính
        setVisible(true);
    }

    private void Sort() throws InterruptedException {
        SortAndShuffle2 sas = new SortAndShuffle2();
        Card[][] newArr = sas.tile.mapTileNum.dataMap;
        sas.sort(newArr);
        panel.updateData(newArr); // Cập nhật dữ liệu trên Panel
    }

    private void Shuffle() throws InterruptedException {
        SortAndShuffle2 sas = new SortAndShuffle2();
        Card[][] newArr = sas.tile.mapTileNum.dataMap;
        sas.shuffle(newArr);
        panel.updateData(newArr); // Cập nhật dữ liệu trên Panel
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainRun();
            }
        });
    }
}
