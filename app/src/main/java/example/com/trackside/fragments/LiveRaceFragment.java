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

import java.util.ArrayList;

import example.com.trackside.Adapter.LiveRaceRecyclerViewAdapter;
import example.com.trackside.Adapter.VerticalRecyclerViewAdapter;
import example.com.trackside.Data.Data;
import example.com.trackside.Data.LiveData;
import example.com.trackside.R;

/**
 * Created by User on 7/14/2017.
 */

public class LiveRaceFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    ArrayList<String> text= new ArrayList<String>();
    ArrayList<Integer> image= new ArrayList<Integer>();
    ArrayList<String> name= new ArrayList<String>();
    ArrayList<String> lap= new ArrayList<String>();
    ArrayList<LiveData> data=new ArrayList<LiveData>();
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data will be updated here
        text.add("#1");
        text.add("#2");
        text.add("#3");
        image.add(R.drawable.pic);
        image.add(R.drawable.pic);
        image.add(R.drawable.pic);
        name.add("sebestian");
        name.add("name a");
        name.add("name b");
        lap.add("1/30");
        lap.add("2/30");
        lap.add("3/30");
        for(int i=0;i<text.size();i++){
            data.add(new LiveData(text.get(i),image.get(i),name.get(i),lap.get(i)));
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.live_race_fragment,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.live_Race_RecyclerView);

        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new LiveRaceRecyclerViewAdapter(data,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;
    }
}
