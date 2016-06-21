//Un ejemplo facil de como hace los grafos Graphviz
public class GraphvizJava {
	
  public static void main(String[] args) {
    try {
//Aca pones la dirección de donde esta instalado Graphviz->bin->dot.exe      
      String dotPath = "Graphviz2.38\\bin\\dot.exe";
//Aca pones el archivo de entrada(que indica que nodos hay y los arcos entre los nodos)
      String fileInputPath = "auto.txt";
//Aca pones donde queres que se guarde el grafo que se origina
      String fileOutputPath = "grafo1.jpg";
      
      String tParam = "-Tjpg";
      String tOParam = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = dotPath;
      cmd[1] = tParam;
      cmd[2] = fileInputPath;
      cmd[3] = tOParam;
      cmd[4] = fileOutputPath;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
      ex.printStackTrace();
    } finally {
    }

  }
}