package com.onlyuniquesoft.buttons;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deneme Git 1
    int a1;
    Button button1,button2;
    RotateAnimation ra=new RotateAnimation(0.0f,360.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);//0.of 0 dereceden başla 360 derece dön demek
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1= (Button) findViewById(R.id.button1);
        button1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {//View v button,MotionEvent evet basılıp çekildigi kontrol eder.
               switch(event.getAction()){
                   case MotionEvent.ACTION_UP:{
                       Toast.makeText(MainActivity.this, "Buttondan Çektin", Toast.LENGTH_SHORT).show();

                       Button view=(Button)v;
                       view.getBackground().clearColorFilter();
                       view.invalidate();
                       break;

                   }case MotionEvent.ACTION_DOWN:{
                      // Toast.makeText(MainActivity.this,"Buttona Bastın",Toast.LENGTH_SHORT).show();
                       Button view=(Button)v;
                       view.getBackground().setColorFilter(0x77000000, PorterDuff.Mode.SRC_ATOP);
                       view.invalidate();
                       break;
                   }
                   case MotionEvent.ACTION_CANCEL:{

                       Button view=(Button)v;
                       view.getBackground().clearColorFilter();
                       view.invalidate();
                       break;

                   }
               }

                return true;
            }
        });

        /*button1.setOnClickListener(new View.OnClickListener() { //Button image si iken yapılan click listener
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Button 1 e Bastın ",Toast.LENGTH_LONG).show();// Bu islem Mesaj vermek için

            }
        });
        */

        button2= (Button) findViewById(R.id.button2);
        ra.setDuration(500); //Animasyonun ne kadar sürede duracagı
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Butona Bastın",Toast.LENGTH_SHORT).show();
                button2.startAnimation(ra);//ra animasyonunu Baslatır
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
