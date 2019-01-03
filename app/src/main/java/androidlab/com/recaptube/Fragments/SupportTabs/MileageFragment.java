package androidlab.com.recaptube.Fragments.SupportTabs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MileageFragment extends AsyncTask<Void,Void,String> {
    ProgressDialog progressDialog;
    Context context;
    JSONObject jsonObject = null;
    JSONArray jsonArray = null;
    String path = "https://www.logics-builder.com/smart/my_reservation.php";


    @Override
    protected void onPreExecute() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("we are loading data");
        progressDialog.setCancelable(false);
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            OutputStream outputStream=httpURLConnection.getOutputStream();
            BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();


            //===========================================
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

            String finalData = reader.readLine();


            try {
                jsonArray = new JSONArray(finalData);
                for(int i=0;i<jsonArray.length();i++) {
                    jsonObject = jsonArray.getJSONObject(i);

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {

        progressDialog.dismiss();


    }
}