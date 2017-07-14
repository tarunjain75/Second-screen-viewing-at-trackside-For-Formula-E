package example.com.trackside.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import example.com.trackside.Data.LiveData;
import example.com.trackside.R;

/**
 * Created by User on 7/14/2017.
 */

public class LiveRaceRecyclerViewAdapter extends RecyclerView.Adapter<LiveRaceRecyclerViewAdapter.ViewHolder> {
    ArrayList<LiveData> data;
    Context context;
    public LiveRaceRecyclerViewAdapter(ArrayList<LiveData> data, Context context) {
        this.data=data;
        this.context=context;
    }

    @Override
    public LiveRaceRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.live_race_card_layout,parent,false);
        LiveRaceRecyclerViewAdapter.ViewHolder vh=new LiveRaceRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getTxt());
        holder.circularImageView.setImageResource(data.get(position).getImageId());
        holder.driverName.setText(data.get(position).getName());
        holder.driverLap.setText(data.get(position).getLap());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView,driverName,driverLap;
        public CircularImageView circularImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.LiveRaceTextView);
            circularImageView=(CircularImageView)itemView.findViewById(R.id.LiveRaceCircularImageView);
            driverLap=(TextView)itemView.findViewById(R.id.lap_number);
            driverName=(TextView)itemView.findViewById(R.id.driverName);

        }
    }
}
