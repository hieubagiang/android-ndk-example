package com.hieu.myandroidnativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.hieu.myandroidnativeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myandroidnativeapp' library on application startup.
    static {
        System.loadLibrary("cmakeBuildLibrary");

    }

    private ActivityMainBinding binding;
    private Button btnCheckC;
    private EditText txtFieldC;
    private TextView textViewTimeC;
    ProgressDialog progressDialog;

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
                    MyTask myTask = new MyTask(textViewTimeC,progressDialog, MainActivity.this);
                    myTask.execute(txtFieldC.getText().toString());

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

}