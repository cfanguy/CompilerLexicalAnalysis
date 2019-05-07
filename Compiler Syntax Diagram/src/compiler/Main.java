package compiler;

public class Main {

    public Main()
    {}

    public static void main(String[] args)
    {
        Main app = new Main();
        System.out.println("READ           NAME              VALUE");
        app.choose();
    }

    //this method chooses the method to execute
    public void choose()
    {
        Token tokenApp = new Token();

        //As long as the current character is not ~ (the end character),
        //this chooses the method to execute
        while(tokenApp.token[tokenApp.current] != '~')
        {
            //When a space is encountered, it skips to the next character
            if (tokenApp.token[tokenApp.current] == ' ')
                tokenApp.current++;

            //if character is a letter, executes isId method
            if (Character.isLetter(tokenApp.token[tokenApp.current]))
            {
                tokenApp.isId(tokenApp.token);
                tokenApp.isLong(tokenApp.str);
            }

            //if character is a digit, executes isNumber method
            if (Character.isDigit(tokenApp.token[tokenApp.current]))
            {
                tokenApp.isNumber(tokenApp.token);
                tokenApp.isLong(tokenApp.num);
            }

            //if character is an operator, executes isOp method
            if(tokenApp.token[tokenApp.current] == '+'
                    || tokenApp.token[tokenApp.current] == '-'
                     || tokenApp.token[tokenApp.current] == '='
                     || tokenApp.token[tokenApp.current] == '<'
                     || tokenApp.token[tokenApp.current] == '>'
                     || tokenApp.token[tokenApp.current] == '('
                     || tokenApp.token[tokenApp.current] == ')'
                     || tokenApp.token[tokenApp.current] == '*'
                     || tokenApp.token[tokenApp.current] == '['
                     || tokenApp.token[tokenApp.current] == ']'
                     || tokenApp.token[tokenApp.current] == ':'
                     || tokenApp.token[tokenApp.current] == '.'
                     || tokenApp.token[tokenApp.current] == ';'
                     || tokenApp.token[tokenApp.current] == '/'
                     || tokenApp.token[tokenApp.current] == ',')
                tokenApp.isOp(tokenApp.token);

            //if character is an illegal chracter, executes the isError method
            if(tokenApp.token[tokenApp.current] == '&'
                    || tokenApp.token[tokenApp.current] == '_'
                     || tokenApp.token[tokenApp.current] == '!'
                     || tokenApp.token[tokenApp.current] == '$'
                     || tokenApp.token[tokenApp.current] == '@'
                     || tokenApp.token[tokenApp.current] == '%'
                     || tokenApp.token[tokenApp.current] == '#'
                     || tokenApp.token[tokenApp.current] == '^'
                     || tokenApp.token[tokenApp.current] == '?'
                     || tokenApp.token[tokenApp.current] == '|'
                     || tokenApp.token[tokenApp.current] == '{'
                     || tokenApp.token[tokenApp.current] == '}')
             tokenApp.isError(tokenApp.token);
        }

        Syntax syn = new Syntax();
        syn.Choice(tokenApp.tokenObj);

    }
}