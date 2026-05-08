package cl.usm.calculadoraspring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Suite de calcular service
class CalculadoraServiceTest {

    CalculadoraService calculadoraService;

    @BeforeEach
    void setUp() {
        calculadoraService = new CalculadoraService();
    }

    // Test case 1
    @Test
    void calcularSumaOk() {
        double res = calculadoraService.calcular("+", 1, 2);
        assertEquals(3, res);
    }

    // Test case 2
    @Test
    void calcularRestaOk(){
        double res = calculadoraService.calcular("-", 5, 2);
        assertEquals(3, res);
    }

    // Test case 3
    @Test
    void calcularMultiplicacionOk() {
        double res = calculadoraService.calcular("*", 3, 3);
        assertEquals(9, res);
    }

    // Test case 4
    @Test
    void calcularDivisionOk() {
        double res = calculadoraService.calcular("/", 8, 4);
        assertEquals(2, res);
    }

    // Test case 5
    @Test
    void calcularDivisionNok() {
        Exception ex = assertThrows(NumberFormatException.class, ()-> {
            double res = calculadoraService.calcular("/", 5, 0);
        });
        assertEquals("can't divide by zero", ex.getMessage());
    }

    // Test case 6
    @Test
    void calcularOperationNok() {
        Exception ex = assertThrows(NumberFormatException.class, ()-> {
            double res = calculadoraService.calcular("fake", 0, 0);
        });
        assertEquals("Invalid operation", ex.getMessage());
    }
}