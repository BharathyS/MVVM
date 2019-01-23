package com.cumulation.mvvmarchitecture.view.home;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.cumulation.mvvmarchitecture.viewmodel.ViewModelFactory;
import com.cumulation.mvvmarchitecture.R;
import com.cumulation.mvvmarchitecture.datamodel.remote.model.Name;
import com.cumulation.mvvmarchitecture.viewmodel.HomeViewModel;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private HomeViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final TextView valuesTv = findViewById(R.id.names_tv);
        findViewById(R.id.refresh_bt).setOnClickListener(this);

        mViewModel = obtainViewModel(this);
        mViewModel.getNames().observe(this, new Observer<List<Name>>() {
            @Override
            public void onChanged(@Nullable List<Name> names) {
                valuesTv.setText(valuesTv.getText() + "\n");
                for (Name name : names) {
                    valuesTv.setText(valuesTv.getText() + name.getName() + "\n");
                }
            }
        });
    }

    public HomeViewModel obtainViewModel(AppCompatActivity activity) {
        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
        HomeViewModel homeViewModel = ViewModelProviders.of(activity, factory).get(HomeViewModel.class);
        return homeViewModel;
    }

    @Override
    public void onClick(View v) {
        mViewModel.start();
    }
}
