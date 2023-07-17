package com.example.restservices; 

public class WordService{

	public ModelWords checkWord(String firstWord, String secondWord) {

		String result="";
		int firstLength= firstWord.length();
		int secondLength= secondWord.length();
		firstWord=firstWord.toLowerCase();
        secondWord=secondWord.toLowerCase();
		int[][] arrCount = new int[firstLength + 1][secondLength + 1];	
		for (int i = 0; i <= firstLength; i++) {
		  for (int j = 0; j <= secondLength; j++) {
			if (i == 0 || j == 0)
			arrCount[i][j] = 0;
			else if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1))
			arrCount[i][j] = arrCount[i - 1][j - 1] + 1;
			else
			arrCount[i][j] = Math.max(arrCount[i - 1][j], arrCount[i][j - 1]);
		  }
		}	
		int index = arrCount[firstLength][secondLength];
		int temp = index;
	
		char[] commonWords = new char[index + 1];
		commonWords[index] = '\0';
	
		int i = firstLength, j = secondLength;
		while (i > 0 && j > 0) {
		  if (firstWord.charAt(i - 1) == secondWord.charAt(j - 1)) {
			commonWords[index - 1] = firstWord.charAt(i - 1);
	
			i--;
			j--;
			index--;
		  }
	
		  else if (arrCount[i - 1][j] > arrCount[i][j - 1])
			i--;
		  else
			j--;
		}
		System.out.print("First Word : " + firstWord + "\nSecond Word : " + secondWord + "\nCommonWords: ");
		for (int k = 0; k <= temp; k++){
			System.out.print(commonWords[k]);
			result+=commonWords[k];
			System.out.println("");
		}
		return new ModelWords(result,String.valueOf(result.length()-1));
	  }
}