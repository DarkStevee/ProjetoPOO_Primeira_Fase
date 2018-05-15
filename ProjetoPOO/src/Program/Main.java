package Program;

public class Main {

   
    public static void main(String[] args) {
        Console centralConsole = new Console("Teste");
        Room room = new Room(23, 20, 50);      
        centralConsole.addRoom(room);
        Wifi wifi = new Wifi();
        centralConsole.act();
        System.out.println(centralConsole.toString());

  
        
        
        
    }  
}
