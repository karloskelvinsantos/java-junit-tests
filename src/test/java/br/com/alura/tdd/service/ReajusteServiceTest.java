package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    @Test
    void reajusteDeveSerDeTresPorCentoParaDesempenhoADesejar() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("Fulano", LocalDate.of(1991, Month.JANUARY, 20), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeQuinzePorCentoParaDesempenhoBom() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("Fulano", LocalDate.of(1991, Month.JANUARY, 20), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveSerDeVintePorCentoParaDesempenhoOtimo() {
        var service = new ReajusteService();
        var funcionario = new Funcionario("Fulano", LocalDate.of(1991, Month.JANUARY, 20), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
