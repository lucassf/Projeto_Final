package Screens;

import Connection.DatabaseConnection;
import java.util.Deque;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;

public class JPCategories extends javax.swing.JPanel {

    DatabaseConnection database;
    Implement.ImpCategories impcategories = new Implement.ImpCategories();
    
    public JPCategories(DatabaseConnection database) {
        initComponents();
        setDatabase(database);
        ((AbstractDocument)UpdateText.getDocument()).setDocumentFilter(new Filters.SizeFilter(40));
        ((AbstractDocument)NewText.getDocument()).setDocumentFilter(new Filters.TextAreaFilter(40,20));
    }
    
    public void setDatabase(DatabaseConnection database){
        impcategories.SetDatabase(database);
        this.database=database;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        SearchButton = new javax.swing.JButton();
        SearchText = new javax.swing.JTextField();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        NewText = new javax.swing.JTextArea();
        UpdateText = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(700, 400));

        jLabel1.setText("Nome:");

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Data De Inscrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TableMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        SearchButton.setText("Pesquisar");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Alterar");
        UpdateButton.setEnabled(false);
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Excluir");
        DeleteButton.setEnabled(false);
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        NewText.setColumns(15);
        NewText.setRows(5);
        NewText.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane2.setViewportView(NewText);

        UpdateText.setEnabled(false);

        NewButton.setText("Adicionar novo(s)");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Escreva os nomes das categorias em cada linha");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("(max. 20 linhas, 40 caracteres por linha).");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SearchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SearchText)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(UpdateText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DeleteButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(UpdateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(NewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewButton)
                        .addGap(23, 23, 23)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UpdateButton)
                            .addComponent(UpdateText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMousePressed
        int row = Table.getSelectedRow();
        if (row >= 0) {
            UpdateButton.setEnabled(true);
            UpdateText.setEnabled(true);
            DeleteButton.setEnabled(true);
        }
    }//GEN-LAST:event_TableMousePressed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String[] s = {"%" + SearchText.getText() + "%"};
        String sql = "select * from test.categorias where descricao like ?;";
        UpdateButton.setEnabled(false);
        UpdateText.setEnabled(false);
        DeleteButton.setEnabled(false);
        if (database.ExecuteQuery(sql, s)) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);
            while (database.NextRegister()) {
                model.addRow(new Object[]{database.GetInt("idCategorias"),
                    database.GetString("Descricao"),
                    database.GetDate("DataDeCadastro")});
        }
        }
        SearchText.setText("");
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        String text = UpdateText.getText();
        String message = "";
        if (!text.isEmpty()) {
            int row = Table.getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            String[] s = {text};
            String sql = "select descricao from test.categorias where descricao=?;";
            if (database.ExecuteQuery(sql, s)) {
                if (!database.NextRegister()) {
                    String[][] set = {{"String", text},
                        {"String", model.getValueAt(row, 0).toString()}};
                    sql = "update test.categorias set descricao=? where idCategorias=?;";
                    if (database.UpdateQuery(sql, set)) {
                        model.setValueAt(text, row, 1);
                        message = "Item atualizado com sucesso";
                    }
                } else {
                    message = "Item já adicionado";
                }
            } else {
                message = "Erro no banco";
            }
            UpdateText.setText("");
        } else {
            message = "Texto inválido";
        }
        JOptionPane.showMessageDialog(null, message);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int[] row = Table.getSelectedRows();
        int length = row.length;
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        String joption = "Deseja excluir ";
        joption+=length==1?"'"+model.getValueAt(row[0], 1)+"'?":length + " itens?";
        int ans = JOptionPane.showConfirmDialog(null, joption,
                "Deletar itens selecionados", 2);
        if (ans == 0) {
            String sql = "delete from test.categorias where ";
            String[][] s = new String[length][2];
            for (int i = 0; i < length; i++) {
                s[i][0] = "int";
                s[i][1] = model.getValueAt(row[i], 0).toString();
                if (i > 0) {
                    sql += " or idCategorias=?";
                } else {
                    sql += "idCategorias=?";
                }
            }
            sql += ";";
            if (database.UpdateQuery(sql, s)) {

                for (int i = length-1; i >=0; i--) {
                    model.removeRow(row[i]);
                }
                UpdateButton.setEnabled(false);
                UpdateText.setEnabled(false);
                DeleteButton.setEnabled(false);
                joption = length==1?"1 item removido":length+" itens removidos";
                JOptionPane.showMessageDialog(null, joption);
            }
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        String[] names = NewText.getText().split("\n");
        Deque<String> deque = new LinkedList<String>();
        int size = names.length;
        boolean t = true;
        String sql = "select descricao from test.categorias where descricao=?;";
        String[] s = new String[1];
        for (int i = 0; i < size && t; i++) {
            if (!names[i].isEmpty() && !deque.contains(names[i])) {
                s[0] = names[i];
                if (database.ExecuteQuery(sql, s)) {
                    if (!database.NextRegister()) {
                        deque.addFirst(names[i]);
                    }
                } else{
                    t=false;
                }
            }
        }
        size = deque.size();
        if (t&&impcategories.Insert(deque.toArray(new String[0]))) {
            JOptionPane.showMessageDialog(null, size + " itens foram adicionados");
            NewText.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Erro no banco de dados");
        }
    }//GEN-LAST:event_NewButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextArea NewText;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTextField SearchText;
    private javax.swing.JTable Table;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JTextField UpdateText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
