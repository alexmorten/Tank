import java.awt.Graphics;
import java.awt.Image;


public class Effect {

public Particle[] particles=new Particle[5000];
public void doNewEffect(int centerx, int centery,int parts,double gradr,int origionid,int targetid){
	for(int part=0;part<parts;part++){
		for(int i=0;i<particles.length;i++){
			if(particles[i]==null){
				particles[i]= new Particle(centerx+Particle.intRandom(-5, 5), centery+Particle.intRandom(-5, 5), gradr, 100, origionid,targetid);
			break;
				}
		}
	}
}
public void doParticlestuff(Graphics g){
	//System.out.println("doing particle stuff");
	for(int i=0;i<particles.length;i++){
		if(particles[i]!=null){
			if(particles[i].lifetime>=0){
			particles[i].PhyX();
			particles[i].paint(g);}
			else{
				particles[i]=null;
			}
		}
		
	}
}
}
