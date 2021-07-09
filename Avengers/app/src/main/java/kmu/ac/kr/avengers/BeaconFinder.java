package kmu.ac.kr.avengers;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.recognition.packets.Beacon;
import com.estimote.coresdk.service.BeaconManager;

import java.util.List;
import java.util.UUID;

public class BeaconFinder extends Application
{
    private BeaconManager beaconManager;

    public void onCreate()
    {
        super.onCreate();

        beaconManager = new BeaconManager( getApplicationContext());

        beaconManager.connect(new BeaconManager.ServiceReadyCallback()
        {
            @Override
            public void onServiceReady()
            {
                beaconManager.startMonitoring(new BeaconRegion("monitored region", UUID.fromString("b9407f30-f5f8-466e-aff9-25556b57fe6d"), 4196, 17810));
            }
        });

        beaconManager.setMonitoringListener(new BeaconManager.BeaconMonitoringListener()
        {
            @Override
            public void onEnteredRegion(BeaconRegion beaconRegion, List<Beacon> beacons)
            {
                showNotification("Info","lemon connected" + beacons.get(0));
                PopupActivity.inArea = true;
                Intent intent = new Intent(getApplicationContext(), PopupActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                getApplicationContext().startActivity(intent);
            }

            @Override
            public void onExitedRegion(BeaconRegion beaconRegion)
            {
                PopupActivity.inArea = false;
                showNotification("Info","lemon disconnected");
            }
        });

        beaconManager.setForegroundScanPeriod(1000, 0);
        beaconManager.setRegionExitExpiration(1000);
    }

    public void showNotification(String title, String message)
    {
        Intent notifyIntent = new Intent(this, MainActivity.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivities(this, 0, new Intent[] { notifyIntent }, PendingIntent.FLAG_UPDATE_CURRENT);
        Notification notification = new Notification.Builder(this)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .build();
        notification.defaults |= Notification.DEFAULT_SOUND;
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);
    }
}