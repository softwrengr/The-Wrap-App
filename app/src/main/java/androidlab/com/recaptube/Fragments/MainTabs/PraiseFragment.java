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

public class PraiseFragment extends Fragment implements View.OnClickListener{

    Button congraulated,reinforement,acknowledge,incentive,gather_information,
            inquired,informed,reviewed,used_active_listening,usedOpenEndedQuestion;
    String Text,clientId,thirdString;
    String whichTab="praise";
    Bundle bundle;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_praise, container, false);

        bundle=new Bundle();

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clientId=sharedPreferences.getString("clientId","");
        Text=getArguments().getString("text");
        congraulated=(Button)view.findViewById(R.id.congratulated);
        incentive=(Button)view.findViewById(R.id.incentive);
        acknowledge=(Button)view.findViewById(R.id.acknowledge);
        reinforement=(Button)view.findViewById(R.id.reinforcement);

        congraulated.setOnClickListener(this);
        incentive.setOnClickListener(this);
        acknowledge.setOnClickListener(this);
        reinforement.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.congratulated:
                if (Text.contains("congratulated who?")|| Text.contains("employed positive reinforcements to who?")
                        || Text.contains("acknowledged who?")
                        || Text.contains("provided an incentive to who?"))
                {
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment=new Intervention2k3c();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="congratulated who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.reinforcement:
                if (Text.contains("congratulated who?")|| Text.contains("employed positive reinforcements to who?")
                        || Text.contains("acknowledged who?")
                        || Text.contains("provided an incentive to who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="employed positive reinforcements to who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.acknowledge:

                if (Text.contains("congratulated who?")|| Text.contains("employed positive reinforcements to who?")
                        || Text.contains("acknowledged who?")
                        || Text.contains("provided an incentive to who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="acknowledged who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.incentive:
                if (Text.contains("congratulated who?")|| Text.contains("employed positive reinforcements to who?")
                        || Text.contains("acknowledged who?")
                        || Text.contains("provided an incentive to who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="provided an incentive to who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
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
