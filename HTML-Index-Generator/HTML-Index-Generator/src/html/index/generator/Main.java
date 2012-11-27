/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html.index.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MyOptions options = new MyOptions();
        CmdLineParser parser = new CmdLineParser(options);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            printUsage(parser);
            return;
        }

        if (!options.getIn().isDirectory()) {
            System.err.println("-i: specified value is no directory!");
            printUsage(parser);
        }

        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.getAbsolutePath().toLowerCase().endsWith(".html");
            }
        };
        
        File indexFileName = new File(options.getIn(), "index.html");

        HTMLMenuGenerator menuGenerator = new HTMLMenuGenerator(options.getTitle(),
                options.getIntro());
        
        menuGenerator.setTitle(options.getCssFile());
        
        System.out.println(">> creating " + indexFileName);

        for (File f : options.getIn().listFiles(filter)) {

            String name = f.getName();

            name = name.toLowerCase().replace("vrl-studio", "vrlstudio");

            String[] tokens = name.split("-");

            name = "";

            for (String t : tokens) {
                
                t = t.replace("vrlstudio", "VRL-Studio");
                t = t.replace("vrl", "VRL");

                name += t.substring(0, 1).toUpperCase() + t.substring(1) + " ";
            }

            name = name.replace(".html", "").trim();
            
            if (name.startsWith("What Is") || name.startsWith("How To")) {
                name = name+"?";
                
                name = name.replace("??", "?");
            }

            menuGenerator.addMenuEntry(name, f.getName());

            System.out.println(" --> entry-name: " + name);
        }
        
        String indexFile = menuGenerator.render();
        
        try {
            System.out.println(">> writing " + indexFileName);
            writeStringToFile(indexFileName, indexFile);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private static void printUsage(CmdLineParser parser) {
        System.err.println("java -jar myprogram.jar [options...] arguments...");
        parser.printUsage(System.err);
    }

    private static void writeStringToFile(File indexFileName, String indexFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(indexFileName));

        writer.write(indexFile);
        writer.flush();
        writer.close();
    }
}
