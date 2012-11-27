/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package html.index.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

/**
 *
 * @author Michael Hoffer <info@michaelhoffer.de>
 */
public class MyOptions {
    
    @Option(name="-i",usage="input folder", required=true)
    private File in;

    @Option(name="-title", usage="Index Title", required=false)
    private String title = "VRL-Studio Documentation";
    
    @Option(name="-intro", usage="Index Intro Text", required=false)
    private String intro = "Help Index";
    
    @Option(name="-css", usage="CSS File Location", required=false)
    private String cssFile = "resources/css/vrl-documentation.css";

    /**
     * @return the in
     */
    public File getIn() {
        return in;
    }

    /**
     * @param in the in to set
     */
    public void setIn(File in) {
        this.in = in;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * @param intro the intro to set
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return the cssFile
     */
    public String getCssFile() {
        return cssFile;
    }

    /**
     * @param cssFile the cssFile to set
     */
    public void setCssFile(String cssFile) {
        this.cssFile = cssFile;
    }

}
