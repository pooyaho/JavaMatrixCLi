<b>Hi</b>
<br/>
This Java project has developed by Pooya husseini to design a command line interface to create, save,
load and manipulate Matrices and values.
It has purely written in Java. I've used maven, spring and freemarker to decrease the production time.
First of all Run Program.java class,for example write Matrix a 3 3, and see that it will create a 3x3 matrix named 'a'.
You can separate commands in a line with ';'. Commands are not case-sensitive.

There is the full command list:

### add [ #store_name ] #name1 #name2
    Adds one object to another

### copy [#store_name] #name1 #name2
    Copies one object to another

### del #name [ #name... ]
    Deletes the given object

### echelon [#store_name] #name
    Calculates the echelon form of the object

### inv [ #store_name ] #name
    Inverts the object

### lu #a #l #u
    Solves the lu decomposition

### matrix #name [#height #width]
    Creates a matrix with dimension of height * width. Setting width and height are optional

### mul [ #store_name ] #name1 #name2
    Multiplies one object to another

### pow [ #store_name ] #name [#integer|#name]
    Powers one object to the entered number

### rank #name
    Calculates the rank of the object

### read #name #file_path
    Reads object from file-path and stores it with the given name

### save #name #file_path
    Stores object in the given file path

### set #name [[#row]][[#col]] [{ #values... }]
    Fills object with values according to values

### show #name  [ #name... ]
    Prints then string representation of the object in console

### solve #x #a #b
    Solves the equation of Ax=b

### sub [ #store_name ] #name1 #name2
    Subtracts one object to another

### swap #name1 #name2
    Swaps two objects

### trace #name
    Calculates the trace of the object

### trn [ #store_name ] #name
    Transpose the object

### var #name [ #value ]
    Defines a single value with the given value

### usage #command_name [ #command_name... ]
    Prints how to use the command_name

### help #command_name [ #command_name... ]
    Prints about the command_name
<br/>
Best regards
Pooya Husseini