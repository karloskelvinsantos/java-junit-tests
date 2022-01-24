package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {


    @Test
    void bonusDeveSerZeroParaSalarioMaiorQueDezMil () {
        var bonusService = new BonusService();
        var bonus = bonusService.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("11000")));

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveSerDezPorCentoParaSalarioMenorQueDezMil () {
        var bonusService = new BonusService();
        var bonus = bonusService.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveSerDezPorCentoParaSalarioIgualADezMil () {
        var bonusService = new BonusService();
        var bonus = bonusService.calcularBonus(new Funcionario("Fulano", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}