/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.datenbank;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author lukas
 */
public class Backup {
    
    public static void MakeBackup() throws IOException {
        String dump = "C:/Program_Files/MySQL/MySQL_Server_5.7/bin/mysqldump.exe "      //Path to mysql
                + "--host=109.73.158.173 "       //Mysql hostname
                + "--port=3306 "            //Mysql portnumber
                + "--user=root "            //Mysql username
                + "--password=Campus02 "        //Mysql password
                + "--add-drop-table "       //Add a DROP TABLE statement before each CREATE TABLE statement
                + "--add-drop-database "    //Add a DROP DATABASE statement before each CREATE DATABASE statement
                + "--complete-insert "      //Use complete INSERT statements that include column names.
                + "--extended-insert "      //Use multiple-row INSERT syntax that include several VALUES lists
                + "horse";                   //Mysql databasename

        Process run = Runtime.getRuntime().exec(dump);

        InputStream in = run.getInputStream();

        int nextChar;
        StringBuffer sb = new StringBuffer();

        while ((nextChar = in.read()) != -1) {
            sb.append((char) nextChar);
        }

        //Here, you can for example write it to a file and save it
        System.out.println(sb);
    }
}
