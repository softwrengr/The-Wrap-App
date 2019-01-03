package androidlab.com.recaptube.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidlab.com.recaptube.R;

public class ToDoList extends Fragment {

    Button btn1, btn2, btn3;
    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_to_do_list, container, false);
        bundle = new Bundle();
        btn1 = view.findViewById(R.id.todoProgress);
        btn2 = view.findViewById(R.id.todoOMA);
        btn3 = view.findViewById(R.id.todoProgreessDakota);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2 = new ClientProgressNote();
                bundle.putString("task", "Progress Note");
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2 = new G_OMA3Month();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2 = new ClientProgressNote();
                bundle.putString("task", "Progress Note");
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
            }
        });
        customActionBar();

        return view;
    }

    public void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar_taskgrid, null);
        TextView textView=(TextView)mCustomView.findViewById(R.id.textView2);
        String barTitle="To Do List";
        textView.setText(barTitle);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }
}
