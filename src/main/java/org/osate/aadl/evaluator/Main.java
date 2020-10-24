package org.osate.aadl.evaluator;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.LogManager;
import javax.swing.ImageIcon;
import org.osate.aadl.evaluator.ui.MainWizardJFrame;
import org.osate.aadl.evaluator.ui.automaticWizard.AutomaticAadlUIAction;
import org.osate.aadl.evaluator.ui.mainWizard.AadlUIManager;
import org.osate.aadl.evaluator.ui.mainWizard.SystemAadlUIAction;
import org.osate.aadl.evaluator.ui.secondWizard.ManualAadlUIAction;

public class Main 
{
    
    public static void main( String args[] )
    {
        System.out.println( "Reading logger configuration file..." );
        loggerInit();
        
        System.out.println( "Reading images..." );
        addAllUIAction();
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWizardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWizardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWizardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWizardJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println( "Starting the GUI..." );
                
                MainWizardJFrame frame = new MainWizardJFrame();
                frame.setIconImages( loadImages() );
                frame.setVisible( true );
            }
        });
    }
    
    // from: https://www.logicbig.com/tutorials/core-java-tutorial/logging/customizing-default-format.html
    private static void loggerInit()
    {
        InputStream stream = Main.class.getClassLoader().getResourceAsStream( "logging.properties" );
        
        try 
        {
            LogManager.getLogManager().readConfiguration( stream );
        }
        catch ( IOException e )
        {
          e.printStackTrace();
        }
    }
    
    // from: https://www.flaticon.com/free-icon/performance_2906035
    private static List<Image> loadImages()
    {
        List<Image> images = new LinkedList<>();
        
        try
        {
            ClassLoader cl = Main.class.getClassLoader();
            images.add( new ImageIcon( cl.getResource( "evaluator-64.png" ) ).getImage() );
            images.add( new ImageIcon( cl.getResource( "evaluator-32.png" ) ).getImage() );
            images.add( new ImageIcon( cl.getResource( "evaluator-24.png" ) ).getImage() );
            images.add( new ImageIcon( cl.getResource( "evaluator-16.png" ) ).getImage() );
        }
        catch( Exception err )
        {
            err.printStackTrace();
        }
        
        return images;
    }
    
    private static void addAllUIAction()
    {
        AadlUIManager.getInstance().add( new SystemAadlUIAction() );
        AadlUIManager.getInstance().add( new ManualAadlUIAction() );
        AadlUIManager.getInstance().add( new AutomaticAadlUIAction() );
    }
    
}