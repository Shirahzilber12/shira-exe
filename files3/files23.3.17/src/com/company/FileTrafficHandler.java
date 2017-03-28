package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/23/2017.
 */
public class FileTrafficHandler
{
    OutputStream outputStream = null;
    InputStream inputStream = null;

    public FileTrafficHandler(OutputStream outputStream, InputStream inputStream)
    {
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public void readFromFileWriteToAnother(int encryption)
    {
        try {
            readBytesUntilUserEndInput(encryption);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            handleEndOfTraffic();
        }
    }

    private void handleEndOfTraffic() {
        if (inputStream != null)
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if (outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void readBytesUntilUserEndInput(int decryptionType) throws IOException {
        int oneByte;
        while ((oneByte = inputStream.read()) != -1)
        {
            oneByte = getOneByteByType(oneByte, decryptionType);
            outputStream.write(oneByte);
        }
    }

    private int getOneByteByType(int oneByte, int decryption) {
        if (AlgorithmOperation.decryption == decryption)
            oneByte = operationDecryption(oneByte, 1);
        else
            oneByte = operationEncryption(oneByte, 1);
        return oneByte;
    }

    public int operationEncryption(int oneByte, int key) {
        return oneByte;
    }

    public int operationDecryption(int oneByte, int key) {
        return oneByte;
    }

}
