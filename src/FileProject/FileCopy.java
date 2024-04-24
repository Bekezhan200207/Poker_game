package FileProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileCopy implements FileOperation{
    public String dir_to;
    public String filename;
    public String dir_from;
    public Integer counter = 0;

    public FileCopy(String dir_to, String filename, String dir_from) {
        this.dir_to = dir_to;
        this.filename = filename;
        this.dir_from = dir_from;
    }

    @Override
    public void execute() {
        Path path1 = Paths.get(dir_to, filename);
        Path path2 = Paths.get(dir_from, filename);
        while(true) {
            if (Files.exists(path1)) {
                counter+=1;
                String[] splitted = filename.split("\\.");
                String name = splitted[0];
                String ext = splitted[1];
                String filename1 = name + "_" + counter + "." + ext;
                path1 = Paths.get(dir_to, filename1);
                System.out.println("File is copied");

            }
            else{
                System.out.println("File does not exist");
                break;
            }
        }
        try{
            Files.copy(path2, path1);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
