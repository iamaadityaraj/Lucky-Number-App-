package com.example.luckynumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView LuckyNumber_textView_1 , LuckyNumber_textView_2;
    Button LuckyNumber_button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        LuckyNumber_textView_1=findViewById(R.id.LuckyNumber_textView_1);
        LuckyNumber_textView_2=findViewById(R.id.LuckyNumber_textView_2);
        LuckyNumber_button2=findViewById(R.id.LuckyNumber_button2);


        // this process define that how we can take data from main activity
        Intent i =getIntent();
        String userName= i.getStringExtra("name");
        int random_num= GenerateRandomNumber();
        LuckyNumber_textView_2.setText(" "+ random_num);
        LuckyNumber_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(userName,random_num);
            }
        });

    }

    // generate Random varaibles
    public int GenerateRandomNumber(){
        Random randomnum=new Random();
        int upper_limit=1000;
        int RandomNumberGenerated= randomnum.nextInt(upper_limit);
        return RandomNumberGenerated;
    }
    public void shareData(String username,int randomnumber){
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_SUBJECT,username + "got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,"your Lucky number is "+randomnumber);
        startActivity(Intent.createChooser(i,"choose a platform"));

    }

}