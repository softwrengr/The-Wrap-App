package androidlab.com.recaptube.Fragments.CFT_Fragments;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidlab.com.recaptube.Fragments.ClientsFragment;
import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.GeneralUtils;
import androidlab.com.recaptube.Utils.ZipManager;

public class CFT_SubmitFragment extends Fragment {
    private String strDate,startT,endT;
    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    Button directedAttentionEng;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String finalOutputPath = Environment.getExternalStorageDirectory().getPath()+ "/CFT Minutes/";
    String inputPath = Environment.getExternalStorageDirectory().getPath()+ "/inputDocx/";
    String inputFile = "input.docx";
    String outputPath = Environment.getExternalStorageDirectory().getPath()+ "/.tmpDocx/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_cft__submit, container, false);
        directedAttentionEng = (Button) view.findViewById(R.id.directedattentionEng);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

            }
        } else {
            // Permission has already been granted
        }

        directedAttentionEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDocCreated = docxCreation();
                if (isDocCreated) {
                    String fName = sharedPreferences.getString("fname","");
                    String lName = sharedPreferences.getString("lname","");
                    editor.putString("CFTClientName", fName + " " + lName).commit();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.mainContainer, new ClientsFragment()).commit();
                }
            }
        });
        return view;
    }


    public boolean docxCreation() {
        String FacilitatorName = GeneralUtils.getFacilitatorName(getActivity());
        String CaregiverName = GeneralUtils.getCaregiverName(getActivity());
        String CFSName = GeneralUtils.getCFSName(getActivity());
        String TherapistName = GeneralUtils.getTherapistName(getActivity());
        String ParentPartnerName = GeneralUtils.getParentPartnerName(getActivity());
        String SupervisorName = GeneralUtils.getSupervisorName(getActivity());
        String NonNegotiables = GeneralUtils.getNonNegotiables(getActivity());
        String ClientRules = GeneralUtils.getClientRules(getActivity());
        String CaregiverGoal = GeneralUtils.getCaregiverGoal(getActivity());
        String ClientGoal = GeneralUtils.getClientGoal(getActivity());
        String ClientWorries = GeneralUtils.getClientWorries(getActivity());
        Log.i("SJA", "ClientRules: " + ClientRules);
        Log.i("SJA", "CaregiverGoal: " + CaregiverGoal);
        String Fname = sharedPreferences.getString("fname","");
        String Lname = sharedPreferences.getString("lname","");
        strDate = GeneralUtils.getDate(getActivity());

        String startTime = sharedPreferences.getString("startTime","");
        String endTime = sharedPreferences.getString("endTime","");
        String dateval = sharedPreferences.getString("CFTDate","");
        DateFormat dateFormat = new SimpleDateFormat("MMMM_dd");
        Date date = new Date();
        File finalOutputPathDir = new File(finalOutputPath);
        if (!finalOutputPathDir.exists()) {
            finalOutputPathDir.mkdirs();
        }
        String OUTPUT_ZIP_FILE = dateFormat.format(date) + "_" + Fname + "_" + Lname + ".docx";
        if (TherapistName.matches("")) {
            Toast.makeText(getActivity(), "Please Enter Therapist Name to replace", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Caregiver Name", Toast.LENGTH_LONG).show();
        }
        else if (CFSName.matches("")) {
            Toast.makeText(getActivity(), "Please Select CFS Name", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Caregiver Name", Toast.LENGTH_LONG).show();
        }
        else if (FacilitatorName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Facilitator Name", Toast.LENGTH_LONG).show();
        }
        else if (ParentPartnerName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Parent Partner Name", Toast.LENGTH_LONG).show();
        }
        else if (SupervisorName.matches("")) {
            Toast.makeText(getActivity(), "Please Select Supervisor Name", Toast.LENGTH_LONG).show();
        }
        else if (NonNegotiables.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Non Negotiables", Toast.LENGTH_LONG).show();
        }
        else if (ClientWorries.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Worries", Toast.LENGTH_LONG).show();
        }
        else if (ClientRules.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Rules", Toast.LENGTH_LONG).show();
        }
        else if (CaregiverGoal.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Caregiver Goal", Toast.LENGTH_LONG).show();
        }
        else if (ClientGoal.matches("")) {
            Toast.makeText(getActivity(), "Please Select value of Client Goal", Toast.LENGTH_LONG).show();
        }
        else if (strDate == null || strDate.matches("")) {
            Toast.makeText(getActivity(), "Please Select Date", Toast.LENGTH_LONG).show();
        }
        else if (startTime == null || startTime.matches("")) {
            Toast.makeText(getActivity(), "Please Select Start Time", Toast.LENGTH_LONG).show();
        }
        else if (endTime == null || endTime.matches("")) {
            Toast.makeText(getActivity(), "Please Select End Time", Toast.LENGTH_LONG).show();
        }
        else {
            ZipManager zipManager = new ZipManager();
            //Extract Data to a folder
            boolean successUnzip = zipManager.extractZip(inputPath + inputFile, outputPath, false);
            // Re-generate docx
            zipManager.generateFileList(new File(outputPath));
            boolean successZip = zipManager.zipIt(finalOutputPath + OUTPUT_ZIP_FILE, Fname, CaregiverName, TherapistName, ParentPartnerName, FacilitatorName, CFSName, SupervisorName, NonNegotiables, ClientWorries, ClientRules, CaregiverGoal, ClientGoal, dateval, startTime, endTime, "", "", Lname, "CFTMIN", null);
            if (successUnzip && successZip) {
                Log.i("SJA", "Yoo... Docx Successfully Created!!");
                return true;

            }
            else {
                Toast.makeText(getActivity(), "Oops..Faild!! Either file or folder not found!", Toast.LENGTH_LONG).show();
            }

        }
        return false;
    }
}
