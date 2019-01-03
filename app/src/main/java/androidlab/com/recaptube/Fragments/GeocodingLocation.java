package androidlab.com.recaptube.Fragments;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Handler;

/**
 * Created by Adamnoor on 02-Mar-18.
 */

public class GeocodingLocation {
    private static final String TAG = "GeocodingLocation";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    public void getAddressFromLocation(final String locationAddress, final Context context, final android.os.Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                try {
                    List addressList = geocoder.getFromLocationName(locationAddress, 1);
                    if (addressList != null && addressList.size() > 0) {
                        Address address = (Address) addressList.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(address.getLatitude()).append("\n");
                        sb.append(address.getLongitude()).append("\n");
                        sharedPreferences = context.getSharedPreferences("recap", Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        Double lat=address.getLatitude();
                        Double lng=address.getLongitude();
                        editor.putString("lat",String.valueOf(lat)).commit();
                        editor.putString("lng",String.valueOf(lng)).commit();

                        result = sb.toString();
                    }

                } catch (IOException e) {
                    Log.e(TAG, "Unable to connect to Geocoder", e);
                } finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    Message message2 = Message.obtain();
                    message2.setTarget(handler);
                    if (result != null) {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Address: " + locationAddress +
                                "\n\nLatitude and Longitude :\n" + result;
                        bundle.putString("address", result);
                        message.setData(bundle);
                    } else {
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Address: " + locationAddress +
                                "\n Unable to get Latitude and Longitude for this address location.";
                        bundle.putString("address", result);
                        message.setData(bundle);
                    }
                    message.sendToTarget();
                }
            }
        };
        thread.start();
    }

    public void getAddressFromLocation2(final String locatoinAddress2, final Context context, final android.os.Handler handler) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result2=null;
                try {
                    List addressList2=geocoder.getFromLocationName(locatoinAddress2,1);
                    if (addressList2 !=null && addressList2.size() >0)
                    {
                        Address address = (Address) addressList2.get(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(address.getLatitude()).append("\n");
                        sb.append(address.getLongitude()).append("\n");
                        sharedPreferences = context.getSharedPreferences("recap", Context.MODE_PRIVATE);
                        editor = sharedPreferences.edit();
                        Double lat=address.getLatitude();
                        Double lng=address.getLongitude();
                        editor.putString("lat2",String.valueOf(lat)).commit();
                        editor.putString("lng2",String.valueOf(lng)).commit();

                        result2 = sb.toString();
                    }
                } catch (IOException e) {
                    Log.e(TAG, "Unable to connect to Geocoder", e);
                } finally {

                    Message message2 = Message.obtain();
                    message2.setTarget(handler);
                    if (result2 != null) {
                        message2.what = 1;
                        Bundle bundle = new Bundle();
                        result2 = "Address: " + locatoinAddress2 +
                                "\n\nLatitude and Longitude :\n" + result2;
                        bundle.putString("address2", result2);
                        message2.setData(bundle);
                    } else {
                        message2.what = 1;
                        Bundle bundle = new Bundle();
                        result2 = "Address: " + locatoinAddress2 +
                                "\n Unable to get Latitude and Longitude for this address location.";
                        bundle.putString("address2", result2);
                        message2.setData(bundle);
                    }
                    message2.sendToTarget();
                }
            }
        };
        thread.start();

    }

}
