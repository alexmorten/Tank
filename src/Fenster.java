

import java.awt.Dimension;
import java.awt.GridLayout;



import javax.swing.*;


public class Fenster extends JFrame {
public static Panel panel;
public static Fenster fenster;
public KeyH keyh;
public static int width=900,height=800;
public static Dimension size=new Dimension(width,height);

	public static void main(String[] args) {
fenster=new Fenster();

	}
	
	Fenster(){
	
	
		this.setBounds(0,0,width,height);
		this.
		setLayout(new GridLayout(1,1,0,0));
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Ich hatte VIEL Zeit");
		panel=new Panel();
	//	panel.setBounds(0,0,300,300);
		this.add(panel);
		//panel.machalles();
		panel.paint();
		keyh=new KeyH();
		this.addKeyListener(keyh);
		this.addMouseListener(keyh);
		this.addMouseMotionListener(keyh);
	}

}
