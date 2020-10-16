package org.osate.evaluator;

import org.osate.aadl.evaluator.file.ProjectFile;
import org.osate.aadl.evaluator.project.Project;
import org.osate.aadl.evaluator.reqspec.DocumentOrSection;
import org.osate.aadl.evaluator.reqspec.Organization;
import org.osate.aadl.evaluator.reqspec.Reqspec;
import org.osate.aadl.evaluator.reqspec.ReqspecElement;
import org.osate.aadl.evaluator.reqspec.Stakeholder;
import org.osate.aadl.evaluator.reqspec.SystemRequirement;
import org.osate.aadl.evaluator.reqspec.SystemRequirements;

public class ReqspecMain 
{
    
    public static void main( String[] args ) throws Exception
    {
        String directory = "/home/avld/projects/Netbeans Projects/AadlEvaluator/examples/reqspec";
        
        Project project = ProjectFile.open( directory );
        Reqspec reqspec = project.getEspecification();
        
        System.out.println( "*****" );
        System.out.println( "*****" );
        System.out.println( "*****" );
        
        System.out.println( "Reqspec.systems........: " + reqspec.getSystems().size() );
        System.out.println( "Reqspec.global.........: " + reqspec.getGlobals().size() );
        System.out.println( "Reqspec.documents......: " + reqspec.getDocuments().size() );
        System.out.println( "Reqspec.sections.......: " + reqspec.getSections().size() );
        System.out.println( "Reqspec.organizations..: " + reqspec.getOrganizations().size() );
        System.out.println( "Reqspec.goals..........: " + reqspec.getGoals().size() );
        
        System.out.println();
        System.out.println( "-------------" );
        System.out.println( "------------- GLOBAL REQUIREMENTS" );
        System.out.println( "-------------" );
        
        for( SystemRequirements globals : reqspec.getGlobals().values() )
        {
            System.out.println();
            println( "global" , globals );
        }
        
        System.out.println();
        System.out.println( "-------------" );
        System.out.println( "------------- SYSTEM REQUIREMENTS" );
        System.out.println( "-------------" );
        
        for( SystemRequirements requirements : reqspec.getSystems().values() )
        {
            System.out.println();
            println( "system" , requirements );
        }
        
        System.out.println();
        System.out.println( "-------------" );
        System.out.println( "------------- DOCUMENTS" );
        System.out.println( "-------------" );
        
        for( DocumentOrSection document : reqspec.getDocuments().values() )
        {
            System.out.println();
            println( "document" , document );
        }
        
        System.out.println();
        System.out.println( "-------------" );
        System.out.println( "------------- SECTIONS" );
        System.out.println( "-------------" );
        
        for( DocumentOrSection section : reqspec.getSections().values() )
        {
            System.out.println();
            println( "section" , section );
        }
        
        System.out.println();
        System.out.println( "-------------" );
        System.out.println( "------------- ORGANIZATIONS" );
        System.out.println( "-------------" );
        
        for( Organization organization : reqspec.getOrganizations().values() )
        {
            System.out.println();
            println( organization );
        }
    }
    
    private static void println( String text , SystemRequirements reqs )
    {
        System.out.println( "  " + text + ".name...........: " + reqs.getName()   );
        System.out.println( "  " + text + ".title..........: " + reqs.getTitle()  );
        System.out.println( "  " + text + ".target.........: " + reqs.getTarget() );
        System.out.println( "  " + text + ".description....: " + reqs.getDescription() );
        System.out.println( "  " + text + ".issues.........: " + reqs.getIssues() );
        System.out.println( "  " + text + ".use Constansts.: " + reqs.getUseConstants() );
        System.out.println( "  " + text + ".see documents..: " + reqs.getSeeDocuments() );
        System.out.println( "  " + text + ".see Goals......: " + reqs.getSeeGoals()  );
        System.out.println( "  " + text + ".computed.......: " + reqs.getComputeds() );
        System.out.println( "  " + text + ".constants......: " + reqs.getConstants() );
        
        for( SystemRequirement req : reqs.getRequirements().values() )
        {
            println( "   requirement" , req );
            System.out.println();
        }
    }
    
