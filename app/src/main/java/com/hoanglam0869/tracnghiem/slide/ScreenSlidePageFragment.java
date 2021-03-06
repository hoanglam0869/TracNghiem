package com.hoanglam0869.tracnghiem.slide;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.hoanglam0869.tracnghiem.R;
import com.hoanglam0869.tracnghiem.question.Question;

import org.parceler.Parcels;

import java.util.ArrayList;

public class ScreenSlidePageFragment extends Fragment {

    ArrayList<Question> arr_Ques;
    public static final String ARG_PAGE = "page";
    public static final String ARG_CHECKANSWER = "checkAnswer";
    public int mPageNumber;     // vị trí trang hiện tại
    public int checkAns;        // biến kiểm tra

    TextView tvNum, tvQuestion;
    RadioGroup radioGroup;
    RadioButton radA, radB, radC, radD;
    ImageView imgIcon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques = new ArrayList<>();
        ScreenSlideActivity screenSlideActivity = (ScreenSlideActivity) getActivity();
        arr_Ques = screenSlideActivity.getData();
        
        mPageNumber = getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        tvNum = rootView.findViewById(R.id.tvNum);
        tvQuestion = rootView.findViewById(R.id.tvQuestion);
        radioGroup = rootView.findViewById(R.id.radGroup);
        radA = rootView.findViewById(R.id.radA);
        radB = rootView.findViewById(R.id.radB);
        radC = rootView.findViewById(R.id.radC);
        radD = rootView.findViewById(R.id.radD);
        imgIcon = rootView.findViewById(R.id.ivIcon);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        tvNum.setText("Câu " + arr_Ques.get(mPageNumber).get_id());
        tvQuestion.setText(getItem(mPageNumber).getQuestion());
        radA.setText(getItem(mPageNumber).getAns_a());
        radB.setText(getItem(mPageNumber).getAns_b());
        radC.setText(getItem(mPageNumber).getAns_c());
        radD.setText(getItem(mPageNumber).getAns_d());
        //imgIcon.setImageResource(getResources().getIdentifier(getItem(mPageNumber).getImage() + "", "drawable", "com.hoanglam0869.tracnghiem"));

        if (checkAns != 0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getItem(mPageNumber).getResult());
        }
        
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                getItem(mPageNumber).choiceID = checkedId;
                getItem(mPageNumber).setTraloi(getChoiceFromID(checkedId));
                //Toast.makeText(getActivity(), "Đây là đáp án" + checkedId, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static ScreenSlidePageFragment create(int pageNumber, int checkAnswer){
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        args.putInt(ARG_CHECKANSWER, checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    public Question getItem(int position){
        return arr_Ques.get(position);
    }

    // Lấy giá trị (vị trí) radiogroup chuyển thành đáp án A/B/C/D
    private String getChoiceFromID(int ID){
        if (ID == R.id.radA){
            return "A";
        }else if (ID == R.id.radB){
            return "B";
        }else if (ID == R.id.radC){
            return "C";
        }else if (ID == R.id.radD){
            return "D";
        }else return "";
    }

    // Hàm kiểm tra câu đúng, nếu câu đúng thì đổi màu background radiobutton tương ứng
    private void getCheckAns(String ans){
        if (ans.equals("A")){
            if (getItem(mPageNumber).getTraloi().equals("A")){
                radA.setBackgroundColor(Color.GREEN);
            } else {
                radA.setBackgroundColor(Color.RED);
            }
        } else if (ans.equals("B")){
            if (getItem(mPageNumber).getTraloi().equals("B")){
                radB.setBackgroundColor(Color.GREEN);
            } else {
                radB.setBackgroundColor(Color.RED);
            }
        } else if (ans.equals("C")){
            if (getItem(mPageNumber).getTraloi().equals("C")){
                radC.setBackgroundColor(Color.GREEN);
            } else {
                radC.setBackgroundColor(Color.RED);
            }
        } else {
            if (getItem(mPageNumber).getTraloi().equals("D")){
                radD.setBackgroundColor(Color.GREEN);
            } else {
                radD.setBackgroundColor(Color.RED);
            }
        }
    }
}