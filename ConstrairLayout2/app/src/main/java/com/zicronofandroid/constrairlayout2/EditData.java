package com.zicronofandroid.constrairlayout2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import java.util.ArrayList;
import java.util.List;

public class EditData extends AppCompatActivity implements View.OnClickListener{
    DatePicker getDate;
    Button confirmBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data);
        getDate = (DatePicker)findViewById(R.id.datePicker2);
        confirmBtn = (Button)findViewById(R.id.button4);
        confirmBtn.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button4:
                tratarDados();
        }
    }
    void tratarDados(){
        int month = getDate.getMonth();
        int day = getDate.getDayOfMonth();
        int year = getDate.getYear();
        //Toast.makeText(getApplicationContext(), "mes: " + month + " dia: " + day + " ano: " + year, Toast.LENGTH_SHORT).show();
        List data = new ArrayList<Integer>();
        data.add(month);
        data.add(day);
        data.add(year);
        //Toast.makeText(getApplicationContext(), "mes: " + data.get(0) + " dia: " + data.get(1) + " ano: " + data.get(2), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putIntegerArrayListExtra("data", (ArrayList<Integer>) data);
        startActivity(intent);
    }
}