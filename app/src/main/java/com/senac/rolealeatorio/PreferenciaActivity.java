package com.senac.rolealeatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.rolealeatorio.dao.PreferenciaDAO;
import com.senac.rolealeatorio.model.Preferencia;

public class PreferenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencia);

        EditText tipo = findViewById(R.id.editTextTipoPreferencia);

        EditText nome = findViewById(R.id.editTextNomePreferencia);

        Button finalizar = findViewById(R.id.buttonCadastrarPreferencia);

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preferencia preferencia = new Preferencia();

                preferencia.setTipo(tipo.getText().toString());
                preferencia.setNome(nome.getText().toString());

                if (preferencia.isNomeEmptyOrNull() || preferencia.isTipoEmptyOrNull()){
                    Toast.makeText(PreferenciaActivity.this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
                } else {
                    PreferenciaDAO dao = new PreferenciaDAO(PreferenciaActivity.this, "roleAleatorio", null, 1);

                    dao.salva(preferencia);

                    Intent intencao = new Intent(PreferenciaActivity.this, LoginActivity.class);
                    startActivity(intencao);

                    Toast.makeText(PreferenciaActivity.this, "Sucesso", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}