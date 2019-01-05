package androidlab.com.recaptube.Fragments.CFT_Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.GeneralUtils;

public class CFT_ThirdFragment extends Fragment {
    EditText   ETCaregiverGoal, ETClientGoal;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cft__third, container, false);

        ETCaregiverGoal = (EditText) view.findViewById(R.id.CaregiverGoal);
        ETClientGoal = (EditText) view.findViewById(R.id.ClientGoal);
        initUI();
        return view;
    }

    private void initUI(){

        ETCaregiverGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String CaregiverGoal = ETCaregiverGoal.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"CaregiverGoal",CaregiverGoal);

            }
        });

        ETClientGoal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String ClientGoal = ETClientGoal.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"ClientGoal",ClientGoal);
            }
        });

    }
}
