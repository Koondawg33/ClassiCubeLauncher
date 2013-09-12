package net.classicube.launcher;

import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;

final class PreferencesScreen extends javax.swing.JDialog {

    public PreferencesScreen(JFrame parent) {
        super(parent, "Preferences", true);
        JRootPane root = getRootPane();
        root.setBorder(new EmptyBorder(8, 8, 8, 8));
        initComponents();
        root.setDefaultButton(bSave);
        bSave.setPreferredSize(bCancel.getSize());
        pack();
        loadPreferences();
        setLocationRelativeTo(parent);
    }

    private void loadPreferences() {
        loadWindowSize(Prefs.getWindowSize());
        loadUpdateMode(Prefs.getUpdateMode());
        xRememberUsers.setSelected(Prefs.getRememberUsers());
        xRememberPasswords.setSelected(Prefs.getRememberPasswords());
        xRememberServer.setSelected(Prefs.getRememberServer());
        tJavaArgs.setText(Prefs.getJavaArgs());
        nMemory.setValue(Prefs.getMaxMemory());
    }

    private void loadWindowSize(WindowSize val) {
        JRadioButton btn;
        switch (val) {
            case MAXIMIZED:
                btn = rWindowMaximized;
                break;
            case FULLSCREEN:
                btn = rWindowFullscreen;
                break;
            default: // NORMAL:
                btn = rWindowNormal;
                break;
        }
        rgWindowSize.setSelected(btn.getModel(), true);
    }

    private void loadUpdateMode(UpdateMode val) {
        JRadioButton btn;
        switch (val) {
            case DISABLED:
                btn = rUpdateDisabled;
                break;
            case AUTOMATIC:
                btn = rUpdateAutomatic;
                break;
            default: // NOTIFY
                btn = rUpdateNotify;
                break;
        }
        rgUpdateMode.setSelected(btn.getModel(), true);
    }

    private void storePreferences() {
        Prefs.setWindowSize(storeWindowSize());
        Prefs.setUpdateMode(storeUpdateMode());
        Prefs.setRememberUsers(xRememberUsers.isSelected());
        Prefs.setRememberPasswords(xRememberPasswords.isSelected());
        Prefs.setRememberServer(xRememberServer.isSelected());
        Prefs.setJavaArgs(tJavaArgs.getText());
        Prefs.setMaxMemory((int) nMemory.getValue());
    }

    private WindowSize storeWindowSize() {
        WindowSize val;
        if (rWindowMaximized.isSelected()) {
            val = WindowSize.MAXIMIZED;
        } else if (rWindowFullscreen.isSelected()) {
            val = WindowSize.FULLSCREEN;
        } else {
            val = WindowSize.NORMAL;
        }
        return val;
    }

    private UpdateMode storeUpdateMode() {
        UpdateMode val;
        if (rUpdateDisabled.isSelected()) {
            val = UpdateMode.DISABLED;
        } else if (rUpdateAutomatic.isSelected()) {
            val = UpdateMode.AUTOMATIC;
        } else {
            val = UpdateMode.NOTIFY;
        }
        return val;
    }

