package com.example.loginapp;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.PrimitiveIterator;

public class ProductAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<Product> listProduct;

    public ProductAdapter(Activity activity, List<Product> listProduct) {
        this.activity = activity;
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView   = activity.getLayoutInflater().inflate(R.layout.product_item,parent,false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder productHolder =(ProductHolder) holder;
        Product model = listProduct.get(position);
        productHolder.ivCover.setImageResource(model.getImage());
        productHolder.tvName.setText(model.getName());
        productHolder.tvPrice.setText(model.getPrice());

    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    private class ProductHolder extends RecyclerView.ViewHolder{
        ImageView ivCover;
        TextView tvName;
        TextView tvPrice;
        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            ivCover =itemView.findViewById(R.id.imgCover);
            tvName =itemView.findViewById(R.id.tvName);
            tvPrice =itemView.findViewById(R.id.tvPrice);
        }
    }
}
