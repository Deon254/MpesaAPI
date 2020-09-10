package com.example.mpesaapi.utils;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.mpesaapi.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Base64;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.mpesaapi.MainActivity.checkoutRequestID;
import static com.example.mpesaapi.MainActivity.databaseHelper;
import static com.example.mpesaapi.settings.SandBox.getConsumer_key;
import static com.example.mpesaapi.settings.SandBox.getConsumer_secret;
import static com.example.mpesaapi.utils.GenerateValues.date;
import static com.example.mpesaapi.utils.GenerateValues.password;

public class Network {


    public static String requests="url";

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String sendRequest(String requestJson, String url) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestJson);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/json")
                .addHeader("authorization", "Bearer " + accesToken())
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        // System.out.println(response.body().string());
        Log.d("RESPONSE: ", response.body().string());

        if (requests.equals("stk")) {
            String jsonData = response.body().string();
            JSONObject jsonObject = new JSONObject(jsonData);
            Log.d("RESPONSE: ", jsonData);
            checkoutRequestID = jsonObject.getString("CheckoutRequestID");
            //MainActivity mainActivity = new MainActivity();
            databaseHelper.insertSTKPush(password, date, checkoutRequestID);
            Log.d("SQLITE: ","Password: "+password +"\n"+ "Date: "+date +"\n"+ "Checkout: "+checkoutRequestID);
        }
        return response.body().toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String accesToken() throws IOException, JSONException {

        String appKeySecret = getConsumer_key() + ":" + getConsumer_secret();
        byte[] bytes = appKeySecret.getBytes("ISO-8859-1");
        String encoded = Base64.getEncoder().encodeToString(bytes);


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get()
                .addHeader("authorization", "Basic " + encoded)
                .addHeader("cache-control", "no-cache")

                .build();

        Response response = client.newCall(request).execute();
        JSONObject jsonObject = new JSONObject(response.body().string());
        //System.out.println(jsonObject.getString("access_token"));
        Log.d("ACCESS TOKEN: ", jsonObject.getString("access_token"));
        return jsonObject.getString("access_token");
    }


}
