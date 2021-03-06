package com.example.tp2q2dynamicl;


import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private LinearLayout myLinearLayout;
    private EditText edText;
    private Button okBtn;
    private ScrollView scrlv;
    LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       initViews();

    }
    private void initViews(){
       this.myLinearLayout=(LinearLayout) findViewById(R.id.myLinearLayout);
       myLinearLayout.setBackgroundColor(Color.DKGRAY);
       edText=new EditText(this);
        myLinearLayout.addView(edText);
        okBtn=new Button(this);
        okBtn.setText("OK");
        myLinearLayout.addView(okBtn);
        scrlv=new ScrollView(this);
         ll= new LinearLayout(this);
         ll.setOrientation(LinearLayout.VERTICAL);
        okBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textview=new TextView(MainActivity.this);
            textview.setText("Bienvenue "+edText.getText());
            textview.setTextColor(Color.WHITE);
            textview.setTextSize(25);
            ll.addView(textview);
        }});
        scrlv.addView(ll);
        myLinearLayout.addView(scrlv);
    }

    @Override
    public void onConfigurationChanged( Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if(newConfig.orientation==Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(getApplicationContext(),"Mode portrait",Toast.LENGTH_SHORT).show();
        } else if(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE){
            Toast.makeText(getApplicationContext(),"Mode paysage",Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("editText",edText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        edText.setText(savedInstanceState.getString("editText"));

    }
}