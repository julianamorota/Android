package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * método chamado quando o botão é clicado. Intent que redireciona para o email com os dados
     * do pedido
     * @param view View
     */
    public void submitOrder(View view){
        CheckBox chantilyCheckBox =  (CheckBox) findViewById(R.id.checkbox_chantilly);
        boolean hasChantilly = chantilyCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText name = (EditText) findViewById(R.id.edittext_name);
        String nomeString = name.getText().toString();

        int price = calculatePrice(hasChantilly, hasChocolate);
        String priceMessage = createOrderSummary(price, hasChantilly, hasChocolate, nomeString);

        //INTENT
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto: "));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JustJava pedido para " + nomeString);
        emailIntent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if(emailIntent.resolveActivity(getPackageManager()) != null){
            startActivity(emailIntent);
        }

    }

    /**
     * formata a mensagem de resumo do pedido
     * @param price preço
     * @param hasChantilly true or false chantilly
     * @param hasChocolate true or false chocolate
     * @param nome nome
     * @return String resumo do pedido
     */
    public String createOrderSummary(int price, boolean hasChantilly, boolean hasChocolate, String nome) {
        String priceMessage = "Nome: " + nome;
        priceMessage += "\nAdd chantilly? " + hasChantilly;
        priceMessage += "\nAdd chocolate? " + hasChocolate;
        priceMessage += "\nQtd: " + quantity;
        priceMessage += "\nTotal: R$" + price;
        priceMessage += "\n" + getString(R.string.obrigado);
        return priceMessage;
    }

    /**
     * Calcula o preço do pedido levando em conta os ingredientes
     * @param hasChantilly
     * @param hasChocolate
     * @return preço int
     */
    private int calculatePrice(boolean hasChantilly, boolean hasChocolate) {
        int price = quantity * 5;
        if(hasChantilly){
            price += (1 * quantity);
        }
        if (hasChocolate){
            price += (2 * quantity);
        }
        return price;
    }

    /**
     * mostra o valor da quantidade
     * @param number valor
     */
    private void display(int number){
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    /**
     * incrementa quantidade (até 100)
     * @param view View
     */
    public void increment(View view){
        if(quantity < 100){
            quantity++;
            display(quantity);
        }
        else{
            Toast.makeText(this, "Você não pode pedir mais de 100 cafés", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * decrementa quantidade (até 1)
     * @param view View
     */
    public void decrement(View view){
        if(quantity>1){
            quantity--;
            display(quantity);
        }
        else{
            Toast.makeText(this, "Você não pode pedir menos de 1 café", Toast.LENGTH_LONG).show();
        }
    }
}
