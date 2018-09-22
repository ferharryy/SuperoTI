package com.com.superoti.superoti;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.com.superoti.superoti.models.ArquivoModel;
import com.com.superoti.superoti.service.HttpService;
import java.util.concurrent.ExecutionException;


public class MainActivity extends AppCompatActivity {

    private ProgressDialog load;
    private TextView nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resposta = findViewById(R.id.etMain_resposta);

        Button btnBuscarArquivo = findViewById(R.id.btnMain_buscarArquivo);
        btnBuscarArquivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    ArquivoModel retorno = new HttpService().execute().get();
                    resposta.setText(retorno.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
