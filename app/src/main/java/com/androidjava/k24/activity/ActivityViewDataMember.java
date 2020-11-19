package com.androidjava.k24.activity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidjava.k24.R;
import com.androidjava.k24.adapter.RecyclerViewAdapter;
import com.androidjava.k24.databasehelper.SqliteHelper;
import com.androidjava.k24.entity.DataFilter;

import java.util.ArrayList;


public class ActivityViewDataMember extends AppCompatActivity {
    private SqliteHelper sqliteHelper;

    private RecyclerViewAdapter adapter;
    private ArrayList<DataFilter> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data_member);
        dataList = new ArrayList<>();
        sqliteHelper = new SqliteHelper (getBaseContext());
        RecyclerView recyclerView = findViewById(R.id.recycler);
        getData();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new RecyclerViewAdapter(dataList);

        recyclerView.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.line));
        recyclerView.addItemDecoration(itemDecoration);
    }

    @SuppressLint("Recycle")
    protected void getData(){
        SQLiteDatabase ReadData = sqliteHelper.getReadableDatabase();
        Cursor cursor = ReadData.rawQuery("SELECT * FROM "+ SqliteHelper.TABLE_MEMBER,null);
        cursor.moveToFirst();
        for(int count=0; count < cursor.getCount(); count++){
            cursor.moveToPosition(count);
            dataList.add(new DataFilter(cursor.getString(0),
                    cursor.getString(1), cursor.getString(2)));
        }
    }

}