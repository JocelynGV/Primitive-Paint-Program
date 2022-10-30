package practice;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * File: MouseShapes
 * Author: Jocelyn Varghese
 * Date Created: Oct 29, 2022
 * Date Modified: Oct 29, 2022
 * Description: Create shapes of different colors and sizes in JavaFX
 * */

public class MouseShapes extends Application {
	// Create pane for the canvas
	Pane canvasPane = new Pane();
	
	// Create text fields
	TextField tfCircleRad = new TextField();
	TextField tfRectWidth = new TextField();
	TextField tfRectHeight = new TextField();
	
	// Create boolean for stroke
	boolean hasStroke = false;
	
	// Change shape dimensions	
	double radius = 5, rectHeight = 8, rectWidth = 16;
	
	Color color = Color.BLACK;
	
	public void start(Stage primaryStage) {		
		// Create and add text
		Text txtStart = new Text(20, 20, "Click on a shape to start!");
//		txtStart.setX(pane.getWidth() / 2);
//		txtStart.setY(pane.getHeight() / 2);
		canvasPane.setStyle("-fx-background-color: white;");
		canvasPane.getChildren().add(txtStart);
		
		
		// Create some buttons!
		Button btCircle = new Button("Circle");
		Button btRect = new Button("Rectangle");
		Button btClear = new Button("Clear");
		Button btUndo = new Button("Undo");

		
		// Put them in an Hbox Pane!
		HBox hBox = new HBox(15);
		hBox.getChildren().addAll(btCircle, btRect, btClear, btUndo);
		hBox.setAlignment(Pos.CENTER);
		hBox.setPadding(new Insets(5, 5, 5, 5));
		hBox.setStyle("-fx-background-color: gray;");

		
		// Create labels
		Label lRadius = new Label("Radius: ");
		Label lHeight = new Label("Height: ");
		Label lWidth = new Label("Width: ");
		lRadius.setTextFill(Color.WHITE);
		lHeight.setTextFill(Color.WHITE);
		lWidth.setTextFill(Color.WHITE);
		
		// Change text fields' sizes
		tfCircleRad.setMaxWidth(40);
		tfRectWidth.setMaxWidth(40);
		tfRectHeight.setMaxWidth(40);
		
		// Create stack pane for stroke rectangle
		StackPane stackPane = new StackPane();
		Rectangle stroke = new Rectangle(40, 25);
		stroke.setArcHeight(5);
		stroke.setArcWidth(5);
		stroke.setStroke(Color.BLACK);
		stroke.setFill(Color.GAINSBORO);
		Text text = new Text("Stroke");
//		text.xProperty().bind(stroke.xProperty());
		stackPane.getChildren().addAll(stroke, text);
		
		// Put them in a vbox
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(lRadius, tfCircleRad, lHeight, tfRectHeight, lWidth, tfRectWidth, stackPane);
		vBox.setPadding(new Insets(5, 5, 5, 5));
		vBox.setAlignment(Pos.CENTER);
		vBox.setStyle("-fx-background-color: gray;");

		
		// Create color buttons and out them in pane
		Button btRed = new Button("Red");		
		Button btBlue = new Button("Blue");
		Button btGreen = new Button("Green");
		Button btYellow = new Button("Yellow");
		Button btOrange = new Button("Orange");
		Button btPurple = new Button("Purple");
		Button btPink = new Button("Pink");
		Button btBrown = new Button("Brown");
		Button btWhite = new Button("White");
		Button btBlack = new Button("Black");
		Button btGray = new Button("Gray");
		
		ArrayList<Button> colorBts = new ArrayList<>(Arrays.asList(btRed, btBlue, btGreen, btYellow, btOrange, btPurple, btPink, btBrown, btWhite, btBlack, btGray));
		
		// Change button sizes
		for (int i = 0; i < colorBts.size(); i++) {
			colorBts.get(i).setMinWidth(55);
		}
		
		// Add button array to vbox pane
		VBox vBox2 = new VBox(5);
		vBox2.getChildren().addAll(colorBts);
		vBox2.setAlignment(Pos.CENTER);
		vBox2.setPadding(new Insets(5, 5, 5, 5));
		vBox2.setStyle("-fx-background-color: gray;");

		
		// Put panes into a border pane
		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(canvasPane);
		borderPane.setBottom(hBox);
		borderPane.setLeft(vBox2);
		borderPane.setRight(vBox);
		
		Scene scene = new Scene(borderPane, 600, 400);
		primaryStage.setTitle("MouseCircles");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
		// Change shape dimensions
		tfCircleRad.setOnAction(e -> setRadius());
		tfRectHeight.setOnAction(e -> {
			setHeight();
			
			if (tfRectWidth.getText() != null && !tfRectWidth.getText().isEmpty()) {
				setWidth();
			}
		});
		
		tfRectWidth.setOnAction(e -> {
			setWidth();
			
			if (tfRectHeight.getText() != null && !tfRectHeight.getText().isEmpty()) {
				setHeight();
			}
		});
		
		
		// Add or remove stroke
		stackPane.setOnMouseClicked(e -> {
			if (!hasStroke) {
				hasStroke = true;
				stroke.setFill(Color.DARKGREY);
				text.setFill(Color.WHITE);
			} else {
				hasStroke = false;
				stroke.setFill(Color.GAINSBORO);
				text.setFill(Color.BLACK);
			}
		});
		
		
		// Pick colors
		btRed.setOnAction(e -> color = Color.RED);
		btBlue.setOnAction(e -> color = Color.AQUA);
		btGreen.setOnAction(e -> color = Color.LAWNGREEN);
		btYellow.setOnAction(e -> color = Color.YELLOW);
		btOrange.setOnAction(e -> color = Color.DARKORANGE);
		btPurple.setOnAction(e -> color = Color.DARKORCHID);
		btPink.setOnAction(e -> color = Color.HOTPINK);
		btBrown.setOnAction(e -> color = Color.PERU);
		btWhite.setOnAction(e -> color = Color.WHITE);
		btBlack.setOnAction(e -> color = Color.BLACK);
		btGray.setOnAction(e -> color = Color.LIGHTSLATEGRAY);
		
		
		// Make circles
		btCircle.setOnAction(e -> {
			// Remove start text and add new text
			canvasPane.getChildren().remove(txtStart);
			
			canvasPane.setOnMousePressed(e2 -> {
				Circle circle = new Circle(radius);
				
				// Set stroke
				if (hasStroke) {
					circle.setStroke(Color.BLACK);
				} else {
					circle.setStroke(null);
				}
				
				circle.setFill(color);
				circle.setCenterX(e2.getX());
				circle.setCenterY(e2.getY());
				canvasPane.getChildren().add(circle);
			});
		});
		
		
		// Make rectangles
		btRect.setOnAction(e -> {
			// Remove start text and add new text
			canvasPane.getChildren().remove(txtStart);

			/*
			Text txtStart2 = new Text(20, 40, "Click anywhere to draw");
			pane.getChildren().add(txtStart2);  */

			canvasPane.setOnMousePressed(e2 -> {
				// Remove second start text
//				pane.getChildren().remove(txtStart2);
				
				Rectangle rect = new Rectangle(rectWidth, rectHeight);
				
				// Set stroke
				if (hasStroke) {
					rect.setStroke(Color.BLACK);
				} else {
					rect.setStroke(null);
				}
				
				rect.setFill(color);
				rect.setX(e2.getX() - (rect.getWidth() / 2));
				rect.setY(e2.getY() - (rect.getHeight() / 2));
				canvasPane.getChildren().add(rect);
			});
		});
		
		
		// Clear the board
		btClear.setOnAction(e -> canvasPane.getChildren().clear());
		
		// Undo last action
		btUndo.setOnAction(e -> {
			if (!canvasPane.getChildren().isEmpty()) {
				canvasPane.getChildren().remove(canvasPane.getChildren().size() - 1);
			}
		});
		
	}
	
	private void setRadius() {
		radius = Double.parseDouble(tfCircleRad.getText());
	}
	
	private void setWidth() {
		rectWidth = Double.parseDouble(tfRectWidth.getText());
	}
	
	private void setHeight() {
		rectHeight = Double.parseDouble(tfRectHeight.getText());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
