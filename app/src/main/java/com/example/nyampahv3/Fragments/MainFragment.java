package com.example.nyampahv3.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nyampahv3.Apis.UserApi;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.R;
import com.example.nyampahv3.Utils.SystemUtil;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView poinText;
    TextView trashDeposit;
    private Gson gson = new Gson();

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        // Inflate the layout for this fragment
//        binding = MainPageBinding.inflate(inflater, container, false);
//        View view = binding.getRoot();
//        return view;
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        poinText = view.findViewById(R.id.text_numerical_points);
        trashDeposit = view.findViewById(R.id.text_numerical_trash_deposited);
        ImageView dp = view.findViewById(R.id.imageView5);

        User currentUser = null;
        User user_data = SystemUtil.getCurrentLoggedInUserDataSharedPref();

        if(user_data == null) currentUser = User.defaultInstance();
        else {
            try {
                currentUser = UserApi.TokenLogin();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        poinText.setText(currentUser.point+"");
        trashDeposit.setText(currentUser.total_trash_weight + " KG");

        return view;
    }
}