    private void loadDefaults() {
        loadWindowSize(Prefs.WindowSizeDefault);
        loadUpdateMode(Prefs.UpdateModeDefault);
        xRememberUsers.setSelected(Prefs.RememberUsersDefault);
        xRememberPasswords.setSelected(Prefs.RememberPasswordsDefault);
        xRememberServer.setSelected(Prefs.RememberServerDefault);
        tJavaArgs.setText(Prefs.JavaArgsDefault);
        nMemory.setValue(Prefs.MaxMemoryDefault);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        rgWindowSize = new javax.swing.ButtonGroup();
        rgUpdateMode = new javax.swing.ButtonGroup();
        javax.swing.JLabel lWindowSize = new javax.swing.JLabel();
        rWindowNormal = new javax.swing.JRadioButton();
        rWindowMaximized = new javax.swing.JRadioButton();
        rWindowFullscreen = new javax.swing.JRadioButton();
        javax.swing.JLabel lUpdateMode = new javax.swing.JLabel();
        rUpdateDisabled = new javax.swing.JRadioButton();
        rUpdateNotify = new javax.swing.JRadioButton();
        rUpdateAutomatic = new javax.swing.JRadioButton();
        javax.swing.JSeparator jSeparator1 = new javax.swing.JSeparator();
        xRememberUsers = new javax.swing.JCheckBox();
        bForgetUsers = new javax.swing.JButton();
        xRememberPasswords = new javax.swing.JCheckBox();
        bForgetPasswords = new javax.swing.JButton();
        xRememberServer = new javax.swing.JCheckBox();
        bForgetServer = new javax.swing.JButton();
        javax.swing.JSeparator jSeparator2 = new javax.swing.JSeparator();
        javax.swing.JLabel lParameters = new javax.swing.JLabel();
        tJavaArgs = new javax.swing.JTextField();
        javax.swing.JLabel lMemory = new javax.swing.JLabel();
        nMemory = new javax.swing.JSpinner();
        javax.swing.JLabel lMB = new javax.swing.JLabel();
        javax.swing.JSeparator jSeparator3 = new javax.swing.JSeparator();
        bDefaults = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        javax.swing.Box.Filler filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        javax.swing.Box.Filler filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        javax.swing.Box.Filler filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        lWindowSize.setText("Game window size:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        getContentPane().add(lWindowSize, gridBagConstraints);

        rgWindowSize.add(rWindowNormal);
        rWindowNormal.setText("Normal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rWindowNormal, gridBagConstraints);

        rgWindowSize.add(rWindowMaximized);
        rWindowMaximized.setText("Maximized");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rWindowMaximized, gridBagConstraints);

        rgWindowSize.add(rWindowFullscreen);
        rWindowFullscreen.setText("Fullscreen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rWindowFullscreen, gridBagConstraints);

        lUpdateMode.setText("Install game updates...");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        getContentPane().add(lUpdateMode, gridBagConstraints);

        rgUpdateMode.add(rUpdateDisabled);
        rUpdateDisabled.setText("Disable");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rUpdateDisabled, gridBagConstraints);

        rgUpdateMode.add(rUpdateNotify);
        rUpdateNotify.setText("Enable (notify me)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rUpdateNotify, gridBagConstraints);

        rgUpdateMode.add(rUpdateAutomatic);
        rUpdateAutomatic.setSelected(true);
        rUpdateAutomatic.setText("Enable (automatic)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(rUpdateAutomatic, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        getContentPane().add(jSeparator1, gridBagConstraints);

        xRememberUsers.setText("Remember usernames");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(xRememberUsers, gridBagConstraints);

        bForgetUsers.setText("Forget all users");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(bForgetUsers, gridBagConstraints);

        xRememberPasswords.setText("Remember passwords");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(xRememberPasswords, gridBagConstraints);

        bForgetPasswords.setText("Forget all passwords");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(bForgetPasswords, gridBagConstraints);

        xRememberServer.setText("Remember last-joined server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        getContentPane().add(xRememberServer, gridBagConstraints);

        bForgetServer.setText("Forget last server");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(bForgetServer, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        getContentPane().add(jSeparator2, gridBagConstraints);

        lParameters.setText("Java args");
        lParameters.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(lParameters, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(tJavaArgs, gridBagConstraints);

        lMemory.setText("Max memory");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 4);
        getContentPane().add(lMemory, gridBagConstraints);

        nMemory.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(64), Integer.valueOf(64), null, Integer.valueOf(16)));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(nMemory, gridBagConstraints);

        lMB.setText("MB");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 10;
        getContentPane().add(lMB, gridBagConstraints);

        jSeparator3.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 0, 8, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 8, 0);
        getContentPane().add(jSeparator3, gridBagConstraints);

        bDefaults.setText("Defaults");
        bDefaults.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDefaultsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        getContentPane().add(bDefaults, gridBagConstraints);

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bSave, gridBagConstraints);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bCancel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        getContentPane().add(filler3, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        storePreferences();
        dispose();
    }//GEN-LAST:event_bSaveActionPerformed

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bDefaultsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDefaultsActionPerformed
        loadDefaults();
    }//GEN-LAST:event_bDefaultsActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bDefaults;
    private javax.swing.JButton bForgetPasswords;
    private javax.swing.JButton bForgetServer;
    private javax.swing.JButton bForgetUsers;
    private javax.swing.JButton bSave;
    private javax.swing.JSpinner nMemory;
    private javax.swing.JRadioButton rUpdateAutomatic;
    private javax.swing.JRadioButton rUpdateDisabled;
    private javax.swing.JRadioButton rUpdateNotify;
    private javax.swing.JRadioButton rWindowFullscreen;
    private javax.swing.JRadioButton rWindowMaximized;
    private javax.swing.JRadioButton rWindowNormal;
    private javax.swing.ButtonGroup rgUpdateMode;
    private javax.swing.ButtonGroup rgWindowSize;
    private javax.swing.JTextField tJavaArgs;
    private javax.swing.JCheckBox xRememberPasswords;
    private javax.swing.JCheckBox xRememberServer;
    private javax.swing.JCheckBox xRememberUsers;
    // End of variables declaration//GEN-END:variables
}