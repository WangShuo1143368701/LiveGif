package com.ws.livegif.livegif.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.ws.livegif.livegif.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogActivity extends AppCompatActivity {

    @BindView(R.id.add_dia)
    Button addDia;
    @BindView(R.id.rem_dia)
    Button remDia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.add_dia, R.id.rem_dia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_dia:
                FansDialog fansDialog = FansDialog.newInstance(new ArrayList(),"1");
                fansDialog.show(getFragmentManager(),"fansDialog");
                break;
            case R.id.rem_dia:
                break;
        }
    }
}
