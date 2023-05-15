package org.openjfx.test;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends Shape {

	public Oval(int width, int height)
	{
		super(width,height, false);		
	}
	public Oval()
	{
		super();		
	}
	public void draw(GraphicsContext gc) {
		
		gc.setLineWidth(4);
		gc.setFill(getColor());
		gc.fillOval(getX(),getY(),getWidth(),getHeight());
		gc.setStroke(Color.BLACK);
		gc.strokeOval(getX(),getY(),getWidth(),getHeight());
		
	}
	
}
