package tr.edu.ege.cs.egenav.test;

import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.IOUtils;
import tr.edu.ege.cs.egenav.direction.GSMDirectionResponse;
import tr.edu.ege.cs.egenav.direction.Polyline;
import tr.edu.ege.cs.egenav.direction.PolylineDeserializer;

/**
 * @author Özgün Yılmaz
 * Created on 14.May.2014, 16:10:01
 */
public class GSMDirectionURLTest2 {
    
    public static void main(String args[]) throws MalformedURLException, IOException{
        
        String url = "http://maps.googleapis.com/maps/api/directions/json?origin=Chicago,IL&destination=Los+Angeles,CA&waypoints=Joplin,MO|Oklahoma+City,OK&sensor=false";
        // Get the contents of json as a string using commons IO IOUTils class.
        
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Polyline.class, new PolylineDeserializer());
        //gson.registerTypeAdapter(GSMBounds.class, new BoundsDeserializer());
        GSMDirectionResponse res = gson.create().fromJson(IOUtils.toString(new URL(url)), GSMDirectionResponse.class);
        System.out.println(res);
        System.out.println(res.getStatus());
        System.out.println(res.getRoutes()[0].getOverviewPolyline().getOverviewPolyline());
//        Dataset[] datasets = albums.getDataset();
//        for (Dataset dataset : datasets) {
//            //System.out.println(dataset.getAlbumTitle());
//            System.out.println(dataset.get("artist_name"));
//        }
        
    }
    
}
