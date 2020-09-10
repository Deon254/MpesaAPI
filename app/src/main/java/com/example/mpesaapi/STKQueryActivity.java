package com.example.mpesaapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.mpesaapi.adapter.Query;
import com.example.mpesaapi.adapter.QueryAdapter;
import com.example.mpesaapi.database.DatabaseHelper;

import java.util.ArrayList;

public class STKQueryActivity extends AppCompatActivity {
    private ArrayList<Query> queryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter queryAdapter;
    public static DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stkquery);

        databaseHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.rv_stk_query);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        queryAdapter = new QueryAdapter(queryList, this);
        recyclerView.setAdapter(queryAdapter);

        Cursor cursor = databaseHelper.getData("SELECT * FROM stkpush");
        queryList.clear();
        while (cursor.moveToNext()) {
            Query query = new Query();
            int id = cursor.getInt(0);
            String password = cursor.getString(1);
            String dates = cursor.getString(2);
            String checkOutId = cursor.getString(3);

            query.setPassword(password);
            query.setDate(dates);
            query.setCheckOut(checkOutId);

            queryList.add(query);

        }
        queryAdapter.notifyDataSetChanged();
        if (queryList.size() == 0) {
            Toast.makeText(this, "Cart is Empty", Toast.LENGTH_LONG).show();
        }


    }
}
