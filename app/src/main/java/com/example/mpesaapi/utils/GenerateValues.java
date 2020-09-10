package com.example.mpesaapi.utils;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.mpesaapi.settings.SandBox;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

public class GenerateValues {
    public static String password;
    public static String date;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String generatePassword() throws UnsupportedEncodingException {
        String payBill = SandBox.getBusiness_shortcode();
        String secretKey = SandBox.getPasskey();
        String time = generateDate();
        String psd = payBill + secretKey + time;

        byte[] bytes = psd.getBytes("ISO-8859-1");

        password = Base64.getEncoder().encodeToString(bytes);
        Log.d("PASSWORD: ",password);
        return password;
    }

    public static String generateDate() {
        date = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault()).format(new Date());
        Log.d("DATE: ",date);
        return date;
    }
}
