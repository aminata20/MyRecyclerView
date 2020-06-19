package com.example.myrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.myrecyclerview.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ActivityMainBinding mainBinding;
    private RecyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainBinding.myRecyclerView.setHasFixedSize(true);
        adapter =  new RecyclerAdapter(this,prepareUser());
        mainBinding.myRecyclerView.setAdapter(adapter);
    }

    private List<User> prepareUser()
    {
        List<String> names = Arrays.asList(getResources().getStringArray(R.array.names));
        List<String> emails = Arrays.asList(getResources().getStringArray(R.array.emails));
        int[] imageId = {R.drawable.photo_1,R.drawable.photo_2,R.drawable.photo_3,
            R.drawable.photo_4,R.drawable.photo_5,R.drawable.photo_6};
        List<User> Names = new ArrayList<>();

        int count = 0;

        for(String name : names)
        {
            Names.add(new User(name,emails.get(count),imageId[count]));
            count++;
        }
        return Names;


    }


}