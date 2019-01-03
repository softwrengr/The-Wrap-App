package androidlab.com.recaptube.Fragments.PraiseTabs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidlab.com.recaptube.Fragments.Fragment2k3eTabs.Fragment2k3e;
import androidlab.com.recaptube.R;


public class PraiseGoalStatusFragment extends Fragment implements View.OnClickListener{

    Button btn1,btn2,btn3;
    String Text,thirdString;
    String textTemp;
    Fragment fragment;
    Bundle bundle;
    String oldText="what?";
    String newText;
    String temp;
    String text2 ,text1, btnText;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    CharSequence[] items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_praise_goal_status, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        Text=getArguments().getString("text");
        thirdString=sharedPreferences.getString("goals","");
        btn1=(Button)view.findViewById(R.id.achievingagoal);
        btn2=(Button)view.findViewById(R.id.makingprogressonagoal);
        btn3=(Button)view.findViewById(R.id.puttingeffortonagoal);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.achievingagoal:
                    String[] GoalsArray = thirdString.split(",");
                    items = new CharSequence[GoalsArray.length+1];

                    for (int j = 0; j < GoalsArray.length; j++) {
                        btnText=btn1.getText().toString();
                        if (btnText.contains(" a "))
                        {
                            text1=" a ";
                            text2=" the ";
                            String text3=btnText.replace(text1,text2);
                            items[j] = text3+" to " + GoalsArray[j];

                        }
                    }
                text1=" a ";
                text2=" the ";
                textTemp=btnText.replace(text1,text2);
                    if (GoalsArray.length==1)
                    {
                        items[1]=textTemp+" to __________";
                    }
                    else
                        if (GoalsArray.length==2)
                        {
                            items[2]=textTemp+" to __________";
                        }
                        else
                            if (GoalsArray.length==3)
                            {
                                items[3]=textTemp+" to __________";
                            }
                            else
                                if (GoalsArray.length==4)
                                {
                                    items[4]=textTemp+" to __________";
                                }
                                else
                                    if (GoalsArray.length==5)
                                    {
                                        items[5]=textTemp+" to __________";
                                    }
                                    else
                                        if (GoalsArray.length==6)
                                        {
                                            items[6]=textTemp+" to __________";
                                        }
                    final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setTitle(Text);
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (items[which].equals(textTemp+" to __________"))
                            {
                                final EditText taskEditText = new EditText(getActivity());
                                taskEditText.setSingleLine();
                                taskEditText.setText(textTemp+" to ");
                                taskEditText.setSelection(taskEditText.length());
                                AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                        .setTitle(Text)
                                        .setView(taskEditText)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                String task = String.valueOf(taskEditText.getText());
                                                temp=Text.replace(oldText,task+".");
                                                bundle.putString("text",temp);
                                                fragment=new Fragment2k3e();
                                                fragment.setArguments(bundle);
                                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                                            }
                                        })
                                        .setNegativeButton("Cancel", null)
                                        .create();
                                alertDialogdialog.show();

                            }
                            else
                            if (items[which].equals(items[0])) {
                                newText = String.valueOf(items[0]);
                                String returnText = Text.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                            } else if (items[which].equals(items[1])) {
                                newText = String.valueOf(items[1]);
                                String returnText = Text.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                            } else if (items[which].equals(items[2])) {
                                newText = String.valueOf(items[2]);
                                String returnText = Text.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                            } else if (items[which].equals(items[3])) {
                                newText = String.valueOf(items[3]);
                                String returnText = temp.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                            } else if (items[which].equals(items[4])) {
                                newText = String.valueOf(items[4]);
                                String returnText = temp.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                            } else if (items[which].equals(items[5])) {

                                newText = String.valueOf(items[5]);
                                String returnText = temp.replace(oldText, newText);
                                temp = returnText;
                                bundle.putString("text", temp+".");
                                Fragment fragment2 = new Fragment2k3e();
                                fragment2.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                            }



                        }
                    });
                    builder.show();
                break;
            case R.id.makingprogressonagoal:
                String[] GoalsArray2 = thirdString.split(",");
                items = new CharSequence[GoalsArray2.length+1];
                for (int j = 0; j < GoalsArray2.length; j++) {
                    btnText=btn2.getText().toString();
                    if (btnText.contains(" a "))
                    {
                        text1=" a ";
                        text2=" the ";
                        String text3=btnText.replace(text1,text2);
                        items[j] = text3+" to " + GoalsArray2[j];

                    }
                }
                text1=" a ";
                text2=" the ";
                textTemp=btnText.replace(text1,text2);
                if (GoalsArray2.length==1)
                {
                    items[1]=textTemp+" to __________";
                }
                else
                if (GoalsArray2.length==2)
                {
                    items[2]=textTemp+" to __________";
                }
                else
                if (GoalsArray2.length==3)
                {
                    items[3]=textTemp+" to __________";
                }
                else
                if (GoalsArray2.length==4)
                {
                    items[4]=textTemp+" to __________";
                }
                else
                if (GoalsArray2.length==5)
                {
                    items[5]=textTemp+" to __________";
                }
                else
                if (GoalsArray2.length==6)
                {
                    items[6]=textTemp+" to __________";
                }
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setTitle(Text);
                builder2.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(textTemp+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(textTemp+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task+".");
                                            bundle.putString("text",temp);
                                            fragment=new Fragment2k3e();
                                            fragment.setArguments(bundle);
                                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();

                        }
                        else
                        if (items[which].equals(items[0])) {
                            newText = String.valueOf(items[0]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }


                    }
                });
                builder2.show();
                break;
            case R.id.puttingeffortonagoal:
                String[] GoalsArray3 = thirdString.split(",");
                items = new CharSequence[GoalsArray3.length+1];
                for (int j = 0; j < GoalsArray3.length; j++) {
                    btnText=btn3.getText().toString();
                    if (btnText.contains(" a "))
                    {
                        text1=" a ";
                        text2=" the ";
                        String text3=btnText.replace(text1,text2);
                        items[j] = text3+" to " + GoalsArray3[j];

                    }
                }
                text1=" a ";
                text2=" the ";
                textTemp=btnText.replace(text1,text2);
                if (GoalsArray3.length==1)
                {
                    items[1]=textTemp+" to __________";
                }
                else
                if (GoalsArray3.length==2)
                {
                    items[2]=textTemp+" to __________";
                }
                else
                if (GoalsArray3.length==3)
                {
                    items[3]=textTemp+" to __________";
                }
                else
                if (GoalsArray3.length==4)
                {
                    items[4]=textTemp+" to __________";
                }
                else
                if (GoalsArray3.length==5)
                {
                    items[5]=textTemp+" to __________";
                }
                else
                if (GoalsArray3.length==6)
                {
                    items[6]=textTemp+" to __________";
                }
              //  items[2]=btnText+" to __________";
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setTitle(Text);
                builder3.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(textTemp+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(textTemp+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task+".");
                                            bundle.putString("text",temp);
                                            fragment=new Fragment2k3e();
                                            fragment.setArguments(bundle);
                                            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
                                        }
                                    })
                                    .setNegativeButton("Cancel", null)
                                    .create();
                            alertDialogdialog.show();

                        }
                        else
                        if (items[which].equals(items[0])) {
                            newText = String.valueOf(items[0]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            bundle.putString("text", temp+".");
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }



                    }
                });
                builder3.show();
                break;

            default:
                break;
        }
    }
}
