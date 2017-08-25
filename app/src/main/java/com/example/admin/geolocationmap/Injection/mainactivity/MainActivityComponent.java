package com.example.admin.geolocationmap.Injection.mainactivity;

import com.example.admin.geolocationmap.View.MainActivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 8/21/2017.
 */

@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
