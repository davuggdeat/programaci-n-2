package Mundial;

public class Partido implements Jugable {

    private String equipoLocal;
    private String equipoVisitante;
    private String fecha;
    private String estadio;
    private int golesLocal;
    private int golesVisitante;

    public Partido(String equipoLocal, String equipoVisitante, String fecha, String estadio) {

        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fecha = fecha;
        this.estadio = estadio;
    }

    @Override
    public void jugarPartido() {

        golesLocal = (int) (Math.random() * 5);
        golesVisitante = (int) (Math.random() * 5);
    }

    @Override
    public void mostrarResultados() {

        System.out.println("--------------------------------------");
        System.out.println("PARTIDO DEL MUNDIAL 2026");
        System.out.println("Fecha: " + fecha);
        System.out.println("Estadio: " + estadio);

        System.out.println(equipoLocal + " " + golesLocal +  " - " + golesVisitante + " " + equipoVisitante);

        if (golesLocal > golesVisitante) {
            System.out.println("Ganador: " + equipoLocal);
        } else if (golesVisitante > golesLocal) {
            System.out.println("Ganador: " + equipoVisitante);
        } else {
            System.out.println("Resultado: Empate");
        }
    }

    public String getGanador() {

        if (golesLocal > golesVisitante)
            return equipoLocal;

        if (golesVisitante > golesLocal)
            return equipoVisitante;

        return "Empate";
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }
}
