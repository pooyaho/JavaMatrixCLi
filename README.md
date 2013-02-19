Hi
This project developed by Pooya husseini to design a command line program in Java to create, save,
load and manipulate Matrices.
It's pure Java core and I did not used any other technologies. I created it in maven to make it cross IDE.
Run Program.java and for example write Matrix a 3 3; it creates a 3x3 matrix that named 'a'.
each commands should end with ; and also every command is case insensitive.
Full command list is:

### MATRIX name height width
Creates a matrix with dimension of height * width . Width and height are optional

### SET M {values}
Fills matrix with values 

### SET MatrixName[rowNumber] {values}
Sets desired row with values

### SET MatrixName[][columnNumber] {values}
Sets desired column with values

### SET MatrixName[r][c] a
Sets desired cell with a

### READ MatrixName filePath 
Reads matrix from filePath and store it with name of MatrixName

### SAVE MatrixName filePath
Stores  MatrixName if desired filePath

### SHOW  MatrixName
Prints string representation of the  MatrixName in console

### COPY M1 M2
Copies M2 into M1

### SWAP M1 M2
Swaps M1 with M2

### ADD M1 M2 M3
It is like M1=M2+M3

### ADD M1 M2
M1=M1+M2

### SUB M1 M2 M3
It is like M1=M2-M3

### SUB M1 M2
M1=M1-M2

### MUL M1 M2 M3
M1=M2xM3

### MUL M1 M2
M1=M1xM2

### POW M1 M2 a
Exponents M2 a times and stores it in M1

### POW M a
Exponents M a times and stores it in M

### INV M1 M2
Inverts M2 and stores it in M1

### INV M
Inverts M and stores it in M

###TRN M1 M2
Calculates Transpose of M2 and stores it in M1

### TRN M
Calculates Transpose of M and stores it in M

### SOLVE M1 M2 M3
Solves Matrix equation  Ax=b that A is M1, X is M2 and b is M3.

### LUDecompose M1 M2 M3
Decomposes M1 with LU decomposition and set M2 with L and M3 with U

### Usage #command_name
prints how to use the command_name

### Help #command_name
prints about the command_name

Best regards
Pooya Husseini
