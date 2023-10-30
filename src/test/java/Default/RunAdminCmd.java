package Default;

import java.io.IOException;

public class RunAdminCmd {
    public static void main(String[] args) {
        try {
            String command = "date 14-09-2023";
            String cmd = "cmd /C start runas /user:Administrator \"cmd /C date 14-09-2023\"";
            // String cmd = "cmd /C start runas /user:Administrator /"+command;
            Runtime.getRuntime().exec(cmd);


            //  System.out.println("Process exited with value: " + exitValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

