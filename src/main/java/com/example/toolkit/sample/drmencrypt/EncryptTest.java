package com.example.toolkit.sample.drmencrypt;

import cn.net.drm.edi.DrmEdiClient;
import cn.net.drm.edi.exception.DrmException;

import java.io.File;

/**
 * @author chenpenghui
 * @date 2021-1-21
 */
public class EncryptTest {
    public static void main(String[] args) {
        File file = new File("D:\\test.xlsx");

        try {
            // 判断是否加密
            boolean flag1 = DrmEdiClient.getInstance().isEncrypted(file);
            if (!flag1) {
                // 加密
                DrmEdiClient.getInstance().encryptAuthFile(file, 1, "super", 1);
            }

            // 判断是否加密
            boolean flag2 = DrmEdiClient.getInstance().isEncrypted(file);
            if (flag2) {
                // 解密
                DrmEdiClient.getInstance().decrypt(file);
            }

        } catch (DrmException e) {
            e.printStackTrace();
        }
    }
}
