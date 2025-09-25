package com.example.baitapandroid;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.baitapandroid.Fragment.DangNhapFragment;

public class MainActivity extends AppCompatActivity {
    public String txt_mk,txt_sdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

            if (savedInstanceState == null) {
                addFragment(new DangNhapFragment());
            }


    }
    public void addFragment(Fragment fr){
        FragmentTransaction fra = getSupportFragmentManager().beginTransaction();
        fra.replace(R.id.frameBody,fr);
        fra.addToBackStack(null);
        fra.commit();
    }
}