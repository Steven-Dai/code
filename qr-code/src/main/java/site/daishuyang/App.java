package site.daishuyang;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            createQRcode("www.baidu.com", 350, 350);
        } catch (IOException | WriterException e) {
            e.printStackTrace();
        }
    }

    public static void createQRcode(String text, int width, int height) throws IOException, WriterException {
        String filePath = "./QrCodeDemo.png";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
