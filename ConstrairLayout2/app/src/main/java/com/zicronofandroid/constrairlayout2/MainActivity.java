package com.zicronofandroid.constrairlayout2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button editNameBtn, editDateBtn, confirmNameBtn;
    TextView nameView, dataView;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNameBtn = (Button) findViewById(R.id.button);
        editDateBtn = (Button) findViewById(R.id.button2);
        confirmNameBtn = (Button) findViewById(R.id.button3);
        nameEdit = (EditText) findViewById(R.id.editText8);
        nameView = (TextView) findViewById(R.id.textView6);
        dataView = (TextView) findViewById(R.id.textView2);
        hideEditName();
        receberData();
        editNameBtn.setOnClickListener(this);
        editDateBtn.setOnClickListener(this);
        confirmNameBtn.setOnClickListener(this);
    }
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                showEditName();
                break;
            case R.id.button2:
                redirectToEditDate();
                break;
            case R.id.button3:
                reloadName();
        }
    }
    void showEditName(){
        confirmNameBtn.setVisibility(View.VISIBLE);
        nameEdit.setVisibility(View.VISIBLE);
    }
    void redirectToEditDate(){
        startActivity(new Intent(MainActivity.this, EditData.class));
    }
    void reloadName(){
        nameView.setText(nameEdit.getText());
        hideEditName();
    }
    void hideEditName(){
        confirmNameBtn.setVisibility(View.INVISIBLE);
        nameEdit.setVisibility(View.INVISIBLE);
    }
   void receberData(){
       Intent intent = getIntent();
       List data = intent.getIntegerArrayListExtra("data");
       if(data== null) {
           Toast.makeText(getApplicationContext(), "Dados não encontrados", Toast.LENGTH_SHORT).show();
       }else{
          //Toast.makeText(getApplicationContext(), "mes: " + data.get(0) + " dia: " + data.get(1) + " ano: " + data.get(2), Toast.LENGTH_SHORT).show();
          dataView.setText(data.get(1).toString() + "/" + data.get(0).toString() + "/" + data.get(2));
       }
   }

}