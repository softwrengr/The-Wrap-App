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


public class SupportFragment extends Fragment implements View.OnClickListener {
    Button advocated,assisted,empathized,encouraged,
            helped,motivated,offered,problem_solved,prompted,provided,reminded,supported,offeredSupport,validated;
    String Text,clientId,thirdString,Doer;
    String whichTab="sup";
    Bundle bundle;
    Fragment fragment;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_support, container, false);

        bundle=new Bundle();

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clientId=sharedPreferences.getString("clientId","");
        Text=getArguments().getString("text");
        advocated=(Button)view.findViewById(R.id.advocated);
        assisted=(Button)view.findViewById(R.id.assisted);
        empathized=(Button)view.findViewById(R.id.emathized);
        encouraged=(Button)view.findViewById(R.id.encouraged);
        helped=(Button)view.findViewById(R.id.helped);
        motivated=(Button)view.findViewById(R.id.motivated);
        offered=(Button)view.findViewById(R.id.offered);
        offeredSupport=(Button)view.findViewById(R.id.offered_support);
        problem_solved=(Button)view.findViewById(R.id.problem_solved);
        prompted=(Button)view.findViewById(R.id.promoted);
        provided=(Button)view.findViewById(R.id.provided_supportive_presence);
        reminded=(Button)view.findViewById(R.id.reminded);
        supported=(Button)view.findViewById(R.id.supported);
        validated=(Button)view.findViewById(R.id.validated);

        validated.setOnClickListener(this);
        supported.setOnClickListener(this);
        reminded.setOnClickListener(this);
        provided.setOnClickListener(this);
        prompted.setOnClickListener(this);
        problem_solved.setOnClickListener(this);
        offeredSupport.setOnClickListener(this);
        offered.setOnClickListener(this);
        motivated.setOnClickListener(this);
        helped.setOnClickListener(this);
        encouraged.setOnClickListener(this);
        empathized.setOnClickListener(this);
        assisted.setOnClickListener(this);
        advocated.setOnClickListener(this);

        return view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.motivated:
                if ( Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="motivated who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.advocated:
                if ( Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="advocated for who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.emathized:
                if ( Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="empathized with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.encouraged:
                if ( Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="encouraged who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.assisted:
                if (Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="assisted who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.helped:
                if (Text.contains("motivated who?")
                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else
                {
                    thirdString="helped who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",whichTab).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
//            case R.id.validated:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment=new Intervention2k3c();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else
//                {
//                    thirdString="validated who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//
//                break;
//            case R.id.problem_solved:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else
//                {
//                    thirdString="problem solved with who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//
//                break;
//            case R.id.promoted:
//
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else {
//                    thirdString="promoted who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }

         //       break;

//            case R.id.offered:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else {
//                    thirdString="offered who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
////                }
//
////                break;
//            case R.id.offered_support:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else {
//                    thirdString="offered support to who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//
//                break;

//            case R.id.supported:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else
//                {
//                    thirdString="supported who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }

            //    break;
//            case R.id.provided_supportive_presence:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else
//                {
//                    thirdString="provided supportive presence to who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//
//                break;

//            case R.id.reminded:
//                if (Text.contains("reminded who?")|| Text.contains("validated who?")
//                        || Text.contains("offered support to who?")
//                        || Text.contains("supported who?")|| Text.contains("provided supportive presence to who?")
//                        || Text.contains("prompted who?")|| Text.contains("problem solved with who?")
//                        || Text.contains("offered who?")|| Text.contains("motivated who?")
//                        || Text.contains("helped who?")||Text.contains("encouraged who?")||Text.contains("empathized with who?")
//                        || Text.contains("assisted who?") || Text.contains("advocated for who?"))
//                {
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//                else
//                {
//                    thirdString="reminded who?";
//                    fragment=new Intervention2k3c();
//                    bundle.putString("text",thirdString);
//                    bundle.putString("text2",Text);
//                    editor.putString("dis",whichTab).commit();
//                    fragment.setArguments(bundle);
//                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
//                }
//
//                break;
            default:
                break;
        }
    }
}
