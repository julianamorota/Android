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
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        displayMessage(priceMessage);
    }

    /**
     * formata a mensagem de resumo do pedido
     * @param price preço
     * @return resumo do pedido
     */
    public String createOrderSummary(int price) {
        String priceMessage = "Nome: Juliana Sayuri";
        priceMessage += "\nQtd: " + quantity;
        priceMessage += "\nTotal: R$" + price;
        priceMessage += "\nObrigado.";

        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        return quantity * 5;
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
     * mostra a mensagem com o total
     * @param message String
     */
    private void displayMessage(String message){
        TextView pedidoTextView = (TextView) findViewById(R.id.pedido_text_view);
        pedidoTextView.setText(message);
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
}
