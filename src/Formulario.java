import javax.swing.JFrame;


public class Formulario extends JFrame {
	Formulario(){
		DataAcces da = new DataAcces("MYSQL");
		da.setUser("root");
		da.setPassword("root");
		da.setIpServer("localhost");
		da.setDatabase("concesionaria");
		
		da.conectar();
		da.getData("select * from cliente");
		
		
	}
}
