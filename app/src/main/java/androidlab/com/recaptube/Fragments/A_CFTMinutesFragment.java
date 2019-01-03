package androidlab.com.recaptube.Fragments;

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
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import androidlab.com.recaptube.Utils.ZipManager;
import androidlab.com.recaptube.R;


public class A_CFTMinutesFragment extends Fragment {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    SharedPreferences sharedPreferences;
    Button directedAttentionEng;
    EditText FacilitatorNameET, ETCFSName, ETCaregiverName, ETParentPartnerName;
    EditText TherapistNameET;
    EditText ETSupervisorName, ETNonNegotiables, ETClientWorries, ETClientRules, ETCaregiverGoal, ETClientGoal;
    TextView tvdatepicker, startTime, endTime;
    DatePickerDialog datePickerDialog;
    String strDate, aTime, startT, endT;
    String finalOutputPath = Environment.getExternalStorageDirectory().getPath()+ "/CFT Minutes/";


    SharedPreferences.Editor editor;

    String inputPath = Environment.getExternalStorageDirectory().getPath()+ "/inputDocx/";
    String inputFile = "input.docx";
    String outputPath = Environment.getExternalStorageDirectory().getPath()+ "/.tmpDocx/";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_a__cftminutes, container, false);
        directedAttentionEng = (Button) view.findViewById(R.id.directedattentionEng);
        FacilitatorNameET = (EditText) view.findViewById(R.id.FacilitatorName);
        ETCaregiverName = (EditText) view.findViewById(R.id.CaregiverName);
        ETCFSName = (EditText) view.findViewById(R.id.CFSName);
        TherapistNameET = (EditText) view.findViewById(R.id.TherapistName);
        ETParentPartnerName = (EditText) view.findViewById(R.id.ParentPartnerName);
        ETSupervisorName = (EditText) view.findViewById(R.id.SupervisorName);
        ETNonNegotiables = (EditText) view.findViewById(R.id.NonNegotiables);
        ETClientWorries = (EditText) view.findViewById(R.id.ClientWorries);
        ETClientRules = (EditText) view.findViewById(R.id.ClientRules);
        ETCaregiverGoal = (EditText) view.findViewById(R.id.CaregiverGoal);
        ETClientGoal = (EditText) view.findViewById(R.id.ClientGoal);
        startTime = (TextView) view.findViewById(R.id.startTime);
        endTime = (TextView) view.findViewById(R.id.endTime);
        tvdatepicker = (TextView) view.findViewById(R.id.tvdatepicker);
//        timeSpinner = (Spinner) view.findViewById(R.id.spinnerSessionType);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
        directedAttentionEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDocCreated = docxCreation();
                if (isDocCreated) {
                    String fName = sharedPreferences.getString("fname","");
                    String lName = sharedPreferences.getString("lname","");
                    editor.putString("CFTClientName", fName + " " + lName).commit();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.mainContainer, new ClientsFragment()).commit();
                }
            }
        });

        //Date time picker
        tvdatepicker.setOnClickListener(new View.OnClickListener() {
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

                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
//                                strDate = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                                strDate = (monthOfYear + 1) + "-" + dayOfMonth + "-" + year;
                                editor.putInt("Month", monthOfYear + 1).commit();
                                editor.putInt("Day", mDay).commit();
                                editor.putInt("Year", year).commit();
                                editor.putString("CFTDate", strDate).commit();
                                tvdatepicker.setText("Date : " + strDate);


                            }
                        }, mYear, mMonth, mDay);

