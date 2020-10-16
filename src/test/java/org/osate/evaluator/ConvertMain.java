package org.osate.evaluator;

import org.osate.aadl.evaluator.unit.MipsUtils;
import org.osate.aadl.evaluator.unit.SizeUtils;
import org.osate.aadl.evaluator.unit.TimeUtils;

public class ConvertMain 
{
    
    public static void main( String[] args )
    {
        size();
        times();
        bitsps();
    }
    
    public static void size()
    {
        System.out.println();
        System.out.println( "SIZE CONVERT" );
        System.out.println( "------------" );
        
        System.out.println( "8 bits to byte......: " + MipsUtils.convert( "8 bits" , "bytes" ) );
        System.out.println( "1000 bytes to KB....: " + SizeUtils.convert( "1000 bytes" , "KB" ) );
        System.out.println( "1000 KB to MB.......: " + SizeUtils.convert( "1000 KB"    , "MB" ) );
        System.out.println( "8000 Kb to MB.......: " + SizeUtils.convert( "8000 Kb"    , "MB" ) );
        
        System.out.println( "1 MB to KB..........: " + SizeUtils.convert( "1 MB"       , "KB" ) );
        System.out.println( "1 MB to Mb..........: " + SizeUtils.convert( "1 MB"       , "Mb" ) );
    }
    
    public static void times()
    {
        System.out.println();
        System.out.println( "TIME CONVERT" );
        System.out.println( "------------" );
        
        System.out.println( "1000 ms to s....: " + TimeUtils.convert( "1000 ms"  , "s" ) );
        System.out.println( "60000 ms to m...: " + TimeUtils.convert( "60000 ms" , "m" ) );
        System.out.println( "300000 ms to h..: " + TimeUtils.convert( "300000 ms" , "h" ) );
        System.out.println( "1 s to ms.......: " + TimeUtils.convert( "1 s"      , "ms" ) );
        System.out.println( "1 m to ms.......: " + TimeUtils.convert( "1 m"      , "ms" ) );
        System.out.println( "1 h to s........: " + TimeUtils.convert( "1 h"      , "s" ) );
    }
    
    public static void bitsps()
    {
        System.out.println();
        System.out.println( "BSPS CONVERT" );
        System.out.println( "------------" );
        
        System.out.println( "1000 kbps to mbps....: " + MipsUtils.convert( "1000 kbps" , "mbps" ) );
        System.out.println( "1000 kbps to gbps....: " + MipsUtils.convert( "1000 kbps" , "gbps" ) );
        
        System.out.println( "1 mbps to kbps.......: " + MipsUtils.convert( "1 mbps" , "kbps" ) );
        
        System.out.println( "1 bytesps to bitsps..: " + MipsUtils.convert( "1 bytesps" , "bitsps" ) );
        System.out.println( "8 bitsps to bytesps..: " + MipsUtils.convert( "8 bitsps" , "bytesps" ) );
    }
    
}