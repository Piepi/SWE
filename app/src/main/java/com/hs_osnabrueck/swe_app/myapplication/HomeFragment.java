package com.hs_osnabrueck.swe_app.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HomeFragment extends Fragment {

    private View rootView;
    private Button scan;
    private TextView score, rank, beaconinfo, veranstaltung1, veranstaltung2, veranstaltung3;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        scan = (Button)rootView.findViewById(R.id.homescreen_scan_button);

        score = (TextView)rootView.findViewById(R.id.homescreen_score);
        score.setBackgroundResource(R.drawable.cell_shape);
        score.setText("Score: 20");

        rank = (TextView)rootView.findViewById(R.id.homescreen_rank);
        rank.setBackgroundResource(R.drawable.cell_shape);
        rank.setText("Rank: 2");


        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return rootView;
    }
}
