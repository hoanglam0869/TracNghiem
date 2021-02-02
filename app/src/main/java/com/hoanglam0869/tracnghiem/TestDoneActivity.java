package com.hoanglam0869.tracnghiem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hoanglam0869.tracnghiem.question.Question;
import com.hoanglam0869.tracnghiem.score.ScoreController;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question> arr_QuesBegin = new ArrayList<>();
    int numNoAns = 0;
    int numTrue = 0;
    int numFalse = 0;
    int totalScore = 0;

    ScoreController scoreController;

    TextView tvTrue, tvFalse, tvNotAns, tvTotalScore;
    Button btnSaveScore, btnAgain, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);

        scoreController = new ScoreController(TestDoneActivity.this);

        Intent intent = getIntent();
        arr_QuesBegin = (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        begin();
        checkResult();

        totalScore = numTrue * 10;
        tvNotAns.setText("" + numNoAns);
        tvFalse.setText("" + numFalse);
        tvTrue.setText("" + numTrue);
        tvTotalScore.setText("" + totalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát hay không?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        btnSaveScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater = TestDoneActivity.this.getLayoutInflater();
                View view = inflater.inflate(R.layout.alert_dialog_save_score, null);
                builder.setView(view);

                EditText edtName = view.findViewById(R.id.edtName);
                EditText edtRoom = view.findViewById(R.id.edtRoom);
                TextView tvScore = view.findViewById(R.id.tvScore);
                tvScore.setText(totalScore + " điểm");

                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtName.getText().toString();
                        String room = edtRoom.getText().toString();
                        scoreController.insertScore(name, totalScore, room);
                        Toast.makeText(TestDoneActivity.this, "Lưu điểm thành công!", Toast.LENGTH_SHORT).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog b = builder.create();
                b.show();
            }
        });
    }

    private void begin() {
        tvTrue = findViewById(R.id.tvTrue);
        tvFalse = findViewById(R.id.tvFalse);
        tvNotAns = findViewById(R.id.tvNotAns);
        tvTotalScore = findViewById(R.id.tvTotalPoint);
        btnAgain = findViewById(R.id.btnAgain);
        btnSaveScore = findViewById(R.id.btnSaveScore);
        btnExit = findViewById(R.id.btnExit);
    }

    // PT Check kết quả
    public void checkResult(){
        for (int i = 0; i < arr_QuesBegin.size(); i++){
            if (arr_QuesBegin.get(i).getTraloi().equals("")){
                numNoAns++;
            } else if (arr_QuesBegin.get(i).getTraloi().equals(arr_QuesBegin.get(i).getResult())){
                numTrue++;
            } else {
                numFalse++;
            }
        }
    }
}