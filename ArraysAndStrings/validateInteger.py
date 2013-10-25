#!/apollo/env/SDETools/bin/python

def isNumeric(string):
    if string is None or len(string)==0:
        return False
    
    string = string.lower()

    # remove plus and minus sign in the front if any 
    if string.find("+") == 0 or string.find("-") == 0:
        string = string[1:]

    ePos = string.find("e")
    dotPos = string.find(".")

    # if "e" or "E" or "." in the end of the string, wrong format
    if ePos == len(string) - 1 or dotPos == len(string) - 1:
        return False

    # if "." and "e" or "E" coexist, "e" or "E" has to be in the front of "."
    if ePos > 0 and dotPos > 0:
       return ePos > dotPos

    return string.replace("e", "", 1).replace(".", "", 1).isdigit()





# test code
listString = ["abcd", "123e5.6", "123.7E79", "1234e6e47","123.5.6", "+123456",
"-2345", "", None, "0", "123456e"]
for string in listString:
    if string is None:
        print "The result for None is " + str(isNumeric(string))
    else:
        if isNumeric(string):
            print string + " is a numeric number."
        else:
            print string + " is not a numeric number."
