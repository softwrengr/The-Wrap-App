package androidlab.com.recaptube.Fragments.SupportTabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidlab.com.recaptube.Fragments.Fragment2k3eTabs.Fragment2k3e;
import androidlab.com.recaptube.R;


public class supportResourcesFragment extends Fragment implements View.OnClickListener{


    Button btn1,btn2,btn3,btn4,btn5;
    String Text,thirdString;
    Fragment fragment;
    Bundle bundle;
    String oldText="what?";
    String newText;
    String temp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_support_resources, container, false);


        bundle=new Bundle();
        Text=getArguments().getString("text");
        btn1=(Button)view.findViewById(R.id.aflyerwithinformation);
        btn2=(Button)view.findViewById(R.id.apamphletwithinformation);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);


        return view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.aflyerwithinformation:
                newText=btn1.getText().toString()+".";
                temp=Text.replace(oldText,newText);
                bundle.putString("text",temp);
                fragment=new Fragment2k3e();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                break;
            case R.id.apamphletwithinformation:
                newText=btn2.getText().toString()+".";
                temp=Text.replace(oldText,newText);
                bundle.putString("text",temp);
                fragment=new Fragment2k3e();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                break;

            default:
                break;
        }
    }

}
