package androidlab.com.recaptube.Fragments;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import androidlab.com.recaptube.R;


public class PlanFragment extends Fragment {

    TextView textPreviewDate, tvPreviewGoals, textPreviewForUserGoal;
    LinearLayout tvPreviewGoalsLayout, textPreviewForUserGoalLayout;

    String strDate;
    String text, goals, textGoal, strUserGoal;
    TextView tvDate;
    DatePickerDialog datePickerDialog;
    String which = "for which type of meeting?";
    Spinner sessionTypeSpinner, goalSpinner, userGoalSPinner;
    String type1 = "an individual rehabilitation session.";
    String type2 = "an All Staff CFT.";
    String type3 = "a CFT meeting.";
    String type4 = "an ITC meeting.";
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Button btnPlan;
    CharSequence[] items;
    String time, Fname, type, Lname;
    String tarikh = null;
    char first;
    long date;
    String aTime;
    String defaultTextForUserGoal = "The CFS will assist the client with the goal to ";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_plan, container, false);
        Log.i("SJA", "okk fuckinng inn PlanFragment");
        customActionBar();
        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Fname = sharedPreferences.getString("fname", "");
        Lname = sharedPreferences.getString("lname", "");
        tarikh = sharedPreferences.getString("date", "");
        first = Fname.charAt(0);
        type = sharedPreferences.getString("type", "");
        goals = sharedPreferences.getString("goals", "");
        textPreviewDate = (TextView) view.findViewById(R.id.tvForDate);

        tvPreviewGoals = (TextView) view.findViewById(R.id.textPreviewForGoals);
        tvPreviewGoalsLayout = (LinearLayout) view.findViewById(R.id.textPreviewForGoalsLayout);

        tvDate = (TextView) view.findViewById(R.id.tvDate);
        sessionTypeSpinner = (Spinner) view.findViewById(R.id.spinnerSessionType);
        goalSpinner = (Spinner) view.findViewById(R.id.spinnerGoals);
        userGoalSPinner = (Spinner) view.findViewById(R.id.spinnerUserGoal);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);

        textPreviewForUserGoal = (TextView) view.findViewById(R.id.tvUserGoal);
        textPreviewForUserGoalLayout = (LinearLayout) view.findViewById(R.id.tvUserGoalLayout);

        tvDate.setOnClickListener(new View.OnClickListener() {
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
                                strDate = (monthOfYear + 1) + "/" + dayOfMonth + "/" + year;
                                editor.putInt("Month", monthOfYear + 1).commit();
                                editor.putInt("Day", mDay).commit();
                                editor.putInt("Year", year).commit();
                                editor.putString("Date", strDate).commit();

                            }
                        }, mYear, mMonth, mDay);

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

                                textPreviewDate.setText("The CFS will meet on " + strDate + " at " + aTime + " for what type of meeting?");
                                editor.putString("time", aTime).commit();
                                sessionTypeSpinner.setVisibility(View.VISIBLE);

                                date=Date.parse(strDate+" "+aTime);
                                editor.putLong("timetime",date).commit();
                            }
                        }, hour, minute, false);



                timePickerDialog.show();

                datePickerDialog.show();





            }
        });

        sessionTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Object item=adapterView.getItemAtPosition(i);
                if (i==1)
                {
                    editor.putString("type",type1).commit();
                    goalSpinner.setVisibility(View.VISIBLE);
                    tvPreviewGoalsLayout.setVisibility(View.VISIBLE);
                    text=textPreviewDate.getText().toString();
                    if (text.contains("what type of meeting?"))
                    {
                        text=text.replace("what type of meeting?",type1);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type2))
                    {
                        editor.putString("type",type1).commit();
                        text=text.replace(type2,type1);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type3))
                    {
                        editor.putString("type",type1).commit();
                        text=text.replace(type3,type1);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type4))
                    {
                        editor.putString("type",type1).commit();
                        text=text.replace(type4,type1);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type1))
                    {
                        editor.putString("type",type1).commit();
                        textPreviewDate.setText(text);
                    }
                }
                else
                if (i==2)
                {
                    editor.putString("type",type2).commit();
                    goalSpinner.setVisibility(View.VISIBLE);
                    tvPreviewGoalsLayout.setVisibility(View.VISIBLE);
                    text=textPreviewDate.getText().toString();
                    if (text.contains("what type of meeting?"))
                    {
                        text=text.replace("what type of meeting?",type2);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type1))
                    {
                        editor.putString("type",type2).commit();
                        text=text.replace(type1,type2);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type3))
                    {
                        editor.putString("type",type2).commit();
                        text=text.replace(type3,type2);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type4))
                    {
                        editor.putString("type",type2).commit();
                        text=text.replace(type4,type2);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type2))
                    {
                        editor.putString("type",type2).commit();
                        textPreviewDate.setText(text);
                    }
                }
                else
                if (i==3)
                {
                    editor.putString("type",type3).commit();
                    goalSpinner.setVisibility(View.VISIBLE);
                    tvPreviewGoalsLayout.setVisibility(View.VISIBLE);
                    text=textPreviewDate.getText().toString();
                    if (text.contains("what type of meeting?"))
                    {
                        text=text.replace("what type of meeting?",type3);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type2))
                    {
                        editor.putString("type",type3).commit();
                        text=text.replace(type2,type3);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type1))
                    {
                        editor.putString("type",type3).commit();
                        text=text.replace(type1,type3);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type4))
                    {
                        editor.putString("type",type3).commit();
                        text=text.replace(type4,type3);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type3))
                    {
                        editor.putString("type",type3).commit();
                        textPreviewDate.setText(text);
                    }
                }
                else
                if (i==4)
                {
                    editor.putString("type",type4).commit();
                    goalSpinner.setVisibility(View.VISIBLE);
                    tvPreviewGoalsLayout.setVisibility(View.VISIBLE);
                    text=textPreviewDate.getText().toString();
                    if (text.contains("what type of meeting?"))
                    {
                        text=text.replace("what type of meeting?",type4);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type1))
                    {
                        editor.putString("type",type4).commit();
                        text=text.replace(type1,type4);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type3))
                    {
                        editor.putString("type",type4).commit();
                        text=text.replace(type3,type4);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type2))
                    {
                        editor.putString("type",type4).commit();
                        text=text.replace(type2,type4);
                        textPreviewDate.setText(text);
                    }
                    else
                    if (text.contains(type4))
                    {
                        editor.putString("type",type4).commit();
                        textPreviewDate.setText(text);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        list.add("Goal");
        String[] GoalsArray = goals.split(",");
        items = new CharSequence[GoalsArray.length];
        for (int j = 0; j < GoalsArray.length; j++) {
            items[j] =GoalsArray[j];
            list.add(GoalsArray[j]);
        }
        adapter.notifyDataSetChanged();
        goalSpinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i == 1) {
                    textPreviewForUserGoalLayout.setVisibility(View.VISIBLE);
                    userGoalSPinner.setVisibility(View.VISIBLE);
                    textGoal = tvPreviewGoals.getText().toString();
                    if(textGoal.contains("?"))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace("?"," "+items[0]+".");
                        if (textGoal.contains("focus on which"))
                        {
                            textGoal=textGoal.replace("focus on which goal","focus on the goal to");
                            tvPreviewGoals.setText(textGoal);
                        }

                    }
                    else
                    if (textGoal.contains(items[0]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[1]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace(items[1],items[0]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[2]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace(items[2],items[1]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[3]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace(items[3],items[1]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[4]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace(items[4],items[1]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[5]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[0]));
                        textGoal=textGoal.replace(items[5],items[1]);
                        tvPreviewGoals.setText(textGoal);
                    }

                }
                else if (i == 2)
                {
                    textPreviewForUserGoalLayout.setVisibility(View.VISIBLE);
                    userGoalSPinner.setVisibility(View.VISIBLE);
                    textGoal = tvPreviewGoals.getText().toString();
                    if(textGoal.contains("?"))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                        textGoal=textGoal.replace("?"," "+items[1]+".");
                        if (textGoal.contains("focus on which"))
                        {
                            textGoal=textGoal.replace("focus on which goal","focus on the goal to");
                            tvPreviewGoals.setText(textGoal);
                        }
                    }
                    else
                    if (textGoal.contains(items[0]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                        textGoal=textGoal.replace(items[0],items[1]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[1]))
                    {
                        tvPreviewGoals.setText(textGoal);
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                    }
                    else
                    if (textGoal.contains(items[2]))
                    {
                        textGoal=textGoal.replace(items[2],items[1]);
                        tvPreviewGoals.setText(textGoal);
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                    }
                    else
                    if (textGoal.contains(items[3]))
                    {
                        textGoal=textGoal.replace(items[3],items[1]);
                        tvPreviewGoals.setText(textGoal);
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                    }
                    else
                    if (textGoal.contains(items[4]))
                    {
                        textGoal=textGoal.replace(items[4],items[1]);
                        tvPreviewGoals.setText(textGoal);
                        editor.putString("selectedgoal",String.valueOf(items[1]));
                    }

                }
                else if (i == 3)
                {
                    textPreviewForUserGoalLayout.setVisibility(View.VISIBLE);
                    userGoalSPinner.setVisibility(View.VISIBLE);
                    textGoal = tvPreviewGoals.getText().toString();
                    if(textGoal.contains("?"))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        textGoal=textGoal.replace("?"," "+items[2]+".");
                        if (textGoal.contains("focus on which"))
                        {
                            textGoal=textGoal.replace("focus on which goal","focus on the goal to");
                            tvPreviewGoals.setText(textGoal);
                        }
                    }
                    else
                    if (textGoal.contains(items[0]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        textGoal=textGoal.replace(items[0],items[2]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[1]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        textGoal=textGoal.replace(items[1],items[2]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[2]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[3]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        textGoal=textGoal.replace(items[3],items[2]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[4]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[2]));
                        textGoal=textGoal.replace(items[4],items[2]);
                        tvPreviewGoals.setText(textGoal);
                    }

                }
                else if (i == 4)
                {
                    textPreviewForUserGoalLayout.setVisibility(View.VISIBLE);
                    userGoalSPinner.setVisibility(View.VISIBLE);
                    textGoal = tvPreviewGoals.getText().toString();
                    if(textGoal.contains("?"))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        textGoal=textGoal.replace("?"," "+items[3]+".");
                        if (textGoal.contains("focus on which"))
                        {
                            textGoal=textGoal.replace("focus on which goal","focus on the goal to");
                            tvPreviewGoals.setText(textGoal);
                        }
                    }
                    else
                    if (textGoal.contains(items[0]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        textGoal=textGoal.replace(items[0],items[3]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[1]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        textGoal=textGoal.replace(items[1],items[3]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[2]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        textGoal=textGoal.replace(items[2],items[3]);
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[3]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        tvPreviewGoals.setText(textGoal);
                    }
                    else
                    if (textGoal.contains(items[4]))
                    {
                        editor.putString("selectedgoal",String.valueOf(items[3]));
                        textGoal=textGoal.replace(items[4],items[3]);
                        tvPreviewGoals.setText(textGoal);
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        list2.add("Goals");
        String[] GoalsArray2 = goals.split(",");
        items = new CharSequence[GoalsArray2.length];
        for (int j = 0; j < GoalsArray2.length; j++) {
            items[j] =GoalsArray2[j];
            list2.add(GoalsArray2[j]);
        }
        adapter2.notifyDataSetChanged();
        userGoalSPinner.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userGoalSPinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1) {
                    btnPlan.setVisibility(View.VISIBLE);
                    strUserGoal = textPreviewForUserGoal.getText().toString();
                    if(strUserGoal.contains("?"))
                    {
                        strUserGoal=strUserGoal.replace("?"," "+items[0]+".");
                        if (strUserGoal.contains("will assist"))
                        {
                            strUserGoal=strUserGoal.replace("will assist","will focus on assisting");
                            if (strUserGoal.contains("which"))
                            {
                                strUserGoal=strUserGoal.replace("which goal","the goal to");
                                textPreviewForUserGoal.setText(strUserGoal);
                            }

                        }


                    }
                    else
                    if (strUserGoal.contains(items[0]))
                    {
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[1]))
                    {
                        strUserGoal=strUserGoal.replace(items[1],items[0]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[2]))
                    {
                        strUserGoal=strUserGoal.replace(items[2],items[0]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[3]))
                    {
                        strUserGoal=strUserGoal.replace(items[3],items[0]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[4]))
                    {
                        strUserGoal=strUserGoal.replace(items[4],items[0]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    {
                        textPreviewForUserGoal.setText(strUserGoal + items[0]+".");
                    }


                }
                else if (i == 2)
                {
                    btnPlan.setVisibility(View.VISIBLE);
                    strUserGoal = textPreviewForUserGoal.getText().toString();
                    if(strUserGoal.contains("?"))
                    {
                        strUserGoal=strUserGoal.replace("?"," "+items[1]+".");
                        if (strUserGoal.contains("will assist"))
                        {
                            strUserGoal=strUserGoal.replace("will assist","will focus on assisting");
                            if (strUserGoal.contains("which"))
                            {
                                strUserGoal=strUserGoal.replace("which goal","the goal to");
                                textPreviewForUserGoal.setText(strUserGoal);
                            }
                        }

                    }
                    else
                    if (strUserGoal.contains(items[0]))
                    {
                        strUserGoal=strUserGoal.replace(items[0],items[1]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[1]))
                    {
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[2]))
                    {
                        strUserGoal=strUserGoal.replace(items[2],items[1]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[3]))
                    {
                        strUserGoal=strUserGoal.replace(items[3],items[1]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[4]))
                    {
                        strUserGoal=strUserGoal.replace(items[4],items[1]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    {
                        textPreviewForUserGoal.setText(strUserGoal + items[1]+".");
                    }

                }
                else if (i == 3)
                {
                    btnPlan.setVisibility(View.VISIBLE);
                    strUserGoal = textPreviewForUserGoal.getText().toString();
                    if(strUserGoal.contains("?"))
                    {
                        strUserGoal=strUserGoal.replace("?"," "+items[2]+".");
                        if (strUserGoal.contains("will assist"))
                        {
                            strUserGoal=strUserGoal.replace("will assist","will focus on assisting");
                            if (strUserGoal.contains("which"))
                            {
                                strUserGoal=strUserGoal.replace("which goal","the goal to");
                                textPreviewForUserGoal.setText(strUserGoal);
                            }
                        }

                    }
                    else
                    if (strUserGoal.contains(items[0]))
                    {
                        strUserGoal=strUserGoal.replace(items[0],items[2]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[1]))
                    {
                        strUserGoal=strUserGoal.replace(items[1],items[2]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[2]))
                    {

                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[3]))
                    {
                        strUserGoal=strUserGoal.replace(items[3],items[2]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[4]))
                    {
                        strUserGoal=strUserGoal.replace(items[4],items[2]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    {
                        textPreviewForUserGoal.setText(strUserGoal + items[2]+".");
                    }
                }
                else if (i == 4)
                {
                    btnPlan.setVisibility(View.VISIBLE);
                    strUserGoal = textPreviewForUserGoal.getText().toString();
                    if(strUserGoal.contains("?"))
                    {
                        strUserGoal=strUserGoal.replace("?"," "+items[3]+".");
                        if (strUserGoal.contains("will assist"))
                        {
                            strUserGoal=strUserGoal.replace("will assist","will focus on assisting");
                            if (strUserGoal.contains("which"))
                            {
                                strUserGoal=strUserGoal.replace("which goal","the goal to");
                                textPreviewForUserGoal.setText(strUserGoal);
                            }
                        }

                    }
                    else
                    if (strUserGoal.contains(items[0]))
                    {
                        strUserGoal=strUserGoal.replace(items[0],items[3]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[1]))
                    {
                        strUserGoal=strUserGoal.replace(items[1],items[3]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[2]))
                    {
                        strUserGoal=strUserGoal.replace(items[2],items[3]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[3]))
                    {
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    if (strUserGoal.contains(items[4]))
                    {
                        strUserGoal=strUserGoal.replace(items[4],items[3]);
                        textPreviewForUserGoal.setText(strUserGoal);
                    }
                    else
                    {
                        textPreviewForUserGoal.setText(strUserGoal + items[3]+".");
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    private void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionabar_plan, null);
        btnPlan=(Button)mCustomView.findViewById(R.id.btnSummary);
        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("pText1",textPreviewDate.getText().toString()).commit();
                editor.putString("pText2",tvPreviewGoals.getText().toString()).commit();
                editor.putString("pText3",textPreviewForUserGoal.getText().toString()).commit();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new FinalSummaryFragment()).commit();
            }
        });
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}