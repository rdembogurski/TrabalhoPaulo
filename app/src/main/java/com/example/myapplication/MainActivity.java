package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNome, etEmail, etIdade, etDisciplina, numPrimeirobi, numSegundobi;
    private TextView txInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);
        etIdade = findViewById(R.id.etIdade);
        etDisciplina = findViewById(R.id.etDisciplina);
        numPrimeirobi = findViewById(R.id.numPrimeirobi);
        numSegundobi = findViewById(R.id.numSegundobi);
        txInfo = findViewById(R.id.txInfo);
        Button btCalcula = findViewById(R.id.btCalcula);


        btCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                String idade = etIdade.getText().toString();
                String disciplina = etDisciplina.getText().toString();

                double nota1 = Double.parseDouble(numPrimeirobi.getText().toString());
                double nota2 = Double.parseDouble(numSegundobi.getText().toString());

                double media = (nota1 + nota2) / 2;

                if (media >= 7) {
                    String resultado = "Nome: " + nome + "\nEmail: " + email + "\nIdade: " + idade +
                            "\nDisciplina: " + disciplina + "\nNota 1º Bimestre: " + nota1 +
                            "\nNota 2º Bimestre: " + nota2 + "\nAluno Aprovado";
                    txInfo.setText(resultado);
                }

                else if (media < 7 ){
                    String resultado = "Nome: " + nome + "\nEmail: " + email + "\nIdade: " + idade +
                            "\nDisciplina: " + disciplina + "\nNota 1º Bimestre: " + nota1 +
                            "\nNota 2º Bimestre: " + nota2 + "\nAluno Reprovado";

                    txInfo.setText(resultado);
                }
            }
        });
    }
}