package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.br.anatamurabiscoitoscaseiros.databinding.ActivityContactBinding;

import java.util.Objects;

public class ContactActivity extends AppCompatActivity {

    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityContactBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.buttonWhatsapp.setOnClickListener(v -> {

            Uri whatsapp = Uri.parse("https://api.whatsapp.com/send?phone=5511994085614");
            Intent whatsappIntent  = new Intent(Intent.ACTION_VIEW, whatsapp);
            startActivity(whatsappIntent);
        });

        binding.buttonInstagram.setOnClickListener(v -> {

            Uri instagram = Uri.parse("https://instagram.com/anatamura_biscoitoscaseiros");
            Intent instagramIntent  = new Intent(Intent.ACTION_VIEW, instagram);
            startActivity(instagramIntent);

        });

        binding.btnReturn.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}