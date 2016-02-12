/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PeptideDigestors;

import PeptideCutter.PeptideCutter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author arne
 */
public class ChemotrypsinDigestorHighSpecific implements Digestor {

    /**
     * contains the minimal length a peptide should have
     */
    private final Integer minimalLength;

    /**
     * Initiates the class.
     *
     * @param minLength
     */
    public ChemotrypsinDigestorHighSpecific(final Integer minLength) {
        this.minimalLength = minLength;
    }

    @Override
    public final ArrayList<String> digest(final String peptide) {
        // Chemotrysin high specificity
        // The order for the sites is:
        // p4   p3  p2  p1  p1F p2F p3F p4F
        ArrayList<Character> aa = new ArrayList<>(Arrays.asList('F', 'Y', 'W'));
        ArrayList<Integer> indices = new ArrayList<>(Arrays.asList(-1, peptide.length() - 1));
        for (Character amino : aa) {
            for (int index = peptide.indexOf(amino); index >= 0 && index <= peptide.length() - 2;
                    index = peptide.indexOf(amino, index + 1)) {
                String p1F = peptide.substring(index + 1, index + 2);
                if (!p1F.equals("P")) {
                    if (amino.equals('W') && p1F.equals("M")) {
                    } else {
                        indices.add(index);
                    }
                }
            }
        }
        PeptideCutter PC = new PeptideCutter();
        return PC.getDigestionArray(peptide, indices, this.minimalLength);
    }
}