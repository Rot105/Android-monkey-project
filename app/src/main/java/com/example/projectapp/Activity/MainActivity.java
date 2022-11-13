package com.example.projectapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.projectapp.Adapter.CategoryAdapter;
import com.example.projectapp.Adapter.RecommendedAdapter;
import com.example.projectapp.Domain.CategoryDomain;
import com.example.projectapp.Domain.GunDomain;
import com.example.projectapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<GunDomain> gunlist = new ArrayList<>();
        gunlist.add(new GunDomain("Desert Eagle", "deserteagle", "es una pistola semiautomatica de grueso calibre americana", 3449.99,5, 20));
        gunlist.add(new GunDomain("Mauser L96", "franco", "El Mauser L96 es un fusil de cerrojo de largo alcance diseñado para uso militar. ", 8349.99,4, 18));
        gunlist.add(new GunDomain("HK 417D", "asalto", "HK 417D es un fusil de asalto de 7,62 mm desarrollado por Heckler & Koch.", 2199.99,3, 16));

        adapter2 = new RecommendedAdapter(gunlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pistolas","pistola"));
        categoryList.add(new CategoryDomain("Sniper","francotirador"));
        categoryList.add(new CategoryDomain("Rifles","rifleAsalto"));
        categoryList.add(new CategoryDomain("Granadas","arrojadizos"));
        categoryList.add(new CategoryDomain("Munición","municiones"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}