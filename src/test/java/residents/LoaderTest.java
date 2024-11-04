package residents;

import org.junit.jupiter.api.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LoaderTest {

    @Test
    void testFileLoaderOk1() throws Exception {
        String file="src/test/resources/ok1.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("4\n");
        fw.write("25 1\n");
        fw.write("70 1\n");
        fw.write("100 0\n");
        fw.write("3 1\n");
        fw.close();
        List<Resident>expected=List.of(new Resident(25,1), new Resident(70,1), new Resident(100, 0),new Resident(3, 1));
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderOk2() throws Exception {
        String file="src/test/resources/ok2.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write("25 0\n");
        fw.write("25 1\n");
        fw.close();
        List<Resident>expected=List.of(new Resident(25,0), new Resident(25,1));
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderOk3() throws Exception {
        String file="src/test/resources/ok_empty.txt";
        FileWriter fw=new FileWriter(file);
        fw.close();
        List<Resident>expected=new ArrayList<>();
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderOk4() throws Exception {
        String file="src/test/resources/ok4.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("3\n");
        fw.write("25 0\n");
        fw.write("25 1\n");
        fw.write("\n");
        fw.write("56 1\n");
        fw.close();
        List<Resident>expected=List.of(new Resident(25,0), new Resident(25,1), new Resident(56,1));
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderOk5() throws Exception {
        String file="src/test/resources/ok4.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write(" 25 0\n");
        fw.write("25   1\n");
        fw.write("45 0 \n");
        fw.write("  56   1  \n");
        fw.close();
        List<Resident>expected=List.of(new Resident(25,0), new Resident(25,1), new Resident(45,0), new Resident(56,1));
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderOk6() throws Exception {
        String file="src/test/resources/ok2.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("1\n");
        fw.write("25 0\n");
        fw.close();
        List<Resident>expected=List.of(new Resident(25,0));
        Assertions.assertIterableEquals(expected, Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderNok1() {
        Assertions.assertThrows(FileNotFoundException.class, ()-> Loader.fileLoader("src/test/resources/__.txt"));
    }

    @Test
    void testFileLoaderNok2() throws IOException {
        String file="src/test/resources/nok2.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write("250\n");
        fw.write("251\n");
        fw.close();
        Assertions.assertThrows(WrongAgeException.class, ()->Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderNok3() throws IOException {
        String file="src/test/resources/nok3.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write("25 0\n");
        fw.write("1badtest\n");
        fw.close();
        Assertions.assertThrows(InputMismatchException.class, ()->Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderNok4() throws IOException {
        String file="src/test/resources/nok4.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write("-25 0\n");
        fw.write("10 1\n");
        fw.close();
        Assertions.assertThrows(WrongAgeException.class, ()->Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }

    @Test
    void testFileLoaderNok5() throws IOException {
        String file="src/test/resources/nok5.txt";
        FileWriter fw=new FileWriter(file);
        fw.write("2\n");
        fw.write("25 2\n");
        fw.write("10 1\n");
        fw.close();
        Assertions.assertThrows(WrongSexException.class, ()->Loader.fileLoader(file));
        Files.delete(Path.of(file));
    }
}