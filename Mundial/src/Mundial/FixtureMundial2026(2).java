package Mundial;

import java.util.Scanner;

public class FixtureMundial2026 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Grupos del mundial
        Grupo[] grupos = {
            new Grupo("A", new String[]{"México", "Sudáfrica", "Corea del Sur", "Chequia"}),
            new Grupo("B", new String[]{"Canadá", "Suiza", "Qatar", "Bosnia"}),
            new Grupo("C", new String[]{"Brasil", "Marruecos", "Haití", "Escocia"}),
            new Grupo("D", new String[]{"Estados Unidos", "Paraguay", "Australia", "Turquía"}),
            new Grupo("E", new String[]{"Alemania", "Curazao", "Costa de Marfil", "Ecuador"}),
            new Grupo("F", new String[]{"Países Bajos", "Japón", "Suecia", "Túnez"}),
            new Grupo("G", new String[]{"Bélgica", "Egipto", "Irán", "Nueva Zelanda"}),
            new Grupo("H", new String[]{"España", "Cabo Verde", "Arabia Saudita", "Uruguay"}),
            new Grupo("I", new String[]{"Francia", "Senegal", "Irak", "Noruega"}),
            new Grupo("J", new String[]{"Argentina", "Argelia", "Austria", "Jordania"}),
            new Grupo("K", new String[]{"Portugal", "RD Congo", "Uzbekistán", "Colombia"}),
            new Grupo("L", new String[]{"Inglaterra", "Croacia", "Ghana", "Panamá"})
        };

        System.out.println("==================================          MUNDIAL 2026        ==================================");
        for (Grupo g : grupos) g.mostrarGrupo();

        //busqueda directa en el arreglo de grupos
        System.out.println("Ingrese la letra del grupo que desea seguir:");
        String opcion = teclado.next().toUpperCase();
        Grupo grupoElegido = null;

        for (Grupo g : grupos) {
            if (g.getNombre().equals(opcion)) {
                grupoElegido = g;
                break;
            }
        }

        if (grupoElegido == null) {
            System.out.println("Grupo inválido");
            System.exit(0);
        }

        teclado.nextLine();
        System.out.println("¿Qué país desea seguir?");
        String paisElegido = teclado.nextLine();

       
        String[] estadios = {"Estadio Azteca", "MetLife Stadium", "SoFi Stadium", "AT&T Stadium", "Mercedes-Benz Stadium"};
        String[] fechas = {"11/06/2026", "15/06/2026", "19/06/2026", "23/06/2026", "27/06/2026"};
        String[] equipos = grupoElegido.getPaises();
        int contador = 0;

        System.out.println("=================================       FASE DE GRUPOS     =================================");
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i + 1; j < equipos.length; j++) {
                Partido partido = new Partido(equipos[i], equipos[j], fechas[contador % fechas.length], estadios[contador % estadios.length]);
                partido.jugarPartido();

                if (equipos[i].equalsIgnoreCase(paisElegido) || equipos[j].equalsIgnoreCase(paisElegido)) {
                    partido.mostrarResultados();
                }
                contador++;
            }
        }

        // Estos paises se mantienen no son aleatorios 
        String[] faseActual = {
            "México", "Suecia", "Brasil", "Estados Unidos", "Alemania", "Países Bajos", "Bélgica", "Uruguay",
            "Francia", "Argentina", "Portugal", "Inglaterra", "España", "Colombia", "Croacia", "Japón"
        };
        
        String[] nombresFases = {"OCTAVOS DE FINAL", "CUARTOS DE FINAL", "SEMIFINALES", "FINAL"};

        for (String nombreFase : nombresFases) {
            System.out.println("=================================      " + nombreFase +    "=================================");
            String[] proximaFase = new String[faseActual.length / 2];
            int pos = 0;
            for (int i = 0; i < faseActual.length; i += 2) {
                proximaFase[pos++] = jugarEliminatoria(faseActual[i], faseActual[i + 1]);
            }
            faseActual = proximaFase; // Para avanzar a la siguiente ronda 
        }

        System.out.println("################################# CAMPEÓN DEL MUNDO FIFA 2026 " + faseActual[0] + " #################################");
        teclado.close();
    }

    public static String jugarEliminatoria(String equipo1, String equipo2) {
        int g1 = (int) (Math.random() * 5);
        int g2 = (int) (Math.random() * 5);
        System.out.println(" " + equipo1 + " " + g1 + " - " + g2 + " " + equipo2);

        if (g1 > g2) { System.out.println("Clasifica: " + equipo1); return equipo1; }
        if (g2 > g1) { System.out.println("Clasifica: " + equipo2); return equipo2; }

        String ganador = Math.random() < 0.5 ? equipo1 : equipo2;
        System.out.println("Empate. Clasifica por penales: " + ganador);
        return ganador;
    }
}
