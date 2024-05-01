package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.br.anatamurabiscoitoscaseiros.database.DBController;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityRegisterBinding;

import java.util.Objects;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;
    private DBController dbController;
    protected String name, email, phoneNumber,dateBirth, password, confirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        binding.buttonRegister.setOnClickListener(v -> {

            setStrings();

           if (!verifyEditText())

               Toast.makeText(getApplicationContext(), "Os campos devem estar preenchidos corretamente",
                                Toast.LENGTH_SHORT).show();
           else {

               dbController = new DBController(getBaseContext());

               boolean response = dbController.save(name, email, dateBirth, phoneNumber, password);

               if (!response)
                Toast.makeText(getApplicationContext(), "Erro ao cadastrar",
                                    Toast.LENGTH_LONG).show();
                else {

                   Toast.makeText(getApplicationContext(), "Cadastro efetuado com sucesso!",
                           Toast.LENGTH_LONG).show();

                   Intent intent = new Intent(this, LoginActivity.class);
                   startActivity(intent);
                   finish();
               }


           }

        });


    }

    private boolean verifyEditText() {

        boolean verify = true;

        if (TextUtils.isEmpty(name)) {

            binding.editName.setError("O campo Nome deve estar preenchido");
            verify = false;

        } else if (TextUtils.isEmpty(email)) {

            binding.editEmail.setError("O campo Email deve estar preenchido");
            verify = false;

        } else if (TextUtils.isEmpty(dateBirth)) {

            binding.editDateBirth.setError("O campo Data de Nascimento deve estar preenchido");
            verify = false;

        } else if (TextUtils.isEmpty(phoneNumber)) {

            binding.editCelPhone.setError("O campo Celular deve estar preenchido");
            verify = false;

        } else if (TextUtils.isEmpty(password)) {

            binding.editPassword.setError("O campo Senha deve estar preenchido");
            verify = false;

        } else if (TextUtils.isEmpty(confirmPassword)) {

            binding.editVerifyPassword.setError("O campo Confirmação de Senha deve estar preenchido");
            verify = false;

        } else if (!password.equals(confirmPassword)) {

            binding.editVerifyPassword.setError("A Senha é diferente de Confirmação de Senha");
            verify = false;
        }

        return verify;
    }

    private void setStrings() {

        name = binding.editName.getText().toString().trim();
        email = binding.editEmail.getText().toString().trim();
        dateBirth = binding.editDateBirth.getText().toString().trim();
        phoneNumber = binding.editCelPhone.getText().toString().trim();
        password = binding.editPassword.getText().toString().trim();
        confirmPassword = binding.editVerifyPassword.getText().toString().trim();
    }
}