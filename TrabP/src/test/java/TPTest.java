import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author joao
 */
public class TPTest {
    
    public TPTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of printMenu method, of class TP.
     */
    @Test
    public void testPrintMenu() {
        System.out.println("printMenu");
        TP.printMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menu method, of class TP.
     */
    @Test
    public void testMenu() throws Exception {
        System.out.println("menu");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] pontuacao = null;
        int M = 0;
        boolean[] jaLido = null;
        int[] contGrupo = null;
        int expResult = 0;
        int result = TP.menu(equipaGrupo, limite, pontuacao, M, jaLido, contGrupo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class TP.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        TP.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lerFicheiro method, of class TP.
     */
    @Test
    public void testLerFicheiro() throws Exception {
        System.out.println("lerFicheiro");
        String[][] equipaGrupo = null;
        int expResult = 0;
        int result = TP.lerFicheiro(equipaGrupo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lerManualmente method, of class TP.
     */
    @Test
    public void testLerManualmente() {
        System.out.println("lerManualmente");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] contGrupo = null;
        int expResult = 0;
        int result = TP.lerManualmente(equipaGrupo, limite, contGrupo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarRepetição method, of class TP.
     */
    @Test
    public void testVerificarRepetição() {
        System.out.println("verificarRepeti\u00e7\u00e3o");
        String[][] equipaGrupo = null;
        int i1 = 0;
        int limite = 0;
        boolean expResult = false;
        boolean result = TP.verificarRepetição(equipaGrupo, i1, limite);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecPorGrupo method, of class TP.
     */
    @Test
    public void testSelecPorGrupo() {
        System.out.println("selecPorGrupo");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] contGrupo = null;
        TP.selecPorGrupo(equipaGrupo, limite, contGrupo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificarNumSelecGrup method, of class TP.
     */
    @Test
    public void testVerificarNumSelecGrup() {
        System.out.println("verificarNumSelecGrup");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] contGrupo = null;
        int i = 0;
        boolean expResult = false;
        boolean result = TP.verificarNumSelecGrup(equipaGrupo, limite, contGrupo, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calcularPontuacao method, of class TP.
     */
    @Test
    public void testCalcularPontuacao() {
        System.out.println("calcularPontuacao");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] pontuacao = null;
        TP.calcularPontuacao(equipaGrupo, limite, pontuacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenar method, of class TP.
     */
    @Test
    public void testOrdenar() {
        System.out.println("ordenar");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] pontuacao = null;
        int[] contGrupo = null;
        TP.ordenar(equipaGrupo, limite, pontuacao, contGrupo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortGru method, of class TP.
     */
    @Test
    public void testSortGru() {
        System.out.println("sortGru");
        String[][] equipaGrupo = null;
        int i1 = 0;
        int i = 0;
        int limite = 0;
        int[] pontuacao = null;
        TP.sortGru(equipaGrupo, i1, i, limite, pontuacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sortBetGru method, of class TP.
     */
    @Test
    public void testSortBetGru() {
        System.out.println("sortBetGru");
        String[][] equipaGrupo = null;
        int classPrim = 0;
        int i = 0;
        int limite = 0;
        int[] pontuacao = null;
        int classUltimo = 0;
        TP.sortBetGru(equipaGrupo, classPrim, i, limite, pontuacao, classUltimo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of check1 method, of class TP.
     */
    @Test
    public void testCheck1() {
        System.out.println("check1");
        int[] generico = null;
        String[][] equipaGrupo = null;
        int i = 0;
        boolean expResult = false;
        boolean result = TP.check1(generico, equipaGrupo, i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of imprimirGrupo method, of class TP.
     */
    @Test
    public void testImprimirGrupo() {
        System.out.println("imprimirGrupo");
        String[][] equipaGrupo = null;
        int[] pontuacao = null;
        int limite = 0;
        TP.imprimirGrupo(equipaGrupo, pontuacao, limite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of maximoGolos method, of class TP.
     */
    @Test
    public void testMaximoGolos() {
        System.out.println("maximoGolos");
        String[][] equipaGrupo = null;
        int limite = 0;
        TP.maximoGolos(equipaGrupo, limite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sofridoGolos method, of class TP.
     */
    @Test
    public void testSofridoGolos() {
        System.out.println("sofridoGolos");
        String[][] equipaGrupo = null;
        int limite = 0;
        TP.sofridoGolos(equipaGrupo, limite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenarDiferencaGolos method, of class TP.
     */
    @Test
    public void testOrdenarDiferencaGolos() {
        System.out.println("ordenarDiferencaGolos");
        String[][] equipaGrupo = null;
        int limite = 0;
        TP.ordenarDiferencaGolos(equipaGrupo, limite);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeiroGrupo method, of class TP.
     */
    @Test
    public void testPrimeiroGrupo() {
        System.out.println("primeiroGrupo");
        String[][] equipaGrupo = null;
        int limite = 0;
        int[] pontuacao = null;
        int[] contGrupo = null;
        TP.primeiroGrupo(equipaGrupo, limite, pontuacao, contGrupo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
