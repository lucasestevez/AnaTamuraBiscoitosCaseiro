package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.anatamurabiscoitoscaseiros.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        setContentView(view);

        binding.buttonRegisterOrder.setOnClickListener(v2 -> {

            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            finish();
        });

        binding.buttonContactUS.setOnClickListener(v3 -> {

            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            finish();
        });


    }
}