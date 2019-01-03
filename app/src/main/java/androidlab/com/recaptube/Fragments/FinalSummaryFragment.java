package androidlab.com.recaptube.Fragments;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.gson.JsonObject;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import javax.mail.Session;

import androidlab.com.recaptube.R;

public class FinalSummaryFragment extends Fragment {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    EditText progressNoteEditText;
    Button btnSubmit;
    Session session = null;
    TextView startDate, endDate, tvTime, tvAddress, tvOtherCodes;
    ProgressDialog pdialog = null;
    Context context = null;
    String getIntroduction2k1, getBehviorText1, getBehviorText2, getIntervention, getResponse, getPtext1, getPtext2, getPtext3, getSelectedGoal;
    int day, year, month;
    String time, Fname, type, Lname, sessionType, address2Street, address2City, address2Zip, startAtime, endAtime, clientName, add2Title, sessionCode;
    int familyMembers;
    int other;
    int friends;
    int interventionTime;
    int FaceToFaceTime;
    int otherInterventionTime;
    int otherTime;
    String TotalTime;
    int commute = 00;
    int travel = 14;
    int documentation = 10;
    String tarikh = null;
    int zero = 00;
    long date;
    String currentDateTime;
    int startimeMinutes, endTimeMinutes;
    char first;
    DatePickerDialog datePickerDialog;
    GoogleAccountCredential mCredential;
    String ServiceSite, date2k1, dateAndTime2k1, abc, clientPresence, ClientInvolved, EncounterWith;
    String strAddress1, strAddress2, strDistance, strTime, strShowDistance, strURL, path, strShowTime, strStreet, strZip, strStreet2, strZip2;
    String strDisplayTime, progressNoteText, timeRowText, addressText, otherCodesText, strAllInfo;
    String staticTime="",staticDistance="";
    LinearLayout textNotificationRow, tmsgs;
    boolean flag1, flag2, flag3, flag4;

    Dialog dialog;
    ImageView imageViewStar;
    TextView tvalt;

    private TextView mOutputText;
    private Button mCallApiButton;
    ProgressDialog mProgress;

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

    private static final String BUTTON_TEXT = "Call Google Calendar API";
    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = {CalendarScopes.CALENDAR_READONLY};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_final_summary, container, false);
        Log.i("SJA", "okk fuckinng inn FinalSummaryFragment");

        customActionBar();
        progressNoteEditText = (EditText) view.findViewById(R.id.progressNoteEditText);
        tvTime = (TextView) view.findViewById(R.id.tvTime);
        tvAddress = (TextView) view.findViewById(R.id.tvAddress);
        tvOtherCodes = (TextView) view.findViewById(R.id.tvOtherCodes);
        textNotificationRow = (LinearLayout) view.findViewById(R.id.tmsgs);
        tmsgs = (LinearLayout) view.findViewById(R.id.TextNotificationRow);
        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        date = sharedPreferences.getLong("timetime", 0);

        startDate = (TextView) view.findViewById(R.id.tvStartDate);
        endDate = (TextView) view.findViewById(R.id.tvEndDate);

        sessionCode = sharedPreferences.getString("code", "");
        add2Title = sharedPreferences.getString("add2title", "");
        clientName = sharedPreferences.getString("clientname", "");
        day = sharedPreferences.getInt("Day", 0);
        other = sharedPreferences.getInt("other", 0);
        friends = sharedPreferences.getInt("friends", 0);
        month = sharedPreferences.getInt("Month", 0);
        address2Street = sharedPreferences.getString("a2street", "");
        address2City = sharedPreferences.getString("a2city", "");
        address2Zip = sharedPreferences.getString("a2zip", "");
        year = sharedPreferences.getInt("Year", 0);
        Fname = sharedPreferences.getString("fname", "");
        Lname = sharedPreferences.getString("lname", "");
        sessionType = sharedPreferences.getString("type", "");
        tarikh = sharedPreferences.getString("date", "");
        date2k1 = sharedPreferences.getString("2k1Date", "");
        familyMembers = sharedPreferences.getInt("fm", 0);
        dateAndTime2k1 = sharedPreferences.getString("2k1DateAndTime", "");
        type = sharedPreferences.getString("type", "");
        clientPresence = sharedPreferences.getString("client", "");

        strAddress1 = sharedPreferences.getString("address1", "null");
        strAddress2 = sharedPreferences.getString("address2", "null");

        strStreet = sharedPreferences.getString("street", "null");
        strZip = sharedPreferences.getString("zip", "null");
        strStreet2 = sharedPreferences.getString("street2", "null");
        strZip2 = sharedPreferences.getString("zip2", "null");


        Log.d("abdullah",String.valueOf(date));

        showDistanceTime(strAddress1,strAddress2);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION},1);

        Dexter.withActivity(getActivity())
                .withPermissions(
                        Manifest.permission.INTERNET,
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION

                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                Log.d("zma","permission granted");
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {

            }


        }).check();

        Log.d("show", "this is my address" + strAddress1);
        Log.d("show", "this is my address2" + strAddress2);

