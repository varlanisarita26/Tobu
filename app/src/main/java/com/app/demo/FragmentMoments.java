package com.app.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentMoments extends Fragment {
    private View view;
    private RecyclerView rvCalender,rvAction,rvAddMoments;
    private LinearLayoutManager layoutManager;
    private Adapter adapter;
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.ic_launcher_foreground,R.drawable.s11,R.drawable.s13,R.drawable.s14));
    public FragmentMoments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_moments, container, false);
        initialization();
        return view;
    }

    private void initialization() {
        rvCalender = view.findViewById(R.id.rvCalender);
        rvCalender.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCalender.setLayoutManager(layoutManager);

        adapter = new Adapter(2);
        rvCalender.setAdapter(adapter);

        rvAction = view.findViewById(R.id.rvAction);
        rvAction.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvAction.setLayoutManager(layoutManager);

        adapter = new Adapter(3);
        rvAction.setAdapter(adapter);

        rvAddMoments = view.findViewById(R.id.rvAddMoments);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rvAddMoments.setLayoutManager(staggeredGridLayoutManager);

        adapter = new Adapter(4,images);
        rvAddMoments.setAdapter(adapter);
    }
}