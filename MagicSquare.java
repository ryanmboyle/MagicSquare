
/**
 * Write a description of class MagicSquare here.
 *
 * @author Ryan Boyle
 * @version May 2020
 */
public class MagicSquare
{
    private int dimension;
    private int[][] data;
    
    public MagicSquare(int size)
    {
        data = new int[size][size];
        int[] shuffle = new int[size*size];
        for (int i=0; i<shuffle.length; i++)
        {
            shuffle[i]=i+1;
            //System.out.print(shuffle[i]+ ", ");
        }
        
        for(int i=shuffle.length-1; i>0; i--)
        {
            int randomPos = (int)(Math.random()*(i-1));
            int copy = shuffle[randomPos];
            shuffle[randomPos]=shuffle[i];
            shuffle[i]=copy;
        }
        
        //int r=0;
        //int c=0;
        int i=0;
        for(int r=0; r<size; r++)
        {
            for(int c=0; c<size; c++)
            {
                data[r][c]=shuffle[i];
                //System.out.print(data[r][c]+ "\t");
                i++;
            }
            //i++;
        }
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
    
    public boolean isMagic()
    {
        if(data.length==data[0].length && findOnce()==true && checkSums()==true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean checkSums()
    {
        int n = data.length;
        double magicNum = 0.5*n*(2+n*n-1);
        int count = 0;
        int finalCount = (n*2)+2;
        
        //diagonal starting top left
        int sum = 0;
        for (int r=0; r<n; r++)
        {
            sum+=data[r][r];
        }
        if(sum==magicNum)
        {
            count++;
        }
        //System.out.println("diagonal top left: "+ sum);
        
        //diagonal starting top right
        sum = 0;
        int c=n-1;
        for (int r=0; r<n; r++)
        {
            sum+=data[r][c];
            c--;
        }
        if(sum==magicNum)
        {
            count++;
        }
        //System.out.println("diagonal top right: "+ sum);
        
        //horizontal
        sum = 0;
        for (int r=0; r<n; r++)
        {
            for (c=0; c<n; c++)
            {
                sum+=data[r][c];
            }
            //System.out.println("horizontal row " + r + ": " + sum);
            if(sum==magicNum)
            {
                count++;
            }
            sum=0;
        }
        
        //vertical
        for (c=0; c<n; c++)
        {
            for (int r=0; r<n; r++)
            {
                sum+=data[r][c];
            }
            //System.out.println("vertical column " + c + ": " + sum);
            if(sum==magicNum)
            {
                count++;
            }
            sum=0;
        }
        
        //System.out.println("count: " + count);
        if(count==finalCount)
            return true;
        else
            return false;
    }
    
    public boolean findOnce()
    {
        int size = data.length;
        boolean findOnce = true;
        int i=1;
        while(findOnce==true && i<=(size*size))
        {
            findOnce = false;
            int count = 0;
            for (int r=0; r<data.length; r++)
            {
                for (int c=0; c<data[0].length; c++)
                {
                    if(data[r][c]==i)
                    {
                        count++;
                    }
                }
            }
            if(count==1)
            {
                findOnce=true; 
            }
            i++;
            }
        if(i==size*size+1)
        {
            return true;
        }
        else
        {
            return false;
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
        //System.out.print(result);
        return result;
    }
    
}
