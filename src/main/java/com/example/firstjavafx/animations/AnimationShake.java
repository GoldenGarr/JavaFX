package com.example.firstjavafx.animations;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class AnimationShake {
    private TranslateTransition tt;

    public AnimationShake(Node node) {
        tt = new TranslateTransition(Duration.millis(100), node);

        // Shift from original
         tt.setFromX(0f);

        // Amount of pixels to move the node by
        tt.setByX(10f);

        tt.setCycleCount(4);

        // To make the node return to its original place
        tt.setAutoReverse(true);
    }

    public void execute() {
        tt.playFromStart();
    }
}
