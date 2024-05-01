package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.br.anatamurabiscoitoscaseiros.database.DBController;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityLoginBinding;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    protected String email, password;
    protected DBController dbController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       Objects.requireNonNull(getSupportActionBar()).hide();


        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.register.setOnClickListener(v1 -> {

            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);

        });

        binding.buttonEntrar.setOnClickListener(v2 -> {

            setStrings();

            if (!verifyEditText())

                Toast.makeText(this, "Os campos devem estar preenchidos", Toast.LENGTH_SHORT).show();

            else {

                dbController = new DBController(getBaseContext());
                boolean check = dbController.loadDataByCode(email,password);

                if (check) {

                    Toast.makeText(this, "Login feito com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else
                    Toast.makeText(this, "Falha ao efetuar login", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private boolean verifyEditText() {

        boolean verify = true;

        if (TextUtils.isEmpty(email)) {

            binding.editEmail.setError("O campo Email deve estar preeenchido");
            verify = false;

        } else if (TextUtils.isEmpty(password)) {

            binding.editPassword.setError("O campo Senha deve estar preeenchido");
            verify = false;

        }

        return verify;
    }

    private void setStrings() {

        email = binding.editEmail.getText().toString().trim();
        password = binding.editPassword.getText().toString().trim();

    }
}