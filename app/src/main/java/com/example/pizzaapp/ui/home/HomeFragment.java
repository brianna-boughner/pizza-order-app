package com.example.pizzaapp.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.pizzaapp.MainActivity;
import com.example.pizzaapp.R;

import java.util.Objects;

public class HomeFragment extends Fragment {

    RadioGroup pizzaSize;
    RadioButton small;
    RadioButton medium;
    RadioButton large;

    RadioGroup pizzaCrust;
    RadioButton thin;
    RadioButton regular;
    RadioButton thick;
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

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);



        return root;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pizzaSize = (RadioGroup) getView().findViewById(R.id.radioGroup);
        small = (RadioButton) getView().findViewById(R.id.small);
        medium = (RadioButton) getView().findViewById(R.id.medium);
        large = (RadioButton) getView().findViewById(R.id.large);

        pizzaCrust = (RadioGroup) getView().findViewById(R.id.radioGroup2);
        thin = (RadioButton) getView().findViewById(R.id.thin);
        regular = (RadioButton) getView().findViewById(R.id.regular);
        thick = (RadioButton) getView().findViewById(R.id.thick);
        priceDisplay = getView().findViewById(R.id.priceDisplay3);

        priceDisplay.setText("Price: " + MainActivity.totalPrice);

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


        if(MainActivity.size == "small"){
            small.setChecked(true);
        }
        else if(MainActivity.size == "medium"){
            medium.setChecked(true);
        }
        else{
            large.setChecked(true);
        }

        if(MainActivity.crust == "thin"){
            thin.setChecked(true);
        }
        else if(MainActivity.crust == "regular"){
            regular.setChecked(true);
        }
        else{
            thick.setChecked(true);
        }

        pizzaSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(MainActivity.size == "large"){
                    MainActivity.totalPrice -= 15.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                }
                else if(MainActivity.size == "medium"){
                    MainActivity.totalPrice -= 12.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                }
                else if(MainActivity.size=="small"){
                    MainActivity.totalPrice -= 9.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                }
                if (checkedId == R.id.small) {
                    MainActivity.size = "small";
                    MainActivity.totalPrice += 9.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                } else  if (checkedId == R.id.medium) {
                    MainActivity.size = "medium";
                    MainActivity.totalPrice += 12.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                } else if (checkedId == R.id.large){
                    MainActivity.size = "large";
                    MainActivity.totalPrice += 15.99;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                }



            }
        });

        pizzaCrust.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.thin) {
                    MainActivity.crust = "thin";
                } else  if (checkedId == R.id.regular) {
                    MainActivity.crust = "regular";
                } else if (checkedId == R.id.thick){
                    MainActivity.crust = "thick";
                }

            }
        });

    }
}