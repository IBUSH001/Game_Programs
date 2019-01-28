package game;
import engineMain.AbstractGame;
import engineMain.GameContainer;
import engineMain.Renderer;

public class GameManager extends AbstractGame{

	public GameManager()
	{
		
	}
	
	@Override
	public void update(GameContainer gc, float dt) {
		
	}

	@Override
	public void render(GameContainer gc, Renderer r) {
	
	}
	
	public static void main(String[] args)
	{
		GameContainer gc = new GameContainer(new GameManager());
		gc.start();
	}

}
