package com.hoanglam0869.tracnghiem.monhoc.hoahoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HoaHocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HoaHocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đề thi môn hóa học");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
