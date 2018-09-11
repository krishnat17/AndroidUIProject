package com.example.krishna.simpleadder;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int MAX_TRIALS = 5;

    private EditText num1, num2;
    private Button add;
    private TextView result;

    private int t1Input1,t1Input2,t2Input1,t2Input2,t3Input1,t3Input2,t4Input1,t4Input2,t5Input1,t5Input2;
    private float t1Time, t2Time, t3Time, t4Time, t5Time;
    private int trialCounter;
    private String participantCode, sessionCode, conditionCode;

    float StartTime, EndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b = getIntent().getExtras();

        participantCode = b.getString("participantCode");
        sessionCode = b.getString("sessionCode");
        conditionCode = b.getString("conditionCode");

        trialCounter = 0;

        num1 = (EditText)findViewById(R.id.etNum1);
        num2 = (EditText)findViewById(R.id.etNum2);

        add = (Button)findViewById(R.id.btnAdd);
        result = (TextView)findViewById(R.id.tvAnswer);

        StartTime = SystemClock.uptimeMillis();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (num1.length() <= 0 || num2.length() <= 0) {
                    result.setText("Enter two numbers");
                }
                else {
                    EndTime = SystemClock.uptimeMillis();

                    int number1 = Integer.parseInt(num1.getText().toString());
                    int number2 = Integer.parseInt(num2.getText().toString());
                    int sum = number1 + number2;

                    result.setText("Answer: " + sum);

                    num1.getText().clear();
                    num2.getText().clear();

                    trialCounter++;

                    if (trialCounter == 1) {
                        t1Input1 = number1;
                        t1Input2 = number2;
                        t1Time = EndTime - StartTime;
                    }
                    else if (trialCounter == 2) {
                        t2Input1 = number1;
                        t2Input2 = number2;
                        t2Time = EndTime - StartTime;
                    }
                    else if (trialCounter == 3) {
                        t3Input1 = number1;
                        t3Input2 = number2;
                        t3Time = EndTime - StartTime;
                    }
                    else if (trialCounter == 4) {
                        t4Input1 = number1;
                        t4Input2 = number2;
                        t4Time = EndTime - StartTime;
                    }
                    else if(trialCounter == 5){
                        t5Input1 = number1;
                        t5Input2 = number2;
                        t5Time = EndTime - StartTime;
                    }

                    StartTime = SystemClock.uptimeMillis();

                    if (trialCounter >= MAX_TRIALS) {
                        Bundle b = new Bundle();

                        b.putInt("t1Input1",t1Input1);
                        b.putInt("t1Input2",t1Input2);
                        b.putInt("t2Input1",t2Input1);
                        b.putInt("t2Input2",t2Input2);
                        b.putInt("t3Input1",t3Input1);
                        b.putInt("t3Input2",t3Input2);
                        b.putInt("t4Input1",t4Input1);
                        b.putInt("t4Input2",t4Input2);
                        b.putInt("t5Input1",t5Input1);
                        b.putInt("t5Input2",t5Input2);

                        b.putFloat("t1Time",t1Time);
                        b.putFloat("t2Time",t2Time);
                        b.putFloat("t3Time",t3Time);
                        b.putFloat("t4Time",t4Time);
                        b.putFloat("t5Time",t5Time);

                        b.putString("participantCode", participantCode);
                        b.putString("sessionCode", sessionCode);
                        b.putString("conditionCode", conditionCode);

                        Intent i = new Intent(getApplicationContext(), Results.class);
                        i.putExtras(b);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }
}
