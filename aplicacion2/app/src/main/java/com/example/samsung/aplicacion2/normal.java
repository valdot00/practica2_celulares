package com.example.samsung.aplicacion2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class normal extends AppCompatActivity {

    EditText Nombre,Edad,txbdecimal,txbbinario;
  //  TextView txbresultadobinario;
    Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Nombre = (EditText)findViewById(R.id.editText_Nombre);
        Edad = (EditText)findViewById(R.id.editText_Edad);
        txbdecimal = (EditText)findViewById(R.id.txbdecimal);
        txbbinario = (EditText)findViewById(R.id.txbbinario);

        ok=(Button)findViewById(R.id.button);

        ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int aux = Integer.parseInt(txbdecimal.getText().toString());//aux toma el valor del decimal
                String binario = "";//este almacenara el numero binario
                //proceso
                while (aux > 0) {

                    binario = aux % 2 + binario;

                    aux /= 2;//se divide el numero decimal entre 2

                    //aux=aux/2;

                }
                //para pasar los resultado a otra vista
                //resultado  decimal a binario
                Nombre.setText(binario);

                String numerobinario = txbbinario.getText().toString();

//
                int longitud = numerobinario.length();//numero de digitos que tiene el binario
                int resultado = 0;//resultado final
                int potencia = longitud - 1;


                try {

                    for (int i = 0; i < longitud; i++) {//recorremos la cadena de numeros
                        if (numerobinario.charAt(i) == '1') {
                            resultado += Math.pow(2, potencia);
                        }
                        potencia--;//decrementamos la potencia
                    }
                    // txbresultadodecimal.setText(resultado);

                    //
                    numerobinario = "";
                    numerobinario = String.valueOf(resultado);
                    Edad.setText(numerobinario);

                } catch (Exception ex) {
                }


                EviarDatos();
            }
        });

    }

    private void EviarDatos(){
        String nombre,edad,decimal,binario;

        binario = txbbinario.getText().toString();
        decimal = txbdecimal.getText().toString();
        nombre = Nombre.getText().toString();
        edad = Edad.getText().toString();

        Intent intent = new Intent(normal.this,Recibir.class);
        intent.putExtra("Nombre",nombre);
        intent.putExtra("Edad",edad);
        intent.putExtra("Binario",binario);
        intent.putExtra("Decimal",decimal);
        startActivity(intent);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_normal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
