package com.example.matrixnnoperator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

public class SomaMatrizesActivity extends AppCompatActivity {

    LinearLayout entrada1, entrada2;
    final LinearLayout containerOperacao= null;
    LinearLayout container;
    //int ordem = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        container = criarContainer(LinearLayout.VERTICAL);

        resetarContainer();





        setContentView(container);
    }


    private LinearLayout criarMatrizResultado(String[][] string,int ordem){
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

    private String[][] pegarMatriz(LinearLayout layout, int ordem){
        String[][] matrizString = new String[ordem][ordem];
        for(int i=0; i<ordem; i++) {
            LinearLayout linha = (LinearLayout) layout.getChildAt(i);
            for(int j=0;j<ordem;j++){
                EditText celula = (EditText) linha.getChildAt(j);
                matrizString[i][j] = celula.getText().toString();
            }
        }
        return matrizString;
    }

    private LinearLayout criarEntradaMatriz(int ordem){
        LinearLayout llMatrix = criarBaseMatrix();


        for(int i=0; i<ordem; i++){
            LinearLayout llLinha = criarLinha();
            for(int j=0; j<ordem; j++){
                llLinha.addView(createEditText("Digite"));
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

    private EditText createEditText(String value){
        EditText editText= new EditText(this);
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.WRAP_CONTENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        );
        editText.setLayoutParams(params);
        editText.setHint(value);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        return editText;
    }

    private LinearLayout criarLinha(){
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
    }

    private LinearLayout criarContainer(int orientation){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(orientation);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT));
        layout.setPadding(10,10,10,10);
        return layout;
    }

    private LinearLayout criarContainerOperacao(int orientation){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(orientation);
        layout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        layout.setPadding(10,10,10,10);
        return layout;
    }

    private Button criarBotao(String text){
        Button button = new Button(this);
        button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText(text);
        return button;
    }

    private String[][] somarMatrizes(String[][] matriz1, String[][] matriz2, int ordem){
        String[][] resultado = new String[ordem][ordem];
        for(int i=0;i<ordem;i++){
            for(int j=0; j<ordem; j++){
                int a = Integer.parseInt(matriz1[i][j]);
                int b = Integer.parseInt(matriz2[i][j]);
                resultado[i][j] = (a+b)+"";
            }
        }
        return resultado;
    }

    private void resetarContainer(){
        final LinearLayout containerOperacao = criarContainerOperacao(LinearLayout.VERTICAL);

        container.addView(createTextView("Soma de Matrizes"));
        container.addView(createTextView("Qual será a ordem da matriz"));
        EditText etOrdem = createEditText("de 0 a 9");
        etOrdem.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.toString().equals("")) {
                    final int ordem = Integer.parseInt(s.toString());
                    if(ordem < 9){
                        //if(container.indexOfChild(entrada1) == -1)
                        containerOperacao.removeView(entrada1);
                        containerOperacao.removeView(entrada2);
                        containerOperacao.addView(createTextView("Matriz1"));
                        entrada1 = criarEntradaMatriz(Integer.parseInt(s.toString()));
                        containerOperacao.addView(entrada1);
                        containerOperacao.addView(createTextView("Matriz2"));
                        entrada2 = criarEntradaMatriz(Integer.parseInt(s.toString()));
                        containerOperacao.addView(entrada2);
                        Button button = criarBotao("Calcular");
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                containerOperacao.removeAllViews();
                                String[][] matriz1 = pegarMatriz(entrada1,ordem);
                                String[][] matriz2 = pegarMatriz(entrada2,ordem);
                                String[][] resultado = somarMatrizes(matriz1,matriz2,ordem);
                                LinearLayout layout = (LinearLayout) criarMatrizResultado(resultado, ordem);
                                containerOperacao.addView(layout);
                                Button button = criarBotao("Tentar Novamente");
                                button.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        container.removeAllViews();
                                        resetarContainer();
                                    }
                                });
                                containerOperacao.addView(button);
                            }
                        });
                        containerOperacao.addView(button);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().equals("")){
                    containerOperacao.removeAllViews();
                }
            }
        });
        container.addView(etOrdem);
        container.addView(containerOperacao);
    }


}
