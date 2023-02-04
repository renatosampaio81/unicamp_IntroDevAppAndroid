package com.renato.pastel_projetocoursera;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class FlavorsActivity extends AppCompatActivity {
    public RadioGroup  flavorsGroup;
    public RadioButton flavorSelection;
    public TextView    footer;
    public Button      flavorButton;
    public float       selectedFlavorValue = 0;
    public String      flavor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flavors);

        flavorsGroup = (RadioGroup) findViewById(R.id.radiogroupflavor);
        footer       = (TextView)   findViewById(R.id.footer);
        flavorButton = (Button)     findViewById(R.id.flavorbutton);

        updateFooter();

        flavorsGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = flavorsGroup.getCheckedRadioButtonId();

                if(id == R.id.calabresarb)
                {
                    selectedFlavorValue = (float)2.0;
                    flavor = ((RadioButton)findViewById(R.id.calabresarb)).getText().toString();
                    flavor = flavor.substring(0, flavor.indexOf(" "));
                    updateFooter();
                }
                if(id == R.id.queijob)
                {
                    selectedFlavorValue = (float) 3.0;
                    flavor = ((RadioButton)findViewById(R.id.queijob)).getText().toString();
                    flavor = flavor.substring(0, flavor.indexOf(" "));
                    updateFooter();
                }
                if(id == R.id.portuguesarb)
                {
                    selectedFlavorValue = (float)3.50;
                    flavor = ((RadioButton)findViewById(R.id.portuguesarb)).getText().toString();
                    flavor = flavor.substring(0, flavor.indexOf(" "));
                    updateFooter();
                }
                if(id == R.id.frangorb)
                {
                    selectedFlavorValue = (float)4.50;
                    flavor = ((RadioButton)findViewById(R.id.frangorb)).getText().toString();
                    flavor = flavor.substring(0, flavor.indexOf(" "));
                    updateFooter();
                }
                if(id == R.id.camaraob)
                {
                    selectedFlavorValue = (float)6.50;
                    flavor = ((RadioButton)findViewById(R.id.camaraob)).getText().toString();
                    flavor = flavor.substring(0, flavor.indexOf(" "));
                    updateFooter();
                }
            }
        });

        flavorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flavorsGroup.getCheckedRadioButtonId() != -1) {
                    selectFlavor();
                }
                else
                {
                    Toast.makeText(FlavorsActivity.this, "Selecione um sabor", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void selectFlavor(){
        addressPopup();
    }

    public void updateFooter(){
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        footer.setText("Total: " + formatter.format(PastelSizeActivity.pastel.getTotalPrice() + selectedFlavorValue));
    }

    public void addressPopup(){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Entre com o endereço");

        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                PastelSizeActivity.pastel.setAddress(input.getText().toString());
                PastelSizeActivity.pastel.setFlavor(flavor);
                PastelSizeActivity.pastel.plusSetTotalPrice(selectedFlavorValue);

                Intent intent = new Intent(getApplicationContext(), ActivityResume.class);
                startActivity(intent);
                Toast.makeText(FlavorsActivity.this, "Pedido confirmado!", Toast.LENGTH_LONG).show();
            }
        });
        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alert.show();
    }
    @Override
    public void onBackPressed(){
        PastelSizeActivity.pastel.restart();
        super.onBackPressed();
    }
}

