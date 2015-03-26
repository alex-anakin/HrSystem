package ua.anakin.hah.service;

public class Tools {
	
	//removing leading and trailing white space,
	//then converting first character to upper case and other
	//characters to lower case
	public static String standardize(String string){
		string = string.trim();
		return string.substring(0, 1).toUpperCase() + string.substring(1).toLowerCase();
	}

}
