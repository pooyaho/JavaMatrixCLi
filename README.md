Hi
<br/>
This project developed by Pooya husseini to design a command line program in Java to create, save,
load and manipulate Matrices.
It's pure Java core and I did not used any other technologies. I created it in maven to make it cross IDE.
Run Program.java and for example write Matrix a 3 3; it creates a 3x3 matrix that named 'a'.
each commands should end with ; and also every command is case insensitive.
Full command list is:

### matrix #name [#height #width]
Creates a matrix with dimension of height * width . width and height are optional

### set #name [[#row]][[#col]] [{ #values... }]
Fills matrix with values according to values

### read #name #file_path
Reads matrix from filePath and store it with name of MatrixName

### save #name #file_path
Stores  MatrixName if desired filePath

### show #name  [ #name... ]
Prints string representation of the  MatrixName in console

### copy [#store_name] #name1 #name2
Copies M2 into M1

### swap #name1 #name2
Swaps one matrix to another

### add [ #store_name ] #name1 #name2
Adds one matrix to another

### sub [ #store_name ] #name1 #name2
Subtracts one matrix to another

### mul [ #store_name ] #name1 #name2
Multiplies one matrix to another

### pow [ #store_name ] #name #integer
Powers one matrix to the entered number

### inv [ #store_name ] #name
Inverts the matrix

### trn [ #store_name ] #name
Transpose the matrix

### solve #x #a #b
Solves Matrix equation  Ax=b

### lu #a #l #u
Decomposes #a with LU decomposition and set #l and #u

### echelon [#store_name] #name
Calculates the echelon form of the matrix

### rank #name
Prints the rank of the matrix

### trace #name
Prints the trace of the matrix

### usage #command_name [ #command_name... ]
prints how to use the command_name

### help #command_name [ #command_name ]
prints about the command_name
<br/>
Best regards
Pooya Husseini