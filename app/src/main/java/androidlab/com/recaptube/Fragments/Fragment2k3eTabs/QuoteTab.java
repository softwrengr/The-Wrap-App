package androidlab.com.recaptube.Fragments.Fragment2k3eTabs;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidlab.com.recaptube.Fragments.Fragment2k3f;
import androidlab.com.recaptube.R;


public class QuoteTab extends Fragment implements View.OnClickListener {

    Button btn1,btn2,btn3,btn4;
    String text,doer,subject,finalString,thirdString;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    Bundle bundle;
    String oldText="The";
    String newText="the";
    Fragment fragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_quote_tab, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        subject=sharedPreferences.getString("subject","");
        bundle=new Bundle();
        text=getArguments().getString("text");
        finalString=text.replace(oldText,newText);

        btn1=(Button)view.findViewById(R.id.asked);
        btn2=(Button)view.findViewById(R.id.exclaimed);
        btn3=(Button)view.findViewById(R.id.said);
        btn4=(Button)view.findViewById(R.id.stated);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id)

        {
            case R.id.asked:
                final EditText taskEditText = new EditText(getActivity());
                taskEditText.setSingleLine();
                taskEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                AlertDialog alertDialogdialog = new AlertDialog.Builder(getActivity())
                        .setTitle("The "+subject+" "+btn1.getText())
                        .setView(taskEditText)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());

                                bundle.putString("text",task);
                                thirdString="The "+subject+ " " +btn1.getText()+ ", \""+task+"\" when " +finalString;
                                fragment=new Fragment2k3f();
                                bundle.putString("text",thirdString);
                                fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialogdialog.show();

                break;
            case R.id.exclaimed:
                final EditText taskEditText2 = new EditText(getActivity());
                taskEditText2.setSingleLine();
                taskEditText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                AlertDialog alertDialogdialog2 = new AlertDialog.Builder(getActivity())
                        .setTitle("The "+subject+" "+btn2.getText())
                        .setView(taskEditText2)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText2.getText());

                                bundle.putString("text",task);
                                thirdString="The "+subject+ " " +btn2.getText()+ ", \""+task+"\" when " +finalString;
                                fragment=new Fragment2k3f();
                                bundle.putString("text",thirdString);
                                fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialogdialog2.show();
                break;
            case R.id.said:
                final EditText taskEditText3 = new EditText(getActivity());
                taskEditText3.setSingleLine();
                taskEditText3.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                AlertDialog alertDialogdialog3 = new AlertDialog.Builder(getActivity())
                        .setTitle("The "+subject+" "+btn3.getText())
                        .setView(taskEditText3)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText3.getText());

                                bundle.putString("text",task);
                                thirdString="The "+subject+ " " +btn3.getText()+ ", \""+task+"\" when " +finalString;
                                fragment=new Fragment2k3f();
                                bundle.putString("text",thirdString);
                                fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialogdialog3.show();
                break;
            case R.id.stated:
                final EditText taskEditText4 = new EditText(getActivity());
                taskEditText4.setSingleLine();
                taskEditText4.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
                AlertDialog alertDialogdialog4 = new AlertDialog.Builder(getActivity())
                        .setTitle("The "+subject+" "+btn4.getText())
                        .setView(taskEditText4)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText4.getText());

                                bundle.putString("text",task);
                                thirdString="The "+subject+ " " +btn4.getText()+ ", \""+task+"\" when " +finalString;
                                fragment=new Fragment2k3f();
                                bundle.putString("text",thirdString);
                                fragment.setArguments(bundle);
                                getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertDialogdialog4.show();
                break;


            default:
                break;
        }
    }
}
