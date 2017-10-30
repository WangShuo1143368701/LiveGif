package com.ws.livegif.livegif.strategy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.ws.livegif.livegif.R;
import com.ws.livegif.livegif.SwipeMenuLayout.SXListActivity;
import com.ws.livegif.livegif.dialog.DialogActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.ws.livegif.livegif.R.id.frame_surfaceview;

public class FrameActivity extends AppCompatActivity {

    @BindView(R.id.button1)
    Button button1;
    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;
    @BindView(R.id.button5)
    Button button5;
    @BindView(R.id.button6)
    Button button6;
    @BindView(R.id.button7)
    Button button7;
    @BindView(R.id.button8)
    Button button8;
    @BindView(R.id.button9)
    Button button9;
    @BindView(R.id.button10)
    Button button10;
    @BindView(frame_surfaceview)
    FrameSurfaceView frameSurfaceview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_frame);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, frame_surfaceview})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("qima");
                //设置单张图片展示时长
                frameSurfaceview.setGapTime(80);
                frameSurfaceview.start();
                break;
            case R.id.button2:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("chuan");
                //设置监听事件
                frameSurfaceview.setOnFrameFinisedListener(new FrameSurfaceView.OnFrameFinishedListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onStop() {

                    }
                });


                //设置单张图片展示时长
                //frame_surfaceview.setRepetition(true);
                frameSurfaceview.setGapTime(100);
                //frame_surfaceview.setQueueTime(1000);
                frameSurfaceview.start();
                break;
            case R.id.button3:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("bullshit");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(40);
                frameSurfaceview.start();
                break;
            case R.id.button4:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("crow");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(50);
                frameSurfaceview.start();
                break;
            case R.id.button5:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("daku");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(60);
                frameSurfaceview.start();
                break;
            case R.id.button6:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("hby");
                //设置单张图片展示时长
                frameSurfaceview.setGapTime(50);
                frameSurfaceview.start();
                break;
            case R.id.button7:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("car");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(100);
                frameSurfaceview.start();
                break;
            case R.id.button8:
                //设置资源文件
                frameSurfaceview.setBitmapAssetFile("huabanyu");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(50);
                frameSurfaceview.start();
                break;
            case R.id.button9:
                /*//设置资源文件
                frameSurfaceview.setBitmapAssetFile("gif/crow");

                //设置单张图片展示时长
                frameSurfaceview.setGapTime(50);
                frameSurfaceview.start();*/
                Intent intent2 = new Intent(FrameActivity.this, SXListActivity.class);
                startActivity(intent2);
                break;
            case R.id.button10:
                Intent intent = new Intent(FrameActivity.this, DialogActivity.class);
                startActivity(intent);
                break;
            case frame_surfaceview:
                break;
        }
    }
}
