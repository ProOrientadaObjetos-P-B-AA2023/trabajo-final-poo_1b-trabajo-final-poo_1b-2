package paquete01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale; 
 import java.util.Scanner; 
 import paquete02.*; 
 import paquete03.*; 
 import paquete04.*; 
 import paquete05.*; 
 import paquete06.*;
public class Inmobiliaria {
    private static String nombrePropietario;
    private static String apellidoPropietario; 
    private static String idPropietario;
    private static String nombreCiudad; 
    private static String provincia; 
    private static double pMetrosC; 
    private static double metroC; 
    private static String nombreBarrio; 
    private static String referencia; 
    private static String nombreConstructora; 
    private static int idConstructora; 
    private static byte cuartos;
    private static String fileCasa = "casas.dat"; 
    private static String filePropietario = "propietarios.dat"; 
    private static String fileConstructora = "constructoras.dat"; 
    private static String fileCiudad = "ciudades.dat"; 
    private static String fileBarrio = "barrios.dat";
    private static String fileDepartamento = "departamentos.dat";
    private static Scanner sc = new Scanner(System.in);
    public static void datosProp() {
        System.out.print("\nIngrese el nombre del propietario: "); 
         nombrePropietario = sc.nextLine(); 
         System.out.print("Ingrese el apellidos del propietario: "); 
         apellidoPropietario = sc.nextLine(); 
         System.out.print("Ingrese la ID del propietario: "); 
         idPropietario = sc.nextLine(); 
         System.out.print("Ingrese el precio del metro cuadrado: "); 
         pMetrosC = sc.nextDouble(); 
         System.out.print("Ingrese el número de metros cuadrados: "); 
         metroC = sc.nextDouble(); 
         System.out.print("Ingrese el numero de cuartos: "); 
         cuartos = sc.nextByte(); 
    } 
    public static void datosBarrio(){
        System.out.print("Ingrese el nombre del barrio: "); 
         nombreBarrio = sc.nextLine(); 
         System.out.print("Ingrese el una referencia: "); 
         referencia = sc.nextLine();
    }
    public static void datosCiudad(){
        System.out.print("Ingrese el nombre de la ciudad: "); 
         nombreCiudad = sc.nextLine(); 
         System.out.print("Ingrese el nombre de la provincia: "); 
         provincia = sc.nextLine();
    }
    public static void datosConstructora(){
        System.out.print("Ingrese el nombre de la constructora: "); 
        nombreConstructora = sc.nextLine(); 
        System.out.print("Ingrese el ID de la constructora: "); 
        idConstructora = sc.nextInt(); 
    }
    public static void paseDatosCasa(String filePropietario, String fileConstructora, String fileCiudad, String fileBarrio, String fileCasa ){
        Propietario propietario = new Propietario(nombrePropietario,apellidoPropietario, idPropietario); 
         Constructora constructora = new Constructora(nombreConstructora,idConstructora); 
         Ciudad ciudad = new Ciudad(nombreCiudad, provincia); 
         Barrio barrio = new Barrio(nombreBarrio, referencia); 
  
         Casa casa = new Casa(propietario, pMetrosC, metroC,cuartos, barrio, ciudad, constructora); 
         casa.calcularCostoFinal();
         
         EscProp escProp= new EscProp(filePropietario); 
         escProp.setRegistro(propietario);
         
         EscConstructora escConstructora= new EscConstructora(fileConstructora); 
         escConstructora.establecerRegistro(constructora);
         
         EscCiudad escCiudad= new EscCiudad(fileCiudad); 
         escCiudad.establecerRegistro(ciudad);
         
         EscBarrio escBarrio = new EscBarrio(fileBarrio); 
         escBarrio.setRegistro(barrio);
         
         EscCasa escCasa = new EscCasa(fileCasa); 
         escCasa.establecerRegistro(casa);
  
    }
    public static void paseDatosDepar(String filePropietario, String fileConstructora, String fileCiudad, String fileBarrio, String fileDepartamento, double alicuota, String nomEdificio, String ubiEnEdificio){
        Propietario propietario = new Propietario(nombrePropietario,apellidoPropietario, idPropietario); 
         Constructora constructora = new Constructora(nombreConstructora,idConstructora); 
         Ciudad ciudad = new Ciudad(nombreCiudad, provincia); 
         Barrio barrio = new Barrio(nombreBarrio, referencia);
         Departamento departamento = new Departamento(propietario, pMetrosC, metroC,alicuota, barrio, ciudad, nomEdificio,ubiEnEdificio, constructora); 
         departamento.calcularCostoFinal(); 
  
         EscProp escProp= new EscProp(filePropietario); 
         escProp.setRegistro(propietario);
         
         EscCiudad escCiudad= new EscCiudad(fileCiudad); 
         escCiudad.establecerRegistro(ciudad);
         
         EscDepartamento escDepartamento= new EscDepartamento(fileDepartamento); 
         escDepartamento.establecerRegistro(departamento);
  
         EscConstructora escConstructora = new EscConstructora(fileConstructora); 
         escConstructora.establecerRegistro(constructora);
         
         EscBarrio escBarrio= new EscBarrio(fileBarrio); 
         escBarrio.setRegistro(barrio); 
         
    }
    
