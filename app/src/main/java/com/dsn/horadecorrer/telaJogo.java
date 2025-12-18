package com.dsn.horadecorrer;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.dsn.horadecorrer.classes.Veiculo;
import com.dsn.horadecorrer.classes.Personagem;


public class telaJogo extends AppCompatActivity {

    // Marquinhos
    Personagem marquinhoAzul = new Personagem("Relâmpago Marquinhos", "Azul", 360);
    Personagem marquinhoVermelho = new Personagem("Relâmpago Marquinhos", "Vermelho", 340);

    // Veículos
    Veiculo pernalonga  = new Veiculo("Pernalonga", 999);
    Veiculo dickvigarista = new Veiculo("Dick Vigarista", 130);
    Veiculo papaleguas = new Veiculo("Papaléguas", 500);
    Veiculo ligeirinho = new Veiculo("Ligeirinho", 300);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RadioButton rPernalonga = findViewById(R.id.radioPernalonga);
        RadioButton rDick = findViewById(R.id.radioDick);
        RadioButton rPapa = findViewById(R.id.radioPapa);
        RadioButton rlig = findViewById(R.id.radioLig);

        /*marquinhos*/

        RadioButton rAzul = findViewById(R.id.radioAzul);
        RadioButton rVermelho = findViewById(R.id.radioVermelho);

        Button btnCorrer = findViewById(R.id.btnCorrer);
        TextView resultado = findViewById(R.id.textResult);

        btnCorrer.setOnClickListener(v ->{
            // Verifica se os dois foram selecionados
            if (!rVermelho.isChecked() && !rAzul.isChecked()) {
                resultado.setText("Escolha um Marquinhos!");

            }

            if (!rPernalonga.isChecked() && !rDick.isChecked() &&
                    !rPapa.isChecked() && !rlig.isChecked()) {
                resultado.setText("Escolha um veículo!");

            }

            // Define o Marquinhos escolhido
            Personagem escolhido = rAzul.isChecked() ? marquinhoAzul : marquinhoVermelho;

            Veiculo rival;
            if (rPernalonga.isChecked()) {
                rival = pernalonga;
            } else if (rDick.isChecked()) {
                rival = dickvigarista;
            } else if (rPapa.isChecked()) {
                rival = papaleguas;
            } else {
                rival = ligeirinho;
            }


            // Compara velocidades
            String textoResultado;
            if (escolhido.velocidade > rival.velocidade) {
                textoResultado = escolhido.cor + " venceu! 💨";
            } else if (escolhido.velocidade < rival.velocidade) {
                textoResultado = rival.nome + " venceu! 🏁";
            } else {
                textoResultado = "Empate! 😮";
            }


            resultado.setText("Corrida: " + escolhido.cor + " vs " + rival.nome + "\n" + textoResultado);








        });


    }
}