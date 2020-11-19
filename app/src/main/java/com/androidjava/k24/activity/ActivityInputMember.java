package com.androidjava.k24.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import com.androidjava.k24.R;
import com.androidjava.k24.databasehelper.SqliteHelper;

public class ActivityInputMember extends AppCompatActivity {

    private EditText Username, Password, Nama, TanggalLahir, Alamat;
    private RadioButton MALE, FAMALE;

    private String setUserName, setPassword, setNama, setTanggalLahir, setAlamat, setJenisKelamin;

    private SqliteHelper sqliteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_member);
        Button simpan = findViewById(R.id.save);
        Nama = findViewById(R.id.nama);
        TanggalLahir = findViewById(R.id.tgl_lahir);
        MALE = findViewById(R.id.male);
        FAMALE = findViewById(R.id.famale);
        Alamat = findViewById(R.id.alamat);
        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);

        sqliteHelper = new SqliteHelper(getBaseContext());

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                saveData();
                Toast.makeText(getApplicationContext(),"Data Berhasil Disimpan", Toast.LENGTH_SHORT).show();
                clearData();
            }
        });

        Button viewData = findViewById(R.id.readData);
        viewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityInputMember.this, ActivityViewDataMember.class));
            }
        });
    }

    private void setData(){
        setUserName = Username.getText().toString();
        setNama = Nama.getText().toString();
        setPassword = Password.getText().toString();
        if(MALE.isChecked()){
            setJenisKelamin = MALE.getText().toString();
        }else if (FAMALE.isChecked()){
            setJenisKelamin = FAMALE.getText().toString();
        }
        setTanggalLahir = TanggalLahir.getText().toString();
        setAlamat = Alamat.getText().toString();
    }

    private void saveData(){
        SQLiteDatabase create = sqliteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SqliteHelper.Nama, setNama);
        values.put(SqliteHelper.Password, setUserName);
        values.put(SqliteHelper.Username, setPassword);
        values.put(SqliteHelper.JenisKelamin, setJenisKelamin);
        values.put(SqliteHelper.TanggalLahir, setTanggalLahir);
        values.put(SqliteHelper.Alamat, setAlamat);


        create.insert(SqliteHelper.TABLE_MEMBER, null, values);
    }

    private void clearData(){
        Username.setText("");
        Password.setText("");
        Nama.setText("");
        TanggalLahir.setText("");
        Alamat.setText("");
    }
}