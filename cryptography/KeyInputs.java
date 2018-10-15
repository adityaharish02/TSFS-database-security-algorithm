package cryptography;

public class KeyInputs 
{   
    public static String k1=new String();
    public static String k2=new String();
    public static String k3=new String();
    static String referenceStringChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static int k10[][]=new int[4][4]; static int k20[][]=new int[4][4];static int k30[][]=new int[4][4];
    static int k11[][]=new int[4][4]; static int k21[][]=new int[4][4];static int k31[][]=new int[4][4];
    static int k12[][]=new int[4][4]; static int k22[][]=new int[4][4];static int k32[][]=new int[4][4];
    static int k13[][]=new int[4][4]; static int k23[][]=new int[4][4];static int k33[][]=new int[4][4];
    public void keyCalculation()
    {   
        System.out.println("Enter keys:");
        
        String k1_matrix[][] = convertKeyToMatrix(k1);
        String k2_matrix[][] = convertKeyToMatrix(k2);
        String k3_matrix[][] = convertKeyToMatrix(k3);
        k10 = keyGenerate0(k1_matrix);
        k20 = keyGenerate0(k2_matrix);
        k30 = keyGenerate0(k3_matrix);
        k11 = keyGenerate1(k1_matrix);
        k21 = keyGenerate1(k2_matrix);
        k31 = keyGenerate1(k3_matrix);
        k12 = keyGenerate2(k1_matrix);
        k22 = keyGenerate2(k2_matrix);
        k32 = keyGenerate2(k3_matrix);
        k13 = keyGenerate3(k1_matrix);
        k23 = keyGenerate3(k2_matrix);
        k33 = keyGenerate3(k3_matrix);
    }
    
    String[][] convertKeyToMatrix(String k)
    {
       int pos=0;
       
       String[][] km = new String[4][4];
       for(int i=0;i<4;i++)
       {
           for(int j=0;j<4;j++)
           {
               if(Character.isLetter(k.charAt(pos)))
               {
                   char c = k.charAt(pos);
                   km[i][j]=String.valueOf(referenceStringChar.indexOf(c));
               }
               else
                   km[i][j]=String.valueOf(k.charAt(pos));
               pos++;
           }
       }
       return km;
    }
    
    int[][] keyGenerate0(String a[][])
    {
        int b[][]=new int[4][4];
        for(int i=0;i<4;i++)
        {   
            for(int j=0;j<4;j++)
            {
                if(j-i<0)
                    b[i][4+(j-i)]=Integer.parseInt(a[i][j]);
                else
                    b[i][j-i]=Integer.parseInt(a[i][j]);
            }
        }
        return b;
    }
    
    int[][] keyGenerate1(String a[][])
    {
        int b[][]=new int[4][4];
        int val=1;
        for(int i=0;i<4;i++)
        {   
            for(int j=0;j<4;j++)
            {
                if(i!=3)
                {
                    if(j-val<0)
                        b[i][4+(j-val)]=Integer.parseInt(a[i][j]);
                    else
                        b[i][j-val]=Integer.parseInt(a[i][j]);
                }
                else 
                {
                    b[i][j]=Integer.parseInt(a[i][j]);
                }
            }
            val++;
        }
        return b;
    }
    
    int[][] keyGenerate2(String a[][])
    {
        int b[][]=new int[4][4];
        int val=2;
        for(int i=0;i<4;i++)
        {   
            for(int j=0;j<4;j++)
            {
                if(i!=2)
                {
                    if(j-val<0)
                        b[i][4+(j-val)]=Integer.parseInt(a[i][j]);
                    else
                        b[i][j-val]=Integer.parseInt(a[i][j]);
                }
                else 
                {
                    b[i][j]=Integer.parseInt(a[i][j]);
                }
            }
            if (i!=2) val++;
            else val-=3;
        }
        return b;
    }
    
    int[][] keyGenerate3(String a[][])
    {
        int b[][]=new int[4][4];
        int val=3;
        for(int i=0;i<4;i++)
        {   
            for(int j=0;j<4;j++)
            {
                if(i!=1)
                {
                    if(j-val<0)
                        b[i][4+(j-val)]=Integer.parseInt(a[i][j]);
                    else
                        b[i][j-val]=Integer.parseInt(a[i][j]);
                }
                else 
                {
                    b[i][j]=Integer.parseInt(a[i][j]);
                }
            }
            if (i!=1) val++;
            else val-=3;
        }
        return b;
    }
}