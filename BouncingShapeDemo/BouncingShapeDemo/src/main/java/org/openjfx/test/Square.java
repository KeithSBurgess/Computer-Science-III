package org.openjfx.test;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square extends Shape {

	public Square(int width, int height)
	{
		super(width,height, true);		
	}
	public Square()
	{
		super();		
	}
	
//	The fillPolygon method fills a polygon 
//	with the given points using the currently set fill paint. 
//	In our case, it paints a right-angled triangle. 
//	The first parameter is an array containing the x coordinates
//	of the polygon points, the second parameter is an array 
//	containing the y coordinates of the polygon points.
//	The last parameter is the number of points that form a polygon.
	public void draw(GraphicsContext gc) {
		
		gc.setLineWidth(4);
		gc.setFill(getColor());
		gc.fillRect(getX(),getX(),getWidth(),getWidth());
		gc.setStroke(Color.BLACK);
		gc.strokeRect(getX(),getX(),getWidth(),getWidth());
				
	}
	
}
