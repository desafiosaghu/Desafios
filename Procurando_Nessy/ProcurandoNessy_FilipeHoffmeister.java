import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcurandoNessy_FilipeHoffmeister {
	public static void main(String[] args) {  
		final Scanner scanner = new Scanner(System.in);
		Integer numTestes;
		System.out.println("Digite o número de testes que serão executados: ");
		try {
			numTestes = scanner.nextInt();
			validarNumeroTestes(numTestes);
			for(int i = 0; i < numTestes; i++) {
				System.out.println("============================================================");
				System.out.println("Teste número " + (i+1));
				System.out.println("============================================================");
				System.out.println("Digite a quantidade de \"linhas\" possui a matriz do lago: ");
				Integer linhas = scanner.nextInt();
				System.out.println("Digite a quantidade de \"colunas\" possui a matriz do lago: ");
				Integer colunas = scanner.nextInt();
				
				validarTamanhoLago(linhas, colunas);
				Integer numSonares = ((linhas/3) * (colunas/3));
				System.out.println("Resultado: Você precisará no mínimo de " + numSonares + (numSonares > 1 ? " Sonares " : " Sonar "));  
			}  
		} catch (InputMismatchException e) {
			System.out.println("Este sistema só aceita números rapá! Não sabe brincar? Não desce pro Play!");
		} catch (NessyNegocioException e) {
			System.out.println(e.getMensagemErro());
		}
		scanner.close();  
	}  
	
	
	private static void validarTamanhoLago(Integer linhas, Integer colunas) throws NessyNegocioException {
		if (colunas < 3 || linhas < 3) {
			throw new NessyNegocioException("Este lago é muito pequeno, Nessy nunca poderia morar lá");
		}
	}
	private static void validarNumeroTestes(int numTestes) throws NessyNegocioException {
		if (numTestes < 1) {
			throw new NessyNegocioException("Não sabe brincar? Não desce pro Play! :)");
		}
	}
}  

class NessyNegocioException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5714599083116091427L;
	
	private String mensagemErro;
	
	public NessyNegocioException(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	
	public String getMensagemErro() {
		return mensagemErro;
	}
	
}