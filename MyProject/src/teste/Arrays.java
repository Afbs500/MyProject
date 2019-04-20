package teste;

public class Arrays {
	
	
	public static void main(String[] args) {
		//declaração de Arrays
		
		int num[] = new int[10]; //armazenar ate 10 itens
		//armazenar 1
		num[0]=1;
		num[1]=2;
		num[2]=3;
		num[3]=4;
		
		//imprimir valor na tela
		System.out.println(num[2]);
		
		System.out.println("---------------------");
		//armazenar valores 2
		//ao criar é necessario armazenar o valor
		int num2[] = {1,2,3,4,5,6,7,8,9};
		
		//imprimir valor na tela
		System.out.println(num2[6]);
		System.out.println("---------------------");
		//declaração de arrays
		int []num3 = new int [10];
		//armazenar valores 3
		for (int i = 0; i < num3.length; i++) {
			num[i] = i+1;
		}
		//imprimir
		for (int i = 0; i < 10; i++) {
			System.out.println(num[i]);
		}
	}
	
	
	
	

}
