package cryptography;

public class Encryption extends KeyInputs
{
    String referenceStringCharacter = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    String referenceStringSpecial = " ~!@#$%^&_+/=<>()[]*-.,";
    String newTextMatrix[][] = new String[4][4];
    String newText = new String();
    public String performEncryptionOperation(String text)
    {   
        
        String encryptedText = "";
        double count = (double)text.length() / 16;
        
        for(int i=0 ; i< count; i++)
        {
            if(text.length() >= 16)
            {
                newText=text.substring(0, 16);
                text = ""+text.substring(16, text.length());    
            }
            else 
            {
                newText = text;
                while( newText.length() != 16 )
                    newText=newText.concat("*"); 
            }
            newTextMatrix = convertToMatrix(newText);
            newTextMatrix = substitutionRound_01(newTextMatrix);
            newTextMatrix = substitutionRound_02(newTextMatrix);
            newTextMatrix = substitutionRound_03(newTextMatrix);
            newTextMatrix = substitutionRound_04(newTextMatrix);
            newTextMatrix = substitutionRound_05(newTextMatrix);
            newTextMatrix = substitutionRound_06(newTextMatrix);
            newTextMatrix = substitutionRound_07(newTextMatrix);
            newTextMatrix = substitutionRound_08(newTextMatrix);
            newTextMatrix = substitutionRound_09(newTextMatrix);
            newTextMatrix = substitutionRound_10(newTextMatrix); 
            newTextMatrix = substitutionRound_11(newTextMatrix);
            newTextMatrix = substitutionRound_12(newTextMatrix);
            
            for(int j=0;j<4;j++)
                for(int k=0;k<4;k++)
                    encryptedText = encryptedText+""+newTextMatrix[j][k];
            
        }
        return encryptedText;
    }
    
    String[][] convertToMatrix(String newText)
    {
       int pos=0;
       String[][] k=new String[4][4];
       for(int i=0;i<4;i++)
       {
           for(int j=0;j<4;j++)
           {
               k[i][j]=String.valueOf(newText.charAt(pos));
               pos++;
           }
       }
       return k;
    }
    
    String[][] transposition(String newTextMatrix[][])
    {
        String[][] transposeMatrix = new String[4][4];
        transposeMatrix[0][0] = newTextMatrix[0][0]; transposeMatrix[0][1] = newTextMatrix[0][1];
        transposeMatrix[0][2] = newTextMatrix[1][0]; transposeMatrix[0][3] = newTextMatrix[2][0];
        transposeMatrix[1][0] = newTextMatrix[1][1]; transposeMatrix[1][1] = newTextMatrix[0][2];
        transposeMatrix[1][2] = newTextMatrix[0][3]; transposeMatrix[1][3] = newTextMatrix[1][2];
        transposeMatrix[2][0] = newTextMatrix[2][1]; transposeMatrix[2][1] = newTextMatrix[3][0];
        transposeMatrix[2][2] = newTextMatrix[3][1]; transposeMatrix[2][3] = newTextMatrix[2][2];
        transposeMatrix[3][0] = newTextMatrix[1][3]; transposeMatrix[3][1] = newTextMatrix[2][3];
        transposeMatrix[3][2] = newTextMatrix[3][2]; transposeMatrix[3][3] = newTextMatrix[3][3];
        return transposeMatrix;
    }
    
