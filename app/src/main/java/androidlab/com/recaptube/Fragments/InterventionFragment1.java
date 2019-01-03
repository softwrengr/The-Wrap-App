package androidlab.com.recaptube.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidlab.com.recaptube.Fragments.MainTabs.Fragment2k3b;
import androidlab.com.recaptube.R;

public class InterventionFragment1 extends Fragment implements View.OnClickListener {

    TextView mainText;
    Button btnFacilitator, btnCFS, btnTherapist, btnParentpartner, btnTeam;
    String clientId;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_intervention_fragment1, container, false);


        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
       customActionBar();
        mainText = (TextView) view.findViewById(R.id.textPreview2k3a);
        btnFacilitator = (Button) view.findViewById(R.id.btnFacilitator);
        btnTherapist = (Button) view.findViewById(R.id.btnTherapist);
        btnCFS = (Button) view.findViewById(R.id.cfs_intervention);
        btnParentpartner = (Button) view.findViewById(R.id.btnParentPartner);
        btnTeam = (Button) view.findViewById(R.id.btnTeam);

        clientId = sharedPreferences.getString("clientId", "");


        btnFacilitator.setOnClickListener(this);
        btnTherapist.setOnClickListener(this);
        btnParentpartner.setOnClickListener(this);
        btnTeam.setOnClickListener(this);
        btnCFS.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btnFacilitator:
                mainText.setText("The facilitator ");
                editor.putString("doer","The facilitator").commit();
                Fragment fragment = new Fragment2k3b();
                Bundle bundle = new Bundle();
                bundle.putString("text", mainText.getText().toString());
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("abc").commit();
                break;
            case R.id.btnTherapist:
                editor.putString("doer","The therapist").commit();
                mainText.setText("The therapist ");
                Fragment fragment2 = new Fragment2k3b();
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", mainText.getText().toString());
                fragment2.setArguments(bundle2);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                break;
            case R.id.btnParentPartner:
                editor.putString("doer","The parent partner").commit();
                mainText.setText("The parent partner ");
                Fragment fragment3 = new Fragment2k3b();
                Bundle bundle3 = new Bundle();
                bundle3.putString("text", mainText.getText().toString());
                fragment3.setArguments(bundle3);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment3).addToBackStack("abc").commit();
                break;
            case R.id.btnTeam:
                editor.putString("doer","The team").commit();
                mainText.setText("The team ");
                Fragment fragment4 = new Fragment2k3b();
                Bundle bundle4 = new Bundle();
                bundle4.putString("text", mainText.getText().toString());
                fragment4.setArguments(bundle4);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment4).addToBackStack("abc").commit();
                break;
            case R.id.cfs_intervention:
                editor.putString("doer","The CFS").commit();
                mainText.setText("The CFS ");
                Fragment fragment5 = new Fragment2k3b();
                Bundle bundle5 = new Bundle();
                bundle5.putString("text", mainText.getText().toString());
                fragment5.setArguments(bundle5);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment5).addToBackStack("abc").commit();
                break;

            default:
                break;
        }
    }

    private void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.customaction, null);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);
    }
}
