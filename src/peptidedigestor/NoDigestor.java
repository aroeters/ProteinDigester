/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peptidedigestor;

import java.util.ArrayList;

/**
 *
 * @author arne
 */
public class NoDigestor implements Digestor {

    /**
     * contains the minimal length a peptide should have.
     */
    private final Integer minimalLength;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public NoDigestor(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // No Digestion
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        ArrayList<String> digestedPeptide = new ArrayList<>();
        if (peptide.length() >= minimalLength) {
            digestedPeptide.add(peptide);
        }
        return digestedPeptide;
    }
}