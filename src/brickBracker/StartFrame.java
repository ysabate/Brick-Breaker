package brickBracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame implements ActionListener {
    private static JButton button;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;

    public StartFrame(){
        //Starting up page
        JFrame frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setTitle("Brick Breaker");
        frame1.setLayout(new FlowLayout());

        //Entry Label
        JLabel entryLabel = new JLabel("Welcome to Brickbreaker",JLabel.CENTER);
        entryLabel.setFont(new Font("serif", Font.BOLD,40));
        entryLabel.setVerticalAlignment(JLabel.TOP);
        frame1.add(entryLabel);

        //Adding button to frame
        button = new JButton("Easy");
        button.addActionListener(this);
        frame1.add(button);
        button1 = new JButton("Medium");
        button1.addActionListener(this);
        frame1.add(button1);
        button2 = new JButton("Impossible");
        button2.addActionListener(this);
        frame1.add(button2);
        button3 = new JButton("Dont Bother");
        button3.addActionListener(this);
        frame1.add(button3);


        frame1.setResizable(false);
        frame1.setSize(500,500);
        frame1.getContentPane().setBackground(SystemColor.gray);
        frame1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            JFrame obj = new JFrame();
            GamePlay gamePlay = new GamePlay(8);

            obj.setBounds(10,10,700,600);
            obj.setTitle("Break Out ball");
            obj.setResizable(false);

            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gamePlay);
            obj.setVisible(true);

        }
        if (e.getSource() == button1){
            JFrame obj = new JFrame();
            GamePlay gamePlay = new GamePlay(6);

            obj.setBounds(10,10,700,600);
            obj.setTitle("Break Out ball");
            obj.setResizable(false);

            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gamePlay);
            obj.setVisible(true);

        }
        if (e.getSource() == button2){
            JFrame obj = new JFrame();
            GamePlay gamePlay = new GamePlay(4);

            obj.setBounds(10,10,700,600);
            obj.setTitle("Break Out ball");
            obj.setResizable(false);

            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gamePlay);
            obj.setVisible(true);

        }
        if (e.getSource() == button3){
            JFrame obj = new JFrame();
            GamePlay gamePlay = new GamePlay(2);

            obj.setBounds(10,10,700,600);
            obj.setTitle("Break Out ball");
            obj.setResizable(false);

            obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            obj.add(gamePlay);
            obj.setVisible(true);

        }
    }


}
