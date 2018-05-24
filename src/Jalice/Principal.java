/* Create an AST, then invoke our interpreter. */ 
//import Jalice.parser.* ;
package Jalice;
import Jalice.lexer.* ; 
import Jalice.node.* ; 
  
import java.io.* ;

  
public class Principal { 
   public static void main(String[] args) { 
      if (args.length > 0) { 
         try { 
            /* Form our AST */ 
            Lexer lexer = new Lexer (new PushbackReader( new FileReader(args[0]), 1024)); 
          //  Parser parser = new Parser(lexer); 
          //  Start ast = parser.parse() ; 
            Token token;
			while(!((token = lexer.next()) instanceof EOF))
				System.out.println(token.getClass()); 
  
            /* Get our Interpreter going. */ 
            //Interpreter interp = new Interpreter () ; 
          //  ast.apply(interp) ; 
         } 
         catch (Exception e) { 
            System.out.println (e) ; 
         } 
      } else { 
         System.err.println("usage: java simpleAdder inputFile"); 
         System.exit(1); 
      } 
   } 
}