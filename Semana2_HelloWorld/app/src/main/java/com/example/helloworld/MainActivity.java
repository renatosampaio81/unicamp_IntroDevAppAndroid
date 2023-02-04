package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    TextView textView; //informa o tipo da var textView
    EditText txtA;
    EditText txtB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //chama oncreate da classe pai
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.tVHello); //localiza o objeto com id textiew_first lá no fragment_first
        System.out.println(textView.getText()); //imprime no Run o conteúdo do texto do objeto localizado acima

        txtA = (EditText)findViewById(R.id.txtA);
        txtB = (EditText)findViewById(R.id.txtB);



        //public static void main(String[] args){
        float number1 = 6;
        float number2 = 4;

        Operacoes operacoes = new Operacoes(number1, number2);
        System.out.println(operacoes.soma());
        System.out.println(operacoes.subtracao());
        System.out.println(operacoes.multiplicacao());
        System.out.println(operacoes.divisao());
        //}

    }

    public void onSoma(View view) {
        int a = Integer.parseInt(txtA.getText().toString());
        int b = Integer.parseInt(txtB.getText().toString());
        Operacoes operacoes = new Operacoes(a,b);
        textView.setText(String.valueOf(operacoes.soma()));
    }

}