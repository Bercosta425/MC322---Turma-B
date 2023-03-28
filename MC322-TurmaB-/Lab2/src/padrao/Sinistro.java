package padrao;

public class Sinistro {
    private String data;
       private String endereco;
       private int id;
       private static int qtd = 0;

       /*Nesse caso, para garantir a unicidade do ID, definiu-se uma variável "static qtd", para armazenar
        quantas instâncias foram criadas. Assim define-se o id como "qtd" para quando é criada a instância.*/
       public Sinistro(String data, String endereco){
           this.data = data;
           this.endereco = endereco;
           this.id = qtd;
           qtd++;
       }
       
       // Métodos setters e getters
       public String getData(){
           return data;
       }

       public String getEndereco(){
           return endereco;
       }

       public int getId(){
           return id;
       }

       public void setData(String data){
           this.data = data;
       }

       public void setEndereco(String endereco){
           this.endereco = endereco;
       }
       
       public String toString() {
           return "Data: " + getData() + "\nEndereco: " + getEndereco() + "\nID: " + getId();
       }
}
