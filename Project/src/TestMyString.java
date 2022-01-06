public class TestMyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyString brett = new MyString("Brett D Hails");
		MyString brian = new MyString("Brian L Thomas");
		MyString adam  = new MyString("Adam K. Peters");
		MyString adam2 = new MyString("Adam K. Petersen");
		MyString copy = new MyString("Brett D Hails");
		char[] arr = {'d', 'c','f','d'};
		MyString arrayString = new MyString(arr);
		System.out.println("oops " + "Adam K. Peters".compareTo("Adam K. Petersen"));
		System.out.println(brett);
		System.out.println( arrayString);
		System.out.println( "length of arr is " + arrayString.length());  // should be 4
		System.out.println( brian.charAt(6));// should be L
		System.out.println( brett.charAt(9)); // should be a
		System.out.println( brett.charAt(0)); // should be B
		System.out.println( brett.charAt(12)); // should be s
		System.out.println( arrayString.concat(brett)); // should be dcfdBrett D Hails
		System.out.println( brett.equals(brian)); // should be false
		System.out.println(brett.equals(copy));  // should be true
		System.out.println(adam.indexOf('K')); // should be 5
		System.out.println( brian .indexOf('a', 5));  // should be 12
		System.out.println( brett.replace('t',  '#')); // should print Bre## D Hails
		System.out.println( brett.toUpperCase());
		System.out.println( brian.toLowerCase());
		System.out.println( brett.substring(8)); // should print Hails
		System.out.println( brett.substring(2, 9)); // should print ett D H
		System.out.println( brett.compareTo(brian)); // should be -4
		System.out.println(adam.compareTo(brett)); // should be -1
		System.out.println( copy.compareTo(brett)); // should be 0
		System.out.println(adam2.compareTo(adam));

	}

}