package com.sumit.crypto;

import org.pgpainless.PGPainless;
import org.pgpainless.algorithm.CompressionAlgorithm;
import org.pgpainless.policy.Policy;
import org.pgpainless.sop.SOPImpl;
import sop.DecryptionResult;
import sop.Ready;
import sop.ReadyWithResult;
import sop.SOP;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CryptoUtility {

    static void setCompressionAlgorithm() {
        CompressionAlgorithm fallback = CompressionAlgorithm.ZIP;
        List<CompressionAlgorithm> algorithms = new ArrayList<>();
        //algorithms.add(CompressionAlgorithm.ZIP);
        algorithms.add(CompressionAlgorithm.ZLIB);
        Policy.CompressionAlgorithmPolicy cPolicy =
                new Policy.CompressionAlgorithmPolicy(fallback, algorithms);
        PGPainless.getPolicy()
                .setCompressionAlgorithmPolicy(cPolicy);
    }

    static void encryptFile() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the path to the file to encrypt
        System.out.print("Enter file path to encrypt: ");
        String filePath = scanner.nextLine();

        // Prompt the user for the password
        // Symmetric key used to encrypt
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Resolve the file path and create input and output streams
        Path inputFile = Paths.get(filePath);
        try (InputStream inputStream = Files.newInputStream(inputFile.toFile().toPath());
             OutputStream outputStream = Files.newOutputStream(Paths.get(inputFile + ".encrypted"))) {

            SOP sop = new SOPImpl();

            // Use PGPainless to encrypt the data
            Ready ready = sop.encrypt()
                    .withPassword(password)
                    .plaintext(inputStream);

            // Write the encrypted data to the output stream
            ready.writeTo(outputStream);
            System.out.println("File encrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void decryptFile() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the path to the file to decrypt
        System.out.print("Enter file path to decrypt: ");
        String filePath = scanner.nextLine();

        // Prompt the user for the password
        // Symmetric key used to encrypt
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Resolve the file path and create input and output streams
        Path inputFile = Paths.get(filePath);
        try (InputStream inputStream = Files.newInputStream(inputFile.toFile().toPath());

             OutputStream outputStream = Files.newOutputStream(Paths.get(inputFile + ".decrypted"))) {
            SOP sop = new SOPImpl();

            // Use PGPainless to decrypt the data
            ReadyWithResult<DecryptionResult> readyWithResult = sop.decrypt()
                    .withPassword(password)
                    .ciphertext(inputStream);

            // Write the decrypted data to the output stream
            readyWithResult.writeTo(outputStream);
            System.out.println("File decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
