package cn.evilcoder.encryption;

/**
 *
 */
public class AESExceptions {

    public static class EncryptServiceException extends Exception {
        public EncryptServiceException(Exception ex) {
            super("Encryption procedure exception", ex);
        }
    }

    public static class DecryptServiceException extends Exception {
        public DecryptServiceException(Exception ex) {
            super("Decryption procedure exception", ex);
        }
    }

    public static class CipherTypeNotExistException extends Exception {
        public CipherTypeNotExistException() {
            super("Cipher type does not exist");
        }
    }
}
