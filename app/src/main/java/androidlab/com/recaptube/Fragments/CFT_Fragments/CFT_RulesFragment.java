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
import android.widget.Toast;

import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.GeneralUtils;


public class CFT_RulesFragment extends Fragment {
    EditText ETClientRules;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cft__rules, container, false);
        ETClientRules = (EditText) view.findViewById(R.id.ClientRules);
        initUI();
        return view;
    }

    private void initUI(){

        ETClientRules.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ClientRules = ETClientRules.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"ClientRules",ClientRules);
            }
        });
    }
}
