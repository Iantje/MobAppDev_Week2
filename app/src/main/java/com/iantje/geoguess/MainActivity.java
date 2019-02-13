package com.iantje.geoguess;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {
    private List<GeoPlace> _geoPlaceList = new ArrayList<>();
    private RecyclerView _recyclerView;

    private GestureDetector _gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < GeoPlace.PRE_DEFINED_GEO_IMAGE_IDS.length; i++) {
            _geoPlaceList.add(new GeoPlace(
                    GeoPlace.PRE_DEFINED_GEO_NAMES[i],
                    GeoPlace.PRE_DEFINED_GEO_IMAGE_IDS[i],
                    GeoPlace.PRE_DEFINED_GEO_IN_EUROPE[i]));
        }

        _recyclerView = findViewById(R.id.recyclerView);
        _recyclerView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                        false));

        final GeoPlaceAdapter geoPlaceAdapter = new GeoPlaceAdapter(this, _geoPlaceList);
        _recyclerView.setAdapter(geoPlaceAdapter);

        _recyclerView.addOnItemTouchListener(this);

        _gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        ItemTouchHelper.SimpleCallback textSlideCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                GeoPlace swipedPlace = _geoPlaceList.get(position);

                if(swipeDir == ItemTouchHelper.LEFT && swipedPlace.ismGeoInEurope() ||
                        swipeDir == ItemTouchHelper.RIGHT && !swipedPlace.ismGeoInEurope()) {
                    // Correct
                    Snackbar.make(viewHolder.itemView, R.string.correct, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    _geoPlaceList.remove(position);
                    geoPlaceAdapter.notifyItemRemoved(position);
                } else {
                    // Incorrect
                    Snackbar.make(viewHolder.itemView, R.string.incorrect, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    geoPlaceAdapter.notifyItemChanged(position);
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(textSlideCallback);
        itemTouchHelper.attachToRecyclerView(_recyclerView);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView r, @NonNull MotionEvent e) {
        View child = r.findChildViewUnder(e.getX(), e.getY());
        int adapterPosition = r.getChildAdapterPosition(child);

        if (child != null && _gestureDetector.onTouchEvent(e)) {
            Toast.makeText(this, _geoPlaceList.get(adapterPosition).getmGeoName(),
                    Toast.LENGTH_SHORT).show();
        }

        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }
}
