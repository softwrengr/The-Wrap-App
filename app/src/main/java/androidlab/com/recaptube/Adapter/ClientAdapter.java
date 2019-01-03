package androidlab.com.recaptube.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidlab.com.recaptube.Controllers.ClientsDetailsModel;
import androidlab.com.recaptube.Fragments.ClientsFragment;
import androidlab.com.recaptube.Fragments.TaskGridFragment;
import androidlab.com.recaptube.R;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Adam Noor on 22-Jan-18.
 */

public class ClientAdapter extends BaseAdapter {
    ArrayList<ClientsDetailsModel> clientsDetailsModels;
    Context context;
    private LayoutInflater layoutInflater;
    String clientId;
    android.support.v7.app.AlertDialog alertDialog;
    MyViewHolder viewHolder = null;

    String id,clientOwnid,dob,homeCity,homeZip,homeState,homeStreet,schoolStreet,schoolCity,schoolZip,schoolState,
    cargPhone,goals,firstName,lastName,middleName,clientPhone,gender;
    final CharSequence[] items = {"Update", "Delete", "Cancel"};
    public ClientAdapter(Context context, ArrayList<ClientsDetailsModel> clientsDetailsModels) {
        this.clientsDetailsModels=clientsDetailsModels;
        this.context=context;
        if (context!=null)
        {
            this.layoutInflater=LayoutInflater.from(context);

        }
    }

    @Override
    public int getCount() {
        if (clientsDetailsModels!=null) return clientsDetailsModels.size();
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(clientsDetailsModels != null && clientsDetailsModels.size() > position) return  clientsDetailsModels.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        final ClientsDetailsModel model=clientsDetailsModels.get(position);
        if(clientsDetailsModels != null && clientsDetailsModels.size() > position) return  clientsDetailsModels.size();
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ClientsDetailsModel model=clientsDetailsModels.get(position);

        viewHolder=new MyViewHolder() ;
        viewHolder.sharedPreferences = context.getSharedPreferences("recap", Context.MODE_PRIVATE);
        viewHolder.editor =viewHolder. sharedPreferences.edit();
        convertView=layoutInflater.inflate(R.layout.custom_client,parent,false);
        viewHolder.textView=(TextView)convertView.findViewById(R.id.clientName);
        viewHolder.cView= convertView.findViewById(R.id.contestentImage);
        String fnm = model.getClinetFname();
        if ("Mark".equals(fnm) || "Rayleen".equals(fnm)) {
            viewHolder.cView.setImageResource(R.drawable.client2);
        }
        viewHolder.textView.setText(model.getClientLname() + ", " + fnm);
        viewHolder.linearLayout=(LinearLayout)convertView.findViewById(R.id.linearLayout);
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                clientId=model.getClientId();
                apicall();
                Bundle bundle=new Bundle();
                viewHolder.editor.putString("clientId",model.getClientId());
                viewHolder.editor.putString("goals",model.getClientGoals()).commit();
                viewHolder.editor.putString("fname",model.getClinetFname()).commit();
                viewHolder.editor.putString("lname",model.getClientLname()).commit();
                bundle.putString("clientName",model.getClientLname()+", "+model.getClinetFname());
                Fragment fragment=new TaskGridFragment();
                fragment.setArguments(bundle);
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer,fragment).addToBackStack("abc").commit();
            }
        });
       viewHolder.linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
           @Override
           public boolean onLongClick(View v) {
               clientId=model.getClientId();
               AlertDialog.Builder builder = new AlertDialog.Builder(context);
               builder.setTitle("Select");
               builder.setItems(items, new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       if (items[which].equals("Update")) {
                           UpdateRecipe();
                       } else if (items[which].equals("Delete")) {
                           DeleteRecipe();
                       } else if (items[which].equals("Cancel")) {
                           dialog.dismiss();
                       }

                   }
               });
               builder.show();
               return true;
           }
       });

        convertView.setTag(viewHolder);
        return convertView;
    }

    private void apicall() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://trendingfashionable.ipage.com/Recaptube/singleClient_detail.php?id="+clientId
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("zmaRes", String.valueOf(response));
                try {
                    JSONArray jsonArray =new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ClientsDetailsModel contes = new ClientsDetailsModel();
                        JSONObject temp = jsonArray.getJSONObject(i);
                        id=temp.getString("id");
                        firstName=temp.getString("first_name");
                        lastName=temp.getString("last_name");
                        clientPhone=temp.getString("phone_number");
                        cargPhone=temp.getString("caregiver_phone");
                        homeStreet=temp.getString("home_street");
                        schoolStreet=temp.getString("school_street");
                        schoolCity=temp.getString("school_city");
                        schoolState=temp.getString("school_state");
                        schoolZip=temp.getString("school_zip");
                        homeCity=temp.getString("home_city");
                        homeZip=temp.getString("home_zip");
                        homeState=temp.getString("home_state");
                        gender=temp.getString("gender");
                        clientOwnid=temp.getString("client_id");
                        dob=temp.getString("dob");
                        //goals=temp.getString("goals");


                        viewHolder.  editor.putString("id",id);
                        viewHolder. editor.putString("Cid",clientOwnid);
                        viewHolder. editor.putString("dob",dob);
                        viewHolder.  editor.putString("Hstreet",homeStreet);
                        viewHolder. editor.putString("Hcity",homeCity);
                        viewHolder. editor.putString("Hzip",homeZip);
                        viewHolder. editor.putString("Hstate",homeState);
                        viewHolder.  editor.putString("Scity",schoolCity);
                        viewHolder.  editor.putString("Sstate",schoolState);
                        viewHolder.  editor.putString("Szip",schoolZip);
                        viewHolder.  editor.putString("Sstreet",schoolStreet);
                        viewHolder.  editor.putString("phone",clientPhone);
                        viewHolder.  editor.putString("Cphone",cargPhone);
                        viewHolder.  editor.putString("gender",gender);
                        viewHolder.  editor.putString("fname",firstName);
                        viewHolder.  editor.putString("lname",lastName);
                        viewHolder.  editor.commit();

                        clientsDetailsModels.add(contes);
                    }


                } catch (JSONException e) {
                    Log.d("zmaE", e.getMessage());
                    e.printStackTrace();
                }


            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                if (error instanceof TimeoutError || error instanceof NoConnectionError) {
                    Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ServerError) {
                    Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof NetworkError) {
                    Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show();
                } else if (error instanceof ParseError) {
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
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(200000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(stringRequest);
    }

    private void UpdateRecipe() {

    }
    private void DeleteRecipe(){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://trendingfashionable.ipage.com/Recaptube/delete_client.php?id="+clientId
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("res", response);
                Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
             //   Fragment fragment=new ClientsFragment();
             //   ((AppCompatActivity) context).getFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();

                Fragment fragment=new ClientsFragment();
                ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction().replace(R.id.mainContainer, fragment).commit();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // progressBar.setVisibility(View.INVISIBLE);
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
        RequestQueue mRequestQueue = Volley.newRequestQueue(context);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(20000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(stringRequest);

    }

    private class MyViewHolder  {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor ;
        TextView textView;
        CircleImageView cView;
        LinearLayout linearLayout;

    }
}
