package com.renato.pastel_projetocoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class ActivityResume extends AppCompatActivity {
    public TextView sizeView;
    public TextView flavorView;
    public TextView priceView;
    public TextView addressView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume);

        sizeView = (TextView) findViewById(R.id.sizeresume);
        flavorView = (TextView) findViewById(R.id.flavorresume);
        priceView = (TextView) findViewById(R.id.priceresume);
        addressView = (TextView) findViewById(R.id.addressresume);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        sizeView.setText("Tamanho: "  + PastelSizeActivity.pastel.getSize().toString());
        flavorView.setText("Sabor: "  + PastelSizeActivity.pastel.getFlavor().toString());
        priceView.setText("Total: " + formatter.format(PastelSizeActivity.pastel.getTotalPrice()));
        addressView.setText("Endereço para entrega: "  + PastelSizeActivity.pastel.getAddress().toString());
    }
}