//                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(),
//                        new TimePickerDialog.OnTimeSetListener() {
//
//                            @Override
//                            public void onTimeSet(TimePicker view, int hourOfDay,
//                                                  int minute) {
//                                int hour = hourOfDay;
//                                int minutes = minute;
//                                String timeSet = "";
//                                if (hour > 12) {
//                                    hour -= 12;
//                                    timeSet = "PM";
//                                } else if (hour == 0) {
//                                    hour += 12;
//                                    timeSet = "AM";
//                                } else if (hour == 12) {
//                                    timeSet = "PM";
//                                } else {
//                                    timeSet = "AM";
//                                }
//
//                                String min = "";
//                                if (minutes < 10)
//                                    min = "0" + minutes;
//                                else
//                                    min = String.valueOf(minutes);
//
//                                // Append in a StringBuilder
//                                aTime = new StringBuilder().append(hour).append(':')
//                                        .append(min).append(" ").append(timeSet).toString();
//
////                                textPreviewDate.setText("The CFS will meet on " + strDate + " at " + aTime + " for what type of meeting?");
//                                editor.putString("CFTtime", aTime).commit();
////                                timeSpinner.setVisibility(View.VISIBLE);
//
////                                date= Date.parse(strDate+" "+aTime);
//                                editor.putString("CFTDate", strDate).commit();
//                            }
//                        }, hour, minute, false);
//                timePickerDialog.show();
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
    public boolean docxCreation() {
        String FacilitatorName = FacilitatorNameET.getText().toString();
        String CaregiverName = ETCaregiverName.getText().toString();
        String CFSName = ETCFSName.getText().toString();
        String TherapistName = TherapistNameET.getText().toString();
        String ParentPartnerName = ETParentPartnerName.getText().toString();
        String SupervisorName = ETSupervisorName.getText().toString();
        String NonNegotiables = ETNonNegotiables.getText().toString();
        String ClientWorries = ETClientWorries.getText().toString();
        String ClientRules = ETClientRules.getText().toString();
        String CaregiverGoal = ETCaregiverGoal.getText().toString();
        String ClientGoal = ETClientGoal.getText().toString();
        Log.i("SJA", "ClientRules: " + ClientRules);
        Log.i("SJA", "CaregiverGoal: " + CaregiverGoal);
        String Fname = sharedPreferences.getString("fname","");
        String Lname = sharedPreferences.getString("lname","");

        String startTime = sharedPreferences.getString("startTime","");
        String endTime = sharedPreferences.getString("endTime","");
        String dateval = sharedPreferences.getString("CFTDate","");
        DateFormat dateFormat = new SimpleDateFormat("MMMM_dd");
        Date date = new Date();
        File finalOutputPathDir = new File(finalOutputPath);
        if (!finalOutputPathDir.exists()) {
            finalOutputPathDir.mkdirs();
        }
        String OUTPUT_ZIP_FILE = dateFormat.format(date) + "_" + Fname + "_" + Lname + ".docx";
        if (TherapistName.matches("")) {
            Toast.makeText(getActivity(), "Please Enter Therapist Name to replace", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Caregiver Name", Toast.LENGTH_LONG).show();
        }
        else if (CFSName.matches("")) {
            Toast.makeText(getActivity(), "Please Select CFS Name", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Caregiver Name", Toast.LENGTH_LONG).show();
        }
        else if (FacilitatorName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Facilitator Name", Toast.LENGTH_LONG).show();
        }
        else if (ParentPartnerName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Parent Partner Name", Toast.LENGTH_LONG).show();
        }
        else if (SupervisorName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Supervisor Name", Toast.LENGTH_LONG).show();
        }
        else if (NonNegotiables.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Non Negotiables", Toast.LENGTH_LONG).show();
        }
        else if (ClientWorries.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Worries", Toast.LENGTH_LONG).show();
        }
        else if (ClientRules.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Rules", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverGoal.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Caregiver Goal", Toast.LENGTH_LONG).show();
        }
        else if (ClientGoal.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Goal", Toast.LENGTH_LONG).show();
        }
        else if (strDate == null || strDate.matches("")) {
            Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_LONG).show();
        }
        else if (startT == null || startT.matches("")) {
            Toast.makeText(getActivity(), "Please Select Start Time", Toast.LENGTH_LONG).show();
        }
        else if (endT == null || endT.matches("")) {
            Toast.makeText(getActivity(), "Please Select End Time", Toast.LENGTH_LONG).show();
        }
        else {
            ZipManager zipManager = new ZipManager();
            //Extract Data to a folder
            boolean successUnzip = zipManager.extractZip(inputPath + inputFile, outputPath, false);
            // Re-generate docx
            zipManager.generateFileList(new File(outputPath));
            boolean successZip = zipManager.zipIt(finalOutputPath + OUTPUT_ZIP_FILE, Fname, CaregiverName, TherapistName, ParentPartnerName, FacilitatorName, CFSName, SupervisorName, NonNegotiables, ClientWorries, ClientRules, CaregiverGoal, ClientGoal, dateval, startTime, endTime, "", "", Lname, "CFTMIN", null);
            if (successUnzip && successZip) {
                Log.i("SJA", "Yoo... Docx Successfully Created!!");
                return true;
//                Toast.makeText(getActivity(), "Yoo...Successfully Done!!", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getActivity(), "Oops..Faild!! Either file or folder not found!", Toast.LENGTH_LONG).show();
            }
            //FacilitatorNameET.setText("");
        }
        return false;
    }

}
