package my.tdl.main;

import java.awt.image.BufferedImage;

import my.project.gop.main.SpriteSheet;
import my.project.gop.main.loadImageFrom;

public class Assets {
	
	SpriteSheet blocks = new SpriteSheet();
	public static SpriteSheet player = new SpriteSheet();
	
	public static BufferedImage stone_1;
	public static BufferedImage wall_1;
	public static BufferedImage rand_1;
	public static BufferedImage tree_1;
	public static BufferedImage chan_1;
	
	private static BufferedImage mouse_pressed;
	private static BufferedImage mouse_unpressed;
	
	public void init() {
		blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "spritesheet.png"));
		player.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "PlayerSheet.png"));

		
		stone_1 = blocks.getTile(0, 0, 16, 16);
		wall_1 = blocks.getTile(16, 0, 16, 16);
		rand_1 = blocks.getTile(32, 0, 16, 16);
		tree_1 = blocks.getTile(0, 16, 16, 32);
		chan_1 = blocks.getTile(16, 16, 16, 16);
		
		mouse_pressed = player.getTile(64 + 32 + 8, 8, 8, 8);
		mouse_unpressed = player.getTile(64 + 32, 8, 8, 8);
	}
	
	public static BufferedImage getStone_1() {
		return stone_1;
	}
	
	public static BufferedImage getWall_1() {
		return wall_1;
	} 
	
	public static BufferedImage getRand_1() {
		return rand_1;
	}

	public static BufferedImage getTree_2() {
		return tree_1;
	}
	
	public static BufferedImage getChan_1() {
		return chan_1;
	}
	
	//mouse
	public static BufferedImage getMouse_pressed() {
		return mouse_pressed;
	}
	
	public static BufferedImage getMouse_unpressed() {
		return mouse_unpressed;
	}
	
}
