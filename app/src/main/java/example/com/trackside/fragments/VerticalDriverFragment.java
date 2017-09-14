package example.com.trackside.fragments;

import android.graphics.Typeface;
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
import java.util.Locale;

import example.com.trackside.Adapter.VerticalRecyclerViewAdapter;
import example.com.trackside.Data.LiveData;
import example.com.trackside.R;

/**
 * Created by User on 7/14/2017.
 */

public class VerticalDriverFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    ArrayList<String> text= new ArrayList<String>();
    ArrayList<Integer> image= new ArrayList<Integer>();
    ArrayList<LiveData> data=new ArrayList<LiveData>();
    ArrayList<String> name= new ArrayList<String>();
    ArrayList<String> lap= new ArrayList<String>();
    TextView driverInfo;
    private Typeface typeface;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //data will be updated here
        text.add("#1");
        text.add("#2");
        text.add("#3");
        text.add("#4");
        text.add("#5");
        text.add("#6");
        text.add("#7");
        text.add("#8");
        image.add(R.drawable.sam);
        image.add(R.drawable.nelson);
        image.add(R.drawable.stephane);
        image.add(R.drawable.maro);
        image.add(R.drawable.loic);
        image.add(R.drawable.jerome);
        image.add(R.drawable.nicolas);
        image.add(R.drawable.sebestien);
        name.add("Sam Bird");
        name.add("Nelson Piquet Jr.");
        name.add("Stéphane Sarrazin");
        name.add("Maro Engel");
        name.add("Loic Duval");
        name.add("Jérôme d'Ambrosio");
        name.add("Nicolas Prost");
        name.add("Sébastien Buemi");
        lap.add("2");
        lap.add("3");
        lap.add("4");
        lap.add("5");
        lap.add("6");
        lap.add("7");
        lap.add("8");
        lap.add("9");
        for(int i=0;i<text.size();i++){
            data.add(new LiveData(text.get(i),image.get(i),name.get(i),lap.get(i)));
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=(View)inflater.inflate(R.layout.driver_fragment,container,false);
        typeface = Typeface.createFromAsset(this.getActivity().getAssets(),
                String.format(Locale.US, "fonts/%s", "1MuseoSans_100Italic.otf"));


        driverInfo=(TextView)rootView.findViewById(R.id.driver_info);
        driverInfo.setTypeface(typeface);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new VerticalRecyclerViewAdapter(data,getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }
}
