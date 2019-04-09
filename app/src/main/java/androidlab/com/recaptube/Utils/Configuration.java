
package androidlab.com.recaptube.Utils;

import android.Manifest;
import android.app.Activity;
import android.util.Log;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

/**
 * Created by eapple on 03/01/2019.
 */

public class Configuration {

    //public static String ALL_CLIENTS = "http://muhammednaveed.com/eric_apis/client_info.php";
    //public static String ADD_CLIENTS = "http://muhammednaveed.com/eric_apis/clients_detail.php";
    //public static String DELETE_CLIENTS = "http://muhammednaveed.com/eric_apis/delete_client.php?id=";

    //public static String ALL_CLIENTS = "http://umerdurrani.design/eric_apis/client_info.php";
    //public static String ADD_CLIENTS = "hhttp://umerdurrani.design/eric_apis/clients_detail.php";
    //public static String DELETE_CLIENTS = "http://umerdurrani.design/eric_apis/delete_client.php?id=";


    public static String ALL_CLIENTS = "http://softwarengr.website/eric_apis/client_info.php";
    public static String ADD_CLIENTS = "http://softwarengr.website/eric_apis/clients_detail.php";
    public static String DELETE_CLIENTS = "http://softwarengr.website/eric_apis/delete_client.php?id=";


    public static void grantPermision(Activity activity){
        Dexter.withActivity(activity)
                .withPermissions(
                        Manifest.permission.INTERNET,
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.WRITE_CALENDAR

                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Log.d("zma","permission granted");
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }


        }).check();
    }

}
