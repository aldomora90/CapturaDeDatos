package com.aldomora.capturadedatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmar_datos);

        Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("nombre");
        String fecha = parametros.getString("fecha");
        String telefono = parametros.getString("telefono");
        String email = parametros.getString("email");
        String desc = parametros.getString("desc");

        Button editar = (Button) findViewById(R.id.btnEditar);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDesc = (TextView) findViewById(R.id.tvDesc);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDesc.setText(desc);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ConfirmarDatos.this,MainActivity.class);
                i.putExtra("nombre",tvNombre.getText());
                i.putExtra("fecha",tvFecha.getText());
                i.putExtra("telefono",tvTelefono.getText());
                i.putExtra("email",tvEmail.getText());
                i.putExtra("desc",tvDesc.getText());
                startActivity(i);
                finish();
            }
        });
    }
}
