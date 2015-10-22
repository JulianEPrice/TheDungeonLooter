package my.tdl.generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import my.project.gop.main.Vector2F;
import my.tdl.MoveableObjects.Player;
import my.tdl.generator.Block.BlockType;

public class World {

	private String worldName;
	private BufferedImage world_image;
	private int world_width;
	private int world_height;
	
	private TileManager tiles = new TileManager();
	private Player player = new Player();
	
	public World(String worldName, BufferedImage world_image, int world_width, int world_height) {
		this.worldName = worldName;
		this.world_image = world_image;
		this.world_width = world_width;
		this.world_height = world_height;
	}

	public void generateWorld() {
		
		BufferedImage map = null;
		
	
	for(int x = 0; x < world_width;x++) {
		for(int y = 0; y < world_height; y++){
			
			int col = world_image.getRGB(x, y);
			//STONE_1
			switch(col & 0xFFFFFF) {
			case 0x808080:
				tiles.blocks.add(new Block(new Vector2F(x * 48, y * 48), BlockType.STONE_1));
				break;
				//WALL_1
			case 0x404040:
				tiles.blocks.add(new Block(new Vector2F(x * 48, y * 48), BlockType.WALL_1).isSolid(true));
				break;
			case 0x303030:
				tiles.blocks.add(new Block(new Vector2F(x * 48, y * 48), BlockType.RAND_1).isSolid(true));
				break;
			case 0x807060:
				tiles.blocks.add(new Block(new Vector2F(x * 48, y * 48), BlockType.TREE_1).isSolid(true));
				break;
			case 0x707060:
				tiles.blocks.add(new Block(new Vector2F(x * 48, y * 48), BlockType.CHAN_1).isSolid(true));
				break;
			}
		}
	}		
	player.init(this);
	}
	
	public void tick(double deltaTime) {
		tiles.tick(deltaTime);
		for(BlockEntity ent : blockents){
			ent.tick(deltaTime);
		}
		player.tick(deltaTime);
	}
	
	public void render(Graphics2D g) {
		tiles.render(g);
		for(BlockEntity ent : blockents){
			ent.render(g);
		}
		player.render(g);
		
		g.drawString(blockents.size() + "", 200, 200);
	}
	
	public static ArrayList<BlockEntity> blockents = new ArrayList<BlockEntity>();
	
	public static void dropBlockEntity(Vector2F pos, BufferedImage block_image) {
		BlockEntity ent = new BlockEntity(pos, block_image);
		if(!blockents.contains(ent)){
			blockents.add(ent);
		}
	}
	
	
	public String getWorldName() {
		return worldName;
	}
	
	public BufferedImage getWorld_image() {
		return world_image;
	}

}
