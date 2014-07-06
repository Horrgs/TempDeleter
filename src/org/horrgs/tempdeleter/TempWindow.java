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
    private JTextArea deleted;
    public TempWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 100);
        setTitle("TempDeleter v1.1 by Horrgs");
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        delete = new JButton("Delete");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(delete, gbc);
        deleted = new JTextArea("Waiting for files to be deleted.....");
        deleted.setBackground(getBackground());
        deleted.setEditable(false);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(deleted, gbc);
        delete.addActionListener(new TempActionListener());
        setVisible(true);
    }

    private class TempActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            if(ev.getSource() == delete) {
                String sep = System.getProperty("file.separator");
                String us = System.getProperty("user.name");
                File dir = new File("C:" + sep + "Users" + sep + us + sep + "AppData" + sep + "Local" + sep + "Temp" + sep);
                if(dir.isDirectory()) {
                    int a = dir.list().length;
                    deleted.setVisible(true);
                    Util u = new Util();
                    u.deleteDir(dir);
                    int b = dir.list().length;
                    int amount = a - b;
                    if(amount == 0) {
                        deleted.setText("You deleted no files!");
                    } else if(amount == 1) {
                        deleted.setText("You deleted " + amount + " file!");
                    } else if(amount > 1) {
                        deleted.setText("You deleted " + amount + " files!");
                    } else {
                        deleted.setText("What did you delete?!");
                    }
                }
            }
        }
    }
}
