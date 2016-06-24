package Screens;

import Data.Products;
import Filters.NumberFilter;
import Filters.SizeFilter;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import java.util.ArrayList;

enum Operation {

    UPDATE, ADD
};

public class JDProducts extends javax.swing.JDialog {

    private final int MAXSIZE = 40;
    private final int DECIMALSIZE = 10;
    private ArrayList<String> idcategories;

    Products product;
    Implement.ImpProducts impproducts = new Implement.ImpProducts();
    private Connection.DatabaseConnection database;
    private Operation operation;
    private String panemessages;
    private Date date;

    public JDProducts(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setFilters();
    }

    public void setOperation(Operation o) {
        operation = o;
        if (o == Operation.UPDATE) {
            AddButton.setVisible(false);
            UpdateButton.setEnabled(true);
        } else if (o == Operation.ADD) {
            product = new Products();
            UpdateButton.setVisible(false);
            AddButton.setEnabled(false);
        }
    }

    public void setDatabase(Connection.DatabaseConnection database) {
        impproducts.SetDatabase(database);
        this.database = database;
        setComboBoxes();
    }

    public void setText(Products p) {
        NameText.setText(p.getName());
        ManuText.setText(p.getManufacturer());
        ProvText.setText(p.getSender());
        DifText.setText(p.getDif());
        CostText.setText(p.getBuyprice());
        PriceText.setText(p.getPrice());
    }
    
    public void setBoxDisplay(String[] selected){
        CatBox.setSelectedItem(selected[0]);
    }
    
    public void setBoxDisplay(int[] selected){
        CatBox.setSelectedIndex(selected[0]);
    }

    public void setProduct(Products p) {
        product = p;
    }

    private void getMessages() {
        panemessages = impproducts.GetJOptionMessage();
    }

