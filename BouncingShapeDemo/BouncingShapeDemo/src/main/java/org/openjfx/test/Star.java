package org.openjfx.test;



import java.util.Arrays;

import javafx.scene.canvas.GraphicsContext;


public class Star extends Shape {

	
	  double[] xpoints = {10, 85, 110, 135, 210, 160,
              170, 110, 50, 60};
      double[] ypoints = {85, 75, 10, 75, 85, 125,
              190, 150, 190, 125};
	public Star(int width, int height)
	{
		super(width,height,true);		
		
		double percent = getWidth() / 190;
		 for (int i = 0; i < xpoints.length; i++) {
				
        	 xpoints[i] *= percent;
        	 ypoints[i] *= percent;
		}   
		
	}
	public Star()
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
		  
		double[] xpointsTemp = Arrays.copyOf(xpoints, xpoints.length); 
		double[] ypointsTemp = Arrays.copyOf(ypoints, xpoints.length); 
	    for (int i = 0; i < xpoints.length; i++) {
	    	xpointsTemp[i] += getX();
	    	ypointsTemp[i] += getY();
	    }   
		
	        gc.fillPolygon(xpointsTemp, ypointsTemp, xpointsTemp.length);
	        gc.strokePolygon(xpointsTemp, ypointsTemp, ypointsTemp.length);
	    }
				
	
	
}
