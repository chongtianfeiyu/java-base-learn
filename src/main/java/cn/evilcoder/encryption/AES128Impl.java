package cn.evilcoder.encryption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.GeneralSecurityException;

import static cn.evilcoder.utils.HexStringUtils.bytesToHexString;
import static cn.evilcoder.utils.HexStringUtils.hexStringToBytes;

/**
 * 用AES 128位加密算法进行加密，用SK的前16位作为密钥,
 * 加密后生成的二进制字节流转成十六进制
 */
public class AES128Impl {

    private static final Logger logger = LoggerFactory.getLogger(AES128Impl.class);

    public static String encrypt(String content, String privateKey) throws AESExceptions.EncryptServiceException {
        byte[] crypted = null;

        try {
            SecretKeySpec skey = new SecretKeySpec(privateKey.substring(0, 16).getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skey);
            crypted = cipher.doFinal(content.getBytes());
        } catch (GeneralSecurityException e) {
            logger.error("Encryption procedure exception", e);
            throw new AESExceptions.EncryptServiceException(e);
        }
        return new String(bytesToHexString(crypted));
    }

    public static String decrypt(String cypherText, String privateKey) throws AESExceptions.DecryptServiceException {
        byte[] output = null;

        try {
            SecretKeySpec skey = new SecretKeySpec(privateKey.substring(0, 16).getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skey);
            output = cipher.doFinal(hexStringToBytes(cypherText));
        } catch (GeneralSecurityException e) {
            logger.error("Decryption procedure need not NULL secretKey", e);
            throw new AESExceptions.DecryptServiceException(e);
        }
        return new String(output);
    }
}
