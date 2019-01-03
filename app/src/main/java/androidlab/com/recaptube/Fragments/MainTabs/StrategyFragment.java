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


public class StrategyFragment extends Fragment implements View.OnClickListener {

    Button brainstormed,developed,explored,identified,outlined,reviewed,strategized,suggested,recommended;
    String Text,thirdString;
    String which="strategy";
    Fragment fragment;
    Bundle bundle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_strategy, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        Text=getArguments().getString("text");
        brainstormed=(Button)view.findViewById(R.id.brainstormed);
        developed=(Button)view.findViewById(R.id.developed);
        explored=(Button)view.findViewById(R.id.explored);
        identified=(Button)view.findViewById(R.id.identified);
        outlined=(Button)view.findViewById(R.id.outlined);
        reviewed=(Button)view.findViewById(R.id.reviewed);
        strategized=(Button)view.findViewById(R.id.strategized);
        suggested=(Button)view.findViewById(R.id.suggested);
        recommended=(Button)view.findViewById(R.id.recommended);

        brainstormed.setOnClickListener(this);
        developed.setOnClickListener(this);
        explored.setOnClickListener(this);
        identified.setOnClickListener(this);
        developed.setOnClickListener(this);
        outlined.setOnClickListener(this);
        reviewed.setOnClickListener(this);
        strategized.setOnClickListener(this);
        suggested.setOnClickListener(this);
        recommended.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.brainstormed:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",which).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="brainstormed with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.developed:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    bundle.putString("text",Text);
                    editor.putString("dis",which).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString= "developed with who?";
                    fragment=new Intervention2k3c();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    editor.putString("dis",which).commit();
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.explored:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString= "explored with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.identified:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="identified with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.outlined:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString= "outlined with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.reviewed:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString="reviewed with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.strategized:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                else {
                    thirdString= "strategized with who?";
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",thirdString);
                    bundle.putString("text2",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }

                break;
            case R.id.suggested:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                thirdString="suggested to who?";
                fragment=new Intervention2k3c();
                editor.putString("dis",which).commit();
                bundle.putString("text",thirdString);
                bundle.putString("text2",Text);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                break;
            case R.id.recommended:
                if (Text.contains("brainstormed with who?")||Text.contains("developed with who?")||Text.contains("explored with who?")
                        ||Text.contains("identified with who?") ||Text.contains("outlined with who?")
                        ||Text.contains("reviewed with who?")||Text.contains("strategized with who?")
                        ||Text.contains("suggested to who?")|| Text.contains("recommended to who?"))
                {
                    fragment=new Intervention2k3c();
                    editor.putString("dis",which).commit();
                    bundle.putString("text",Text);
                    fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                }
                thirdString="recommended to who?";
                fragment=new Intervention2k3c();
                editor.putString("dis",which).commit();
                bundle.putString("text",thirdString);
                bundle.putString("text2",Text);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                break;
                default:
                    break;
        }
    }
}
