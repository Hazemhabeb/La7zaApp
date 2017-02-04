package sohba.sohba_travel.com.la7zaapp;

import android.app.Application;

import com.instabug.library.Instabug;
import com.instabug.library.invocation.InstabugInvocationEvent;

/**
 * Created by hazem on 1/31/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        new Instabug.Builder(this, "bb29d0bea479ec9ddbf2edab1209d2da")
                .setInvocationEvent(InstabugInvocationEvent.SHAKE)
                .build();
    }
}
