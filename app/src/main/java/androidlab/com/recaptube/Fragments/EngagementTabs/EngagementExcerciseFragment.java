package androidlab.com.recaptube.Fragments.EngagementTabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidlab.com.recaptube.Fragments.Fragment2k3eTabs.Fragment2k3e;
import androidlab.com.recaptube.R;


public class EngagementExcerciseFragment extends Fragment implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5;
    String Text,doer,interventionSubject;
    Fragment fragment;
    Bundle bundle;
    String oldText="what?";
    String newText;
    String temp;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_engagement_excercise, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        doer=sharedPreferences.getString("doer","");
        interventionSubject=sharedPreferences.getString("subject","");

        bundle=new Bundle();
        Text=getArguments().getString("text");
       // temp=Text.replace(oldText,newText);
        btn1=(Button)view.findViewById(R.id.aguidedimageryexercise);
        btn2=(Button)view.findViewById(R.id.ameditationexercise);
        btn3=(Button)view.findViewById(R.id.arelaxationexercise);
        btn4=(Button)view.findViewById(R.id.adeepbreathingexercise);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.aguidedimageryexercise:
                if (Text.contains("roleplayed"))
                {
                    bundle.putString("text",doer+" roleplayed "+btn1.getText().toString()+" with the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                else
                if (Text.contains(" what "))
                {
                    bundle.putString("text",doer+" role modeled "+btn1.getText().toString()+" to the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    newText=btn1.getText().toString()+".";
                    temp=Text.replace(oldText,newText);
                    bundle.putString("text",temp);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.ameditationexercise:
                if (Text.contains("roleplayed"))
                {
                    bundle.putString("text",doer+" roleplayed "+btn2.getText().toString()+" with the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                else
                if (Text.contains(" what "))
                {
                    bundle.putString("text",doer+" role modeled "+btn2.getText().toString()+" to the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    newText=btn2.getText().toString()+".";
                    temp=Text.replace(oldText,newText);
                    bundle.putString("text",temp);
                    Fragment fragment2=new Fragment2k3e();
                    fragment2.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment2).addToBackStack("abc").commit();
                }

                break;

            case R.id.arelaxationexercise:
                if (Text.contains("roleplayed"))
                {
                    bundle.putString("text",doer+" roleplayed "+btn3.getText().toString()+" with the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                else
                if (Text.contains(" what "))
                {
                    bundle.putString("text",doer+" role modeled "+btn3.getText().toString()+" to the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    newText=btn3.getText().toString()+".";
                    temp=Text.replace(oldText,newText);
                    bundle.putString("text",temp);
                    Fragment fragment3=new Fragment2k3e();
                    fragment3.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment3).addToBackStack("abc").commit();
                }

                break;
            case R.id.adeepbreathingexercise:
                if (Text.contains("roleplayed"))
                {
                    bundle.putString("text",doer+" roleplayed "+btn4.getText().toString()+" with the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                else
                if (Text.contains(" what "))
                {
                    bundle.putString("text",doer+" role modeled "+btn4.getText().toString()+" to the "+interventionSubject);
                    fragment=new Fragment2k3e();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    newText=btn4.getText().toString()+".";
                    temp=Text.replace(oldText,newText);
                    bundle.putString("text",temp);
                    Fragment fragment4=new Fragment2k3e();
                    fragment4.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment4).addToBackStack("abc").commit();
                }

                break;

            default:
                break;
        }
    }
}
