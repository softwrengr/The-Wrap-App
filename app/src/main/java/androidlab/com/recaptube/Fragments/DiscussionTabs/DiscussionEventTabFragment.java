package androidlab.com.recaptube.Fragments.DiscussionTabs;

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


public class DiscussionEventTabFragment extends Fragment implements View.OnClickListener {

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
        View view= inflater.inflate(R.layout.fragment_discussion_event_tab, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        doer=sharedPreferences.getString("doer","");
        interventionSubject=sharedPreferences.getString("subject","");
        bundle=new Bundle();
        Text=getArguments().getString("text");
        btn1=(Button)view.findViewById(R.id.anupcomingcourtdate);
        btn2=(Button)view.findViewById(R.id.eventssincethelastsession);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
     int id=v.getId();
     switch (id)
     {
         case R.id.anupcomingcourtdate:
             if (Text.contains(" what information "))
             {
                 String text1=" what information ";
                 String text2=" information regarding "+btn1.getText()+" ";
                 newText=".";
                 temp=Text.replace(text1,text2);
                 String text3="?";
                 String text4=".";
                 String finalText=temp.replace(text3,text4);
                 bundle.putString("text",finalText);
                 fragment=new Fragment2k3e();
                 fragment.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
             }
             else if (Text.contains("explained to "))
             {
                 bundle.putString("text",doer+" explained "+btn1.getText()+" to the "+interventionSubject+".");
                 fragment=new Fragment2k3e();
                 fragment.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
             }
             else {
                 newText=btn1.getText().toString();
                 temp=Text.replace(oldText,newText);
                 bundle.putString("text",temp+".");
                 fragment=new Fragment2k3e();
                 fragment.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
             }

             break;
         case R.id.eventssincethelastsession:
             if (Text.contains(" what information "))
             {
                 String text1=" what information ";
                 String text2=" information regarding "+btn2.getText()+" ";
                 newText=".";
                 temp=Text.replace(text1,text2);
                 String text3="?";
                 String text4=".";
                 String finalText=temp.replace(text3,text4);
                 bundle.putString("text",finalText);
                 fragment=new Fragment2k3e();
                 fragment.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
             }
             else if (Text.contains("explained to "))
             {
                 bundle.putString("text",doer+" explained "+btn2.getText()+" to the "+interventionSubject+".");
                 fragment=new Fragment2k3e();
                 fragment.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
             }
             else
             {
                 newText=btn2.getText().toString();
                 temp=Text.replace(oldText,newText);
                 bundle.putString("text",temp+".");
                 Fragment fragment2=new Fragment2k3e();
                 fragment2.setArguments(bundle);
                 getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment2).addToBackStack("abc").commit();

             }
              break;
             default:
                 break;
     }
    }
}
