package FileProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Scanner;

public class FileRunner {

    public static String directory = FileConfig.rootDirectory;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println();
            System.out.println("default root directory is - " + FileConfig.rootDirectory);
            System.out.println("current directory is - " + directory);
            System.out.println();
            System.out.println("Enter operation name:");
            System.out.println("1 - Create");
            System.out.println("2 - Delete");
            System.out.println("3 - Rename");
            System.out.println("4 - Copy");
            System.out.println("5 - Change. Changes current Directory");
            System.out.println("6 - Set. Sets Directory back to default");
            System.out.println("To leave the terminal - type 'Break' ");

            String operation = in.next();
            switch(operation){

                case "Create" -> createFile(in);
                case "Delete" -> deleteFile(in);
                case "Rename" -> renameFile(in);
                case "Copy" -> copyFile(in);
                case "Change" -> changeDir(in);
                case "Set" -> setDefaultDir(in);
                case "Break" -> System.out.println("Operations are finished");
                default -> System.out.println("Entered command is invalid or unknown. Enter the command again");

            }
            if(Objects.equals(operation, "Break")){
                break;
            }

        }
    }
    private static void copyFile(Scanner in){
        System.out.println("Enter directory you want to copy file from");
        String dirfrom = in.next();
        System.out.println("Enter file name you want to copy");
        String filename = in.next();
        File file1 = new File(dirfrom + filename);
        boolean isPresentFile = file1.exists();
        boolean isPresentDir = Files.isDirectory(Path.of(directory));
        if(isPresentDir && isPresentFile) {
            System.out.println("Enter directory you want to copy file to");
            String dir_to = in.next();
            FileCopy filecopy = new FileCopy(dir_to, filename, dirfrom);
            filecopy.execute();
        }
        else {
            System.out.println("Such file or directory does not exist. Please try again");
        }
    }

    private static void setDefaultDir(Scanner in){
        directory = FileConfig.rootDirectory;
        System.out.println("Directory is set to default - " + FileConfig.rootDirectory);
    }
    private static void changeDir(Scanner in){
        System.out.println("Enter New Directory. Example - 'Desktop/folder1/folder2/ ...'");
        directory = "src/" + in.next();
        boolean dirExist = Files.isDirectory(Path.of(directory));
        if (!dirExist) {
            try {
                Files.createDirectory(Path.of(directory));
                System.out.println("Redirection is success");
            } catch (IOException e) {
                System.out.println("Something went wrong. Try again");
            }
        }
    }

    private static void createFile(Scanner in) {
        System.out.println("Enter file name you want to create");
        String newFileName = in.next();
        Filecreate filecreate = new Filecreate(newFileName, directory);
        filecreate.execute();

    }

    private static void deleteFile(Scanner in){
        System.out.println("Enter file name you want to delete");
        String fileNameDel = in.next();
        FileDelete fileDelete = new FileDelete(fileNameDel, directory);
        fileDelete.execute();

    }

    private static void renameFile(Scanner in){
        System.out.println("Enter file name you want to rename");
        String fileRenameFrom = in.next();
        System.out.println("Enter new file name");
        String fileRenameTo = in.next();
        FileRename fileRename = new FileRename(fileRenameFrom, fileRenameTo, directory);
        fileRename.execute();
    }

}
