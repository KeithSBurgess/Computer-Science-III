package org.openjfx.test;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

	public Circle(int width, int height)
	{
		super(width,height, true);		
	}
	
	@Override
	public void draw(GraphicsContext gc) {
		
		gc.setLineWidth(4);
		gc.setFill(getColor());
		gc.fillOval(getX(),getY(),getWidth(),getWidth());
		gc.setStroke(Color.BLACK);
		gc.strokeOval(getX(),getY(),getWidth(),getWidth());
		
	}
	
}
