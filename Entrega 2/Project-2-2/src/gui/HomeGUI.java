package gui;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class HomeGUI extends JFrame {
    public HomeGUI(){
        setResizable(false);
        setTitle("Hotel DPOO | Home");
        setSize(900, 700);
        setLayout(new GridLayout(2,1));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel image = new JPanel(){
            @Override
            public void paint(Graphics graphics) {
                super.paint(graphics);
                Image image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/gui/home_image.png"))).getImage();
                graphics.drawImage(image, 0, 0, 900, 250, this);
            }
        };
        add(image);

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(4, 1));
        JLabel welcomeMessage = new JLabel("                                   Welcome to DPOO Hotel");
        welcomeMessage.setFont(new Font(welcomeMessage.getFont().getName(), Font.BOLD, 30));
        loginPanel.add(welcomeMessage);
        JPanel user = new JPanel();
        user.add(new JLabel("User: "));
        user.add(new JTextField("",20));
        loginPanel.add(user);
        JPanel password = new JPanel();
        password.add(new JLabel("Password: "));
        password.add(new JTextField("",20));
        loginPanel.add(password);
        JButton login = new JButton("login");
        loginPanel.add(login);
        add(loginPanel);
        setVisible(true);


    }

    public static void main(String[] args) {
        new HomeGUI();
    }
}
