package androidlab.com.recaptube.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidlab.com.recaptube.R;

public class GoalsFragment extends Fragment {

    LinearLayout linearLayout;
    String clientId,clientName;
    String clientGoals;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    String previous;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_goals, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        linearLayout=(LinearLayout)view.findViewById(R.id.container);
        clientName=getArguments().getString("clientName");
        clientGoals=sharedPreferences.getString("goals","");
        clientId=sharedPreferences.getString("clientId","");
        customActionBar();
        String[] GoalsArray = clientGoals.split(",");
        for(int j =0; j<GoalsArray.length; j++){
            EditText textView = new EditText(getActivity());
            textView.setHeight(50);
            textView.setTextSize(20);
            textView.setTextColor(Color.GRAY);
            int line = 2;
            textView.setLines(line);
            textView.setEnabled(false);
            textView.setPadding(50,0,0,20);
            textView.setText("The client will "+GoalsArray[j]+".");

            linearLayout.addView(textView);

        }
       // goalApiCall();
        return view;
    }

    private void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar_goals, null);
        final TextView textView=(TextView)mCustomView.findViewById(R.id.tvGoals);
        String barTitle="Goals";
        textView.setText(barTitle);

        final Button button=(Button)mCustomView.findViewById(R.id.btnIntervention);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    button.setVisibility(View.VISIBLE);
                    Fragment fragment=new InterventionFragment1();
                    Bundle bundle=new Bundle();
                    bundle.putString("clientId",clientId);
                    editor.putString("goals",clientGoals).commit();
                    //fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();


            }
        });


        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}
