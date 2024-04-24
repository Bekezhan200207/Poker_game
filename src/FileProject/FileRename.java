package FileProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRename implements FileOperation{
    public String filename_start;
    public String filename_end;
    public String directory;

    public FileRename(String filename_start, String filename_end, String directory) {
        this.filename_start = filename_start;
        this.filename_end = filename_end;
        this.directory = directory;
    }

    @Override
    public void execute() {
        File file1 = new File(directory + filename_start);
        File file2 = new File(directory + filename_end);
        boolean ispresent = file1.exists();
        try{
            if (ispresent) {
                file1.renameTo(file2);
                System.out.println("File is renamed");
            }
            else{
                System.out.println("there is no file with such name");
            }
        }
        catch (RuntimeException e){
            System.out.println("programm did not run succesfully");
        }
    }

}



