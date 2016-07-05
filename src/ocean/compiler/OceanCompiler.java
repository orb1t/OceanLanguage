package ocean.compiler;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahe
 */
public class OceanCompiler {

    BufferedReader CODE_READER = null;
    String CODE = "";
    String SyntaxINI = "";
    String baseDir = "C:/Users/Mahe/Documents/NetBeansProjects/Ocean/src/";

    public OceanCompiler(String codeFile) {
        this.readSyntax();
        CODE = codeFile;
        this.readCode();
        boolean valid = false;
        
    }

    private void readSyntax() {
        BufferedReader br = null;
        try {
            File syntaxFile = new File(baseDir + "/ocean/lang/Syntax.odi");
            br = new BufferedReader(new FileReader(syntaxFile));
            boolean eof = false;
            int c = 0;
            while (!eof) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        break;
                    }
                    SyntaxINI += s + "\n";
                } catch (EOFException e) {
                    System.err.println(e.getMessage());
                    eof = true;
                } catch (IOException ex) {
                    Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Read Code : \n" + SyntaxINI);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void readCode() {
        BufferedReader br = null;
        try {
            File syntaxFile = new File(CODE);
            CODE = "";
            br = new BufferedReader(new FileReader(syntaxFile));
            boolean eof = false;
            int c = 0;
            while (!eof) {
                try {
                    String s = br.readLine();
                    if (s == null) {
                        break;
                    }
                    CODE += s + "\n";
                } catch (EOFException e) {
                    System.err.println(e.getMessage());
                    eof = true;
                } catch (IOException ex) {
                    Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Read Code : \n" + CODE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(OceanCompiler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
