package com.example.matrixnnoperator;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btSoma = criarBotao("Somar");
        btSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SomaMatrizesActivity.class));
            }
        });

        Button btSubtrair = criarBotao("Subtrair");
        btSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SubtrairMatrizesActivity.class));
            }
        });

        Button btTransposta = criarBotao("Transposta");
        btTransposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),MatrizTranspostaActivity.class));
            }
        });


        Button btTraco = criarBotao("Calcular Traço");
        btTraco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),TracoMatrizActivity.class));
            }
        });

        Button btMultiplicar = criarBotao("Multiplicar");
        btMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),  ProdutoMatrizesActivity.class));
            }
        });

        LinearLayout container = createLinearLayout(LinearLayout.VERTICAL);

        container.addView(btSoma);
        container.addView(btSubtrair);
        container.addView(btTransposta);
        container.addView(btTraco);
        container.addView(btMultiplicar);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        TextView textView = new TextView(this);
        textView.setLayoutParams(params);
        textView.setTextColor(Color.parseColor("#008800"));
        textView.setText("Unifeso.");

        TextView textView2 = new TextView(this);
        textView2.setLayoutParams(params);
        textView2.setTextColor(Color.parseColor("#0000ff"));
        textView2.setText("Charles Campista - 01019179.");

        TextView textView3 = new TextView(this);
        textView3.setLayoutParams(params);
        textView3.setTextColor(Color.parseColor("#ff0000"));
        textView3.setText("Professor Nelson Lacerda.");

        container.addView(textView);
        container.addView(textView2);
        container.addView(textView3);
        setContentView(container);
    }

    /*private void createLayout(int ordemMatriz) {

    }

    private TableRow createTableRow(List<TextView> views){
        TableRow tableRow = new TableRow(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tableRow.setLayoutParams(params);
        //for (View view : views) {
        //    tableRow.addView((TextView) view);
        //}

        return tableRow;
    }


    private LinearLayout criarMatriz(int ordem, String[][] string){
        LinearLayout llMatrix = criarBaseMatrix();


        for(int i=0; i<ordem; i++){
            LinearLayout llLinha = criarLinha();
            for(int j=0; j<ordem; j++){
                llLinha.addView(createTextView(string[i][j]));
            }
            llMatrix.addView(llLinha);
        }

        return llMatrix;
    }


    private TextView createTextView(String value){
        TextView textView = new TextView(this);
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        );
        textView.setLayoutParams(params);
        textView.setText(value);
        return textView;
    }

    private TableLayout createTableLayout(){
        TableLayout tableLayout = new TableLayout(this);
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT
        );
        tableLayout.setLayoutParams(params);
        return  tableLayout;
    }*/

    private LinearLayout createLinearLayout(int orientation){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(orientation);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setPadding(10,10,10,10);
        return layout;
    }

    /*private LinearLayout criarLinha(){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        return layout;
    }

    private LinearLayout criarBaseMatrix(){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        return layout;
    }*/

    private Button criarBotao(String text){
        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText(text);
        return button;
    }



}
