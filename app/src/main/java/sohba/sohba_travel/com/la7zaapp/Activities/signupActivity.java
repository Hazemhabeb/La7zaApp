package sohba.sohba_travel.com.la7zaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.util.SetFont;

public class signupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_multichoice);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter);


        SetFont setFont = new SetFont();
        setFont.changeFonts(signupActivity.this, (LinearLayout) findViewById(R.id.parent_lol));
        setFont.changeFonts(signupActivity.this, (LinearLayout) findViewById(R.id.parent_id));
        setFont.changeFonts(signupActivity.this, (LinearLayout) findViewById(R.id.parent_id_));
    }
    public void signup_(View view){
        startActivity(new Intent(signupActivity.this,mainActivity.class));
    }
}
