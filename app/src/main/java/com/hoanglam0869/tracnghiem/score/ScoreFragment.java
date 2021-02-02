package com.hoanglam0869.tracnghiem.score;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hoanglam0869.tracnghiem.R;

public class ScoreFragment extends Fragment {

    ListView lvScore;
    ScoreController scoreController;
    ScoreAdapter scoreAdapter;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_score, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        scoreController = new ScoreController(getActivity());
        lvScore = getActivity().findViewById(R.id.lvScore);
        Cursor cursor = scoreController.getScore();
        scoreAdapter = new ScoreAdapter(getActivity(), cursor, true);
        lvScore.setAdapter(scoreAdapter);
    }
}