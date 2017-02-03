package exercise2;

public class Lotto {

	private int[] lottoNumbers = new int[3];
	
	
	public Lotto(int number1, int number2, int number3){
		
		this.lottoNumbers[0] = number1;
		this.lottoNumbers[1] = number2;
		this.lottoNumbers[2] = number3;
	}
	
	public int[] getArray(){
		
		
		return this.lottoNumbers;
	}
	
	public int sum(){
		
		return (this.lottoNumbers[0]+this.lottoNumbers[1]+this.lottoNumbers[2]);
		
	}
	
}
