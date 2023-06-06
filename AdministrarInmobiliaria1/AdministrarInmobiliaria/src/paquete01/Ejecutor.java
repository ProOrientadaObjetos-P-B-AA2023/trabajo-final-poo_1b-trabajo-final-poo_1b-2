package paquete01; 
  
 import java.util.Locale; 
 import java.util.Scanner; 
 import paquete02.*; 
 import paquete03.*; 
 import paquete04.*; 
 import paquete05.*; 
 import paquete06.*; 
  
 public class Ejecutor { 
  
     public static void main(String[] args) { 
  
         Scanner ent = new Scanner(System.in); 
         int opcion; 
         boolean bandera = true; 
  
         while (bandera) { 
             System.out.print("Sistema GESTION INMOBILIARIA\n" 
                     + "+-------------------------------------------------+\n" 
                     + "1.  Ingresar Casa\n" 
                     + "2.  Ingresar Departamento\n" 
                     + "3.  Visualizar Casas\n" 
                     + "4.  Visualizar Departamentos\n" 
                     + "5.  Visualizar Propietarios\n" 
                     + "6.  Visualizar Propietario por Identificación\n" 
                     + "7.  Visualizar Constructoras\n" 
                     + "8.  Visualizar Constructora por ID de empresa\n" 
                     + "9.  Visualizar Ciudades\n" 
                     + "10. Visualizar Ciudad por nombre de ciudad\n" 
                     + "11. Visualizar Barrios\n" 
                     + "12. Visualizar Barrio por nombre de barrio\n" 
                     + "0.  Salir\n" 
                     + "+-------------------------------------------------+\n" 
                     + ">> "); 
             opcion = ent.nextInt(); 
  
             switch (opcion) { 
                 case 0: 
                     bandera = false; 
                     break; 
                 case 1: 
                     ingresarCasa(); 
                     break; 
                 case 2: 
                     ingresarDepartamento(); 
                     break; 
                 case 3: 
                     visualizarCasas(); 
                     break; 
                 case 4: 
                     visualizarDepartamentos(); 
                     break; 
                 case 5: 
                     visualizarPropietarios(); 
                     break; 
                 case 6: 
                     visualizarPropietarioId(); 
                     break; 
                 case 7: 
                     visualizarConstructoras(); 
                     break; 
                 case 8: 
                     visualizarConstructoraId(); 
                     break; 
                 case 9: 
                     visualizarCiudades(); 
                     break; 
                 case 10: 
                     visualizarCiudadNombre(); 
                     break; 
                 case 11: 
                     visualizarBarrios(); 
                     break; 
                 case 12: 
                     visualizarBarrioNombre(); 
                     break; 
                 default: 
                     System.err.println("Error, esa opción no existe.."); 
                     ; 
             } 
         } 
     } 
  
     public static void ingresarCasa() { 
         Scanner ent = new Scanner(System.in); 
         ent.useLocale(Locale.US); 
  
         String arcCasa = "casas.dat"; 
         String arcPropietario = "propietarios.dat"; 
         String arcConstructora = "constructoras.dat"; 
         String arcCiudad = "ciudades.dat"; 
         String arcBarrio = "barrios.dat"; 
  
         String nomPropietario; 
         String apePropietario; 
         String idPropietario; 
         double precioMetroC; 
         double nMetroC; 
         int nCuartos; 
         String nomConstructora; 
         int idConstructora; 
         String nomCiudad; 
         String nomProvincia; 
         String nomBarrio; 
         String nomReferencia; 
  
         System.out.print("\nIngrese los nombres del propietario: "); 
         nomPropietario = ent.nextLine(); 
         System.out.print("Ingrese los apellidos del propietario: "); 
         apePropietario = ent.nextLine(); 
         System.out.print("Ingrese la identificación del propietario: "); 
         idPropietario = ent.nextLine(); 
         System.out.print("Ingrese el precio por metro cuadrado: "); 
         precioMetroC = ent.nextDouble(); 
         System.out.print("Ingrese el número de metros cuadrados: "); 
         nMetroC = ent.nextDouble(); 
         System.out.print("Ingrese el nro. de cuartos de la casa: "); 
         nCuartos = ent.nextInt(); 
         ent.nextLine(); 
         System.out.print("Ingrese el nombre de la constructora: "); 
         nomConstructora = ent.nextLine(); 
         System.out.print("Ingrese el ID empresarial (Número entero)" 
                 + " de la constructora: "); 
         idConstructora = ent.nextInt(); 
         ent.nextLine(); 
         System.out.print("Ingrese el nombre de la ciudad: "); 
         nomCiudad = ent.nextLine(); 
         System.out.print("Ingrese el nombre de la provincia: "); 
         nomProvincia = ent.nextLine(); 
         System.out.print("Ingrese el nombre del barrio: "); 
         nomBarrio = ent.nextLine(); 
         System.out.print("Ingrese el una referencia: "); 
         nomReferencia = ent.nextLine(); 
  
         Propietario propietario = new Propietario(nomPropietario, 
                 apePropietario, idPropietario); 
         Constructora constructora = new Constructora(nomConstructora, 
                 idConstructora); 
         Ciudad ciudad = new Ciudad(nomCiudad, nomProvincia); 
         Barrio barrio = new Barrio(nomBarrio, nomReferencia); 
  
         Casa casa = new Casa( 
                 propietario, precioMetroC, nMetroC, 
                 nCuartos, barrio, ciudad, constructora); 
         casa.calcularCostoFinal(); 
  
         EscProp escrituraArcPropietario 
                 = new EscProp(arcPropietario); 
         escrituraArcPropietario.establecerRegistro(propietario); 
         escrituraArcPropietario.establecerSalida(); 
         escrituraArcPropietario.cerrarArchivo(); 
  
         EscConstructora escrituraArcConstructora 
                 = new EscConstructora(arcConstructora); 
         escrituraArcConstructora.establecerRegistro(constructora); 
         escrituraArcConstructora.establecerSalida(); 
         escrituraArcConstructora.cerrarArchivo(); 
  
         EscCiudad escrituraArcCiudad 
                 = new EscCiudad(arcCiudad); 
         escrituraArcCiudad.establecerRegistro(ciudad); 
         escrituraArcCiudad.establecerSalida(); 
         escrituraArcCiudad.cerrarArchivo(); 
  
         EscBarrio escrituraArcBarrio 
                 = new EscBarrio(arcBarrio); 
         escrituraArcBarrio.establecerRegistro(barrio); 
         escrituraArcBarrio.establecerSalida(); 
         escrituraArcBarrio.cerrarArchivo(); 
  
         EscCasa escrituraArcCasa 

                 = new EscCasa(arcCasa); 
         escrituraArcCasa.establecerRegistro(casa); 
         escrituraArcCasa.establecerSalida(); 
         escrituraArcCasa.cerrarArchivo(); 
  
         System.out.println("\nArchivos ingresados correctamente!\n"); 
  
     } 
  
     public static void ingresarDepartamento() { 
         Scanner ent = new Scanner(System.in); 
         ent.useLocale(Locale.US); 
  
         String arcDepartamento = "departamentos.dat"; 
         String arcPropietario = "propietarios.dat"; 
         String arcConstructora = "constructoras.dat"; 
         String arcCiudad = "ciudades.dat"; 
         String arcBarrio = "barrios.dat"; 
  
         String nomPropietario; 
         String apePropietario; 
         String idPropietario; 
         double precioMetroC; 
         double nMetroC; 
         double alicuota; 
         String nomEdificio; 
         String ubiEnEdificio; 
         String nomConstructora; 
         int idConstructora; 
         String nomCiudad; 
         String nomProvincia; 
         String nomBarrio; 
         String nomReferencia; 
  
         System.out.print("\nIngrese los nombres del propietario: "); 
         nomPropietario = ent.nextLine(); 
         System.out.print("Ingrese los apellidos del propietario: "); 
         apePropietario = ent.nextLine(); 
         System.out.print("Ingrese la identificación del propietario: "); 
         idPropietario = ent.nextLine(); 
         System.out.print("Ingrese el precio por metro cuadrado: "); 
         precioMetroC = ent.nextDouble(); 
         System.out.print("Ingrese el número de metros cuadrados: "); 
         nMetroC = ent.nextDouble(); 
         System.out.print("Ingrese el valor de la alicuota: "); 
         alicuota = ent.nextDouble(); 
         ent.nextLine(); 
         System.out.print("Ingrese el nombre del edificio: "); 
         nomEdificio = ent.nextLine(); 
         System.out.print("Ingrese la ubicación del departamento" 
                 + " en el edificio: "); 
         ubiEnEdificio = ent.nextLine(); 
         System.out.print("Ingrese el nombre de la constructora: "); 
         nomConstructora = ent.nextLine(); 
         System.out.print("Ingrese el ID empresarial (Número entero)" 
                 + " de la constructora: "); 
         idConstructora = ent.nextInt(); 
         ent.nextLine(); 
         System.out.print("Ingrese el nombre de la ciudad: "); 
         nomCiudad = ent.nextLine(); 
         System.out.print("Ingrese el nombre de la provincia: "); 
         nomProvincia = ent.nextLine(); 
         System.out.print("Ingrese el nombre del barrio: "); 
         nomBarrio = ent.nextLine(); 
         System.out.print("Ingrese el una referencia: "); 
         nomReferencia = ent.nextLine(); 
  
         Propietario propietario = new Propietario(nomPropietario, 
                 apePropietario, idPropietario); 
         Constructora constructora = new Constructora(nomConstructora, 
                 idConstructora); 
         Ciudad ciudad = new Ciudad(nomCiudad, nomProvincia); 
         Barrio barrio = new Barrio(nomBarrio, nomReferencia); 
  
         Departamento departamento = new Departamento( 
                 propietario, precioMetroC, nMetroC, 
                 alicuota, barrio, ciudad, nomEdificio, 
                 ubiEnEdificio, constructora); 
         departamento.calcularCostoFinal(); 
  
         EscProp escrituraArcPropietario 
                 = new EscProp(arcPropietario); 
         escrituraArcPropietario.establecerRegistro(propietario); 
         escrituraArcPropietario.establecerSalida(); 
         escrituraArcPropietario.cerrarArchivo(); 
  
         EscConstructora escrituraArcConstructora 
                 = new EscConstructora(arcConstructora); 
         escrituraArcConstructora.establecerRegistro(constructora); 
         escrituraArcConstructora.establecerSalida(); 
         escrituraArcConstructora.cerrarArchivo(); 
  
         EscCiudad escrituraArcCiudad 
                 = new EscCiudad(arcCiudad); 
         escrituraArcCiudad.establecerRegistro(ciudad); 
         escrituraArcCiudad.establecerSalida(); 
         escrituraArcCiudad.cerrarArchivo(); 
  
         EscBarrio escrituraArcBarrio 
                 = new EscBarrio(arcBarrio); 
         escrituraArcBarrio.establecerRegistro(barrio); 
         escrituraArcBarrio.establecerSalida(); 
         escrituraArcBarrio.cerrarArchivo(); 
  
         EscDepartamento escrituraArcDepartamento 
                 = new EscDepartamento(arcDepartamento); 
         escrituraArcDepartamento.establecerRegistro(departamento); 
         escrituraArcDepartamento.establecerSalida(); 
         escrituraArcDepartamento.cerrarArchivo(); 
  
         System.out.println("\nArchivos ingresados correctamente!\n"); 
  
     } 
  
     public static void visualizarCasas() { 
         String arcCasa = "casas.dat"; 
  
         LecCasa lecturaArcCasa = new LecCasa(arcCasa); 
         lecturaArcCasa.establecerListaCasas(); 
         System.out.println(lecturaArcCasa); 
         lecturaArcCasa.cerrarArchivo(); 
     } 
  
     public static void visualizarDepartamentos() { 
         String arcDepartamento = "departamentos.dat"; 
  
         LecDepartamento lecturaArcDepartamento 
                 = new LecDepartamento(arcDepartamento); 
         lecturaArcDepartamento.establecerListaDepartamentos(); 
         System.out.println(lecturaArcDepartamento); 
         lecturaArcDepartamento.cerrarArchivo(); 
     } 
  
     public static void visualizarPropietarios() { 
         String arcPropietario = "propietarios.dat"; 
  
         LecProp lecturaArcPropietario 
                 = new LecProp(arcPropietario); 
         lecturaArcPropietario.establecerListaPropietarios(); 
         System.out.println(lecturaArcPropietario); 
         lecturaArcPropietario.cerrarArchivo(); 
     } 
  
     public static void visualizarPropietarioId() { 
         Scanner ent = new Scanner(System.in); 
  
         String arcPropietario = "propietarios.dat"; 
         System.out.print("\nIngrese la identificación del" 
                 + " propietario a buscar: "); 
         String id = ent.nextLine(); 
  
         LecProp lecturaArcPropietario 
                 = new LecProp(arcPropietario); 
         lecturaArcPropietario.establecerListaPropietarios(); 
  
         Propietario propietario = lecturaArcPropietario.obtenerPropietraio(id); 
  
         if (propietario != null) { 
             System.out.println(propietario); 
         } else { 
             System.out.println("\n*** Lo sentimos, el propietario que busca no se" 
                     + " encuentra dentro de los registros *\n"); 
         } 
  
         lecturaArcPropietario.cerrarArchivo(); 
     } 
  
     public static void visualizarConstructoras() { 
         String arcConstructora = "constructoras.dat"; 
  
         LecConstructora lecturaArcConstructora 
                 = new LecConstructora(arcConstructora); 
         lecturaArcConstructora.establecerListaConstructoras(); 
         System.out.println(lecturaArcConstructora); 
         lecturaArcConstructora.cerrarArchivo(); 
     } 
  
     public static void visualizarConstructoraId() { 
         Scanner ent = new Scanner(System.in); 
  
         String arcConstructora = "constructoras.dat"; 
         System.out.print("\nIngrese la identificación (Número entero)" 
                 + " empresarial de la" 
                 + " constructora a buscar: "); 
         int id = ent.nextInt(); 
  
         LecConstructora lecturaArcConstructora 
                 = new LecConstructora(arcConstructora); 
         lecturaArcConstructora.establecerListaConstructoras(); 
  
         Constructora constructora = lecturaArcConstructora.obtenerConstructora(id); 
  
         if (constructora != null) { 
             System.out.println(constructora); 
         } else { 
             System.out.println("\n*** Lo sentimos, la constructora que busca no se" 
                     + " encuentra dentro de los registros *\n"); 
         } 
         lecturaArcConstructora.cerrarArchivo(); 
     } 
  
     public static void visualizarCiudades() { 
         String arcCiudad = "ciudades.dat"; 
  
         LecCiudad lecturaArcCiudad 
                 = new LecCiudad(arcCiudad); 
         lecturaArcCiudad.establecerListaCiudades(); 
         System.out.println(lecturaArcCiudad); 
         lecturaArcCiudad.cerrarArchivo(); 
  
     } 
  
     public static void visualizarCiudadNombre() { 
         Scanner ent = new Scanner(System.in); 
  
         String arcCiudad = "ciudades.dat"; 
         System.out.print("\nIngrese el nombre de la" 
                 + " ciudad a buscar: "); 
         String nombre = ent.nextLine(); 
  
         LecCiudad lecturaArcCiudad 
                 = new LecCiudad(arcCiudad); 
         lecturaArcCiudad.establecerListaCiudades(); 
  
         Ciudad ciudad = lecturaArcCiudad.obtenerCiudad(nombre); 
  
         if (ciudad != null) { 
             System.out.println(ciudad); 
         }else{ 
             System.out.println("\n*** Lo sentimos, la ciudad que busca no se" 
                     + " encuentra dentro de los registros *\n"); 
         } 
         lecturaArcCiudad.cerrarArchivo(); 
  
     } 
  
     public static void visualizarBarrios() { 
         String arcBarrio = "barrios.dat"; 
  
         LecBarrio lecturaArcBarrio 
                 = new LecBarrio(arcBarrio); 
         lecturaArcBarrio.establecerListaBarrios(); 
         System.out.println(lecturaArcBarrio); 
         lecturaArcBarrio.cerrarArchivo(); 
     } 
  
     public static void visualizarBarrioNombre() { 
         Scanner ent = new Scanner(System.in); 
  
         String arcBarrio = "barrios.dat"; 
         System.out.print("\nIngrese el nombre del" 
                 + " barrio a buscar: "); 
         String nombre = ent.nextLine(); 
  
         LecBarrio lecturaArcBarrio 
                 = new LecBarrio(arcBarrio); 
         lecturaArcBarrio.establecerListaBarrios(); 
  
         Barrio barrio = lecturaArcBarrio.obtenerBarrio(nombre); 
  
         if (barrio != null) { 
             System.out.println(barrio); 
         }else{ 
             System.out.println("\n*** Lo sentimos, el barrio que busca no se" 
                     + " encuentra dentro de los registros *\n"); 
         } 
         lecturaArcBarrio.cerrarArchivo(); 
     } 
 }
