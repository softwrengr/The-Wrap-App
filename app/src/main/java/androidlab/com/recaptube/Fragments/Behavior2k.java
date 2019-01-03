package androidlab.com.recaptube.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import androidlab.com.recaptube.Adapter.MoodAdapter;
import androidlab.com.recaptube.R;

public class Behavior2k extends Fragment {

    Switch clientStatedSwitch,GoalSuccessSwitch;
    TextView tvTopBehavior;
    Spinner moodSpinner,goalSpinner,reporterSpinner;
    String goals,clientId,before2ndrow,str2ndRow;
    String afterRowFirst=" Who observed the client's goal progress?";
    String btn1,btn2,btn3,btn4,btn5,btn6,btn7,btnTherapist,btnClient,btnParentPartner,btnFacilitator;
    String[] countryNames={"Mood","positive","neutral","negative"};
    int flags[] = {0,R.drawable.positive, R.drawable.neutral, R.drawable.negative};
    SharedPreferences sharedPreferences;
    String firstText;
    SharedPreferences.Editor editor ;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list2 = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    CharSequence[] items;
    Button btnPlan;
    TextView tv2ndRow;
    LinearLayout tv2ndRowLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_behavior2k, container, false);

        customActionBar();
        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        goals=sharedPreferences.getString("goals","");
        tvTopBehavior=(TextView)view.findViewById(R.id.textPreview2K4_1);
        moodSpinner=(Spinner)view.findViewById(R.id.spinnerMood);
        goalSpinner=(Spinner)view.findViewById(R.id.spinnerGoals);
        reporterSpinner=(Spinner)view.findViewById(R.id.spinnerReporter);
        clientStatedSwitch=(Switch)view.findViewById(R.id.switchClientStated);
        GoalSuccessSwitch=(Switch)view.findViewById(R.id.switchGoalSuccess);
        tv2ndRow=(TextView)view.findViewById(R.id.textPreview2K4_2);
        tv2ndRowLayout=(LinearLayout)view.findViewById(R.id.textPreview2K4_2Layout);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list);
        adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, list2);

        MoodAdapter customAdapter=new MoodAdapter(getActivity(),flags,countryNames);
        moodSpinner.setAdapter(customAdapter);

        moodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position==0)
                {
                    firstText="What was the client's mood?";
                    tvTopBehavior.setText("What was the client's mood?");
                }
                else
                if (position==1)
                {
                 clientStatedSwitch.setVisibility(View.VISIBLE);
                 reporterSpinner.setVisibility(View.VISIBLE);
                 tv2ndRowLayout.setVisibility(View.VISIBLE);
                 if (!clientStatedSwitch.isChecked())
                 {
                     firstText="The client appeared to be in a positive mood.";
                     tvTopBehavior.setText("The client appeared to be in a positive mood.");
                 }
                 clientStatedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                     @Override
                     public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                         if (clientStatedSwitch.isChecked())
                         {
                             firstText="The client stated that they were in a positive mood.";
                             tvTopBehavior.setText("The client stated that they were in a positive mood.");

                         }
                         else
                         {
                             firstText="The client appeared to be in a positive mood.";
                             tvTopBehavior.setText("The client appeared to be in a positive mood.");
                         }
                     }
                 });

                }
                else
                    if (position==2)
                    {
                        clientStatedSwitch.setVisibility(View.VISIBLE);
                        reporterSpinner.setVisibility(View.VISIBLE);
                        tv2ndRowLayout.setVisibility(View.VISIBLE);
                        if (!clientStatedSwitch.isChecked())
                        {
                            firstText="The client appeared to be in a neutral mood.";
                            tvTopBehavior.setText("The client appeared to be in a neutral mood.");
                        }
                        clientStatedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (clientStatedSwitch.isChecked())
                                {
                                    firstText="The client stated that they were in a neutral mood.";
                                    tvTopBehavior.setText("The client stated that they were in a neutral mood.");

                                }
                                else
                                {
                                    firstText="The client appeared to be in a neutral mood.";
                                    tvTopBehavior.setText("The client appeared to be in a neutral mood.");
                                }
                            }
                        });
                    }
                    else
                        if (position==3)
                    {
                        clientStatedSwitch.setVisibility(View.VISIBLE);
                        reporterSpinner.setVisibility(View.VISIBLE);
                        tv2ndRow.setVisibility(View.VISIBLE);
                        if (!clientStatedSwitch.isChecked())
                        {
                            firstText="The client appeared to be in a negative mood.";
                            tvTopBehavior.setText("The client appeared to be in a negative mood.");
                        }
                        clientStatedSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if (clientStatedSwitch.isChecked())
                                {
                                    firstText="The client stated that they were in a negative mood.";
                                    tvTopBehavior.setText("The client stated that they were in a negative mood.");

                                }
                                else
                                {
                                    firstText="The client appeared to be in a negative mood.";
                                    tvTopBehavior.setText("The client appeared to be in a negative mood.");
                                }
                            }
                        });

                    }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        clientId=sharedPreferences.getString("clientId","");
        btn1=sharedPreferences.getString(clientId+" btn1","");
        btn2=sharedPreferences.getString(clientId+" btn2","");
        btn3=sharedPreferences.getString(clientId+" btn3","");
        btn4=sharedPreferences.getString(clientId+" btn4","");
        btn5=sharedPreferences.getString(clientId+" btn5","");
        btn6=sharedPreferences.getString(clientId+" btn6","");
        btn7=sharedPreferences.getString(clientId+" btn7","");
        list.add("Goal Reporter");
        list.add("client");

        if (!btn1.equals("") )
        {
            list.add(btn1);
        }
        if (!btn2.equals(""))
        {
            list.add(btn2);
        }

        if (!btn3.equals(""))
        {
            list.add(btn3);
        }

        if (!btn4.equals(""))
        {
            list.add(btn4);
        }

        if (!btn5.equals(""))
        {
            list.add(btn5);
        }

        if (!btn6.equals(""))
        {
            list.add(btn6);
        }

        if (!btn7.equals(""))
        {
            list.add(btn7);
        }
        adapter.notifyDataSetChanged();
        reporterSpinner.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        reporterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item=parent.getItemAtPosition(position);
                if (item.equals("Goal Reporter"))
                {
                    tv2ndRow.setText(afterRowFirst);
                }
                else
                    if (item.equals("client"))
                    {
                        before2ndrow=" The client reported on which goal?";
                        tv2ndRow.setText(before2ndrow);
                        goalSpinner.setVisibility(View.VISIBLE);

                    }
                    else
                        if (item.equals(btn1))
                        {
                            before2ndrow=" The "+btn1 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);

                        }
                        else
                        if (item.equals(btn2))
                        {
                            before2ndrow=" The "+btn2 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
                        else
                        if (item.equals(btn3))
                        {
                            before2ndrow=" The "+btn3 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
                        else
                        if (item.equals(btn4))
                        {
                            before2ndrow=" The "+btn4 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
                        else
                        if (item.equals(btn5))
                        {
                            before2ndrow=" The "+btn5 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
                        else
                        if (item.equals(btn6))
                        {
                            before2ndrow=" The "+btn6 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
                        else
                        if (item.equals(btn7))
                        {
                            before2ndrow=" The "+btn7 +" reported on which goal?";
                            tv2ndRow.setText(before2ndrow);
                            goalSpinner.setVisibility(View.VISIBLE);
                        }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        list2.add("Goal");
        String[] GoalsArray = goals.split(",");
        items = new CharSequence[GoalsArray.length];
        for (int j = 0; j < GoalsArray.length; j++) {
            items[j] =GoalsArray[j];
            list2.add(GoalsArray[j]);
        }
        adapter2.notifyDataSetChanged();
        goalSpinner.setAdapter(adapter2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        goalSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (position==1)
                    {
                        GoalSuccessSwitch.setVisibility(View.VISIBLE);
                        btnPlan.setVisibility(View.VISIBLE);
                        if(GoalSuccessSwitch.isChecked())
                        {
                            before2ndrow=tv2ndRow.getText().toString();
                            if (before2ndrow.contains("on which goal?"))
                            {
                               // String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[0]);
                                before2ndrow=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[0]+".");
                                tv2ndRow.setText(before2ndrow);
                            }
                            else
                                if (before2ndrow.contains(items[0]))
                                {
                                    tv2ndRow.setText(before2ndrow);
                                }
                                else
                                    if (before2ndrow.contains(items[1]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[1],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                    else if (before2ndrow.contains(items[2]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[2],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                    else if (before2ndrow.contains(items[3]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[3],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                    else if (before2ndrow.contains(items[4]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[4],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                    else if (before2ndrow.contains(items[5]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[5],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                    else if (before2ndrow.contains(items[6]))
                                    {
                                        before2ndrow=before2ndrow.replace(items[6],items[0]);
                                        tv2ndRow.setText(before2ndrow);
                                    }
                        }
                        else
                        {
                            if (before2ndrow.contains(items[0]))
                            {
                                tv2ndRow.setText(before2ndrow);
                            }
                            else
                            if (before2ndrow.contains(items[1]))
                            {
                                before2ndrow=before2ndrow.replace(items[1],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                            else if (before2ndrow.contains(items[2]))
                            {
                                before2ndrow=before2ndrow.replace(items[2],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                            else if (before2ndrow.contains(items[3]))
                            {
                                before2ndrow=before2ndrow.replace(items[3],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                            else if (before2ndrow.contains(items[4]))
                            {
                                before2ndrow=before2ndrow.replace(items[4],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                            else if (before2ndrow.contains(items[5]))
                            {
                                before2ndrow=before2ndrow.replace(items[5],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                            else if (before2ndrow.contains(items[6]))
                            {
                                before2ndrow=before2ndrow.replace(items[6],items[0]);
                                tv2ndRow.setText(before2ndrow);
                            }
                        }
                        GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                if(!GoalSuccessSwitch.isChecked())
                                {
                                    before2ndrow=tv2ndRow.getText().toString();
                                    if (before2ndrow.contains("The"))
                                    {
                                        before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                        if (before2ndrow.contains("was "))
                                        {
                                            before2ndrow=before2ndrow.replace("was ","was not ");
                                            tv2ndRow.setText(before2ndrow);
                                        }
                                    }
                                }
                                else
                              if (GoalSuccessSwitch.isChecked())
                                {
                                    before2ndrow=tv2ndRow.getText().toString();
                                    if(before2ndrow.contains("Unfortunately, the"))
                                    {
                                        before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                        if (before2ndrow.contains("was not"))
                                        {
                                            before2ndrow=before2ndrow.replace("was not ","was ");
                                            tv2ndRow.setText(before2ndrow);
                                        }
                                    }
                                }
                            }
                        });
                    }
                    else
                if (position==2)
                {
                    GoalSuccessSwitch.setVisibility(View.VISIBLE);
                    btnPlan.setVisibility(View.VISIBLE);
                    if(GoalSuccessSwitch.isChecked())
                    {
                        if (before2ndrow.contains("on which goal?"))
                        {
                            String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[1]+".");
                            tv2ndRow.setText(text);
                        }
                        else
                        if (before2ndrow.contains(items[0]))
                        {
                           // Toast.makeText(getActivity(), before2ndrow, Toast.LENGTH_LONG).show();
                            before2ndrow=tv2ndRow.getText().toString();
                            before2ndrow=before2ndrow.replace(items[0],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    else
                    {
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {

                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[1]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(!GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tv2ndRow.getText().toString();
                                if (before2ndrow.contains("The"))
                                {
                                    before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                    if (before2ndrow.contains("was "))
                                    {
                                        before2ndrow=before2ndrow.replace("was ","was not ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                            else
                                if (GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tv2ndRow.getText().toString();
                                if(before2ndrow.contains("Unfortunately, the"))
                                {
                                    before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                    if (before2ndrow.contains("was not"))
                                    {
                                        before2ndrow=before2ndrow.replace("was not ","was ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                        }
                    });

                }
                else
                if (position==3)
                {
                    GoalSuccessSwitch.setVisibility(View.VISIBLE);
                    btnPlan.setVisibility(View.VISIBLE);
                    if(GoalSuccessSwitch.isChecked())
                    {
                        if (before2ndrow.contains("on which goal?"))
                        {
                            String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[2]+".");
                            tv2ndRow.setText(firstText +text);
                        }
                        else
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=tv2ndRow.getText().toString();
                            before2ndrow=before2ndrow.replace(items[0],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    else
                    {
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[2]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(!GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tv2ndRow.getText().toString();
                                if (before2ndrow.contains("The"))
                                {
                                    before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                    if (before2ndrow.contains("was "))
                                    {
                                        before2ndrow=before2ndrow.replace("was ","was not ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                            else
                                if (GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tv2ndRow.getText().toString();
                                if(before2ndrow.contains("Unfortunately, the"))
                                {
                                    before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                    if (before2ndrow.contains("was not"))
                                    {
                                        before2ndrow=before2ndrow.replace("was not","was ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                        }
                    });
                }
                if (position==4)
                {
                    GoalSuccessSwitch.setVisibility(View.VISIBLE);
                    btnPlan.setVisibility(View.VISIBLE);
                    if(GoalSuccessSwitch.isChecked())
                    {
                        if (before2ndrow.contains("on which goal?"))
                        {
                            String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[3]+".");
                            tv2ndRow.setText(firstText +text);
                        }
                        else
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    else
                    {
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {

                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[3]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(!GoalSuccessSwitch.isChecked())
                            {
                                if (before2ndrow.contains(". The"))
                                {
                                    before2ndrow=tv2ndRow.getText().toString();
                                    before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                    if (before2ndrow.contains("was "))
                                    {
                                        before2ndrow=before2ndrow.replace("was ","was not ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                            else
                                if (GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tvTopBehavior.getText().toString();
                                if(before2ndrow.contains("Unfortunately, the"))
                                {
                                    before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                    if (before2ndrow.contains("was not"))
                                    {
                                        before2ndrow=before2ndrow.replace("was not","was ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                        }
                    });
                }
                else
                if (position==5)
                {
                    GoalSuccessSwitch.setVisibility(View.VISIBLE);
                    btnPlan.setVisibility(View.VISIBLE);
                    if(GoalSuccessSwitch.isChecked())
                    {
                        if (before2ndrow.contains("on which goal?"))
                        {
                            String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[4]+".");
                            tv2ndRow.setText(firstText +text);
                        }
                        else
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    else
                    {
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            before2ndrow=before2ndrow.replace(items[5],items[4]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[4]);
                            tvTopBehavior.setText(before2ndrow);
                        }
                    }
                    GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(!GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tvTopBehavior.getText().toString();
                                if (before2ndrow.contains("The"))
                                {
                                    before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                    if (before2ndrow.contains("was "))
                                    {
                                        before2ndrow=before2ndrow.replace("was ","was not ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                            else
                                if (GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tvTopBehavior.getText().toString();
                                if(before2ndrow.contains("Unfortunately, the"))
                                {
                                    before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                    if (before2ndrow.contains("was not"))
                                    {
                                        before2ndrow=before2ndrow.replace("was not","was ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                        }
                    });
                }
                if (position==6)
                {
                    GoalSuccessSwitch.setVisibility(View.VISIBLE);
                    btnPlan.setVisibility(View.VISIBLE);
                    if(GoalSuccessSwitch.isChecked())
                    {
                        if (before2ndrow.contains("on which goal?"))
                        {
                            String text=before2ndrow.replace("on which goal?", "that the client was successful in meeting the goal to "+items[5]+".");
                            tv2ndRow.setText(firstText +text);
                        }
                        else
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    else
                    {
                        if (before2ndrow.contains(items[0]))
                        {
                            before2ndrow=before2ndrow.replace(items[0],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else
                        if (before2ndrow.contains(items[1]))
                        {
                            before2ndrow=before2ndrow.replace(items[1],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[2]))
                        {
                            before2ndrow=before2ndrow.replace(items[2],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[3]))
                        {
                            before2ndrow=before2ndrow.replace(items[3],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[4]))
                        {
                            before2ndrow=before2ndrow.replace(items[4],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[5]))
                        {
                            tv2ndRow.setText(before2ndrow);
                        }
                        else if (before2ndrow.contains(items[6]))
                        {
                            before2ndrow=before2ndrow.replace(items[6],items[5]);
                            tv2ndRow.setText(before2ndrow);
                        }
                    }
                    GoalSuccessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(!GoalSuccessSwitch.isChecked())
                            {
                                if (before2ndrow.contains("The"))
                                {
                                    before2ndrow=before2ndrow.replaceFirst("The","Unfortunately, the");
                                    if (before2ndrow.contains("was "))
                                    {
                                        before2ndrow=before2ndrow.replace("was ","was not ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                            else
                                if (GoalSuccessSwitch.isChecked())
                            {
                                before2ndrow=tvTopBehavior.getText().toString();
                                if(before2ndrow.contains("Unfortunately, the"))
                                {
                                    before2ndrow=before2ndrow.replace("Unfortunately, the","The");
                                    if (before2ndrow.contains("was not"))
                                    {
                                        before2ndrow=before2ndrow.replace("was not","was ");
                                        tv2ndRow.setText(before2ndrow);
                                    }
                                }
                            }
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
        View mCustomView = mInflater.inflate(R.layout.custom_behavior, null);
        btnPlan=(Button)mCustomView.findViewById(R.id.btnPlan);
        btnPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("bText1",tvTopBehavior.getText().toString()).commit();
                editor.putString("bText2",tv2ndRow.getText().toString()).commit();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new PlanFragment()).commit();
            }
        });
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}
