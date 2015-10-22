package my.tdl.managers;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.project.gop.main.Light;
import my.project.gop.main.Vector2F;
import my.tdl.MoveableObjects.Player;
import my.tdl.main.Main;

public class HUDmanager {

	private Player player;
	
	//250 is the map size for the lighting
	private BufferedImage lightmap = new BufferedImage(250 * 32, 250 * 32, BufferedImage.TYPE_INT_ARGB);
	private ArrayList<Light> lights = new ArrayList<Light>();
	private Vector2F lightm = new Vector2F();
	
	public HUDmanager(Player player) {
		this.player = player;
		addLights();
		
	}
	
	private void addLights() {
		//lights.add(new Light(500, 400, 120, 220));
		//lights.add(new Light(300, 300, 200, 180));
		lights.add(new Light(650, 450, 520, 250));
		lights.add(new Light(650, 600, 750, 250));
	}
	
	public void UpdateLights() {
		Graphics2D g = null;
		if(g == null) {
			g = (Graphics2D) lightmap.getGraphics();
		}
		
		g.setColor(new Color(0, 0, 0, 255));
		g.fillRect(0, 0, lightmap.getWidth(), lightmap.getHeight());
		g.setComposite(AlphaComposite.DstOut);
		
		for(Light light : lights) {
			light.render(g);
			//light.lightpos.xpos++;
		}
		g.dispose();
	}
	
	public void render(Graphics2D g) {
		UpdateLights();
		g.drawImage(lightmap, (int)lightm.getWorldLocation().xpos, (int)lightm.getWorldLocation().ypos, null);
		
		//Makes it look like a movie(whats in the rest of code block)
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.width, Main.height / 6);
		g.fillRect(0, 900, Main.width, Main.height / 6);
		g.setColor(Color.WHITE);

		
		//g.drawString(player.getPos().xpos + "", 200, 200);
		
	}

}
