package com.br.anatamurabiscoitoscaseiros.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.br.anatamurabiscoitoscaseiros.ItemsCartActivity;
import com.br.anatamurabiscoitoscaseiros.R;
import com.br.anatamurabiscoitoscaseiros.databinding.ActivityItemsCartBinding;
import com.br.anatamurabiscoitoscaseiros.databinding.FoodItemBinding;
import com.br.anatamurabiscoitoscaseiros.model.Food;

import java.util.ArrayList;
import java.util.Objects;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>  {

    private final ArrayList<Food> foodList;
    private final Context context;

    public FoodAdapter(ArrayList<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FoodItemBinding listItem;
        listItem = FoodItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new FoodViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

            holder.binding.imgFood.setImageResource(foodList.get(position).getImgFood());
            holder.binding.foodName.setText(foodList.get(position).getFoodName());
            holder.binding.foodDescription.setText(foodList.get(position).getFoodDescription());
            holder.binding.foodPrice.setText(foodList.get(position).getFoodPrice());

            holder.binding.buttonDecrease.setOnClickListener(v -> {

                String amount = (String) holder.binding.amount.getText();

                if(Objects.equals(amount, "3"))
                    holder.binding.amount.setText("2");
                 else if (Objects.equals(amount, "2"))
                    holder.binding.amount.setText("1");


            });

            holder.binding.buttonIncrease.setOnClickListener(v -> {

                String amount = (String) holder.binding.amount.getText();

                if(Objects.equals(amount, "1"))
                   holder.binding.amount.setText("2");
                else if (Objects.equals(amount, "2"))
                    holder.binding.amount.setText("3");
            });

            holder.binding.buttonAdd.setOnClickListener(v -> {

                String name = (String) holder.binding.foodName.getText();
                int amount = Integer.parseInt((String) holder.binding.amount.getText());
                double price = Double.parseDouble((String) holder.binding.foodPrice.getText())
                                * Double.parseDouble(String.valueOf(amount));

                Intent intent = new Intent(context, ItemsCartActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("amount", amount);
                context.startActivity(intent);
            });



    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {

        private final FoodItemBinding binding;

        public FoodViewHolder(FoodItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
