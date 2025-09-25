package com.example.baitapandroid.Fragment;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.baitapandroid.MainActivity;
import com.example.baitapandroid.R;


public class DangNhapFragment extends Fragment implements View.OnClickListener{
    private EditText txt_sdt, txt_mk;
    private Button btn_dangNhap;
    private TextView txt_dangKy;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dang_nhap, container, false);
        addView(v);
        btn_dangNhap.setOnClickListener(this);
        txt_dangKy.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        txt_mk = v.findViewById(R.id.txt_mk);
        txt_sdt = v.findViewById(R.id.txt_sdt);
        btn_dangNhap= v.findViewById(R.id.btn_dn);
        txt_dangKy = v.findViewById(R.id.txt_dk);
    }

    @Override
    public void onClick(View v) {
        MainActivity m = (MainActivity)getActivity();
        if(v.getId()==R.id.btn_dn)
        {

            if(txt_mk.getText().toString().equals(m.txt_mk)&&txt_sdt.getText().toString().equals(m.txt_sdt))
            {
                AlertDialog.Builder bl = new AlertDialog.Builder(requireContext())
                        .setMessage("Đăng nhập thành công !")
                        .setCancelable(true)
                        .setPositiveButton("Ok",((dialog, id) -> dialog.dismiss() ));
                bl.show();
            }else
            {
                AlertDialog.Builder bl = new AlertDialog.Builder(requireContext())
                        .setMessage("Đăng nhập thất bại !")
                        .setCancelable(true)
                        .setPositiveButton("Ok",((dialog, id) -> dialog.dismiss() ));
                bl.show();
            }
        }if(v.getId()==R.id.txt_dk)
        {
            m.addFragment(new DangKyFragment());
        }
    }
}