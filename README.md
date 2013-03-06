<b>Hi</b>
<br/>
This Java project has developed by Pooya husseini to design a command line interface to create, save,
load and manipulate Matrices and values.
It has purely written in Java. I've used maven, spring and freemarker to decrease the production time.
First of all Run Program.java class,for example write Matrix a 3 3, and see that it will create a 3x3 matrix named 'a'.
You can separate commands in a line with ';'. Commands are not case-sensitive.

There is the full command list:

### add [ #matrix_store_name ] #object_name1 #object_name2
    Adds one object to another

### copy [#matrix_store_name] #object_name1 #object_name2
    Copies one object to another

### del #object_name [ #object_name... ]
    Deletes the given object

### echelon [ #matrix_name ] #matrix_name
    Calculates the echelon form of the object

### inv [ #matrix_store_name ] #matrix_name
    Inverts the object

### lu #matrix_a #matrix_l #matrix_u
    Solves the lu decomposition

### matrix #matrix_name [#height #width]
    Creates a matrix with dimension of height * width. Setting width and height are optional

### mul [ #matrix_store_name ] #object_name1 #object_name2
    Multiplies one object to another

### pow [ #matrix_store_name ] #object_name [#integer|#val_name]
    Powers one object to the entered number or value

### rank [ #val_store_name ] #matrix_name
    Calculates the rank of the object

### read #object_name #file_path
    Reads object from file-path and stores it with the given name

### save #object_name #file_path
    Stores object in the given file path

### set #object_name [[#row]][[#col]] [{ #values... }]
    Fills object with values according to values

### show #object_name  [ #object_name... ]
    Prints then string representation of the object in console

### solve #matrix_x #matrix_a #matrix_b
    Solves the equation of Ax=b

### sub [ #matrix_store_name ] #object_name1 #object_name2
    Subtracts one object to another

### swap #object_name1 #object_name2
    Swaps two objects

### trace [ #val_store_name ] #matrix_name
    Calculates the trace of the object and puts in the given value

### trn [ #matrix_store_name ] #matrix_name
    Transpose the object and puts it in the given val

### var #val_name [ #number ]
    Defines a single value with the given value

### usage #command_name [ #command_name... ]
    Prints how to use the command_name

### help #command_name [ #command_name... ]
    Prints about the command_name
<br/>
Best regards
Pooya Husseini