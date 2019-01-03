package androidlab.com.recaptube.Fragments.Fragment2k3eTabs;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidlab.com.recaptube.Fragments.Fragment2k3f;
import androidlab.com.recaptube.R;

public class PositiveFragment extends Fragment implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13
    ,btn14,btn15,btn16,btn17;
    String Text,InterventionSubject;
    Bundle bundle;
    String finalText;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_positive, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        InterventionSubject=sharedPreferences.getString("subject","");
        Text=getArguments().getString("text");
        finalText=Text.replace("The","the");

        btn1=(Button)view.findViewById(R.id.agreed);
        btn2=(Button)view.findViewById(R.id.appearedinterested);
        btn3=(Button)view.findViewById(R.id.engaged2K3e);
        btn4=(Button)view.findViewById(R.id.complied);
        btn5=(Button)view.findViewById(R.id.contributedtotheconversation);
        btn6=(Button)view.findViewById(R.id.displayedproblemsolvingskills);
        btn7=(Button)view.findViewById(R.id.madeconsciencedecisions);
        btn8=(Button)view.findViewById(R.id.madepositivestatements);
        btn9=(Button)view.findViewById(R.id.modifiedtheirbehavior);
        btn10=(Button)view.findViewById(R.id.respondedappropriately);
        btn11=(Button)view.findViewById(R.id.smiled);
        btn12=(Button)view.findViewById(R.id.usedactivelisteningskills);
        btn13=(Button)view.findViewById(R.id.wasassertive);
        btn14=(Button)view.findViewById(R.id.wasempathetic);
        btn15=(Button)view.findViewById(R.id.washopeful);
        btn16=(Button)view.findViewById(R.id.wasinsightful);
        btn17=(Button)view.findViewById(R.id.wasreceptive);
        btn1.setOnClickListener(this);    btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);    btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);    btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);    btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);    btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);    btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);    btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);    btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();

        Text="The " + InterventionSubject + " " + buttonText + " when " + finalText;
        fragment=new Fragment2k3f();
        bundle.putString("text",Text);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
    }
}