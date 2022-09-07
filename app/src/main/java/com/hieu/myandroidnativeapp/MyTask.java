package com.hieu.myandroidnativeapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

public class MyTask extends AsyncTask<String, Integer, String> {
    private final TextView textViewOutput;
    private ProgressDialog progressDialog;
    final AtomicReference<Context> context = new AtomicReference<Context>();
    public MyTask(TextView txtFieldC, ProgressDialog progressDialog, Context context) {
        this.context.set(context);
        this.progressDialog = progressDialog;
        this.textViewOutput =txtFieldC;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context.get(), null, "Calculating", true,
                true);
        progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {

            @Override
            public void onCancel(DialogInterface dialog) {
                MyTask.this.cancel(true);

            }
        });


    }

    @Override
    protected String doInBackground(String... params) {
        String textNumber = params[0];
        String out="";
        long input = Long.parseLong( textNumber);

        long start = System.currentTimeMillis();
        long result = Connect.javaFibonacci(input);
        long stop = System.currentTimeMillis();
        out += String.format(Locale.ENGLISH,"Fibonacci(%s) = %d\n Time taken for Java method: %d (msec)", textNumber
                ,result, stop - start);

        start = System.currentTimeMillis();
        long res = Connect.nativeFibonacci(Integer.parseInt(String.valueOf(input)));
        stop = System.currentTimeMillis();

        out += String.format(Locale.ENGLISH,"\n\nFibonacci(%s) = %d\n Time taken for Naivte method: %d (msec)",textNumber, res, stop - start);
        return  out;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressDialog.dismiss();
        progressDialog=null;
        textViewOutput.setText(result);
    }
}
