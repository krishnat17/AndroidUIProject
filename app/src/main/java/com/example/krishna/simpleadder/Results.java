package com.example.krishna.simpleadder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results extends Activity implements View.OnClickListener {

    private final float MILLISECONDS_IN_SECOND = 1000;

    private int t1Input1,t1Input2, t2Input1,t2Input2, t3Input1,t3Input2, t4Input1, t4Input2, t5Input1, t5Input2;
    private float t1Time, t2Time, t3Time, t4Time, t5Time;

    private String participantCode, sessionCode, conditionCode;

    private TextView t1Input1Text,t1Input2Text,t2Input1Text,t2Input2Text,t3Input1Text,t3Input2Text,t4Input1Text,t4Input2Text,t5Input1Text,t5Input2Text;
    private TextView t1TimeText,t2TimeText,t3TimeText,t4TimeText,t5TimeText;
    private TextView participantCodeText, sessionCodeText, conditionCodeText;
    Button setup, exit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.results);

        Bundle b = getIntent().getExtras();

        t1Input1 = b.getInt("t1Input1",0);
        t1Input2 = b.getInt("t1Input2",0);
        t2Input1 = b.getInt("t2Input1",0);
        t2Input2 = b.getInt("t2Input2",0);
        t3Input1 = b.getInt("t3Input1",0);
        t3Input2 = b.getInt("t3Input2",0);
        t4Input1 = b.getInt("t4Input1",0);
        t4Input2 = b.getInt("t4Input2",0);
        t5Input1 = b.getInt("t5Input1",0);
        t5Input2 = b.getInt("t5Input2",0);

        t1Time = b.getFloat("t1Time",0);
        t2Time = b.getFloat("t2Time",0);
        t3Time = b.getFloat("t3Time",0);
        t4Time = b.getFloat("t4Time",0);
        t5Time = b.getFloat("t5Time",0);

        participantCode = b.getString("participantCode");
        sessionCode = b.getString("sessionCode");
        conditionCode = b.getString("conditionCode");

        setup = (Button) findViewById(R.id.setup);
        exit = (Button) findViewById(R.id.exit);

        t1Input1Text = (TextView)findViewById(R.id.t1Input1Text);
        t1Input2Text = (TextView)findViewById(R.id.t1Input2Text);
        t2Input1Text = (TextView)findViewById(R.id.t2Input1Text);
        t2Input2Text = (TextView)findViewById(R.id.t2Input2Text);
        t3Input1Text = (TextView)findViewById(R.id.t3Input1Text);
        t3Input2Text = (TextView)findViewById(R.id.t3Input2Text);
        t4Input1Text = (TextView)findViewById(R.id.t4Input1Text);
        t4Input2Text = (TextView)findViewById(R.id.t4Input2Text);
        t5Input1Text = (TextView)findViewById(R.id.t5Input1Text);
        t5Input2Text = (TextView)findViewById(R.id.t5Input2Text);

        t1TimeText = (TextView)findViewById(R.id.t1TimeText);
        t2TimeText = (TextView)findViewById(R.id.t2TimeText);
        t3TimeText = (TextView)findViewById(R.id.t3TimeText);
        t4TimeText = (TextView)findViewById(R.id.t4TimeText);
        t5TimeText = (TextView)findViewById(R.id.t5TimeText);

        participantCodeText = (TextView)findViewById(R.id.participantCodeText);
        sessionCodeText = (TextView)findViewById(R.id.sessionCodeText);
        conditionCodeText = (TextView)findViewById(R.id.conditionCodeText);

        t1Input1Text.setText("" + t1Input1);
        t1Input2Text.setText("" + t1Input2);
        t2Input1Text.setText("" + t2Input1);
        t2Input2Text.setText("" + t2Input2);
        t3Input1Text.setText("" + t3Input1);
        t3Input2Text.setText("" + t3Input2);
        t4Input1Text.setText("" + t4Input1);
        t4Input2Text.setText("" + t4Input2);
        t5Input1Text.setText("" + t5Input1);
        t5Input2Text.setText("" + t5Input2);

        t1TimeText.setText("" + t1Time/MILLISECONDS_IN_SECOND);
        t2TimeText.setText("" + t2Time/MILLISECONDS_IN_SECOND);
        t3TimeText.setText("" + t3Time/MILLISECONDS_IN_SECOND);
        t4TimeText.setText("" + t4Time/MILLISECONDS_IN_SECOND);
        t5TimeText.setText("" + t5Time/MILLISECONDS_IN_SECOND);

        participantCodeText.setText(participantCode);
        sessionCodeText.setText(sessionCode);
        conditionCodeText.setText(conditionCode);
    }

    @Override
    public void onClick(View v) {
        if (v == setup) {
            Intent i = new Intent(getApplicationContext(), Settings.class);
            startActivity(i);
            finish();
        } else if (v == exit) {
            this.finish();
        }
    }
}
