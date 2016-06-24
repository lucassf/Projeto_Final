package Screens;

import Data.Providers;
import Filters.*;
import java.awt.Color;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class JDProviders extends javax.swing.JDialog {

    private final int MAXSIZE = 40;
    private final int MAXPHONESIZE = 14;
    private String panemessage;

    Providers provider;
    Implement.ImpProviders impproviders = new Implement.ImpProviders();
    private Connection.DatabaseConnection database;
    private Operation operation;
    private Date date;

    public JDProviders(java.awt.Frame parent, boolean modal) {
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
            provider = new Providers();
            UpdateButton.setVisible(false);
            AddButton.setEnabled(false);
        }
    }

    public void setDatabase(Connection.DatabaseConnection database) {
        this.database = database;
        impproviders.setDatabase(database);
    }

    public void setText(Providers p) {
        NameText.setText(p.getName());
        CnpjText.setText(p.getCnpj());
        EmailText.setText(p.getEmail());
        Phone1Text.setText(p.getPhone1());
        Phone2Text.setText(p.getPhone2());
        AddressText.setText(p.getAddress());
        CityText.setText(p.getCity());
        NeigbText.setText(p.getNeighborhood());
    }

    public void setProvider(Providers p) {
        provider = p;
    }

    public void setBoxDisplay(String s) {
        StatesBox.setSelectedItem(s);
    }

    private void getMessages() {
        panemessage = impproviders.getMessage();
    }

    private void setFilters() {
        ((AbstractDocument) NameText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) AddressText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) CityText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) NeigbText.getDocument()).setDocumentFilter(new SizeFilter(MAXSIZE));
        ((AbstractDocument) Phone1Text.getDocument()).setDocumentFilter(new NumberFilter(false,MAXPHONESIZE));
        ((AbstractDocument) Phone2Text.getDocument()).setDocumentFilter(new NumberFilter(false,MAXPHONESIZE));
    }

    private void ResetProvider(Providers p) {
        provider.setAddress("");
        provider.setCity("");
        provider.setCnpj("");
        provider.setDate("");
        provider.setEmail("");
        provider.setId("");
        provider.setName("");
        provider.setNeighborhood("");
        provider.setPhone1("");
        provider.setPhone2("");
        provider.setState("AC");
    }

    private boolean Verify(String txt, String field, javax.swing.JLabel error) {
        boolean enabled = false;
        boolean toreturn = false;
        if (impproviders.Verify(txt, field)) {
            if (impproviders.Verify(provider)) {
                enabled = true;
            }
            error.setText(impproviders.getErrorMessage());
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
            error.setText(impproviders.getErrorMessage());
            field.setBackground(Color.red);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        NameText = new javax.swing.JTextField();
        AddressText = new javax.swing.JTextField();
        CityText = new javax.swing.JTextField();
        CnpjText = new javax.swing.JTextField();
        Phone1Text = new javax.swing.JTextField();
        Phone2Text = new javax.swing.JTextField();
        EmailText = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        UpdateButton = new javax.swing.JButton();
        NameError = new javax.swing.JLabel();
        CnpjError = new javax.swing.JLabel();
        EmailError = new javax.swing.JLabel();
        Phone1Error = new javax.swing.JLabel();
        CityError = new javax.swing.JLabel();
        Phone2Error = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NeigbText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        StatesBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de fornecedores");

        jLabel1.setText("*Nome:");

        jLabel2.setText("*Cnpj:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("*Cidade:");

        jLabel6.setText("*Telefone 1:");

        jLabel7.setText("Telefone 2:");

        jLabel8.setText("*Email:");

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

        AddressText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AddressTextFocusLost(evt);
            }
        });

        CityText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CityTextFocusLost(evt);
            }
        });
        CityText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CityTextKeyReleased(evt);
            }
        });

        CnpjText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                CnpjTextFocusLost(evt);
            }
        });
        CnpjText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CnpjTextKeyReleased(evt);
            }
        });

        Phone1Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Phone1TextFocusLost(evt);
            }
        });
        Phone1Text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Phone1TextKeyReleased(evt);
            }
        });

        Phone2Text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Phone2TextFocusLost(evt);
            }
        });
        Phone2Text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Phone2TextKeyReleased(evt);
            }
        });

        EmailText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailTextFocusLost(evt);
            }
        });
        EmailText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EmailTextKeyReleased(evt);
            }
        });

        AddButton.setText("Adicionar");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
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

        CnpjError.setForeground(new java.awt.Color(255, 0, 51));
        CnpjError.setText(" ");

        EmailError.setForeground(new java.awt.Color(255, 0, 51));
        EmailError.setText(" ");

        Phone1Error.setForeground(new java.awt.Color(255, 0, 51));
        Phone1Error.setText(" ");

        CityError.setForeground(new java.awt.Color(255, 0, 51));
        CityError.setText(" ");

        Phone2Error.setForeground(new java.awt.Color(255, 0, 51));
        Phone2Error.setText(" ");

        jLabel9.setText("Bairro:");

        NeigbText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                NeigbTextFocusLost(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel11.setText("Max.: 40 caracteres");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel12.setText("Max.: 40 caracteres");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel13.setText("Max.: 40 caracteres");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel14.setText("Max.: 40 caracteres");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel15.setText("Somente números");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel16.setText("Somente números");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel17.setText("Somente números");

        jLabel5.setText("*Estado:");

        StatesBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        StatesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatesBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("* Item obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel12))
                                        .addComponent(StatesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(CnpjError, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(EmailError, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Phone1Error, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(158, 158, 158))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(CnpjText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel15)
                                            .addGap(84, 84, 84))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(Phone1Text, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel16)
                                            .addGap(84, 84, 84)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(28, 28, 28)
                                            .addComponent(UpdateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(AddButton))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(CityText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel13))
                                                        .addComponent(CityError, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(NeigbText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel14)))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11))
                            .addComponent(NameError, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Phone2Text, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17))
                            .addComponent(Phone2Error, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(AddressText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(StatesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CityText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CityError))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(CnpjText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CnpjError)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(EmailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(EmailError)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Phone1Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Phone1Error)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Phone2Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(NeigbText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Phone2Error)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(UpdateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        LocalDate now = LocalDate.now();
        date = Date.valueOf(now);
        provider.setDate(date.toString());
        if (impproviders.Insert(provider)) {
            ResetProvider(provider);
            setText(provider);
            setBoxDisplay("AC");
            StatesBox.setSelectedIndex(0);
            AddButton.setEnabled(false);
        }
        getMessages();
        JOptionPane.showMessageDialog(rootPane, panemessage);
    }//GEN-LAST:event_AddButtonActionPerformed

    private void UpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateButtonActionPerformed
        impproviders.Update(provider);
        getMessages();
        JOptionPane.showMessageDialog(rootPane, panemessage);
    }//GEN-LAST:event_UpdateButtonActionPerformed

    private void NameTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NameTextFocusLost
        provider.setName(NameText.getText());
        if (Verify(NameText.getText(), "name", NameError)) {
            NameText.setBackground(Color.WHITE);
        } else{
        getErrors(NameText, NameError);
        }
    }//GEN-LAST:event_NameTextFocusLost

    private void NameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NameTextKeyReleased
        provider.setName(NameText.getText());
        if (Verify(NameText.getText(), "name", NameError)) {
            NameText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_NameTextKeyReleased

    private void CnpjTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CnpjTextFocusLost
        provider.setCnpj(CnpjText.getText());
        if (Verify(CnpjText.getText(), "cnpj", CnpjError)) {
            CnpjText.setBackground(Color.WHITE);
        }else{
        getErrors(CnpjText, CnpjError);
        }
    }//GEN-LAST:event_CnpjTextFocusLost

    private void CnpjTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CnpjTextKeyReleased
        provider.setCnpj(CnpjText.getText());
        if (Verify(CnpjText.getText(), "cnpj", CnpjError)) {
            CnpjText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_CnpjTextKeyReleased

    private void EmailTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailTextFocusLost
        provider.setEmail(EmailText.getText());
        if (Verify(EmailText.getText(), "email", EmailError)) {
            EmailText.setBackground(Color.WHITE);
        }else{
        getErrors(EmailText, EmailError);
        }
    }//GEN-LAST:event_EmailTextFocusLost

    private void EmailTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EmailTextKeyReleased
        provider.setEmail(EmailText.getText());
        if (Verify(EmailText.getText(), "email", EmailError)) {
            EmailText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_EmailTextKeyReleased

    private void Phone1TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Phone1TextFocusLost
        provider.setPhone1(Phone1Text.getText());
        if (Verify(Phone1Text.getText(), "phone", Phone1Error)) {
            Phone1Text.setBackground(Color.WHITE);
        }else{
        getErrors(Phone1Text, Phone1Error);
        }
    }//GEN-LAST:event_Phone1TextFocusLost

    private void Phone1TextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone1TextKeyReleased
        provider.setPhone1(Phone1Text.getText());
        if (Verify(Phone1Text.getText(), "phone", Phone1Error)) {
            Phone1Text.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Phone1TextKeyReleased

    private void Phone2TextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Phone2TextFocusLost
        provider.setPhone2(Phone2Text.getText());
        if (Verify(Phone2Text.getText(), "phone", Phone2Error)) {
            Phone2Text.setBackground(Color.WHITE);
        }else{
        getErrors(Phone2Text, Phone2Error);
        }
    }//GEN-LAST:event_Phone2TextFocusLost

    private void Phone2TextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Phone2TextKeyReleased
        provider.setPhone2(Phone2Text.getText());
        if (Verify(Phone2Text.getText(), "phone", Phone2Error)) {
            Phone2Text.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_Phone2TextKeyReleased

    private void AddressTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AddressTextFocusLost
        provider.setAddress(AddressText.getText());
    }//GEN-LAST:event_AddressTextFocusLost

    private void StatesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatesBoxActionPerformed
        provider.setState((String) StatesBox.getSelectedItem());
    }//GEN-LAST:event_StatesBoxActionPerformed

    private void CityTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CityTextFocusLost
        provider.setCity(CityText.getText());
        if (Verify(CityText.getText(), "city", CityError)) {
            CityText.setBackground(Color.WHITE);
        }else{
        getErrors(CityText, CityError);
        }
    }//GEN-LAST:event_CityTextFocusLost

    private void CityTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CityTextKeyReleased
        provider.setCity(CityText.getText());
        if (Verify(CityText.getText(), "city", CityError)) {
            CityText.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_CityTextKeyReleased

    private void NeigbTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NeigbTextFocusLost
        provider.setNeighborhood(NeigbText.getText());
    }//GEN-LAST:event_NeigbTextFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JTextField AddressText;
    private javax.swing.JLabel CityError;
    private javax.swing.JTextField CityText;
    private javax.swing.JLabel CnpjError;
    private javax.swing.JTextField CnpjText;
    private javax.swing.JLabel EmailError;
    private javax.swing.JTextField EmailText;
    private javax.swing.JLabel NameError;
    private javax.swing.JTextField NameText;
    private javax.swing.JTextField NeigbText;
    private javax.swing.JLabel Phone1Error;
    private javax.swing.JTextField Phone1Text;
    private javax.swing.JLabel Phone2Error;
    private javax.swing.JTextField Phone2Text;
    private javax.swing.JComboBox StatesBox;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
