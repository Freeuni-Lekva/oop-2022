import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Sequence<File> findFilesIn(File current) {
        Sequence<File> children = new ArraySequence<>(
                current.listFiles());
        Sequence<File> descendants = Sequence.flatten(children
                .filter(File::isDirectory)
                .map(Main::findFilesIn));
        Sequence<File> currentDirFiles = children.filter(File::isFile);
        ListSequence<Sequence<File>> all = new ListSequence<>();
        all.add(descendants);
        all.add(currentDirFiles);
        return Sequence.flatten(all);
    }

    private static Filter<File> createFilterByExtension(String ext) {
        return elem -> elem.getName().endsWith(ext);
    }

    private static Sequence<String> readLines(File f) {
        ListSequence<String> lines = new ListSequence<>();
        try {
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                lines.add(s.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Sequence<String> getWords(String line) {
        return new ArraySequence<>(line.split(" "));
    }

    public static void main(String[] args) {
        File curr = new File("/Users/lekva/teach/freeuni/oop/oop-2022");
        Sequence<File> all = findFilesIn(curr);
        all = all.filter(createFilterByExtension(".java"));
        Sequence<String> words = Sequence.flatten(all.map(Mapper.chain(
                f -> readLines(f),
                lines -> Sequence.flatten(lines.map(l -> getWords(l))))));
//        Sequence<String> lines = Sequence.flatten(all.map(f -> readLines(f)));
//        Sequence<String> words = Sequence.flatten(lines.map(l -> getWords(l)));
        for (String w : words) {
            System.out.println(w);
        }
//        Integer[] numbers = {1, 2, 3, 4, 5};
//        Sequence<Integer> s = new ArraySequence<>(numbers);
//        Integer sum = s.map(new Mapper<Integer, Integer>() {
//            @Override
//            public Integer map(Integer elem) {
//                return elem * elem;
//            }
//        })
//                .filter(x -> x % 2 == 0)
//                .reduce((cur, elem) -> cur + elem, 0);
//        System.out.println(sum);
    }
}
