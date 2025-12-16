package com.example.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private String[] questions = {"Is the Earth flat?","Is water wet?","Is the sun a star?","Can a fish swim?","Is the moon a planet?","Do humans have wings?"};
    private Boolean[] answers = {false,true,true,true,true,false};
    private int score=0;
    private int index = 0;
    TextView ques;
    Button yes,no;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ques=findViewById(R.id.ques);
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        ques.setText(questions[index]);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1){
                   if (answers[index]==true){
                       score++;
                   }
                   index++;
                   if (index<=questions.length-1) {
                       ques.setText(questions[index]);
                   }
                   else{
                       Toast.makeText(MainActivity.this, "Your Score Is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                   }
                   }
                else{
                    Toast.makeText(MainActivity.this, "Please Restart the App to Play Again :)", Toast.LENGTH_SHORT).show();
                }
        }
            }
        );

        no.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  if (index<=questions.length-1){
                      if (answers[index]==false){
                          score++;
                      }
                      index++;
                      if (index<=questions.length-1) {
                          ques.setText(questions[index]);
                      }
                      else{
                          Toast.makeText(MainActivity.this, "Your Score Is: " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();
                      }
                  } else{
                      Toast.makeText(MainActivity.this, "Please Restart the App to Play Again :)", Toast.LENGTH_SHORT).show();
                  }
            }
        });
                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                    return insets;
                });
    }
}