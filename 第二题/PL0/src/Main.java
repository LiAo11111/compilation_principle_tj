//import antlr.PL0.CalculatorVisitorImpl;
import antlr.PL0.Quadruple;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import PL0.PL0Parser;
import PL0.PL0Lexer;
import antlr.PL0.PL0VisitorImpl;
import PL0.PL0BaseVisitor;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        PL0Lexer lexer = new PL0Lexer(CharStreams.fromString(
                "PROGRAM add\n" +
                        "VAR x,y;\n" +
                        "BEGIN\n" +
                        "    x:=1;\n" +
                        "    y:=2;\n" +
                        "    WHILE x<5 DO x:=x+1;\n" +
                        "    IF y>0 THEN y:=y-1;\n" +
                        "    y:=y+x\n" +
                        "END"));
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

        System.out.println("parser has executed");

    }
}