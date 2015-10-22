package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.project.gop.main.loadImageFrom;
import my.tdl.MoveableObjects.Player;
import my.tdl.generator.Block.BlockType;
import my.tdl.main.Main;

public class Map {

	public static BufferedImage map = null;
	
	public World world;
	
	public Map() {
		
	}
	
	public void init() {
		
		try {
			map = loadImageFrom.LoadImageFrom(Main.class, "map.png");
		}catch(Exception e){
		
		}
		
		//250 means world size
		world = new World("world1", map, 250, 250);
		world.generateWorld();
	
	}
	
	public void tick(double deltaTime) {
		world.tick(deltaTime);
	}
	
	public void render(Graphics2D g) {
		world.render(g);
	}
	
}
