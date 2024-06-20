package org.joychou.cmd;

import org.joychou.util.WebUtils;

import java.io.IOException;

public class testRun {
    public static void main(String[] args) throws IOException {
        String filepath = "/tmp; open /System/Applications/Calculator.app";
        String[] cmdList = new String[]{"sh", "-c", "ls -la " + filepath};
        //String[] cmdList = new String[]{"cmd.exe", "-c", "dir " + filepath};
        ProcessBuilder builder = new ProcessBuilder(cmdList);
        builder.redirectErrorStream(true);
        Process process = builder.start();
        String result = WebUtils.convertStreamToString(process.getInputStream());
        System.out.println(result);
    }

}
