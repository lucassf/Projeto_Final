package Screens;

import Connection.DatabaseConnection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JPProviders extends javax.swing.JPanel {
    
    DatabaseConnection database;
    javax.swing.JFrame mainframe;

    public JPProviders(javax.swing.JFrame mainframe,DatabaseConnection database) {
        initComponents();
        this.database = database;
        this.mainframe = mainframe;
        UpdateButton.setEnabled(false);
        DeleteButton.setEnabled(false);
    }
    
    private void Search(String[] s) {
        String Sql = "Select * from test.fornecedores where Nome like ? "
                + "and Cnpj like ? and Endereco like ? and Cidade like ?;";
        if (database.ExecuteQuery(Sql, s)) {
            DefaultTableModel model = (DefaultTableModel) Table.getModel();
            model.setRowCount(0);
            while (database.NextRegister()) {
                model.addRow(new Object[]{database.GetInt("idFornecedores"),
                    database.GetString("Nome"),
                    database.GetString("Cnpj"),
                    database.GetString("Endereco"),
                    database.GetString("Estado"),
                    database.GetString("Cidade"),
                    database.GetString("Bairro"),
                    database.GetString("Telefone1"),
                    database.GetString("Telefone2"),
                    database.GetString("Email"),
                    database.GetDate("DataDeCadastro")});
            }
        }
    }
    
    private void Update() {
        int row = Table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) Table.getModel();
        JDProviders jdproviders = new JDProviders(mainframe,true);
        jdproviders.setDatabase(database);
        jdproviders.setOperation(Operation.UPDATE);
        Data.Providers p = new Data.Providers();
        p.setId(model.getValueAt(row, 0).toString());
        p.setName(model.getValueAt(row, 1).toString());
        p.setCnpj(model.getValueAt(row, 2).toString());
        p.setAddress(model.getValueAt(row, 3).toString());
        p.setState(model.getValueAt(row, 4).toString());
        p.setCity(model.getValueAt(row, 5).toString());
        p.setNeighborhood(model.getValueAt(row, 6).toString());
        p.setPhone1(model.getValueAt(row, 7).toString());
        p.setPhone2(model.getValueAt(row, 8).toString());
        p.setEmail(model.getValueAt(row, 9).toString());
        jdproviders.setText(p);
        jdproviders.setProvider(p);
        jdproviders.setBoxDisplay(p.getState());
        jdproviders.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        CnpjText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddressText = new javax.swing.JTextField();
        CityText = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Cnpj", "Endereço", "Estado", "Cidade", "Bairro", "Telefone 1", "Telefone 2", "Email", "DataDeCadastro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
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

        jLabel1.setText("Nome:");

        jLabel2.setText("Cnpj:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Cidade:");

        NewButton.setText("Novo");
        NewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewButtonActionPerformed(evt);
            }
        });

        SearchButton.setText("Pesquisar");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        UpdateButton.setText("Alterar");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Excluir");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NameText, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(CnpjText))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CityText)
                            .addComponent(AddressText, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                        .addGap(213, 213, 213)
                        .addComponent(NewButton)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addComponent(UpdateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DeleteButton)
                .addGap(85, 85, 85))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(CityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(CnpjText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(SearchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(NewButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UpdateButton)
                    .addComponent(DeleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void NewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewButtonActionPerformed
        JDProviders jdprovider = new JDProviders(mainframe,true);
        jdprovider.setDatabase(database);
        jdprovider.setOperation(Operation.ADD);
        jdprovider.setVisible(true);
    }//GEN-LAST:event_NewButtonActionPerformed

    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        String text1 = NameText.getText();
        String text2 = CnpjText.getText();
        String text3 = AddressText.getText();
        String text4 = CityText.getText();
        UpdateButton.setEnabled(false);
        DeleteButton.setEnabled(false);
        String[] s = {"%" + text1 + "%", "%" + text2 + "%",
            "%" + text3 + "%", "%" + text4 + "%"};
        Search(s);
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void TableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMousePressed
        int row = Table.getSelectedRow();
        if (row >= 0) {
            UpdateButton.setEnabled(Table.getSelectedRowCount()==1);
            DeleteButton.setEnabled(true);
        }
        if (evt.getClickCount() == 2 && evt.getButton() == evt.BUTTON1 && row >= 0) {
            Update();
        }
    }//GEN-LAST:event_TableMousePressed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        Update();
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
            String sql = "delete from test.fornecedores where ";
            String[][] s = new String[length][2];
            for (int i = 0; i < length; i++) {
                s[i][0] = "int";
                s[i][1] = model.getValueAt(row[i], 0).toString();
                if (i > 0) {
                    sql += " or idFornecedores=?";
                } else {
                    sql += "idFornecedores=?";
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressText;
    private javax.swing.JTextField CityText;
    private javax.swing.JTextField CnpjText;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField NameText;
    private javax.swing.JButton NewButton;
    private javax.swing.JButton SearchButton;
    private javax.swing.JTable Table;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
