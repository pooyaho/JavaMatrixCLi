<b>Hi</b>
<br/>
This Java project has developed by Pooya husseini to design a command line interface to create, save,
load and manipulate Matrices and values.
It has purely written in Java. I've used maven, spring and freemarker to decrease the production time.
First of all Run Program.java class,for example write Matrix a 3 3, and see that it will create a 3x3 matrix named 'a'.
You can separate commands in a line with ';'. Commands are case insensitive.

There is the full command list:

<#list items as item>
### ${item.getTitle()}
    ${item.getDetail()}

</#list>

### usage #command_name [ #command_name... ]
    Prints how to use the command_name

### help #command_name [ #command_name... ]
    Prints about the command_name

<#--[#--### matrix #name [#height #width]--]-->
<#--[#--Creates a matrix with dimension of height * width . width and height are optional--]-->

<#--[#--### set #name [[#row]][[#col]] [{ (#values,)+ }]--]-->
<#--[#--Fills matrix with values according to values--]-->

<#--[#--### read #name #file_path--]-->
<#--[#--Reads matrix from filePath and store it with name of MatrixName--]-->

<#--[#--### save #name #file_path--]-->
<#--[#--Stores  MatrixName if desired filePath--]-->

<#--[#--### show #name  [ (#name)+ ]--]-->
<#--[#--Prints string representation of the  MatrixName in console--]-->

<#--[#--### copy [#store_name] #name1 #name2--]-->
<#--[#--Copies M2 into M1--]-->

<#--[#--### swap #name1 #name2--]-->
<#--[#--Swaps one matrix to another--]-->

<#--[#--### add [ #store_name ] #name1 #name2--]-->
<#--[#--Adds one matrix to another--]-->

<#--[#--### sub [ #store_name ] #name1 #name2--]-->
<#--[#--Subtracts one matrix to another--]-->

<#--[#--### mul [ #store_name ] #name1 #name2--]-->
<#--[#--Multiplies one matrix to another--]-->

<#--[#--### pow [ #store_name ] #name #integer--]-->
<#--[#--Powers one matrix to the entered number--]-->

<#--[#--### inv [ #store_name ] #name--]-->
<#--[#--Inverts the matrix--]-->

<#--[#--### trn [ #store_name ] #name--]-->
<#--[#--Transpose the matrix--]-->

<#--[#--### solve #x #a #b--]-->
<#--[#--Solves Matrix equation  Ax=b--]-->

<#--[#--### lu #a #l #u--]-->
<#--[#--Decomposes #a with LU decomposition and set #l and #u--]-->

<#--[#--### echelon [#store_name] #name--]-->
<#--[#--Calculates the echelon form of the matrix--]-->

<#--[#--### rank #name--]-->
<#--[#--Prints the rank of the matrix--]-->

<#--[#--### trace #name--]-->
<#--[#--Prints the trace of the matrix--]-->

<#--[#--### usage #command_name [ #command_name... ]--]-->
<#--[#--Prints how to use the command_name--]-->

<#--[#--### help #command_name [ #command_name ]--]-->
<#--[#--Prints about the command_name--]-->

<#--[#--### del #name [ #name... ]--]-->
<#--[#--Delete the given matrix--]-->

<#--[#--### val #name [ #value ]--]-->
<#--[#--Defines a variable with given value--]-->

<br/>
Best regards
Pooya Husseini