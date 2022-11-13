package com.ksabando.validarcodigo;


import junit.framework.TestCase;

public class ValidarCodigoContenedorTest extends TestCase {

    ValidarCodigoContenedor validarCodigoContenedor;

    @Override
    protected void setUp() throws Exception {
        validarCodigoContenedor = ValidarCodigoContenedor.getSingleton();
    }

    public void testComprobacionCodigo() {
        assertEquals("Error", validarCodigoContenedor.ComprobacionCodigo("M234567890"));
        assertEquals("Error", validarCodigoContenedor.ComprobacionCodigo("MSCUART8901"));
        assertEquals("Error", validarCodigoContenedor.ComprobacionCodigo("M23456789011"));

        assertEquals("Codigo Correcto", validarCodigoContenedor.ComprobacionCodigo("MSCU7512387"));
        assertEquals("Codigo Incorrecto", validarCodigoContenedor.ComprobacionCodigo("MSCU7512388"));
    }
}