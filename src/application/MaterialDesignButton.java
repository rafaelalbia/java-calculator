package application;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class MaterialDesignButton extends Button {
	
	private Circle circleRipple;
	private Rectangle rippleClip = new Rectangle();
	private Duration rippleDuration = new Duration(250);
	private double lastRippleHeight = 0;
	private double lastRippleWidth = 0;
	private Color rippleColor = new Color(0, 0, 0, 0.11);
	
	public MaterialDesignButton(String text) {
		super(text);
		
		getStyleClass().addAll("md-button");
		
		createRippleEffect();
	}
	
	
}
