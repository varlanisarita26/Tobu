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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class FragmentMoments extends Fragment {
    private View view;
    private RecyclerView rvCalender,rvAction,rvAddMoments;
    private LinearLayoutManager layoutManager;
    private Adapter adapter;
    private Calendar calendar;
    ArrayList images = new ArrayList<>(Arrays.asList(R.drawable.ic_launcher_foreground,R.drawable.s11,R.drawable.s13,R.drawable.s14));
    private List<MyCalendar> calendarList= new ArrayList<>();
    private CalendarAdapter calendarAdapter;
    public FragmentMoments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_moments, container, false);
        initialization();
        setUpCalendar();
        return view;
    }

    private void initialization() {
        calendar = Calendar.getInstance();
        rvCalender = view.findViewById(R.id.rvCalender);
        rvCalender.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvCalender.setLayoutManager(layoutManager);

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

    private void setUpCalendar() {
        String monthName = calendar.getDisplayName(Calendar.MONTH,Calendar.SHORT, Locale.ENGLISH);
        int totalNoofDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for ( int i=1; i <=totalNoofDays; i++) {
            MyCalendar myCalendar = new MyCalendar(i,monthName);
            calendarList.add(myCalendar);
        }

        calendarAdapter = new CalendarAdapter(view.getContext(),calendarList,calendar);
        rvCalender.setAdapter(calendarAdapter);
    }
}