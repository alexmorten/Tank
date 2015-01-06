import java.awt.Graphics;


public class Ufo extends BartBaer{

	Ufo(int x, int y, int id) {
		super(x, y, id);
		
	}
	@Override
	public void paint(Graphics g){
		g.drawImage(Fenster.panel.UfoImg, x, y, width, height, null);
		paintLebensbar(g);
	}

}
