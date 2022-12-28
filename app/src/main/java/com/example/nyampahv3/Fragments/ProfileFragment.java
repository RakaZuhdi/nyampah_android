package com.example.nyampahv3.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.Pages.LoginPage;
import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.App;
import com.example.nyampahv3.Utils.SystemUtil;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile2, container, false);
        Button logout = view.findViewById(R.id.logoutBtn);
        Button changePwd = view.findViewById(R.id.changePwdBtn);
        TextView fullname = view.findViewById(R.id.fullname);
        TextView email = view.findViewById(R.id.email);
        TextView trashDeposit = view.findViewById(R.id.trashDesposiTxt);
        TextView totalPickup = view.findViewById(R.id.totalPickupTxt);

        
        User currentUser = SystemUtil.getCurrentLoggedInUserDataSharedPref(); 

        fullname.setText(currentUser.fullname);
        email.setText(currentUser.email);
        trashDeposit.setText(currentUser.total_trash_weight+"");


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SystemUtil.clearSharedPreference("login");
                startActivity(new Intent(App.getContext(), LoginPage.class));
                return;
            }
        });


        return view;


    }
}