     public static void ingresarCasa(){
         datosProp();
         sc.nextLine();
         datosConstructora();
         sc.nextLine(); 
         datosCiudad();
         datosBarrio();
         paseDatosCasa(filePropietario, fileConstructora, fileCiudad, fileBarrio, fileCasa);
     } 
  
     public static void ingresarDepartamento() {
         double alicuota; 
         String nomEdificio; 
         String ubiEnEdificio;
         datosProp();
         System.out.print("Ingrese el valor de la alicuota: "); 
         alicuota = sc.nextDouble(); 
         sc.nextLine(); 
         System.out.print("Ingrese el nombre del edificio: "); 
         nomEdificio = sc.nextLine(); 
         System.out.print("Ingrese la ubicación del departamento: "); 
         ubiEnEdificio = sc.nextLine(); 
         datosConstructora();
         sc.nextLine(); 
         datosCiudad();
         datosBarrio();
  
         paseDatosDepar(filePropietario, fileConstructora, fileCiudad, fileBarrio, fileDepartamento, alicuota, nomEdificio, ubiEnEdificio);
  
     }
     public static void registroDepartamentos() {
         LecDepartamento lecDepartamento= new LecDepartamento(fileDepartamento); 
         lecDepartamento.setLDepartamentos(); 
         System.out.println(lecDepartamento); 
         lecDepartamento.cerrarArchivo(); 
     } 
  
     public static void registroPropietarios() {
         LecProp lecProp= new LecProp(filePropietario); 
         lecProp.setLPropietarios(); 
         System.out.println(lecProp); 
         lecProp.cerrarArchivo(); 
     } 
  
     public static void visualizarPropietarioId() { 
         System.out.print("\nIngrese la ID del propietario: "); 
         String id = sc.nextLine();
         LecProp lecProp= new LecProp(filePropietario); 
         lecProp.setLPropietarios();
         Propietario propietario = lecProp.getPropietraio(id);
         if (propietario != null) { 
             System.out.println(propietario); 
         } else { 
             System.out.println("\nno se encontro la ID\n"); 
         }
         lecProp.cerrarArchivo(); 
     } 
  
     public static void registroConstructoras() {
         LecConstructora lecConstructora= new LecConstructora(fileConstructora); 
         lecConstructora.setLConstructoras(); 
         System.out.println(lecConstructora); 

     } 
  
     public static void registroConstructoraId() {
         System.out.print("\nIngrese la ID constructora: "); 
         int id = sc.nextInt();
         LecConstructora lecConstructora= new LecConstructora(fileConstructora); 
         lecConstructora.setLConstructoras();
         Constructora constructora = lecConstructora.obtenerConstructora(id);
         if (constructora != null) { 
             System.out.println(constructora); 
         } else { 
             System.out.println("\n no se encontro la ID\n"); 
         }
     }
     public static void registroCiudades() {
         LecCiudad lecCiudad= new LecCiudad(fileCiudad); 
         lecCiudad.setLCiudades(); 
         System.out.println(lecCiudad); 

     }
     public static void registroCasas() {
         LecCasa lecCasa = new LecCasa(fileCasa); 
         lecCasa.setLCasas(); 
         System.out.println(lecCasa); 

     } 
     public static void registroBarrios() { 
         LecBarrio lecBarrio= new LecBarrio(fileBarrio); 
         lecBarrio.setLBarrios(); 
         System.out.println(lecBarrio);
     }
 }
     
    

