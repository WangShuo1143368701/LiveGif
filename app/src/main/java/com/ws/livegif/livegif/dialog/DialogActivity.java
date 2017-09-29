package com.ws.livegif.livegif.dialog;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

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
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
        ButterKnife.bind(this);

        String htmlFor02 = "项目图片测试：" + "<img src='" + R.drawable.ic_launcher + "'>" + "<img src='"
                + R.drawable.ship1 + "'>";
        tv.setText(Html.fromHtml(htmlFor02, new Html.ImageGetter() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public Drawable getDrawable(String source) {

                int id = Integer.parseInt(source);
                Drawable drawable = getResources().getDrawable(id, null);
               /* drawable.setBounds(0, 0, drawable.getIntrinsicWidth() ,
                        drawable.getIntrinsicHeight());*/
                drawable.setBounds(0, 0, 40 ,
                        40);
                return drawable;
            }
        }, null));

    }

    @OnClick({R.id.add_dia, R.id.rem_dia})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add_dia:
                FansDialog fansDialog = FansDialog.newInstance(new ArrayList(), "1");
                fansDialog.show(getFragmentManager(), "fansDialog");
                break;
            case R.id.rem_dia:
                break;
        }
    }
}
