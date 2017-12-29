/*
 * Daniel Reyes / danielreyes61@gmail.com
 */


import javax.swing.*;
import java.io.*;
import java.util.Stack;

public class L8232DRey {

    public static void RecursiveFileSearch(File root) {
        if(root.listFiles()!=null){
            for (File file : root.listFiles()) {
                if (file.isDirectory()) {
                    RecursiveFileSearch(file);
                }
                String x = file.toString();
                x = x.substring(x.length()-3,x.length());
                if(x.equalsIgnoreCase("pdf")){
					System.out.println(file.toString());

                }
            }
        }
    }

    public static void NonRecursiveFileSearch(File root) {
      Stack<File> fileStack = new Stack();
    	fileStack.push(root);
    	while (!fileStack.empty()) {
            File top = fileStack.pop();
            if (top.listFiles() != null) {
                for (File inFile : top.listFiles()) {
                    if (inFile.isDirectory()) {
                        fileStack.push(inFile);
                    }
                    String x = inFile.toString();
                    x = x.substring(x.length() - 3, x.length());
                    if (x.equalsIgnoreCase("pdf")) {
                        System.out.println(inFile.toString());
                    }
                }
            }

        }
    }
    
    public static File chooseDirectory() {

        JFileChooser jfc = new JFileChooser();

        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int openOutcome = jfc.showOpenDialog(null);

        if (openOutcome != JFileChooser.APPROVE_OPTION) {

            System.exit(0);
        }

        return jfc.getSelectedFile();

    }

    public static void main(String[] args) {
        NonRecursiveFileSearch(chooseDirectory());
        System.out.println("");
		    RecursiveFileSearch(chooseDirectory());
		    System.out.println("");
    }
}
