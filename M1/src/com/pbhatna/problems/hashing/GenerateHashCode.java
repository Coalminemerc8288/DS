package com.pbhatna.problems.hashing;

/**
 * Joshua Bloch in Effective Java provides good guidelines for generating an hashCode() value

 1. Store some constant nonzero value; say 17, in an int variable called result.
 2. For each significant field f in your object (each field taken into account by the equals( )), do the following

 a.  Compute an int hashCode c for the field:
     i.      If the field is a boolean, compute
     c = (f ? 1 : 0).
     ii.     If the field is a byte, char, short, or int, compute c = (int) f.
     iii.    If the field is a long, compute c = (int) (f ^ (f >>> 32)).
     iv.    If the field is a float, compute c = Float.floatToIntBits(f).
     v.     If the field is a double, compute
     long l = Double.doubleToLongBits(f),
     c = (int)(l ^ (l >>> 32))
     vi.    If the field is an object reference then equals( ) calls equals( ) for this field.                                             compute
     c =  f.hashCode()
     vii.   If the field is an array, treat it as if each element were a separate field.
     That is, compute a hashCode for each significant element by applying above rules to                                      each element

 b.  Combine the hashCode c computed in step 2.a into result as follows:
    result = 37 * result + c;

 3. Return result.
 4. Look at the resulting hashCode() and make sure that equal instances have equal hash codes.

 */
public class GenerateHashCode {

    private String field1;
    private short  field2;

    @Override
    public int hashCode() {
        int result = 17;
        result = 37*result + field1.hashCode();
        result = 37*result + (int)field2;
        return result;
    }
}
