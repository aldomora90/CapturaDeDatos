package com.aldomora.capturadedatos;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Contact contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextInputLayout nombreForm = (TextInputLayout) findViewById(R.id.nombreForm);
        final DatePicker fechaForm = (DatePicker) findViewById(R.id.fechaForm);
        final TextInputLayout telForm = (TextInputLayout) findViewById(R.id.telForm);
        final TextInputLayout emailForm = (TextInputLayout) findViewById(R.id.emailForm);
        final TextInputLayout descForm = (TextInputLayout) findViewById(R.id.descForm);
        Button siguiente = (Button) findViewById(R.id.sigButton);

        Bundle parametros = getIntent().getExtras();

        if(parametros != null){
            String nombre = parametros.getString("nombre");
            String fecha = parametros.getString("fecha");
            String telefono = parametros.getString("telefono");
            String email = parametros.getString("email");
            String desc = parametros.getString("desc");
            nombreForm.getEditText().setText(nombre);
            String [] fechaS = fecha.split("/");
            fechaForm.init(Integer.parseInt(fechaS[2]),Integer.parseInt(fechaS[1])-1,Integer.parseInt(fechaS[0]),null);
            telForm.getEditText().setText(telefono);
            emailForm.getEditText().setText(email);
            descForm.getEditText().setText(desc);
        }

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String formatoFecha = checkDigit(fechaForm.getDayOfMonth())+"/"+checkDigit(fechaForm.getMonth()+1)+"/"+String.valueOf(fechaForm.getYear());
                contacto = new Contact(nombreForm.getEditText().getText().toString(),formatoFecha,telForm.getEditText().getText().toString(),emailForm.getEditText().getText().toString(),descForm.getEditText().getText().toString());
                Intent i = new Intent(MainActivity.this,ConfirmarDatos.class);
                i.putExtra("nombre",contacto.getName());
                i.putExtra("fecha",contacto.getDate());
                i.putExtra("telefono",contacto.getTelephone());
                i.putExtra("email",contacto.getEmail());
                i.putExtra("desc",contacto.getDescription());
                startActivity(i);
                finish();
            }
        });
    }

    public String checkDigit(int number) {
        return number<=9?"0"+number:String.valueOf(number);
    }
}

