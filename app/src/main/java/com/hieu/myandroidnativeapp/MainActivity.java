package com.hieu.myandroidnativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.hieu.myandroidnativeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myandroidnativeapp' library on application startup.
    static {
        System.loadLibrary("myandroidnativeapp");
        System.loadLibrary("isPrimeNumber");
    }

    private ActivityMainBinding binding;
    private Button btnCheckJava;
    private Button btnCheckC;
    private TextInputEditText txtFieldC;
    private TextInputEditText txtFieldJava;
    private TextView textViewTimeC;
    private TextView textViewTimeJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getViews(binding);
        setContentView(binding.getRoot());

        btnCheckC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtFieldC.getText().toString().isEmpty()){
                    int no = Integer.parseInt(txtFieldC.getText().toString());
                    long start1= System.currentTimeMillis();
                    if(isPrimeNumber(no)==1){
                        Toast.makeText(MainActivity.this,"Prime Number",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Not Prime Number",Toast.LENGTH_LONG).show();

                    }
                    long end1 = System.currentTimeMillis();
                    long t1= (end1-start1)/2;
                    String s1=String.valueOf(t1);
                    s1=s1+" mili giây";
                    textViewTimeC.setText("Thời gian: "+ s1);
                }
            }
        });
        btnCheckJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtFieldJava.getText().toString().isEmpty()){
                    int no = Integer.parseInt(txtFieldJava.getText().toString());
                    long start1= System.currentTimeMillis();
                    if(isPrimeNumberJava(no)==1){
                        Toast.makeText(MainActivity.this,"Prime Number",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(MainActivity.this,"Not Prime Number",Toast.LENGTH_LONG).show();

                    }
                    long end1 = System.currentTimeMillis();
                    long t1= (end1-start1)/2;
                    String s1=String.valueOf(t1);
                    s1=s1+" mili giây";
                    textViewTimeJava.setText("Thời gian: "+ s1);
                }
            }
        });
    }

    private void getViews(ActivityMainBinding binding) {
        btnCheckC = binding.btnCheckC;
        btnCheckJava=binding.btnCheckJava;
        txtFieldC=binding.textFieldC;
        txtFieldJava=binding.textFieldJava;
        textViewTimeC= binding.txtTimeC;
        textViewTimeJava=binding.txtTimeJava;
    }

    /**
     * A native method that is implemented by the 'myandroidnativeapp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String helloFromNative();
    public native int isPrimeNumber(int number);
    public  int isPrimeNumberJava(int number){
        int isPrime = 1;
        for(int i=2;i<=number/2;i++){
            if(number%i==0){
                return 0;
            }else{
                isPrime=1;
            }
        }
        return isPrime;
    }
}