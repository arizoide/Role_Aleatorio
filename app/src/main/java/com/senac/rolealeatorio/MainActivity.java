package com.senac.rolealeatorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.senac.rolealeatorio.dao.UsuarioDAO;
import com.senac.rolealeatorio.model.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Button finalizarCadastroUsuario = findViewById(R.id.buttonFinalizarCadastroUsuario);
        Button limparCadastroUsuario = findViewById(R.id.buttonLimpar);
        EditText editTextNome = findViewById(R.id.editTextNome);
        EditText editTextSobrenome = findViewById(R.id.editTextSobrenome);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextCPF = findViewById(R.id.editTextCPF);
        EditText editTextSenha = findViewById(R.id.editTextSenha);
        EditText editTextDataNascimento = findViewById(R.id.editTextDataNascimento);

        finalizarCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Usuario usuario = new Usuario();
                usuario.setNome(editTextNome.getText().toString());
                usuario.setSobrenome(editTextSobrenome.getText().toString());
                usuario.setEmail(editTextEmail.getText().toString());
                usuario.setSenha(editTextSenha.getText().toString());
                usuario.setCPF(editTextCPF.getText().toString());

                if (usuario.isCPFNullOrEmpty() || usuario.isEmailNullOrEmpty() || usuario.isSenhaNullOrEmpty()) {
                    Toast.makeText(MainActivity.this, "CPF, Email e senha são obrigatórios", Toast.LENGTH_LONG).show();
                } else {
                    UsuarioDAO dao = new UsuarioDAO(MainActivity.this, "roleAleatorio", null, 1);

                    dao.salva(usuario);

                    Intent intencao = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intencao);

                    Toast.makeText(MainActivity.this, "Sucesso", Toast.LENGTH_LONG).show();

                }
            }
        });

        limparCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextNome.setText("");
                editTextSobrenome.setText("");
                editTextEmail.setText("");
                editTextSenha.setText("");
                editTextCPF.setText("");
                editTextDataNascimento.setText("");
            }
        });
    }
}