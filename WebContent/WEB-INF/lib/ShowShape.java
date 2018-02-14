
import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;




public class ShowShape extends Applet {

	//set the initial value of variables

	private String Message;
	private String Shape;
	private String FTColor;
	private String BGColor;
	private String FTStyle;
	private Integer FTSize;
	private Integer x;
	private Integer y;
	private Font ft;
	private String errmsg = "";
	private int stx, sty;


//read parameter from html file
	public void init() {
		Message = this.getParameter("MESSAGE");
		Shape = this.getParameter("SHAPE");
		FTColor = this.getParameter("COLOR");
		x = Integer.parseInt(this.getParameter("X"));
		y = Integer.parseInt(this.getParameter("Y"));
		BGColor = this.getParameter("BGCOLOR");
		FTStyle = this.getParameter("FTSTYLE");
		FTSize = Integer.parseInt(this.getParameter("FTSIZE"));


//check message
		if (Message == null) {
			Message = "Assignment2";
			errmsg += "Error:Message!";
		}

//check shape
		switch (Shape) {
		case "OVAL": break;
		case "RECT": break;
		case "ROUNDRECT": break;
		default: {
			Shape = "RECT";
			errmsg += "Error:Shape!";
		}
		}

//check font color
		switch (FTColor) {
		case "black":
		case "blue":
		case "cyan":
		case "darkGray":
		case "gray":
		case "green":
		case "lightGray":
		case "magenta":
		case "orange":
		case "pink":
		case "red":
		case "white":
		case "yellow": break;
		default: {
			FTColor = "red";
			errmsg += "Error:Fontcolor!";
		}
		}

//check and set the Background color
		switch (BGColor) {
		case "black":
		case "blue":
		case "cyan":
		case "darkGray":
		case "gray":
		case "green":
		case "lightGray":
		case "magenta":
		case "orange":
		case "pink":
		case "red":
		case "white":
		case "yellow": break;
		default: {
			BGColor = "darkGray";
			errmsg += "Error:Background color!";
		}
		}

//check font style
		switch (FTStyle) {
		case "REGULAR":
		case "BOLD":
		case "ITALIC":
		case "BOLD ITALIC": break;
		default: {
			FTStyle = "BOLD";
			errmsg += "Error:Fontstyle!";
		}
		}

//check x and y
		if (x >= 250 || y >= 100) {
			x = 200;
			y = 80;
			errmsg += "Shape Oversize!";
		}
	}


//set the font style
	public int FTStyle(String Ftstyle) {
		switch (Ftstyle) {
		case "REGULAR": return Font.PLAIN;
		case "BOLD": return Font.BOLD;
		case "ITALIC": return Font.ITALIC;
		case "BOLD ITALIC": return Font.ITALIC + Font.BOLD;
		default: return Font.BOLD;
		}
	}

//set the font color
	public Color FTColor(String ftcolor) {
		switch (ftcolor) {
		case "black": return Color.black;
		case "blue":  return Color.blue;
		case "cyan":  return Color.cyan;
		case "darkGray": return Color.darkGray;
		case "gray": return Color.gray;
		case "green": return Color.green;
		case "lightGray": return Color.lightGray;
		case "magenta": return Color.magenta;
		case "orange": return Color.orange;
		case "pink": return Color.pink;
		case "red": return Color.red;
		case "white": return Color.white;
		case "yellow": return Color.yellow;
		default: return Color.red;
		}
	}

//set the background color
	public Color BgColor(String Bgcl) {
		switch (Bgcl) {
		case "black": return Color.black;
		case "blue":  return Color.blue;
		case "cyan":  return Color.cyan;
		case "darkGray": return Color.darkGray;
		case "gray": return Color.gray;
		case "green": return Color.green;
		case "lightGray": return Color.lightGray;
		case "magenta": return Color.magenta;
		case "orange": return Color.orange;
		case "pink": return Color.pink;
		case "red": return Color.red;
		case "white": return Color.white;
		case "yellow": return Color.yellow;
		default: return Color.darkGray;
		}
	}


//make the text be center of the shape
	public void center(Graphics g) {
		Dimension size = this.getSize();
		int w = size.width;
		int h = size.height;
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rec = fm.getStringBounds(Message, g);
		int w1 = (int)rec.getWidth();
		int h1 = (int)rec.getHeight() + fm.getLeading();
		this.stx = (w - w1) / 2;
		this.sty = (h - h1) / 2 + h1 - fm.getDescent() + fm.getLeading();
	}

//draw the shape
	public void drawShape(Graphics g) {
		//get applet size
		Dimension size = this.getSize();
		int w = size.width;
		int h = size.height;
		w=(w-this.x)/2;
		h=(h-this.y)/2;
		switch (Shape) {
		case "OVAL": g.drawOval(w,h, this.x, this.y); break;
		case "RECT": g.drawRect(w,h, this.x, this.y); break;
		case "ROUNDRECT": g.drawRoundRect(w,h, this.x, this.y, this.x / 10, this.y / 10); break;
		default: g.drawRect(w,h, this.x, this.y);
		}
	}

//set the font style and the font Color
	public void setString(Graphics g) {
		this.ft = new Font("Arial", FTStyle(FTStyle), FTSize);
		g.setFont(ft);
		g.setColor(FTColor(FTColor));
		this.setBackground(BgColor(BGColor));
	}

//check whether string is proper
	public void strprop(Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		Rectangle2D rec = fm.getStringBounds(Message, g);
		if (this.x <= (int)rec.getWidth() || this.y <= (int)rec.getHeight() + fm.getLeading()) {
			errmsg += "Error:Fontsize is too big!";
			FTSize = 12;
			repaint();
		}
	}


//show error message box
	public void showErr(Graphics g) {
		g.setFont(new Font("Arial", Font.BOLD, 8));
	}

//draw the whole graph
	public void paint(Graphics g) {
		super.paint(g);
		setString(g);
		drawShape(g);
		center(g);
		g.drawString(Message, this.stx, this.sty);
		strprop(g);
		showErr(g);
		if (errmsg != null)
			g.drawString(errmsg, 0, 8);
	}
}
