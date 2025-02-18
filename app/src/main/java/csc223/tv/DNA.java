package csc223.tv;

public class DNA {
    
    public static String countNucleotides(String dna) {
        int NumberOfA = 0;
        int NumberOfT = 0;
        int NumberOfG = 0;
        int NumberOfC = 0;
        
        for (int i = 0; i < dna.length() ; i ++){
            if (dna.charAt(i) == 'A'){
                NumberOfA += 1;
            } else if (dna.charAt(i) == 'T') {
                NumberOfT += 1;
            } else if (dna.charAt(i) == 'G') {
                NumberOfG += 1;
            } else if (dna.charAt(i) == 'C'){
                NumberOfC += 1;
            };
        };
        return String.format("%d %d %d %d", NumberOfA, NumberOfT, NumberOfG, NumberOfC);
    }


    public static String transcribe(String dna){
        StringBuilder rna = new StringBuilder(dna);
        for (int i = 0; i < dna.length(); i ++){
            if (rna.charAt(i) == 'T'){
                rna.setCharAt(i, 'U');
            }
        }
        return rna.toString();
    }


    public static String reverseComplement(String dna){
        StringBuilder sc = new StringBuilder();
        for (int i = dna.length() - 1; i >= 0 ; i--){
            char nucleotide = dna.charAt(i);
            if (nucleotide == 'A'){
                sc.append('T');
            } else if (nucleotide == 'T'){
                sc.append('A');
            } else if (nucleotide == 'G'){
                sc.append('C');

            } else if (nucleotide == 'C'){
                sc.append('G');
            }
        }
        return sc.toString();
    }

    public static void main(String[] args){
        System.out.println(countNucleotides("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC"));
        System.out.println(transcribe("GATGGAACTTGACTACGTAAATT"));
        System.out.println(reverseComplement("AAAACCCGGT"));
    }
}
