package androidlab.com.recaptube.Fragments.CFT_Fragments;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidlab.com.recaptube.Fragments.ClientsFragment;
import androidlab.com.recaptube.Utils.GeneralUtils;
import androidlab.com.recaptube.Utils.ZipManager;
import androidlab.com.recaptube.R;


public class CFT_MinutesFragment extends Fragment {
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    SharedPreferences sharedPreferences;
    TextView tvdatepicker, startTime, endTime;
    DatePickerDialog datePickerDialog;
    String strDate, aTime, startT, endT;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a__cftminutes, container, false);
        startTime = (TextView) view.findViewById(R.id.startTime);
        endTime = (TextView) view.findViewById(R.id.endTime);
        tvdatepicker = (TextView) view.findViewById(R.id.tvdatepicker);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        } else {
            // Permission has already been granted
        }


        //Date time picker
        tvdatepicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c1 = Calendar.getInstance();
                int mYear = c1.get(Calendar.YEAR); // current year
                int mMonth = c1.get(Calendar.MONTH); // current month
                final int mDay = c1.get(Calendar.DAY_OF_MONTH);

                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                strDate = (monthOfYear + 1) + "-" + dayOfMonth + "-" + year;
                                editor.putInt("Month", monthOfYear + 1).commit();
                                editor.putInt("Day", mDay).commit();
                                editor.putInt("Year", year).commit();
                                editor.putString("CFTDate", strDate).commit();
                                tvdatepicker.setText("Date : " + strDate);
                                GeneralUtils.putStringValueInEditor(getActivity(),"cft_date",strDate);


                            }
                        }, mYear, mMonth, mDay);

                datePickerDialog.show();
            }
        });

        startTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c1 = Calendar.getInstance();
                int mYear = c1.get(Calendar.YEAR); // current year
                int mMonth = c1.get(Calendar.MONTH); // current month
                final int mDay = c1.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                int hour = hourOfDay;
                                int minutes = minute;
                                String timeSet = "";
                                if (hour > 12) {
                                    hour -= 12;
                                    timeSet = "PM";
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
                                aTime = new StringBuilder().append(hour).append(':')
                                        .append(min).append(" ").append(timeSet).toString();

                                editor.putString("CFTtime", aTime).commit();
                                startTime.setText("Start Time : " + aTime);
                                startT = aTime;
                                editor.putString("startTime", aTime).commit();

                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
        endTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar c1 = Calendar.getInstance();

                final Calendar c = Calendar.getInstance();
                int hour = c.get(Calendar.HOUR_OF_DAY);
                int minute = c.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {
                                int hour = hourOfDay;
                                int minutes = minute;
                                String timeSet = "";
                                if (hour > 12) {
                                    hour -= 12;
                                    timeSet = "PM";
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
                                aTime = new StringBuilder().append(hour).append(':')
                                        .append(min).append(" ").append(timeSet).toString();
                                editor.putString("CFTtime", aTime).commit();
                                endTime.setText("End Time : " + aTime);
                                endT = aTime;
                                editor.putString("endTime", aTime).commit();

                            }
                        }, hour, minute, false);
                timePickerDialog.show();
            }
        });
        return view;
    }

}
