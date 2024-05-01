package com.br.anatamurabiscoitoscaseiros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.br.anatamurabiscoitoscaseiros.adapter.FoodAdapter;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityOrderBinding;
import com.br.anatamurabiscoitoscaseiros.model.Food;

import java.util.ArrayList;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {

    private ActivityOrderBinding binding;
    private FoodAdapter foodAdapter;
    private final ArrayList<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding = ActivityOrderBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();

        setContentView(view);

        RecyclerView recyclerView = binding.recyclerViewFood;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        foodAdapter = new FoodAdapter(foodList, this);
        recyclerView.setAdapter(foodAdapter);
        getFood();

    }

    private void getFood() {

        Food biscoitoBanhado = new Food(
                R.drawable.biscoito_banhado,
                "Banhadinho",
                "Sabores: baunilha, Cacau 50%, Canela, Leite Ninho, Nozes, Amendoim",
                "9.00"
        );
        foodList.add(biscoitoBanhado);

        Food alfajor = new Food(
                R.drawable.alfajor1,
                "Alfajor",
                "Alfajor na versão tradicional Argentina com doce de leite coberto com chocolate",
                "7.00"
        );
        foodList.add(alfajor);

        Food copoNutella = new Food(
                R.drawable.biscoito_copo,
                "Copão",
                "Sabores: Baunilha com Nutella ou Churros com Doce de Leite",
                "14.00"
        );
        foodList.add(copoNutella);

        Food biscoitoSalgado = new Food(
                R.drawable.biscoito_parmesao,
                "Salgado",
                "Sabores: Queijo Parmesão ou Cebola",
                "9.00"
        );
        foodList.add(biscoitoSalgado);

        Food cookieTradicional = new Food(
                R.drawable.cookie_tradicional,
                "Cookies Recheados",
                "Sabores: Oreo, Nutella, Doce de Leite e M&M's",
                "7.00"
        );
        foodList.add(cookieTradicional);

        Food biscoitoPersonalizado = new Food(
                R.drawable.biscoito_personalizado1,
                "Biscoito Personalizado",
                "Sabor: Baunilha",
                "Valor a Consultar"
        );
        foodList.add(biscoitoPersonalizado);

    }
}