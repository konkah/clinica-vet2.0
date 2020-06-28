package view;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
//import caixa.Account;
import controller.Controller;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import model.Cliente;
import model.ClienteDAO;

public class ClinicaVeterinaria implements Observer{
 @Override
 public void update(Observable o, Object arg) {
 System.out.println("Dados Atualizados!!");
 System.out.println(arg);
 }
 public void listaClientes(){
 //Controller.getAllClientes();
 
 }
 
 public void addAnimal() {

 }
 
 
 
 
 public void listaClienteID() {
Scanner sc = new Scanner(System.in);
System.out.print("Digite o ID:" );
int id = sc.nextInt();
Controller.getClienteById(id);


 }
 
 
 
 
 public void addCliente() {
Scanner sc = new Scanner(System.in);
System.out.println("Digite seu nome: ");
String nome = sc.next();
System.out.println("Digite seu endere�o:");
String endereco = sc.next();
String email = "Test@test.com";
System.out.println("Digite seu telefone:");
String telefone = sc.next();
System.out.println("Digite seu Cep:");
String cep = sc.next();
Controller.addCliente(nome,endereco,telefone,cep);
 }
 
 
 public void listaAnimalById(){
 Scanner sc = new Scanner(System.in);
 System.out.println("Digite o Id:");
 int idAnimal= sc.nextInt();
 List animalById = (List) Controller.getAnimalById(idAnimal);
 }
 
 
 public void menuPrincipal(){
 Scanner in = new Scanner(System.in);
 while (true){
 System.out.println("1- Insere Cliente");
 System.out.println("2 - Insere Animal");
 System.out.println("3- Lista Clientes");
 System.out.println("4- Encontrar ID");
 System.out.println("5- Encontra animal por id");
 System.out.println("6-Encerra");
 int opcao = in.nextInt();
 switch (opcao){
 case 1:
addCliente();
 break;
 case 2:
addAnimal();
 case 3:
 listaClientes();
 break;
 case 4:
listaClienteID();
 case 5:
 listaAnimalById();
 break;
 case 6:
return;
 }
 }
 }
 /**
 * @param args the command line arguments
 */
 public static void main(String[] args) {
 new ClinicaVeterinaria().menuPrincipal();
 }
}