package com.hoanglam0869.tracnghiem.monhoc.toanhoc;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hoanglam0869.tracnghiem.R;
import com.hoanglam0869.tracnghiem.exam.Exam;
import com.hoanglam0869.tracnghiem.exam.ExamAdapter;
import com.hoanglam0869.tracnghiem.slide.ScreenSlideActivity;

import java.util.ArrayList;

public class ToanHocFragment extends Fragment {

    ExamAdapter examAdapter;
    GridView gvExam;
    ArrayList<Exam> arr_exam = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_toan_hoc, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gvExam = getActivity().findViewById(R.id.gvExam);
        arr_exam.add(new Exam("Đề số 1"));
        arr_exam.add(new Exam("Đề số 2"));
        arr_exam.add(new Exam("Đề số 3"));
        arr_exam.add(new Exam("Đề số 4"));
        arr_exam.add(new Exam("Đề số 5"));
        arr_exam.add(new Exam("Đề số 6"));

        examAdapter = new ExamAdapter(getActivity(), arr_exam);
        gvExam.setAdapter(examAdapter);
        gvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ScreenSlideActivity.class);
                intent.putExtra("num_exam", position + 1);
                intent.putExtra("subject", "toan");
                startActivity(intent);
            }
        });
    }
}