package example.com.trackside.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.trackside.Data.Data;
import example.com.trackside.R;

/**
 * Created by User on 7/14/2017.
 */

public class ReplayRecyclerViewAdapter extends RecyclerView.Adapter<ReplayRecyclerViewAdapter.ViewHolder> {
    ArrayList<Data> data;
    Context context;

    public ReplayRecyclerViewAdapter(ArrayList<Data> data,Context context) {
        this.data = data;
        this.context=context;
    }


    @Override
    public ReplayRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.replay_card_layout,parent,false);
        ReplayRecyclerViewAdapter.ViewHolder vh=new ReplayRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageResource(data.get(position).getImageId());
            holder.textView.setText(data.get(position).getTxt());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.replay_textView);
            imageView=(ImageView)itemView.findViewById(R.id.replay_image);
        }
    }
}
