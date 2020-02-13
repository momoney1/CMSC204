package Assignment1;
import java.util.ArrayList;
/**
 * A utility class that contains methods that verify the validity of passwords
 * @author Moe Diakite
 *
 */
public class PasswordCheckerUtility {
	/**
	 * A no arg constructor 
	 */
	public PasswordCheckerUtility()  {
		
	}
	/**
	 * A method that accepts a password value, and checks it's valitdity
	 * @param passwordString
	 * @return true or false
	 */
	static boolean isValidPassword (String passwordString) throws LengthException,  NoUpperAlphaException, NoDigitException,
	NoLowerAlphaException, InvalidSequenceException{
		boolean capLetters = false; //boolean variable that gets initialized to true or false for capital letters found in a word
		boolean lowerLetters = false;//boolean variable that gets initialized to true or false for lower case letters found in a word
		int count = 0;
		if(passwordString.length() < 6) {
			throw new LengthException();
		}
		for(int i = 0; i < passwordString.length(); i++) {  //loops through to check for lowercase and uppercase requirements
			if(Character.isUpperCase(passwordString.charAt(i))) {
				capLetters = true;
			}
			if(Character.isLowerCase(passwordString.charAt(i))) {
				lowerLetters = true;
			}
		}
		if(capLetters == false) { //exception thrown if no capital letters found
			throw new NoUpperAlphaException();
		}
		
		if(lowerLetters == false) {//exception thrown if no lowercase letters found
			throw new NoLowerAlphaException();
		}
		if(!passwordString.matches(".*[1-9].*")) { //exception thrown if no digit is found
			throw new NoDigitException();
		}
		for(int i = 0; i < passwordString.length() - 2; i++) {// loops through each character in the string to verify validity
				if(passwordString.charAt(i) == passwordString.charAt(i + 1) && passwordString.charAt(i) == passwordString.charAt(i + 2)) {
					if(Character.isLowerCase(passwordString.charAt(i)) && Character.isLowerCase(passwordString.charAt(i + 1)) && 
							Character.isLowerCase(passwordString.charAt(i + 2))|| 
							Character.isUpperCase(passwordString.charAt(i)) && Character.isUpperCase(passwordString.charAt(i + 1)))
					throw new InvalidSequenceException();
				}
		}
		
		return true;
	}
	/**
	 * A method that determins whether or not a password is weak
	 * @param passwordString
	 * @return true or false
	 */
	static boolean isWeakPassword(String passwordString) {
		if(passwordString.length() >= 6 && passwordString.length() <= 9) {
			return true;
		}
		return false;
	}
	/**
	 * A method that accepts a list of passwords, and returns all the invalid ones
	 * @param passwords
	 * @return invalid passwords
	 */
	static ArrayList<String> invalidPasswords(ArrayList<String> passwords){
		ArrayList<String> invalid = new ArrayList<>();
		for(int i = 0; i < passwords.size(); i++) {  //loops through the passwords list
			try {
				isValidPassword(passwords.get(i)); //inside try statement due to potential for exception being thrown
			}
			catch(RuntimeException e) {  //one catch statement, containing else/if clauses to check for different exceptions
				if(e instanceof LengthException) {
					invalid.add(passwords.get(i) + " "+ e.getMessage());
				}
				else if(e instanceof NoUpperAlphaException) {
					invalid.add(passwords.get(i) + " "+ e.getMessage());
				}
				else if(e instanceof NoLowerAlphaException) {
					invalid.add(passwords.get(i) + " "+ e.getMessage());
				}
				else if(e instanceof NoDigitException) {
					invalid.add(passwords.get(i) + " "+ e.getMessage());
				}
				else if(e instanceof InvalidSequenceException) {
					invalid.add(passwords.get(i) + " "+ e.getMessage());
				}
			}
			
		}
		return invalid;
	}
}
