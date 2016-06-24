package Screens;

import Connection.DatabaseConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPProducts extends javax.swing.JPanel {

    DatabaseConnection database;
    javax.swing.JFrame mainframe;

    public JPProducts(javax.swing.JFrame mainframe,DatabaseConnection database) {
        initComponents();
        this.database=database;
        this.mainframe = mainframe;
        UpdateButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }

    private void Search(String[] s) {
        String Sql = "Select p.*,c.descricao from test.produtos p inner join test.categorias"
                +" c on p.idCategoria=c.idCategorias where p.Descricao like ? "
                + "and p.Fabricante like ? and c.descricao like ? and p.Fornecedor like ?;";
        if (database.ExecuteQuery(Sql, s)) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);
            while (database.NextRegister()) {
                model.addRow(new Object[]{database.GetInt("idProdutos"),
                    database.GetString("p.Descricao"),
                    database.GetString("c.Descricao"),
                    database.GetString("Fabricante"),
                    database.GetString("Fornecedor"),
                    database.GetDouble("Margem"),
                    database.GetDouble("PrecoCusto"),
                    database.GetDouble("PrecoVenda"),
                    database.GetDate("DataDeCadastro")});
            }
        }
    }

    private void Update() {
        int row = Table.getSelectedRow();
        String[] boxitems = new String[3];
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        JDProducts jdproducts = new JDProducts(mainframe,true);
        jdproducts.setDatabase(database);
        jdproducts.setOperation(Operation.UPDATE);
        Data.Products p = new Data.Products();
        p.setId(model.getValueAt(row, 0).toString());
        p.setName(model.getValueAt(row, 1).toString());
        boxitems[0] = model.getValueAt(row, 2).toString();
        p.setManufacturer(model.getValueAt(row, 3).toString());
        p.setSender(model.getValueAt(row, 4).toString());
        p.setDif(model.getValueAt(row, 5).toString());
        p.setBuyprice(model.getValueAt(row, 6).toString());
        p.setPrice(model.getValueAt(row, 7).toString());
        p.setDate(model.getValueAt(row, 8).toString());
        jdproducts.setText(p);
        jdproducts.setProduct(p);
        jdproducts.setBoxDisplay(boxitems);
        jdproducts.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        NameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        DeleteButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CatTextField = new javax.swing.JTextField();
        SendTextField = new javax.swing.JTextField();
        ProdTextField = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();

        jLabel3.setText("Fabricante:");

        jLabel1.setText("Descrição:");

        jLabel4.setText("Fornecedor:");

        DeleteButton.setText("Excluir");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Alterar");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Pesquisar");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Categoria:");

        NewButton.setText("Novo");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrção", "Categoria", "Fabricante", "Fornecedor", "Margem", "PreçoCusto", "PreçoVenda", "DataDeCadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameTextField)
                            .addComponent(CatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ProdTextField)
                            .addComponent(SendTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addComponent(NewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(SearchButton)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(UpdateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteButton)
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(ProdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(NewButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(SendTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SearchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButton)
                    .addComponent(DeleteButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int[] row = Table.getSelectedRows();
        int length = row.length;
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        String joption = "Deseja excluir ";
        joption+=length==1?"'"+model.getValueAt(row[0], 1)+"'?":length + " itens?";
        int ans = JOptionPane.showConfirmDialog(null, joption,
                "Deletar itens selecionados", 2);
        if (ans == 0) {
            String sql = "delete from test.produtos where ";
            String[][] s = new String[length][2];
            for (int i = 0; i < length; i++) {
                s[i][0] = "int";
                s[i][1] = model.getValueAt(row[i], 0).toString();
                if (i > 0) {
                    sql += " or idProdutos=?";
                } else {
                    sql += "idProdutos=?";
                }
            }
            sql += ";";
            if (database.UpdateQuery(sql, s)) {

                for (int i = length-1; i >=0; i--) {
                    model.removeRow(row[i]);
                }
                UpdateButton.setEnabled(false);
                DeleteButton.setEnabled(false);
                joption = length==1?"1 item removido":length+" itens removidos";
                JOptionPane.showMessageDialog(null, joption);
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        Update();
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String text1 = NameTextField.getText();
        String text2 = ProdTextField.getText();
        String text3 = CatTextField.getText();
        String text4 = SendTextField.getText();
        UpdateButton.setEnabled(false);
        DeleteButton.setEnabled(false);
        String[] s = {"%" + text1 + "%", "%" + text2 + "%",
            "%" + text3 + "%", "%" + text4 + "%"};
        Search(s);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        JDProducts jdproducts = new JDProducts(mainframe,true);
        jdproducts.setDatabase(database);
        jdproducts.setOperation(Operation.ADD);
        jdproducts.setVisible(true);
    }//GEN-LAST:event_NewButtonActionPerformed

    private void TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMousePressed
        int row = Table.getSelectedRow();
        if (row >= 0) {
            UpdateButton.setEnabled(true);
            DeleteButton.setEnabled(true);
        }
        if (evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1 && row >= 0) {
            Update();
        }
    }//GEN-LAST:event_TableMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CatTextField;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField ProdTextField;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SendTextField;
    private javax.swing.JTable Table;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
