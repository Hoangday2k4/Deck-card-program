package lab11.baitap.bai3.cardInterface.source.display.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Tạo frame
        JFrame frame = new JFrame("Chương trình đóng cửa sổ");

        // Tạo button
        JButton closeButton = new JButton("Đóng chương trình");

        // Thiết lập hành động cho button
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Hỏi người dùng có muốn thoát không
                int result = JOptionPane.showConfirmDialog(frame,
                        "Bạn có muốn thoát chương trình?",
                        "Xác nhận thoát",
                        JOptionPane.YES_NO_OPTION);

                // Nếu người dùng chọn "Yes", thoát chương trình
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        // Thêm button vào frame
        frame.getContentPane().add(closeButton);

        // Thiết lập kích thước của frame
        frame.setSize(300, 200);

        // Đặt chế độ đóng khi đóng cửa sổ
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hiển thị frame
        frame.setVisible(true);
    }
}