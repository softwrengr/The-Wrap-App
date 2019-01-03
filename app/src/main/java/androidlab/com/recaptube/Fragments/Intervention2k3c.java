package androidlab.com.recaptube.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidlab.com.recaptube.Fragments.DiscussionTabs.DiscussionTablayoutFragment;
import androidlab.com.recaptube.Fragments.EngagementTabs.EngagementTablayout;
import androidlab.com.recaptube.Fragments.PraiseTabs.PraiseTablayoutFragment;
import androidlab.com.recaptube.Fragments.StrategyTabs.strategyTabLayoutFragments;
import androidlab.com.recaptube.Fragments.SupportTabs.supportTabLayout;
import androidlab.com.recaptube.R;


public class Intervention2k3c extends Fragment implements View.OnClickListener {

    String Text,secondText;
    TextView textView;
    android.support.v7.app.AlertDialog alertDialog;
    String clientId,which,Doer;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    String getBtn1,getBtn2,getBtn3,getBtn4,getBtn5,getBtn6,getBtn7,btnclient,btnfamily;
    int number=0;
    Button no1,no2,no3,no4,no5,no6,no7,family, client;
     String[] strArray;
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_intervention2k3c, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Doer=sharedPreferences.getString("doer","");
        bundle=new Bundle();
        Text=getArguments().getString("text");
        secondText=getArguments().getString("text2");
        clientId=sharedPreferences.getString("clientId","");
        textView=(TextView)view.findViewById(R.id.textPreview2K3c);
        if (secondText!=null) {

            textView.setText(secondText + Text);
        }
        else
        {
            textView.setText(Text);
        }


        family =(Button)view.findViewById(R.id.family);
        client = (Button)view.findViewById(R.id.client);
        no1 = (Button)view.findViewById(R.id.btn1);
        no2 =(Button)view. findViewById(R.id.btn2);
        no3 =(Button)view. findViewById(R.id.btn3);
        no4 = (Button)view.findViewById(R.id.btn4);
        no5 =(Button)view. findViewById(R.id.btn5);
        no6 =(Button)view. findViewById(R.id.btn6);
        no7 =(Button)view. findViewById(R.id.btn7);


        getBtn1=sharedPreferences.getString(clientId+" btn1","");
        getBtn2=sharedPreferences.getString(clientId+" btn2","");
        getBtn3=sharedPreferences.getString(clientId+" btn3","");
        getBtn4=sharedPreferences.getString(clientId+" btn4","");
        getBtn5=sharedPreferences.getString(clientId+" btn5","");
        getBtn6=sharedPreferences.getString(clientId+" btn6","");
        getBtn7=sharedPreferences.getString(clientId+" btn7","");


        no1.setOnClickListener(this);
        no2.setOnClickListener(this);
        no3.setOnClickListener(this);
        no4.setOnClickListener(this);
        no5.setOnClickListener(this);
        no6.setOnClickListener(this);
        no7.setOnClickListener(this);
        family.setOnClickListener(this);
        client.setOnClickListener(this);




