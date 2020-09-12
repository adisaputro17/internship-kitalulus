package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class fragment_menu extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<String> nameList;
    private ArrayList<Integer> imageList;
    private ArrayList<String> priceList;

    private String[] name = {"Americano","Ice Latte","Chocholate","Cappucino"};
    private String[] price = {"Rp. 5.000","Rp. 7.500","Rp. 6.000","Rp. 8.000"};
    private int[] image = {R.drawable.americano, R.drawable.icelatte, R.drawable.chocholate, R.drawable.cappucino};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mMenu_layout = inflater.inflate(R.layout.layout_menu,container,false);

        final fragment_home HomeFragment = new fragment_home();
        TextView mBackbutton = mMenu_layout.findViewById(R.id.back_button);
        mBackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(HomeFragment);
            }
        });

        nameList = new ArrayList<>();
        priceList = new ArrayList<>();
        imageList = new ArrayList<>();

        recyclerView = mMenu_layout.findViewById(R.id.list_menu);
        ListItem();

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(nameList,imageList,priceList);

        recyclerView.setAdapter(adapter);

        return mMenu_layout;
    }

    private void setFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.main_menu, fragment);
        ft.commit();
    }

    private void ListItem() {
        for (int i=0; i<name.length; i++){
            nameList.add(name[i]);
            priceList.add(price[i]);
            imageList.add(image[i]);
        }
    }
}
