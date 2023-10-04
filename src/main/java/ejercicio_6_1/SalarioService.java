package ejercicio_6_1;

public class SalarioService {
    private static final int SALARIO_BASICO = 2000;

    public double calcularDescuento(double salario){
        if (salario <= 0){
            throw new IllegalArgumentException("Salario no válido!");
        }

        if (salario <= SALARIO_BASICO) {
            return 0.0;
        } else if (salario > SALARIO_BASICO && salario <= 2 * SALARIO_BASICO) {
            return 5.0;
        } else {
            return 15.0;
        }
    }
}
