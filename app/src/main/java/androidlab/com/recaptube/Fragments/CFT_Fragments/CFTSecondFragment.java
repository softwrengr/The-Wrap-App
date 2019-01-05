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


public class CFTSecondFragment extends Fragment {
    EditText FacilitatorNameET, ETCFSName, ETCaregiverName, ETParentPartnerName,TherapistNameET,ETSupervisorName, ETNonNegotiables;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cftsecond, container, false);


        FacilitatorNameET = (EditText) view.findViewById(R.id.FacilitatorName);
        ETCaregiverName = (EditText) view.findViewById(R.id.CaregiverName);
        ETCFSName = (EditText) view.findViewById(R.id.CFSName);
        TherapistNameET = (EditText) view.findViewById(R.id.TherapistName);
        ETParentPartnerName = (EditText) view.findViewById(R.id.ParentPartnerName);
        ETSupervisorName = (EditText) view.findViewById(R.id.SupervisorName);

        initUI();

        return view;
    }

    private void initUI(){

        FacilitatorNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String FacilitatorName = FacilitatorNameET.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"FacilitatorName",FacilitatorName);
            }
        });

        ETCFSName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String CFSName = ETCFSName.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"CFSName",CFSName);
            }
        });

        ETCaregiverName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String CaregiverName = ETCaregiverName.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"CaregiverName",CaregiverName);
            }
        });

        TherapistNameET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String TherapistName = TherapistNameET.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"TherapistName",TherapistName);
            }
        });

        ETParentPartnerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String ParentPartnerName = ETParentPartnerName.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"ParentPartnerName",ParentPartnerName);
            }
        });

        ETSupervisorName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String SupervisorName = ETSupervisorName.getText().toString();
                GeneralUtils.putStringValueInEditor(getActivity(),"SupervisorName",SupervisorName);
            }
        });

    }
}
