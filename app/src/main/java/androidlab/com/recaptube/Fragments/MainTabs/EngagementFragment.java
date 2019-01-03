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

public class EngagementFragment extends Fragment implements View.OnClickListener{

    Button directedattention, engaged, builtrapport, rolemodeled, roleplayed, redirected;
    String Text,clientId,thirdString;
    Bundle bundle;
    String whichTab="eng";
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_engagement, container, false);

        bundle=new Bundle();

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clientId=sharedPreferences.getString("clientId","");
        Text=getArguments().getString("text");

        directedattention=(Button)view.findViewById(R.id.directedattentionEng);
        engaged=(Button)view.findViewById(R.id.engagedEng);
        builtrapport=(Button)view.findViewById(R.id.builtrapportEng);
        rolemodeled=(Button)view.findViewById(R.id.rolemodeledEng);
        roleplayed=(Button)view.findViewById(R.id.roleplayedEng);
        redirected=(Button)view.findViewById(R.id.redirectedEng);

        directedattention.setOnClickListener(this);
        engaged.setOnClickListener(this);
        builtrapport.setOnClickListener(this);
        rolemodeled.setOnClickListener(this);
        roleplayed.setOnClickListener(this);
        redirected.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.directedattentionEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="directed whose attention?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.engagedEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment=new Intervention2k3c();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="engaged who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.builtrapportEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="built rapport with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.rolemodeledEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="role modeled to who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.roleplayedEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="roleplayed with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.redirectedEng:
                if (Text.contains("directed whose attention?")      || Text.contains("engaged who?")
                        || Text.contains("built rapport with who?") || Text.contains("role modeled to who?")
                        || Text.contains("roleplayed with who?")    || Text.contains("redirected who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString = "redirected who?";
                    fragment = new Intervention2k3c();
                    bundle.putString("text", thirdString);
                    bundle.putString("text2", Text);
                    editor.putString("dis", whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("abc").commit();
                }

                break;





            default:
                break;
        }
    }
}
