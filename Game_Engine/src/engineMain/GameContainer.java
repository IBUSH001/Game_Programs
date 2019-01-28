package engineMain;

/**
 * 
 * @author ibush001
 * @version January 25, 2019
 */
public class GameContainer implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	private final double UPDATE_CAP = 1.0 / 60.0;
	private int width = 320, height = 240;
	private float scale = 4f;
	private String title = "GameEngine v 0.2";
	
	private Window window;
	private Renderer renderer;
	private Input input;
	private AbstractGame game;
	
	/**
	 * Creates a new GameContainer object
	 */
	public GameContainer(AbstractGame game)
	{
		this.game = game;
	}
	
	public void start()
	{
		window = new Window(this);
		renderer = new Renderer(this);
		input = new Input(this);
		
		thread = new Thread(this);
		thread.run();
	}
	
	public void stop()
	{
		
	}
	
	public void run()
	{
		running = true;
		boolean render;
		
		double firstTime = 0;
		double lastTime = System.nanoTime() / 1000000000.0;
		double passedTime = 0;
		double unprocessedTime = 0;
		while(running) {
			render = false;
			firstTime = System.nanoTime() / 1000000000.0;
			passedTime = firstTime - lastTime;
			lastTime = firstTime;
			
			unprocessedTime += passedTime;
			while(unprocessedTime >= UPDATE_CAP)
			{
				unprocessedTime -= UPDATE_CAP;
				render = true;
				input.update();
				game.update(this, (float)UPDATE_CAP);
			}
			
			if(render)
			{
				renderer.clear();
				game.render(this, renderer);
				window.update();
			}
			else
			{
				try
				{
					Thread.sleep(1);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		dispose();
	}
	
	private void dispose()
	{
		
	}
	
	public int getWidth()
	{
		return this.width;
	}
	
	public int getHeight()
	{
		return this.height;
	}
	
	public float getScale()
	{
		return this.scale;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public Window getWindow()
	{
		return window;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setHeight(int height)
	{
		this.height = height;
	}
	
	public void setScale(float scale)
	{
		this.scale = scale;
	}
}
