## CryptoUtility
`CryptoUtility` is a Java class that provides methods for encrypting and decrypting files using PGP (Pretty Good Privacy) encryption. PGP is a widely used encryption standard that allows for secure communication and data storage.

## Dependencies
`CryptoUtility` requires the following external libraries:

`org.pgpainless`: A library for working with PGP encryption in Java.
Make sure to include these dependencies in your project's classpath.

## Usage
`CryptoUtility` provides three main methods:

1. `setCompressionAlgorithm()`
This method sets the compression algorithm policy to be used by PGPainless. It sets a fallback compression algorithm and a list of preferred compression algorithms. This method needs to be called before performing any encryption or decryption operations.

2. `encryptFile()`
This method prompts the user for a file path and a password, and then encrypts the file using PGP encryption. The encrypted file is written with the extension ".encrypted" in the same directory as the original file.

3. `decryptFile()`
This method prompts the user for a file path and a password, and then decrypts the file using PGP encryption. The decrypted file is written with the extension ".decrypted" in the same directory as the original encrypted file.

Note: It's important to provide the correct password for successful decryption.

## Example Usage

```
package com.sumit.crypto;

public class Main {

    public static void main(String[] args) {
        // Set the compression algorithm policy
        CryptoUtility.setCompressionAlgorithm();

        // Encrypt a file
        CryptoUtility.encryptFile();

        // Decrypt a file
        CryptoUtility.decryptFile();
    }
}

```

In the above example, the `setCompressionAlgorithm()` method is called to set the compression algorithm policy. Then the `encryptFile()` and `decryptFile()` methods are called to perform encryption and decryption operations respectively.

Please make sure to handle exceptions appropriately for real-world usage.

## License

MIT License

Copyright (c) 2023 Sumit Sahoo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
