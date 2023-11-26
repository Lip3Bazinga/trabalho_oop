package managerApp.managerView.UI;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

  public Button(String text) {
    super(text);
    initialize();
  }

  private void initialize() {
    setBorderPainted(false);
    setFocusPainted(false);
    setBackground(new Color(169, 169, 169));
    setForeground(Color.BLACK);
    setAlignmentX(Component.CENTER_ALIGNMENT);
    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        setBackground(new Color(27, 27, 27));
        setForeground(Color.WHITE);
      }

      public void mouseExited(java.awt.event.MouseEvent evt) {
        setBackground(new Color(169, 169, 169));
        setForeground(Color.BLACK);
      }
    });
  }
}
