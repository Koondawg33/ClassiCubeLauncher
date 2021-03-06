package net.classicube.launcher.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class ErrorScreen extends javax.swing.JDialog {

    public static void show(final JFrame parent, final String title, final String message, final Throwable ex) {
        new ErrorScreen(parent, title, message, ex).setVisible(true);
    }

    private ErrorScreen(final JFrame parent, final String title, final String message, final Throwable ex) {
        // set title, add border
        super(parent, title, true);

        // set background
        final ImagePanel bgPanel = new ImagePanel(null, true);
        bgPanel.setGradient(true);
        bgPanel.setImage(Resources.getClassiCubeBackground());
        bgPanel.setGradientColor(new Color(124, 104, 141));
        bgPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
        setContentPane(bgPanel);

        initComponents();

        // fill in exception info (if available)
        this.lMessage.setText("<html><b>" + message);
        if (ex != null) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            this.tDetails.setText(sw.toString());
            this.tDetails.selectAll();
            this.tDetails.setCaretPosition(0);
        } else {
            this.bDetails.setVisible(false);
        }
        this.detailsContainer.setVisible(false);
        
        // focus & highlight [Close]
        getRootPane().setDefaultButton(bClose);

        // Show GridBagLayout who's boss.
        this.imgErrorIcon.setImage(Resources.getErrorIcon());
        this.imgErrorIcon.setMinimumSize(new Dimension(64, 64));
        this.imgErrorIcon.setPreferredSize(new Dimension(64, 64));
        this.imgErrorIcon.setSize(new Dimension(64, 64));

        // Set windows size, pack, and center
        this.setPreferredSize(new Dimension(450, 130));
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        detailsContainer = new javax.swing.JScrollPane();
        tDetails = new javax.swing.JTextArea();
        lMessage = new javax.swing.JLabel();
        bDetails = new net.classicube.launcher.gui.JNiceLookingToggleButton();
        bClose = new net.classicube.launcher.gui.JNiceLookingButton();
        imgErrorIcon = new net.classicube.launcher.gui.ImagePanel();
        javax.swing.Box.Filler filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tDetails.setEditable(false);
        tDetails.setColumns(20);
        tDetails.setRows(6);
        detailsContainer.setViewportView(tDetails);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 0, 0);
        getContentPane().add(detailsContainer, gridBagConstraints);

        lMessage.setForeground(new java.awt.Color(255, 255, 255));
        lMessage.setText("Someone set up us the bomb!");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        getContentPane().add(lMessage, gridBagConstraints);

        bDetails.setText("+ Details");
        bDetails.setToolTipText("Show technical details of this error.\nWhen reporting a bug, please include this information.");
        bDetails.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bDetailsItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bDetails, gridBagConstraints);

        bClose.setText("Close");
        bClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCloseActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_END;
        getContentPane().add(bClose, gridBagConstraints);

        imgErrorIcon.setMaximumSize(new java.awt.Dimension(64, 64));
        imgErrorIcon.setMinimumSize(new java.awt.Dimension(64, 64));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 8);
        getContentPane().add(imgErrorIcon, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(filler2, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCloseActionPerformed

    private void bDetailsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bDetailsItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.detailsContainer.setVisible(true);
            this.setPreferredSize(new Dimension(450, 400));
        } else if (evt.getStateChange() == ItemEvent.DESELECTED) {
            this.detailsContainer.setVisible(false);
            this.setPreferredSize(new Dimension(450, 130));
        }
        pack();
    }//GEN-LAST:event_bDetailsItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.classicube.launcher.gui.JNiceLookingButton bClose;
    private net.classicube.launcher.gui.JNiceLookingToggleButton bDetails;
    private javax.swing.JScrollPane detailsContainer;
    private net.classicube.launcher.gui.ImagePanel imgErrorIcon;
    private javax.swing.JLabel lMessage;
    private javax.swing.JTextArea tDetails;
    // End of variables declaration//GEN-END:variables
}
