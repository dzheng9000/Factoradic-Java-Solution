package permute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.math.BigInteger;

/**
 *
 * @author Dave Zheng
 */
public class Permuter 
{
    public static final long ONE = 1; //constant 1
    public static final long ZERO = 0; //constant 0
    private String input;
    private char [] inp;
    private long rank;
    private ArrayList<FactoradicDigit> factoradic;
    
    /**
     * Constructor for permuter
     * @param str an input value
     */
    public Permuter(String str)
    {
        factoradic = new ArrayList<>();
        input = str.toUpperCase();
        inp = input.toCharArray();
		rank = ZERO;
    }
    
    /**
     * Finds alphabetical order of the word and prints it to the console.
     */
    public void findPlace()
    {
		this.calcFactoradic();
        long place = factoradic.size() - 1; //specific digit the loop points to
        long order = ZERO; //alphabetical order of all possible permutations
        long denominator = ONE; // accounts for repeats
        Collection c ;
        Iterator <Map.Entry<Character,SpecialInt>> itr; 
        for(int i = 0; i<factoradic.size(); i++)
        {
            c = factoradic.get(i).getAlphabet().entrySet(); //initialize collection for factoradic digit being compared
            itr  = c.iterator(); //iterator for TreeMap
            while(itr.hasNext())
            {
                Map.Entry<Character, SpecialInt> entry =  itr.next();
                if(entry.getValue()!=null)
                {
                    denominator = denominator * ifactorial(entry.getValue().getInt());
                }
            }
            order = order + ifactorial(place)/denominator *  (factoradic.get(i).getValue()) ;
            if(order < 0)
            {
            	System.out.println("Place digit is " + place);
            	System.out.println("Factorial at " + i + " is " + ifactorial(place));
            	System.out.println("Negative sequence begins at index " + i + " and is " + order);
            }
            place--;
            denominator = ONE; //denominator reset to 1 for multiplication
        }
        order++;
        rank = order;
    }
	/**
     * @return rank, the alphabetical ordering of the provided word.
     */
	public long getRank()
	{
		return rank;
	}
    
	/**
	 *Returns factoradic representation of word.
	*/
    public ArrayList<Long> getFactoradic()
    {
    	ArrayList<Long> temp = new ArrayList<Long>();
    	for(int i = 0; i<factoradic.size(); i++)
    	{
    		temp.add(factoradic.get(i).getValue());
    	}
    	return temp;
    }
    
    /**
     * Calculates factoradic representation of specified word and stores it into an ArrayList.
     */
    private void calcFactoradic()
    {
        char first;
        long factBase;

        FactoradicDigit digit;
        for(int i = 0; i<inp.length; i++)
        {
            digit = new FactoradicDigit(); //generates new digit 
            first = inp[i];
            digit.incrementRepeatCount(first);
            factBase = 0; 
            for(int j = i+1; j <inp.length; j++ )
            {
                if(first > inp[j]) //if this letter hasn't been compared to the first letter yet
                {
                    factBase++;
                    digit.incrementRepeatCount(inp[j]);
                }
                if(first == inp[j])
                {
                    digit.incrementRepeatCount(first);
                }
            }
            digit.setValue(factBase);
            factoradic.add(digit);
        }
    }
    /**
     *
     * @param n integer n
     * @return iterative calculated factorial
     */
    public long ifactorial(long n)
    {
        long temp = n;
        if(n == 0)
        {
            return ONE;
        }
        for(long i = n-1; i>=0 ; i--)
        {
            if(i == 0)
            {
                temp = temp * ONE;
                break;
            }
            temp = temp * (i);
        }
        return temp;
    }

}