    private static void println( String text , DocumentOrSection ds )
    {
        System.out.println( "  " + text + ".name...........: " + ds.getName()   );
        System.out.println( "  " + text + ".title..........: " + ds.getTitle()  );
        System.out.println( "  " + text + ".target.........: " + ds.getTarget() );
        System.out.println( "  " + text + ".description....: " + ds.getDescription() );
        System.out.println( "  " + text + ".issues.........: " + ds.getIssues() );
        
        for( ReqspecElement req : ds.getGoals().values() )
        {
            println( "   goal" , req );
            System.out.println();
        }
        
        for( ReqspecElement req : ds.getRequirements().values() )
        {
            println( "   requeriment" , req );
            System.out.println();
        }
    }
    
    private static void println( String text , ReqspecElement req )
    {
        System.out.println( "  " + text + ".name...........: " + req.getName()   );
        System.out.println( "  " + text + ".title..........: " + req.getTitle()  );
        System.out.println( "  " + text + ".target.........: " + req.getTarget() );
        System.out.println( "  " + text + ".description....: " + req.getDescription() );
        System.out.println( "  " + text + ".issues.........: " + req.getIssues() );
    }
    
    private static void println( String text , SystemRequirement req )
    {
        System.out.println( "  " + text + ".name...........: " + req.getName()   );
        System.out.println( "  " + text + ".title..........: " + req.getTitle()  );
        System.out.println( "  " + text + ".target.........: " + req.getTarget() );
        System.out.println( "  " + text + ".description....: " + req.getDescription() );
        System.out.println( "  " + text + ".issues.........: " + req.getIssues() );
        System.out.println( "  " + text + ".category.......: " + req.getCategory() );
        System.out.println( "  " + text + ".change Uncert..: " + req.getChangeUncertainty() );
        System.out.println( "  " + text + ".decoposes......: " + req.getDecomposes() );
        System.out.println( "  " + text + ".dev. Stakeold..: " + req.getDevelopmentStakeholder() );
        System.out.println( "  " + text + ".dropped........: " + req.getDropped() );
        System.out.println( "  " + text + ".evolves........: " + req.getEvolves() );
        System.out.println( "  " + text + ".inherits.......: " + req.getInherits() );
        System.out.println( "  " + text + ".mitigates......: " + req.getMitigates() );
        System.out.println( "  " + text + ".predicate......: " + req.getPredicate() );
        System.out.println( "  " + text + ".rationale......: " + req.getRationale() );
        System.out.println( "  " + text + ".refines........: " + req.getRefines() );
        System.out.println( "  " + text + ".see Documents..: " + req.getSeeDocuments() );
        System.out.println( "  " + text + ".see Goals......: " + req.getSeeGoals() );
        System.out.println( "  " + text + ".see Requerement: " + req.getSeeRequirements() );
        System.out.println( "  " + text + ".when condition.: " + req.getWhenCondition() );
        System.out.println( "  " + text + ".computed.......: " + req.getComputeds() );
        System.out.println( "  " + text + ".constants......: " + req.getConstants() );
        System.out.println( "  " + text + ".variables......: " + req.getVariables() );
    }
    
    private static void println( Organization org )
    {
        System.out.println( "  organization.name...........: " + org.getName()   );
        
        for( Stakeholder stake : org.getStakeholders().values() )
        {
            System.out.println( "     stakeholder.name...........: " + stake.getName() );
            System.out.println( "     stakeholder.full name......: " + stake.getFullName() );
            System.out.println( "     stakeholder.title..........: " + stake.getTitle() );
            System.out.println( "     stakeholder.description....: " + stake.getDescription() );
            System.out.println( "     stakeholder.email..........: " + stake.getEmail() );
            System.out.println( "     stakeholder.phone..........: " + stake.getPhone() );
            System.out.println( "     stakeholder.role...........: " + stake.getRole() );
            System.out.println( "     stakeholder.supervisor.....: " + stake.getSupervisor() );
            System.out.println();
        }
    }
    
}