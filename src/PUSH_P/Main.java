package PUSH_P;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        final String extractPath = "F://Games//";
        StringBuilder builder = new StringBuilder();

        File dir1 = new File(extractPath + "src");
        dirCr(dir1, builder, extractPath);

        File dir2 = new File(extractPath + "res");
        dirCr(dir2, builder, extractPath);

        File dir3 = new File(extractPath + "savegames");
        dirCr(dir3, builder, extractPath);

        File dir4 = new File(extractPath + "temp");
        dirCr(dir4, builder, extractPath);

        File dir5 = new File(extractPath + "src//main");
        dirCr(dir5, builder, extractPath + "src//");

        File dir6 = new File(extractPath + "src//test");
        dirCr(dir6, builder, extractPath + "src//");

        File dir7 = new File(extractPath + "res//drawables");
        dirCr(dir7, builder, extractPath + "res//");

        File dir8 = new File(extractPath + "res//vectors");
        dirCr(dir8, builder, extractPath + "res//");

        File dir9 = new File(extractPath + "res//icons");
        dirCr(dir9, builder, extractPath + "res//");

        File file1 = new File(extractPath + "src//main//Main.java");
        fileCr(file1, builder, extractPath + "src//main//");

        File file2 = new File(extractPath + "src//main//Utils.java");
        fileCr(file2, builder, extractPath + "src//main//");

        File file3 = new File(extractPath + "temp//temp.txt");
        fileCr(file3, builder, extractPath + "temp//");

        String resString = builder.toString();

        try (FileWriter writer = new FileWriter(extractPath+"temp//temp.txt", false)) {

            writer.write(resString);
            writer.append("Cоздание файлов окончено");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static void dirCr(File dir, StringBuilder builder, String path) {
        if (dir.mkdir()) builder.append("Создан каталог " + path + dir.getName() + "\n");
        else
            builder.append("Ошибка при создании каталога " + path + dir.getName() + "\n");
    }

    public static void fileCr(File file, StringBuilder builder, String path) {
        try {
            if (file.createNewFile())
                builder.append("Создан файл " + path + file.getName() + "\n");
            else builder.append("Ошибка при создании файла " + path + file.getName() + "\n");

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
