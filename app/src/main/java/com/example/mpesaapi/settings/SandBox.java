package com.example.mpesaapi.settings;

public class SandBox {
    //for access token
    public static final String consumer_key = "EwIRavrMvSg7NBZyNT1lZStvw4liLO0D";
    public static final String consumer_secret = "E1AhfarinI0R440x";

    public static final String initiator_name = "testapi";
    public static final String security_credential = "BTF1eVHRyPSSBI/UzggykzrrhHirK1GmexqrPTHGe/qaCQT+0SSu8teiPS5ouNG0PKIjKW91Q4ozjmlINshBsljD/DXAhT/JpIuPHQTMhcVYkeHIigvm4lRyJrdbLntSM1eqgG695vSbiLwa4xmGJcJjFczdudLov7Jngpt2ebPFDSyqMzZSGotFz2HpLeqHXhyly0JLpVPzATNqA+L82VMR+Ym1sScS8NSW5DeKp9YO9ai2upZGXZhQ7sdIwoI12HX44j/7YgYi++tT9cMXI0fytZHaR8xzOoHoS+lT+9AsnpeeUIudQHT5Gv+ehiszbKzULYqFnIH6ovO/8lQ4bA==";
    public static final String passkey = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
    public static final String command_id = "";

    public static final String short_code = "600130";
    public static final String MSISDN = "254708374149";
    public static final String business_shortcode = "174379";
    public static final String transaction_type = "";

    //custom urls
    public static final String queue_timeout_url = "http://smartforex.co.ke/test/timeout.php";
    public static final String result_url = "http://smartforex.co.ke/test/result.php";
    public static final String confirmation_url = "http://smartforex.co.ke/test/confirmation_url.php";
    public static final String callBack_url = "http://smartforex.co.ke/test/callback.php";
    public static final String validation_url = "http://smartforex.co.ke/test/validation.php";


    //mpesa url;
    public static final String b2c_url="https://sandbox.safaricom.co.ke/mpesa/b2c/v1/paymentrequest";
    public static final String b2b_url="https://sandbox.safaricom.co.ke/mpesa/b2b/v1/paymentrequest";
    public static final String register_url="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/registerurl";
    public static final String c2b_url="https://sandbox.safaricom.co.ke/mpesa/c2b/v1/simulate";
    public static final String acc_bal_url="https://sandbox.safaricom.co.ke/mpesa/accountbalance/v1/query";
    public static final String trans_status_url="https://sandbox.safaricom.co.ke/mpesa/transactionstatus/v1/query";
    public static final String reversal_url="https://sandbox.safaricom.co.ke/mpesa/reversal/v1/request";
    public static final String stkpush_url="https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
    public static final String stkpushquery_url="https://sandbox.safaricom.co.ke/mpesa/stkpushquery/v1/query";


    public static String getPasskey() {
        return passkey;
    }

    public static String getConsumer_key() {
        return consumer_key;
    }

    public static String getConsumer_secret() {
        return consumer_secret;
    }

    public static String getInitiator_name() {
        return initiator_name;
    }

    public static String getSecurity_credential() {
        return security_credential;
    }

    public static String getCommand_id() {
        return command_id;
    }

    public static String getShort_code() {
        return short_code;
    }

    public static String getMSISDN() {
        return MSISDN;
    }

    public static String getBusiness_shortcode() {
        return business_shortcode;
    }

    public static String getTransaction_type() {
        return transaction_type;
    }

    public static String getQueue_timeout_url() {
        return queue_timeout_url;
    }

    public static String getResult_url() {
        return result_url;
    }

    public static String getConfirmation_url() {
        return confirmation_url;
    }

    public static String getCallBack_url() {
        return callBack_url;
    }

    public static String getValidation_url() {
        return validation_url;
    }

    public static String getB2c_url() {
        return b2c_url;
    }

    public static String getB2b_url() {
        return b2b_url;
    }

    public static String getRegister_url() {
        return register_url;
    }

    public static String getC2b_url() {
        return c2b_url;
    }

    public static String getAcc_bal_url() {
        return acc_bal_url;
    }

    public static String getTrans_status_url() {
        return trans_status_url;
    }

    public static String getReversal_url() {
        return reversal_url;
    }

    public static String getStkpush_url() {
        return stkpush_url;
    }

    public static String getStkpushquery_url() {
        return stkpushquery_url;
    }
}
