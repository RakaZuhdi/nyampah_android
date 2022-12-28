package com.example.nyampahv3.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

//import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Fragments.MainFragment;
import com.example.nyampahv3.Fragments.ProfileFragment;
import com.example.nyampahv3.Pages.LoginPage;
import com.example.nyampahv3.R;
import com.example.nyampahv3.R.id;
import com.example.nyampahv3.Utils.App;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;


public class MainPage extends AppCompatActivity {

//    private MainPageBinding binding;

    Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        binding = MainPageBinding.inflate(getLayoutInflater());
//        View view = binding.getRoot();
        setContentView(R.layout.main_page_v3_user);

        App.setActivity(this);


        BottomNavigationView bnav = findViewById(id.bottom_navigation_view);
        bnav.setId(id.home);
        loadFragment(new MainFragment());



        bnav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            Fragment fragment = null;
            switch (item.getItemId()) {
                case R.id.home:
                    fragment = new MainFragment();
                    break;
                case R.id.trash:
                    //fragment = new usersFragment();
                    break;
                case R.id.profile:
                    if(!SystemUtil.LoggedIn()) {
                        startActivity(new Intent(App.getContext(), LoginPage.class));
                        return true;
                    }
                    fragment = new ProfileFragment();
                    break;
            }
            if (fragment != null) {
                loadFragment(fragment);
            }
            return true;
        });

        App.setContext(getApplicationContext());

    }
    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, fragment).commit();
    }

}