/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Animal;
import model.AnimalDAO;
import model.Cliente;
import model.ClienteDAO;
import model.DAO;
import view.AnimalTableModel;
import view.TelaCadastroCliente;
import view.TelaCadastroCliente;
import view.TelaCadastroVeterinario;
import view.TelaConsultas;

/**
 *
 * @author karlos
 */
public class TelaCadastroAnimal extends javax.swing.JFrame {

    /**
     * Creates new form TelaAnimais
     */
    public TelaCadastroAnimal() {
        initComponents();
        
        
        
        tableDados.getColumnModel().getColumn(5).setMinWidth(0);
        tableDados.getColumnModel().getColumn(5).setMaxWidth(0);
        
        
        List<Cliente> clientes = ClienteDAO.getInstance().getAllClientes();
        clientes.forEach(cliente -> {
            comboCliente.addItem(cliente.getNome());
        });
        
         comboEspecie.removeAllItems();
         ArrayList<String> especies = new ArrayList();
         especies.add("Cão");
         especies.add("Gato");
       
           int i;
        int n = especies.size();
    for (i=0; i<n; i++) {

            comboEspecie.addItem(especies.get(i));
        }
    
        ImageIcon icon = new ImageIcon(DAO.getImage("consultaagendada"));// aqui vai ter que colocar o endereço do seu desktop
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(imgScale);
        jLabel7.setIcon(scaledIcon);
        
        ImageIcon icon1 = new ImageIcon(DAO.getImage("novaconsulta"));// aqui vai ter que colocar o endereço do seu desktop
        Image img1 = icon1.getImage();
        Image imgScale1 = img1.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(imgScale1);
        jLabel8.setIcon(scaledIcon1);
        
        ImageIcon icon2 = new ImageIcon(DAO.getImage("cadastroanimal"));// aqui vai ter que colocar o endereço do seu desktop
        Image img2 = icon2.getImage();
        Image imgScale2 = img2.getScaledInstance(jLabel9.getWidth(), jLabel9.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
        jLabel9.setIcon(scaledIcon2);
        
        ImageIcon icon3 = new ImageIcon(DAO.getImage("cadastrocliente"));// aqui vai ter que colocar o endereço do seu desktop
        Image img3 = icon3.getImage();
        Image imgScale3 = img3.getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
        jLabel10.setIcon(scaledIcon3);
        
        ImageIcon icon4 = new ImageIcon(DAO.getImage("cadastroveterinario"));// aqui vai ter que colocar o endereço do seu desktop
        Image img4 = icon4.getImage();
        Image imgScale4 = img4.getScaledInstance(jLabel11.getWidth(), jLabel11.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledIcon4 = new ImageIcon(imgScale4);
        jLabel11.setIcon(scaledIcon4);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        painelCadastro = new javax.swing.JLayeredPane();
        labelNome = new javax.swing.JLabel();
        textNome = new javax.swing.JTextField();
        labelAnoNascimento = new javax.swing.JLabel();
        textAnoNascimento = new javax.swing.JTextField();
        labelSexo = new javax.swing.JLabel();
        comboSexo = new javax.swing.JComboBox<>();
        labelCliente = new javax.swing.JLabel();
        comboEspecie = new javax.swing.JComboBox<>();
        panelDados = new javax.swing.JScrollPane();
        tableDados = new javax.swing.JTable();
        buttonSalvar1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        labelCliente1 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1058, 450));

        jPanel1.setBackground(new java.awt.Color(134, 207, 132));
        jPanel1.setForeground(new java.awt.Color(134, 207, 132));

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cadastros");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Consultas");
        jLabel2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel2KeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Consultas agendadas");
        jLabel3.setToolTipText("");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cadastro cliente");
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nova consulta");
        jLabel5.setToolTipText("");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Console", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 0, 0));
        jLabel6.setText("Cadastro animal");
        jLabel6.setToolTipText("");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Console", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cadastro veterinario");
        jLabel12.setToolTipText("");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jLabel4.getAccessibleContext().setAccessibleName("jButton4");

        painelCadastro.setBackground(new java.awt.Color(255, 255, 255));
        painelCadastro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        painelCadastro.setForeground(new java.awt.Color(255, 255, 255));
        painelCadastro.setOpaque(true);

        labelNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelNome.setText("Nome");

        textNome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        labelAnoNascimento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelAnoNascimento.setText("Ano de Nascimento");

        textAnoNascimento.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        labelSexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelSexo.setText("Sexo");

        comboSexo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fêmea", "Macho" }));

        labelCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCliente.setText("Espécie");

        comboEspecie.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEspecieActionPerformed(evt);
            }
        });

        tableDados.setModel(
            new AnimalTableModel((ArrayList)AnimalDAO.getInstance().getAllAnimais())

        );
        panelDados.setViewportView(tableDados);

        buttonSalvar1.setBackground(new java.awt.Color(255, 255, 255));
        buttonSalvar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttonSalvar1.setForeground(new java.awt.Color(51, 255, 51));
        buttonSalvar1.setText("Salvar");
        buttonSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvar1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 0, 51));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelCliente1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCliente1.setText("Cliente");

        comboCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboClienteActionPerformed(evt);
            }
        });

        painelCadastro.setLayer(labelNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(textNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(labelAnoNascimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(textAnoNascimento, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(labelSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(comboSexo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(labelCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(comboEspecie, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(panelDados, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(buttonSalvar1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(labelCliente1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        painelCadastro.setLayer(comboCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout painelCadastroLayout = new javax.swing.GroupLayout(painelCadastro);
        painelCadastro.setLayout(painelCadastroLayout);
        painelCadastroLayout.setHorizontalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelCadastroLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelDados)
                            .addGroup(painelCadastroLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(painelCadastroLayout.createSequentialGroup()
                                        .addComponent(buttonSalvar1)
                                        .addGap(444, 444, 444))
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelCadastroLayout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(labelNome)
                            .addGap(18, 18, 18)
                            .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelCadastroLayout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(labelAnoNascimento)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(textAnoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(labelSexo)
                            .addGap(18, 18, 18)
                            .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelCadastroLayout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(labelCliente)
                            .addGap(18, 18, 18)
                            .addComponent(comboEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(66, 66, 66)
                            .addComponent(labelCliente1)
                            .addGap(18, 18, 18)
                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(70, 70, 70))
        );
        painelCadastroLayout.setVerticalGroup(
            painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNome))
                .addGap(25, 25, 25)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textAnoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelAnoNascimento))
                    .addComponent(comboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(labelSexo)))
                .addGap(17, 17, 17)
                .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelCliente))
                    .addComponent(labelCliente1)
                    .addGroup(painelCadastroLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(buttonSalvar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        comboEspecie.getAccessibleContext().setAccessibleName("comboEspecie");
        comboCliente.getAccessibleContext().setAccessibleName("comboCliente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelCadastro)
        );

        painelCadastro.getAccessibleContext().setAccessibleName("PainelCadastro");

        pack();
    }// </editor-fold>//GEN-END:initComponents
int t=0;
    private void buttonSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvar1ActionPerformed
     
        Integer clienteSelecionado = comboCliente.getSelectedIndex();
        List<Cliente> clientes = ClienteDAO.getInstance().getAllClientes();
        Cliente cliente = clientes.get(clienteSelecionado);
        
        Integer id = AnimalDAO.getInstance().addAnimal(
                textNome.getText(), 
                Integer.parseInt(textAnoNascimento.getText()),
                (String)comboSexo.getSelectedItem(), 
                cliente,
                (String)comboEspecie.getSelectedItem()        );
        
        if (id > -1) {
            Animal animal = AnimalDAO.getInstance().getAnimalById(id);
            AnimalTableModel tb = (AnimalTableModel)tableDados.getModel();
            tb.addItem(animal);
        }
    
        
        
        
        
    }//GEN-LAST:event_buttonSalvar1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
        
        AnimalTableModel tb = ((AnimalTableModel)tableDados.getModel());
        
        int idAnimal =(Integer) tableDados.getModel().getValueAt(  tableDados.getSelectedRow() ,5);
       
     
            AnimalDAO.getInstance().deleteAnimalById(idAnimal);
        
         
            tb.removeItem(tableDados.getSelectedRow());         
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        TelaCadastroAnimal nomeVariavel = new TelaCadastroAnimal();
        nomeVariavel.setVisible(true);
        dispose();

    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
    TelaCadastroConsulta nomeVariavel = new TelaCadastroConsulta();
        nomeVariavel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        TelaCadastroCliente nomeVariavel = new TelaCadastroCliente();
        nomeVariavel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        TelaConsultas tela = new TelaConsultas();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel2KeyPressed

    }//GEN-LAST:event_jLabel2KeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        TelaCadastroVeterinario nomeVariavel = new TelaCadastroVeterinario();
        nomeVariavel.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void comboEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEspecieActionPerformed
      
    }//GEN-LAST:event_comboEspecieActionPerformed

    private void comboClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAnimal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSalvar1;
    private javax.swing.JComboBox<String> comboCliente;
    private javax.swing.JComboBox<String> comboEspecie;
    private javax.swing.JComboBox<String> comboSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelAnoNascimento;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelCliente1;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLayeredPane painelCadastro;
    private javax.swing.JScrollPane panelDados;
    private javax.swing.JTable tableDados;
    private javax.swing.JTextField textAnoNascimento;
    private javax.swing.JTextField textNome;
    // End of variables declaration//GEN-END:variables
}