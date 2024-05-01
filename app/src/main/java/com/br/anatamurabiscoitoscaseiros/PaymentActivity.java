package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.br.anatamurabiscoitoscaseiros.database.DBController;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityPaymentBinding;
import java.util.Objects;

public class PaymentActivity extends AppCompatActivity {

    private ActivityPaymentBinding binding;
    protected String address, complement;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityPaymentBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        String name = getIntent().getStringExtra("name");
        int amount = getIntent().getIntExtra("amount", 0);
        double price = getIntent().getDoubleExtra("price", 0.00);

        binding.txtTotal.setText(name+"\nQuantidde: "+amount+"\n"+price);

        binding.buttonConfirmPayment.setOnClickListener( v -> {

            setAll();

             if (!verify())

                 Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

             else {

                 Toast.makeText(this, "Registro realizado com sucesso", Toast.LENGTH_SHORT).show();

                 Intent intent = new Intent(this, ThankYouActivity.class);
                 startActivity(intent);
                 finish();

            }
        });

    }

    protected boolean verify() {

        boolean bool = true;

        if (address.isEmpty()) {

            binding.address.setError("O campo endereço tem que estar preeenchido");
            bool = false;

        } else if (complement.isEmpty()) {

            binding.complement.setError("O campo complemento tem que estar preeenchido");
            bool = false;

        } else if (!binding.buttonCreditCard.isChecked() && !binding.buttonMoney.isChecked() &&
                !binding.buttonPix.isChecked()) {

            binding.buttonPix.setError("Escolha uma forma de pagamento");
            binding.buttonMoney.setError("Escolha uma forma de pagamento");
            binding.buttonCreditCard.setError("Escolha uma forma de pagamento");
            bool = false;
        }

        return bool;
    }

    protected void setAll() {

        address = binding.address.getText().toString();
        complement = binding.complement.getText().toString();

    }
}