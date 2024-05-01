package com.br.anatamurabiscoitoscaseiros;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityItemsCartBinding;
import java.util.Objects;

public class ItemsCartActivity extends AppCompatActivity {

    private ActivityItemsCartBinding binding;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityItemsCartBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        String name = getIntent().getStringExtra("name");
        int amount = getIntent().getIntExtra("amount", 0);
        double price = getIntent().getDoubleExtra("price", 0.00);

        binding.order.setText(name+"\nQuantidde: "+amount+"\n"+price);

        binding.buttonGoToRegisterOrder.setOnClickListener(v2 -> {

            Intent intent = new Intent(this, PaymentActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("amount", amount);
            intent.putExtra("price", price);
            startActivity(intent);
            finish();
        });

    }

}