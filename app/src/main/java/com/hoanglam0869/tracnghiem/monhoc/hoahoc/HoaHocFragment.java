package com.hoanglam0869.tracnghiem.monhoc.hoahoc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hoanglam0869.tracnghiem.R;

public class HoaHocFragment extends Fragment {

    private HoaHocViewModel hoaHocViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        hoaHocViewModel = new ViewModelProvider(this).get(HoaHocViewModel.class);
        View root = inflater.inflate(R.layout.fragment_hoa_hoc, container, false);
        final TextView textView = root.findViewById(R.id.text_hoa_hoc);
        hoaHocViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}