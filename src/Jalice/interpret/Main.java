/* Create an AST, then invoke our interpreter. */ 
//import Jalice.parser.* ;
package Jalice.interpret;
import java.io.* ;

import Jalice.lexer.*;
import Jalice.node.*;


public class Main { 
	
	/*
	 * Varre o arquivo de entrada e obtém um token que representa o caractere (imprime em tela).
	*/
	static void imprimirToken(Lexer lexer)
	{
		//objeto token.
		Token token;
        String classeToken = null;
		try {
			while(!((token = lexer.next()) instanceof EOF))
			{
				classeToken = token.getClass().getSimpleName();
				switch(classeToken)
				{
					case "TEspaco":
						System.out.print(' '); 
						break;
					case "TTeclaTab":
						System.out.print('\t'); 
						break;
					case "TNovaLinha":
						System.out.print('\n'); 
						break;
					default:
						System.out.print(classeToken); 	
				}
			}
		} catch (Exception e) {
			String[] partes = e.toString().split(" ", 2);
			String parte = partes[1];
			System.out.print(parte); 
			imprimirToken(lexer);
		}			
	}
	  
	
   public static void main(String[] args) { 
      if (args.length > 0) { 
         try { 
            /* Form our AST */ 
            ComentarioAninhado lexer = new ComentarioAninhado (new PushbackReader( new FileReader(args[0]), 1024)); 
            //  Parser parser = new Parser(lexer); 
            //  Start ast = parser.parse() ; 
            imprimirToken(lexer);	 
            /* Get our Interpreter going. */ 
            //Interpreter interp = new Interpreter () ; 
            //  ast.apply(interp) ; 
         } 
         catch (Exception e) { 
            System.out.println (e); 
         } 
      } else { 
         System.err.println("usage: java simpleAdder inputFile"); 
         System.exit(1); 
      } 
   } 
}