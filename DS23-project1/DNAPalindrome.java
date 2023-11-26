import java.util.Scanner;



public class DNAPalindrome {
    
    public static StringDoubleEndedQueueImpl CreateQ(String DNAseq){
       
        StringDoubleEndedQueueImpl s = new StringDoubleEndedQueueImpl();
        char[] charArray = DNAseq.toCharArray();
        
        for (int i = 0; i < charArray.length; i++) {
             s.addLast(String.valueOf(charArray[i])); 
        }
        
        return s;
    }
    
        
    
    
    public static boolean isValidDNASequence(String sequence) {
        // Ελέγχουμε αν το String είναι null.
    if (sequence == null) {
        return false;
    }

    // Ελέγχουμε αν το String είναι κενό.
    if (sequence.isEmpty()) {
        return true;
    }
       
    
        // Ελέγχουμε κάθε χαρακτήρα του String για εγκυρότητα.
        for (char nucleotide : sequence.toCharArray()) {
            if (!isValidNucleotide(nucleotide)) {
                return false;
            }
        }
    
        return true;
    }
    
    private static boolean isValidNucleotide(char nucleotide) {
        // Ελέγχουμε αν ο χαρακτήρας είναι ένα από τα έγκυρα A, T, C, G (πεζά γράμματα).
        return (nucleotide == 'A' || nucleotide == 'T' || nucleotide == 'C' || nucleotide == 'G');
    }
    public static boolean isWatson( StringDoubleEndedQueueImpl q1){
        while(!q1.isEmpty()){
            
            if((q1.getFirst().equals("A") && q1.getLast().equals("T")) ||
            (q1.getFirst().equals("T") && q1.getLast().equals("A")) ||
            (q1.getFirst().equals("C") && q1.getLast().equals("G")) ||
            (q1.getFirst().equals("G") &&q1.getLast().equals("C"))){
                q1.removeFirst();
                q1.removeLast();
                q1.printQueue(System.out);
                System.out.println("this is queue");

            }else{
                return false;
                
            }
        }
       return true;
        

    }
    
    
    
    
    
    
    


   public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Give me a Dna sequence");
            String DNAseq=in.nextLine();
            while(!isValidDNASequence(DNAseq)){
                System.out.println("Give me a Dna sequence");
                DNAseq=in.nextLine();

            }
            
            
            StringDoubleEndedQueueImpl q1=CreateQ(DNAseq);
            if (isWatson(q1)) {
                System.out.println(DNAseq+" is watson");
                
            }else{
                System.out.println(DNAseq+" is not watson");
            }
        }

        


    }
}