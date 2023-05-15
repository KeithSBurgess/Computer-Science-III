package org.openjfx.test;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class BouncingShapes extends GraphicApp {

	List<Shape> shapes = new ArrayList<Shape>();

	public BouncingShapes() {
		super();
		this.height = 500;
		this.width = 500;

	}

	public static void main(String[] args) {

		launch();
	}

	@Override
	public void setup() {
		title("Bouncing Shapes Application");
		createShapes();
		setBottom(createButtonBox());
		this.background(Color.BLACK);
	}

	private HBox createButtonBox() {
		// Create Hbox to hold buttons
		HBox hbox = new HBox();
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(10);

		// Create Button to change background
		Button b = new Button();
		b.setText("Random Background");
		b.setOnAction((event) -> {
			this.background(Color.color(Math.random(), Math.random(), Math.random()));
		});
		hbox.getChildren().add(b);

		Button b2 = new Button();
		// Create Button to add more shapes
		b2.setText("Add More Random Shapes");
		b2.setOnAction((event) -> {
			createShapes();
		});
		hbox.getChildren().add(b2);

		// Create Button to remove
		Button b3 = new Button();
		b3.setText("Remove All Shapes");
		b3.setOnAction((event) -> {
			removeAll();
		});
		hbox.getChildren().add(b3);
		
		// Create Button to remove
		Button b4 = new Button();
		b4.setText("Randomize Current Shapes");
		b4.setOnAction((event) -> { radomizeCurrent();  });	
		hbox.getChildren().add(b4);
		
		return hbox;

	}
	
	private void radomizeCurrent()
	{		
		int loops = shapes.size() / 5;
		removeAll();		
		for (int i = 0; i < loops; i++) {
			createShapes();
		}
	}

	private void removeAll() {
		shapes = new ArrayList<Shape>();
	}

	private void createShapes() {
		shapes.add(new Circle(this.height, this.width));
		shapes.add(new Square(this.height, this.width));
		shapes.add(new Rectangle(this.height, this.width));
		shapes.add(new Star(this.height, this.width));
		shapes.add(new Oval(this.height, this.width));
	}

	@Override
	public void draw() {

		for (Shape shape : shapes) {
			//System.out.println(shapes.size());
			shape.update();
			shape.draw(graphicContext);
			//System.out.printf("X: %d%n",shape.getX());
			//System.out.printf("Y: %d%n",shape.getY());
			shape.checkCollision(shapes);
			//x = shape.getX();
			//y = shape.getY();
		}//collision check method

	}

}
