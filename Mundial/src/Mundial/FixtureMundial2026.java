package Mundial;

import java.util.Scanner;

public class FixtureMundial2026 {

    public static void main (String[] args) {
    
    Scanner teclado = new Scanner(System.in);	
    	Grupo grupoA = new Grupo("A",
                new String[]{"México", "Sudáfrica", "Corea del Sur", "Chequia"});

        Grupo grupoB = new Grupo("B",
                new String[]{"Canadá", "Suiza", "Qatar", " Bosnia"});

        Grupo grupoC = new Grupo("C",
                new String[]{"Brasil", "Marruecos", "Haití", "Escocia"});

        Grupo grupoD = new Grupo("D",
                new String[]{"Estados Unidos", "Paraguay", "Australia", "Turquía"});

        Grupo grupoE = new Grupo("E",
                new String[]{"Alemania", "Curazao", "Costa de Marfil", "Ecuador"});

        Grupo grupoF = new Grupo("F",
                new String[]{"Países Bajos", "Japón", "Suecia", "Túnez"});

        Grupo grupoG = new Grupo("G",
                new String[]{"Bélgica", "Egipto", "Irán", "Nueva Zelanda"});

        Grupo grupoH = new Grupo("H",
                new String[]{"España", "Cabo Verde", "Arabia Saudita", "Uruguay"});

        Grupo grupoI = new Grupo("I",
                new String[]{"Francia", "Senegal", "Irak", "Noruega"});

        Grupo grupoJ = new Grupo("J",
                new String[]{"Argentina", "Argelia", "Austria", "Jordania"});

        Grupo grupoK = new Grupo("K",
                new String[]{"Portugal", "RD Congo", "Uzbekistán", "Colombia"});

        Grupo grupoL = new Grupo("L",
                new String[]{"Inglaterra", "Croacia", "Ghana", "Panamá"});

        Grupo[] grupos = {
                grupoA, grupoB, grupoC, grupoD,
                grupoE, grupoF, grupoG, grupoH,
                grupoI, grupoJ, grupoK, grupoL
        };
        
        System.out.println("==================================");
        System.out.println("          MUNDIAL 2026            ");
        System.out.println("==================================");
        
        for (Grupo grupo : grupos) { 
        	
            System.out.println("GRUPO " + grupo.getNombre());

            for(String pais : grupo.getPaises()) {
                System.out.println("- " + pais);
            }
        }   
        System.out.println("Ingrese la letra del grupo que desea seguir:");
        String opcion = teclado.next().toUpperCase();

        Grupo grupoElegido = null;
        
        switch(opcion) {

        case "A": grupoElegido = grupoA; break;
        case "B": grupoElegido = grupoB; break;
        case "C": grupoElegido = grupoC; break;
        case "D": grupoElegido = grupoD; break;
        case "E": grupoElegido = grupoE; break;
        case "F": grupoElegido = grupoF; break;
        case "G": grupoElegido = grupoG; break;
        case "H": grupoElegido = grupoH; break;
        case "I": grupoElegido = grupoI; break;
        case "J": grupoElegido = grupoJ; break;
        case "K": grupoElegido = grupoK; break;
        case "L": grupoElegido = grupoL; break;

        default:
            System.out.println("Grupo inválido");
            System.exit(0);
    }
        grupoElegido.mostrarGrupo();
        
        teclado.nextLine();
        
        System.out.println("¿Qué país desa seguir?");
        String paisElegido = teclado.nextLine();
        
        String[] equipos = grupoElegido.getPaises();
        
        //Estadios donde se juega el mundial (sin expesificar el pais)
        
        String[] estadios = {
        		
        		 "Estadio Azteca",
                 "MetLife Stadium",
                 "SoFi Stadium",
                 "AT&T Stadium",
                 "Mercedes-Benz Stadium",
                 "NRG Stadium",
                 "BC Place",
                 "BMO Field",
                 "Lumen Field",
                 "Hard Rock Stadium",
                 "Lincoln Financial Field",
                 "Levi's Stadium",
                 "Estadio BBVA",
                 "Estadio Akron",
                 "Arrowhead Stadium",
                 "Gillette Stadium"
         };
        
        String[] fechas = {
                "11/06/2026",
                "15/06/2026",
                "19/06/2026",
                "23/06/2026",
                "27/06/2026",
                "30/06/2026"
        };
        
        int contador = 0;
        
        System.out.println("=================================");
        System.out.println("       FASE DE GRUPOS");
        System.out.println("=================================");

        for(int i = 0; i < equipos.length; i++) {

            for(int j = i + 1; j < equipos.length; j++) {

                Partido partido = new Partido(
                        equipos[i],
                        equipos[j],
                        fechas[contador % fechas.length],
                        estadios[contador % estadios.length]);

                partido.jugarPartido();

                if(equipos[i].equalsIgnoreCase(paisElegido)
                        || equipos[j].equalsIgnoreCase(paisElegido)) {

                    partido.mostrarResultados();
                }

                contador++;
            }
        }
        
        String[] octavos = {
                "México","Suecia",
                "Brasil","Estados Unidos",
                "Alemania","Países Bajos",
                "Bélgica","Uruguay",
                "Francia","Argentina",
                "Portugal","Inglaterra",
                "España","Colombia",
                "Croacia","Japón"
        };

        System.out.println("=================================");
        System.out.println("      OCTAVOS DE FINAL");
        System.out.println("=================================");

        String[] cuartos = new String[8];

        int pos = 0;

        for(int i = 0; i < octavos.length; i += 2) {

            cuartos[pos] =
                    jugarEliminatoria(octavos[i], octavos[i + 1]);

            pos++;
        }

        System.out.println("=================================");
        System.out.println("      CUARTOS DE FINAL");
        System.out.println("=================================");

        String[] semifinales = new String[4];

        pos = 0;

        for(int i = 0; i < cuartos.length; i += 2) {

            semifinales[pos] =
                    jugarEliminatoria(cuartos[i], cuartos[i + 1]);

            pos++;
        }

        System.out.println("=================================");
        System.out.println("         SEMIFINALES");
        System.out.println("=================================");

        String[] finalistas = new String[2];

        pos = 0;

        for(int i = 0; i < semifinales.length; i += 2) {

            finalistas[pos] =
                    jugarEliminatoria(semifinales[i], semifinales[i + 1]);

            pos++;
        }

        System.out.println("=================================");
        System.out.println("            FINAL");
        System.out.println("=================================");

        String campeon =
                jugarEliminatoria(finalistas[0], finalistas[1]);

        System.out.println("#################################");
        System.out.println(" CAMPEÓN DEL MUNDO FIFA 2026");
      
        System.out.println(" " + campeon +" ");
        System.out.println("#################################");
        teclado.close();
    }

         
        public static String jugarEliminatoria(String equipo1, String equipo2) {

            int goles1 = (int)(Math.random() * 5);
            int goles2 = (int)(Math.random() * 5);

            System.out.println(" " + equipo1 + " " + goles1 + " - " + goles2 + " " + equipo2);

            if(goles1 > goles2) {
                System.out.println("Clasifica: " + equipo1);
                return equipo1;
            }

            if(goles2 > goles1) {
                System.out.println("Clasifica: " + equipo2);
                return equipo2;
            }

            String ganador =
                    Math.random() < 0.5 ? equipo1 : equipo2;

            System.out.println("Empate. Clasifica por penales: " + ganador);

            return ganador;
        }
}
