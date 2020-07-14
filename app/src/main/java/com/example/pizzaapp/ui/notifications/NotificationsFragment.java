package com.example.pizzaapp.ui.notifications;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.pizzaapp.MainActivity;
import com.example.pizzaapp.R;

import org.w3c.dom.Text;

public class NotificationsFragment extends Fragment {

    Button order;

    CheckBox greenPepper;
    CheckBox tomato;
    CheckBox onion;
    CheckBox spinach;
    CheckBox mushroom;
    CheckBox sundried;
    CheckBox olives;
    CheckBox pineapple;
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

    ImageView orderPage;

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        return root;
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        order = getView().findViewById(R.id.orderButton);

        greenPepper = getView().findViewById(R.id.greenPepper);
        tomato = getView().findViewById(R.id.tomato);
        onion = getView().findViewById(R.id.onion);
        spinach = getView().findViewById(R.id.spinach);
        mushroom = getView().findViewById(R.id.mushroom);
        sundried = getView().findViewById(R.id.sundried);
        olives = getView().findViewById(R.id.olive);
        pineapple = getView().findViewById(R.id.pineapple);
        priceDisplay = getView().findViewById(R.id.priceDisplay1);

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

        orderPage = getView().findViewById(R.id.orderpage);

        priceDisplay.setText("Price: " + MainActivity.totalPrice);

        // Set everything to default depending on what toppings are added

        orderPage.setVisibility(View.INVISIBLE);

        if(MainActivity.veggies.contains("greenPepper")) {
            greenPepper.setChecked(true);
        }
        if(MainActivity.veggies.contains("tomato")) {
            tomato.setChecked(true);
        }
        if(MainActivity.veggies.contains("onion")) {
            onion.setChecked(true);
        }
        if(MainActivity.veggies.contains("spinach")) {
            spinach.setChecked(true);
        }
        if(MainActivity.veggies.contains("mushroom")) {
            mushroom.setChecked(true);
        }
        if(MainActivity.veggies.contains("sundried")) {
            sundried.setChecked(true);
        }
        if(MainActivity.veggies.contains("olives")) {
            olives.setChecked(true);
        }
        if(MainActivity.veggies.contains("pineapple")) {
            pineapple.setChecked(true);
        }

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

        greenPepper.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(greenPepper.isChecked()){
                    MainActivity.veggies.add("greenPepper");
                    greenpepper_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("greenPepper");
                    greenpepper_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        tomato.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(tomato.isChecked()){
                    MainActivity.veggies.add("tomato");
                    tomatoes_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("tomato");
                    tomatoes_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        onion.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(onion.isChecked()){
                    MainActivity.veggies.add("onion");
                    onions_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("onion");
                    onions_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        spinach.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(spinach.isChecked()){
                    MainActivity.veggies.add("spinach");
                    spinach_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("spinach");
                    spinach_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        mushroom.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(mushroom.isChecked()){
                    MainActivity.veggies.add("mushroom");
                    MainActivity.totalPrice += 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    mushrooms_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("mushroom");
                    MainActivity.totalPrice -= 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    mushrooms_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        sundried.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(sundried.isChecked()){
                    MainActivity.veggies.add("sundried");
                    MainActivity.totalPrice += 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    sundried_img.setVisibility(View.VISIBLE);

                }
                else{
                    MainActivity.veggies.remove("sundried");
                    MainActivity.totalPrice -= 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    sundried_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        olives.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(olives.isChecked()){
                    MainActivity.veggies.add("olives");
                    MainActivity.totalPrice += 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    olives_img.setVisibility(View.VISIBLE);

                }
                else{
                    MainActivity.veggies.remove("olives");
                    MainActivity.totalPrice -= 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    olives_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        pineapple.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(pineapple.isChecked()){
                    MainActivity.veggies.add("pineapple");
                    MainActivity.totalPrice += 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    pineapple_img.setVisibility(View.VISIBLE);
                }
                else{
                    MainActivity.veggies.remove("pineapple");
                    MainActivity.totalPrice -= 1.25;
                    MainActivity.totalPrice = Math.floor(MainActivity.totalPrice * 100) / 100;
                    priceDisplay.setText("Price: " + MainActivity.totalPrice);
                    pineapple_img.setVisibility(View.INVISIBLE);
                }
            }
        });
        order.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                order.setVisibility(View.GONE);
                orderPage.setVisibility(View.VISIBLE);
            }
        });

    }
}