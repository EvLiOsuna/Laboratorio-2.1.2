package mx.edu.ittepic.lab_212;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nombre, cel, dir, fecha, hora, platillos, postres;
    CheckBox basic, lujo;
    SeekBar meseros;
    Button grd, obt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        cel = findViewById(R.id.celular);
        dir = findViewById(R.id.direccion);
        fecha  = findViewById(R.id.fecha);
        hora = findViewById(R.id.hora);
        platillos = findViewById(R.id.platillos);
        postres = findViewById(R.id.postres);

        basic = findViewById(R.id.basica);
        lujo = findViewById(R.id.lujo);

        meseros = findViewById(R.id.seekbar);





    }
    public void guardarPreferencia (View v){

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("Nombre", nombre.getText().toString());
        editor.putString("Celular", cel.getText().toString());
        editor.putString("Direccion", dir.getText().toString());
        editor.putString("Fecha", fecha.getText().toString());
        editor.putString("Hora", hora.getText().toString());
        editor.putString("Platillos", platillos.getText().toString());
        editor.putString("Postres", postres.getText().toString());


        editor.putBoolean("Basica",basic.isChecked());
        editor.putBoolean("Lujo",lujo.isChecked());

        editor.putInt("Meseros",meseros.getProgress());


        editor.commit();


        Toast.makeText(this,"Se han Guardado tus Datos", Toast.LENGTH_LONG).show();
    }


    public void obtenerPreferencia (View v){

        String n,c,d,f,h,p,po;
        Boolean g1,g2;
        int mes;

        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);

        n = sharedPreferences.getString("Nombre",null);
        c = sharedPreferences.getString("Celular",null);
        d = sharedPreferences.getString("Direccion",null);
        f = sharedPreferences.getString("Fecha",null);
        h = sharedPreferences.getString("Hora",null);
        p = sharedPreferences.getString("Platillos",null);
        po = sharedPreferences.getString("Postres",null);


        g1= sharedPreferences.getBoolean("Basica", false);
        g2= sharedPreferences.getBoolean("Lujo", false);

        mes = sharedPreferences.getInt("Meseros",0);

        nombre.setText(n);
        cel.setText(c);
        dir.setText(d);
        fecha.setText(f);
        hora.setText(h);
        platillos.setText(p);
        postres.setText(po);

        basic.setChecked(g1);
        lujo.setChecked(g2);

        meseros.setProgress(mes);


        Toast.makeText(this,"Configuracion Cargada", Toast.LENGTH_LONG).show();
    }
}