        if(!getBtn1.equals(""))
        {
            no1.setVisibility(View.VISIBLE);
            no1.setText(getBtn1);
            number++;
        }
        if (!getBtn2.equals(""))
        {
            no2.setVisibility(View.VISIBLE);
            no2.setText(getBtn2);
            number++;
        }
        if (!getBtn3.equals(""))
        {
            no3.setVisibility(View.VISIBLE);
            no3.setText(getBtn3);
            number++;
        }
        if (!getBtn4.equals(""))
        {
            no4.setVisibility(View.VISIBLE);
            no4.setText(getBtn4);
            number++;
        }
        if (!getBtn5.equals(""))
        {
            no5.setVisibility(View.VISIBLE);
            no5.setText(getBtn5);
            number++;
        }
        if (!getBtn6.equals(""))
        {
            no6.setVisibility(View.VISIBLE);
            no6.setText(getBtn6);
            number++;
        }
        if (!getBtn7.equals(""))
        {
            no7.setVisibility(View.VISIBLE);
            no7.setText(getBtn7);
            number++;
        }

        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.btn1:
                editor.putString("subject",getBtn1).commit();
                String temp1=secondText+ "and the " +getBtn1+ " " +Text;
                which=sharedPreferences.getString("dis","");
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn1+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn1+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn1+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn1+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn1+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn1+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn1+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn1+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn1+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn1+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn1+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " " +returnText+getBtn1+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " " +returnText+getBtn1+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp1.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp1.replace(oldText,newText);
                    temp1=returnText;
                    textView.setText(temp1);

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn1+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn1+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                    else
                    if (temp1.contains("gathered information from who"))
                    {
                        String oldText="gathered information from who";
                        String newText="gathered information regarding";
                        String returnText=temp1.replace(oldText,newText);
                        temp1=returnText;
                        textView.setText(temp1);
                        which=sharedPreferences.getString("dis","");
                        if (which.equals("discussion"))
                        {
                            Fragment fragment=new DiscussionTablayoutFragment();
                            bundle.putString("text",Doer+" gathered what information from the " +getBtn1+"?");
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();;
                        }
                    }
                    else
                    if (temp1.contains("informed who"))
                    {
                        String oldText="informed who";
                        String newText="what";
                        String returnText=temp1.replace(oldText,newText);
                        temp1=returnText;
                        textView.setText(temp1);

                        which=sharedPreferences.getString("dis","");
                        if (which.equals("discussion"))
                        {
                            Fragment fragment=new DiscussionTablayoutFragment();
                            bundle.putString("text",Doer+" informed the "+getBtn1+" about what?");
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                    }
                    else
                    if (temp1.contains("inquired who"))
                    {
                        String oldText="inquired who";
                        String newText="what";
                        String returnText=temp1.replace(oldText,newText);
                        temp1=returnText;
                        textView.setText(temp1);

                        which=sharedPreferences.getString("dis","");
                        if (which.equals("discussion"))
                        {
                            Fragment fragment=new DiscussionTablayoutFragment();
                            bundle.putString("text",Doer+" inquired the "+getBtn1+" about what?");
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                    }
                    else
                    if (temp1.contains("who"))
                    {
                        String oldText="who";
                        String newText="what";
                        String returnText=temp1.replace(oldText,newText);
                        temp1=returnText;
                        textView.setText(temp1);
                        which=sharedPreferences.getString("dis","");
                        if (which.equals("discussion"))
                        {
                            Fragment fragment=new DiscussionTablayoutFragment();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else
                        if (which.equals("strategy"))
                        {
                            Fragment fragment=new strategyTabLayoutFragments();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("praise"))
                        {
                            Fragment fragment=new PraiseTablayoutFragment();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("eng"))
                        {
                            Fragment fragment=new EngagementTablayout();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("sup"))
                        {
                            Fragment fragment=new supportTabLayout();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                    }

                break;
            case R.id.btn2:
                editor.putString("subject",getBtn2).commit();
                String temp2=secondText+ "and the " +getBtn2+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn2+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn2+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn2+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn2+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn2+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn2+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn2+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn2+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn2+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn2+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp2.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp2.replace(oldText,newText);
                    temp2=returnText;
                    textView.setText(temp2);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp2.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp2.replace(oldText,newText);
                    temp2=returnText;
                    textView.setText(temp2);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the " +getBtn2+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp2.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp2.replace(oldText,newText);
                    temp2=returnText;
                    textView.setText(temp2);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn2+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp2.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp2.replace(oldText,newText);
                    temp2=returnText;
                    textView.setText(temp2);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn2+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp2.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp2.replace(oldText,newText);
                    temp2=returnText;
                    textView.setText(temp2);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }

                break;
            case R.id.btn3:
                editor.putString("subject",getBtn3).commit();
                String temp=secondText+ "and the " +getBtn3+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn3+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn3+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn3+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn3+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn3+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn3+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn3+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn3+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn3+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn3+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp.contains("with who")) {
                    String oldText = "with who";
                    String newText = "what";
                    String returnText = temp.replace(oldText, newText);
                    temp = returnText;
                    textView.setText(temp);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }  else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp.replace(oldText,newText);
                    temp=returnText;
                    textView.setText(temp);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the " +getBtn3+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp.replace(oldText,newText);
                    temp=returnText;
                    textView.setText(temp);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn1+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp.replace(oldText,newText);
                    temp=returnText;
                    textView.setText(temp);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn3+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp.contains("who")) {
                    String oldText = "who";
                    String newText = "what";
                    String returnText = temp.replace(oldText, newText);
                    temp = returnText;
                    textView.setText(temp);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }  else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
            case R.id.btn4:
                editor.putString("subject",getBtn4).commit();
                String temp4=secondText+ "and the " +getBtn4+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn4+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn4+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn4+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn4+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn4+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn4+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn4+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn4+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn4+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp4.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp4.replace(oldText,newText);
                    temp4=returnText;
                    textView.setText(temp4);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                } else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn4+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }

                else
                if (temp4.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp4.replace(oldText,newText);
                    temp4=returnText;
                    textView.setText(temp4);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the " +getBtn4+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp4.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp4.replace(oldText,newText);
                    temp4=returnText;
                    textView.setText(temp4);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn4+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp4.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp4.replace(oldText,newText);
                    temp4=returnText;
                    textView.setText(temp4);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn4+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp4.contains("from who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp4.replace(oldText,newText);
                    temp4=returnText;
                    textView.setText(temp4);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
            case R.id.btn5:
                editor.putString("subject",getBtn5).commit();
                String temp5=secondText+ "and the " +getBtn5+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn5+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn5+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn5+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn5+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn5+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn5+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn5+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn5+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn5+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn5+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp5.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp5.replace(oldText,newText);
                    temp5=returnText;
                    textView.setText(temp5);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp5.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp5.replace(oldText,newText);
                    temp5=returnText;
                    textView.setText(temp5);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the " +getBtn5+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp5.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp5.replace(oldText,newText);
                    temp5=returnText;
                    textView.setText(temp5);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn5+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp5.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp5.replace(oldText,newText);
                    temp5=returnText;
                    textView.setText(temp5);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn5+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp5.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp5.replace(oldText,newText);
                    temp5=returnText;
                    textView.setText(temp5);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
            case R.id.btn6:
                editor.putString("subject",getBtn6).commit();
                String temp6=secondText+ "and the " +getBtn6+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn6+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn6+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn6+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn6+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn6+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn6+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn6+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn6+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn6+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn6+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp6.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp6.replace(oldText,newText);
                    temp6=returnText;
                    textView.setText(temp6);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }

                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp6.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp6.replace(oldText,newText);
                    temp6=returnText;
                    textView.setText(temp6);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the "+getBtn6+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp6.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp6.replace(oldText,newText);
                    temp6=returnText;
                    textView.setText(temp6);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn6+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp6.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp6.replace(oldText,newText);
                    temp6=returnText;
                    textView.setText(temp6);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn6+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp6.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp6.replace(oldText,newText);
                    temp6=returnText;
                    textView.setText(temp6);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
            case R.id.btn7:
                editor.putString("subject",getBtn7).commit();
                String temp7=secondText+ "and the " +getBtn7+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+getBtn7+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+getBtn7+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+getBtn7+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+getBtn7+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+getBtn7+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+getBtn7+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+getBtn7+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn7+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+getBtn7+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+getBtn7+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp7.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp7.replace(oldText,newText);
                    temp7=returnText;
                    textView.setText(temp7);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp7.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp7.replace(oldText,newText);
                    temp7=returnText;
                    textView.setText(temp7);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the "+getBtn7+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp7.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp7.replace(oldText,newText);
                    temp7=returnText;
                    textView.setText(temp7);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+getBtn7+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp7.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp7.replace(oldText,newText);
                    temp7=returnText;
                    textView.setText(temp7);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+getBtn7+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp7.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp7.replace(oldText,newText);
                    temp7=returnText;
                    textView.setText(temp7);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
            case R.id.family:
                editor.putString("subject",family.getText().toString()).commit();
                String temp8=secondText+ "and the " +family.getText()+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+family.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+family.getText()+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+family.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+family.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+family.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+family.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+family.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+family.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+family.getText()+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+family.getText()+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+family.getText()+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+family.getText()+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+family.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp8.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp8.replace(oldText,newText);
                    temp8=returnText;
                    textView.setText(temp8);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                        if (which.equals("strategy"))
                        {
                            Fragment fragment=new strategyTabLayoutFragments();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);

                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("praise"))
                        {
                            Fragment fragment=new PraiseTablayoutFragment();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("eng"))
                        {
                            Fragment fragment=new EngagementTablayout();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                        else if (which.equals("sup"))
                        {
                            Fragment fragment=new supportTabLayout();
                            bundle.putString("text",textView.getText().toString());
                            fragment.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                        }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+family.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+family.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp8.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp8.replace(oldText,newText);
                    temp8=returnText;
                    textView.setText(temp8);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the"+" " +family.getText().toString()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp8.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp8.replace(oldText,newText);
                    temp8=returnText;
                    textView.setText(temp8);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+family.getText()+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp8.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp8.replace(oldText,newText);
                    temp8=returnText;
                    textView.setText(temp8);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+family.getText()+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp8.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp8.replace(oldText,newText);
                    temp8=returnText;
                    textView.setText(temp8);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);

                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }

                break;
            case R.id.client:
                editor.putString("subject",client.getText().toString()).commit();
                String temp9=secondText+ "and the " +client.getText()+ " " +Text;
                if (Text.contains("explained to who?"))
                {
                    String oldText="The";
                    String newText="the";
                    String returnText=secondText.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text","What did "+returnText+"explained to the "+client.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("motivated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" motivated the "+client.getText()+" to do what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("advocated for who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" advocated for the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("empathized with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" empathized with the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("encouraged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" encouraged the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("assisted who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" assisted the "+client.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("helped who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",Doer+" helped the "+client.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("provided an incentive to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" provided an incentive to the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("acknowledged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" acknowledged the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("employed positive reinforcements to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" employed positive reinforcements to the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("congratulated who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",Doer+" congratulated the "+client.getText()+" for what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("redirected who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" redirected the "+client.getText()+" to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("roleplayed with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" roleplayed what with the "+client.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("role modeled to who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" role modeled what to the "+client.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("built rapport with who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" built report with the "+client.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("directed whose attention?"))
                {
                    String oldText="directed whose attention?";
                    String newText=" directed the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+returnText+client.getText()+"'s attention to what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used open ended questions with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+client.getText()+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("used active listening with who?"))
                {
                    String oldText="who?";
                    String newText="the ";
                    String returnText=Text.replace(oldText,newText);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+ " "+returnText+client.getText()+" when discussing what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("with who"))
                {
                    String oldText="with who";
                    String newText="what";
                    String returnText=temp9.replace(oldText,newText);
                    temp9=returnText;
                    textView.setText(temp9);

                    which=sharedPreferences.getString("dis","");

                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("suggested to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" suggested what to the "+client.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("recommended to who?"))
                {
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",Doer+" recommended what to the "+client.getText()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("gathered information from who"))
                {
                    String oldText="gathered information from who";
                    String newText="gathered what information from";
                    String returnText=temp9.replace(oldText,newText);
                    textView.setText(returnText);
                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" gathered what information from the " +client.getText().toString()+"?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("informed who"))
                {
                    String oldText="informed who";
                    String newText="what";
                    String returnText=temp9.replace(oldText,newText);
                    temp9=returnText;
                    textView.setText(temp9);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" informed the "+client.getText()+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (Text.contains("engaged who?"))
                {

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",Doer+" engaged the "+client.getText()+" with what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("inquired who"))
                {
                    String oldText="inquired who";
                    String newText="what";
                    String returnText=temp9.replace(oldText,newText);
                    temp9=returnText;
                    textView.setText(temp9);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",Doer+" inquired the "+client.getText()+" about what?");
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("who"))
                {
                    String oldText="who";
                    String newText="what";
                    String returnText=temp9.replace(oldText,newText);
                    temp9=returnText;
                    textView.setText(temp9);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                else
                if (temp9.contains("to who"))
                {
                    String oldText="to who";
                    String newText="what";
                    String returnText=temp9.replace(oldText,newText);
                    temp9=returnText;
                    textView.setText(temp9);

                    which=sharedPreferences.getString("dis","");
                    if (which.equals("discussion"))
                    {
                        Fragment fragment=new DiscussionTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else
                    if (which.equals("strategy"))
                    {
                        Fragment fragment=new strategyTabLayoutFragments();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("praise"))
                    {
                        Fragment fragment=new PraiseTablayoutFragment();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("eng"))
                    {
                        Fragment fragment=new EngagementTablayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                    else if (which.equals("sup"))
                    {
                        Fragment fragment=new supportTabLayout();
                        bundle.putString("text",textView.getText().toString());
                        fragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                    }
                }
                break;
                default:
                    break;

        }
    }
}
