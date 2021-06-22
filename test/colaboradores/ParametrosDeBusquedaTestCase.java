package colaboradores;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.ParametrosBusqueda;

class ParametrosDeBusquedaTestCase {

	ParametrosBusqueda paramBusqueda;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testLosParametrosDeBusquedaPuedenRecibirSoloParametrosObligatorios() {
		LocalDate checkIn = LocalDate.of(2021, 6, 10);
		LocalDate checkOut = LocalDate.of(2021, 6, 12);
		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut);

		assertEquals(paramBusqueda.getCiudad(), "Buenos Aires");
		assertEquals(paramBusqueda.getCheckIn(), LocalDate.of(2021, 6, 10));
		assertEquals(paramBusqueda.getCheckOut(), LocalDate.of(2021, 6, 12));

	}

	@Test
	void testLosParametrosDeBusquedaPuedenRecibirObligatoriosYElRestoPuedenSerNulos() {
		LocalDate checkIn = LocalDate.of(2021, 6, 10);
		LocalDate checkOut = LocalDate.of(2021, 6, 12);
		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, null, null, null);

		assertEquals(paramBusqueda.getCantidadDeHuespedes(), null);
		assertEquals(paramBusqueda.getPrecioMinimo(), null);
		assertEquals(paramBusqueda.getPrecioMaximo(), null);

	}

	@Test
	void testLosParametrosDeBusquedaRecibenObligatoriosYOpcionalDeCantHuespedes() {
		LocalDate checkIn = LocalDate.of(2021, 6, 10);
		LocalDate checkOut = LocalDate.of(2021, 6, 12);
		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, 3, null, null);

		assertEquals(paramBusqueda.getCantidadDeHuespedes(), 3);
		assertTrue(paramBusqueda.seIndicaCantidadDeHuespedes());

	}

	@Test
	void testLosParametrosDeBusquedaRecibenObligatoriosYPrecioMinimoYMaximo() {
		LocalDate checkIn = LocalDate.of(2021, 6, 10);
		LocalDate checkOut = LocalDate.of(2021, 6, 12);
		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, null, 100.0, 150.0);

		assertEquals(paramBusqueda.getPrecioMinimo(), 100.0);
		assertEquals(paramBusqueda.getPrecioMaximo(), 150.0);
		assertFalse(paramBusqueda.seIndicaCantidadDeHuespedes());

	}

	@Test
	void testLosParametrosObligatoriosRecibenObligatoriosYTodosLosOpcionales() {
		LocalDate checkIn = LocalDate.of(2021, 6, 10);
		LocalDate checkOut = LocalDate.of(2021, 6, 12);
		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, 3, 100.0, 150.0);

		assertEquals(paramBusqueda.getCantidadDeHuespedes(), 3);
		assertEquals(paramBusqueda.getPrecioMinimo(), 100.0);
		assertEquals(paramBusqueda.getPrecioMaximo(), 150.0);

	}

}
