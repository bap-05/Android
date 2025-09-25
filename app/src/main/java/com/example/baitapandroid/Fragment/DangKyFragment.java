package com.example.baitapandroid.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baitapandroid.MainActivity;
import com.example.baitapandroid.R;

public class DangKyFragment extends Fragment implements View.OnClickListener{
private EditText txt_mk, txt_sdt, txt_name;
private Button btn_dk;
private TextView txt_dn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dang_ky, container, false);
        addView(v);
        btn_dk.setOnClickListener(this);
        txt_dn.setOnClickListener(this);
        return v;
    }

    private void addView(View v) {
        txt_sdt = v.findViewById(R.id.txt_sdt_dk);
        txt_mk = v.findViewById(R.id.txt_mk_dk);
        btn_dk = v.findViewById(R.id.btn_dk);
        txt_dn = v.findViewById(R.id.txt_dn);
        txt_name=v.findViewById(R.id.txt_username);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_dk)
        {
            if(!txt_sdt.getText().toString().trim().isEmpty() && !txt_mk.getText().toString().trim().isEmpty()&&!txt_name.getText().toString().trim().isEmpty())
            {
                ((MainActivity)getActivity()).txt_mk=txt_mk.getText().toString();
                ((MainActivity)getActivity()).txt_sdt = txt_sdt.getText().toString();
                Toast.makeText(requireContext(),"Đăng ký thành công",Toast.LENGTH_LONG).show();
                ((MainActivity)requireActivity()).addFragment(new DangNhapFragment());
            }
            else
                Toast.makeText(requireContext(),"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.txt_dn)
        {
            requireActivity().getSupportFragmentManager().popBackStack();
        }
    }
}