package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText LuckyNumber_EditText;
    TextView LuckyNumber_textView;
    Button LuckyNumber_button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        LuckyNumber_EditText =findViewById(R.id.LuckyNumber_EditText);
        LuckyNumber_textView=findViewById(R.id.LuckyNumber_textView);
        LuckyNumber_button1=findViewById(R.id.LuckyNumber_button1);

        LuckyNumber_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=LuckyNumber_EditText.getText().toString();
                Intent i= new Intent(
                        getApplicationContext(),
                        SecondActivity.class
                );
                // giving infromation from first activity to second activity
                i.putExtra("name",userName);
                startActivity(i);
            }
        });


    }
}