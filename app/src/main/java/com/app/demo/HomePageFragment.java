package com.app.demo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class HomePageFragment extends Fragment {
    private View view;
    private RecyclerView rvMoments,rvContacts;
    private LinearLayoutManager layoutManager;
    private Adapter adapter;
    private LinearLayout llMoments;
    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_home_page, container, false);
        intialization();
        return view;
    }

    private void intialization() {
        rvMoments = view.findViewById(R.id.rvMoments);
        rvMoments.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvMoments.setLayoutManager(layoutManager);

        adapter = new Adapter(0);
        rvMoments.setAdapter(adapter);

        rvContacts = view.findViewById(R.id.rvContacts);
        rvContacts.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(view.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvContacts.setLayoutManager(layoutManager);

        adapter = new Adapter(1);
        rvContacts.setAdapter(adapter);

        llMoments = view.findViewById(R.id.llMoments);
        llMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new FragmentMoments();
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();
            }
        });
    }
}