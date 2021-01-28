package com.hoanglam0869.tracnghiem.monhoc.vatly;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VatLyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VatLyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đề thi môn vật lý");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
