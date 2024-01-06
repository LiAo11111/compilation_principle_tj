//import antlr.PL0.CalculatorVisitorImpl;
import antlr.PL0.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\86188\\Desktop\\PL0\\PL0\\src\\PL0.txt";

        String content = Files.readString(Paths.get(filePath));
        PL0Lexer lexer = new PL0Lexer(CharStreams.fromString(content));

        PL0Parser parser = new PL0Parser((new CommonTokenStream(lexer)));
//        parser.start();
        parser.setBuildParseTree(true);
        PL0Parser.StartContext tree = parser.start();
        PL0VisitorImpl<Void> visitor = new PL0VisitorImpl<>();

        System.out.println("符号表：");
        visitor.visit(tree);
        List<Word> id_list = visitor.getWord();
        for (Word id : id_list) {
            System.out.println(id.toString());
        }

        List<Quadruple> quadruples = visitor.getQuadruples();
        int i = 100;
        // Print or process the quadruples as needed
        System.out.println("\n中间代码：");
        for (Quadruple quad : quadruples) {
            System.out.println(i+"  ("+quad.toString()+")");
            i++;
        }
        System.out.println(i);
        System.out.println("parser has executed");

    }
}