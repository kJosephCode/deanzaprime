public class Test {

	public static void main (String [] args)
	{
		
		
		
	}
	
	/*
	 * Algorithm IsArrayPrimeIter (array, n)
	 * 		
	 * 		This algorithm checks if an array contains all prime numbers or not. 
	 * 		Pre : array - an array of integers
	 * 			  n - the true size of array
	 * 		Post:
	 * 		Return: true or false
	 * 
	 * 		i=0
	 * 		loop (i < size)		
	 * 			if(array[i] <= 3)
	 * 				return !(array[i] equals 1)
	 * 			end if
	 * 			if (array[i] % 2 equals 0)
	 * 				return false
	 * 			end if
	 * 			int j=3
	 * 			loop(j <= sqrt(array[i]))
	 * 				
	 * 				if(array[i]% j equals 0)
	 * 					return false;
	 * 				end if
	 * 				j+=2
	 * 			end loop
	 * 		i++
	 * 		end loop
	 * 		return true
	 * 
	 * end IsArrayPrimeIter
	 */
	public static boolean IsArrayPrimeIter(int [] arr, int size)
	{
		
		for(int i =0; i<size; i++)  // iterate through each element in loop
		{
			if(arr[i]<=3) // if the number is 2 or 1 or 3, return true if number is 2 or 3, and false if number is 1.
			{
				return !(arr[i]==1);
			}
			
			if( arr[i] % 2 == 0) // if number is divisible by 2, that means the number is not prime and thus we return false. else we only have to check if arr[i] is divisible by odd numbers.
			{
				return false;
			}
			for(int j=3; j<=(Math.sqrt(arr[i])+1); j+=2) // since we only enter this loop if arr[i] is not divisble by 2, we can iterate through odd numbers.
      // we only have to go up to the sqrt of arr[i], since if a number is prime, atleast one divisor will be less than sqrt(arr[i]).
			{
				if(arr[i]%j == 0) // check if number is divisible by using modulo
				{
					return false; 
				}
			}
		}
		return true; // if the for loops all exit without any returns, return true.
	}
	
	/*
	 * Algorithm IsArrayPrimeRecur (array, n)
	 * 		
	 * 		This algorithm checks recursively if an array contains all prime numbers or not. 
	 * 		Pre : array - an array of integers
	 * 			  n - the true size of array
	 * 		Post:
	 * 		Return: true or false
	 * 
	 * 		if(n equals 0)
	 * 			return true
	 * 		end if
	 * 		if(array[n-1] is not prime) // helper method to check if value in array is prime
	 * 			return false
	 * 		end if
	 * 		return isArrayPrimeRecur (array, n-1)
	 * 		
	 * end IsArrayPrimeRecur
	 */
	public static boolean IsArrayPrimeRecur(int[] arr, int size)
	{
		
		if(size == 0) // if the size is 0, that means we found that all numbers are prime. (i.e: this is base case)
		{
			return true;
		}
		
		if(!isPrimeRecur(arr[size-1], 3)) // check if number is a prime number, by using helper method PrimeRecur. (divisor starts at 3 so we can optmize our code.)
		{
			return false;
		}
		
		return IsArrayPrimeRecur(arr, size-1); // recursively call our method again, with size -1, so that we can get the next value in the array.
		
		
	}
	
	/*
	 * Algorithm IsPrimeRecur (number, divisor)
	 * 		
	 * 		This algorithm checks recursively if a number is prime or not. 
	 * 		Pre : number - integer to be checked
	 * 		 	  divisor - integer to check if is factor of number
	 * 		Post:
	 * 		Return: true or false
	 * 
	 * 		if(number <=3)
	 * 			return !(number equals 1)
	 * 		end if
	 * 		if((number % divisor equals 0) or (number % 2 equals 0))
	 * 			return false;
	 * 		end if
	 * 		if(divisor> sqrt(number))
	 * 			return true;
	 * 		end if
	 * 		return isPrimeRecur(num, divisor + 2)
	 * 
	 * end IsPrimeRecur
	 */
	private static boolean isPrimeRecur (int num, int divisor)
	{
		
		if(num<=3) // if the number is 2 or 1 or 3, return true if number is 2 or 3, and false if number is 1.
		{
			return !(num==1);
		}
		
		if(num%divisor == 0 || num%2 == 0 ) // check is number is divisible by divisor or 2. If number is divisible by 2, we return false. if it isn't we only have check
    // if the value is divisble by odd numbers. 
		{
			return false;
		}
		
		if(divisor > Math.sqrt(num)+1) // if number the divisor is incremented to the point it is greater than Math.sqrt(num) that means the number is a prime number. so we return true.
		{
			return true;
		}
		
		return isPrimeRecur(num, divisor +2); // recursively call our method, with the divisor +2, since we only reach this step if the number is not divisble by 2, which means
    // we only have to check if number is divisble by odd numbers.
	}
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Tester {
    public static void main(String[] args) throws IOException
    {
        int sortMaxSize = 16;
        BufferedReader br = new  BufferedReader(new InputStreamReader(System.in)); // in order to read the entire line
        System.out.println("Enter up to " + sortMaxSize + " elements with values between 1 and 9999 with one space between numbers: ");
        int[] inputNums = new int[sortMaxSize];
        String[] strArr;
        strArr = br.readLine().split(" ");
        // read user input till end of line
        int count = strArr.length;
        if (count > sortMaxSize) {
            count = sortMaxSize;
        }
        for (int i=0; i<count; i++)
        {
            inputNums[i] = Integer.parseInt(strArr[i]);
        }
        // print array for debug
        for (int i=0; i<count; i++) {
            System.out.print(inputNums[i] + " ");
        }
        System.out.println();

        // test1
        
        if (IsArrayPrimeIter(inputNums, count)) {
            System.out.println("Array is prime");
        } else {
            System.out.println("Array is not prime");
        }

        // test2
        if (IsArrayPrimeRecur(inputNums, count)) {
            System.out.println("Array is prime");
        } else {
            System.out.println("Array is not prime");
        }
    }

    public static boolean IsArrayPrimeIter(int[] arr, int size)
    {
        System.out.println("Entering IsArrayPrimeIter");
        for (int i = 0; i < size; i++)
        {
            if (arr[i] == 1)
            {
                System.out.println("Leaving IsArrayPrimeIter");
                return false; // 1 is not a prime number
            }
            if (arr[i] % 2 == 0)
            {
                System.out.println("Leaving IsArrayPrimeIter");
                return false;
            }

            for (int j = 3; j <= Math.sqrt(arr[i])+1; j+=2)
            {
                if (arr[i] % j == 0)
                {
                    System.out.println("Leaving IsArrayPrimeIter");
                    return false;
                }
            }
        }
        System.out.println("Leaving IsArrayPrimeIter");
        return true;
    }

    public static boolean IsArrayPrimeRecur(int[] arr, int size)
    {
        System.out.println("Entering IsArrayPrimeRecur");
        if (size == 0)
        {
            System.out.println("Leaving IsArrayPrimeRecur");
            return true;
        }
        if (!IsPrimeRecur(arr[size-1], 3)) // check if the last element in the array is prime
        {
            System.out.println("Leaving IsArrayPrimeRecur");
            return false;
        }
        System.out.println("Leaving IsArrayPrimeRecur");
        return IsArrayPrimeRecur(arr, size-1);
    }

    public static boolean IsPrimeRecur(int checkNum, int divisorNum)
    {
        System.out.println("Entering IsPrimeRecur");
        if (checkNum == 1)
        {
            System.out.println("Leaving IsPrimeRecur");
            return false;
        }
        if (divisorNum > Math.sqrt(checkNum) + 1)
        {
            System.out.println("Leaving IsPrimeRecur");
            return true;
        }
        if (checkNum % 2 == 0 || checkNum % divisorNum ==0)
        {
            System.out.println("Leaving IsPrimeRecur");
            return false;
        }
        System.out.println("Leaving IsPrimeRecur");
        return IsPrimeRecur(checkNum, divisorNum+2);
    }
}


