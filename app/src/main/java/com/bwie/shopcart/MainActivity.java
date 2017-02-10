package com.bwie.shopcart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.shopcart.view.Bezier;

/**
 * 主类
 */
public class MainActivity extends AppCompatActivity {

    ImageView imageView;
//    TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Bezier(this));
    }
}
