package androidlab.com.recaptube.Fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidlab.com.recaptube.R;


public class ExtraFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_extra, container, false);


        return view;
    }


    private void showDialog(){
        Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog4_layout);
        dialog.show();
    }
}
