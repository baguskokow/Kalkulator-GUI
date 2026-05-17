import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

public class KalkulatorLatexApp extends JFrame implements ActionListener {
    
    private JLabel screenLabel;
    // Variabel untuk menyimpan string rumus mentah asli (tanpa kursor)
    private String rawText = "0"; 

    public KalkulatorLatexApp() {
        // 1. Setup Window Utama
        setTitle("Kalkulator LaTeX Dinamis");
        setSize(420, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // 2. Setup Layar Utama (screenLabel)
        screenLabel = new JLabel();
        screenLabel.setHorizontalAlignment(SwingConstants.RIGHT); // Rata kanan ala kalkulator
        screenLabel.setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
        add(screenLabel, BorderLayout.NORTH);

        // Render angka "0" pertama kali saat aplikasi dibuka (belum ada kursor)
        updateLatexScreen(rawText);

        // 3. Setup Panel dan Tombol-Tombol
        JPanel buttonPanel = new JPanel(new GridLayout(2, 4, 6, 6));
        String[] buttons = {"7", "8", "9", "+", "2", "^", "AC", "="};

        for (String txt : buttons) {
            JButton btn = new JButton(txt);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 18));
            btn.setFocusable(false);
            btn.addActionListener(this); // Semua tombol bermuara ke actionPerformed
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent action) {
        String textTombol = action.getActionCommand();

        // KONDISI 1: Jika tombol Reset (AC) diklik
        if (textTombol.equals("AC")) {
            rawText = "0";
            updateLatexScreen(rawText); // Tampilkan "0" polosan tanpa kursor awal
        } 
        
        // KONDISI 2: Jika tombol Hasil (=) diklik
        else if (textTombol.equals("=")) {
            String hasilHitung;
            
            // Simulasi logika hitung sederhana berdasarkan input
            if (rawText.equals("9^2")) {
                hasilHitung = "81";
            } else if (rawText.equals("7+8")) {
                hasilHitung = "15";
            } else {
                hasilHitung = "999"; // Default penampung sementara
            }
            
            rawText = hasilHitung;       // Rumus mentah di-reset jadi hasil akhir murni
            updateLatexScreen(rawText);  // Tampilkan hasil akhir polosan (kursor hilang)
        } 
        
        // KONDISI 3: Jika tombol angka atau operator (+, ^, dll) diklik
        else {
            if (rawText.equals("0")) {
                rawText = textTombol; // Ganti angka 0 di awal dengan input baru
            } else {
                rawText = rawText + textTombol; // Gabungkan string rumus
            }

            // Pintu Utama Render: Kirim rumus mentah ditambah kursor " |" di ujungnya
            updateLatexScreen(rawText + " |");
        }
    }

    // --- ENGINE RENDER LATEX (SATU PINTU) ---
    private void updateLatexScreen(String textToRender) {
        try {
            // Ubah string mentah menjadi format sintaks LaTeX yang valid
            String latexFormula = formatToLatex(textToRender);
            
            // Proses render string menjadi komponen Gambar (TeXIcon)
            TeXFormula formula = new TeXFormula(latexFormula);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 32); // Ukuran font 32
            
            // Tempelkan gambar hasil render ke label layar
            screenLabel.setIcon(icon);
            screenLabel.setText(""); // Kosongkan teks bawaan biar gak tumpang tindih
            
            // Segarkan UI secara real-time
            screenLabel.revalidate();
            screenLabel.repaint();
            
        } catch (Exception e) {
            // Pengaman jika formula LaTeX bermasalah, paksa tampilkan teks biasa
            screenLabel.setIcon(null);
            screenLabel.setText(textToRender);
        }
    }

    // --- TRANSLATOR STRING BIASA KE SINTAKS LATEX ---
    private String formatToLatex(String raw) {
        if (raw.isEmpty() || raw.equals("0")) {
            return "0";
        }

        String formatted = raw;

        // Logika memotong pangkat agar kursor "|" ikut naik ke atas menemani nilai n
        if (formatted.contains("^")) {
            String[] parts = formatted.split("\\^");
            if (parts.length > 1) {
                // Contoh: "9^2 |" diubah jadi "9^{2 |}" (angka 2 & kursor ikut naik jadi pangkat)
                formatted = parts[0] + "^{" + parts[1] + "}";
            } else {
                // Contoh jika baru pencet "9^ |", otomatis diubah jadi "9^{ |}"
                formatted = parts[0] + "^{ |}";
            }
        }

        // Contoh penyesuaian simbol operator lainnya jika dibutuhkan nanti
        formatted = formatted.replace("X", "\\times ");
        formatted = formatted.replace("/", "\\div ");

        return formatted;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new KalkulatorLatexApp().setVisible(true);
        });
    }
}
