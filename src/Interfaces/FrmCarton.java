/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Interfaces;

import Controlador.ControladorJuego;
import Modelo.Carton;
import Modelo.Observer;
import java.awt.Color;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sebas
 */
public class FrmCarton extends javax.swing.JInternalFrame implements Observer{

    private ControladorJuego contrlPrin;
    private JButton[][] botones;
    /**
     * Creates new form FrmCarton
     * @param contrlPrin
     */
    public FrmCarton(ControladorJuego contrlPrin) {
        initComponents();
        
        this.contrlPrin = contrlPrin;
        
        botones = new JButton[][]{
        {b0_0, b1_0, b2_0, b3_0, b4_0},
        {b0_1, b1_1, b2_1, b3_1, b4_1},
        {b0_2, b1_2, b2_2, b3_2, b4_2},
        {b0_3, b1_3, b2_3, b3_3, b4_3},
        {b0_4, b1_4, b2_4, b3_4, b4_4}
    };
    }
    
    public void limpiarColores() {
    for (int i = 0; i < botones.length; i++) {
        for (int j = 0; j < botones[i].length; j++) {
            botones[i][j].setBackground(Color.WHITE);
        }
    }
}

    
    public void llenarCarton(int[][] v, String id ){
        for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            botones[i][j].setText(String.valueOf(v[i][j]));
        }
    }
       btnId.setText(id);
    }
    
    public void pintarCarton(int n){
         for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {

            String txt = botones[i][j].getText();

                if (!txt.isEmpty() && Integer.parseInt(txt) == n) {
                botones[i][j].setBackground(Color.RED);
                return;
                }
            }
         }
    }
    
    public void DesmarcarCarton(int n){
         for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {

            String txt = botones[i][j].getText();

                if (!txt.isEmpty() && Integer.parseInt(txt) == n) {
                botones[i][j].setBackground(Color.WHITE);
                return;
                }
            }
         }
    }
  public void habilitarModoManual() {

    for (int fila = 0; fila < botones.length; fila++) {
        for (int col = 0; col < botones[fila].length; col++) {

            JButton btn = botones[fila][col];

            // ---- RESETEO TOTAL ----
            btn.setText("");
            btn.setBackground(Color.WHITE);

            // remover ActionListeners anteriores (NECESARIO)
            for (var al : btn.getActionListeners()) {
                btn.removeActionListener(al);
            }

            final int f = fila;
            final int c = col;

            btn.addActionListener(e -> {
                String txt = JOptionPane.showInputDialog(
                    this,
                    "Ingrese un número válido"
                );

                if (txt == null || txt.isEmpty()) return;

                try {
                    int n = Integer.parseInt(txt);

                    // Validación general
                    if (n < 1 || n > 75) {
                        JOptionPane.showMessageDialog(this, "Debe ser entre 1 y 75");
                        return;
                    }

                    // Validación por columna B I N G O
                    int min = c * 15 + 1;
                    int max = (c + 1) * 15;

                    if (n < min || n > max) {
                        JOptionPane.showMessageDialog(this,
                            "Columna " + "BINGO".charAt(c) + " usa números " + min + " a " + max);
                        return;
                    }

                    // Validación de repetidos
                    if (numeroRepetidoEnCarton(n, f, c)) {
                        JOptionPane.showMessageDialog(this, "Número repetido en el cartón.");
                        return;
                    }

                    // Establecer número sin marcar color
                    btn.setText(String.valueOf(n));
                    btn.setBackground(Color.WHITE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Debe ser un número.");
                }
            });
        }
    }

    // Forzar que el FREE SPACE sea 0
    botones[2][2].setText("0");
    botones[2][2].setBackground(Color.WHITE);
}

private boolean numeroRepetidoEnCarton(int n, int filaActual, int colActual) {
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {

            if (i == filaActual && j == colActual) continue;

            String txt = botones[i][j].getText();
            if (!txt.isEmpty() && Integer.parseInt(txt) == n) return true;
        }
    }
    return false;
}
public void setId(String id) {
    btnId.setText(id);
}



    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        b0_0 = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        idCarton1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        b2_0 = new javax.swing.JButton();
        b3_0 = new javax.swing.JButton();
        b4_0 = new javax.swing.JButton();
        b1_0 = new javax.swing.JButton();
        b2_1 = new javax.swing.JButton();
        b3_1 = new javax.swing.JButton();
        b4_1 = new javax.swing.JButton();
        b1_1 = new javax.swing.JButton();
        b0_1 = new javax.swing.JButton();
        b2_2 = new javax.swing.JButton();
        b3_2 = new javax.swing.JButton();
        b4_2 = new javax.swing.JButton();
        b1_2 = new javax.swing.JButton();
        b0_2 = new javax.swing.JButton();
        b2_3 = new javax.swing.JButton();
        b3_3 = new javax.swing.JButton();
        b4_3 = new javax.swing.JButton();
        b1_3 = new javax.swing.JButton();
        b0_3 = new javax.swing.JButton();
        b2_4 = new javax.swing.JButton();
        b3_4 = new javax.swing.JButton();
        b4_4 = new javax.swing.JButton();
        b1_4 = new javax.swing.JButton();
        b0_4 = new javax.swing.JButton();
        btnId = new javax.swing.JButton();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Cartón número :");

        b0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0_0ActionPerformed(evt);
            }
        });

        idCarton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idCarton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Cartón número :");

        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(idCarton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idCarton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        b2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_0ActionPerformed(evt);
            }
        });

        b3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_0ActionPerformed(evt);
            }
        });

        b4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4_0ActionPerformed(evt);
            }
        });

        b1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_0ActionPerformed(evt);
            }
        });

        b2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_1ActionPerformed(evt);
            }
        });

        b3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_1ActionPerformed(evt);
            }
        });

        b4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4_1ActionPerformed(evt);
            }
        });

        b1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_1ActionPerformed(evt);
            }
        });

        b0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0_1ActionPerformed(evt);
            }
        });

        b2_2.setText(":)");
        b2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_2ActionPerformed(evt);
            }
        });

        b3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_2ActionPerformed(evt);
            }
        });

        b4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4_2ActionPerformed(evt);
            }
        });

        b1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_2ActionPerformed(evt);
            }
        });

        b0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0_2ActionPerformed(evt);
            }
        });

        b2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_3ActionPerformed(evt);
            }
        });

        b3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_3ActionPerformed(evt);
            }
        });

        b4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4_3ActionPerformed(evt);
            }
        });

        b1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_3ActionPerformed(evt);
            }
        });

        b0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0_3ActionPerformed(evt);
            }
        });

        b2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2_4ActionPerformed(evt);
            }
        });

        b3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3_4ActionPerformed(evt);
            }
        });

        b4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4_4ActionPerformed(evt);
            }
        });

        b1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1_4ActionPerformed(evt);
            }
        });

        b0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0_4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnId, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 184, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 184, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(b0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 155, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 156, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b0_0ActionPerformed

    private void idCarton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idCarton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idCarton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void b2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2_0ActionPerformed

    private void b3_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_0ActionPerformed

    private void b4_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4_0ActionPerformed

    private void b1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_0ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1_0ActionPerformed

    private void b2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2_1ActionPerformed

    private void b3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_1ActionPerformed

    private void b4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4_1ActionPerformed

    private void b1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1_1ActionPerformed

    private void b0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b0_1ActionPerformed

    private void b2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2_2ActionPerformed

    private void b3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_2ActionPerformed

    private void b4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4_2ActionPerformed

    private void b1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1_2ActionPerformed

    private void b0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b0_2ActionPerformed

    private void b2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2_3ActionPerformed

    private void b3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_3ActionPerformed

    private void b4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4_3ActionPerformed

    private void b1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1_3ActionPerformed

    private void b0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b0_3ActionPerformed

    private void b2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b2_4ActionPerformed

    private void b3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b3_4ActionPerformed

    private void b4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b4_4ActionPerformed

    private void b1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b1_4ActionPerformed

    private void b0_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b0_4ActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
         int r = JOptionPane.showConfirmDialog(this, "Quieres borrar el cartón con ID: "+btnId.getText(), "Borrar Cartón!", JOptionPane.YES_NO_OPTION);

    if (r == JOptionPane.YES_OPTION) {
        contrlPrin.eliminarObserver(this);
        contrlPrin.eliminarCarton(btnId.getText());
        this.dispose();
    } else {
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
    }
    
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b0_0;
    private javax.swing.JButton b0_1;
    private javax.swing.JButton b0_2;
    private javax.swing.JButton b0_3;
    private javax.swing.JButton b0_4;
    private javax.swing.JButton b1_0;
    private javax.swing.JButton b1_1;
    private javax.swing.JButton b1_2;
    private javax.swing.JButton b1_3;
    private javax.swing.JButton b1_4;
    private javax.swing.JButton b2_0;
    private javax.swing.JButton b2_1;
    private javax.swing.JButton b2_2;
    private javax.swing.JButton b2_3;
    private javax.swing.JButton b2_4;
    private javax.swing.JButton b3_0;
    private javax.swing.JButton b3_1;
    private javax.swing.JButton b3_2;
    private javax.swing.JButton b3_3;
    private javax.swing.JButton b3_4;
    private javax.swing.JButton b4_0;
    private javax.swing.JButton b4_1;
    private javax.swing.JButton b4_2;
    private javax.swing.JButton b4_3;
    private javax.swing.JButton b4_4;
    private javax.swing.JButton btnId;
    private javax.swing.JTextField idCarton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onNumeroCantado(int numero) {
         pintarCarton(numero);
    }

    @Override
    public void onGanadores(List<Carton> ganadores) {
        
    }
}
