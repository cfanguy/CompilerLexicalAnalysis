package compiler;

public class Syntax {

    public Syntax(){}

    int number = 1;

    //Program
    public void Choice(String[] array) {
        if (array[number].equals("PROGRAM"))
        {
            number = number + 1;
            if (array[number].equals("identifier"))
            {
                number = number + 2;
                if (array[number].equals("semicolon"))
                {
                    number = number + 3;
                    this.Dec(array);
                    this.Dec(array);
                    this.Comp(array);
                    if (array[number].equals("period"))
                        System.out.println("Syntax Correct.");
                    else
                    {
                        System.out.println("Syntax Incorrect at String: "
                                + "\"" + array[number] + "\" "
                                + "at location: " + number);
                    }
                }
            }
        }
    }


    //Declaraion Part
    public void Dec(String[] array) {
        if (array[number].equals("PROCEDURE"))
        {
            number = number + 1;
            this.Proc(array);
        }
        if (array[number].equals("VAR"))
        { 
            number = number + 1;
            this.Var(array);
            number = number + 3;
        }
        
        if (array[number].equals("BEGIN"))
        {
            this.Comp(array);
        }
    }


    //Compund Statement
    public void Comp(String[] array) {
        if(array[number].equals("BEGIN"))
        {
            this.State(array);
            if(array[number].equals("semicolon"))
            {
                this.State(array);
                if(array[number].equals("semicolon"))
                {
                    number = number + 3;
                    if(array[number].equals("END"))
                    {
                        this.Comp(array);
                    }
                }
            }
        }
        if(array[number].equals("END"))
            {
                number = number + 1;
                if(array[number].equals("semicolon"))
                {
                    number = number + 3;
                    this.Comp(array);
                }
            }
    }


    //Variable Declaration
    public void Var(String[] array) {
        if(array[number].equals("identifier"))
        {
            number = number + 2;
            if(array[number].equals("colon"))
            {
                number = number + 3;
                if(array[number].equals("INTEGER"))
                {
                    number = number + 1;
                    if(array[number].equals("semicolon"))
                    {
                        if(array[number + 2].equals("identifier"))
                        {
                            number = number + 2;
                            this.Var(array);
                        }
                    }
                }
            }
        }
    }


    //Procedure Declaration
    public void Proc(String[] array) {
        if(array[number].equals("identifier"))
        {
            if(array[number + 2].equals("openparen"))
            {
                number = number + 4;
                this.Form(array);
                this.Dec(array);
            }
            else
            {
                number = number + 3;
                this.Dec(array);
            }
        }
    }


    //Formal Parameters
    public void Form(String[] array) {
        this.Var(array);
        number = number + 2;
        if(array[number].equals("closeparen"))
        {
            number = number + 3;
        }
    }


    //Statement
    public void State(String[] array) {
        if(array[number + 1].equals("identifier"))
        {
            number = number + 3;
            if(array[number].equals("assignment"))
            {
                this.Assign(array);
            }
            else
                this.ProcCall(array);
        }
        if(array[number + 2].equals("identifier"))
        {
            number = number + 4;
            if(array[number].equals("assignment"))
            {
                this.Assign(array);
            }
            else
                this.ProcCall(array);
        }
        else
        {
            if(array[number + 3].equals("IF"))
            {
                number = number + 4;
                this.If(array);
            }
            else
            {
                if(array[number + 3].equals("WHILE"))
                {
                    number = number + 4;
                    this.While(array);
                }
            }
        }
    }


    //Assignment Statement
    public void Assign(String[] array) {
        number = number + 2;
        this.Exp(array);
    }


    //Procedure Call Statement
    public void ProcCall(String[] array) {
        if(array[number].equals("openparen"))
        {
            number = number + 2;
            if(array[number].equals("identifier"))
            {
                number = number + 2;
                if(array[number].equals("comma"))
                {
                    number = number + 2;
                    if(array[number].equals("identifier"))
                    {
                        number = number + 2;
                    }
                }
                else
                    if(array[number].equals("closeparen"))
                        number = number + 2;
            }
        }
    }


    //If Statement
    public void If(String[] array) {
        this.Exp(array);
        if(array[number].equals("THEN"))
        {
            this.State(array);
            if(array[number].equals("ELSE"))
            {
                this.State(array);
            }
        }
    }


    //While Statement
    public void While(String[] array) {
        this.Exp(array);
        if(array[number].equals("DO"))
        {
            number = number + 2;
            this.Comp(array);
        }
    }


    //Expression
    public void Exp(String[] array) {
        this.SimpExp(array);
        if(array[number].equals("lessthan") ||
                array[number].equals("greaterthan") ||
                array[number].equals("equal") ||
                array[number].equals("LTequal") ||
                array[number].equals("GTequal") ||
                array[number].equals("NOTequal"))
        {
            number = number + 2;
            this.SimpExp(array);
        }
    }


    //Simple Expression
    public void SimpExp(String[] array) {
        this.Term(array);
        if(array[number].equals("plus") ||
                array[number].equals("minus"))
        {
            number = number + 2;
            this.Term(array);
        }
    }


    //Term
    public void Term(String[] array) {
        this.Factor(array);
        if(array[number].equals("multiply") ||
                array[number].equals("divide"))
        {
            number = number + 2;
            this.Factor(array);
        }
    }


    //Factor
    public void Factor(String[] array) {
        if(array[number].equals("identifier"))
        {
            number = number + 2;
        }
        if(array[number].equals("number"))
        {
            number = number + 2;
        }
        if(array[number].equals("openparen"))
        {
            number = number + 2;
            this.Exp(array);
            if(array[number].equals("closeparen"))
                number = number + 3;
        }
    }
}