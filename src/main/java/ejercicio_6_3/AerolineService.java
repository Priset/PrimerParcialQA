package ejercicio_6_3;

public class AerolineService {
    public String reservaVuelo(String destino, int cantidad, int dia, int mes, int gestion) {
        if (AerolineaServiceUtils.existenPasajes(destino, cantidad)) {
            String diaSemana = AerolineaServiceUtils.getDay(dia, mes, gestion);
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
        return meses[mes -1];
    }
}
