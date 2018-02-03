/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientss.data;

/**
 *
 * @author lukas
 */
public enum Command 
{
    DELETE, NEW, ALL, INFO, LOGIN, GET, WATER, START, STOP, VERSION;

    private final static String[] text =
    {
      "delete","new","all","info","login","get","water","start","stop","version"  
    };
    
    @Override
    public String toString() {
        return text[ordinal()];
    }
    
    
}
