package com.example.admin.geolocationmap.View.MainActivity;

import android.app.Activity;
import android.content.Context;

import com.example.admin.geolocationmap.BasePresenter;
import com.example.admin.geolocationmap.BaseView;

/**
 * Created by Admin on 8/22/2017.
 */

public interface MainActivityContract {
    interface View extends BaseView{
        void locationObtained(boolean isObtained);
        void locationEnabled(boolean isEnabled);
    }
    interface Presenter extends BasePresenter<View>{
        void init(Activity activity);
        void checkLocationActive(Activity activity);
        void getContext(Context context);
        void getLocation(String lat, String lon);
        void getLocationByAddress(String a, String b, String c, String d, String e);
        void getLocationByGeo(String a, String b, String c, String d, String e);
    }

}
