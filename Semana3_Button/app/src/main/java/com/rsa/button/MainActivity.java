package com.rsa.button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Toast toast = Toast.makeText(MainActivity.this, "Você pressionou o botão", Toast.LENGTH_SHORT);
        toast.show();
    }

}