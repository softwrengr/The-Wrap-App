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

public class NeutralFragment extends Fragment implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5;
    String Text,InterventionSubject,thirdString;
    Bundle bundle;
    String finalText;
    String oldText="The";
    String newText="the";
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_neutral, container, false);


        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        InterventionSubject=sharedPreferences.getString("subject","");
        Text=getArguments().getString("text");
        finalText=Text.replace(oldText,newText);

        btn1=(Button)view.findViewById(R.id.listenedquietly);
        btn2=(Button)view.findViewById(R.id.madeeyecontact);
        btn3=(Button)view.findViewById(R.id.negotiated);
        btn4=(Button)view.findViewById(R.id.nodded);
        btn5=(Button)view.findViewById(R.id.participated);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {case R.id.listenedquietly:
            if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                    || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) )
            {
                bundle.putString("text",Text);
                fragment=new Fragment2k3f();
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
            }
            else
            {
                thirdString="The "+InterventionSubject+ " " +btn1.getText()+ " when " +finalText;
                fragment=new Fragment2k3f();
                bundle.putString("text",thirdString);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
            }

            break;
            case R.id.madeeyecontact:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn2.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.negotiated:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn3.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.nodded:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn4.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.participated:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {

                    Text="The "+InterventionSubject+ " " +btn5.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;

            default:
                break;
        }
    }
}
