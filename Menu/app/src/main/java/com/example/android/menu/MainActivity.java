package com.example.android.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view){
        TextView mango = (TextView) findViewById(R.id.id_mango_sorbet);
        String string1 = mango.getText().toString();
        Log.v("MainActivity", string1);

        TextView blueberry = (TextView) findViewById(R.id.id_blueberry_pie);
        String string2 = (String) blueberry.getText();
        Log.v("MainActivity", string2);

        TextView chocolate = (TextView) findViewById(R.id.id_chocolate_lava_cake);
        String string3 = (String) chocolate.getText();
        Log.v("MainActivity", string3);

    }
}
