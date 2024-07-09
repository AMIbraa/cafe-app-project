/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package dropdownlist;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author CIAGamester
 */
public class dropdown extends javax.swing.JPanel {

    /**
     * @return the subMenu
     */
    public ArrayList<dropdown> getSubMenu() {
        return subMenu;
    }

    private final ArrayList<dropdown> subMenu = new ArrayList<>();
    
    private ActionListener act;

    public dropdown(Icon icon, boolean sbm, String menuName, ActionListener act, dropdown... subMenu) {
        initComponents();
        
        b_icon.setIcon(icon);
        b_menuName.setText(menuName);
        
        if(act != null){
            this.act = act;
        }
        
//        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
//        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
//        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for(int i=0; i<subMenu.length; i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        b_icon = new javax.swing.JLabel();
        b_menuName = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_icon.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        add(b_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 6, 28, 42));

        b_menuName.setFont(new java.awt.Font("Poppins", 1, 16)); // NOI18N
        b_menuName.setText("Profile");
        add(b_menuName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 6, -1, 45));
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        setBackground(new java.awt.Color(255,255,255));
        
        if(showing){
            hideMenu();
        } else {
            showMenu();
        }
        
        if(act != null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel b_icon;
    private javax.swing.JLabel b_menuName;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i = subMenu.size() - 1; i >= 0; i++){
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run(){
                for(int i = 0; i < subMenu.size(); i++){
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }
    
    private void sleep(){
        try {
            Thread.sleep(20);
        } catch (Exception e){
            
        }
    }
}