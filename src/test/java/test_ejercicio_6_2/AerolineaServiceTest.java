package test_ejercicio_6_2;

import ejercicio_6_2.AerolineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AerolineaServiceTest {
    @Test
    public void testReservaVueloConPasajeDisponibles(){
        AerolineService aerolineService = Mockito.spy(new AerolineService());

        Mockito.doReturn(true).when(aerolineService).existenPasajes("La Paz", 2);
        Mockito.doReturn("Lunes").when(aerolineService).getDay(29, 5,2023);

        String respuesta = aerolineService.reservaVuelo("La Paz", 2, 29, 5, 2023);
        Assertions.assertEquals("el dia Lunes 29 de Mayo 2023 existen 2 pasajes para La Paz", respuesta);

        Mockito.verify(aerolineService).existenPasajes("La Paz", 2);
        Mockito.verify(aerolineService).getDay(29, 5, 2023);
    }

    @Test
    public void testReservaVueloSinPasajesDisponibles(){
        AerolineService aerolineService = Mockito.spy(new AerolineService());

        Mockito.doReturn(false).when(aerolineService.existenPasajes("La Paz",3));
        String respuesta = aerolineService.reservaVuelo("La Paz", 3, 15, 6, 2023);
        Assertions.assertEquals("no existen suficientes pasajes para La Paz", respuesta);

        Mockito.verify(aerolineService).existenPasajes("La Paz", 3);
    }

    @Test
    public void testReservarVueloOtroDestino(){
        AerolineService aerolineService = Mockito.spy(new AerolineService());

        Mockito.doReturn(true).when(aerolineService).existenPasajes("Santa Cruz", 2);
        Mockito.doReturn("Martes").when(aerolineService).getDay(1, 1, 2023);

        String respuesta = aerolineService.reservaVuelo("Santa Cruz", 2, 1, 1, 2023);
        Assertions.assertEquals("el dia Martes 1 Enero 2023 existen 2 pasajes para Santa Cruz", respuesta);

        Mockito.verify(aerolineService).existenPasajes("Santa Cruz", 2);
        Mockito.verify(aerolineService).getDay(1, 1, 2023);
    }

    @Test
    public void testConverisonCorectaDelMes(){
        AerolineService aerolineService = Mockito.spy(new AerolineService());

        Mockito.doReturn(true).when(aerolineService).existenPasajes("Oruro", 2);
        Mockito.doReturn("Miércoles").when(aerolineService).getDay(20,4,2023);

        String respuesta = aerolineService.reservaVuelo("Oruro", 2,20,4,2023);
        Assertions.assertEquals("el dia Miércoles 20 Abril 2023 existen 2 pasajes para Oruro", respuesta);

        Mockito.verify(aerolineService).existenPasajes("Oruro", 2);
        Mockito.verify(aerolineService).getDay(20, 4, 2023);
    }
}
