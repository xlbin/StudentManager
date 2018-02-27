package com.bin.studentmanager.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xiaolang on 2018/2/27.
 */

public class ImageUtils {
    /***
     *  url转换成bitmap
     *
     * */
    public final static Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;

        try {
            myFileUrl = new URL(url);
            HttpURLConnection conn;

            conn = (HttpURLConnection) myFileUrl.openConnection();

            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bitmap;
    }

    /**
     *按比例缩放图片
     *
     * */
    public static Bitmap getScaledBitmap(Bitmap oldBmp, int newWidth) {
        int oldWidth = oldBmp.getWidth();
        int oldHeight = oldBmp.getHeight();
        float scale = (float) oldHeight / oldWidth;
        int newHeight = Math.round(newWidth * scale);
        Bitmap newBmp = Bitmap.createScaledBitmap(oldBmp, newWidth, newHeight, false);
        oldBmp.recycle();
        return newBmp;
    }

    /**
     * 压缩并保存图片到文件
     *
     * **/
    public static boolean saveBitmap(Bitmap bitmap, File file) {
        if (bitmap == null)
            return false;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
            fos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }
}
