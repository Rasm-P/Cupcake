/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Encryption;

import com.sun.corba.se.spi.transport.CorbaTransportManager;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.jcp.xml.dsig.internal.dom.ApacheData;

/**
 *
 * @author Rumle
 */
public class DataEncryption {
    
    private static final SecureRandom random = new SecureRandom();
     private static final int ITERATIONS = 65536;
  private static final int KEY_LENGTH = 512;
  private static final String ALGORITHM = "PBKDF2WithHmacSHA512";
    
    
    public static Optional<String> hashPassword(String password, String salt) {
        char[] chars = password.toCharArray();
        byte[] bytes = salt.getBytes();
        
        PBEKeySpec spec = new PBEKeySpec(chars, bytes, ITERATIONS, KEY_LENGTH);
        
        Arrays.fill(chars, Character.MIN_VALUE);
        
        try {
            SecretKeyFactory fac = SecretKeyFactory.getInstance(ALGORITHM);
            byte[] securePassword = fac.generateSecret(spec).getEncoded();
            return Optional.of(Base64.getEncoder().encodeToString(securePassword));        
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.err.println("Exception encountered in HashPassword");
            return Optional.empty();
        } finally {
            spec.clearPassword();
        }
    }
    
//    public Optional<String> generateSalt(final int length) {
//        
//        byte bytes[] = new byte[20];
//        random.nextBytes(bytes);
//        return bytes;
//    }
    
    
    
//    public static void main(String[] args) {
//        DataEncryption de = new DataEncryption();
//        System.out.println(de.generateSalt().toString());
//        
//    }
    
}
