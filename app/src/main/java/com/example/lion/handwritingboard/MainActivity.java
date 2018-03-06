package com.example.lion.handwritingboard;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button clearBtn;
    MyPaintView paintView;
    ImageView imageView;
    Canvas canvas;
    Bitmap bitmap;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // 将自定义的控件类作为整个布局
        //setContentView(new MyPaintView(this));

        //使用布局文件
        setContentView(R.layout.activity_main);

        paintView = (MyPaintView) findViewById(R.id.view_paint);
        imageView = (ImageView) findViewById(R.id.image);
        clearBtn = (Button)findViewById(R.id.btn_clear);

        clearBtn.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                if (bitmap == null) {
                    bitmap = Bitmap.createBitmap(paintView.getWidth(), paintView.getHeight(), Bitmap.Config.RGB_565);
                    canvas = new Canvas(bitmap);
                }

                paintView.draw(canvas);
                imageView.setImageBitmap(bitmap);
                paintView.clear();

            }
        });
    }
}