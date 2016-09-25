package bits.project.com.flightplanner;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Vignesh on 9/18/2016.
 */
public class FlightInfo extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}


