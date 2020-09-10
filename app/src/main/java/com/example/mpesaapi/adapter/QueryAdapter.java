package com.example.mpesaapi.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mpesaapi.R;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.mpesaapi.mpesa.Mpesa.lipaNaMpesaOnlineQuery;
import static com.example.mpesaapi.settings.SandBox.getBusiness_shortcode;

public class QueryAdapter extends RecyclerView.Adapter<QueryAdapter.ViewHolder> {
    ArrayList<Query> queryList;
    private Context context;

    public QueryAdapter(ArrayList<Query> queryList, Context context) {
        this.queryList = queryList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stk_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Query query = queryList.get(position);

        holder.textViewDate.setText(query.getDate());
        holder.textViewPassword.setText(query.getPassword());
        holder.textViewCheckOutId.setText(query.getCheckOut());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    lipaNaMpesaOnlineQuery(getBusiness_shortcode(),query.getPassword(),query.getDate(),query.getCheckOut());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return queryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewDate;
        public TextView textViewPassword;
        public TextView textViewCheckOutId;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDate=itemView.findViewById(R.id.textViewDate);
            textViewPassword=itemView.findViewById(R.id.textViewPassword);
            textViewCheckOutId=itemView.findViewById(R.id.textViewCheckOut);
            linearLayout=itemView.findViewById(R.id.layout_row);
        }
    }
}
