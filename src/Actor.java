import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Actor extends Rectangle{
	public boolean ingame=false;
public void giveBounds(int x, int y, int height, int width){
	this.x=x;
	this.y=y;
	this.height=height;
	this.width=width;
}
public boolean isinFrame(){
	return ((x<=Fenster.panel.getWidth() && x>= 0)&&(y<=Fenster.panel.getHeight() && y>= 0));
}
public void paint(Graphics g){
	g.setColor(new Color(255,0,0));
	g.fillRect(x, y, height, width);
}
public void PhyX(){
	
}
public void delete(){
	ingame=false;
	System.out.println("deleted");
}
}
