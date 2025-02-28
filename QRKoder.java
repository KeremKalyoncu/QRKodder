import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class QRKoder extends JFrame {
    private JTextField metinAlani;
    private JLabel qrGoster;
    private JButton uretDugme, kaydetDugme;

    public QRKoder() {
        setTitle("QRKoder");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        metinAlani = new JTextField(20);
        metinAlani.setText("Link veya metin giriniz");
        metinAlani.setForeground(Color.GRAY);
        metinAlani.setOpaque(false);
        metinAlani.setBackground(new Color(255, 255, 255, 100));
        metinAlani.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (metinAlani.getText().equals("Link veya metin giriniz")) {
                    metinAlani.setText("");
                    metinAlani.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (metinAlani.getText().isEmpty()) {
                    metinAlani.setText("Link veya metin giriniz");
                    metinAlani.setForeground(Color.BLACK);
                }
            }
        });
        uretDugme = new JButton("ÜRET");
        dugmeStili(uretDugme);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        add(metinAlani, gbc);

        gbc.gridx = 1;
        add(uretDugme, gbc);

        qrGoster = new JLabel();
        qrGoster.setPreferredSize(new Dimension(300, 300));
        qrGoster.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(qrGoster, gbc);

        kaydetDugme = new JButton("KAYDET");
        dugmeStili(kaydetDugme);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(kaydetDugme, gbc);

        uretDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qrKodUret();
            }
        });

        kaydetDugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qrKodKaydet();
            }
        });
    }

    private void qrKodUret() {
        try {
            String metin = metinAlani.getText();
            if (metin.equals("Link veya metin giriniz")) return;
            int genislik = 300;
            int yukseklik = 300;

            BitMatrix bitMatrisi = new MultiFormatWriter().encode(metin, BarcodeFormat.QR_CODE, genislik, yukseklik);
            BufferedImage qrGoruntu = MatrixToImageWriter.toBufferedImage(bitMatrisi);

            qrGoster.setIcon(new ImageIcon(qrGoruntu));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "QR Kod oluşturulamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void qrKodKaydet() {
        try {
            String metin = metinAlani.getText();
            int genislik = 300;
            int yukseklik = 300;
            BitMatrix bitMatrisi = new MultiFormatWriter().encode(metin, BarcodeFormat.QR_CODE, genislik, yukseklik);

            Path exeDizini = Paths.get(new File(".").getAbsolutePath()).normalize();
            Path dosyaYolu = exeDizini.resolve("qrcode.png");
            MatrixToImageWriter.writeToPath(bitMatrisi, "PNG", dosyaYolu);

            JOptionPane.showMessageDialog(this, "QR Kod kaydedildi: " + dosyaYolu.toAbsolutePath(), "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "QR Kod kaydedilemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dugmeStili(JButton dugme) {
        dugme.setBackground(new Color(50, 150, 250, 150));
        dugme.setForeground(Color.WHITE);
        dugme.setFocusPainted(false);
        dugme.setFont(new Font("Arial", Font.BOLD, 16));
        dugme.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QRKoder().setVisible(true);
        });
    }
}
