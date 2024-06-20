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

//    public static void main(String[] args) throws IOException {
//        String path = "ls-l; /System/Applications/Calculator.app";
//        String[] cmd = { "open", path };
//
//        Runtime.getRuntime().exec(cmd);
//    }

//    public static void main(String[] args) throws IOException, InterruptedException {
//        String path = "/System/Applications/Calculator.app/Contents/MacOS/";
//        String[] cmd1 = { "ls", "-l", path };
//
//        ProcessBuilder pb1 = new ProcessBuilder(cmd1);
//        Process process1 = pb1.start();
//        process1.waitFor();
//
//        String[] cmd2 = { "open", "/System/Applications/Calculator.app" };
//
//        ProcessBuilder pb2 = new ProcessBuilder(cmd2);
//        Process process2 = pb2.start();
//        process2.waitFor();
//    }
}
