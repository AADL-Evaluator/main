package org.osate.evaluator;

import javax.swing.SwingUtilities;
import org.osate.aadl.evaluator.file.ProjectFile;
import org.osate.aadl.evaluator.project.Component;
import org.osate.aadl.evaluator.project.ComponentPackage;
import org.osate.aadl.evaluator.project.Connection;
import org.osate.aadl.evaluator.project.Feature;
import org.osate.aadl.evaluator.project.Project;
import org.osate.aadl.evaluator.project.Property;
import org.osate.aadl.evaluator.project.Subcomponent;
import org.osate.aadl.evaluator.ui.edit.ComponentJDialog;

public class ComponentJDialogMain 
{
    
    public static void main( String[] args ) throws Exception
    {
        String projectDir = "/home/avld/projects/Netbeans Projects/AadlEvaluator/examples/example 01/";
        final Project project = ProjectFile.open( projectDir );
        
        SwingUtilities.invokeLater( new Runnable() {
            @Override
            public void run() {
                final ComponentJDialog dialog = new ComponentJDialog( null );
                dialog.setComponent( getComponent( project ) );
                dialog.setVisible( true );
                dialog.dispose();
                
                print( dialog.getComponent() );
            }
        });
    }
    
    private static Component getComponent( Project project )
    {
        ComponentPackage pack = project.getPackages().get( "aadlbook::integration" );
        
        for( Component c : pack.getComponents().values() )
        {
            return c;
        }
        
        return null;
    }
    
    private static void print( Component component )
    {
        System.out.print( component.getType() );
        
        if( component.isImplementation() )  
        {
            System.out.print( " implementation" );
        }
        
        System.out.print( " " + component.getName() );
        
        if( component.getExtend() != null 
            && !component.getExtend().trim().isEmpty() )  
        {
            System.out.print( " extend " + component.getExtend() );
        }
        
        System.out.println();
        
        System.out.println( "" );
        System.out.println( "  Features" );
        
        for( Feature feature : component.getFeatures().values() )
        {
            System.out.println( "    " + feature.getName() + " : " + feature.getValue() + ";" );
        }
        
        System.out.println( "" );
        System.out.println( "  Subcomponents" );
        
        for( Subcomponent subcomponent : component.getSubcomponents().values() )
        {
            System.out.println( "    " + subcomponent.getName() + " : " + subcomponent.getValue() + ";" );
        }
        
        System.out.println( "" );
        System.out.println( "  Connections" );
        
        for( Connection connection : component.getConnections().values() )
        {
            System.out.println( "    " + connection.getName() + " : " + connection.getValue() + ";" );
        }
        
        System.out.println( "" );
        System.out.println( "  Properties" );
        
        for( Property property : component.getProperties() )
        {
            System.out.println( "    " + property.getName() + " => " + property.getValue() + ";" );
        }
    }
}