    private void setFilters() {
        ((AbstractDocument) NameText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) ManuText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) ProvText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) DifText.getDocument()).setDocumentFilter(new NumberFilter(true,DECIMALSIZE));
        ((AbstractDocument) CostText.getDocument()).setDocumentFilter(new NumberFilter(true,DECIMALSIZE));
        ((AbstractDocument) PriceText.getDocument()).setDocumentFilter(new NumberFilter(true,DECIMALSIZE));
    }

    private void setComboBoxes() {
        idcategories = new ArrayList<>();
        idcategories.add("");
        if (database.ExecuteQuery("select * from test.categorias order by descricao;", new String[]{})) {
            while (database.NextRegister()) {
                CatBox.addItem(database.GetString("descricao"));
                idcategories.add(String.valueOf(database.GetInt("idCategorias")));
            }
        }
    }
    
    private void ResetProduct(Products p){
        p.setBuyprice("");
        p.setCategoryid("");
        p.setDate("");
        p.setDif("");
        p.setId("");
        p.setName("");
        p.setPrice("");
        p.setManufacturer("");
        p.setSender("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CostText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        PriceText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        AddButton = new javax.swing.JButton();
        CatBox = new javax.swing.JComboBox();
        UpdateButton = new javax.swing.JButton();
        NameError = new javax.swing.JLabel();
        CatError = new javax.swing.JLabel();
        ManuError = new javax.swing.JLabel();
        ProvError = new javax.swing.JLabel();
        DifError = new javax.swing.JLabel();
        CostError = new javax.swing.JLabel();
        PriceError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ProvText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ManuText = new javax.swing.JTextField();
        DifText = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        CostText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CostTextFocusLost(evt);
            }
        });
        CostText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CostTextKeyReleased(evt);
            }
        });

        jLabel11.setText("Preço de venda:");

        PriceText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PriceTextFocusLost(evt);
            }
        });
        PriceText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PriceTextKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel2.setText("Max.: 40 caracteres");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel7.setText("Max.: 40 caracteres");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel9.setText("Max.: 40 caracteres");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Max.: 10 dígitos");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("Max.: 10 dígitos");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Max.: 10 dígitos");

        AddButton.setText("Adicionar");
        AddButton.setToolTipText("");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        CatBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-Selecione uma categoria-" }));
        CatBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CatBoxFocusLost(evt);
            }
        });
        CatBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatBoxActionPerformed(evt);
            }
        });

        UpdateButton.setText("Atualizar");
        UpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateButtonActionPerformed(evt);
            }
        });

        NameError.setForeground(new java.awt.Color(255, 0, 51));
        NameError.setText(" ");

        CatError.setForeground(new java.awt.Color(255, 0, 51));
        CatError.setText(" ");

        ManuError.setForeground(new java.awt.Color(255, 0, 51));
        ManuError.setText(" ");

        ProvError.setForeground(new java.awt.Color(255, 0, 51));
        ProvError.setText(" ");

        DifError.setForeground(new java.awt.Color(255, 0, 51));
        DifError.setText(" ");

        CostError.setForeground(new java.awt.Color(255, 0, 51));
        CostError.setText(" ");

        PriceError.setForeground(new java.awt.Color(255, 0, 51));
        PriceError.setText(" ");

        jLabel3.setText("Margem:");

        jLabel1.setText("Descrição:");

        NameText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NameTextFocusLost(evt);
            }
        });
        NameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                NameTextKeyReleased(evt);
            }
        });

        jLabel5.setText("Categoria:");

        jLabel6.setText("Fornecedor:");

        ProvText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ProvTextFocusLost(evt);
            }
        });
        ProvText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ProvTextKeyReleased(evt);
            }
        });

        jLabel8.setText("Fabricante:");

        ManuText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ManuTextFocusLost(evt);
            }
        });
        ManuText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ManuTextKeyReleased(evt);
            }
        });

        DifText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DifTextFocusLost(evt);
            }
        });
        DifText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DifTextKeyReleased(evt);
            }
        });

        jLabel10.setText("Preço de custo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ManuError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ManuText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProvText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ProvError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CatBox, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NameError, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                .addComponent(CatError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PriceError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(UpdateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(40, 40, 40))
                                    .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(DifError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CostError, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DifText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CostText, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DifText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(4, 4, 4)
                        .addComponent(DifError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(CostText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(4, 4, 4)
                        .addComponent(CostError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(PriceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(4, 4, 4)
                        .addComponent(PriceError)
                        .addGap(28, 28, 28)
                        .addComponent(AddButton)
                        .addGap(8, 8, 8)
                        .addComponent(UpdateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(4, 4, 4)
                        .addComponent(NameError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CatBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(CatError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ManuText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(4, 4, 4)
                        .addComponent(ManuError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(ProvText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(2, 2, 2)
                        .addComponent(ProvError)))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean Verify(String txt, String field,javax.swing.JLabel error) {
        boolean enabled = false;
        boolean toreturn = false;
        if (impproducts.Verify(txt,field)) {
            if (impproducts.Verify(product)) {
                enabled = true;
            }
            error.setText(impproducts.getErrorMessage());
            toreturn = true;
        }
        if (operation == Operation.ADD) {
            AddButton.setEnabled(enabled);
        } else if (operation == Operation.UPDATE) {
            UpdateButton.setEnabled(enabled);
        }
        return toreturn;
    }

    private void getErrors(javax.swing.JTextField field, javax.swing.JLabel error) {
        if (field.getText().isEmpty()) {
            error.setText(impproducts.getErrorMessage());
            field.setBackground(Color.red);
        }
    }

    private void CostTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CostTextFocusLost
        product.setBuyprice(CostText.getText());
        if (Verify(CostText.getText(), "cost",CostError)) {
            CostText.setBackground(Color.WHITE);
        }
        getErrors(CostText, CostError);
    }//GEN-LAST:event_CostTextFocusLost

    private void CostTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CostTextKeyReleased
        product.setBuyprice(CostText.getText());
        if (Verify(CostText.getText(), "cost",CostError)) {
            CostText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_CostTextKeyReleased

    private void PriceTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PriceTextFocusLost
        product.setPrice(PriceText.getText());
        if (Verify(PriceText.getText(), "price",PriceError)) {
            PriceText.setBackground(Color.WHITE);
        }
        getErrors(PriceText, PriceError);
    }//GEN-LAST:event_PriceTextFocusLost

    private void PriceTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceTextKeyReleased
        product.setPrice(PriceText.getText());
        if (Verify(PriceText.getText(), "price",PriceError)) {
            PriceText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_PriceTextKeyReleased

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        LocalDate now = LocalDate.now();
        date = Date.valueOf(now);
        product.setDate(date.toString());
        if (impproducts.Insert(product)) {
            ResetProduct(product);
            setText(product);
            setBoxDisplay(new int[]{0});
            AddButton.setEnabled(false);
        }
        getMessages();
        JOptionPane.showMessageDialog(rootPane, panemessages);
        
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        impproducts.Update(product);
        getMessages();
        JOptionPane.showMessageDialog(rootPane, panemessages);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void NameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusLost
        product.setName(NameText.getText());
        if (Verify(NameText.getText(), "name",NameError)) {
            NameText.setBackground(Color.WHITE);
        }
        getErrors(NameText, NameError);
    }//GEN-LAST:event_NameTextFocusLost

    private void NameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameTextKeyReleased
        product.setName(NameText.getText());
        if (Verify(NameText.getText(), "name",NameError)) {
            NameText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_NameTextKeyReleased

    private void ProvTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ProvTextFocusLost
        product.setSender(ProvText.getText());
        if (Verify(ProvText.getText(), "provider",ProvError)) {
            ProvText.setBackground(Color.WHITE);
        }
        getErrors(ProvText, ProvError);
    }//GEN-LAST:event_ProvTextFocusLost

    private void ProvTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ProvTextKeyReleased
        product.setSender(ProvText.getText());
        if (Verify(ProvText.getText(), "provider",ProvError)) {
            ProvText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_ProvTextKeyReleased

    private void ManuTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ManuTextFocusLost
        product.setManufacturer(ManuText.getText());
        if (Verify(ManuText.getText(), "manufacturer",ManuError)) {
            ManuText.setBackground(Color.WHITE);
        }
        getErrors(ManuText, ManuError);
    }//GEN-LAST:event_ManuTextFocusLost

    private void ManuTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ManuTextKeyReleased
        product.setManufacturer(ManuText.getText());
        if (Verify(ManuText.getText(), "manufacturer",ManuError)) {
            ManuText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_ManuTextKeyReleased

    private void DifTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DifTextFocusLost
        product.setDif(DifText.getText());
        if (Verify(DifText.getText(), "dif",DifError)) {
            DifText.setBackground(Color.WHITE);
        }
        getErrors(DifText, DifError);
    }//GEN-LAST:event_DifTextFocusLost

    private void DifTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DifTextKeyReleased
        product.setDif(DifText.getText());
        if (Verify(DifText.getText(), "dif",DifError)) {
            DifText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_DifTextKeyReleased

    private void CatBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatBoxActionPerformed
        CatError.setText(" ");
        product.setCategoryid(idcategories.get(CatBox.getSelectedIndex()));
        Verify(idcategories.get(CatBox.getSelectedIndex()),"category", CatError);
    }//GEN-LAST:event_CatBoxActionPerformed

    private void CatBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CatBoxFocusLost
        if (!Verify(product.getCategoryid(), "category",CatError)) {
            CatError.setText(impproducts.getErrorMessage());
        }
    }//GEN-LAST:event_CatBoxFocusLost

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JComboBox CatBox;
    private javax.swing.JLabel CatError;
    private javax.swing.JLabel CostError;
    private javax.swing.JTextField CostText;
    private javax.swing.JLabel DifError;
    private javax.swing.JTextField DifText;
    private javax.swing.JLabel ManuError;
    private javax.swing.JTextField ManuText;
    private javax.swing.JLabel NameError;
    private javax.swing.JTextField NameText;
    private javax.swing.JLabel PriceError;
    private javax.swing.JTextField PriceText;
    private javax.swing.JLabel ProvError;
    private javax.swing.JTextField ProvText;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
