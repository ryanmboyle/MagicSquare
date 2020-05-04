
/**
 * Write a description of class MagicSquare here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MagicSquare
{
    private int dimension;
    private int[][] data;
    
    public MagicSquare(int size)
    {
        
    }
    
    public MagicSquare(String numbers)
    {
        String firstRow = numbers.substring(2, numbers.indexOf("}"));
        int count = 0;
        for (int i=0; i<firstRow.length(); i++)
        {
            if(firstRow.substring(i, i+1).equals(","))
            {
                count++;
            }
        }
        int size = count+1;
        data = new int[size][size];
        //System.out.println(size);
        
        int r=0;
        int c=0;
        
        
        String newNumbers = numbers.substring(2, numbers.length()-1);
        int j=1;
        int i=0;
        while (j<=size)
        {
            newNumbers = newNumbers.substring(i);
            i=0;
            int loc = newNumbers.indexOf("}");
            
            for (int y=0; y<loc; y+=3)
            {
                String stringNum = "";
                if(newNumbers.substring(y+1, y+2).equals(",") || newNumbers.substring(y+1, y+2).equals("}"))
                {
                    stringNum += newNumbers.substring(y, y+1);
                    
                }
                else
                {
                    stringNum += newNumbers.substring(y, y+2);
                    //System.out.println(stringNum);
                    y++;
                    i++;
                }
                int num = Integer.parseInt(stringNum);
                data[r][c] = num;
                c++;
            }
            c=0;
            r++;
            i += (size*3)+2;
            j++;
        }
    }

    public String toString()
    {
        int numRows = data.length;
        int numCols = data[0].length;
        String result = "";
        for (int r=0; r<numRows; r++)
        {
            for (int c=0; c<numCols; c++)
            {
                result += data[r][c] + "\t";
            }
            result += "\n";
        }
        System.out.print(result);
        return result;
    }
    
}
