package com.hieu.myandroidnativeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.hieu.myandroidnativeapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'myandroidnativeapp' library on application startup.
    static {
        System.loadLibrary("myandroidnativeapp");
        System.loadLibrary("ndktest");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(ndkBuildTestFromJNI());
    }

    /**
     * A native method that is implemented by the 'myandroidnativeapp' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String helloFromNative();
    public native String ndkBuildTestFromJNI();
}