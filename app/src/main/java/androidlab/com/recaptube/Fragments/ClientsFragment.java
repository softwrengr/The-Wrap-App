package androidlab.com.recaptube.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import androidlab.com.recaptube.Adapter.ClientAdapter;
import androidlab.com.recaptube.Controllers.ClientsDetailsModel;
import androidlab.com.recaptube.R;
import androidlab.com.recaptube.Utils.Alert_Utils;
import androidlab.com.recaptube.Utils.Configuration;
import androidlab.com.recaptube.Utils.GeneralUtils;


public class ClientsFragment extends Fragment {

    GridView gridView;
    ArrayList<ClientsDetailsModel> clientsDetailsModels;
    ClientAdapter clientAdapter;
    SwipeRefreshLayout swipeRefreshLayout;
    android.support.v7.app.AlertDialog alertDialog;
    SharedPreferences sharedPreferences, sharedPreferences1;
    SharedPreferences.Editor editor, editor1;
    Dialog dialog, dialog1,emailDialog;
    TextView tvalt;
    EditText etalert;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clients, container, false);

        sharedPreferences = getActivity().getSharedPreferences("MYPREF", Context.MODE_PRIVATE);
        sharedPreferences1 = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor1 = sharedPreferences1.edit();
        customActionBar();
        deleteCache(getActivity());


        // clearCache();
        //  getActivity().setTitle("My Clients");
        gridView = (GridView) view.findViewById(R.id.gridViewAllContestent);
        clientsDetailsModels = new ArrayList<>();

        if (alertDialog == null) {
            alertDialog = Alert_Utils.createProgressDialog(getActivity());
//            alertDialog.show();
        }
        clientsDetailsModels.clear();

        clientAdapter = new ClientAdapter(getActivity(), clientsDetailsModels);
        gridView.setAdapter(clientAdapter);
        showDialog();
        apicall();
        return view;
    }
    private void showDialog() {
        String CFTClientName = sharedPreferences1.getString("CFTClientName","");
        String OMAClientName = sharedPreferences1.getString("OMAClientName","");
        if (CFTClientName != null && !CFTClientName.equals("")) {
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.dialog_layout);
            Button btn_Next = dialog.findViewById(R.id.dialog_next);
            btn_Next.setText("Submit");
            tvalt = (TextView) dialog.findViewById(R.id.myalertdialog);
            etalert = (EditText) dialog.findViewById(R.id.etalert);
            etalert.setText("The CFS prepared and debriefed for CFT meeting. ");
            etalert.setSelection(etalert.length());
            btn_Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    showDialog2(15);
                    editor1.putString("CFTClientName", "").commit();

                }
            });
            dialog.show();
        }
        else if (OMAClientName != null && !OMAClientName.equals("")) {
            dialog = new Dialog(getActivity());
            dialog.setContentView(R.layout.dialog_layout);
            Button btn_Next = dialog.findViewById(R.id.dialog_next);
            tvalt = (TextView) dialog.findViewById(R.id.myalertdialog);
            etalert = (EditText) dialog.findViewById(R.id.etalert);
            etalert.setText("The CFS researched information in order to accurately submit Outcome Measures Application. ");            etalert.setSelection(etalert.length());
            btn_Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    showDialog2(30);
                    editor1.putString("OMAClientName", "").commit();

                }
            });
            dialog.show();
        }

    }
    private void showDialog2(int points) {
        dialog1 = new Dialog(getActivity());
        dialog1.setContentView(R.layout.congo_dialog_layout);
        Button btn_ok = dialog1.findViewById(R.id.ok_congo);
        tvalt = (TextView) dialog1.findViewById(R.id.tvCongo);
        tvalt.setText("Congratulations! You have earned " + points + " productivity points!");
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog1.dismiss();
                emailDialog = new Dialog(getActivity());
                emailDialog.setContentView(R.layout.emai_dialog_layout);
                Button btnOne = emailDialog.findViewById(R.id.one);
                Button btnTwo = emailDialog.findViewById(R.id.two);
                btnOne.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        emailDialog.dismiss();
                    }
                });
                btnTwo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        emailDialog.dismiss();
                    }
                });
                emailDialog.show();
            }
        });

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(getActivity().getApplicationContext(), notification);
        r.play();

        dialog1.show();
    }
    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public boolean clearCache() {
        try {
            File[] files = getActivity().getBaseContext().getCacheDir().listFiles();

            for (File file : files) {

                if (!file.delete()) {
                    return false;
                }
            }

            return true;

        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
        inflater.inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.profile:
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
// ...Irrelevant code for customizing the buttons and title
                LayoutInflater inflater = this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.custom_profile, null);
                dialogBuilder.setView(dialogView);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
                break;

            case R.id.todolist:
                Fragment fragment2 = new ToDoList();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment2).addToBackStack("abc").commit();
                break;

            case R.id.scheduled:
                Fragment fragment3 = new Scheduled_Notifications();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment3).addToBackStack("abc").commit();
                break;

            case R.id.mileage:
                Fragment fragment6 = new MileageFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment6).addToBackStack("abc").commit();
                break;

            case R.id.addClient:
                Fragment fragment = new AddClientFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).addToBackStack("abc").commit();
                break;

            case R.id.searchClient:

                break;
            case R.id.glossary:
                Fragment fragment4 = new GlossaryFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment4).addToBackStack("abc").commit();
                break;
            case R.id.resources:
                Fragment fragment5 = new ResourcesFragment();
                getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment5).addToBackStack("abc").commit();
                break;

        }
        return true;

    }

    private void apicall() {
        JsonObjectRequest stringRequest = new JsonObjectRequest(Request.Method.GET, Configuration.ALL_CLIENTS
                , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("zmaRes", String.valueOf(response));
                try {
                    JSONArray jsonArray = response.getJSONArray("data");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ClientsDetailsModel contes = new ClientsDetailsModel();
                        JSONObject temp = jsonArray.getJSONObject(i);
                        contes.setClientId(temp.getString("id"));
                        contes.setClinetFname(temp.getString("first_name"));
                        contes.setClientLname(temp.getString("last_name"));
                        contes.setClientGoals(temp.getString("goals"));

                        clientsDetailsModels.add(contes);
                        if (alertDialog != null)
                            alertDialog.dismiss();
                        Collections.sort(clientsDetailsModels, new Comparator<ClientsDetailsModel>() {
                            @Override
                            public int compare(ClientsDetailsModel item, ClientsDetailsModel t1) {
                                String s1 = item.getClientLname();
                                String s2 = t1.getClientLname();
                                return s1.compareToIgnoreCase(s2);
                            }

                        });
                    }

                    clientAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    Log.d("zmaE", e.getMessage());
                    if (alertDialog != null)
                        alertDialog.dismiss();
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //DialogUtils.sweetAlertDialog.dismiss();
                // DialogUtils.showErrorTypeAlertDialog(getActivity(), "Server error");
                if (alertDialog != null)
                    alertDialog.dismiss();
                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(getActivity(), "Network Error", Toast.LENGTH_SHORT).show();
                //} else if (error instanceof ServerError) {
                //    Toast.makeText(getActivity(), "Server Error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(getActivity(), "Network Error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
                    Toast.makeText(getActivity(), "No client found", Toast.LENGTH_SHORT).show();
                }
                Log.d("error", String.valueOf(error.getCause()));

            }
        }) {
            @Override
            public String getBodyContentType() {
                return "application/x-www-form-urlencoded;charset=UTF-8";
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
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
        View mCustomView = mInflater.inflate(R.layout.custom_actionbar, null);

        ImageView imageView = (ImageView) mCustomView.findViewById(R.id.iv);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Fragment fragment = new NewsFeedFragment();
             getFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
            }
        });


        TextView textView = (TextView) mCustomView.findViewById(R.id.productivity);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.custom_profile, null);
                dialogBuilder.setView(dialogView);
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });

        mActionBar.setCustomView(mCustomView);
        mActionBar.setDisplayShowCustomEnabled(true);

    }
}