/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaLambda;

public class PruebaCalculadora {
    
   
    
    public PruebaCalculadora(){
        
        
         //1er método, definimos clases distintas a partir de un interfaz
         // y usamos cada una de ellas
         OperacionInterface opSuma=new CalculoSuma();
         OperacionInterface opResta=new CalculoResta();
                
         System.out.println(opSuma.operacion(5, 6));
         System.out.println(opResta.operacion(5,6));
         
   
         
         
         
         
         //2º método. En vez de crear clases que implementan un interfaz
         //implementamos el interfaz directamente a traves de clases anónimas
         
         OperacionInterface opSuma2 =new OperacionInterface(){
                    @Override
                   public int operacion(int a, int b){
                       return a+b;
                    }
         };
                   
         OperacionInterface opResta2 =new OperacionInterface(){
                    @Override
                   public int operacion(int a, int b){
                       return a-b;
                        }
                   
         };
         
         
         System.out.println(opSuma2.operacion(5, 6));
         System.out.println(opResta2.operacion(5,6));
        
         
         
         //3er método. El código anterior es una clase anónima que implementa
         //una interfaz que solo tiene una función.
         //Eso es justamente una expresión lambda. Representa a una función anónima.
         
         OperacionInterface opSuma3 =(int a, int b) -> a+b;
         OperacionInterface opResta3 =(int a, int b) -> a-b;
         
         
         //esto no se puede hacer en Java. Da error:
         //  (int,int)->int opResta4 =(int a, int b) -> a-b;
         // Hay que hacerlo a través
         // de una interfaz que defina la expresion lambda
         
         
         System.out.println(opSuma3.operacion(5, 6));
         System.out.println(opResta3.operacion(5,6));
         
       
   
    }
             
                   
                   
}
                   
        
        
    
         
         
        
    
    
    
    

    
    
    
    

