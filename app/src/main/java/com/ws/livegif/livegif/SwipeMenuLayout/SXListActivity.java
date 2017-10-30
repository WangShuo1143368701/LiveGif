package com.ws.livegif.livegif.SwipeMenuLayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.ws.livegif.livegif.R;

import java.util.ArrayList;
import java.util.List;

public class SXListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private SXListAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private List<SwipeChatListBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sxlist);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        initDatas();
        mAdapter = new SXListAdapter(this, mDatas);
        mAdapter.setOnDelListener(new SXListAdapter.onSwipeListener() {
            @Override
            public void onDel(int pos) {
                if (pos >= 0 && pos < mDatas.size()) {
                    Toast.makeText(SXListActivity.this, "删除:" + pos, Toast.LENGTH_SHORT).show();
                    mDatas.remove(pos);
                    mAdapter.notifyItemRemoved(pos);//推荐用这个
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((SwipeMenuLayout) holder.itemView).quickClose();
                    //mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTop(int pos) {
                if (pos > 0 && pos < mDatas.size()) {
                    SwipeChatListBean swipeChatListBean = mDatas.get(pos);
                    mDatas.remove(swipeChatListBean);
                    mAdapter.notifyItemInserted(0);
                    mDatas.add(0, swipeChatListBean);
                    mAdapter.notifyItemRemoved(pos + 1);
                    if (mLayoutManager.findFirstVisibleItemPosition() == 0) {
                        mRecyclerView.scrollToPosition(0);
                    }
                    //notifyItemRangeChanged(0,holder.getAdapterPosition()+1);
                }
            }

            @Override
            public void onClickListener(int pos) {

            }
        });
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager = new LinearLayoutManager(this));

        //6 2016 10 21 add , 增加viewChache 的 get()方法，
        // 可以用在：当点击外部空白处时，关闭正在展开的侧滑菜单。我个人觉得意义不大，
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    SwipeMenuLayout viewCache = SwipeMenuLayout.getViewCache();
                    if (null != viewCache) {
                        viewCache.smoothClose();
                    }
                }
                return false;
            }
        });
    }

    private int[] type_db= {R.mipmap.alsaka,R.mipmap.husky,R.mipmap.samoyed,R.mipmap.corgi,R.mipmap.sharpei,
            R.mipmap.pomeranian,R.mipmap.bordeaux,R.mipmap.pitbull,R.mipmap.tibetan,R.mipmap.corso,R.mipmap.capf};
    private String[] name_db={"Alaska","Husky","Samoyed","Corgi","Sharpei","Pomeranian","Bordeaux",
            "Pitbull","Tibetan","Corso","BlackOrder"};
    private String[] content_db={"楼下是傻狗","你才是傻狗","楼上是傻狗","[动画表情]","好吵","我美我不说话","...",
            "大家好我是孙红雷","我能打10个傻狗","哦，你好厉害","[动画表情]"};

    private void initDatas() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < name_db.length; i++) {
            SwipeChatListBean swipeChatListBean = new SwipeChatListBean();
            swipeChatListBean.setContent(content_db[i]);
            swipeChatListBean.setName(name_db[i]);
            swipeChatListBean.setHead(type_db[i]);
            swipeChatListBean.setCount("1");
            mDatas.add(swipeChatListBean);
        }
    }

}
