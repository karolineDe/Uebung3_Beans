package beans;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Hashtable;

public class SimpleTest extends Canvas implements Serializable {

	  private static Hashtable colorTable;
	  static {
	    colorTable = new Hashtable();
	    colorTable.put("red", new Color(255, 0, 0));
	    colorTable.put("yellow", new Color(255, 255, 0));
	    colorTable.put("green", new Color(0, 200, 0));
	    colorTable.put("blue", new Color(0, 0, 255));
	  }
	  private String currentColor;

	  public SimpleTest() {
	    currentColor = "red";
	    setSize(100, 100);
	  }

	  public String getCurrentColor() {
	    return currentColor;
	  }

	  public void setCurrentColor(String color) {
	    this.currentColor = color;
	    repaint();
	  }

	  public void paint(Graphics g) {
	    Color color = (Color)colorTable.get(currentColor);
	    g.setColor(color);
	    Dimension d = getSize();
	    g.fillRect(0, 0, d.width - 1, d.height - 1);
	  }

}
