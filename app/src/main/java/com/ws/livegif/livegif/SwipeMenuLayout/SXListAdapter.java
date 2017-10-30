package com.ws.livegif.livegif.SwipeMenuLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ws.livegif.livegif.R;
import com.ws.livegif.livegif.SwipeMenuLayout.badge.Badge;
import com.ws.livegif.livegif.SwipeMenuLayout.badge.QBadgeView;

import java.util.List;

import static android.R.attr.x;
import static android.R.attr.y;


public class SXListAdapter extends RecyclerView.Adapter<SXListAdapter.SXListHolder> {
    private Context mContext;
    private LayoutInflater mInfalter;
    private List<SwipeChatListBean> mDatas;

    public SXListAdapter(Context context, List<SwipeChatListBean> mDatas) {
        mContext = context;
        mInfalter = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public SXListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SXListHolder(mInfalter.inflate(R.layout.item_cst_swipe, parent, false));
    }

    @Override
    public void onBindViewHolder(final SXListHolder holder, final int position) {
        //((SwipeMenuLayout) holder.itemView).setIos(false).setLeftSwipe(position % 2 == 0 ? true : false);//这句话关掉IOS阻塞式交互效果 并依次打开左滑右滑
        holder.iv_chat_head.setImageResource(mDatas.get(position).getHead());
        holder.tv_chat_name.setText(mDatas.get(position).getName());
        holder.tv_chat_content.setText(mDatas.get(position).getContent());
        holder.tv_chat_time.setText("19:30");

        holder.badge = new QBadgeView(mContext).bindTarget(holder.item_layout);
        holder.badge.setBadgeTextSize(12, true);
        holder.badge.setBadgeNumber(position);
        holder.badge.setBadgeGravity(Gravity.END | Gravity.BOTTOM);
        holder.badge.setGravityOffset(10, 10, true);
        holder.badge.setBadgePadding(3, true);
        holder.badge.setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
        @Override
        public void onDragStateChanged(int dragState, Badge badge, View targetView) {
            if (dragState == STATE_SUCCEED) {
                Toast.makeText(mContext, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        }
    });

        initListener(holder,position);
    }

    private void initListener(final SXListHolder holder,final int position){
        //验证长按
        holder.item_layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "longclig", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onLongClick() called with: v = [" + v + "]");
                return false;
            }
        });

        //注意事项，设置item点击，不能对整个holder.itemView设置咯，只能对第一个子View，即原来的content设置，这算是局限性吧。
        (holder.item_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnSwipeListener){
                    mOnSwipeListener.onClickListener(holder.getAdapterPosition());
                }
                Toast.makeText(mContext, "onClick:" + holder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onClick() called with: v = [" + v + "]");
            }
        });
        //置顶：
        holder.btnTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=mOnSwipeListener){
                    mOnSwipeListener.onTop(holder.getAdapterPosition());
                }

            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mOnSwipeListener) {
                    //如果删除时，不使用mAdapter.notifyItemRemoved(pos)，则删除没有动画效果，
                    //且如果想让侧滑菜单同时关闭，需要同时调用 ((CstSwipeDelMenu) holder.itemView).quickClose();
                    //((CstSwipeDelMenu) holder.itemView).quickClose();
                    mOnSwipeListener.onDel(holder.getAdapterPosition());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return null != mDatas ? mDatas.size() : 0;
    }

    /**
     * 和Activity通信的接口
     */
    public interface onSwipeListener {
        void onDel(int pos);

        void onTop(int pos);

        void onClickListener(int pos);
    }

    private onSwipeListener mOnSwipeListener;

    public onSwipeListener getOnDelListener() {
        return mOnSwipeListener;
    }

    public void setOnDelListener(onSwipeListener mOnDelListener) {
        this.mOnSwipeListener = mOnDelListener;
    }

    class SXListHolder extends RecyclerView.ViewHolder {
        Button btnDelete;
        Button btnTop;

        RelativeLayout item_layout;
        ImageView iv_chat_head;
        TextView tv_chat_name;
        TextView tv_chat_content;
        TextView tv_chat_time;
        Badge badge;


        public SXListHolder(View itemView) {
            super(itemView);
            btnDelete = (Button) itemView.findViewById(R.id.btnDelete);
            btnTop = (Button) itemView.findViewById(R.id.btnTop);

            item_layout = (RelativeLayout)itemView.findViewById(R.id.item_layout);
            iv_chat_head =  (ImageView)itemView.findViewById(R.id.iv_chat_head);
            tv_chat_name = (TextView) itemView.findViewById(R.id.tv_chat_name);
            tv_chat_content = (TextView) itemView.findViewById(R.id.tv_chat_content);
            tv_chat_time = (TextView) itemView.findViewById(R.id.tv_chat_time);
        }
    }
}

