import org.hamcrest.core.StringContains;



import java.util.Queue;
import java.util.Stack;


public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {

		/* IMPLEMENT THIS METHOD! */

		Stack<HtmlTag> stack = new Stack<>();

		//Debemos iterar por cada tag en la pila
		for (HtmlTag tag : tags) {

			//Aqui verificamos si el tag es unico (se cierra solo). En este caso
			//no hay que hacer nada
			if (tag.isSelfClosing()) {
				continue;}

			//Si el tag es de tipo abierto, se agrega a la pila
			else if (tag.isOpenTag()) {
				stack.push(tag);}

			//Si el tag es uno de cierre se debe verificar que el stack no este vacio
			else if (!tag.isOpenTag()) {

				//Se verifica que el primer tag del stack sea igual al tag de cierre
				if (!stack.isEmpty()) {
					if (stack.peek().matches(tag)) {
						stack.pop();
					}

					//Se retorna el stack si los tags no coinciden
					else {
						return stack;
					}
				}

				//Si el stack esta vacio, se retorna null
				else {
					return null;
				}
			}
		}
		return stack;
	}


}