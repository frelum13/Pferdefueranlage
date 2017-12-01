package server.main;

import java.io.IOException;
import server.datenbank.Database;
import server.server.Server;

/**
 *
 * @author lukas
 */
public class Main {
    public final static String VERSION = "0.3";
    
    public static boolean WATER = false;
    public static int TIME = 0;
    public static int TURNAROUND = 0;
    public static String STOP = null;
    
    public static String ERROR = null;
    
    public static void main(String[] args) throws IOException {
        new Server(1111).start();
    }
}
