package gatsan.vehicletracker.models;

/**
 * Created by XSS on 11/03/2018.
 */

public class location {

    private String time, valid, lat, lon, alt, speed, address;

    public void setValues(String t, String v, String lati, String longi, String alti, String s, String ad) {
        time = t;
        valid = v;
        lat = lati;
        lon = longi;
        alt = alti;
        speed = s;
        address = ad;
    }

    public String toString()
    {
        return time + "," + valid + "," + lat + "," + lon + "," + alt + "," + speed + "," + address;
    }
}
