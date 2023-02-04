package com.renato.pastel_projetocoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class PastelSizeActivity extends AppCompatActivity {
    private ListView pastelSizeListView;
    public  static   OrderDetails pastel = new OrderDetails();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pastel_size);

        pastelSizeListView = (ListView) findViewById(R.id.sizelistview);

        pastelSizeListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(PastelSizeActivity.this,"A partir de R$ 10", Toast.LENGTH_SHORT).show();
                }
                if(position == 1){
                    Toast.makeText(PastelSizeActivity.this,"A partir de R$ 12", Toast.LENGTH_SHORT).show();
                }
                if(position == 2){
                    Toast.makeText(PastelSizeActivity.this,"A partir de R$ 16", Toast.LENGTH_SHORT).show();
                }
                if(position == 3){
                    Toast.makeText(PastelSizeActivity.this,"A partir de R$ 21", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

        pastelSizeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), FlavorsActivity.class);

                if(position == 0){
                    pastel.setSize("Mini Pasteis");
                    pastel.plusSetTotalPrice(10);
                    startActivity(intent);
                }
                if(position == 1){
                    pastel.setSize("Pastel de Feira");
                    pastel.plusSetTotalPrice(12);
                    startActivity(intent);
                }
                if(position == 2){
                    pastel.setSize("Pastelão");
                    pastel.plusSetTotalPrice(16);
                    startActivity(intent);
                }
                if(position == 3){
                    pastel.setSize("Pastel Gigante");
                    pastel.plusSetTotalPrice(21);
                    startActivity(intent);
                }
            }
        });
    }
}