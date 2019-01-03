package androidlab.com.recaptube.Fragments.MainTabs;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidlab.com.recaptube.Fragments.Intervention2k3c;
import androidlab.com.recaptube.R;


public class FragmentDiscussion extends Fragment implements View.OnClickListener {

    Button briefed,discussed,explained,highlighted,gather_information,
            inquired,informed,reviewed,used_active_listening,usedOpenEndedQuestion;
    String Text,clientId,thirdString,whichTab;
    Bundle bundle;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fragment_discussion, container, false);

        bundle=new Bundle();

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clientId=sharedPreferences.getString("clientId","");
        Text=getArguments().getString("text");
        briefed=(Button)view.findViewById(R.id.briefed);
        discussed=(Button)view.findViewById(R.id.discussed);
        explained=(Button)view.findViewById(R.id.explained);
        highlighted=(Button)view.findViewById(R.id.highlighted);
        gather_information=(Button)view.findViewById(R.id.gather_information);
        inquired=(Button)view.findViewById(R.id.inquired);
        informed=(Button)view.findViewById(R.id.informed);
        reviewed=(Button)view.findViewById(R.id.reviewed);
        used_active_listening=(Button)view.findViewById(R.id.used_active_listening);
        usedOpenEndedQuestion=(Button)view.findViewById(R.id.usedOpenEndedQuestion);

        briefed.setOnClickListener(this);
        discussed.setOnClickListener(this);
        explained.setOnClickListener(this);
        highlighted.setOnClickListener(this);
        gather_information.setOnClickListener(this);
        inquired.setOnClickListener(this);
        informed.setOnClickListener(this);
        reviewed.setOnClickListener(this);
        used_active_listening.setOnClickListener(this);
        usedOpenEndedQuestion.setOnClickListener(this);

        return  view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.briefed:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment=new Intervention2k3c();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="briefed who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.explained:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="explained to who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.inquired:

                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="inquired who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.informed:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="informed who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.used_active_listening:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="used active listening with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.usedOpenEndedQuestion:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="used open ended questions with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.highlighted:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="highlighted to who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.gather_information:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="gathered information from who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.reviewed:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="reviewed with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.discussed:
                if (Text.contains("briefed who?") || Text.contains("explained to who?") || Text.contains("inquired who?")
                        || Text.contains("informed who?") || Text.contains("used active listening with who?")
                        || Text.contains("used open ended questions with who?") || Text.contains("highlighted to who?")
                        || Text.contains("gathered information from who?") || Text.contains("reviewed with who?")
                        || Text.contains("discussed with who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="discussed with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    whichTab="discussion";
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            default:
                break;
        }
    }
}
