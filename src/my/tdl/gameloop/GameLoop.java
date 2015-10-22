package my.tdl.gameloop;

import my.project.gop.main.IDGameLoop;
import my.project.gop.main.Vector2F;
import my.tdl.gamestate.GameStateManager;
import my.tdl.main.Assets;

@SuppressWarnings("serial")
public class GameLoop extends IDGameLoop {

	GameStateManager gsm;
	public static Assets assets = new Assets();
	public static Vector2F map = new Vector2F();
	
	
	public GameLoop(int fwidth, int fheight) {
		super(fwidth, fheight);
		
	}
	
	@Override
	public void init() {
		assets.init();
		Vector2F.setWorldVariables(map.xpos, map.ypos);
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
		Vector2F.setWorldVariables(map.xpos, map.ypos);
		gsm.tick(deltaTime);
	}
	
	@Override
	public void render() {
		super.render();
		gsm.render(graphics2D);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}
	
}
