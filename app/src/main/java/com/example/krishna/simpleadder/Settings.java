package com.example.krishna.simpleadder;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends Activity implements View.OnClickListener {

    String[] participantCode = {"P01", "P01", "P02", "P03", "P04", "P05", "P06", "P07", "P08", "P09", "P10"};
    String[] sessionCode = {"S01", "S01", "S02", "S03", "S04", "S05", "S06", "S07", "S08", "S09", "S10"};
    String[] conditionCode = {"Number Pad", "Number Pad", "Handwriting", "Number Picker"};

    SharedPreferences sp;
    SharedPreferences.Editor spe;
    Button ok, save, exit;

    private Spinner spinParticipantCode, spinSessionCode, spinConditionCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.settings);

        sp = this.getPreferences(MODE_PRIVATE);

        participantCode[0] = sp.getString("participantCode", participantCode[0]);
        sessionCode[0] = sp.getString("sessionCode", sessionCode[0]);
        conditionCode[0] = sp.getString("conditionCode", conditionCode[0]);

        spinParticipantCode = (Spinner)findViewById(R.id.spinParticipantCode);
        spinSessionCode = (Spinner)findViewById(R.id.spinSessionCode);
        spinConditionCode = (Spinner)findViewById(R.id.spinConditionCode);

        ok = (Button)findViewById(R.id.ok);
        save = (Button)findViewById(R.id.save);
        exit = (Button)findViewById(R.id.exit);

        ArrayAdapter<CharSequence> adapterPC = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle,
                participantCode);
        spinParticipantCode.setAdapter(adapterPC);

        ArrayAdapter<CharSequence> adapterSC = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle,
                sessionCode);
        spinSessionCode.setAdapter(adapterSC);

        ArrayAdapter<CharSequence> adapterCC = new ArrayAdapter<CharSequence>(this, R.layout.spinnerstyle,
                conditionCode);
        spinConditionCode.setAdapter(adapterCC);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public void onClick(View v) {
        if (v == ok)
        {
            // get user's choices
            String part = participantCode[spinParticipantCode.getSelectedItemPosition()];
            String sess = sessionCode[spinSessionCode.getSelectedItemPosition()];
            String cond = conditionCode[spinConditionCode.getSelectedItemPosition()];

            // package the user's choices in a bundle
            Bundle b = new Bundle();
            b.putString("participantCode", part);
            b.putString("sessionCode", sess);
            b.putString("conditionCode", cond);

            if(cond.equals("Number Picker")){
                Intent i = new Intent(getApplicationContext(), PickerActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }
            else {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                i.putExtras(b);
                startActivity(i);
                finish();
            }

        } else if (v == save)
        {
            spe = sp.edit();
            spe.putString("participantCode", participantCode[spinParticipantCode.getSelectedItemPosition()]);
            spe.putString("sessionCode", sessionCode[spinSessionCode.getSelectedItemPosition()]);
            spe.putString("conditionCode",conditionCode[spinConditionCode.getSelectedItemPosition()]);

            spe.apply();
            Toast.makeText(this, "Preferences saved!", Toast.LENGTH_SHORT).show();

        } else if (v == exit)
        {
            this.finish(); // terminate
        }
    }
}
