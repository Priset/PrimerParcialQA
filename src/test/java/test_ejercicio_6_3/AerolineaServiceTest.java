package test_ejercicio_6_3;

import ejercicio_6_3.AerolineService;
import ejercicio_6_3.AerolineaServiceUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class AerolineaServiceTest {
    @Test
    public void testReservaVueloConPasajesDisponibles(){
        try (MockedStatic<AerolineaServiceUtils> utilities = Mockito.mockStatic(AerolineaServiceUtils.class)){
            utilities.when(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2)).thenReturn(true);
            utilities.when(() -> AerolineaServiceUtils.getDay(29,5,2023)).thenReturn("Lunes");

            AerolineService aerolineService = new AerolineService();
            String respuesta = aerolineService.reservaVuelo("La Paz", 2, 29, 5, 2023);

            Assertions.assertEquals("el dia Lunes 29 Mayo 2023 existen 2 pasajes para La Paz", respuesta);

            utilities.verify(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2));
            utilities.verify(() -> AerolineaServiceUtils.getDay(29,5,2023));
        }
    }

    @Test
    public void testReservaVueloSinPasajesDisponibles(){
        try (MockedStatic<AerolineaServiceUtils> utilities = Mockito.mockStatic(AerolineaServiceUtils.class)) {
            utilities.when(() -> AerolineaServiceUtils.existenPasajes("La Paz", 3)).thenReturn(false);

            AerolineService aerolineService = new AerolineService();
            String respuesta = aerolineService.reservaVuelo("La Paz", 3, 29, 5, 2023);

            Assertions.assertEquals("no existen suficientes pasajes para La Paz", respuesta);

            utilities.verify(() -> AerolineaServiceUtils.existenPasajes("La Paz", 3));
        }
    }

    @Test
    public void testReservaVueloDiaDomingo(){
        try (MockedStatic<AerolineaServiceUtils> utilities = Mockito.mockStatic(AerolineaServiceUtils.class)) {
            utilities.when(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2)).thenReturn(true);
            utilities.when(() -> AerolineaServiceUtils.getDay(28, 5, 2023)).thenReturn("Domingo");

            AerolineService aerolineService = new AerolineService();
            String respuesta = aerolineService.reservaVuelo("La Paz", 2, 28, 5, 2023);

            Assertions.assertEquals("el dia Domingo 28 Mayo 2023 existen 2 pasajes para La Paz", respuesta);

            utilities.verify(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2));
            utilities.verify(() -> AerolineaServiceUtils.getDay(28, 5, 2023));
        }
    }

    @Test
    public void testReservaVueloMesDiferente(){
        try (MockedStatic<AerolineaServiceUtils> utilities = Mockito.mockStatic(AerolineaServiceUtils.class)) {
            utilities.when(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2)).thenReturn(true);
            utilities.when(() -> AerolineaServiceUtils.getDay(1, 6, 2023)).thenReturn("Jueves");

            AerolineService aerolineService = new AerolineService();
            String respuesta = aerolineService.reservaVuelo("La Paz", 2, 1, 6, 2023);

            Assertions.assertEquals("el dia Jueves 1 Junio 2023 existen 2 pasajes para La Paz", respuesta);

            utilities.verify(() -> AerolineaServiceUtils.existenPasajes("La Paz", 2));
            utilities.verify(() -> AerolineaServiceUtils.getDay(1, 6, 2023));
        }
    }
}
