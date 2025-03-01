import com.google.zxing.*;
import com.google.zxing.client.j2se.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class QRKoder extends JFrame {
    private JTextField metinAlani;
    private JLabel qrGoster;
    private JButton uretDugme, kaydetDugme, okuDugme;

    public QRKoder() {
        setTitle("QRKoder");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        metinAlani = new JTextField(20);
        metinAlani.setText("Link veya metin giriniz");
        metinAlani.setForeground(Color.GRAY);
        metinAlani.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (metinAlani.getText().equals("Link veya metin giriniz")) {
                    metinAlani.setText("");
                    metinAlani.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (metinAlani.getText().isEmpty()) {
                    metinAlani.setText("Link veya metin giriniz");
                    metinAlani.setForeground(Color.GRAY);
                }
            }
        });

        uretDugme = new JButton("ÜRET");
        kaydetDugme = new JButton("KAYDET");
        okuDugme = new JButton("QR OKU");
        dugmeStili(uretDugme);
        dugmeStili(kaydetDugme);
        dugmeStili(okuDugme);

        gbc.gridx = 0;
        gbc.gridy = 0;
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

        gbc.gridy = 3;
        add(kaydetDugme, gbc);

        gbc.gridy = 5;
        add(okuDugme, gbc);

        uretDugme.addActionListener(e -> qrKodUret());
        kaydetDugme.addActionListener(e -> qrKodKaydet());
        okuDugme.addActionListener(e -> qrKodOku());
    }

    private void qrKodUret() {
        try {
            String metin = metinAlani.getText();
            if (metin.equals("Link veya metin giriniz")) return;
            BitMatrix bitMatrisi = new MultiFormatWriter().encode(metin, BarcodeFormat.QR_CODE, 300, 300);
            BufferedImage qrGoruntu = MatrixToImageWriter.toBufferedImage(bitMatrisi);
            qrGoster.setIcon(new ImageIcon(qrGoruntu));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "QR Kod oluşturulamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void qrKodKaydet() {
        try {
            String metin = metinAlani.getText();
            BitMatrix bitMatrisi = new MultiFormatWriter().encode(metin, BarcodeFormat.QR_CODE, 300, 300);
            Path dosyaYolu = Paths.get("qrcode.png");
            MatrixToImageWriter.writeToPath(bitMatrisi, "PNG", dosyaYolu);
            JOptionPane.showMessageDialog(this, "QR Kod kaydedildi!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "QR Kod kaydedilemedi!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void qrKodOku() {
        try {
            JFileChooser dosyaSecici = new JFileChooser();
            if (dosyaSecici.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File secilenDosya = dosyaSecici.getSelectedFile();
                BufferedImage qrGoruntu = ImageIO.read(secilenDosya);
                LuminanceSource kaynak = new BufferedImageLuminanceSource(qrGoruntu);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(kaynak));
                Result sonuc = new MultiFormatReader().decode(bitmap);
                JOptionPane.showMessageDialog(this, "QR İçeriği: " + sonuc.getText(), "QR Okundu", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "QR Kod okunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void dugmeStili(JButton dugme) {
        dugme.setBackground(new Color(50, 150, 250)); // Mavi arka plan
        dugme.setForeground(Color.WHITE); // Beyaz yazı rengi
        dugme.setFocusPainted(false); // Butona odaklanınca değişmemesi için
        dugme.setContentAreaFilled(false); // İç dolguyu kapatır, rengin değişmesini engeller
        dugme.setOpaque(true); // Arkaplanın sabit kalmasını sağlar
        dugme.setBorderPainted(false); // Kenar çizgisini kaldırır
        dugme.setFont(new Font("Arial", Font.BOLD, 16)); // Yazı tipi ve boyutu
        dugme.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Kenar boşluğu ayarı
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new QRKoder().setVisible(true));
    }
}
