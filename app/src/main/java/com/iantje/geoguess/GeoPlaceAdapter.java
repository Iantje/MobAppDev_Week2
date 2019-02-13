package com.iantje.geoguess;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class GeoPlaceAdapter extends RecyclerView.Adapter<GeoPlaceViewHolder> {
    private Context _context;
    private List<GeoPlace> _geoPlaceList;

    public GeoPlaceAdapter(Context context, List<GeoPlace> geoPlaceList) {
        _context = context;
        _geoPlaceList = geoPlaceList;
    }

    @NonNull
    @Override
    public GeoPlaceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.geoplace_tempalte,
                viewGroup, false);

        return new GeoPlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GeoPlaceViewHolder geoPlaceViewHolder, int i) {
        final GeoPlace geoPlace = _geoPlaceList.get(i);

        geoPlaceViewHolder._imageView.setImageResource(geoPlace.getmGeoImageName());
    }

    @Override
    public int getItemCount() {
        return _geoPlaceList.size();
    }
}
