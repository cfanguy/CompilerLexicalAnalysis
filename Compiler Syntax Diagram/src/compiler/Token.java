package compiler;

import javax.swing.JOptionPane;

public class Token {

    public int c, count = 0, current = 0;
    public String input, str, num, op, error;
    public boolean test = true, isRes = false;
    public String[] resW;
    public String[] tokenObj;
    public char[] token;

    public Token()
    {
        //initializes the array of characters
        token = new char[255];

        //initializes the string of tokens
        tokenObj = new String[255];

        //creates the reserved word array
        resW = new String[] {"PROGRAM","VAR","INTEGER","REAL","BOOLEAN","ARRAY",
                "PROCEDURE","BEGIN","END","IF","THEN","ELSE","WHILE", "DO"};

        //Input entered and '~' is used to end program
        input = JOptionPane.showInputDialog(null, "Enter commands " +
                "(Enter ~ to end program): ",
                "Lexical Analysis", JOptionPane.QUESTION_MESSAGE);

        //takes the input and puts it into the character array
        token = input.toCharArray();
    }

    //checks whether input is an identifier or reserved word
    public void isId (char[] array)
    {
        if(Character.isLetter(array[current]))
        {
            str = "" + array[current];
            current++;
            while(test == true)
            {
                if(Character.isLetterOrDigit(array[current]))
                {
                    str = str + array[current];
                    test = true;
                    current++;

                    if(array[current] == '~')
                    {
                        //checks str if it is a reserved word or identifier
                        for(c = 0; c < 14; c++)
                        {
                            if(str.equals(resW[c]))
                            {
                                System.out.print(str + "          ");
                                tokenObj[count]=("reserved");
                                System.out.print(tokenObj[count]);
                                count++;
                                tokenObj[count]=("" + str);
                                System.out.println("            "
                                        + tokenObj[count]);
                                count++;
                                break;
                            }
                        }
                        if (c == 14)
                        {
                                System.out.print(str + "          ");
                                tokenObj[count]=("identifier");
                                System.out.print(tokenObj[count]);
                                count++;
                                tokenObj[count]=("" + str);
                                System.out.println("            "
                                        + tokenObj[count]);
                                count++;
                        }
                        break;
                    }
                }
                else
                {
                        for(c = 0; c < 14; c++)
                        {
                            if(str.equals(resW[c]))
                            {
                                System.out.print(str + "          ");
                                tokenObj[count]=("reserved");
                                System.out.print(tokenObj[count]);
                                count++;
                                tokenObj[count]=("" + str);
                                System.out.println("            "
                                        + tokenObj[count]);
                                count++;
                                break;
                            }
                        }
                        if (c == 14)
                        {
                                System.out.print(str + "          ");
                                tokenObj[count]=("identifier");
                                System.out.print(tokenObj[count]);
                                count++;
                                tokenObj[count]=("" + str);
                                System.out.println("            "
                                        + tokenObj[count]);
                                count++;
                        }
                        break;
                    }
                }
        }
    }

    //checks if input is a number
    public void isNumber(char[] array)
    {
        if(Character.isDigit(array[current]))
        {
            num = "" + array[current];
            current++;
            while(test == true)
            {
                if(Character.isDigit(array[current]))
                {
                    num = num + array[current];
                    test = true;
                    current++;
                    if(array[current] == '~')
                    {
                        System.out.print(num + "          ");
                        tokenObj[count]=("number");
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("" + num);
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                        break;
                    }
                }
                else
                {
                    System.out.print(num + "          ");
                    tokenObj[count]=("number");
                    System.out.print(tokenObj[count]);
                    count++;
                    tokenObj[count]=("" + num);
                    System.out.println("              "
                            + tokenObj[count]);
                    count++;
                    break;
                }
            }
        }
    }

    //checks if input is an operator
    public void isOp(char[] array)
    {
        if(array[current] == '+' || array[current] == '-'
                 || array[current] == '=' || array[current] == '<'
                 || array[current] == '>' || array[current] == '('
                 || array[current] == ')' || array[current] == '*'
                 || array[current] == '%' || array[current] == '['
                 || array[current] == ']' || array[current] == ':'
                 || array[current] == '.' || array[current] == ';'
                 || array[current] == '/' || array[current] == ',')
        {
            if (array[current] == ' ')
                        current++;
            op = "" + array[current];
            current++;
            while(test == true)
            {
                if(array[current] == '+' || array[current] == '-'
                        || array[current] == '=' || array[current] == '<'
                        || array[current] == '>' || array[current] == '('
                        || array[current] == ')' || array[current] == '*'
                        || array[current] == '['
                        || array[current] == ']' || array[current] == ':'
                        || array[current] == '.' || array[current] == ';'
                        || array[current] == '/' || array[current] == ',')
                {
                    op = op + array[current];
                    test = true;
                    current++;
                    if(array[current] == '~')
                    {
                        break;
                    }
                }
                else
                {
                    if(op.equals("."))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="period";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(":"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="colon";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(";"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="semicolon";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(","))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="comma";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("("))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="openparen";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(")"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="closeparen";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("["))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="openbracket";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("]"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="closebracket";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(":="))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="assignment";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("<"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="lessthan";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(">"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="greaterthan";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("="))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="equal";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("<="))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="LTequal";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals(">="))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="GTequal";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("<>"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="NOTequal";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("+"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="plus";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("-"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="minus";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("*"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="multiply";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    if(op.equals("/"))
                    {
                        System.out.print(op + "          ");
                        tokenObj[count]="divide";
                        System.out.print(tokenObj[count]);
                        count++;
                        tokenObj[count]=("0");
                        System.out.println("              "
                                + tokenObj[count]);
                        count++;
                    }
                    break;
                }
            }
        }
    }

    //checks if the character is illegal
    public void isError(char[] array)
    {
        error = "" + array[current];
        System.out.println("Illegal character found at position "
                + (current + 1) + ": " + array[current]);
        current++;
    }

    //checks if the string is too long
    public void isLong(String string)
    {
        if (string.length() > 10)
            System.out.println("String " + string + " is too long");
    }
}