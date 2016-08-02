package com.zetcode;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.LayoutStyle;

/*
 * Java ResourceBundle tutorial
 *
 * This program uses a ResourceBundle in a 
 * Java Swing application.
 *
 * Author: Jan Bodnar
 * Website: zetcode.com
 * Last modified: August 2016
 */
public class ResourceBundleEx3 extends JFrame {

    private ResourceBundle bundle;
    private JLabel flag;
    private JLabel lbl;
    private JMenu langMenu;
    private JRadioButtonMenuItem skMenuItem;
    private JRadioButtonMenuItem huMenuItem;

    public ResourceBundleEx3() {

        initUI();
    }

    private void initUI() {

        createMenuBar();

        flag = new JLabel();
        lbl = new JLabel();
        
        updateLanguage(new Locale("sk", "SK"));

        createLayout(lbl, flag);
        pack();

        setTitle(bundle.getString("name"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void updateLanguage(Locale locale) {

        bundle = ResourceBundle.getBundle("com.zetcode.myres.MyResources", locale);
        langMenu.setText(bundle.getString("lang_menu"));
        skMenuItem.setText(bundle.getString("lang_sk"));
        huMenuItem.setText(bundle.getString("lang_hu"));
        flag.setIcon((Icon) bundle.getObject("flag"));
        lbl.setText(bundle.getString("description"));
        setTitle(bundle.getString("name"));
        pack();
    }

    private void createMenuBar() {

        JMenuBar menubar = new JMenuBar();

        langMenu = new JMenu();
        langMenu.setMnemonic(KeyEvent.VK_F);

        ButtonGroup btnGroup = new ButtonGroup();

        skMenuItem = new JRadioButtonMenuItem("Slovak", true);
        btnGroup.add(skMenuItem);

        skMenuItem.addActionListener((ActionEvent e) -> {
            updateLanguage(new Locale("sk", "SK"));
        });

        langMenu.add(skMenuItem);

        huMenuItem = new JRadioButtonMenuItem("Hungarian");
        btnGroup.add(huMenuItem);

        huMenuItem.addActionListener((ActionEvent e) -> {
            updateLanguage(new Locale("hu", "HU"));
        });

        langMenu.add(huMenuItem);

        menubar.add(langMenu);

        setJMenuBar(menubar);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(arg[1])
        );
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            ResourceBundleEx3 ex = new ResourceBundleEx3();
            ex.setVisible(true);
        });
    }
}
