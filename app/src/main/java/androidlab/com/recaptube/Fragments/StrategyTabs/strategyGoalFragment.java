package androidlab.com.recaptube.Fragments.StrategyTabs;

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


public class strategyGoalFragment extends Fragment implements View.OnClickListener{
    Button btn1,btn2,btn3,btn4,btn5,btn6;
    String Text,thirdString;
    Fragment fragment;
    Bundle bundle;
    String abc="?";
    String xyz=".";
    String oldText="what";
    String newText;
    String temp;
    String finalString;
    String btnText,text1,text2;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    CharSequence[] items;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_strategy_goal, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        bundle=new Bundle();
        Text=getArguments().getString("text");
        thirdString=sharedPreferences.getString("goals","");

        btn1=(Button)view.findViewById(R.id.barriers);
        btn2=(Button)view.findViewById(R.id.benefitsandconsequences);
        btn3=(Button)view.findViewById(R.id.ideas);
        btn4=(Button)view.findViewById(R.id.methods);
        btn5=(Button)view.findViewById(R.id.prosandcons);
        btn6=(Button)view.findViewById(R.id.strategies);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        return  view;
    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)
        {
            case R.id.benefitsandconsequences:
                String[] GoalsArray = thirdString.split(",");
                items = new CharSequence[GoalsArray.length+1];
                for (int j = 0; j < GoalsArray.length; j++) {
                    btnText=btn2.getText().toString();
                    items[j] =btnText+ " to " + GoalsArray[j];
                }
                if (GoalsArray.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle(Text);
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                           newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                             newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                           newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }



                    }
                });
                builder.show();

                break;
            case R.id.ideas:
                String[] GoalsArray2 = thirdString.split(",");
                items = new CharSequence[GoalsArray2.length+1];
                for (int j = 0; j < GoalsArray2.length; j++) {
                    btnText=btn3.getText().toString();
                    items[j] = btnText+" to " + GoalsArray2[j];

                }
                if (GoalsArray2.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray2.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray2.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray2.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray2.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray2.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder2 = new AlertDialog.Builder(getActivity());
                builder2.setTitle(Text);
                builder2.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }


                    }
                });
                builder2.show();
                break;
            case R.id.methods:
                String[] GoalsArray3 = thirdString.split(",");
                items = new CharSequence[GoalsArray3.length+1];
                for (int j = 0; j < GoalsArray3.length; j++) {
                    btnText=btn4.getText().toString();
                    items[j] = btnText+" to " + GoalsArray3[j];
                }
                if (GoalsArray3.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray3.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray3.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray3.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray3.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray3.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(getActivity());
                builder3.setTitle(Text);
                builder3.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }


                    }
                });
                builder3.show();
                break;
            case R.id.prosandcons:
                String[] GoalsArray4 = thirdString.split(",");
                items = new CharSequence[GoalsArray4.length+1];
                for (int j = 0; j < GoalsArray4.length; j++) {
                    btnText=btn5.getText().toString();
                        items[j] = btnText+" to " + GoalsArray4[j];
                }
                if (GoalsArray4.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray4.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray4.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray4.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray4.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray4.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder4 = new AlertDialog.Builder(getActivity());
                builder4.setTitle(Text);
                builder4.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }


                    }
                });
                builder4.show();
                break;
            case R.id.strategies:
                String[] GoalsArray5= thirdString.split(",");
                items = new CharSequence[GoalsArray5.length+1];
                for (int j = 0; j < GoalsArray5.length; j++) {
                    btnText=btn6.getText().toString();
                        items[j] = btnText+" to " + GoalsArray5[j];

                }
                if (GoalsArray5.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray5.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray5.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray5.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray5.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray5.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder5 = new AlertDialog.Builder(getActivity());
                builder5.setTitle(Text);
                builder5.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }


                    }
                });
                builder5.show();
                break;

            case R.id.barriers:
                String[] GoalsArray6= thirdString.split(",");
                items = new CharSequence[GoalsArray6.length+1];
                for (int j = 0; j < GoalsArray6.length; j++) {
                    btnText=btn1.getText().toString();
                        items[j] = btnText+" to " + GoalsArray6[j];

                }
                if (GoalsArray6.length==1)
                {
                    items[1]=btnText+" to __________";
                }
                else
                if (GoalsArray6.length==2)
                {
                    items[2]=btnText+" to __________";
                }
                else
                if (GoalsArray6.length==3)
                {
                    items[3]=btnText+" to __________";
                }
                else
                if (GoalsArray6.length==4)
                {
                    items[4]=btnText+" to __________";
                }
                else
                if (GoalsArray6.length==5)
                {
                    items[5]=btnText+" to __________";
                }
                else
                if (GoalsArray6.length==6)
                {
                    items[6]=btnText+" to __________";
                }
                final AlertDialog.Builder builder6 = new AlertDialog.Builder(getActivity());
                builder6.setTitle(Text);
                builder6.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (items[which].equals(btnText+" to __________"))
                        {
                            final EditText taskEditText = new EditText(getActivity());
                            taskEditText.setSingleLine();
                            taskEditText.setText(btnText+" to ");
                            taskEditText.setSelection(taskEditText.length());
                            AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                                    .setTitle(Text)
                                    .setView(taskEditText)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            String task = String.valueOf(taskEditText.getText());
                                            temp=Text.replace(oldText,task);
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
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[1])) {
                            newText = String.valueOf(items[1]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();

                        } else if (items[which].equals(items[2])) {
                            newText = String.valueOf(items[2]);
                            String returnText = Text.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[3])) {
                            newText = String.valueOf(items[3]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[4])) {
                            newText = String.valueOf(items[4]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        } else if (items[which].equals(items[5])) {

                            newText = String.valueOf(items[5]);
                            String returnText = temp.replace(oldText, newText);
                            temp = returnText;
                            finalString=temp.replace(abc,xyz);
                            bundle.putString("text", finalString);
                            Fragment fragment2 = new Fragment2k3e();
                            fragment2.setArguments(bundle);
                            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                        }



                    }
                });
                builder6.show();
                break;
            default:
                break;
        }
    }

}
