package cn.leo.bookkeeping.user.common.util;


import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Objects;

/**
 * 加解密的工具集
 * 
 * @author leo.zl on 2020/6/4
 */
public class EncryptUtils {
    public static final String MD5 = "MD5";
    public static final String SHA1 = "SHA1";
    public static final String HmacMD5 = "HmacMD5";
    public static final String HmacSHA1 = "HmacSHA1";
    public static final String DES = "DES";
    public static final String AES = "AES";

    /**
     * 编码格式；默认使用uft-8
     */
    public String charset = "utf-8";
    /**
     * DES
     */
    public int keySizeDes = 0;
    /**
     * AES
     */
    public int keySizeAes = 128;

    public static EncryptUtils encryptUtils;

    private EncryptUtils() {
    }

    public static EncryptUtils getInstance() {
        if (encryptUtils == null) {
            synchronized (EncryptUtils.class) {
                if (encryptUtils == null) {
                    encryptUtils = new EncryptUtils();
                }
            }
        }
        return encryptUtils;
    }

    /**
     * 使用MessageDigest进行单向加密（无密码）
     *
     * @param encryptContent       被加密的文本
     * @param algorithm 加密算法名称
     * @return 加密后的密文
     */
    private String messageDigest(String encryptContent, String algorithm) {
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] encryptContentBytes = charset == null ? encryptContent.getBytes() : encryptContent.getBytes(charset);
            return base64(md.digest(encryptContentBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用KeyGenerator进行单向/双向加密（可设密码）
     *
     * @param encryptContent       被加密的原文
     * @param algorithm 加密使用的算法名称
     * @param key       加密使用的秘钥
     * @return 加密后的密文
     */
    private String keyGeneratorMac(String encryptContent, String algorithm, String key) {
        try {
            SecretKey sk = null;
            if (key == null) {
                KeyGenerator kg = KeyGenerator.getInstance(algorithm);
                sk = kg.generateKey();
            } else {
                byte[] keyBytes = charset == null ? key.getBytes() : key.getBytes(charset);
                sk = new SecretKeySpec(keyBytes, algorithm);
            }
            Mac mac = Mac.getInstance(algorithm);
            mac.init(sk);
            byte[] encryptContentByte = mac.doFinal(encryptContent.getBytes());
            return base64(encryptContentByte);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用KeyGenerator双向加密，DES/AES，注意这里转化为字符串的时候是将2进制转为16进制格式的字符串，不是直接转，因为会出错
     *
     * @param encryptContent       加密的原文
     * @param algorithm 加密使用的算法名称
     * @param key       加密的秘钥
     * @param keySize 密码长度
     * @param isEncode
     * @return
     */
    private String keyGeneratorES(String encryptContent, String algorithm, String key, int keySize, boolean isEncode) {
        try {
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            if (keySize == 0) {
                byte[] keyBytes = charset == null ? key.getBytes() : key.getBytes(charset);
                kg.init(new SecureRandom(keyBytes));
            } else if (key == null) {
                kg.init(keySize);
            } else {
                byte[] keyBytes = charset == null ? key.getBytes() : key.getBytes(charset);
                kg.init(keySize, new SecureRandom(keyBytes));
            }
            SecretKey sk = kg.generateKey();
            SecretKeySpec sks = new SecretKeySpec(sk.getEncoded(), algorithm);
            Cipher cipher = Cipher.getInstance(algorithm);
            if (isEncode) {
                cipher.init(Cipher.ENCRYPT_MODE, sks);
                byte[] encryptContentBytes = charset == null ? encryptContent.getBytes() : encryptContent.getBytes(charset);
                return parseByte2HexStr(cipher.doFinal(encryptContentBytes));
            } else {
                cipher.init(Cipher.DECRYPT_MODE, sks);
                return new String(cipher.doFinal(Objects.requireNonNull(parseHexStr2Byte(encryptContent))));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String base64(byte[] encryptContent) {
        return Base64.encode(encryptContent);
    }

    /**
     * 将二进制转换成16进制
     */
    public static String parseByte2HexStr(byte[] buf) {
        StringBuilder sb = new StringBuilder();
        for (byte b : buf) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1){
            return null;
        }
        byte[] encryptContentult = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            encryptContentult[i] = (byte) (high * 16 + low);
        }
        return encryptContentult;
    }

    /**
     * md5加密算法进行加密（不可逆）
     *
     * @param encryptContent 需要加密的原文
     * @return 加密后的密文
     */
    public String MD5(String encryptContent) {
        return messageDigest(encryptContent, MD5);
    }

    /**
     * md5加密算法进行加密（不可逆）
     *
     * @param encryptContent 需要加密的原文
     * @param key 秘钥
     * @return 加密后的密文
     */
    public String MD5(String encryptContent, String key) {
        return keyGeneratorMac(encryptContent, HmacMD5, key);
    }

    /**
     * 使用SHA1加密算法进行加密（不可逆）
     *
     * @param encryptContent 需要加密的原文
     * @return 加密后的密文
     */
    public String SHA1(String encryptContent) {
        return messageDigest(encryptContent, SHA1);
    }

    /**
     * 使用SHA1加密算法进行加密（不可逆）
     *
     * @param encryptContent 需要加密的原文
     * @param key 秘钥
     * @return
     */
    public String SHA1(String encryptContent, String key) {
        return keyGeneratorMac(encryptContent, HmacSHA1, key);
    }

    /**
     * 使用DES加密算法进行加密（可逆）
     *
     * @param encryptContent 需要加密的原文
     * @param key 秘钥
     * @return 加密后的密文
     */
    public String DESEncode(String encryptContent, String key) {
        return keyGeneratorES(encryptContent, DES, key, keySizeDes, true);
    }

    /**
     * 对使用DES加密算法的密文进行解密（可逆）
     *
     * @param encryptContent 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String DESDecode(String encryptContent, String key) {
        return keyGeneratorES(encryptContent, DES, key, keySizeDes, false);
    }

    /**
     * 使用AES加密算法经行加密（可逆）
     *
     * @param encryptContent 需要加密的密文
     * @param key 秘钥
     * @return 加密后的密文
     */
    public String AESEncode(String encryptContent, String key) {
        return keyGeneratorES(encryptContent, AES, key, keySizeAes, true);
    }

    /**
     * 对使用AES加密算法的密文进行解密
     *
     * @param encryptContent 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String AESDecode(String encryptContent, String key) {
        return keyGeneratorES(encryptContent, AES, key, keySizeAes, false);
    }

    /**
     * 使用异或进行加密
     *
     * @param encryptContent 需要加密的密文
     * @param key 秘钥
     * @return 加密后的密文
     */
    public String XOREncode(String encryptContent, String key) {
        byte[] bs = encryptContent.getBytes();
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return parseByte2HexStr(bs);
    }

    /**
     * 使用异或进行解密
     *
     * @param encryptContent 需要解密的密文
     * @param key 秘钥
     * @return
     */
    public String XORDecode(String encryptContent, String key) {
        byte[] bs = parseHexStr2Byte(encryptContent);
        for (int i = 0; i < bs.length; i++) {
            bs[i] = (byte) ((bs[i]) ^ key.hashCode());
        }
        return new String(bs);
    }

    /**
     * 直接使用异或（第一调用加密，第二次调用解密）
     *
     * @param encryptContent 密文
     * @param key 秘钥
     * @return 加密后的密文
     */
    public int XOR(int encryptContent, String key) {
        return encryptContent ^ key.hashCode();
    }

    /**
     * 使用Base64进行加密
     *
     * @param encryptContent 密文
     * @return 加密后的密文
     */
    public String Base64Encode(String encryptContent) {
        return Base64.encode(encryptContent.getBytes());
    }

    /**
     * 使用Base64进行解密
     *
     * @param encryptContent
     * @return
     */
    public String Base64Decode(String encryptContent) throws Base64DecodingException {
        return new String(Base64.decode(encryptContent));
    }
}
