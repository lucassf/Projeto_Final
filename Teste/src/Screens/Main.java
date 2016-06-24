package Screens;

import Connection.DatabaseConnection;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame {

    static Main mainscreen;
    static DatabaseConnection database;

    public Main() {
        
        initComponents();
        database = new DatabaseConnection();
        javax.swing.JPanel productspanel = new JPProducts(this,database);
        javax.swing.JPanel categoriespanel = new JPCategories(database);
        javax.swing.JPanel providerpanel = new JPProviders(this,database);
        MainPanel.add(productspanel, "Product");
        MainPanel.add(categoriespanel,"Category");
        MainPanel.add(providerpanel,"Provider");
        ((CardLayout)MainPanel.getLayout()).show(MainPanel, "Product");
    }
    
    private void Close(){
        mainscreen.setVisible(false);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        ProductMenu = new javax.swing.JMenuItem();
        CategoryMenu = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        Exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        MainPanel.setPreferredSize(new java.awt.Dimension(710, 450));
        MainPanel.setLayout(new java.awt.CardLayout());

        jMenu3.setText("Novo");

        ProductMenu.setText("Produto");
        ProductMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductMenuActionPerformed(evt);
            }
        });
        jMenu3.add(ProductMenu);

        CategoryMenu.setText("Categoria");
        CategoryMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoryMenuActionPerformed(evt);
            }
        });
        jMenu3.add(CategoryMenu);

        jMenuItem3.setText("Fornecedor");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu1.setText("Navegar");

        Exit.setText("Sair");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        jMenu1.add(Exit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        Close();
    }//GEN-LAST:event_ExitActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ((CardLayout)MainPanel.getLayout()).show(MainPanel, "Provider");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void CategoryMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoryMenuActionPerformed
        ((CardLayout)MainPanel.getLayout()).show(MainPanel, "Category");
    }//GEN-LAST:event_CategoryMenuActionPerformed

    private void ProductMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductMenuActionPerformed
        ((CardLayout)MainPanel.getLayout()).show(MainPanel, "Product");
    }//GEN-LAST:event_ProductMenuActionPerformed

    public static void main(String args[]) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            System.out.println("Erro de inicialização");
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                mainscreen = new Main();
                
                if (database.InitConnection()) {
                    mainscreen.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(mainscreen, "Erro ao tentar conectar com o banco");
                    System.exit(1);
                }
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CategoryMenu;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenuItem ProductMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    // End of variables declaration//GEN-END:variables
}
