package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import my.project.gop.main.Vector2F;

public class BlockEntity {

	private Vector2F pos;
	private BufferedImage block_image;
	private double rotation;
	private double rotation_speed = 0.8;
	private double blockSize = 24;
	
	public BlockEntity(Vector2F pos, BufferedImage block_image) {
		this.pos = pos;
		this.block_image = block_image;
		rotation = new Random().nextInt(180);
	}

	public void tick(double deltaTime) {
		rotation-= rotation_speed;
	}
	
	public void render(Graphics2D g) {
		
		g.rotate(Math.toRadians(rotation), pos.getWorldLocation().xpos + blockSize / 2, pos.getWorldLocation().ypos + blockSize / 2);
		//############################
		
		g.drawImage(block_image, (int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, (int) blockSize, (int) blockSize, null);
		
		g.drawRect((int) pos.getWorldLocation().xpos, (int) pos.getWorldLocation().ypos, (int) blockSize, (int) blockSize);
		
		//################################
		g.rotate(-Math.toRadians(rotation), pos.getWorldLocation().xpos + blockSize / 2, pos.getWorldLocation().ypos + blockSize / 2);

	}
	
	
	
}
