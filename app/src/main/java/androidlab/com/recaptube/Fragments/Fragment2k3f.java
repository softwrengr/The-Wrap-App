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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.GeneralUtils;


public class Fragment2k3f extends Fragment {

    TextView tvFinalString, tvFinalResponse;
    String text, finalText, totalString, finalResponse;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment2k3f, container, false);

        customActionBar();
        tvFinalString = (TextView) view.findViewById(R.id.FinalString);
        tvFinalResponse = (TextView) view.findViewById(R.id.FinalResponse);
        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        finalText = sharedPreferences.getString("finalstring", "");
        editor.putString("finalstring", "").commit();
        totalString = sharedPreferences.getString("aaa", "");

        if (totalString.equals("")) {
            tvFinalString.setText(finalText);
            editor.putString("aaa", finalText).commit();
        } else {
            totalString = totalString + " " + finalText;
            tvFinalString.setText(totalString);
            editor.putString("aaa", totalString).commit();
        }

        Bundle bundle = this.getArguments();
        if (bundle == null) {
            text = "";
        } else {
            text = getArguments().getString("text");
        }

        finalResponse = sharedPreferences.getString("bbb", "");
        if (finalResponse.equals("")) {
            tvFinalResponse.setText(text);
            editor.putString("bbb", text).commit();
        } else {
            finalResponse = finalResponse + " " + text;
            tvFinalResponse.setText(finalResponse);
            editor.putString("bbb", finalResponse).commit();
        }

        tvFinalResponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new Behavior2k()).commit();

                editor.putString("intervention", tvFinalString.getText().toString()).commit();
                editor.putString("response", tvFinalResponse.getText().toString()).commit();
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
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar2k3b, null);
        Button btnBehavior = (Button) mCustomView.findViewById(R.id.btnBehavior);
        Button btnIntervention = (Button) mCustomView.findViewById(R.id.btnInterventioncustom);
        btnBehavior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("intervention", tvFinalString.getText().toString()).commit();
                editor.putString("response", tvFinalResponse.getText().toString()).commit();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new Behavior2k()).commit();
            }
        });
        btnIntervention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneralUtils.connectFragmentWithBackStack(getActivity(), new InterventionFragment1());
            }
        });
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }


}
