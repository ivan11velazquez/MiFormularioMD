package org.coursera.miformulariomd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.coursera.miformulariomd.clases.Contacto;

public class ConfirmaDatos extends AppCompatActivity {

    private TextView nombreCompleto, fechaNacimiento, descContacto, telefono, email;
    private Button btnEditarDatos;
    private Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);
        contacto = (Contacto) getIntent().getSerializableExtra("Contacto");

        nombreCompleto = findViewById(R.id.txtNombreContacto);
        fechaNacimiento = findViewById(R.id.txtFechaNacimiento);
        descContacto = findViewById(R.id.txtDescripcionContactoEdit);
        telefono = findViewById(R.id.txtTelefonoConfirmacion);
        email = findViewById(R.id.txtEmailContacto);
        btnEditarDatos = findViewById(R.id.btnEditarDatos);

        if(contacto != null){
            nombreCompleto.setText(contacto.getNombreCompleto());
            fechaNacimiento.setText(contacto.getFechaNac());
            //descContacto.setText(contacto.getDescContacto());
            telefono.setText(contacto.getTelef());
            email.setText(contacto.getEmail());
            btnEditarDatos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("Contacto", contacto);
                    startActivity(intent);
                }
            });
        }else{

        }

    }
}
