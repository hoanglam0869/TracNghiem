package com.hoanglam0869.tracnghiem.question;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cursoradapter.widget.CursorAdapter;

import com.hoanglam0869.tracnghiem.R;

public class QuestionAdapter extends CursorAdapter {
    public QuestionAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_question, null);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView tvQuestion = view.findViewById(R.id.tvQuestion);
        LinearLayout linQues = view.findViewById(R.id.linQues);

        if (cursor.getPosition() % 2 == 0){
            linQues.setBackgroundColor(Color.parseColor("#FFE2DFDF"));
        } else {
            linQues.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }

        tvQuestion.setText(cursor.getString(1));
    }
}
