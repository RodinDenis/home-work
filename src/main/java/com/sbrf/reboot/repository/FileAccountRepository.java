package com.sbrf.reboot.repository;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileAccountRepository  implements AccountRepository {

    String filePath = null;

    public FileAccountRepository(String filePath) throws FileNotFoundException{
        File file = new File(filePath);
        if(file.exists()){
            this.filePath = filePath;
        }
        else{
            throw new FileNotFoundException("There is no file with specified directory.");
        }
    }

    public FileAccountRepository() {
    }

    @Override
    public Set<Long> getAllAccountsByClientId(long clientId) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(this.filePath);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }

        Reader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        }
        BufferedReader inputStreamBufferedReader = new BufferedReader(inputStreamReader);

        int data = 0;
        try {
            data = inputStreamBufferedReader.read();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        String line = "";
        char[] letters;
        Set<Long> accounts = new HashSet();
        String tempIdString = "";
        String tempNumberString = "";
        long tempId = 0L;
        long tempNumber = 0L;
        while(data != -1){
            char theChar = (char) data;
            if(theChar == '\r'){
                letters = line.toCharArray();
                if (line.contains("clientId")) {
                    // i < line.length() - 1 - для того, чтобы не читать запятую.
                    for (int i = line.lastIndexOf(' ') + 1; i < line.length() - 1; ++i) {
                        tempIdString += letters[i];
                    }
                    tempId = Long.valueOf(tempIdString);
                }
                if (line.contains("number") && tempId == clientId){
                    for (int i = line.lastIndexOf(' ') + 1; i < line.length(); ++i) {
                        tempNumberString += letters[i];
                    }
                    tempNumber = Long.valueOf(tempNumberString);
                    accounts.add(tempNumber);
                    System.out.println(tempId + " " + tempNumber);
                }
                tempIdString = "";
                tempNumberString = "";
                letters = null;
                line = "";
            }
            else{
                if (theChar != '\n') {
                    line += theChar;
                }
            }
            try {
                data = inputStreamBufferedReader.read();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        try {
            inputStreamBufferedReader.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return accounts;
    }

    @Override
    public void addAccountToClient(long clientId, long contractNumber) {

    }
}
