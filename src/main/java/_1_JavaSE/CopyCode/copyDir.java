package _1_JavaSE.CopyCode;

import java.io.File;

public class copyDir {
    public static void main(String[] args) {
        File src = new File("/Users/hbx1998/Downloads");
        File dest = new File("/Users/hbx1998/Desktop");
        copy_dir(src, dest);

    }

    private static void copy_dir(File src, File dest) {
        if (src.isFile()) {
            System.out.println(src.getName() + " is a file");
            copyFile.copy_file(src.getAbsolutePath(), dest.getAbsolutePath() + "/" + src.getName());
        }
        else {
            System.out.println(src.getName() + " is a dir");
            File newdir = new File(dest.getAbsolutePath() + "/" + src.getName());
            System.out.println(newdir.mkdir());
            File[] children = src.listFiles();
            if (children != null) {
                for(File f : children) {
                    copy_dir(f.getAbsoluteFile(), newdir);
                }
            }
        }
    }
}
