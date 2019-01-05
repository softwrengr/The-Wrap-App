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

public class CFT_NonNegotiableFragment extends Fragment {
    EditText  ETNonNegotiables;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cft__non_negotiable, container, false);

        ETNonNegotiables = (EditText) view.findViewById(R.id.NonNegotiables);
        initUI();
        return view;
    }

    private void initUI(){

        ETNonNegotiables.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String NonNegotiables = ETNonNegotiables.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"NonNegotiables",NonNegotiables);
            }
        });

    }
}
