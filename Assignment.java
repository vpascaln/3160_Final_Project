public class Assignment {
   private String s;
   private Identifier id; 
   private Expression expr;
   private int expValue;

   public Assignment(String s){
       this.s = s.trim();
        if(!validated()){
          throw new RuntimeException("error");
        }
        s = s.substring(0, s.length()-1);
        String[] temp = s.split("=");
    
        id=new Identifier(temp[0].trim());
        expr=new Expression(temp[1].trim());
        expValue=expr.eval();
     
       Program.addIdentifier( id.getIdentifier(), expValue);

      
   }
   public boolean validated(){
       return s.endsWith(";") && s.contains("=");
   }
   
   public void printAssignment(){
     System.out.println(id.getIdentifier()+" = "+ expValue);
   }

}