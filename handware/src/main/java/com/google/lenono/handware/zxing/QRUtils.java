package com.google.lenono.handware.zxing;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.FileOutputStream;
import java.security.spec.EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenono on 2016-07-19.
 */
public class QRUtils {
    public static boolean createQR(String content, int width, int height, String filePath, Bitmap logo) {
        boolean flg = false;
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        try {
            //使用二维码的写对象，根据生成的内容的宽和高，生成一个bit的矩阵（matrix）
            BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
            //创建数组保存所有的像素的点
            int pixles[] = new int[width * height];
            //得到每一个像素点的颜色
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    //从矩阵中获得x轴，从根据y的的变化  把每个像素点得到
                    if (bitMatrix.get(x, y)) {
                        pixles[y * width + x] = 0xff000000;
                    } else {
                        pixles[y * width + x] = 0xffffffff;
                    }
                }
            }
            //创建一个二维码的图片
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            //把二维码的像素画到图片上
            bitmap.setPixels(pixles, 0, width, 0, 0, width, height);
            //在二维码图片上添加logo
            if (logo != null) {
                bitmap = addLogo(bitmap, logo);
            }
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, new FileOutputStream(filePath));
            flg = true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return flg;
    }

    //给二维码加上logo
    public static Bitmap addLogo(Bitmap src, Bitmap logo) {
        Bitmap bitmap;
        if (src != null || logo != null) {
            int width = src.getWidth();
            int height = src.getHeight();
            int logoWidth = logo.getWidth();
            int logoHeight = logo.getHeight();
            //创建底板图片
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            //创建画板对象
            Canvas canvas = new Canvas(bitmap);
            canvas.drawBitmap(src, 0, 0, null);
            canvas.drawBitmap(logo, (width - logoWidth) / 2, (height - logoHeight) / 2, null);
            canvas.save(Canvas.ALL_SAVE_FLAG);
            canvas.restore();
            return bitmap;
        }
        return null;
    }
}


