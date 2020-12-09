package cn.leo.bookkeeping.user.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author create by leo.zl on 2020/11/18
 */
public class DesUtils {

    public static void main(String[] args) throws Exception {
        String key = "cmbtest1";

        String info = "u9su4Mi92g8b2l1GjBEllZQBpjFxRbKYY4MNjgS7qyS4GajzsQbyHPC6Xon2lc+gPjF3kjQalI2WNWw3UpY6M3RU4B6GFEC6IWf6KxYtcF4D9BJ6SrnW+LG1ncaArA8yJaAnlF42uMP4pHnWfJcIwBlobdjBJtCM/jgyvqSDq8EbGuUbEzfTBdWNGul6Zfr4MfvQFNE/KcsETGb6HrXayCR+ZD7aQ6dfk4wdd47Lpw14apcdMK8S3YaoOWN5NTgFgvqN8CyoZWJWFtZvntMozOWfKcgSIC5iTnVQsDYtnyvoPXvLMQRK2RngCMfHNyj8KHmtqLvapwCimVrD34/vV3n4WmQ4d+yPpMthMwg9NH6dxuC92tmfmeSNnfB3Ru3sZyo5PlxCrAyEaP7V2nnMg+JC9KuBf43TcrvQFAMJ9/YzjnYQLw4uVH58q0ebCcCY5Wvoda74aMRM+uWYY8RTFclmCyyyCEcttY1XzDS+zOCDu6rhjiDswDXno+YWbgU3G2skHRoMMxjOGmCUS1u6rrHp+6ERZa/YiRH77PFcilAsIbINkmBKgm8r/qe3m81nO8u2U6pEHp4=";

        final BASE64Decoder base64Decoder = new BASE64Decoder();
        final byte[] decrypt = decrypt(base64Decoder.decodeBuffer(info), key.getBytes(StandardCharsets.UTF_8));

        System.out.println(new String(decrypt));
    }

    static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
    }

    /**
     * 密钥算法 <br>
     * Java 6 只支持56bit密钥 <br>
     * Bouncy Castle 支持64bit密钥
     */
    public static final String KEY_ALGORITHM = "DES";

    /**
     * 加密/解密算法 / 工作模式 / 填充方式
     */
    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    /**
     * 转换密钥
     *
     * @param key 二进制密钥
     * @return Key 密钥
     * @throws Exception
     */
    private static Key toKey(byte[] key) throws Exception {

        // 实例化DES密钥材料
        DESKeySpec dks = new DESKeySpec(key);

        // 实例化秘密密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory
                .getInstance(KEY_ALGORITHM);

        // 生成秘密密钥
        SecretKey secretKey = keyFactory.generateSecret(dks);

        return secretKey;
    }

    /**
     * 解密
     *
     * @param data 待解密数据
     * @param key  密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {

        // 还原密钥
        Key k = toKey(key);

        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);

        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 加密
     *
     * @param data 待加密数据
     * @param key  密钥
     * @return byte[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {

        // 还原密钥
        Key k = toKey(key);

        // 实例化
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);

        // 初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE, k);

        // 执行操作
        return cipher.doFinal(data);
    }

    /**
     * 生成密钥 <br>
     * Java 6 只支持56bit密钥 <br>
     * Bouncy Castle 支持64bit密钥 <br>
     *
     * @return byte[] 二进制密钥
     * @throws Exception
     */
    public static byte[] initKey() throws Exception {

        // 实例化密钥生成器
        // 若要使用64bit密钥注意替换 将下述代码中的KeyGenerator.getInstance(CIPHER_ALGORITHM);
        // 替换为KeyGenerator.getInstance(CIPHER_ALGORITHM, "BC");
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);

        // 初始化密钥生成器 若要使用64bit密钥注意替换 将下述代码kg.init(56); 替换为kg.init(64);
        kg.init(56, new SecureRandom());

        // 生成秘密密钥
        SecretKey secretKey = kg.generateKey();

        // 获得密钥的二进制编码形式
        return secretKey.getEncoded();
    }

    public static byte[] initKey(String seed) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom(new Base64().decode(seed));
        kg.init(secureRandom);
        SecretKey secretKey = kg.generateKey();
        return secretKey.getEncoded();
    }

}
