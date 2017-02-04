package sohba.sohba_travel.com.la7zaapp.Activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.model.addRequestModel;

public class addRequest extends AppCompatActivity {


    private DatabaseReference mFirebaseDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request);




        // New child entries
        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        final Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        final Spinner spinner12 = (Spinner) findViewById(R.id.spinner12);
        final EditText hospitalEt= (EditText) findViewById(R.id.hospitalEt);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.blood_type, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter12 = ArrayAdapter.createFromResource(this,
                R.array.case_, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        adapter1.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        adapter12.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
        spinner12.setAdapter(adapter12);

        Button sendRequestB= (Button) findViewById(R.id.sendRequestB);
        sendRequestB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (hospitalEt.getText().toString().isEmpty()){
                    Toast.makeText(addRequest.this,"plz type the hospital name",Toast.LENGTH_LONG).show();
                    return;
                }
                 addRequestModel addRequestModel = new
                         addRequestModel(hospitalEt.getText().toString()
                         ,spinner.getSelectedItem().toString(),spinner1.getSelectedItem().toString(),
                         spinner12.getSelectedItem().toString());

                mFirebaseDatabaseReference.child("Emergency")
                        .push().setValue(addRequestModel);
                Toast.makeText(addRequest.this,"your request has been send keep in touch",Toast.LENGTH_LONG).show();

                new CountDownTimer(6000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        //nothing
                    }

                    public void onFinish() {
                        Intent intent = new Intent(addRequest.this, mainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        PendingIntent pendingIntent = PendingIntent.getActivity(addRequest.this, 0 /* Request code */, intent,
                                PendingIntent.FLAG_ONE_SHOT);
                        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                        NotificationCompat.Builder notificationBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(addRequest.this)
                                .setSmallIcon(R.drawable.lm3)
                                .setContentTitle("Success")
                                .setContentText("We send the Request for you Waiting for incomming Notifications")
                                .setAutoCancel(true)
                                .setSound(defaultSoundUri)
                                .setContentIntent(pendingIntent);

                        NotificationManager notificationManager =
                                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
                    }
                }.start();
                finish();

            }
        });


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }


}
