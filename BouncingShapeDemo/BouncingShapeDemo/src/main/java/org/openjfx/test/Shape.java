package org.openjfx.test;

//import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shape {
	private int x = 0;
	private int y = 0;
	// Indicates direction of motion in Horizontal axis 
	// +1 Right -1 Left
	private int xDir = 1;
	// Indicates direction of motion in Vertical axis 
	// +1 Down -1 Up
	private int yDir = 1;

	private Color color;	
	private static int DEFAULT_WIDTH = 500;
	private static int DEFAULT_HEIGHT = 500;
	private static int MAX_WIDTH = 100;
	private static int MIN_WIDTH = 20;
	private static int MAX_HEIGHT = 100;
	private static int MIN_HEIGHT = 20;
	
	private static int BUFFER = 10;
	
	
	// width of shape
	private double width = 0;
	// height of shape
	private double height = 0;
	// width of Window
	private int windowWidth = 0;
	// height of Window
	private int windowHeight = 0;
	
	private static Random random = new Random();
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}	
	public Color getColor() {
		return color;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}

	public Shape(int windowWidth, int windowHeight, boolean widthHeightEqual )
	{
		this();
		this.windowWidth = windowWidth ;
		this.windowHeight = windowHeight ;
		if(widthHeightEqual)
		{
			this.height = width;
			this.x = random.nextInt(windowHeight - (int)height);		
		}
		
	}
	public Shape() {
		super();
		
		this.windowWidth = DEFAULT_WIDTH;
		this.windowHeight = DEFAULT_HEIGHT;
		this.width  = Math.max(random.nextDouble() * MAX_WIDTH, MIN_WIDTH) ;
		this.height = Math.max(random.nextDouble() * MAX_HEIGHT, MIN_HEIGHT);
		
		this.y = random.nextInt(windowHeight -  100); 
		this.x = random.nextInt(windowWidth -  100);		
		this.xDir = random.nextBoolean() ? 1 : -1;
		this.yDir = random.nextBoolean() ? 1 : -1;
		this.color = Color.color(Math.random(), Math.random(),Math.random());
		
	}

	public void checkCollision(List<Shape> shapes) {//nested for loop looking for overlap,
		
		for (Shape shape : shapes) {
			//System.out.println("IN SHAPE");
			double x_A1 = shape.getX() - BUFFER;	//TOPLEFT
			double x_A2 = x_A1 + shape.getWidth();// + BUFFER;	//TOPRIGHT
			
			double y_A1 = shape.getY() - BUFFER; //TOPLEFT
			double y_A3 = shape.getY() + shape.getHeight() + BUFFER; //BOTTOMLEFT

			for (Shape shape2 : shapes) {
				//System.out.println("IN SHAPE_2");
					double x_B1 = shape2.getX() - BUFFER;	//TOPLEFT
					double x_B2 = x_B1 + shape2.getWidth() + BUFFER;	//TOPRIGHT
					
					double y_B1 = shape2.getY() - BUFFER; //TOPLEFT
					double y_B3 = shape2.getY() + shape2.getHeight() + BUFFER; //BOTTOMLEFT
					
					//			[LEFT]-RIGHT					LEFT-[RIGHT]											[UP]-DOWN						UP-[DOWN]
					if(((x_A1 > x_B1 && x_A1 < x_B2) || (x_A2 > x_B1 && x_A2 < x_B2))		&&		((y_A1 > y_B1 && y_A1 < y_B3) || (y_A3 > y_B1 && y_A3 < y_B3))) {
						System.out.println("OVERLAP");	//Direction switching too many times and looks like it isn't working???
						shape.xDir *= -1; //Change Direction
						shape2.xDir *= -1; //Change Direction
						shape.yDir *= -1; //Change Direction
						shape2.yDir *= -1; //Change Direction
					}

			}
		}

	}//END checkCollision
		
	public void update() {
		if( x+width < 0 || x > windowWidth) //LEFT-RIGHT	(x + width > windowWidth|| x < 0)
		{
			//System.out.printf("H %d %f %d%n",x , height, windowHeight);
			//xDir *= -1; //Change Direction
			if(x+width < 0) { //LEFT
				x = (int) (windowWidth); //(windowWidth - width)
			}
			if(x > windowWidth) { //RIGHT
				x = (int) (0-width);	//(0)
			}
		}
		
		if( y < 0 || y + height > windowHeight)//UP-DOWN	(y + height > windowHeight || y < 0)
		{
			//System.out.printf("W %d %f %d%n",y , width, windowWidth);
			//yDir *= -1; //Change Direction
			if(y+height < 0) { //UP
				y = (int) (windowHeight);
			}
			if(y > windowHeight){ //DOWN
				y = (int) (0-height);
			}
		}
		
		x += 1 * xDir;
		y += 1 * yDir;
		
	} 
	
	public abstract void draw(GraphicsContext gc);		
		
}
