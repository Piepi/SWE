package com.hs_osnabrueck.swe_app.myapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
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
    private Beacon beacon;

    private final static int REQUEST_ENABLE_BT = 1;
    private BluetoothManager btManager;
    private BluetoothAdapter btAdapter = null;
    private BeaconSearch bs;

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

        beaconinfo = (TextView)rootView.findViewById(R.id.homescreen_beaconinfo);
        beaconinfo.setBackgroundResource(R.drawable.cell_shape);

        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btManager = (BluetoothManager)getActivity().getSystemService(Context.BLUETOOTH_SERVICE);
                btAdapter = btManager.getAdapter();
                if (btAdapter != null && !btAdapter.isEnabled()) {
                    Intent enableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableIntent,REQUEST_ENABLE_BT);
                }
                bs = new BeaconSearch();
                new Timer().execute();
                btAdapter.startLeScan(bs.getLeScanCallback());
                beacon = new Beacon(bs.getBeacon());
                beaconinfo.setText(beacon.getName() + "\n" + beacon.getId() + "\n" + beacon.getRssi());

            }

        });
        return rootView;
    }

    public class Timer extends AsyncTask<Integer, Void, Void> {

        @Override
        protected Void doInBackground(Integer... time) {
            try {
                Thread.sleep(1000);
                btAdapter.stopLeScan(bs.getLeScanCallback());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }
    }

}
