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


public class NegativeFragment extends Fragment implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13;
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
        View view =inflater.inflate(R.layout.fragment_negative, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        InterventionSubject=sharedPreferences.getString("subject","");
        Text=getArguments().getString("text");
        finalText=Text.replace(oldText,newText);

        btn1=(Button)view.findViewById(R.id.didntrespond);
        btn2=(Button)view.findViewById(R.id.disagreed);
        btn3=(Button)view.findViewById(R.id.madelittleeyecontact);
        btn4=(Button)view.findViewById(R.id.providedlimitedresponse);
        btn5=(Button)view.findViewById(R.id.respondedinappropriately);
        btn6=(Button)view.findViewById(R.id.refused);
        btn7=(Button)view.findViewById(R.id.unsuccessfullyengaged);
        btn8=(Button)view.findViewById(R.id.wasguarded);
        btn9=(Button)view.findViewById(R.id.washostile);
        btn10=(Button)view.findViewById(R.id.wasnonreceptive);
        btn11=(Button)view.findViewById(R.id.wasreserved);
        btn12=(Button)view.findViewById(R.id.wasuninterested);
        btn13=(Button)view.findViewById(R.id.waswithdrawn);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.didntrespond:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
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
            case R.id.disagreed:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
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
            case R.id.madelittleeyecontact:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
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
            case R.id.providedlimitedresponse:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
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
            case R.id.respondedinappropriately:
                if(Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
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
            case R.id.refused:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn6.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.unsuccessfullyengaged:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn7.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.wasguarded:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn8.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.washostile:
                if(Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn9.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.wasnonreceptive:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn10.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.wasreserved:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn11.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.wasuninterested:
                if(Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn12.getText()+ " when " +finalText;
                    fragment=new Fragment2k3f();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.waswithdrawn:
                if (Text.contains(btn1.getText()) || Text.contains(btn2.getText())|| Text.contains(btn3.getText())
                        || Text.contains(btn4.getText()) || Text.contains(btn5.getText()) || Text.contains(btn6.getText())
                        || Text.contains(btn7.getText()) || Text.contains(btn8.getText()) || Text.contains(btn9.getText())
                        || Text.contains(btn10.getText()) || Text.contains(btn11.getText()) || Text.contains(btn12.getText())
                        || Text.contains(btn13.getText()) )
                {
                    bundle.putString("text",Text);
                    fragment=new Fragment2k3f();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    Text="The "+InterventionSubject+ " " +btn13.getText()+ " when " +finalText;
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
