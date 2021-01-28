package com.hoanglam0869.tracnghiem.slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hoanglam0869.tracnghiem.R;
import com.hoanglam0869.tracnghiem.question.Question;

import java.util.ArrayList;

public class CheckAnswerAdapter extends BaseAdapter {

    ArrayList<Question> lsData;
    LayoutInflater inflater;

    public CheckAnswerAdapter(ArrayList<Question> lsData, Context context) {
        this.lsData = lsData;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return lsData.size();
    }

    @Override
    public Object getItem(int position) {
        return lsData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Question data = (Question) getItem(position);
        ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_gridview_list_answer, null);
            holder.tvNumAns = convertView.findViewById(R.id.tvNumAns);
            holder.tvYourAns = convertView.findViewById(R.id.tvAnswer);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        int i = position + 1;
        holder.tvNumAns.setText("Câu " + i + ": ");
        holder.tvYourAns.setText(data.getTraloi());
        return convertView;
    }

    private static class ViewHolder{
        TextView tvNumAns, tvYourAns;
    }
}
