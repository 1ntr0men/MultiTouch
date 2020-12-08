package com.example.multitouch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private TextView[] txt = new TextView[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout cr = findViewById(R.id.root);
        txt[0] = findViewById(R.id.txt1);
        txt[1] = findViewById(R.id.txt2);
        txt[2] = findViewById(R.id.txt3);
        txt[3] = findViewById(R.id.txt4);
        txt[4] = findViewById(R.id.txt5);
        txt[5] = findViewById(R.id.txt6);
        txt[6] = findViewById(R.id.txt7);
        txt[7] = findViewById(R.id.txt8);
        txt[8] = findViewById(R.id.txt9);
        txt[9] = findViewById(R.id.txt10);

        cr.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int xPos = -1;
        int yPos = -1;
        int count = event.getPointerCount();
        for (int i = 0; i < count; i++){
            xPos = (int) event.getX(i);
            yPos = (int) event.getY(i);
            txt[i].setText(Integer.toString(xPos) + " " + Integer.toString(yPos));
        } // при отпускании сразу нескольких пальцев он выводит координаты пыльца, который положили последним, как исправить это я не знаю
        //я  так понимаю что надо работать не с индексом, а с id пальца, но функция всегда принимает именно индекс
        return true;
    }
}