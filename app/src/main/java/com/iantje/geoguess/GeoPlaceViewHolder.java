package com.iantje.geoguess;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class GeoPlaceViewHolder extends RecyclerView.ViewHolder {
    public ImageView _imageView;
    private View _view;

    public GeoPlaceViewHolder(@NonNull View itemView) {
        super(itemView);

        _imageView = itemView.findViewById(R.id.imageView);
        _view = itemView;
    }

    public ImageView get_imageView() {
        return _imageView;
    }

    public void set_imageView(ImageView _imageView) {
        this._imageView = _imageView;
    }
}
