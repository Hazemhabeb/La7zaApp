package sohba.sohba_travel.com.la7zaapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.util.SetFont;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // set font to the layout
        SetFont setFont = new SetFont();
        setFont.changeFonts(LoginActivity.this, (LinearLayout) findViewById(R.id.parent_id));
        setFont.changeFonts(LoginActivity.this, (LinearLayout) findViewById(R.id.parent_id_));
        setFont.changeFonts(LoginActivity.this, (LinearLayout) findViewById(R.id.parent_id__));
    }
    public void login_(View view){
        startActivity(new Intent(LoginActivity.this,mainActivity.class));
    }
    public void sign_up_on_click(View view){
        startActivity(new Intent(LoginActivity.this,signupActivity.class));
    }
}
