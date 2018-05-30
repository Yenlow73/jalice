package principal;

import Jalice.lexer.*;
import Jalice.node.*;

public class ComentarioAninhado extends Lexer{
	
	//pilha 
	private int pilha;
	private boolean comentarioLinha;
	
	
	// Definimos o construtor
	public ComentarioAninhado(java.io.PushbackReader in)
	{ 
		super(in);
		pilha = 0;
		comentarioLinha = false;
	}
	//retorna valor da pilha.
	public int getPilha(){
		return pilha;
	}
	
	//implementa os efeitos do comentário de bloco. comentários aninhados, espera-se que a pilha esteja zerada.
	private void comentarioBloco() throws LexerException{
		
		//chegando ao final do arquivo e não encontrado o TFechacomentario. encerro.
		if(super.token instanceof EOF && pilha >= 1){
			System.out.print("Erro de comentario de bloco. ");
			System.out.print("Linha: " + (super.token.getLine()) + ", posição:" + (super.token.getPos()) + ".");
			System.exit(1); 
		}
		//primeira abertura de comentário, crio o token TComentarioBloco
		if ((super.token instanceof TAbrecomentario) && pilha == 0 ){
			pilha += 1;
		}	
	
		//da segunda abertura em diante
		else if ((super.token instanceof TAbrecomentario))
			pilha += 1;
	
		//ao encontrar um fecha comentário
		if (super.token instanceof TFechacomentario){	
			pilha -= 1;
			//o último fechaComentário é trocado por comentário bloco.
			if(pilha == 0)
				super.token = new TComentarioBloco(super.token.getLine(),super.token.getPos());
		}	
		
		//se há comentário de bloco, os tokens são descartados, começando de /*.
		if(pilha >= 1)
			super.token = null;
			
		//exceção se * sem /* antes dele.	
		if(pilha < 0){
			System.out.print("Erro de comentario de bloco. ");
			System.out.print("Linha: " + (super.token.getLine()) + ", posição:" + (super.token.getPos()) + ". : ");
			System.out.print("TComentarioBlocoFimErrado");
			System.exit(1);
		}	
	}
	
	//implementa o comentario de linha.
	private void comentarioLinha()throws LexerException{
	
		//o que vem depois de // é descartado.	
		if ((comentarioLinha ==  true) && !(super.token instanceof TNovaLinha))
			super.token = null;
	
	
		//se houver fora de um comentário de bloco um // 
		if(super.token instanceof TComentarioLinha)
			comentarioLinha = true;
			
		//se chegar ao fim da linha, acaba o comentário.	
		if((super.token instanceof TNovaLinha) && (comentarioLinha == true))
			comentarioLinha = false;
	
	}
	
	// Definimos um filtro que reconhece comentarios aninhados
	@Override
	protected void filter() throws LexerException{ 
	
		comentarioLinha();	
		comentarioBloco();
	
	}
}