package org.coursera.miformulariomd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import org.coursera.miformulariomd.clases.Contacto;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnSiguiente;
    private Contacto contacto;
    private TextInputEditText nombreCompleto, descripcion, email, telefono;
    private static TextInputEditText fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacto = (Contacto) getIntent().getSerializableExtra("Contacto");

        telefono = findViewById(R.id.txtTelefono);
        descripcion = findViewById(R.id.txtDescContacto);
        btnSiguiente = findViewById(R.id.btnSiguente);
        email = findViewById(R.id.txtEmail);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacto = guardarContacto();
                if(contacto != null){
                    Intent intent = new Intent(getApplicationContext(), ConfirmaDatos.class);
                    intent.putExtra("Contacto", contacto);
                    startActivity(intent);
                }

            }
        });

        nombreCompleto  = findViewById(R.id.txtNombre);
        fechaNacimiento = findViewById(R.id.txtFechNacimiento);
        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(v);
            }
        });

        if(contacto != null){
            nombreCompleto.setText(contacto.getNombreCompleto());
            fechaNacimiento.setText(contacto.getFechaNac());
            telefono.setText(contacto.getTelef());
            descripcion.setText(contacto.getDescContacto());
            email.setText(contacto.getEmail());
        }
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private Contacto guardarContacto(){
        Contacto contacto = new Contacto();
        try {
            contacto.setNombreCompleto(nombreCompleto.getText().toString());
            contacto.setFechaNac(fechaNacimiento.getText().toString());
            contacto.setEmail(email.getText().toString());
            contacto.setTelef(telefono.getText().toString());
            contacto.setDescContacto(descripcion.getText().toString());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return contacto;
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            fechaNacimiento.setText(day+"/"+month+"/"+year);

        }
    }


}


