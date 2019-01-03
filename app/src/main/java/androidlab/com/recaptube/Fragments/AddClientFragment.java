package androidlab.com.recaptube.Fragments;

import android.app.DatePickerDialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.Alert_Utils;

public class AddClientFragment extends Fragment {

    EditText etFirstName,etMiddleName,etLastName,etDob,etGoals,etHomeAddressStreet,etHomeAddressState,etHomeAddressCity,etHomeAddressZipCode,
            etSchoolAddressStreet,etSchoolAddressState,etID,
            etSchoolAddressZipCode,etSchoolAddressCity,etPhoneNo,etCaregiverPhoneNo;
    Button btnSubmit;
    String strFirstName,strMiddleName,strLastName,strHomeAddress,strSchoolAddress,strPhoneNo,strDob,strGoal,
    strHomeAddressCity,strHomeAddressState,strHomeAddressZipCode,strSchoolAddressState,strSchoolAddressZipCode,
    strSchoolAddressCity,strSpinnerValue,strCaregiverPhoneNo,strClientId;
    DatePickerDialog datePickerDialog;
    android.support.v7.app.AlertDialog alertDialog;
    ImageView btnAddnewGoal;
    Spinner spinner;
    LinearLayout goalsLayout;
    FrameLayout frameLayoutGoals;
    ArrayList<EditText> goalsEditTextList = new ArrayList();
    ArrayList<ImageView> goalsImageList = new ArrayList();
    int hint=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_add_client, container, false);

        etFirstName=(EditText)view.findViewById(R.id.etClientName);
        etMiddleName=(EditText)view.findViewById(R.id.etMiddleName);
        etLastName=(EditText)view.findViewById(R.id.etLastName);
        etDob=(EditText)view.findViewById(R.id.etDob);
        etHomeAddressStreet=(EditText)view.findViewById(R.id.etClientAddress);
        etHomeAddressCity=(EditText)view.findViewById(R.id.etClientAddress2);
        etHomeAddressState=(EditText)view.findViewById(R.id.etClientAddress3);
        etHomeAddressZipCode=(EditText)view.findViewById(R.id.etClientAddress4);
        etSchoolAddressStreet=(EditText)view.findViewById(R.id.etClientOfficeAddress);
        etSchoolAddressCity=(EditText)view.findViewById(R.id.etClientOfficeAddress2);
        etSchoolAddressState=(EditText)view.findViewById(R.id.etClientOfficeAddress3);
        etSchoolAddressZipCode=(EditText)view.findViewById(R.id.etClientOfficeAddress4);
        etGoals=(EditText)view.findViewById(R.id.etClientGoals);
        etPhoneNo=(EditText)view.findViewById(R.id.etClientPhoneNo);
        btnAddnewGoal=(ImageView)view.findViewById(R.id.btnAddIng);
        goalsLayout=(LinearLayout) view.findViewById(R.id.parentLayoutInstructions);
        etID=(EditText)view.findViewById(R.id.etID);
        frameLayoutGoals=(FrameLayout)view.findViewById(R.id.frameLayoutGoals);
        etCaregiverPhoneNo=(EditText)view.findViewById(R.id.etCaregiverPhoneNo);
        goalsEditTextList.add(etGoals);
        goalsImageList.add(btnAddnewGoal);
        spinner=(Spinner)view.findViewById(R.id.spinnerGender);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object item=parent.getItemAtPosition(position);
                if (item.equals("Male"))
                {
                    strSpinnerValue="Male";
                }
                else
                    if (item.equals("Female"))
                    {
                        strSpinnerValue="Female";
                    }
                    else if (item.equals("Gender"))
                    {
                        strSpinnerValue="";
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        etGoals.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() < 1) {
                    btnAddnewGoal.setVisibility(View.INVISIBLE);
                } else {
                    btnAddnewGoal.setVisibility(View.VISIBLE);
                }
            }
        });

        btnAddnewGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAddnewGoal.setVisibility(View.INVISIBLE);
                addEditTextForGoals();
            }
        });


        btnSubmit=(Button)view.findViewById(R.id.btnSubmit);

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                // date picker dialog
                datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                etDob.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeDataFromFields();
                onDataInput();
            }
        });

        return view;
    }

    public void takeDataFromFields() {
        strGoal = "";
        for (EditText etIngred : goalsEditTextList) {
            strGoal += etIngred.getText().toString() + ",";
            Log.d("zmaData",etIngred.getText().toString());
        }
        strGoal = strGoal.substring(0, strGoal.length() - 1);
        Toast.makeText(getActivity(), strGoal, Toast.LENGTH_SHORT).show();
    }

    private void addEditTextForGoals() {
        goalsImageList.get(goalsImageList.size() - 1).setVisibility(View.INVISIBLE);
        final FrameLayout frameLayout = new FrameLayout(getActivity());
        frameLayout.setLayoutParams(frameLayoutGoals.getLayoutParams());
        frameLayout.setTag(goalsEditTextList.size());
        EditText  editText = new EditText(getActivity());
        editText.setLayoutParams(etGoals.getLayoutParams());
        editText.setHint("Add Goal");
        editText.setPadding(etGoals.getPaddingLeft(), 0, 0, 0);
        frameLayout.addView(editText);
        final ImageView imageView = new ImageView(getActivity());
        imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.delete));
        imageView.setLayoutParams(btnAddnewGoal.getLayoutParams());
        frameLayout.addView(imageView);
        imageView.setTag(0);
        imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.delete));
        goalsImageList.add(imageView);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() < 1) {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.delete));
                    imageView.setTag(0);
                } else {
                    imageView.setVisibility(View.VISIBLE);
                    imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.plusicon));
                    imageView.setTag(1);
                }

            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((int) (imageView.getTag()) == 1) {
                    addEditTextForGoals();
                } else {
                    goalsLayout.removeView(frameLayout);
                    goalsEditTextList.remove((int) (frameLayout.getTag()));
                    goalsImageList.remove((int) (frameLayout.getTag()));
                    goalsImageList.get(goalsImageList.size() - 1).setVisibility(View.VISIBLE);

                }
            }
        });
        goalsLayout.addView(frameLayout);
        goalsEditTextList.add(editText);
    }
    private void onDataInput() {
        strFirstName=etFirstName.getText().toString();
        strMiddleName=etMiddleName.getText().toString();
        strLastName=etLastName.getText().toString();
        strDob=etDob.getText().toString();
        strSchoolAddress=etSchoolAddressStreet.getText().toString();
        strSchoolAddressCity=etSchoolAddressCity.getText().toString();
        strSchoolAddressState=etSchoolAddressState.getText().toString();
        strSchoolAddressZipCode=etSchoolAddressZipCode.getText().toString();
        strPhoneNo=etPhoneNo.getText().toString();
        strHomeAddress=etHomeAddressStreet.getText().toString();
        strHomeAddressCity=etHomeAddressCity.getText().toString();
        strHomeAddressState=etHomeAddressState.getText().toString();
        strHomeAddressZipCode=etHomeAddressZipCode.getText().toString();
        strCaregiverPhoneNo=etCaregiverPhoneNo.getText().toString();
        strClientId=etID.getText().toString();
        if (strClientId.equals(""))
        {
            etID.setError("Please fill this field");
        }
        else
        if (strFirstName.equals(""))
        {
            etFirstName.setError("Please fill this field");
        }else
        if (strLastName.equals(""))
        {
            etLastName.setError("Please fill this field");
        }else
        if (strDob.equals(""))
        {
            etDob.setError("Please fill this field");
        }else
        if (strPhoneNo.equals(""))
        {
            etPhoneNo.setError("Please fill this field");
        }else
        if (strSchoolAddress.equals(""))
        {
            etSchoolAddressStreet.setError("Please fill this field");

        }else if (strSchoolAddressCity.equals(""))
        {
            etSchoolAddressCity.setError("Please fill this field");
        }
        else
            if (strSchoolAddressState.equals(""))
            {
                etSchoolAddressState.setError("Please fill this field");
            }
            else if (strSchoolAddressZipCode.equals(""))
            {
                etSchoolAddressZipCode.setError("Please fill this field");
            }
        else
        if (strHomeAddress.equals(""))
        {
            etHomeAddressStreet.setError("Please fill this field");

        }else
            if (strHomeAddressZipCode.equals(""))
            {
                etHomeAddressZipCode.setError("Please fill this field");
            }
            else
                if (strHomeAddressCity.equals(""))
                {
                    etHomeAddressCity.setError("Please fill this field");
                }
                else
                    if (strSchoolAddressState.equals(""))
                    {
                        etHomeAddressState.setError("Please fill this field");
                    }
        else
        if (strGoal.equals(""))
        {
            etGoals.setError("Please fill this field");
        }else
        {
            if (alertDialog==null)
            {
                alertDialog= Alert_Utils.createProgressDialog(getActivity());
                alertDialog.show();
            }
            apicall();
        }

    }
   // http://trendingfashionable.ipage.com/Recaptube/clients_detail.php
    //http://squaresdevelopers.com/RecapTube/clients_detail.php
    private void apicall() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://trendingfashionable.ipage.com/Recaptube/clients_detail.php"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("zma log ", response);
                if (response.contains("Data inserted successfully"))
                {
                    if (alertDialog!=null)
                        alertDialog.dismiss();
                    Toast.makeText(getActivity(), "Client has been added successfully", Toast.LENGTH_SHORT).show();
                    Fragment fragment=new ClientsFragment();
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).commit();
                }
                else
                {
                    if (alertDialog!=null)
                        alertDialog.dismiss();
                    Toast.makeText(getActivity(), "error"+response, Toast.LENGTH_SHORT).show();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (alertDialog!=null)
                    alertDialog.dismiss();
                Toast.makeText(getActivity(), error.getCause().toString(), Toast.LENGTH_SHORT).show();
                Log.d("error",error.getCause().toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("first_name",strFirstName);
                params.put("middle_name",strMiddleName);
                params.put("last_name",strLastName);
                params.put("dob",strDob);
                params.put("client_id",strClientId);
                params.put("phone_no",strPhoneNo);
                params.put("Gender",strSpinnerValue);
                params.put("goals",strGoal);
                params.put("caregiver_phone",strCaregiverPhoneNo);
                params.put("home_street",strHomeAddress);
                params.put("home_city",strHomeAddressCity);
                params.put("home_state",strHomeAddressState);
                params.put("home_zip",strHomeAddressZipCode);
                params.put("school_street",strSchoolAddress);
                params.put("school_city",strSchoolAddressCity);
                params.put("school_state",strSchoolAddressState);
                params.put("school_zip",strSchoolAddressZipCode);
                Log.d("zma params",params.toString());
                //   params.put("Accept", "application/json");
                return params;
            }

        };
        RequestQueue mRequestQueue = Volley.newRequestQueue(getActivity());
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(200000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(stringRequest);
    }

}
