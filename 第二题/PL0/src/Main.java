//import antlr.PL0.CalculatorVisitorImpl;
import antlr.PL0.Quadruple;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import antlr.PL0.PL0Parser;
import antlr.PL0.PL0Lexer;
import antlr.PL0.PL0VisitorImpl;
import antlr.PL0.PL0BaseVisitor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "F:\\VS文件\\编译原理第一题\\编译原理第一题\\input4.txt";
        String content = Files.readString(Paths.get(filePath));
        PL0Lexer lexer = new PL0Lexer(CharStreams.fromString(content));

        PL0Parser parser = new PL0Parser((new CommonTokenStream(lexer)));
//        parser.start();
        parser.setBuildParseTree(true);
        PL0Parser.StartContext tree = parser.start();
        PL0VisitorImpl<Void> visitor = new PL0VisitorImpl<>();
        visitor.visit(tree);

        List<Quadruple> quadruples = visitor.getQuadruples();
        int i = 100;
        // Print or process the quadruples as needed
        for (Quadruple quad : quadruples) {
            System.out.println(i+"  ("+quad.toString()+")");
            i++;
        }
        System.out.println(i);
        System.out.println("parser has executed");

    }
}