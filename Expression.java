//import java.util.regex.*; 
class Expression {
    private String s;
    private int currIndex;
    private int n;
    private char inputToken;
   
    public Expression(String s){
        this.s = s;
        currIndex = 0;
        n = s.length();
        nextToken();
    }

    void nextToken(){
        char c;
        do {
            if (currIndex == n){
                inputToken = '$';
                return;
            }
            c = s.charAt(currIndex++);
        } while (Character.isWhitespace(c));
        inputToken = c;
    }
  
   void match(char token){
       if (inputToken == token){
           nextToken();
       } else {
           throw new RuntimeException("syntax error");
       }
   }
  
   int eval(){
       int x = exp();
       if (inputToken == '$'){
           return x;
       } else {
           throw new RuntimeException("syntax error");
       }
   }
  
   int exp(){
       int x = term();
       while (inputToken == '+' || inputToken == '-'){
           char op = inputToken;
           nextToken();
           int y = term();
           x = apply(op, x, y);
       }
       return x;
   }
  
   int term(){
       int x = factor();
       while (inputToken == '*' ){
           char op = inputToken;
           nextToken();
           int y = factor();
           x = apply(op, x, y);
       }
       return x;
   }
  
   int factor(){
       int x;
       if(inputToken == '('){
            nextToken();
            x = exp();
            match(')');
            return x;
       }
       else if(inputToken == '-'){
           nextToken();
                x = factor();
                return -x;
       }
       else if(inputToken == '+'){
           nextToken();
            x = factor();
            return x;
       }
       else if(Character.isDigit(inputToken)){
        //collect all the digits and convert to int
            if(inputToken == '0'){
                nextToken();
                if(Character.isDigit(inputToken) ){
                    throw new RuntimeException("syntax error");      }
                x = 0;
            }
            else{
                String s = "";
                s += inputToken;
                nextToken();
                while(Character.isDigit(inputToken)){
                    s += inputToken;
                    nextToken();
                }
                x = Integer.parseInt(s);
            }
            return x;
       }
       else if(Character.isLetter(inputToken) || inputToken == '_'){
            String temp="";
            temp+=inputToken;
            
            nextToken();
            while(Character.isLetter(inputToken)|| inputToken =='_' ){
                temp+=inputToken;
                nextToken();
            }
            return Program.getExp(temp);
        
       }  
       else{
           throw new RuntimeException("syntax error");
       }         
                  
   }
  
    static int apply(char op, int x, int y){
        int z = 0;
        switch (op){
            case '+': z = x + y; break;
            case '-': z = x - y; break;
            case '*': z = x * y; break;
            case '/': z = x / y; break;
        }
        return z;
    }
}