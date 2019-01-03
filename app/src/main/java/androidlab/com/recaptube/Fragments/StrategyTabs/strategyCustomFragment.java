package androidlab.com.recaptube.Fragments.StrategyTabs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidlab.com.recaptube.Fragments.Fragment2k3eTabs.Fragment2k3e;
import androidlab.com.recaptube.R;


public class strategyCustomFragment extends Fragment {



    Button btnDiscussionCustom;
    String Text;
    String oldText="what";
    String doer,subject;
    String newText;
    Bundle bundle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_strategy_custom, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        doer=sharedPreferences.getString("doer","");
        subject=sharedPreferences.getString("subject","");
        Text=getArguments().getString("text");
        bundle=new Bundle();
        btnDiscussionCustom = (Button) view.findViewById(R.id.btnStrategyCustom);
        btnDiscussionCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText taskEditText = new EditText(getActivity());
                taskEditText.setSingleLine();
                AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                        .setTitle(Text)
                        .setView(taskEditText)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                newText=Text.replace(oldText,task);
                                String abc="?";
                                String xyz=".";
                                String finalText=newText.replace(abc,xyz);
                                bundle.putString("text",finalText);
                                Fragment fragment=new Fragment2k3e();
                                fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialogdialog.show();

            }
        });


        return  view;
    }


}
