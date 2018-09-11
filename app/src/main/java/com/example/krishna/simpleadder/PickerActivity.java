package com.example.krishna.simpleadder;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class PickerActivity extends AppCompatActivity {

    private final int MAX_TRIALS = 5;

    private NumberPicker np1hundreds, np1tens, np1ones, np2hundreds, np2tens, np2ones;
    private Button add;
    private TextView result;

    private int t1Input1,t1Input2,t2Input1,t2Input2,t3Input1,t3Input2,t4Input1,t4Input2,t5Input1,t5Input2;
    private float t1Time, t2Time, t3Time, t4Time, t5Time;
    private int t1Ticks1, t1Ticks2, t2Ticks1, t2Ticks2, t3Ticks1, t3Ticks2, t4Ticks1, t4Ticks2, t5Ticks1, t5Ticks2;
    private int trialCounter, tick1Counter, tick2Counter;
    private String participantCode, sessionCode, conditionCode;

    float StartTime, EndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        Bundle b = getIntent().getExtras();

        participantCode = b.getString("participantCode");
        sessionCode = b.getString("sessionCode");
        conditionCode = b.getString("conditionCode");

        trialCounter = 0;
        tick1Counter = 0;
        tick2Counter = 0;

        np1hundreds = (NumberPicker)findViewById(R.id.num1hundreds);
        np1tens = (NumberPicker)findViewById(R.id.num1tens);
        np1ones = (NumberPicker)findViewById(R.id.num1ones);
        np2hundreds = (NumberPicker)findViewById(R.id.num2hundreds);
        np2tens = (NumberPicker)findViewById(R.id.num2tens);
        np2ones = (NumberPicker)findViewById(R.id.num2ones);

        np1hundreds.setWrapSelectorWheel(false);
        np1tens.setWrapSelectorWheel(false);
        np1ones.setWrapSelectorWheel(false);
        np2hundreds.setWrapSelectorWheel(false);
        np2tens.setWrapSelectorWheel(false);
        np2ones.setWrapSelectorWheel(false);

        np1hundreds.setMinValue(0);
        np1hundreds.setMaxValue(9);
        np1tens.setMinValue(0);
        np1tens.setMaxValue(9);
        np1ones.setMinValue(0);
        np1ones.setMaxValue(9);
        np2hundreds.setMinValue(0);
        np2hundreds.setMaxValue(9);
        np2tens.setMinValue(0);
        np2tens.setMaxValue(9);
        np2ones.setMinValue(0);
        np2ones.setMaxValue(9);

        add = (Button)findViewById(R.id.btnAdd);
        result = (TextView)findViewById(R.id.tvAnswer);

        StartTime = SystemClock.uptimeMillis();

        np1hundreds.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick1Counter++;
            }
        });

        np1tens.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick1Counter++;
            }
        });

        np1ones.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick1Counter++;
            }
        });

        np2hundreds.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick2Counter++;
            }
        });

        np2tens.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick2Counter++;
            }
        });

        np2ones.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tick2Counter++;
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EndTime = SystemClock.uptimeMillis();

                int number1 = (np1hundreds.getValue() * 100) + (np1tens.getValue() * 10) + np1ones.getValue();
                int number2 = (np2hundreds.getValue() * 100) + (np2tens.getValue() * 10) + np2ones.getValue();
                int sum = number1 + number2;

                result.setText("Answer: " + sum);

                trialCounter++;

                if (trialCounter == 1) {
                    t1Input1 = number1;
                    t1Input2 = number2;
                    t1Ticks1 = tick1Counter;
                    t1Ticks2 = tick2Counter;
                    t1Time = EndTime - StartTime;
                }
                else if (trialCounter == 2) {
                    t2Input1 = number1;
                    t2Input2 = number2;
                    t2Ticks1 = tick1Counter;
                    t2Ticks2 = tick2Counter;
                    t2Time = EndTime - StartTime;
                }
                else if (trialCounter == 3) {
                    t3Input1 = number1;
                    t3Input2 = number2;
                    t3Ticks1 = tick1Counter;
                    t3Ticks2 = tick2Counter;
                    t3Time = EndTime - StartTime;
                }
                else if (trialCounter == 4) {
                    t4Input1 = number1;
                    t4Input2 = number2;
                    t4Ticks1 = tick1Counter;
                    t4Ticks2 = tick2Counter;
                    t4Time = EndTime - StartTime;
                }
                else if(trialCounter == 5){
                    t5Input1 = number1;
                    t5Input2 = number2;
                    t5Ticks1 = tick1Counter;
                    t5Ticks2 = tick2Counter;
                    t5Time = EndTime - StartTime;
                }

                tick1Counter = 0;
                tick2Counter = 0;
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

                    b.putInt("t1Ticks1",t1Ticks1);
                    b.putInt("t2Ticks1",t2Ticks1);
                    b.putInt("t3Ticks1",t3Ticks1);
                    b.putInt("t4Ticks1",t4Ticks1);
                    b.putInt("t5Ticks1",t5Ticks1);
                    b.putInt("t1Ticks2",t1Ticks2);
                    b.putInt("t2Ticks2",t2Ticks2);
                    b.putInt("t3Ticks2",t3Ticks2);
                    b.putInt("t4Ticks2",t4Ticks2);
                    b.putInt("t5Ticks2",t5Ticks2);

                    b.putFloat("t1Time",t1Time);
                    b.putFloat("t2Time",t2Time);
                    b.putFloat("t3Time",t3Time);
                    b.putFloat("t4Time",t4Time);
                    b.putFloat("t5Time",t5Time);

                    b.putString("participantCode", participantCode);
                    b.putString("sessionCode", sessionCode);
                    b.putString("conditionCode", conditionCode);

                    Intent i = new Intent(getApplicationContext(), ResultsPicker.class);
                    i.putExtras(b);
                    startActivity(i);
                    finish();
                }

                np1hundreds.setValue(0);
                np1tens.setValue(0);
                np1ones.setValue(0);
                np2hundreds.setValue(0);
                np2tens.setValue(0);
                np2ones.setValue(0);
            }
        });
    }
}
