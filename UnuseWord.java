package tags;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 */
public class UnuseWord {

    private final List<String> stopWords;

    public UnuseWord() {
        this.stopWords = new ArrayList<>();
        this.readStopWords();
    }

    public boolean isUnuseWord(String word) {
        String pattern = "(\\.{1,})|([\\…\\s\\″\\•`~@!#$%\\^&*\\(\\)\\+=\\}\\{\\[\\]:;\"'\\|\\\\<,>\\.\\?/\\s\\-\\+=\\–\\—\\_\\‘\\’\\“\\”[a-zA-Z0-9_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]]){0,1}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(word);
        return m.matches();
    }

    private void readStopWords() {
        try {
            File currentDirFile = new File(".");
            String currentPathProject = currentDirFile.getAbsolutePath();
            String pathOfStopWords = currentPathProject.substring(0, currentPathProject.length() - 1) + "src/stopword";
            FileReader fr = new FileReader(pathOfStopWords);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                if (!this.stopWords.contains(line)) {
                    this.stopWords.add(line);
                }
            }
        } catch (Exception ex) {
            System.out.println("UnuseWord.java - readStopWords: " + ex.toString());
        }
    }

    public boolean isStopWords(String word) {

        if (this.stopWords.isEmpty()) {
            return false;
        }
        return this.stopWords.contains(word);
    }

}
