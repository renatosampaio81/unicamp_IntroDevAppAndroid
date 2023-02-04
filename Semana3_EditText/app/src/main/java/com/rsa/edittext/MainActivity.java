package com.rsa.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtB = (EditText)findViewById(R.id.editText);
    }

    public void onClick(View view) {
        String txtC = txtB.getText().toString();
        Toast toast = Toast.makeText(this, "Você escreveu: " + txtC, Toast.LENGTH_SHORT);
        toast.show();
    }
}