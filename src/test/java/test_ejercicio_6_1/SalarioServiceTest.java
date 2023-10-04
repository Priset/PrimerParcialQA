package test_ejercicio_6_1;

import ejercicio_6_1.SalarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SalarioServiceTest {
    private SalarioService salarioService = new SalarioService();

    @ParameterizedTest
    @CsvSource({
            "2000, 0.0",
            "2000.01, 5.0",
            "1999.99, 0.0",
            "4000, 5.0",
            "4000.01, 15.0",
            "3999.99, 5.0",
            "1500, 0.0",
            "4500, 15.0",
            "-500, 0.0"
    })

    public void testCalcularDescuento(double salario, double descuentoEsperado){
        if (salario < 0){
            Assertions.assertThrows(IllegalArgumentException.class, () -> salarioService.calcularDescuento(salario));
        } else {
            double descuentoReal = salarioService.calcularDescuento(salario);
            Assertions.assertEquals(descuentoEsperado, descuentoReal, "ERROR! El descuento no es el esperado!");
        }
    }

}
