package androidlab.com.recaptube.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import androidlab.com.recaptube.R;

/**
 * Created by eapple on 03/01/2019.
 */

public class GeneralUtils {

    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static Fragment connectFragment(Context context, Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
        return fragment;
    }

    public static Fragment connectFragmentWithBackStack(Context context, Fragment fragment) {
        ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("true").commit();
        return fragment;
    }


    public static SharedPreferences.Editor putStringValueInEditor(Context context, String key, String value) {
        sharedPreferences = getSharedPreferences(context);
        editor = sharedPreferences.edit();
        editor.putString(key, value).commit();
        return editor;
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences("recaptube", 0);
    }



    //second screen data
    public static String getFacilitatorName(Context context){
        return getSharedPreferences(context).getString("FacilitatorName","");
    }

    public static String getCaregiverName(Context context){
        return getSharedPreferences(context).getString("CaregiverName","");
    }
    public static String getCFSName(Context context){
        return getSharedPreferences(context).getString("CFSName","");
    }
    public static String getTherapistName(Context context){
        return getSharedPreferences(context).getString("TherapistName","");
    }
    public static String getParentPartnerName(Context context){
        return getSharedPreferences(context).getString("ParentPartnerName","");
    }
    public static String getSupervisorName(Context context){
        return getSharedPreferences(context).getString("SupervisorName","");
    }

    //end

    //third screen data
    public static String getNonNegotiables(Context context){
        return getSharedPreferences(context).getString("NonNegotiables","");
    }

    public static String getClientRules(Context context){
        return getSharedPreferences(context).getString("ClientRules","");
    }

    public static String getCaregiverGoal(Context context){
        return getSharedPreferences(context).getString("CaregiverGoal","");
    }

    public static String getClientGoal(Context context){
        return getSharedPreferences(context).getString("ClientGoal","");
    }


    public static String getDate(Context context){
        return getSharedPreferences(context).getString("cft_date","");
    }

    //worries
    public static String getClientWorries(Context context){
        return getSharedPreferences(context).getString("ClientWorries","");
    }

    public static String getText(Context context){
        return getSharedPreferences(context).getString("text","");
    }
}
