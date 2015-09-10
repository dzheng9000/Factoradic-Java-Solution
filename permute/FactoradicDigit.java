package permute;
import java.util.TreeMap;
/**
 *
 * @author Dave Zheng
 */
public class FactoradicDigit 
{
    private long value;
    private TreeMap<Character, SpecialInt> alphabet;
    /**
     * Constructor for FactoradicDigit. Adds a full TreeMap/dictionary of the alphabet.
     * Keys are letters of the alphabet linked to a SpecialInt, which contains the permutations
     * of the repeated letters.
     */
    public FactoradicDigit()
    {
        alphabet = new TreeMap();
        alphabet.put('a', null);
        alphabet.put('b', null);
        alphabet.put('c', null);
        alphabet.put('d', null);
        alphabet.put('e', null);
        alphabet.put('f', null);
        alphabet.put('g', null);
        alphabet.put('h', null);
        alphabet.put('i', null);
        alphabet.put('j', null);
        alphabet.put('k', null);
        alphabet.put('l', null);
        alphabet.put('m', null);
        alphabet.put('n', null);
        alphabet.put('o', null);
        alphabet.put('p', null);
        alphabet.put('q', null);
        alphabet.put('r', null);
        alphabet.put('s', null);
        alphabet.put('t', null);
        alphabet.put('u', null);
        alphabet.put('v', null);
        alphabet.put('w', null);
        alphabet.put('x', null);
        alphabet.put('y', null);
        alphabet.put('z', null);
    }
    /**
     * Increments the value of a found letter.
     */
    public void increment()
    {
        value++;
    }
    /**
     *
     * @return the value of a certain letter.
     */
    public long getValue()
    {
        return value;
    }
    /**
     *
     * @param num the input.
     * Sets the value of this factoradic digit.
     */
    public void setValue(long num)
    {
        value = num;
    }
    /**
     *
     * @return the TreeMap of the alphabet alongside the number of occurrences per letter
     */
    public TreeMap getAlphabet()
    {
        return alphabet;
    }
    /**
     *
     * @param someCharacter
     */
    public void incrementRepeatCount(char someCharacter)//shows which letters have been hit
    {
        if(alphabet.get(someCharacter) == null)
        {
            alphabet.put(someCharacter, new SpecialInt() );
        }
        else
        {
            SpecialInt temp = alphabet.get(someCharacter);
            temp.increment();
            alphabet.put(someCharacter, temp);
        }
    }
}
