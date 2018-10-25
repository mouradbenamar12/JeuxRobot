

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main {

    public static ImageIcon resizeimg(ImageIcon imageIcon){
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 300,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }


    public static void main(String[] args) {

        JFrame jf = new JFrame("Jeu Robot");
        jf.getContentPane().setLayout(new BorderLayout());




        ImageIcon RobotBlue = new ImageIcon("/Users/abdellebay/IdeaProjects/JeuxRobot/Images/RobotBleu.png");
        ImageIcon RobotGreen = new ImageIcon("/Users/abdellebay/IdeaProjects/JeuxRobot/Images/RobotNGGreen.jpg");
        ImageIcon RobotRed = new ImageIcon("/Users/abdellebay/IdeaProjects/JeuxRobot/Images/RobotNGRouge.jpg");
        ImageIcon RobotYellow = new ImageIcon("/Users/abdellebay/IdeaProjects/JeuxRobot/Images/RobotNGYellow.jpg");

        ImageIcon Gas = new ImageIcon("/Users/abdellebay/IdeaProjects/JeuxRobot/Images/Robotic_Gas_Pumps.jpg");
        Gas = resizeimg(Gas);

        RobotNG RbGreen = new RobotNG("RobotGreen",600,400,"Est",RobotGreen,3000);
        Thread ThreadBlue = new Thread(RbGreen);

        RobotNG RbRed = new RobotNG("RobotRed",300,200,"Est",RobotRed,5000);
        Thread ThreadRed = new Thread(RbRed);

        jf.add(RbGreen,BorderLayout.NORTH);
        jf.add(RbRed,BorderLayout.SOUTH);
        JLabel JGas = new JLabel(Gas);
        jf.add(JGas,BorderLayout.EAST);
        //jf.add(new JLabel(RobotRed),BorderLayout.EAST);
        //jf.add(new JLabel(RobotYellow),BorderLayout.WEST);
        jf.pack();
        //jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setSize(1440,820);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        //JOptionPane.showMessageDialog(null,"X:"+JGas.getLocation().x+" Y:"+JGas.getLocation().y,"Axe",JOptionPane.WARNING_MESSAGE);

        jf.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null,"X:"+e.getX()+" Y:"+e.getY(),"Axe",JOptionPane.WARNING_MESSAGE);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ThreadBlue.start();
        ThreadRed.start();


    }
}
