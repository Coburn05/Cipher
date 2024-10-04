for contributing please open a branch with your name.
create and/or assign the issue you want to work on to yourself
when you finish with your work have the last commit be something like
"finished, works as expected"

More info found in /src/Text Files

Message is encrypted using a 11x11 matrix
    - matrix can be rotated and shifted
    - transformations to the matrix are defined in the header
    - header is encrypted using a rule hidden in the signature
each letter or number has 3 ways to write it (including spaces)
using the matrix letters from the plain-text (original message)
are converted into character pairs.
    a -> ~!
    b -> @d
    c -> hC
    ... -> ...
character pairs can then be encrypted again with a different cypher

Verification is to be set using a rolling code.
The code is defined as a function that takes in communication number,
and the sender ID
    SenderID = [Hash](Sender_Private_Key)
    RollingCode(MSG_NUM, SenderID) = [Hash](MSG_NUM % SenderID)
    Signature = [Hash](MSG + RollingCode(MSG_NUM, SenderID))

Signature rules
    - at the beginning of the signature add the degree rotation of the matrix
    - after the degree rotation add a group of 5 random letters
    - after 5 random letters add 3 number representation of matrix shift
        - pad with 0's at the front if needed
    - matrix translations can be converted to hexadecimal
        - pad in a way to make the numbers fit in size, but not change the value

=========== RULES ARE VOID
    - first 9 bits are used to hide info on rotation
        - 00 = 0
        - 01 = 90
        - 10 = 180
        - 11 = 270
        - last 7 bits of first 9 bits include shift information
    - This tag is ADDED and does NOT REPLACE any of the signature
        - this allows for sender verification while including information
          on the encryption rules
=========== VOID ENDS
