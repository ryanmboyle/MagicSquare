
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
        System.out.println(size);
        String newNumbers = numbers.substring(1, numbers.length()-1);
        //System.out.println(newNumbers);
        
        int r=0;
        int c=0;
        
        for(int i=1; i<newNumbers.length(); i+=(size*3)+2)
        {
            for (int y=i; y<i+(size*2)+3; y+=3)
            {
                String stringNum = newNumbers.substring(y, y+1);
                //System.out.println(stringNum);
                int num = Integer.parseInt(stringNum);
                //System.out.println(num);
                
                data[r][c] = num;
                
                c++;
            }
            c=0;
            r++;
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
        //  System.out.print(result);
        return result;
    }
    
}
