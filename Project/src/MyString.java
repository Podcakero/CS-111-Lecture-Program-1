public class MyString
{
	/**
	 * The char array representing the characters of our MyString
	 */
	private char[] text;

	/**
	 * The decimal unicode number where UpperICase characters begin
	 */
	private final int UPPERCASE_START = 65;
	/**
	 * The decimal unicode number where LowerCase characters begin
	 */
	private final int LOWERCASE_START = 97;
	/**
	 * The decimal unicode number where UpperCase characters end
	 */
	private final int UPPERCASE_END = 90;
	/**
	 * The decimal unicode number where LowerCase characters end
	 */
	private final int LOWERCASE_END = 122;
	/**
	 * The difference between uppercase unicode values and their equivalent lowercase unicode values
	 */
	private final int UPPER_TO_LOWER_DIFFERENCE = LOWERCASE_END - UPPERCASE_END;
	/**
	 * The difference between lowercase unicode values and their equivalent uppercase unicode values
	 */
	private final int LOWER_TO_UPPER_DIFFERENCE = UPPERCASE_END - LOWERCASE_END;

	/**
	 * Creates a new MyString object from a given char array
	 * @param original The char array to construct this new MyString from
	 */
	public MyString(char[] original)
	{
		text = new char[original.length];

		for (int i = 0; i < text.length; i++)
			text[i] = original[i];
	}

	/**
	 * Creates a new MyString object from a given String object
	 * @param original The String to construct this new MyString from
	 */
	public MyString(String original)
	{
		text = new char[original.length()];

		for (int i = 0; i < text.length; i++)
			text[i] = original.charAt(i);
	}

	/**
	 * Creates a new MyString object from a given MyString object
	 * @param original The MyString to construct this new MyString from
	 */
	public MyString (MyString original)
	{
		text = new char[original.length()];

		for (int i = 0; i < text.length; i++)
			text[i] = original.charAt(i);
	}

	/**
	 * Returns the length of the MyString object
	 * @return The length as an int
	 */
	public int length()
	{
		return this.text.length;
	}

	/**
	 * The character in the current MyString at the give index
	 * @param index The index to grab the character from
	 * @return The character at the given index
	 */
	public char charAt(int index)
	{
		return this.text[index];
	}

	/**
	 * Concatenates the given MyString to the end of the current MyString
	 * @param other The MyString to add to the end
	 * @return The two MyStrings concatenated together
	 */
	public MyString concat(MyString other)
	{
		//Grab the lengths of the first and second MyStrings
		int firstStringSize = this.text.length;
		int secondStringSize = other.length();

		//Create a new char array whose # of elements is equal to the # of elements of the 2 Mystrings added together.
		char[] finalString = new char[firstStringSize + secondStringSize];

		//Run through the char array and add the elements of the first MyString
		for (int i = 0; i < firstStringSize; i++)
			finalString[i] = this.charAt(i);

		//Starting at the index = first MyString's last index + 1, add the second MyString's elements
		for (int j = firstStringSize; j < finalString.length; j++)
			finalString[j] = other.charAt(j - firstStringSize);

		return new MyString(finalString);
	}

	/**
	 * Determines if the current MyString is equal to the given MyString
	 * @param other The string to check is equal
	 * @return True if the strings are equal. False if not
	 */
	public boolean equals(MyString other)
	{
		//Run through the current MyString and compare each character. if at any point they differ, return false.
		for (int i = 0; i < this.length(); i++)
			if (this.charAt(i) != other.charAt(i))
				return false;
		//Since we never returned false, it must be true`
		return true;
	}

	/**
	 * Returns the index of the first occurrence of the given char. If the character is not found, -1 will be returned
	 * @param ch The character to look for
	 * @return The index of the first occurrence of the char in the MyString, -1 if the char does not exist
	 */
	public int indexOf(char ch)
	{
		//Run through the array. Returning the index of the first occurrence of ch
		for (int i = 0; i < this.length(); i++)
			if (this.charAt(i) == ch)
				return i;
		//If the char isn't found, return -1
		return -1;
	}

	/**
	 * Returns the index of the first occurrence of the given char starting from a specific index. If the character is not found, -1 will be returned
	 * @param ch The character to look for
	 * @param fromIndex The index to begin looking from
	 * @return The index of the first occurrence of the char in the MyString, -1 if the char does not exist
	 */
	public int indexOf(char ch, int fromIndex)
	{
		//Run through the array starting at the fromIndex. Returning the index of the first occurrence of ch
		for (int i = fromIndex; i < this.length(); i++)
			if (this.charAt(i) == ch)
				return i;
		//If the char isn't found, return -1
		return -1;
	}

	/**
	 * Replaces every instance of 'target' with 'replacement'
	 * @param target The target character
	 * @param replacement The replacement character
	 * @return The MyString with all targets replaced with replacement
	 */
	public MyString replace(char target, char replacement)
	{
		//Create a new array of the same length
		char[] newString = new char[this.length()];

		//run through the array
		for (int i = 0; i < newString.length; i++)
		{
			//If the character at the current index is the target, replace it
			if (this.charAt(i) == target)
				newString[i] = replacement;
			//Else add it to the char array
			else
				newString[i] = this.charAt(i);
		}

		return new MyString(newString);
	}

	/**
	 * Creates a MyString slice beginning at beginIndex and going to the end of the MyString
	 * @param beginIndex The index to being the substring at
	 * @return A MyString object equal to the characters starting at beginIndex and running to the end of the MyString
	 */
	public MyString substring(int beginIndex)
	{
		return substring(beginIndex, this.length());
	}

	/**
	 * Creates a MyString slice beginning at beginIndex and ending at endIndex
	 * @param beginIndex The index to begin the substring at
	 * @param endIndex The index to end that substring at
	 * @return The MyString object equal to the characters between beginIndex and endIndex of the current MyString
	 */
	public MyString substring(int beginIndex, int endIndex)
	{
		//Create a new char that is the size of the "slice"
		char[] newString = new char[endIndex - beginIndex];

		//Run through the newString values and add the values of the old MyString beginning at beginIndex
		for (int i = 0; i < newString.length; i++)
			newString[i] = this.charAt(i + beginIndex);

		return new MyString(newString);
	}

	/**
	 * Converts the current MyString object to all uppercase characters
	 * @return MyString An ALL uppercase version of the current MyString
	 */
	public MyString toUpperCase()
	{
		//Create a new array that is the same size as our current MyString
		char[] newString = new char[this.length()];

		for (int i = 0; i < this.length(); i++)
		{
			//If our character is lowercase
			if ((int) this.charAt(i) >= LOWERCASE_START && (int) this.charAt(i) <= LOWERCASE_END)
				//Take the unicode value in decimal and add the difference between the lower and upper case unicode values. Then convert that to a char value
				newString[i] = (char)((int) this.charAt(i) + LOWER_TO_UPPER_DIFFERENCE);
			else
				//If we don't need to convert anything, than just add it to our array
				newString[i] = this.charAt(i);
		}

		return new MyString(newString);
	}

	/**
	 * Converts the current MyString object to all lowercase characters
	 * @return MyString An All lowercase version of the current MyString
	 */
	public MyString toLowerCase()
	{
		//Create a new array that is the same size as our current MyString
		char[] newString = new char[this.length()];

		//Run through our MyString
		for (int i = 0; i < this.length(); i++)
		{
			//If our character is lowercase
			if ((int) this.charAt(i) >= UPPERCASE_START && (int) this.charAt(i) <= UPPERCASE_END)
				//Take the unicode value in decimal and add the difference between the lower and upper case unicode values. Then convert that to a char value
				newString[i] = (char)((int) this.charAt(i) + UPPER_TO_LOWER_DIFFERENCE);
			else
				//If we don't need to convert anything, than just add it to our array
				newString[i] = this.charAt(i);
		}

		return new MyString(newString);
	}

	/**
	 * Converts the MyString object to a String
	 * @return the MyString object as a String
	 */
	public String toString()
	{
		String output = "";

		//Add each character to the output string.
		for (char c : this.text)
			output += c;

		return output;
	}

	/**
	 * Compares two MyStrings lexicographically, returning the difference as either 0, a negative number, or a positive number
	 * @param other The MyString to compare to
	 * @return an integer representing the lexicographical difference in the 2 MyStrings
	 */
	public int compareTo(MyString other)
	{
		//If our length is smaller than the MyString we are comparing to, then we use this MyString's length as our max as to avoid an "out of bounds" error
		if (this.length() < other.length())
		{
			//Run through until we find a character that is different, and subtract their unicode differences.
			for (int i = 0; i < this.length(); i++)
				if (this.charAt(i) != other.charAt(i))
					return this.charAt(i) - other.charAt(i);
		}
		else
			//Run through until we find a character that is different, and subtract their unicode differences.
			for (int j = 0; j < other.length(); j++)
				if (this.charAt(j) != other.charAt(j))
					return this.charAt(j) - other.charAt(j);
		//If there are no differing characters, subtract the lengths of the two MyStrings.
		return this.length() - other.length();
	}
}
