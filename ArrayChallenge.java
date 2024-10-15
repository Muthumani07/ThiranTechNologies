import java.util.Arrays;

public class ArrayChallenge {
    
    public static String ArrayChallenge(int[] arr) {
        int length = arr.length;
        int[] result = new int[length];
        int varOcg = 1;  // _define-ocg_
        
        // Step 1: Calculate the product of all numbers
        for (int i = 0; i < length; i++) {
            varOcg *= arr[i];
        }

        // Step 2: Create the new array where each element is the product of all other elements
        for (int i = 0; i < length; i++) {
            result[i] = varOcg / arr[i];  // Division to get the product of all other elements
        }

        // Step 3: Convert the array into a hyphen-separated string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(result[i]);
            if (i < length - 1) sb.append("-");
        }

        String finalResult = sb.toString();
        
        // Step 4: Interspersing ChallengeToken
        String challengeToken = "n8crgxo3y5";
        StringBuilder interspersed = new StringBuilder();
        int tokenIndex = 0;
        
       
        for (int i = 0; i < finalResult.length(); i++) {
            interspersed.append(finalResult.charAt(i));
            if (tokenIndex < challengeToken.length()) {
                interspersed.append(challengeToken.charAt(tokenIndex));
                tokenIndex++;
            }
        }
        while(tokenIndex < challengeToken.length()) {
            interspersed.append(challengeToken.charAt(tokenIndex));
                tokenIndex++;
        }
        

        return interspersed.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3};      
        String result = ArrayChallenge(arr);
        System.out.println(result); // Outputs: 1n28-c3r-g4xo3y5
    }
}