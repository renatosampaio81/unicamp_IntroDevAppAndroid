package com.rsa.textview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txtA;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = (TextView)findViewById(R.id.txtA);
        count = 0;

    }

    public void onClick(View view) {
        count += 1;
        txtA.setText("Você pressionou o botão: "+count);
    }

}