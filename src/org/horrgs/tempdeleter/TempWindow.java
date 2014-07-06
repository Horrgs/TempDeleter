package org.horrgs.tempdeleter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Horrgs on 7/5/2014.
 */
public class TempWindow extends JFrame {
    private JButton delete;
    public TempWindow() {
        setSize(300, 100);
        setTitle("TempDeleter v1.0 by Horrgs");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        delete = new JButton("Delete");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(delete, gbc);
        delete.addActionListener(new TempActionListener());
        setVisible(true);
    }

    private class TempActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            if(ev.getSource() == delete) {
                String sep = System.getProperty("file.separator");
                String us = System.getProperty("user.name");
                File dir = new File("C:" + sep + "Users" + sep + us + sep + "AppData" + sep + "Local" + "Temp" + sep);
                Util u = new Util();
                u.deleteDir(dir);
            }
        }
    }
}
