package com.ws.livegif.livegif;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.ws.livegif.livegif.strategy.FrameActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by WangShuo on 2016/8/18.
 */
public class MainActivity extends AppCompatActivity {

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
    @BindView(R.id.gif_view)
    GifImageView gifView;
    @BindView(R.id.frame_surfaceview)
    FrameAnimation frame_surfaceview;

    int[] srcId =
            {R.drawable.ship1, R.drawable.ship2, R.drawable.ship3, R.drawable.ship4,
                    R.drawable.ship5, R.drawable.ship6, R.drawable.ship7,
                    R.drawable.ship8

            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //取消标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Intent intent = new Intent(MainActivity.this,FrameActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                gifView.setImageDrawable(null);

                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("chuan");
                //设置监听事件
                frame_surfaceview.setOnFrameFinisedListener(new FrameAnimation.OnFrameFinishedListener() {
                    @Override
                    public void onStop() {


                    }

                    @Override
                    public void onStart() {

                    }
                });

                //设置单张图片展示时长
                //frame_surfaceview.setRepetition(true);
                frame_surfaceview.setGapTime(500);
                //frame_surfaceview.setQueueTime(1000);
                frame_surfaceview.start();
                break;
            case R.id.button3:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("bullshit");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(40);
                frame_surfaceview.start();
                break;
            case R.id.button4:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("crow");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(50);
                frame_surfaceview.start();
                break;
            case R.id.button5:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("daku");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(60);
                frame_surfaceview.start();
                break;
            case R.id.button6:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("hby");
                frame_surfaceview.setQueuePlayMode(false);
                //设置单张图片展示时长
                frame_surfaceview.setGapTime(50);
                frame_surfaceview.start();
                break;
            case R.id.button7:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("car");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(100);
                frame_surfaceview.start();
                break;
            case R.id.button8:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("huabanyu");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(50);
                frame_surfaceview.start();
                break;
            case R.id.button9:
                try {
                    frame_surfaceview.stop();
                    gifView.setImageDrawable(null);
                    GifDrawable gifDrawable = new GifDrawable(getResources(), R.drawable.anim_flag_iceland);
                    gifView.setImageDrawable(gifDrawable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button10:
                gifView.setImageDrawable(null);
                //设置资源文件
                frame_surfaceview.setBitmapAssetFile("gif/crow");

                //设置单张图片展示时长
                frame_surfaceview.setGapTime(50);
                frame_surfaceview.start();
                break;
        }
    }
}
