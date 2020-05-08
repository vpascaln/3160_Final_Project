import java.util.regex.*; 
public class Identifier {
  private String s;
  public Identifier(String s){
      this.s = s;
      if(!validated()){
          throw new RuntimeException("error");
      }
  }
  public boolean validated(){
    String regex = "^([a-zA-Z]|_)([a-zA-Z]|_|[0-9])*";
    return Pattern.matches(regex, s);
  }
  public String getIdentifier(){
      return s;
  }
}