name=android/example-app/app/src/main/java/org/fuerun/example/MainActivity.java
package org.fuerun.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.view.SurfaceView;
import android.util.Log;

public class MainActivity extends Activity {
    static {
        System.loadLibrary("native-lib");
    }

    private native void onTouchEventNative(float x, float y, int action, int pointerId);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout container = new FrameLayout(this);
        SurfaceView surface = new SurfaceView(this);
        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pointerIndex = event.getActionIndex();
                int pointerId = event.getPointerId(pointerIndex);
                float x = event.getX(pointerIndex);
                float y = event.getY(pointerIndex);
                int action = event.getActionMasked();
                onTouchEventNative(x, y, action, pointerId);
                return true; // indicate we handled the touch
            }
        });
        container.addView(surface);
        setContentView(container);
        Log.i("ExampleApp", "MainActivity created");
    }
}
