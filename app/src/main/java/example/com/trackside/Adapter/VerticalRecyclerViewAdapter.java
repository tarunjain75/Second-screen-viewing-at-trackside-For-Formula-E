package example.com.trackside.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import example.com.trackside.Data.Data;
import example.com.trackside.R;
import example.com.trackside.fragments.DriverInfoFragment;
import example.com.trackside.fragments.LiveRaceFragment;
import example.com.trackside.fragments.TrackSideViewFragment;

import static example.com.trackside.R.id.view;

/**
 * Created by User on 7/14/2017.
 */

public class VerticalRecyclerViewAdapter extends RecyclerView.Adapter<VerticalRecyclerViewAdapter.ViewHolder> {
    ArrayList<Data> data;
    Context context;

    public VerticalRecyclerViewAdapter(ArrayList<Data> data, Context context){
        this.data=data;
        this.context=context;
    }


    @Override
    public VerticalRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_card_layout,parent,false);
        VerticalRecyclerViewAdapter.ViewHolder vh=new VerticalRecyclerViewAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(VerticalRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.circularImageView.setImageResource(data.get(position).getImageId());
        holder.textView.setText(data.get(position).getTxt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment liveRaceFragment = new DriverInfoFragment();
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.framelay, liveRaceFragment).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public CircularImageView circularImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.VerticalTextView);
            circularImageView=(CircularImageView)itemView.findViewById(R.id.VerticalCircularImageView);

        }
    }
}
