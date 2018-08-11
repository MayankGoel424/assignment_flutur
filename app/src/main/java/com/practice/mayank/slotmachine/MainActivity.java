package com.practice.mayank.slotmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView img1,img2,img3;
    private Wheel wheel1,wheel2,wheel3;
    private Button btn;
    private int gh;
    private boolean isstarted;
    public static final Random RANDOM = new Random();
    public static long randomLong(long lower, long upper){
        return lower + (long) (RANDOM.nextDouble() * (upper-lower));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    img1 = (ImageView)findViewById(R.id.slot_1);
    img2 =(ImageView)findViewById(R.id.slot_2);
    img3=(ImageView)findViewById(R.id.slot_3);
    btn = (Button)findViewById(R.id.play);
    btn.setOnClickListener(new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            if (isstarted){
                wheel1.stopwheel();
                wheel2.stopwheel();
                wheel3.stopwheel();
                btn.setText("Play");
                isstarted=false;
            }
            else{
                wheel1 = new Wheel(new Wheel.Wheellistner() {
                    @Override
                    public void newImage(final int img) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img1.setImageResource(img);
                            }
                        });
                    }
                }, 200, randomLong(0,200));
                wheel1.start();

                wheel2 = new Wheel(new Wheel.Wheellistner() {
                    @Override
                    public void newImage(final int img) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img2.setImageResource(img);
                            }
                        });
                    }
                }, 200, randomLong(150,400));
                wheel2.start();

                wheel3 = new Wheel(new Wheel.Wheellistner() {
                    @Override
                    public void newImage(final int img) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                img3.setImageResource(img);
                            }
                        });
                    }
                }, 200, randomLong(150,400));
                wheel3.start();
                btn.setText("Stop");
                isstarted=true;
            }
        }
    });
    }
}
