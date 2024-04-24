package FileProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDelete implements FileOperation{
    public String filename;
    public String directory;

    public FileDelete(String filename, String directory) {
        this.filename = filename;
        this.directory = directory;
    }
    @Override
    public void execute() {
        Path path = Paths.get(directory, filename);
        try{
            Files.delete(path);
            System.out.println("File is deleted");
        }
        catch (IOException e){
            System.out.println("can not delete unexistent file");;
        }
    }
}
