package FileProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Filecreate implements FileOperation{

    public String filename;
    public String directory;
    public Integer counter = 0;

    public Filecreate(String filename, String directory) {
        this.filename = filename;
        this.directory = directory;
    }

    public void execute() {
        Path path = Paths.get(directory, filename);


        while(true) {
            if (Files.exists(path)) {
                counter+=1;
                String[] splitted = filename.split("\\.");
                String name = splitted[0];
                String ext = splitted[1];
                String filename1 = name + "_" + counter + "." + ext;
                path = Paths.get(directory, filename1);

            }
            else{
                break;
            }
        }



        try{
            Files.createFile(path);
            System.out.println("File is created");
        }
        catch (IOException e){
            System.out.println("Something went wrong. Try again");;
        }

    }
}
