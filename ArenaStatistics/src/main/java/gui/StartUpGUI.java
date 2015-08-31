/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Deck;
import domain.Match;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import logic.ClassVSClassStatisticsKeeper;
import logic.DeckClassStatisticsKeeper;
import logic.RewardStatisticsKeeper;
import logic.ClassStatisticsKeeper;
import logic.MatchArchiver;
import logic.StartUp;

public class StartUpGUI extends javax.swing.JFrame implements Runnable {

    @Override
    public void run() {
        initComponents();
        start();
    }

    private void start() {
        long start = System.currentTimeMillis();
        parseData();
        long end = System.currentTimeMillis();
        updateFeed("Parsing completed in " + ((double) (end - start) / 1000) + " seconds");
        progressBar.setIndeterminate(false);
        progressBar.setValue(100);
        okButton.setEnabled(true);
    }

    private void parseData() {
//        updateFeed("Parsing decks");
//        decks = StartUp.getDecks("src/main/resources/Decks.xml");
        updateFeed("Parsing matches");
        archiver = StartUp.getMatchArchiver("src/main/resources/Matches.xml");
//        updateFeed("Assigning matches to decks and vice versa");
//        StartUp.assignMatchesToDecks(decks, matches);
        updateFeed("Parsing match statistics");
        ClassStatisticsKeeper = StartUp.getClassStatistics("src/main/resources/ClassStatistics.xml");
        classVSClassStatisticsKeeper = StartUp.getClassVSClassStatistics("src/main/resources/ClassVSClassStatistics.xml");
        updateFeed("Parsing deck statistics");
        deckClassStatisticsKeeper = StartUp.getDeckClassStatisticsKeeper("src/main/resources/DeckClassStatistics.xml");
        deckWinStatisticsKeeper = StartUp.getDeckWinStatisticsKeeper("src/main/resources/DeckWinStatistics.xml");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void updateFeed(String newText) {
        StringBuilder sb = new StringBuilder();
        sb.append(textFeed.getText()).append("\n").append(newText);
        textFeed.setText(sb.toString());
    }

    public ClassStatisticsKeeper getClassStatisticsKeeper() {
        return ClassStatisticsKeeper;
    }

    public ClassVSClassStatisticsKeeper getClassVSClassStatisticsKeeper() {
        return classVSClassStatisticsKeeper;
    }

    public DeckClassStatisticsKeeper getDeckClassStatisticsKeeper() {
        return deckClassStatisticsKeeper;
    }

    public RewardStatisticsKeeper getDeckWinStatisticsKeeper() {
        return deckWinStatisticsKeeper;
    }

//    public List<Deck> getDecks() {
//        return decks;
//    }
//
//    public List<Match> getMatches() {
//        return matches;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textFeed = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        okButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        textFeed.setColumns(20);
        textFeed.setRows(5);
        jScrollPane1.setViewportView(textFeed);

        progressBar.setIndeterminate(true);

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addGap(135, 135, 135))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(okButton)
                .addGap(9, 9, 9)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        dispose();
        MainGUI mainGUI = new MainGUI();
//        mainGUI.setMatches(matches);
//        mainGUI.setDecks(decks);
        mainGUI.setClassStatisticsKeeper(ClassStatisticsKeeper);
        mainGUI.setClassVSClassStatisticsKeeper(classVSClassStatisticsKeeper);
        mainGUI.setDeckClassStatisticsKeeper(deckClassStatisticsKeeper);
        mainGUI.setDeckWinStatisticsKeeper(deckWinStatisticsKeeper);
        SwingUtilities.invokeLater(mainGUI);
        mainGUI.setVisible(true);
    }//GEN-LAST:event_okButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextArea textFeed;
    // End of variables declaration//GEN-END:variables
    private List<Deck> decks;
    private List<Match> matches;
    private ClassStatisticsKeeper ClassStatisticsKeeper;
    private ClassVSClassStatisticsKeeper classVSClassStatisticsKeeper;
    private DeckClassStatisticsKeeper deckClassStatisticsKeeper;
    private RewardStatisticsKeeper deckWinStatisticsKeeper;
    private MatchArchiver archiver;
}