    String[][] substitutionRound_01(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k10[i][j], KeyInputs.k11[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k10[i][j], KeyInputs.k11[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k10[i][j], KeyInputs.k11[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_02(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k11[i][j], KeyInputs.k12[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k11[i][j], KeyInputs.k12[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k11[i][j], KeyInputs.k12[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    String[][] substitutionRound_03(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k12[i][j], KeyInputs.k13[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k12[i][j], KeyInputs.k13[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k12[i][j], KeyInputs.k13[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_04(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k13[i][j], KeyInputs.k20[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k13[i][j], KeyInputs.k20[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k13[i][j], KeyInputs.k20[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_05(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k20[i][j], KeyInputs.k21[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k20[i][j], KeyInputs.k21[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k20[i][j], KeyInputs.k21[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_06(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k21[i][j], KeyInputs.k23[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k21[i][j], KeyInputs.k23[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k21[i][j], KeyInputs.k23[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_07(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k23[i][j], KeyInputs.k23[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k23[i][j], KeyInputs.k23[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k23[i][j], KeyInputs.k23[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_08(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k23[i][j], KeyInputs.k30[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k23[i][j], KeyInputs.k30[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k23[i][j], KeyInputs.k30[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_09(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k30[i][j], KeyInputs.k31[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k30[i][j], KeyInputs.k31[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k30[i][j], KeyInputs.k31[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_10(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k31[i][j], KeyInputs.k32[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k31[i][j], KeyInputs.k32[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k31[i][j], KeyInputs.k32[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_11(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k32[i][j], KeyInputs.k33[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k32[i][j], KeyInputs.k33[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k32[i][j], KeyInputs.k33[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    String[][] substitutionRound_12(String newTextMatrix[][])
    {
        newTextMatrix = transposition(newTextMatrix);
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                char z = newTextMatrix[i][j].charAt(0);
                if(Character.isLetter(z))
                    newTextMatrix[i][j]=String.valueOf(referenceStringCharacter.charAt(roundCalculation(referenceStringCharacter.indexOf(z), KeyInputs.k33[i][j], KeyInputs.k10[i][j], 52))); 
                else if(Character.isDigit(z))
                    newTextMatrix[i][j]=String.valueOf((roundCalculation(Integer.parseInt(newTextMatrix[i][j]), KeyInputs.k33[i][j], KeyInputs.k10[i][j], 10))); 
                else
                    newTextMatrix[i][j]=String.valueOf(referenceStringSpecial.charAt(roundCalculation(referenceStringSpecial.indexOf(z), KeyInputs.k33[i][j], KeyInputs.k10[i][j], 23))); 
            }
        }
        newTextMatrix = folding(newTextMatrix);
        newTextMatrix = shifting(newTextMatrix);
        return newTextMatrix;
    }
    
    int roundCalculation(int z, int k1, int k2, int modVal)
    {
        int x,y;
        x = (z + k1) % modVal;
        y = (x + k2) % modVal;
        return y;
    }
    
    String[][] folding(String newTextMatrix[][])
    {
        
        for(int i=0;i<4;i++)
        {
            String temp = newTextMatrix[1][i];
            newTextMatrix[1][i]= newTextMatrix[3][i];
            newTextMatrix[3][i] = temp;
        }
        for(int i=0;i<4;i++)
        {
            String temp = newTextMatrix[i][0];
            newTextMatrix[i][0]= newTextMatrix[i][2];
            newTextMatrix[i][2] = temp;
        } 
        for(int i=0;i<4;i++)
        {
            for(int j=i+1;j<4;j++)
            {
                String temp = newTextMatrix[i][j];
                newTextMatrix[i][j] = newTextMatrix[j][i];
                newTextMatrix[j][i] = temp;
            }
        }
        return newTextMatrix;
    }
    
    String [][] shifting(String newTextMatrix[][])
    {
        String referenceShifting = "+/=efg3vwxadIy0zA1BSTbcUCD2Eh ijklm6no~!@FGH#^&p-q7$%stu8OPQr5R.9VYZ_<>JK4,LMN()[]*WX";
        String referenceVal      = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ~!@#$%^&_+/=<>()[]*-.,0123456789";
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<4;j++)
            {
                int val = referenceVal.indexOf(newTextMatrix[i][j].charAt(0));
                newTextMatrix[i][j] = String.valueOf(referenceShifting.charAt(val));
            }
        }
        return newTextMatrix;
    }
}
