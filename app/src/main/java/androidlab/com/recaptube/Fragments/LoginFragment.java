package androidlab.com.recaptube.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.Alert_Utils;


public class LoginFragment extends Fragment {

    EditText etEmail,etPassword;
    Button btnSignIn;
    String strEmail,strPassword;
    android.support.v7.app.AlertDialog alertDialog;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login, container, false);

       // customActionBar();
        etEmail=(EditText)view.findViewById(R.id.etEmail);
        etPassword=(EditText)view.findViewById(R.id.etPassword);
        btnSignIn=(Button)view.findViewById(R.id.btnSignIn);

        sharedPreferences = getActivity().getSharedPreferences("com.wrap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDataInput();
            }
        });


        return view;
    }

    /*
    private void onDataInput() {
        strEmail=etEmail.getText().toString();
        strPassword=etPassword.getText().toString();
        if (strEmail.equals("")) {
            etEmail.setError("Please enter email");
        }
        else if (strPassword.equals("")) {
            etPassword.setError("Please enter the password");
        }
        else {
            Fragment fragment=new ClientsFragment();
            getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).commit();


            //if (alertDialog==null)
            //{
            //    alertDialog= Alert_Utils.createProgressDialog(getActivity());
            //    alertDialog.show();
            //}


            //apicall();
        }
    }
    */

        private void onDataInput() {
            Fragment fragment = new ClientsFragment();
            getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();
        }

        private void apicall() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://squaresdevelopers.com/RecapTube/user_authenthication.php"
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("zma log ", response);
                if (response.contains("true"))
                {
                    String apiToken="abc123";
                    editor.putString("token",apiToken).commit();
                    if (alertDialog!=null)
                        alertDialog.dismiss();
                    Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
                    Fragment fragment=new ClientsFragment();
                    getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).commit();
                }
                else
                {
                    if (alertDialog!=null)
                        alertDialog.dismiss();
                    Toast.makeText(getActivity(), response, Toast.LENGTH_SHORT).show();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (alertDialog!=null)
                    alertDialog.dismiss();
                Log.d("zmaRespo",error.getCause().toString());
            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email", strEmail);
                params.put("password", strPassword);
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
    public void customActionBar() {

        android.support.v7.app.ActionBar mActionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);
        LayoutInflater mInflater = LayoutInflater.from(getActivity());
        View mCustomView = mInflater.inflate(R.layout.custom_login_actionbar, null);
        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }
}
