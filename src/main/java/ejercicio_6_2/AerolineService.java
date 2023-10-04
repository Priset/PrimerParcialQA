package ejercicio_6_2;

public class AerolineService {
    public boolean existenPasajes(String destino, int cantidad) {
        return true;
    }

    public String getDay(int dia, int mes, int gestion) {
        return "Lunes";
    }

    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion){
        if (existenPasajes(destino, cantidad)) {
            String diaSemana = getDay(dia, mes, gestion);
            String mesTexto = convertirMesATexto(mes);
            return String.format("el dia %s %d %s %d existen %d pasajes para %s", diaSemana, dia, mesTexto, gestion, cantidad, destino);
        } else {
            return String.format("no existen suficientes pasajes para %s", destino);
        }
    }

    private String convertirMesATexto(int mes) {
            String[] meses = {
              "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                    "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
            };
            return meses[mes - 1];
    }
}
