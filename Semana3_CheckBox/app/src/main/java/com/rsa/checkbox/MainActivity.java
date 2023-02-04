package com.rsa.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox checkBox_1;
    CheckBox checkBox_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox_1 = (CheckBox) findViewById(R.id.checkbox_1);
        checkBox_2 = (CheckBox) findViewById(R.id.checkbox_2);
    }

    /* chamado quando algum dos CBs são clicados */
    public void onCheckboxClicked(View view) {  //a view que ele recebe como parâmetro é a box clicada
        boolean checked = ((CheckBox) view).isChecked(); //a view recebida é transformada par atipo checkbox e verificada se está check
        switch (view.getId()) { //compara a ID que chegou como parâmetro
            case R.id.checkbox_1:
                if (checked) {
                    Toast.makeText(this, "Você selecionou a primeira opção", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Você cancelou a primeira opção", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkbox_2:
                if (checked) {
                    Toast.makeText(this, "Você selecionou a segunda opção", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Você cancelou a segunda opção", Toast.LENGTH_SHORT).show();
                }
        }
    }

    /* chamado quando o button é clicado */
    public void onClick(View view) { //como a view que eu recebo é um botao e nao um checkbox, eu preciso usar as vars criadas no oncreate para verificar o check
        boolean checked1 = checkBox_1.isChecked();
        boolean checked2 = checkBox_2.isChecked();

        if (checked1 && checked2) {
            Toast.makeText(this, "Você selecionou as duas opções", Toast.LENGTH_SHORT).show();
        } else if (checked1) {
            Toast.makeText(this, "Você selecionou apenas a primeira opção", Toast.LENGTH_SHORT).show();
        } else if (checked2) {
            Toast.makeText(this, "Você selecionou apenas a segunda opção", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Você não selecionou nehuma opção", Toast.LENGTH_SHORT).show();
        }
    }

}