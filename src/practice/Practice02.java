package practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;

class CirclePanel extends JPanel implements Runnable {

  private int x = 100;
  private int y = 100;

  CirclePanel() {
    Thread thread = new Thread(this);

    this.addMouseListener(
        new MouseAdapter() {
          public void mouseReleased(MouseEvent e) {
            thread.start();
          }
        }
      );
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.magenta);
    g.drawOval(x, y, 50, 50);
  }

  @Override
  public void run() {
    while (true) {
      x = (int) (Math.random() * 500);
      y = (int) (Math.random() * 500);
      repaint();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
  }
}

public class Practice02 extends JFrame {

  public Practice02() {
    this.setTitle("원 그리기 연습");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // Container contentPane = this.getContentPane();
    this.setContentPane(new CirclePanel());

    this.setVisible(true);
    this.setSize(500, 500);
  }

  public static void main(String[] args) {
    new Practice02();
  }
}
