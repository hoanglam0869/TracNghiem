package com.hoanglam0869.tracnghiem.monhoc.sinhhoc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SinhHocViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SinhHocViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đề thi môn sinh học");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
