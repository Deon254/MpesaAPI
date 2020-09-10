package com.example.mpesaapi.mpesa;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import static com.example.mpesaapi.utils.Network.sendRequest;
import static com.example.mpesaapi.settings.SandBox.getAcc_bal_url;
import static com.example.mpesaapi.settings.SandBox.getB2b_url;
import static com.example.mpesaapi.settings.SandBox.getB2c_url;
import static com.example.mpesaapi.settings.SandBox.getC2b_url;
import static com.example.mpesaapi.settings.SandBox.getRegister_url;
import static com.example.mpesaapi.settings.SandBox.getReversal_url;
import static com.example.mpesaapi.settings.SandBox.getStkpush_url;
import static com.example.mpesaapi.settings.SandBox.getStkpushquery_url;
import static com.example.mpesaapi.settings.SandBox.getTrans_status_url;

/**
 * This class contains all the methods required.
 **/
public class Mpesa {

    //b2c request
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void businessCustomer(String initiatorName, String securityCredential, String commandID, String amount, String partyA, String partyB, String remarks, String queueTimeOutURL, String resultURL) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("InitiatorName", initiatorName);
        jsonObject.put("SecurityCredential", securityCredential);
        jsonObject.put("CommandID", commandID);
        jsonObject.put("Amount", amount);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("Remarks", remarks);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("ResultURL", resultURL);
        //jsonObject.put("Occassion", occassion);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getB2c_url());
    }

    //b2b request
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void businessBusiness(String initiatorName, String accountReference, String securityCredential, String commandID, String senderIdentifierType, String receiverIdentifierType, String amount, String partyA, String partyB, String remarks, String queueTimeOutURL, String resultURL) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Initiator", initiatorName);
        jsonObject.put("SecurityCredential", securityCredential);
        jsonObject.put("CommandID", commandID);
        jsonObject.put("SenderIdentifierType", senderIdentifierType);
        jsonObject.put("RecieverIdentifierType", receiverIdentifierType);
        jsonObject.put("Amount", amount);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("Remarks", remarks);
        jsonObject.put("AccountReference", accountReference);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("ResultURL", resultURL);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getB2b_url());
    }

    //c2b request
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void customerBusiness(String shortCode, String commandID, String amount, String MSISDN, String billRefNumber) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ShortCode", shortCode);
        jsonObject.put("CommandID", commandID);
        jsonObject.put("Amount", amount);
        jsonObject.put("Msisdn", MSISDN);
        jsonObject.put("BillRefNumber", billRefNumber);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");

        sendRequest(requestJson, getC2b_url());
    }

    //stk push(Lipa Na Mpesa Online)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void lipaNaMpesaOnline(String businessShortCode, String password, String timestamp, String transactionType, String amount, String phoneNumber, String partyA, String partyB, String callBackURL, String queueTimeOutURL, String accountReference, String transactionDesc) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("TransactionType", transactionType);
        jsonObject.put("Amount", amount);
        jsonObject.put("PhoneNumber", phoneNumber);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("PartyB", partyB);
        jsonObject.put("CallBackURL", callBackURL);
        jsonObject.put("AccountReference", accountReference);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("TransactionDesc", transactionDesc);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getStkpush_url());
    }


    //stk push query(Lipa Na Mpesa Online Query)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void lipaNaMpesaOnlineQuery(String businessShortCode, String password, String timestamp, String checkoutRequestID) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("BusinessShortCode", businessShortCode);
        jsonObject.put("Password", password);
        jsonObject.put("Timestamp", timestamp);
        jsonObject.put("CheckoutRequestID", checkoutRequestID);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getStkpushquery_url());

    }

    //account balance
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void accountBalance(String initiator, String commandID, String securityCredential, String partyA, String identifierType, String remarks, String queueTimeOutURL, String resultURL) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Initiator", initiator);
        jsonObject.put("SecurityCredential", securityCredential);
        jsonObject.put("CommandID", commandID);
        jsonObject.put("PartyA", partyA);
        jsonObject.put("IdentifierType", identifierType);
        jsonObject.put("Remarks", remarks);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("ResultURL", resultURL);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getAcc_bal_url());
    }

    //registerUrl
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void registerURL(String shortCode, String responseType, String confirmationURL, String validationURL) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("ShortCode", shortCode);
        jsonObject.put("ResponseType", responseType);
        jsonObject.put("ConfirmationURL", confirmationURL);
        jsonObject.put("ValidationURL", validationURL);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getRegister_url());
    }


    //reversal
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void reversal(String initiator, String securityCredential, String commandID, String transactionID, String amount, String receiverParty, String recieverIdentifierType, String resultURL, String queueTimeOutURL, String remarks) throws IOException, JSONException {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Initiator", initiator);
        jsonObject.put("SecurityCredential", securityCredential);
        jsonObject.put("CommandID", commandID);
        jsonObject.put("TransactionID", transactionID);
        jsonObject.put("Amount", amount);
        jsonObject.put("ReceiverParty", receiverParty);
        jsonObject.put("RecieverIdentifierType", recieverIdentifierType);
        jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
        jsonObject.put("ResultURL", resultURL);
        jsonObject.put("Remarks", remarks);
        //jsonObject.put("Occasion", ocassion);

        jsonArray.put(jsonObject);

        String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
        sendRequest(requestJson, getReversal_url());
    }

    //trans status
@RequiresApi(api = Build.VERSION_CODES.O)
public static void transactionStatus(String initiator,String securityCredential,String commandID,String transactionID,String partyA,String identifierType,String resultURL,String queueTimeOutURL,String remarks) throws JSONException, IOException {
    JSONArray jsonArray = new JSONArray();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("Initiator", initiator);
    jsonObject.put("SecurityCredential", securityCredential);
    jsonObject.put("CommandID", commandID);
    jsonObject.put("TransactionID", transactionID);
    jsonObject.put("PartyA", partyA);
    jsonObject.put("IdentifierType", identifierType);
    jsonObject.put("ResultURL", resultURL);
    jsonObject.put("QueueTimeOutURL", queueTimeOutURL);
    jsonObject.put("Remarks", remarks);


    jsonArray.put(jsonObject);

    String requestJson = jsonArray.toString().replaceAll("[\\[\\]]", "");
    sendRequest(requestJson, getTrans_status_url());
}

}
