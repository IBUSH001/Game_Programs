package engineMain;
import java.awt.image.DataBufferInt;

public class Renderer {

	private int pixWidth, pixHeight;
	private int[] p;
	
	public Renderer(GameContainer gc)
	{
		pixWidth = gc.getWidth();
		pixHeight = gc.getHeight();
		p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
	}
	
	public void clear()
	{
		for(int i = 0; i < p.length; i++)
		{
			p[i] = 0;
		}
	}
}
