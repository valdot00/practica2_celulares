package com.example.samsung.aplicacion2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by samsung on 16/03/2016.
 */
public class Recibir extends Activity {

    TextView Nombre,Edad,Decimal,Binario;

    String nombre,edad,decimal,binario;

    protected  void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recibir);

        Nombre = (TextView)findViewById(R.id.TextView_nombre);
        Edad = (TextView)findViewById(R.id.TextView_Edad);
        Decimal= (TextView)findViewById(R.id.txbdecimal);
        Binario= (TextView)findViewById(R.id.txbbinario);

        Bundle bundle = this.getIntent().getExtras();

        nombre=bundle.getString("Nombre");
        edad=bundle.getString("Edad");
        decimal=bundle.getString("Decimal");
        binario=bundle.getString("Binario");

        Nombre.setText(nombre);
        Edad.setText(edad);
        Decimal.setText(decimal);
        Binario.setText(binario);

    }

}
