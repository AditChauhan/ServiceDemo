package tutorial.adit.com.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyBinder extends Service {

    //constructor
    public MyBinder() {
    }

    //create a ibinder object which takes binder which return service class object
    private final IBinder myBinder = new LocalBinder();

    //onbind bind the ibinder object
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return myBinder;
    }

    // getcurrentTime()
    public String getCurrentTime() {
        SimpleDateFormat dateformat =
                new SimpleDateFormat("HH:mm:ss MM/dd/yyyy",
                        Locale.US);
        return (dateformat.format(new Date()));
    }

    public class LocalBinder extends Binder {
        MyBinder getService() {
            return MyBinder.this;
        }
    }


}
