package com.hoanglam0869.tracnghiem.score;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hoanglam0869.tracnghiem.question.DBHelper;
import com.hoanglam0869.tracnghiem.question.Question;

import java.util.ArrayList;

public class ScoreController {
    private DBHelper dbHelper;

    public ScoreController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void insertScore(String name, int score, String room){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        values.put("room", room);
        db.insert("score", null, values);
        db.close();
    }

    // Lấy danh sách điểm
    public Cursor getScore(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("score",   // tên bảng
                null,                    // danh sách cột cần lấy
                null,                    // điều kiện where
                null,                // đối số điều kiện where
                null,                    // biểu thức Groupby
                null,                      // biểu thức Having
                "id DESC",                // biểu thức order by
                null
                 );
        if (cursor != null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
