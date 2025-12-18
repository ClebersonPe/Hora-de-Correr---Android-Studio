package com.dsn.horadecorrer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class telaLogin extends AppCompatActivity {

    String login = "admin";
    String senha = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText inputEmail = findViewById(R.id.inputEmail);
        EditText inputSenha = findViewById(R.id.inputSenha);
        TextView alert = findViewById(R.id.alert);

        btnLogin.setOnClickListener(v ->{
            String usuarioInput = inputEmail.getText().toString();
            String senhaInput = inputSenha.getText().toString();

            if(login.equals(usuarioInput) && senha.equals(senhaInput)){
                Intent telaGames = new Intent(this, telaJogo.class);
                startActivity(telaGames);
            }else{
                alert.setText("Erro ao entrar, verifique seu usuário e senha");
            }

        });
    }
}