package com.ws.livegif.livegif.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.ws.livegif.livegif.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A on 2017/9/12.
 */

public class FansDialog extends DialogFragment {

    private int pWidth;
    private int pHeight;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.Dialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        DisplayMetrics dm = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
        pWidth = dm.widthPixels;
        pHeight = dm.heightPixels;

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.BOTTOM;
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = (int) (pHeight*0.8);  // 高
        window.getAttributes().windowAnimations = R.style.Dialog;
        window.setAttributes(lp);
        getDialog().setCanceledOnTouchOutside(true);
    }

    public static final FansDialog newInstance(ArrayList respones, String id) {
        FansDialog fragment = new FansDialog();
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        bundle.putParcelableArrayList("list", respones);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
            String roomId = bundle.getString("id");
            List respones = bundle.getParcelableArrayList("list");
        }
        View view = inflater.inflate(R.layout.dialog_fans, container);
        return view;
    }


}
