import java.awt.*;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JLabel;

class RandomThread extends Thread {

  private Container contentPane;
  private boolean flag = false;

  RandomThread(Container contentPane) {
    this.contentPane = contentPane;
  }

  public void finish() {
    flag = true;
  }

  @Override
  public void run() {
    while (true) {
      int posX = (int) (Math.random() * 500);
      int posY = (int) (Math.random() * 500);
      JLabel label = new JLabel("JAVA");
      label.setSize(80, 20);
      label.setLocation(posX, posY);
      contentPane.add(label);
      contentPane.repaint();
      try {
        Thread.sleep(200);
        if (flag) {
          return;
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
  }
}

public class ThreadFinishEx extends JFrame {

  public ThreadFinishEx() {
    this.setTitle("Thread Finish 연습");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.setLayout(null);
    RandomThread randomThread = new RandomThread(contentPane);
    randomThread.start();
    contentPane.addMouseListener(
      new MouseAdapter() {
        public void mouseReleased(MouseEvent e) {
          randomThread.finish();
        }
      }
    );

    this.setVisible(true);
    this.setSize(500, 500);
  }

  public static void main(String[] args) {
    new ThreadFinishEx();
  }
}
