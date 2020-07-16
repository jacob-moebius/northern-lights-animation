package edu.miracostacollege.cs134.northernlightsanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Frame Animation; starts as null in this case
    AnimationDrawable frameAnim;

    // Tween Animations
    Animation rotateAnim;
    Animation shakeAnim;
    Animation newsyAnim;

    private ImageView lightsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightsImageView = findViewById(R.id.lightsImageView);
    }

    public void toggleFrameAnim(View v) {
        if (frameAnim == null) {
            lightsImageView.setBackgroundResource(R.drawable.frame_anim);
            frameAnim = (AnimationDrawable) lightsImageView.getBackground();
        }

        // If animation is running, stop animation
        if (frameAnim.isRunning()) {
            frameAnim.stop();
        } else {
            frameAnim.start();
        }
    }

    public void toggleRotateAnim(View v) {
        // Check if the rotate anim has already started
        if (rotateAnim != null && rotateAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            rotateAnim = null;
        } else {
            rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
            lightsImageView.startAnimation(rotateAnim);
        }
    }

    public void toggleShakeAnim(View v) {
        if (shakeAnim != null && shakeAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            shakeAnim = null;
        } else {
            shakeAnim = AnimationUtils.loadAnimation(this, R.anim.shake_anim);
            lightsImageView.startAnimation(shakeAnim);
        }
    }

    public void toggleCustomAnim(View v) {
        if (newsyAnim != null && newsyAnim.hasStarted()) {
            lightsImageView.clearAnimation();
            newsyAnim = null;
        } else {
            newsyAnim = AnimationUtils.loadAnimation(this, R.anim.newsy_anim);
            lightsImageView.startAnimation(newsyAnim);
        }
    }
}

