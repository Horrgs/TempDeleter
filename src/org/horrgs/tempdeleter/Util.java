package org.horrgs.tempdeleter;

import java.io.File;

/**
 * Created by Horrgs on 7/5/2014.
 */
public class Util {

    public void deleteDir(File dir) {
        if(dir.isDirectory()) {
            String[] children = dir.list();
            for(int x = 0; x < children.length; x++) {
                deleteDir(new File(dir, children[x]));
            }
        }
    }
}
