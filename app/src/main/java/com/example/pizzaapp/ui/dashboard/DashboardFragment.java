package com.example.pizzaapp.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pizzaapp.MainActivity;
import com.example.pizzaapp.R;
import com.example.pizzaapp.ui.home.HomeViewModel;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    CheckBox pepperoni;
    CheckBox ham;
    CheckBox groundBeef;
    CheckBox sausage;
    TextView priceDisplay;

    ImageView greenpepper_img;
    ImageView tomatoes_img;
    ImageView spinach_img;
    ImageView onions_img;
    ImageView mushrooms_img;
    ImageView sundried_img;
    ImageView pineapple_img;
    ImageView olives_img;
    ImageView pepperoni_img;
    ImageView ham_img;
    ImageView groundBeef_img;
    ImageView sausage_img;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        greenpepper_img = getView().findViewById(R.id.imageView4);
        tomatoes_img = getView().findViewById(R.id.imageView5);
        spinach_img = getView().findViewById(R.id.imageView8);
        onions_img = getView().findViewById(R.id.imageView6);
        mushrooms_img = getView().findViewById(R.id.imageView9);
        sundried_img = getView().findViewById(R.id.imageView12);
        pineapple_img = getView().findViewById(R.id.imageView11);
        olives_img = getView().findViewById(R.id.imageView10);
        pepperoni_img = getView().findViewById(R.id.imageView14);
        ham_img = getView().findViewById(R.id.imageView13);
        groundBeef_img = getView().findViewById(R.id.imageView15);
        sausage_img = getView().findViewById(R.id.imageView16);

        if(!MainActivity.veggies.contains("greenPepper")){
            greenpepper_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("tomato")){
            tomatoes_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("onion")){
            onions_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("spinach")){
            spinach_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("mushroom")){
            mushrooms_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("sundried")){
            sundried_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("olives")){
            olives_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.veggies.contains("pineapple")){
            pineapple_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.meat.contains("ham")){
            ham_img.setVisibility(View.INVISIBLE);
        }
        if(!MainActivity.meat.contains("pepperoni")){
            pepperoni_img.setVisibility(View.INVISIBLE);
        }

        if(!MainActivity.meat.contains("groundBeef")){
            groundBeef_img.setVisibility(View.INVISIBLE);
        }

        if(!MainActivity.meat.contains("sausage")){
            sausage_img.setVisibility(View.INVISIBLE);
        }

        pepperoni = getView().findViewById(R.id.pepperoni);
        ham = getView().findViewById(R.id.ham);
        groundBeef = getView().findViewById(R.id.beef);
        sausage = getView().findViewById(R.id.sausage);
        priceDisplay = getView().findViewById(R.id.priceDisplay2);

        priceDisplay.setText("Price: " + MainActivity.totalPrice);

        if(MainActivity.meat.contains("pepperoni")) {
            pepperoni.setChecked(true);
        }
        if(MainActivity.meat.contains("ham")) {
            ham.setChecked(true);
        }
        if(MainActivity.meat.contains("groundBeef")) {
            groundBeef.setChecked(true);
        }
        if(MainActivity.meat.contains("sausage")) {
            sausage.setChecked(true);
        }


        pepperoni.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(pepperoni.isChecked()){
                    MainActivity.meat.add("pepperoni");
                    pepperoni_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.meat.remove("pepperoni");
                    pepperoni_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        ham.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(ham.isChecked()){
                    MainActivity.meat.add("ham");
                    ham_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.meat.remove("ham");
                    ham_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        groundBeef.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(groundBeef.isChecked()){
                    MainActivity.meat.add("groundBeef");
                    MainActivity.totalPrice += 2.50;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    groundBeef_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.meat.remove("groundBeef");
                    MainActivity.totalPrice -= 2.50;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    groundBeef_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        sausage.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(sausage.isChecked()){
                    MainActivity.meat.add("sausage");
                    MainActivity.totalPrice += 2.50;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    sausage_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.meat.remove("sausage");
                    MainActivity.totalPrice -= 2.50;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    sausage_img.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}