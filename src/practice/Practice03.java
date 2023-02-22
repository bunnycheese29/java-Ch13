package practice;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.JLabel;

class ClockLabel extends JLabel implements Runnable {

  private Thread thread;

  ClockLabel() {
    this.setText("시간이 노출 되는 곳");
    this.setFont(new Font("맑은 고딕", Font.BOLD, 48));
    this.setHorizontalAlignment(JLabel.CENTER);
    thread = new Thread(this);
    thread.start();
  }

  @Override
  public void run() {
    while (true) {
      Calendar cal = Calendar.getInstance();
      int hour = cal.get(Calendar.HOUR_OF_DAY);
      int minute = cal.get(Calendar.MINUTE);
      int second = cal.get(Calendar.SECOND);
      setText(hour + ":" + minute + ":" + second);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
        return;
      }
    }
  }
}

public class Practice03 extends JFrame {

  public Practice03() {
    this.setTitle("Thread Finish 연습");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container contentPane = this.getContentPane();
    contentPane.add(new ClockLabel());

    this.setVisible(true);
    this.setSize(500, 500);
  }

  public static void main(String[] args) {
    new Practice03();
  }
}
