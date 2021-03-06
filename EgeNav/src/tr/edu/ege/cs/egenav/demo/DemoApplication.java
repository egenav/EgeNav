/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DemoApplication.java
 *
 * Created on 03.Haz.2014, 14:41:04
 */
package tr.edu.ege.cs.egenav.demo;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import tr.edu.ege.cs.egenav.GSMMapType;
import tr.edu.ege.cs.egenav.GSMMapURL;
import tr.edu.ege.cs.egenav.GeoPoint;
import tr.edu.ege.cs.egenav.Location;
import tr.edu.ege.cs.egenav.MapSize;
import tr.edu.ege.cs.egenav.direction.GSMDirectionResponse;
import tr.edu.ege.cs.egenav.direction.GSMDirectionURL;
import tr.edu.ege.cs.egenav.mapcache.MemoryMapCache;

/**
 *
 * @author Özgün Yılmaz
 */
public class DemoApplication extends javax.swing.JFrame {
    
    GSMMapURL m;
    MemoryMapCache cache;
    SimulationThread st;
    Voice voice;

    /** Creates new form DemoApplication */
    public DemoApplication() {
        
        try{
            m=new GSMMapURL();  //Create a new Google static map url object.

            m.setCenter(new Location(new GeoPoint(38.461154,27.091094)));  //Set center location of the map
            m.setZoom(15);  //set zoom level

            m.setMapSize(new MapSize(500,500));  //set map size

            cache=new MemoryMapCache("MapData"); //create memory mapped cache object and store maps under ./MapData directory
            
            initComponents(); //GUI

            mp.setNavPanel(np);  //set the navigation panel for the map panel
            mp.refreshMap();     //show the map represented by the MapURL object
            VoiceManager voiceManager = VoiceManager.getInstance();  //get voice manager
            voice = voiceManager.getVoice("kevin16");   //get a voice
            voice.allocate();
            voice.setRate(120) ;
            mp.setVoice(voice); //set voice object for the map panel
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getStackTrace(), "Error occurred", JOptionPane.ERROR_MESSAGE);
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        np = new tr.edu.ege.cs.egenav.ui.DefaultNavigationInformationPanel2();
        jPanel1 = new javax.swing.JPanel();
        type = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        zoom = new javax.swing.JComboBox(new String[] {/*"1","2","3",*/"4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"/*,"21"*/});
        jPanel2 = new javax.swing.JPanel();
        btnGo = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        txtLon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtLat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDest = new javax.swing.JTextField();
        btnGetSupport = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtSim = new javax.swing.JTextField();
        btnBrowse = new javax.swing.JButton();
        btnStartSim = new javax.swing.JButton();
        chkRealTime = new javax.swing.JCheckBox();
        btnStopSim = new javax.swing.JButton();
        mp = new tr.edu.ege.cs.egenav.ui.MapPanel(m,cache);
        hint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EgeNav Demo Navigation Application");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        np.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation Information"));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Map properties"));

        type.setModel(new javax.swing.DefaultComboBoxModel(GSMMapType.getMapTypes()));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel1.setText("Map type:");

        jLabel2.setText("Zoom level:");

        zoom.setSelectedIndex(11);
        zoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(zoom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(zoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigate"));

        btnGo.setText("Go");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        txtLon.setText("27.086159");

        jLabel4.setText("Longitude:");

        txtLat.setText("38.461507");

        jLabel3.setText("Latitude:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtLon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGo)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset)
                        .addGap(30, 30, 30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnGo)))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Navigation support"));

        jLabel5.setText("Destination (coordinates or an address):");

        txtDest.setText("38.458734,27.095171");

        btnGetSupport.setText("Get support");
        btnGetSupport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetSupportActionPerformed(evt);
            }
        });

        btnReset2.setText("Reset");
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnGetSupport)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtDest, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetSupport)
                    .addComponent(btnReset2)))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Simulation"));

        jLabel6.setText("File name:");

        txtSim.setText("SimData.sim");

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        btnStartSim.setText("Start simulation");
        btnStartSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartSimActionPerformed(evt);
            }
        });

        chkRealTime.setSelected(true);
        chkRealTime.setText("Real time simulation");

        btnStopSim.setText("Stop");
        btnStopSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopSimActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(chkRealTime)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtSim, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowse))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnStartSim)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStopSim)
                        .addGap(43, 43, 43)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowse))
                .addGap(18, 18, 18)
                .addComponent(chkRealTime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStartSim)
                    .addComponent(btnStopSim))
                .addContainerGap())
        );

        javax.swing.GroupLayout mpLayout = new javax.swing.GroupLayout(mp);
        mp.setLayout(mpLayout);
        mpLayout.setHorizontalGroup(
            mpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        mpLayout.setVerticalGroup(
            mpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        hint.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 12));
        hint.setText("<html><b>Quick start steps:</b><br><b>1.</b> Press the <b>'Go'</b> button in the 'Navigate' panel.<br><b>2.</b> Press <b>'Get support'</b> button in the 'Navigation support' panel.<br><b>3.</b> Press the <b>'Start simulation'</b> button in the 'Simulation' panel.</html>");
        hint.setToolTipText("Follow these steps to get a quick glimpse of the demo application");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hint, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(np, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(hint))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(np, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(mp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // When the map type changes set selected item as new map type of the MapURL object
        m.setMapType((String)type.getSelectedItem());
        // call refreshMap method to refresh the map shown on the map panel
        mp.refreshMap();
    }//GEN-LAST:event_typeActionPerformed

    private void zoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomActionPerformed
        // When the zoom level changes set selected item as new zoom level of the MapURL object
        m.setZoom(Integer.parseInt((String)zoom.getSelectedItem()));
        // call refreshMap method to refresh the map shown on the map panel
        mp.refreshMap();
    }//GEN-LAST:event_zoomActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //When the window is closing, allocated resources are released
        if (voice!=null) {
            voice.deallocate();
        }
        System.out.println("closed");
        cache.close();  //cache should be closed
    }//GEN-LAST:event_formWindowClosing

    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        //When the user clicks go button, map panel's map url is updated with a new location
        double lat=Double.parseDouble(txtLat.getText());
        double lon=Double.parseDouble(txtLon.getText());
        mp.updateLocation(new Location (lat,lon));
    }//GEN-LAST:event_btnGoActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        //When reset button is clicked, navigation history is cleared and the map is repainted
        mp.clearNavigationHistory();
        mp.repaint();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnGetSupportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetSupportActionPerformed
        //There should be a location to get direction support
        if (mp.getLastLocation()==null){
            JOptionPane.showMessageDialog(null, "First should move to a place by using 'Navigate' panel", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //new GSMDirectionURL object is created for using Google Directions service
        GSMDirectionURL dir=new GSMDirectionURL(mp.getLastLocation(),new Location (txtDest.getText()));
        dir.setLanguage("en");  //language is set to English
        try {
            GSMDirectionResponse res=dir.getDirections();  //Directions are get from GSMDirectionURL object and then assigned to direction response
            mp.setDirection(res);  //map panel's direction object is set
            
        } catch (MalformedURLException ex) {
            Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(DemoApplication.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.toString()+"\n\nYour internet connection might be down", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGetSupportActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        //if reset is clicked map panel's direction object is set to null.
        mp.setDirection(null);
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed
        //When browse button is clicked, a file chooser dialog box is shown
        JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Simulation files (*.sim)", "sim");
        fc.setFileFilter(filter);

        if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION){
            txtSim.setText(fc.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_btnBrowseActionPerformed

    private void btnStartSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartSimActionPerformed
        //SimulationThread is created and simulation is started
        st=null;
        NavInfoList list=new NavInfoList(txtSim.getText());
        st=new SimulationThread(mp,list,chkRealTime.isSelected());
        st.start();
    }//GEN-LAST:event_btnStartSimActionPerformed

    private void btnStopSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopSimActionPerformed
        //Stop the simulation
        if (st!=null){
            st.stop2();
        }
        
    }//GEN-LAST:event_btnStopSimActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new DemoApplication().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.JButton btnGetSupport;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnStartSim;
    private javax.swing.JButton btnStopSim;
    private javax.swing.JCheckBox chkRealTime;
    private javax.swing.JLabel hint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private tr.edu.ege.cs.egenav.ui.MapPanel mp;
    private tr.edu.ege.cs.egenav.ui.DefaultNavigationInformationPanel2 np;
    private javax.swing.JTextField txtDest;
    private javax.swing.JTextField txtLat;
    private javax.swing.JTextField txtLon;
    private javax.swing.JTextField txtSim;
    private javax.swing.JComboBox type;
    private javax.swing.JComboBox zoom;
    // End of variables declaration//GEN-END:variables
}
