package FileDataBase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountsFile {
    public AccountsFile() {

    }

    public void set(String key, String value) throws IOException {

        try {

            String content = key + ":" + value;
            java.io.File file = new java.io.File("Accounts.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);

            if (!file.exists()) {
                file.createNewFile();
            }

            bw.write(content);
            bw.newLine();
            bw.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean registerToFile(String key, String pass) throws IOException {
        boolean loged = true;
        Scanner scanner = new Scanner(new File("Accounts.txt"));
        String content = key + ":" + pass;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals(content)) {
                loged = true;
                break;
            } else {
                loged = false;

            }
        }
        return loged;
    }

    public boolean checkForAccounts(String key) throws IOException {
        boolean loged = true;
        Scanner scanner = new Scanner(new File("Accounts.txt"));
        String content = key;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            line = line.substring(0, line.indexOf(":"));
            if (line.equals(content)) {
                loged = true;
                break;
            } else {
                loged = false;
            }
        }
        return loged;
    }

}
