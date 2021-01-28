package com.hoanglam0869.tracnghiem.monhoc.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Đây là ứng dụng ôn thi trắc nghiệm Toán, Lý, Hóa Sinh");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
