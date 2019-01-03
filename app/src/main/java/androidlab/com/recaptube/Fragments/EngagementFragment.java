package androidlab.com.recaptube.Fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidlab.com.recaptube.R;


public class EngagementFragment extends Fragment {

    Button briefed,discussed,explained,highlighted,gather_information,
            inquired,informed,reviewed,used_active_listening,usedOpenEndedQuestion;
    String Text,clientId,thirdString,whichTab;
    Bundle bundle;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_engagement2, container, false);

        return view;
    }
}
