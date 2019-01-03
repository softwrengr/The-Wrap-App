package androidlab.com.recaptube.Fragments;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidlab.com.recaptube.Fragments.CFT_Fragments.A_CFTMinutesFragment;
import androidlab.com.recaptube.R;

public class TaskGridFragment extends Fragment implements View.OnClickListener {

    ImageView ivProgressNote, ivOma;
    TextView tvProgressNote, tvOma;
    String clientId, clientName;
    LinearLayout linearLayoutProgressNote, LinearOma, linearLayoutCFTMinutes, linearLayoutGenogram, linearLayoutMentalHealth;
    Bundle bundle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Dialog dialog, dialog1,dialog2,dialogFour;
    EditText etalert;
    TextView tvalt;
    ImageView imageViewStar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_task_grid, container, false);


        ivProgressNote = (ImageView) view.findViewById(R.id.ivProgressNote);
        tvProgressNote = (TextView) view.findViewById(R.id.tvProgressNote);
        linearLayoutProgressNote = (LinearLayout) view.findViewById(R.id.linearLayoutProgressNote);
        ivOma = (ImageView) view.findViewById(R.id.omaiv);
        tvOma = (TextView) view.findViewById(R.id.tvoma);
        LinearOma = (LinearLayout) view.findViewById(R.id.omalayout);
        linearLayoutCFTMinutes = (LinearLayout) view.findViewById(R.id.linearlayoutCFTMinutes);
        linearLayoutGenogram = (LinearLayout) view.findViewById(R.id.linearLayoutGenogram);
        linearLayoutMentalHealth = (LinearLayout) view.findViewById(R.id.linearLayoutMentalHealth);
        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        clientId = sharedPreferences.getString("clientId", "");
        bundle = new Bundle();
        // clientId=getArguments().getString("clientId");
        clientName = getArguments().getString("clientName");
        bundle.putString("clientId", clientId);
        bundle.putString("clientName", clientName);
        customActionBar();
        ivProgressNote.setOnClickListener(this);
        linearLayoutProgressNote.setOnClickListener(this);
        linearLayoutCFTMinutes.setOnClickListener(this);
        linearLayoutGenogram.setOnClickListener(this);
        linearLayoutMentalHealth.setOnClickListener(this);
        String clientFName = sharedPreferences.getString("fname", "");
        if ("Mark".equals(clientFName) || "Rayleen".equals(clientFName)) {
            //showDialog();
            showDialog4();
        }
        showDialog1();

        tvOma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new G_OMA3Month()).commit();
            }
        });
        ivOma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new G_OMA3Month()).commit();
            }
        });
        LinearOma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.mainContainer, new G_OMA3Month()).commit();
            }
        });
        return view;
    }

    private void showDialog1() {
        if (sharedPreferences.getBoolean("isDilogOpen", false)) {
            dialog1 = new Dialog(getActivity());
            dialog1.setContentView(R.layout.dialog_layout);
            Button btn_Next = dialog1.findViewById(R.id.dialog_next);
            tvalt = (TextView) dialog1.findViewById(R.id.myalertdialog);
            etalert = (EditText) dialog1.findViewById(R.id.etalert);
            etalert.setText("The CFS called the client's caregiver to discuss ");
            etalert.setSelection(etalert.length());
            btn_Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editor.putBoolean("isDilogOpen", false).commit();
                    showDialog2(18);
                    dialog1.dismiss();
                }
            });
            dialog1.show();
        }
    }
    private void showDialog2(int points) {
        dialog2 = new Dialog(getActivity());
        dialog2.setContentView(R.layout.congo_dialog_layout);
        Button btn_ok = dialog2.findViewById(R.id.ok_congo);
        imageViewStar = (ImageView) dialog2.findViewById(R.id.imageViewStar);
        imageViewStar.setVisibility(View.VISIBLE);
        tvalt = (TextView) dialog2.findViewById(R.id.tvCongo);
        tvalt.setText("Congratulations! You have earned " + points + " productivity points!");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.dismiss();
            }
        });
        dialog2.show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.ivProgressNote:
                Fragment fragment = new ClientProgressNote();
                bundle.putString("clientName", clientName);
                bundle.putString("clientId", clientId);
                bundle.putString("task", "Progress Note");
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("abc").commit();
                break;
            case R.id.tvProgressNote:
                Fragment fragment2 = new ClientProgressNote();
                bundle.putString("task", "Progress Note");
                bundle.putString("clientName", clientName);
                bundle.putString("clientId", clientId);
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                break;
            case R.id.linearLayoutProgressNote:
                Fragment fragment3 = new ClientProgressNote();
                bundle.putString("task", "Progress Note");
                bundle.putString("clientName", clientName);
                bundle.putString("clientId", clientId);
                fragment3.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment3).addToBackStack("abc").commit();
                break;
            case R.id.linearlayoutCFTMinutes:
                Fragment A_CFTMinutes = new A_CFTMinutesFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, A_CFTMinutes).addToBackStack("abc").commit();
                break;
            case R.id.linearLayoutGenogram:
                Fragment gFragment = new GenogramFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, gFragment).addToBackStack("abc").commit();
                break;
            case R.id.linearLayoutMentalHealth:
                Fragment mentalHealthFragment = new MentalHealthAssessment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, mentalHealthFragment).addToBackStack("abc").commit();
                break;
            default:
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        inflater.inflate(R.menu.client_progressnote, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.action_settings:
                break;
            case R.id.todolist:

                break;

            case R.id.scheduled:

                break;

            case R.id.mileage:

                break;

            case R.id.addClient:

                break;

            case R.id.searchClient:

                break;
            case R.id.action_menu1:
            case R.id.action_menu2:
            case R.id.action_menu3:
            case R.id.action_menu4:
            case R.id.action_menu5:
            case R.id.action_menu6:
                Fragment fragment = new FullScreenImageFragment();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
                break;

        }
        return true;

    }


    public void customActionBar() {
        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayHomeAsUpEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar_taskgrid, null);
        TextView textView = (TextView) mCustomView.findViewById(R.id.textView2);
        String barTitle = "Task List";
        textView.setText(barTitle);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }

    public void showDialog() {
        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_layout);
        Button btn_Next = dialog.findViewById(R.id.dialog_next);
        btn_Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void  showDialog4(){
        dialogFour = new Dialog(getActivity());
        dialogFour.setContentView(R.layout.dialog4_layout);
        Button dialogFourBtn = dialogFour.findViewById(R.id.dialogFourBtn);
        dialogFourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogFour.dismiss();
            }
        });
        dialogFour.show();

    }
}

