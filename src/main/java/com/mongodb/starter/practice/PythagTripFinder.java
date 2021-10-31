package com.mongodb.starter.practice;

import java.util.List;

public interface PythagTripFinder {
    /**
     * Given a limit number C, find all primitive Pythagorean triples below that
     * limit. For definitions of the terms, refer to
     * https://www.mathsisfun.com/numbers/pythagorean-triples.html#:~:text=A%20Pythagorean%20Triple%20can%20never,number%20is%20an%20even%20number.
     * https://en.wikipedia.org/wiki/Pythagorean_triple. If (3 , 4, 5) is an answer,
     * (6, 8, 10) should be excluded. Euclid's formula may be handy for this
     * purpose. -- https://www.geeksforgeeks.org/check-two-numbers-co-prime-not/ --
     * http://www.blackwasp.co.uk/Coprime.aspx
     * 
     * @param cLimit The upper limit of C, such that the three sides meet the
     *               condition A < B < C < cLimit
     * @return
     */
    List<PythagTriple> getTriples(int cLimit);
}
