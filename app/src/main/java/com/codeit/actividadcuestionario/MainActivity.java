package com.codeit.actividadcuestionario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    RadioGroup grupoRadiospreguntas;
    RadioButton rbP1,rbP2,rbP3,rbP4;
    Button btnSiguiente;
    int contadorPregunta = 1;
    int notaFinal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        rbP1 = findViewById(R.id.rbP1);
        rbP2 = findViewById(R.id.rbP2);
        rbP3 = findViewById(R.id.rbP3);
        rbP4 = findViewById(R.id.rbP4);
        grupoRadiospreguntas = findViewById(R.id.grupoRadiospreguntas);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        tv1.setText("Pregunta #1");
        tv2.setText("¿Qué necesitan las plantas para vivir?");
        rbP1.setText("Sol, Agua, Tierra");
        rbP2.setText("Cocacola");
        rbP3.setText("Pizza");
        rbP4.setText("Chocolate");
        btnSiguiente.setEnabled(false);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluarRespuestas();
                contadorPregunta++;
                imprimirPreguntas();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        if (rbP1.isChecked()|| rbP2.isChecked()||rbP3.isChecked()||rbP4.isChecked()){
            btnSiguiente.setEnabled(true);
        }
    }

    public void evaluarRespuestas(){
        if (contadorPregunta==1){
            if (rbP1.isChecked()){
                notaFinal+=2;
            }
        }
        if (contadorPregunta==2){
            if (rbP3.isChecked()){
                notaFinal+=2;
            }
        }
        if (contadorPregunta==3){
            if (rbP1.isChecked()){
                notaFinal+=2;
            }
        }
        if (contadorPregunta==4){
            if (rbP2.isChecked()){
                notaFinal+=2;
            }
        }
        if (contadorPregunta==5){
            if (rbP2.isChecked()){
                notaFinal+=2;
            }
        }
    }

    public void imprimirPreguntas(){
        if (contadorPregunta==2){
            grupoRadiospreguntas.clearCheck();
            tv1.setText("Pregunta #2");
            tv2.setText("Cuánto es 1+1");
            rbP1.setText("La respuesta es 5");
            rbP2.setText("La respuesta es 8");
            rbP3.setText("La respuesta es 2");
            rbP4.setText("La respuesta es 9");
            btnSiguiente.setEnabled(false);
        }
        if (contadorPregunta==3){
            grupoRadiospreguntas.clearCheck();
            tv1.setText("Pregunta #3");
            tv2.setText("¿Cómo dicen los perros?");
            rbP1.setText("Wuaf Wuaf");
            rbP2.setText("Miau");
            rbP3.setText("Kikirikiiii");
            rbP4.setText("Oink Oink");
            btnSiguiente.setEnabled(false);
        }
        if (contadorPregunta==4){
            grupoRadiospreguntas.clearCheck();
            tv1.setText("Pregunta #4");
            tv2.setText("¿Cuál es la primera letra del Abedecedario?");
            rbP1.setText("La primera letra es P");
            rbP2.setText("La primera letra es A");
            rbP3.setText("La primera letra es U");
            rbP4.setText("La primera letra es S");
            btnSiguiente.setEnabled(false);
        }
        if (contadorPregunta==5){
            grupoRadiospreguntas.clearCheck();
            tv1.setText("Pregunta #5");
            tv2.setText("¿Los padres de mis padres son mis?");
            rbP1.setText("Tios");
            rbP2.setText("Abuelos");
            rbP3.setText("Sobrinos");
            rbP4.setText("Hermanos");
            btnSiguiente.setEnabled(false);
        }
        if (contadorPregunta>5){
            grupoRadiospreguntas.clearCheck();
            tv1.setText("SU NOTA ES: "+notaFinal);
            if (notaFinal>=6){
                tv2.setText("Aprobado");
            }else{
                tv2.setText("Reprobado");
            }
            grupoRadiospreguntas.setVisibility(View.INVISIBLE);
            btnSiguiente.setEnabled(false);
        }
    }

}