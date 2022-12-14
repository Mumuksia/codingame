package ground;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FilesRenamer {

    public static void main(String args[]) {
        File directory = new File("d:/ama/skin/temp/");
        File[] files = directory.listFiles();

        Arrays.sort(files, Comparator.comparingLong(File::lastModified));
        int i = 48;
        for (File f : files){
            f.renameTo(new File("d:/ama/skin/temp/" + i + ".jpg"));
            i++;
        }
    }
}
