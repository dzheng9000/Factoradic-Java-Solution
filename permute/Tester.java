/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package permute;
/**
 *
 * @author Dave Zheng
 */
public class Tester 
{
    public static void main(String[] args)
    {
        Permuter test = new Permuter(args[0]);
        test.findPlace();
		System.out.println(args[0] + " = " + test.getRank() );
    }
}
