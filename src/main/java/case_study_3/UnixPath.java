package case_study_3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UnixPath {
    public static void main(String[] args) {
        Path path = Paths.get("home/../var/./lib/../folder1/./folder2//file.txt");

        System.out.println("full path: " + path);
        System.out.println("path normalize (short path): " + path.normalize());
    }
}