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

import example.com.trackside.Adapter.HorizontalRecyclerViewAdapter;
import example.com.trackside.Data.Data;
import example.com.trackside.R;


/**
 * Created by User on 7/13/2017.
 */

public class HorizontalDriverFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    ArrayList<String> text= new ArrayList<String>();
    ArrayList<Integer> image= new ArrayList<Integer>();
    ArrayList<Data> data=new ArrayList<Data>();
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
        for(int i=0;i<text.size();i++){
            data.add(new Data(text.get(i),image.get(i)));
        }

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=(View)inflater.inflate(R.layout.driver_fragment_horizontal,container,false);



        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new HorizontalRecyclerViewAdapter(data,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }
}
