// Q: remove the duplicate characters in a string;
// assume only ASCII char.
bool removeDup(char* array)
{
    if(array==NULL) return false; // clarify if this case should return true/false or throw
    
    int hashTable[256];     //better naming
    for(int i=0; i<256; i++)
        hashTable[i]=false;
    
    int rPointer = 0;
    int wPointer = 0; 
    while(array[rPointer]!=NULL) {
        if(hashTable[array[rPointer]]==false)
        {
            hashTable[array[rPointer]]=true;
            array[wPointer] = array[rPointer];   
            wPointer++;
        }
        rPointer++;  
    }
    array[wPointer]=NULL;
    return true;
}

//Q: Given an M*N matrix, find all elements which are zero, when found it, set all the elements in that row and column to zero.
bool SetColRowZero(int** matrix, int row, int col)
{
    if(matrix==NULL || row<=0 || col <=0) return false;
    
    bool* rowMark = new bool[col];
    bool* colMark = new bool[row];
    if(!rowMark || !colMark) return false;

    for(int i=0; i<col; i++)
    {
        rowMark[i]=false;
    }
    for(int i=0; i<row; i++)
    {
        colMark[i]=false;
    }

    for(int i=0; i<row; i++)
    {
        for(int j=0; j<col; j++)
        {
            if(matrix[i][j]==0)
            {
                rowMark[j]=true;
                colMark[i]=true;
            }
        }
    }

    for(int i=0; i<row; i++)
    {
        for(int j=0; j<col; j++)
        {
            if(rowMark[j]==0 || colMark[i]==0)
            {
                matrix[i][j]=0;
            }
        }
    }
    
    // free memory
    
    return true;
}
