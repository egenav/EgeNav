package tr.edu.ege.cs.egenav;

/**
 * @author Özgün Yılmaz
 * Created on 04.Nis.2014, 14:12:40
 */
public class GSMMapType {
    
    public static final String ROADMAP="roadmap";
    public static final String SATELLITE="satellite";
    public static final String TERRAIN="terrain";
    public static final String HYBRID="hybrid";
    
    public static String[] getMapTypes(){
        String[] types={ROADMAP,SATELLITE,TERRAIN,HYBRID};
        return types;
    }
}
