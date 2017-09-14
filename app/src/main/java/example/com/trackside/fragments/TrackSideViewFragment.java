package example.com.trackside.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;

import example.com.trackside.Adapter.ReplayRecyclerViewAdapter;
import example.com.trackside.Data.Data;
import example.com.trackside.R;
import example.com.trackside.TestComponents;

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

        ImageView view1=(ImageView) view.findViewById(R.id.view1);
        ImageView view2=(ImageView) view.findViewById(R.id.view2);
        ImageView view3=(ImageView) view.findViewById(R.id.view3);
        ImageView view4=(ImageView) view.findViewById(R.id.view4);


        String path = "android.resource://" + getActivity().getApplicationContext().getPackageName() + "/" + R.raw.race;
//        view1.setVideoURI(Uri.parse(path));
//        //view1.start();
//        view2.setVideoURI(Uri.parse(path));
//        //view2.start();
//        view3.setVideoURI(Uri.parse(path));
//        view4.setVideoURI(Uri.parse(path));

        startOnTouchVideoActivity(view1);
        startOnTouchVideoActivity(view2);
        startOnTouchVideoActivity(view3);
        startOnTouchVideoActivity(view4);

        layoutManager=new LinearLayoutManager(getActivity());
        adapter=new ReplayRecyclerViewAdapter(data,getContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return view;

    }

    void startOnTouchVideoActivity(ImageView view)
    {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity().getApplicationContext(), TestComponents.class);
                startActivity(in);
            }
        });
    }
}
