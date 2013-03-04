<b>Hi</b>
<br/>
This Java project has developed by Pooya husseini to design a command line interface to create, save,
load and manipulate Matrices and values.
It has purely written in Java. I've used maven, spring and freemarker to decrease the production time.
First of all Run Program.java class,for example write Matrix a 3 3, and see that it will create a 3x3 matrix named 'a'.
You can separate commands in a line with ';'. Commands are not case-sensitive.

There is the full command list:

### add [ #store_name ] #name1 #name2
    Adds one matrix to another

### copy [#store_name] #name1 #name2
    Copies one matrix to another

### del #name [ #name... ]
    Delete the given matrix

### echelon [#store_name] #name
    Calculates the echelon form of the matrix

### inv [ #store_name ] #name
    Inverts the matrix

### lu #a #l #u
    Solves the lu decomposition

### matrix #name [#height #width]
    Creates a matrix with dimension of height * width. Setting width and height are optional

### mul [ #store_name ] #name1 #name2
    Multiplies one matrix to another

### pow [ #store_name ] #name #integer
    Powers one matrix to the entered number

### rank #name
    Prints the rank of the matrix

### read #name #file_path
    Reads matrix from file path and store it with the entered name

### save #name #file_path
    Stores MatrixName if desired file path

### set #name [[#row]][[#col]] [{ #values... }]
    Fills matrix with values according to values

### show #name  [ #name... ]
    Prints then string representation of the matrix name in console

### solve #x #a #b
    Solves the equation

### sub [ #store_name ] #name1 #name2
    Subtracts one matrix to another

### swap #name1 #name2
    Swaps one matrix to another

### trace #name
    Prints the trace of the matrix

### trn [ #store_name ] #name
    Transpose the matrix

### var #name [ #value ]
    Defines a variable with given value

### usage #command_name [ #command_name... ]
    Prints how to use the command_name

### help #command_name [ #command_name... ]
    Prints about the command_name


<br/>
Best regards
Pooya Husseini