//        requestForPlaceApi();

        first = Fname.charAt(0);

        mCredential = new GoogleAccountCredential(getActivity(), "softwrengr@gmail.com");

        java.util.Calendar c = java.util.Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String formattedDate = df.format(c.getTime());

        if (add2Title.contains("Home")) {
            ServiceSite = ("12 - Home");
        } else if (add2Title.contains("School")) {
            ServiceSite = ("03 - School");
        } else if (add2Title.contains("Office")) {
            ServiceSite = ("11 - Office");
        } else {
            ServiceSite = ("90 - Field");
        }


        time = sharedPreferences.getString("time", "");
        btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        getSelectedGoal = sharedPreferences.getString("selectedgoal", "");
        getIntroduction2k1 = sharedPreferences.getString("back", "");
        getBehviorText1 = sharedPreferences.getString("bText1", "");
        getBehviorText2 = sharedPreferences.getString("bText2", "");
        getIntervention = sharedPreferences.getString("intervention", "");
        getResponse = sharedPreferences.getString("response", "");
        getPtext1 = sharedPreferences.getString("pText1", "");
        getPtext2 = sharedPreferences.getString("pText2", "");
        getPtext3 = sharedPreferences.getString("pText3", "");

        progressNoteText =
                "********** INTRODUCTION **********\n" +
                        getIntroduction2k1 + "\n\n" +
                        "********** GOAL **********\n" +
                        getSelectedGoal + "\n\n" +
                        "********** BEHAVIOR **********\n" +
                        getBehviorText1 + getBehviorText2 + "\n\n" +
                        "********** INTERVENTION **********\n" +
                        getIntervention + "\n\n" +
                        "********** RESPONSE **********\n" +
                        getResponse + "\n\n" +
                        "********** PLAN **********\n" +
                        getPtext1 + " " + getPtext2 + " " + getPtext3;

//        final String timeRowText =
//        final String addressText =
        addressText =
                "" + "    " + path + "\n\n" +
                        "                 Distance    " + staticDistance + "\n" +
                        "             Service Site" + "    12 - Home" + "\n" +
                        "    Service Facility Name" + "    " + add2Title + "\n" +
                        " Service Facility Address" + "    " + address2Street + "\n" +
                        "    Service Facility City" + "    " + address2City + "\n" +
                        "   Service Facility State" + "    " + "CA" + "\n" +
                        "Service Facility Zip Code" + "    " + address2Zip + "\n";

