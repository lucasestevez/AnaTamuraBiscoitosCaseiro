package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.br.anatamurabiscoitoscaseiros.databinding.ActivityRegisterBinding;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityThankYouBinding;

import java.util.Objects;

public class ThankYouActivity extends AppCompatActivity {

    private ActivityThankYouBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityThankYouBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.buttonReturn.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

        });
    }
}