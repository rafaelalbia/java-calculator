package application;

import com.sun.javafx.scene.control.skin.ButtonSkin;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

// Ripple effect structure
public class MaterialDesignButton extends Button {
	
	// Ripple effect variables
	private Circle circleRipple;
	private Rectangle rippleClip = new Rectangle();
	private Duration rippleDuration = new Duration(250);
	private double lastRippleHeight = 0;
	private double lastRippleWidth = 0;
	private Color rippleColor = new Color(0, 0, 0, 0.11);
	
	public MaterialDesignButton(String text) {
		super(text);
		
		getStyleClass().addAll("md-button");
		
		// Will call the function with the effect
		createRippleEffect();
	}
	
	@Override
	protected Skin<?> createDefaultSkin() {
		final ButtonSkin buttonSkin = new ButtonSkin(this);
		// Adding circleRipple as first node of button nodes to be on the bottom
		this.getChildren().add(0, circleRipple);
		return buttonSkin;
	}
	
	private void createRippleEffect() {
		circleRipple = new Circle(0.1, rippleColor);
		circleRipple.setOpacity(0.0);
		// Optional box blur on ripple - smoother ripple effect
//		circleRipple.setEffect(new BoxBlur(3, 3, 2));
		
		
		// Fade effect bit longer to show edges on the end
		final FadeTransition fadeTransition = new FadeTransition(rippleDuration, circleRipple);
		fadeTransition.setInterpolator(Interpolator.EASE_OUT);
		fadeTransition.setFromValue(1.0);
		fadeTransition.setToValue(0.0);
		
		final Timeline scaleRippleTimeline = new Timeline();
		
		final SequentialTransition parallelTransition = new SequentialTransition();
		parallelTransition.getChildren().addAll(
				scaleRippleTimeline,
				fadeTransition
			);
		
		parallelTransition.setOnFinished(event1 -> {
			circleRipple.setOpacity(0.0);
			circleRipple.setRadius(0.1);
		});
		
		
	}
}
