package exercise2;

public class Lotto {

	//Array
	private int[] lottoNumbers = new int[3];
	
	//Constructor receiving random numbers
	public Lotto(int number1, int number2, int number3){
		
		this.lottoNumbers[0] = number1;
		this.lottoNumbers[1] = number2;
		this.lottoNumbers[2] = number3;
	}
	
	//Method that returns the array
	public int[] getArray(){
		
		
		return this.lottoNumbers;
	}
	
	public int sum(){
		
		return (this.lottoNumbers[0]+this.lottoNumbers[1]+this.lottoNumbers[2]);
		
	}
	
}
