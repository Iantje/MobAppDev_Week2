package com.iantje.geoguess;

public class GeoPlace {
    public static final String[] PRE_DEFINED_GEO_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Columbia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static final int[] PRE_DEFINED_GEO_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static final boolean[] PRE_DEFINED_GEO_IN_EUROPE = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };

    private String mGeoName;
    private int mGeoImageName;
    private boolean mGeoInEurope;

    public GeoPlace(String mGeoName, int mGeoImageName, boolean mGeoInEurope) {
        this.mGeoName = mGeoName;
        this.mGeoImageName = mGeoImageName;
        this.mGeoInEurope = mGeoInEurope;
    }

    public String getmGeoName() {
        return mGeoName;
    }

    public int getmGeoImageName() {
        return mGeoImageName;
    }

    public boolean ismGeoInEurope() {
        return mGeoInEurope;
    }
}