//        final String otherCodesText =
        if (clientPresence.equals("yes")) {
            ClientInvolved = "Yes";
        } else {
            ClientInvolved = "No";
        }
            otherCodesText =
                "          Client Involved" + "    " + ClientInvolved + "\n" +
                        "       Family Collaterals" + "    " + String.valueOf(familyMembers) + "\n" +
                        "   Non-Family Collaterals" + "    " + String.valueOf(other + friends) + "\n" +
                        "             Session Type" + "    " + sessionCode + "\n" +
                        "            Activity Type" + "    " + "02 - Face to Face with Client - IBHIS" + "\n" +
                        "           Encounter With" + "    " + "05 - Client or Client With Others" + "\n" +
                        "  Evidence Based Practice" + "    " + "00 - No Evidence-Based Practice" + "\n" +
                        "             Completed By" + "    " + "Eric Ramos (Child and Family Specialist III Bilingual)" + "\n" +
                        "                Submit To" + "    " + "Boss Lady (CFS Coordinator)";

        progressNoteEditText.setText(progressNoteText);
        tvAddress.setText(addressText);
        tvOtherCodes.setText(otherCodesText);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final java.util.Calendar c = java.util.Calendar.getInstance();
                int hour = c.get(java.util.Calendar.HOUR_OF_DAY);
                int minute = c.get(java.util.Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                flag1 = true;
                                makeLayoutVisible();
                                int hour = hourOfDay;
                                int minutes = minute;
                                String timeSet = "";
                                if (hour > 12) {
                                    timeSet = "PM";
                                    hour -= 12;

                                } else if (hour == 0) {
                                    hour += 12;
                                    timeSet = "AM";
                                } else if (hour == 12) {
                                    timeSet = "PM";
                                } else {
                                    timeSet = "AM";
                                }

                                String min = "";
                                if (minutes < 10)
                                    min = "0" + minutes;
                                else
                                    min = String.valueOf(minutes);

                                // Append in a StringBuilder
                                startimeMinutes = hour * 60 + minutes;
                                CalculateTime(startimeMinutes, endTimeMinutes);
                                startAtime = new StringBuilder().append(hour).append(':')
                                        .append(min).toString();
                                abc = startDate.getText().toString();
                                startDate.setText(abc + " at " + startAtime);
                                Log.d("date",startDate.getText().toString());

                            }
                        }, hour, minute, false);
                timePickerDialog.show();


                final java.util.Calendar c1 = java.util.Calendar.getInstance();
                int mYear = c1.get(java.util.Calendar.YEAR); // current year
                int mMonth = c1.get(java.util.Calendar.MONTH); // current month
                final int mDay = c1.get(java.util.Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                flag2 = true;
                                makeLayoutVisible();
                                // set day of month , month and year value in the edit text
                                abc = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                startDate.setText(abc);


                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();


            }
        });

        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final java.util.Calendar c = java.util.Calendar.getInstance();
                int hour = c.get(java.util.Calendar.HOUR_OF_DAY);
                int minute = c.get(java.util.Calendar.MINUTE);


                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                flag3 = true;
                                makeLayoutVisible();
                                int hour = hourOfDay;
                                int minutes = minute;
                                String timeSet = "";
                                if (hour > 12) {
                                    hour -= 12;
                                    //  timeSet = "PM";
                                } else if (hour == 0) {
                                    hour += 12;
                                    //  timeSet = "AM";
                                } else if (hour == 12) {
                                    // timeSet = "PM";
                                } else {
                                    // timeSet = "AM";
                                }

                                String min = "";
                                if (minutes < 10)
                                    min = "0" + minutes;
                                else
                                    min = String.valueOf(minutes);
                                endTimeMinutes = hour * 60 + minutes;
                                CalculateTime(startimeMinutes, endTimeMinutes);
                                // Append in a StringBuilder
                                endAtime = new StringBuilder().append(hour).append(':')
                                        .append(min).toString();
                                abc = endDate.getText().toString();
                                endDate.setText(abc + " at " + endAtime);

                            }
                        }, hour, minute, false);
                timePickerDialog.show();


                final java.util.Calendar c1 = java.util.Calendar.getInstance();
                int mYear = c1.get(java.util.Calendar.YEAR); // current year
                int mMonth = c1.get(java.util.Calendar.MONTH); // current month
                final int mDay = c1.get(java.util.Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                flag4 = true;
                                makeLayoutVisible();
                                // set day of month , month and year value in the edit text
                                abc = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                                endDate.setText(abc);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View view) {

                strAllInfo = progressNoteText  + timeRowText  + addressText + otherCodesText;
                generateNoteOnSD(strAllInfo);
                createEvent();
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {

                    Cursor cursor = getActivity().getContentResolver().query(CalendarContract.Events.CONTENT_URI, null, null, null, null);
                    while (cursor.moveToNext()) {
                        if (cursor != null) {
                            int id_1 = cursor.getColumnIndex(CalendarContract.Events._ID);
                            int id_2 = cursor.getColumnIndex(CalendarContract.Events.TITLE);
                            int id_3 = cursor.getColumnIndex(CalendarContract.Events.DESCRIPTION);
                            int id_4 = cursor.getColumnIndex(CalendarContract.Events.EVENT_LOCATION);

                            String idValue = cursor.getString(id_1);
                            String titleValue = cursor.getString(id_2);
                            String descriptionValue = cursor.getString(id_3);
                            String eventValue = cursor.getString(id_4);

                        } else {
                        }
                    }
                    return;
                }
                showDialog();
                Fragment fragment = new ClientsFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("abc").commit();

            }
        });

        return view;
    }
    private void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.congo_dialog_layout);
        Button btn_ok = dialog.findViewById(R.id.ok_congo);
        imageViewStar = (ImageView) dialog.findViewById(R.id.imageViewStar);
        imageViewStar.setVisibility(View.VISIBLE);
        tvalt = (TextView) dialog.findViewById(R.id.tvCongo);
        tvalt.setText("Congratulations! You have earned " + interventionTime + " productivity points!");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
    public void makeLayoutVisible() {
        if (flag1 && flag2 && flag3 && flag4) {
            tvTime.setVisibility(View.VISIBLE);
            tvAddress.setVisibility(View.VISIBLE);
            tvOtherCodes.setVisibility(View.VISIBLE);
            textNotificationRow.setVisibility(View.VISIBLE);
            tmsgs.setVisibility(View.VISIBLE);
            progressNoteEditText.setVisibility(View.VISIBLE);
            btnSubmit.setVisibility(View.VISIBLE);

        }
        else {
            tvTime.setVisibility(View.GONE);
            tvAddress.setVisibility(View.GONE);
            tvOtherCodes.setVisibility(View.GONE);
            textNotificationRow.setVisibility(View.GONE);
            tmsgs.setVisibility(View.GONE);
            progressNoteEditText.setVisibility(View.GONE);
            btnSubmit.setVisibility(View.GONE);
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode ==   1){
//            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                requestForPlaceApi();
//                Log.d("zma","permission granted");
//                Toast.makeText(context, "permission granted", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    public void CalculateTime(int start, int end) {
        int finalTime = end - start + 1;
        String abc = String.valueOf(finalTime);
        abc = abc.replace("-", "");
        interventionTime = Integer.parseInt(abc);
        interventionTime = 60;

        startimeMinutes = interventionTime - 1;

        if (clientPresence.equals("yes")) {
            ClientInvolved = "Yes";

            FaceToFaceTime = interventionTime;
            otherInterventionTime = 0;

            EncounterWith = "05 - Client or Client With Others";

        } else {
            ClientInvolved = "No";

            FaceToFaceTime = 0;
            otherInterventionTime = interventionTime;

            if (familyMembers > 0) {
                EncounterWith = "01 - Client's Family or Significant Other";
            } else {
                EncounterWith = "02 - Other Professional";
            }

        }

        travel = Integer.parseInt(staticTime);

        otherTime = Integer.valueOf(otherInterventionTime + 10 + travel - 0);
        TotalTime = String.valueOf(interventionTime + otherTime);
        timeRowText =
                "\n" +
                        "               Total Time    " + TotalTime + "\n" +
                        "        Face-to-Face Time        " + FaceToFaceTime + "\n" +
                        "               Other Time        " + otherTime + "\n" +
                        "                                     +" + otherInterventionTime + " (Intervention)\n" +
                        "                                     +10 (Documentation)\n" +
                        "                                     +" + staticTime + " (Travel)\n" +
                        "                                     -00 (Commute)\n";


        tvTime.setText(timeRowText);

    }

    public void generateNoteOnSD(String sBody) {
        SimpleDateFormat formatter = new SimpleDateFormat("mm");
        Date now = new Date();
        String fileName = clientName + "_" + startDate.getText().toString() + ".txt";
        try {
            File root = new File(Environment.getExternalStorageDirectory() + File.separator + "Notes");
            if (!root.exists()) {
                root.mkdirs();
            }

            File gpxfile = new File(root, fileName);


            FileWriter writer = new FileWriter(gpxfile, true);
            writer.append(sBody + "\n\n");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMail() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"SBHGApp@gmail.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {

        }
    }

    public String getCurrentTimeStamp() {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
            currentDateTime = dateFormat.format(new Date()); // Find todays date

            return currentDateTime;
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }



    private void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.customaction, null);
        TextView textView = (TextView) mCustomView.findViewById(R.id.tvTitle);
        textView.setText("Summary");
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }

    public void createEvent() {

        ContentResolver cr = getActivity().getContentResolver();
        String eventUriString = "content://com.android.calendar/events";
        ContentValues eventValues = new ContentValues();
        eventValues.put("calendar_id", 1);
        eventValues.put("title", first + " ." + Lname + ", " + type);
        eventValues.put("description", "this is my event");
        eventValues.put("eventLocation", "Los Vegas");
        eventValues.put(CalendarContract.Events.DTSTART, date);
        eventValues.put(CalendarContract.Events.DTEND, date + 60 * 60 * 1000);
        eventValues.put("eventStatus", "Recaptube");
        eventValues.put("hasAlarm", 1);

        eventValues.put("eventTimezone", TimeZone.getDefault().getID());
        Uri eventUri = cr.insert(Uri.parse(eventUriString), eventValues);
        long eventID = Long.parseLong(eventUri.getLastPathSegment());

    }

    //============================

    public void showDistanceTime(String address1,String address2){
        String street1 = strStreet.replace(" ", "-");
        String street2 = strStreet2.replace(" ", "-");
        path = "https://maps.google.com/maps/api/directions/" + street1 + "+" + strZip + "/" + street2 + "+" + strZip2;

         if(address1.equals("11155 183rd StCerritosCA 90703") && address2.equals("1625 W. Olympic BlvdLos AngelesCA 90015")){
            staticTime = "38";
            staticDistance = "20.4 miles";
        }

        else if(address1.equals("1625 W. Olympic BlvdLos AngelesCA 90015") && address2.equals("11155 183rd StCerritosCA 90703")){
            staticTime = "38";
            staticDistance = "20.4 miles";
        }
        else {
             staticDistance = "14.6 miles";
             staticTime = "31";
        }

    }

}
