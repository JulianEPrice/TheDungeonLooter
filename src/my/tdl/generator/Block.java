package my.tdl.generator;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import my.project.gop.main.Vector2F;
import my.tdl.main.Assets;

@SuppressWarnings("serial")
public class Block extends Rectangle {

	Vector2F pos = new Vector2F();
	private int BlockSize = 48;
	private BlockType blocktype;
	private BufferedImage block;
	private boolean isSolid;
	private boolean isAlive;
	private boolean droped = false;
	
	public Block(Vector2F pos, BlockType blocktype) {
		setBounds((int)pos.xpos, (int)pos.ypos, BlockSize, BlockSize);
		this.pos = pos;
		isAlive = true;
		this.blocktype = blocktype;
		init();
	}
	
	public Block isSolid(boolean isSolid) {
		this.isSolid = isSolid;
		return this;
	}
	
	public void init() {
		switch(blocktype) {
		case STONE_1:
			block = Assets.getStone_1();
			break;
		case WALL_1:
			block = Assets.getWall_1();
			break;
		case RAND_1:
			block = Assets.getRand_1();
			break;
		case TREE_1:
			block = Assets.getTree_2();
			break;
		case CHAN_1:
			block = Assets.getChan_1();
			break;
		}
	}
	
	public void tick(double deltaTime) {
		if(isAlive){
		setBounds((int)pos.xpos, (int)pos.ypos, BlockSize, BlockSize);
		}
	}
	public void render(Graphics2D g) {
		if(isAlive) {
		//g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
		g.drawImage(block, (int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize, null);
		
		if(isSolid) {
			g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
		}
		
			g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
		}else{
			if(!droped) {
				float xpos = pos.xpos + 24 - 12;
				float ypos = pos.ypos + 24 - 12;
				
				Vector2F newpos = new Vector2F(xpos, ypos);
				
				World.dropBlockEntity(newpos, block);
				
				droped = true;
			}
		}
		
	}
	
	public enum BlockType {
		STONE_1, WALL_1, RAND_1, TREE_1, CHAN_1
		
		
	}

	public boolean isSolid() {
		return isSolid;
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
}
