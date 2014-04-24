package tr.edu.ege.cs.egenav.ui;

import tr.edu.ege.cs.egenav.Location;

/**
 * @author Özgün Yılmaz
 * Created on 24.Nis.2014, 15:04:11
 */
public class NavigationInfo {
    
    private Location location;
    private long timeStamp;
    private int distanceToPreviousLocation;

    public NavigationInfo(Location location, long timeStamp, int distanceToPreviousLocation) {
        this.location = location;
        this.timeStamp = timeStamp;
        this.distanceToPreviousLocation = distanceToPreviousLocation;
    }

    public int getDistanceToPreviousLocation() {
        return distanceToPreviousLocation;
    }

    public void setDistanceToPreviousLocation(int distanceToPreviousLocation) {
        this.distanceToPreviousLocation = distanceToPreviousLocation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
    
    
    
}