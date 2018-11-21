package com.cassby.terminal.pinpadexample;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cassby.terminal.pinpad.PinpadFragment;

public class MainActivity extends AppCompatActivity {

    private PinpadFragment pinpadFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pinpadFragment = new PinpadFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, pinpadFragment);
        fragmentTransaction.commit();

        pinpadFragment.setTint(209,96,111);
        pinpadFragment.setKeyColor(255,255,255);
    }
}
