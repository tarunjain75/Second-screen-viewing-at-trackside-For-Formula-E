package example.com.trackside.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import example.com.trackside.Adapter.ReplayRecyclerViewAdapter;
import example.com.trackside.Data.Data;
import example.com.trackside.R;

/**
 * Created by User on 7/14/2017.
 */

public class TrackSideViewFragment extends Fragment{
    View view;
    TextView lap_info,Driver_name;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    ArrayList<String> text= new ArrayList<String>();
    ArrayList<Integer> image= new ArrayList<Integer>();
    ArrayList<Data> data=new ArrayList<Data>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text.add("Replay lap 1");
        text.add("Replay lap 2");
        text.add("Replay lap 3");
        image.add(R.drawable.cam3);
        image.add(R.drawable.cam3);
        image.add(R.drawable.cam3);
        for(int i=0;i<text.size();i++){
            data.add(new Data(text.get(i),image.get(i)));
        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.track_side_view_layout,container,false);
        lap_info=(TextView)view.findViewById(R.id.lap_info);
        Driver_name=(TextView)view.findViewById(R.id.driver_name);
        recyclerView=(RecyclerView)view.findViewById(R.id.replay_recyclerView);
        layoutManager=new LinearLayoutManager(getActivity());
        adapter=new ReplayRecyclerViewAdapter(data,getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
