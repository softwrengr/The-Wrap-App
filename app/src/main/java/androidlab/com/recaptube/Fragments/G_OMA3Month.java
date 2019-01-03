package androidlab.com.recaptube.Fragments;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidlab.com.recaptube.Utils.ZipManager;
import androidlab.com.recaptube.R;


public class G_OMA3Month extends Fragment {
    EditText et_CaregiverWages,et_ClientWages,et_SpouseWages,et_Savings,et_RetirementSocialSecurity,et_VeteranBenefits;
    EditText et_LoanCredit,editText3, etHousingSubsidy, etGeneralReliefAssistance, etFoodStamps, etTANFCalWORKs;
    EditText etSSISSP, etSSDI, etSDI, etTribalBenefits, etUnemployment, etChildSupport, etOtherWages, etNoFinancialSupport;
    Button btnSubmit;
    String client_name, test;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String inputPath = Environment.getExternalStorageDirectory().getPath()+ "/inputDocx/";
    String inputFile = "Child3M.docx";
    String tmpPath = Environment.getExternalStorageDirectory().getPath()+ "/.tmpDocx/";
    String finalOutputPath = Environment.getExternalStorageDirectory().getPath()+ "/OMA 3 Month/";
    Dialog dialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oma_3_month, container, false);
        et_CaregiverWages = view.findViewById(R.id.etCaregiverWages);
        et_ClientWages = view.findViewById(R.id.etClientWages);
        et_SpouseWages = view.findViewById(R.id.etSpouseWages);
        et_Savings=view.findViewById(R.id.etSavings);
        et_RetirementSocialSecurity = view.findViewById(R.id.etRetirementSocialSecurity);
        et_VeteranBenefits = view.findViewById(R.id.etVeteranBenefits);
        et_LoanCredit = view.findViewById(R.id.etLoanCredit);
        editText3 = view.findViewById(R.id.editText3);
        etHousingSubsidy = view.findViewById(R.id.etHousingSubsidy);
        etGeneralReliefAssistance = view.findViewById(R.id.etGeneralReliefAssistance);
        etFoodStamps = view.findViewById(R.id.etFoodStamps);
        etTANFCalWORKs = view.findViewById(R.id.etTANFCalWORKs);
        etSSISSP = view.findViewById(R.id.etSSISSP);
        etSSDI = view.findViewById(R.id.etSSDI);
        etSDI = view.findViewById(R.id.etSDI);
        etTribalBenefits = view.findViewById(R.id.etTribalBenefits);
        etUnemployment = view.findViewById(R.id.etUnemployment);
        etChildSupport = view.findViewById(R.id.etChildSupport);
        etOtherWages = view.findViewById(R.id.etOtherWages);
        etNoFinancialSupport = view.findViewById(R.id.etNoFinancialSupport);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();


        client_name=sharedPreferences.getString("fname","");
        test = sharedPreferences.getString("ClientDOB","");

        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                100);
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);


        btnSubmit = (Button) view.findViewById(R.id.btnSubmit2);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                createPDF();
                boolean isDocCreated = docxCreation();
                if (isDocCreated) {
                    String fName = sharedPreferences.getString("fname", "");
                    String lName = sharedPreferences.getString("lname", "");
                    editor.putString("OMAClientName", fName + " " + lName).commit();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.mainContainer, new ClientsFragment()).commit();
                }
            }
        });

        return view;
    }

    public boolean docxCreation() {
        String stret_CaregiverWages = et_CaregiverWages.getText().toString();
        String stret_ClientWages = et_ClientWages.getText().toString();
        String stret_SpouseWages = et_SpouseWages.getText().toString();
        String et_Savingsstr = et_Savings.getText().toString();
        String editText3str = editText3.getText().toString();
        String et_RetirementSocialSecuritystr = et_RetirementSocialSecurity.getText().toString();
        String et_VeteranBenefitsstr = et_VeteranBenefits.getText().toString();
        String et_LoanCreditstr = et_LoanCredit.getText().toString();
        String etHousingSubsidystr = etHousingSubsidy.getText().toString();
        String etGeneralReliefAssistancestr = etGeneralReliefAssistance.getText().toString();
        String etFoodStampsstr = etFoodStamps.getText().toString();
        String etTANFCalWORKsstr = etTANFCalWORKs.getText().toString();
        String etSSISSPstr = etSSISSP.getText().toString();
        String etSSDIstr = etSSDI.getText().toString();
        String etSDIstr = etSDI.getText().toString();
        String etTribalBenefitsstr = etTribalBenefits.getText().toString();
        String etUnemploymentstr = etUnemployment.getText().toString();
        String etChildSupportstr = etChildSupport.getText().toString();
        String etOtherWagesstr = etOtherWages.getText().toString();
        String etNoFinancialSupportstr = etNoFinancialSupport.getText().toString();
        String[] wagesArray = new String[]{
                stret_CaregiverWages, stret_ClientWages, stret_SpouseWages, et_Savingsstr, editText3str,
                et_RetirementSocialSecuritystr, et_VeteranBenefitsstr, et_LoanCreditstr,
                etHousingSubsidystr, etGeneralReliefAssistancestr, etFoodStampsstr, etTANFCalWORKsstr, etSSISSPstr,
                etSSDIstr, etSDIstr, etTribalBenefitsstr, etUnemploymentstr, etChildSupportstr, etOtherWagesstr, etNoFinancialSupportstr
        };
        String ClientID = sharedPreferences.getString("clientId","");
        String ClientDOB = sharedPreferences.getString("dob","");
        String Fname = client_name;
        String Lname = sharedPreferences.getString("lname","");

        DateFormat dateFormat = new SimpleDateFormat("MMMM_dd");
        Date date = new Date();
        File finalOutputPathDir = new File(finalOutputPath);
        if (!finalOutputPathDir.exists()) {
            finalOutputPathDir.mkdirs();
        }
        String OUTPUT_ZIP_FILE = dateFormat.format(date) + "_" + Fname + "_" + Lname + ".docx";
        ZipManager zipManager = new ZipManager();
        //Extract Data to a folder
        boolean successUnzip = zipManager.extractZip(inputPath + inputFile, tmpPath, true);
        // Re-generate docx
        zipManager.generateFileList(new File(tmpPath));
        boolean successZip = zipManager.zipIt(finalOutputPath + OUTPUT_ZIP_FILE, Fname, "","", "","","", "","", "", "", "","", "","","", ClientID, ClientDOB, Lname, "OMA3", wagesArray);
        if (successUnzip && successZip) {
//            Toast.makeText(getActivity(), "Yoo...Successfully Done!!", Toast.LENGTH_LONG).show();
            Log.i("SJA", "Yoo... Docx Successfully Created!!");
            return true;
        }
        else {
            Toast.makeText(getActivity(), "Oops..Faild!! Either file or folder not found!", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    public void createPDF() {

        char checked='\u00FE';
        char unchecked='\u00A8';

//create document object
        Document doc = new Document();
//output file path
        String outpath = Environment.getExternalStorageDirectory() + "/eric.pdf";
        try {
//create pdf writer instance
            PdfWriter.getInstance(doc, new FileOutputStream(outpath));
//open the document for writing
            doc.open();

            DottedLineSeparator separator = new DottedLineSeparator();
            Chunk c = new Chunk(separator);
            Paragraph p = new Paragraph("");
            p.add(c);



            doc.add(new Paragraph("\bCOUNTY OF LOS ANGELES DEPARTMENT OF MENTAL HEALTH\n\bOUTCOMES MEASURES APPLICATION \n\bChild 3-Month (3M) \n\t\bAge Group: 0-15"));
            doc.add(new Paragraph("ADMINISTRATIVE INFORMATION"));

            doc.add(p);
            doc.add(new Paragraph("Client ID = _________"+""+"Client DOB = _________"));
            doc.add(new Paragraph("Episode ID = _________"));
            doc.add(new Paragraph("Provide Number = _________"));
            doc.add(new Paragraph("Client Name = "+client_name));
            doc.add(new Paragraph(String.valueOf(checked)));
            doc.add(new Paragraph("CaregiverWages = "+et_CaregiverWages.getText().toString()));
            doc.add(new Paragraph("ClientWages = "+et_ClientWages.getText().toString()));
            doc.add(new Paragraph("SpouseWages = "+et_SpouseWages.getText().toString()));
            doc.add(new Paragraph("Savings = "+et_Savings.getText().toString()));
            doc.add(new Paragraph("RetirementSocialSecurity = "+et_RetirementSocialSecurity.getText().toString()));
            doc.add(new Paragraph("VeteranBenefits = "+et_VeteranBenefits.getText().toString()));
            doc.add(new Paragraph("LoanCredit = "+et_LoanCredit.getText().toString()));

            doc.add(p);

            Toast.makeText(getActivity(), "pdf created successfully", Toast.LENGTH_SHORT).show();
            doc.close();

        } catch (FileNotFoundException e) {

            Toast.makeText(getActivity(), e.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(), e.getStackTrace().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
