package ch11.ex11_1;

import java.util.Scanner;
import java.util.TreeSet;

public class DirectoryList {
    TreeSet<File> fileList;
    public record File( String dir, String fileName ) implements Comparable<File>{
        @Override
        public int compareTo(File o) {
            return this.dir.compareTo(o.dir);
        }
    }

    public DirectoryList() {
        this.fileList = new TreeSet<>(){};
    }

    private void makeFile(String dir){
        java.io.File directory = new java.io.File(dir);
        String[] files = directory.list();
        for(String file : files){
            java.io.File fileName = new java.io.File(dir,file);
            if (!fileName.isDirectory()) {
                fileList.add(new File(dir,file));
            }
            else {
                makeFile(dir+"/"+file);
            }
        }
    }

    //1. 디렉토리 내부의 파일, 디렉토리 목록을 불러와서
    //  if 디렉토리면 1로 다시 간다.
    //  else 파일이면 2로 간다.
    //2. 파일을 저장한다.

    public static void main(String[] args) {

        String directoryName;  // Directory name entered by the user.
        java.io.File directory;        // File object referring to the directory.

        Scanner scanner;       // For reading a line of input from the user.

        scanner = new Scanner(System.in);  // scanner reads from standard input.

        DirectoryList dl = new DirectoryList();

        System.out.print("Enter a directory name: ");
        directoryName = scanner.nextLine().trim();
        directory = new java.io.File(directoryName);

        if (!directory.isDirectory()) {
            if (!directory.exists())
                System.out.println("There is no such directory!");
            else
                System.out.println("That file is not a directory.");
        }
        else {
            dl.makeFile(directoryName);
        }

        dl.fileList.stream().forEach((x)->System.out.println(x.dir + "/"+x.fileName));

        scanner.close();
    } // end main()

} // end class DirectoryList