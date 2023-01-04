package com.example.nyampahv3;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nyampahv3.api.UserApi;
import com.example.nyampahv3.util.AlertUtil;

import java.util.ArrayList;

public class RedeemAdapter extends RecyclerView.Adapter<RedeemAdapter.MyViewHolder> {
    private ArrayList<Redeem> redeemList;

    public RedeemAdapter(ArrayList<Redeem> redeemList){
        this.redeemList = redeemList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private Button redeemButton;

        public MyViewHolder(final View view){
            super(view);

            redeemButton = view.findViewById(R.id.list_item_redeem_button);
            redeemButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String textValue = String.valueOf(redeemButton.getText());

                    if(textValue.equals("Redeem 60.000 points")){
                        try {
                            UserApi.RedeemPoint(60000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 60000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(textValue.equals("Redeem 120.000 points")){
                        Log.d("Value", textValue);
                        try {
                            UserApi.RedeemPoint(120000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 120000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(textValue.equals("Redeem 180.000 points")){
                        Log.d("Value", textValue);
                        try {
                            UserApi.RedeemPoint(180000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 180000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(textValue.equals("Redeem 240.000 points")){
                        Log.d("Value", textValue);
                        try {
                            UserApi.RedeemPoint(240000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 240000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(textValue.equals("Redeem 300.000 points")){
                        Log.d("Value", textValue);
                        try {
                            UserApi.RedeemPoint(300000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 300000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }else if(textValue.equals("Redeem 360.000 points")){
                        Log.d("Value", textValue);
                        try {
                            UserApi.RedeemPoint(360000);
                            Log.d("Value", textValue);
                            AlertUtil.alert("Congrats", "You have redeemed 360000 point");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }



    @NonNull
    @Override
    public RedeemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.redeem_list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RedeemAdapter.MyViewHolder holder, int position) {
        String name = redeemList.get(position).getUsername();
        holder.redeemButton.setText("Redeem " + name + " points");
    }

    @Override
    public int getItemCount() {
        return redeemList.size();
    }
}
