import java.awt.*;
import java.awt.Container;
import javax.swing.*;
import javax.swing.JLabel;

public class ThreadMainEx {

  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getId());
    System.out.println(Thread.currentThread().getName());
    System.out.println(Thread.currentThread().getState());
    System.out.println(Thread.currentThread().getPriority());
  }
}
