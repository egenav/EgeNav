package tr.edu.ege.cs.egenav;

import tr.edu.ege.cs.egenav.direction.Directions;
import java.awt.Point;
import java.util.ArrayList;

/**
 * @author Özgün Yılmaz
 * Created on 04.Nis.2014, 14:35:45
 */
public class GSMMapURL extends MapURL{
    
    //marker,styled maps, paths
    //visible parametresini ekle.
    
    private boolean sensor=false;
    private String apiKey,signature,language,region;
    private int scale=-1;
    private ArrayList<GSMPath> paths;   
    private ArrayList<GSMMarker> markers;
    private ArrayList<GSMStyle> styles;
    
    public static final int MAX_ZOOM=21;
    
    
    public GSMMapURL(){
        setMiddleURL("maps.googleapis.com/maps/api/staticmap?");
        setSeparator("&");
    }
    
    public GSMMapURL(String apiKey){
        this();
        this.apiKey=apiKey;
    }
    
    public GSMMapURL(String clientID,String signature){
        this();
        setClientID(clientID);
        this.signature=signature;
    }
    
    @Override
    public boolean incrementZoom(){
        if (getZoom()<MAX_ZOOM){
            setZoom(getZoom()+1);
            return true;
        }
        return false;
    }
    
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }
    
    @Override
    public Location getLocation(){
        return super.getLocation();
    }
    
    public Location getCenter() {
        return getLocation();
    }

    public void setCenter(Location center) {
        setLocation(center);
    }
    
    public void setCenter(GeoPoint center) {
        setLocation(new Location(center));
    }
    
    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public boolean isSensor() {
        return sensor;
    }

    public void setSensor(boolean sensor) {
        this.sensor = sensor;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    

    @Override
    public String getAbsoluteURLString() {
        
        String url;
        
        if (isSecure()){
            url="https://";
        }else{
            url="http://";
        }
        
        url=url+getMiddleURL();
        
        if (getCenter()!=null){
            url=url+"center="+getCenter().toString()+getSeparator();
        }
        
        if (getZoom()!=-1){
            url=url+"zoom="+getZoom()+getSeparator();
        }
        
        url=url+"size="+getMapSize().getHorizontal()+"x"+getMapSize().getVertical()+getSeparator()+
                "sensor="+isSensor()+getSeparator();
        
        if (getScale()!=-1){
            url=url+"scale="+getScale()+getSeparator();
        }
        
        if (getFormat()!=null && !getFormat().isEmpty()){
            
            url=url+"format="+getFormat()+getSeparator();
        }
        
        if (getMapType()!=null && !getMapType().isEmpty()){
            
            url=url+"maptype="+getMapType()+getSeparator();
        }
        
        if (getLanguage()!=null && !getLanguage().isEmpty()){
            url=url+"language="+getLanguage()+getSeparator();
        }
                
        if (getRegion()!=null && !getRegion().isEmpty()){
            url=url+"region="+getRegion()+getSeparator();
        }
        
        if (paths!=null && !paths.isEmpty()){
            for (int i=0;i<paths.size();i++){
                url=url+paths.get(i).toString()+getSeparator();
            }
        }
        
        if (styles!=null && !styles.isEmpty()){
            for (int i=0;i<styles.size();i++){
                url=url+styles.get(i).toString()+getSeparator();
            }
        }
        
        if (markers!=null && !markers.isEmpty()){
            for (int i=0;i<markers.size();i++){
                url=url+markers.get(i).toString()+getSeparator();
            }
        }
        
        for (int i=0;i<parameters.size();i++){
            url=url+parameters.get(i).toString()+getSeparator();
        }
        
        if (getApiKey()!=null && !getApiKey().isEmpty()){
            
            url=url+"key="+getApiKey()+getSeparator();
        }
        
        if (getClientID()!=null && !getClientID().isEmpty()){
            
            url=url+"client="+getClientID()+getSeparator();
        }
        
        if (getSignature()!=null && !getSignature().isEmpty()){
            
            url=url+"signature="+getSignature()+getSeparator();
        }
        
        while (url.endsWith(getSeparator())){
            url=url.substring(0, url.lastIndexOf(getSeparator()));
        }
        
        return url;
    }

    @Override
    public GSMMapURL clone() {
        
        GSMMapURL gsm=new GSMMapURL();
        gsm.setApiKey(getApiKey());
        gsm.setCenter(getCenter().clone());
        gsm.setClientID(getClientID());
        gsm.setFormat(getFormat());
        gsm.setLanguage(getLanguage());
        gsm.setMapSize(getMapSize().clone());
        gsm.setMapType(getMapType());
        gsm.setMiddleURL(getMiddleURL());
        gsm.setRegion(getRegion());
        gsm.setScale(getScale());
        gsm.setSecure(isSecure());
        gsm.setSensor(isSensor());
        gsm.setSeparator(getSeparator());
        gsm.setSignature(getSignature());
        gsm.setZoom(getZoom());
        
        return gsm;
    }

    @Override
    public Point getPixelOnMap(double lat, double lon) {
        
        Point p=new Point(getMapSize().getHorizontal()/2+MercatorProjection.getDeltaByLons(this.getLocation().getLongitude(), lon, getZoom()),
                getMapSize().getVertical()/2+MercatorProjection.getDeltaByLats(this.getLocation().getLatitude(), lat, getZoom()));
        //System.out.println(this.getLocation().getLatitude()+","+this.getLocation().getLongitude()+","+lat+","+lon+","+p);
        return p;
    }

    @Override
    public GeoPoint getCordinatesOnMap(Point p) {
        
        GeoPoint gp=new GeoPoint(
                MercatorProjection.getLatByPixels(getCenter().getLatitude(),getMapSize().getVertical()/2-(int)p.getY(),getZoom()),
                MercatorProjection.getLonByPixels(getCenter().getLongitude(),getMapSize().getHorizontal()/2-(int)p.getX(),getZoom()));
        
        return gp;
    }

    @Override
    public GSMMapURL getNeighborTile(int verticalDirection, int horizontalDirection) {
        
        GSMMapURL gsm=clone();
        GeoPoint gp=gsm.getCenter().getGeoPoint();
        double lat=gp.getLatitude();
        double lon=gp.getLongitude();
        
        if (verticalDirection!=Directions.CONSTANT){
            double newLat=MercatorProjection.getLatByPixels(lat,verticalDirection*getMapSize().getVertical(),getZoom());
            gp.setLatitude(newLat);
        }
        
        if (horizontalDirection!=Directions.CONSTANT){
            double newLon=MercatorProjection.getLonByPixels(lon,horizontalDirection*getMapSize().getHorizontal(),getZoom());
            gp.setLongitude(newLon);
        }
        
        return gsm;
        
    }
    
    @Override
    public void removeAllParameters(){
        super.removeAllParameters();
        markers.clear();
        paths.clear();
        styles.clear();
    }

    public ArrayList<GSMPath> getPathList() {
        return paths;
    }

    public void setPathList(ArrayList<GSMPath> pathList) {
        this.paths = pathList;
    }
    
    public ArrayList<GSMStyle> getStyleList() {
        return styles;
    }

    public void setStyleList(ArrayList<GSMStyle> styleList) {
        this.styles = styleList;
    }

    public ArrayList<GSMMarker> getMarkerList() {
        return markers;
    }

    public void setMarkerList(ArrayList<GSMMarker> markers) {
        this.markers = markers;
    }
    
    public void addPath(GSMPath path){
        if (paths==null){
            paths=new ArrayList<GSMPath>();
        }
        paths.add(path);
    }
    
    public void addStyle(GSMStyle style){
        if (styles==null){
            styles=new ArrayList<GSMStyle>();
        }
        styles.add(style);
    }
    
    public void addMarker(GSMMarker marker){
        if (markers==null){
            markers=new ArrayList<GSMMarker>();
        }
        markers.add(marker);
    }
    
    public boolean removePath(GSMPath path){
        if (paths==null){
            return false;
        }
        return paths.remove(path);
    }
    
    public boolean removeStyle(GSMStyle style){
        if (styles==null){
            return false;
        }
        return styles.remove(style);
    }
    
    public boolean removeMarker(GSMMarker marker){
        if (markers==null){
            return false;
        }
        return markers.remove(marker);
    }
    
    public void removePath(int i){
        if (paths==null){
            return;
        }
        paths.remove(i);
    }
    
    public void removeStyle(int i){
        if (styles==null){
            return;
        }
        styles.remove(i);
    }
    
    public void removeMarker(int i){
        if (markers==null){
            return;
        }
        markers.remove(i);
    }

    @Override
    public boolean isCompatible(MapURL m) {
        
        String mp1=getMapType();
        String mp2=m.getMapType();
        
        if(mp1==null){
            mp1="null";
        }
        
        if(mp2==null){
            mp2="null";
        }
        
        if (!mp1.equals(mp2) || getZoom()!=m.getZoom()){
            return false;
        }
        
        GSMMapURL gm=(GSMMapURL)m;
        
        if ((paths!=null ^ gm.getPathList()!=null) || (paths!=null && gm.getPathList()!=null && paths.size()!=gm.getPathList().size())){
            return false;
        }
                
        if ((markers!=null ^ gm.getMarkerList()!=null) || (markers!=null && gm.getMarkerList()!=null && markers.size()!=gm.getMarkerList().size())){
            return false;
        }
        
        if ((styles!=null ^ gm.getStyleList()!=null) || (styles!=null && gm.getStyleList()!=null && styles.size()!=gm.getStyleList().size())){
            return false;
        }
        
        if ((parameters!=null ^ gm.getParameterList()!=null) || (parameters!=null && gm.getParameterList()!=null && parameters.size()!=gm.getParameterList().size())){
            return false;
        }
        
        if ((paths!=null && gm.getPathList()!=null)){
            for (int i=0; i<paths.size();i++){
                if (!paths.get(i).toString().equals(gm.getPathList().get(i).toString())){
                    return false;
                }
            }
        }
                
        if (markers!=null && gm.getMarkerList()!=null){
            for (int i=0; i<markers.size();i++){
                if (!markers.get(i).toString().equals(gm.getMarkerList().get(i).toString())){
                    return false;
                }
            }
        }
        
        if (styles!=null && gm.getStyleList()!=null){
            for (int i=0; i<styles.size();i++){
                if (!styles.get(i).toString().equals(gm.getStyleList().get(i).toString())){
                    return false;
                }
            }
        }
        
        if (parameters!=null && gm.getParameterList()!=null){
            for (int i=0; i<parameters.size();i++){
                if (!parameters.get(i).toString().equals(gm.getParameterList().get(i).toString())){
                    return false;
                }
            }
        }
        
        return true;
    }

    @Override
    public MapPosition intersects(MapURL mapurl) {
        
        //        String mp1=getMapType();
//        String mp2=mapurl.getMapType();
//        
//        if(mp1==null){
//            mp1="null";
//        }
//        
//        if(mp2==null){
//            mp2="null";
//        }
//        
//        if (!mp1.equals(mp2) || getZoom()!=mapurl.getZoom()){
//            return new MapPosition(false);
//        }
        
        if (!isCompatible(mapurl)){
            return new MapPosition(false);
        }
        
        int h=getMapSize().getHorizontal()/2;
        int v=getMapSize().getVertical()/2;
        GSMMapURL gm=(GSMMapURL)mapurl;
        Point p=getPixelOnMap(gm.getLocation().getLatitude(),gm.getLocation().getLongitude());
        int h2=p.x;
        int v2=p.y;
        int dh=h2-h;
        int dv=v2-v;
        
        if (Math.abs(dh)>=getMapSize().getHorizontal() || Math.abs(dv)>=getMapSize().getVertical()){
            return new MapPosition(false);
        }
        
        MapPosition mp=new MapPosition(true);
        mp.setDeltaHorizontal(dh);
        mp.setDeltaVertical(dv);
        return mp;
        
    }
    
//    public static GSMMapURL parseString() {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    
}
