package com.dboaz.utils.security;

import java.io.File;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dboaz.utils.enums.SystemCodeEnum;
import com.dboaz.utils.exceptions.GlobalException;
import com.dboaz.utils.models.CustomAlert;

public class RSAKeyGenerator {
    private static final Logger LOG = LoggerFactory.getLogger(RSAKeyGenerator.class);
    
    private static final Integer KEY_SIZE = 2048;
    private static final String FILE_PUBLIC = "/public.pub";
    private static final String FILE_PRIVATE = "/private.key";
    private static final String PATH = "base_core/src/main/resources";
    
    public static void main(String[] args) {
        var pair = generateKeyPairRSA();

        createFolderResourcesIfNotExist();
        generateFileWithPublicKey(pair.getPublic());
        generateFileWithPrivateKey(pair.getPrivate());

        LOG.debug("Generate key RSA in " + PATH);
    }

    private static KeyPair generateKeyPairRSA() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(KEY_SIZE);
            return keyPairGen.generateKeyPair(); 
        } catch (Exception e) {
            LOG.error(e.getMessage());
            var alert = new CustomAlert(SystemCodeEnum.C020DB);
            throw GlobalException.builder().alert(alert).status(500).build();
        }
    }

    private static void createFolderResourcesIfNotExist() {
        File dir = new File(PATH);
        if (!dir.exists()) { dir.mkdirs(); }
    }

    private static void generateFileWithPublicKey(PublicKey key) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(key.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(PATH + FILE_PUBLIC)) {
            fos.write(x509EncodedKeySpec.getEncoded());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            var alert = new CustomAlert(SystemCodeEnum.C020DB);
            throw GlobalException.builder().alert(alert).status(500).build();
        }
    }

    private static void generateFileWithPrivateKey(PrivateKey key) {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(key.getEncoded());
        try (FileOutputStream fos = new FileOutputStream(PATH + FILE_PRIVATE)) {
            fos.write(pkcs8EncodedKeySpec.getEncoded());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            var alert = new CustomAlert(SystemCodeEnum.C020DB);
            throw GlobalException.builder().alert(alert).status(500).build();
        }
    }
}
