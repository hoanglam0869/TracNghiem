package com.hoanglam0869.tracnghiem.monhoc.toanhoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ToanHocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ToanHocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đề thi môn toán học");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
