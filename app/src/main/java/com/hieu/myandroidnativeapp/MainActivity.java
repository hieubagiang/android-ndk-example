package com.hieu.myandroidnativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText txtFieldC;
    private TextInputEditText txtFieldJava;
    private TextView textViewTimeC;
    private TextView textViewTimeJava;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Connect connect = new Connect();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        getViews(binding);
        setContentView(binding.getRoot());

        btnCheckC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!txtFieldC.getText().toString().isEmpty()){
                    String out="";
                    long input = Long.valueOf( txtFieldC.getText().toString());
                    long start = System.currentTimeMillis();

                    long result = connect.javaRecursive(input);

                    long stop = System.currentTimeMillis();

                    out += String.format("Time taken for Java recursion: %d (%d msec)", result, stop - start);

                    start = System.currentTimeMillis();

                    long res = connect.nativeRecursive(Integer.valueOf(String.valueOf(input)));

                    stop = System.currentTimeMillis();

                    out += String.format("\n\nTime taken for native recursion: %d (%d msec)", res, stop - start);


                    textViewTimeC.setText(out);
                }
            }
        });

    }

    private void getViews(ActivityMainBinding binding) {
        btnCheckC = binding.buttonGo;
//        btnCheckJava=binding.btnCheckJava;
        txtFieldC=binding.editInput;
        textViewTimeC=binding.textResult;
        /*
        txtFieldJava=binding.textFieldJava;
        textViewTimeC= binding.txtTimeC;
        textViewTimeJava=binding.txtTimeJava;
*/    }

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

    public static long javaRecursive(long n) {
        if(n!=0)
        {
            n+=javaRecursive(n-1)+javaRecursive(n-1);
        }
        return n;
    }

}