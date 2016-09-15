package com.example.android.justjava;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {

    private int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * método chamado quando o botão é clicado
     * @param view View
     */
    public void submitOrder(View view){
        String priceMessage = "Total R$" + quantity * 5 + "\nObrigado!";
        displayMessage(priceMessage);
    }

    /**
     * incrementa quantidade
     * @param view View
     */
    public void increment(View view){
        quantity++;
        display(quantity);
    }

    /**
     * decrementa quantidade
     * @param view View
     */
    public void decrement(View view){
        if(quantity>0){
            quantity--;
            display(quantity);
        }
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
     * mostra o preço
     * @param number valor
     */
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * mostra a mensagem com o total
     * @param message String
     */
    private void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }


}
