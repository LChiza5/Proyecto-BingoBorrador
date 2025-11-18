
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto.bingoborrador;

import Controlador.ControladorPrincipal;
import Modelo.Carton;
import Modelo.ModoJuego;
import Modelo.Strategy;
import Modelo.StrategyCartonLleno;
import Modelo.StrategyCuatroEsquinas;
import Modelo.VerificadorGanador;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Luisk
 */
public class ProyectoBingoBorrador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ControladorPrincipal ctrl = new ControladorPrincipal();
        // Verificador local para chequear ganadores (lo sincronizaremos cuando se cambie modo)
        VerificadorGanador verificador = new VerificadorGanador(new Strategy());

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        System.out.println("== PRUEBAS BINGO (usando tu controlador y modelo) ==");

        while (running) {
            System.out.println("\n--- MENÚ DE PRUEBAS ---");
            System.out.println("1) Agregar cartón automático");
            System.out.println("2) Agregar cartón manual (ingresar 24 números)");
            System.out.println("3) Listar cartones (ver números + marcados)");
            System.out.println("4) Ingresar número manual (tómbola)");
            System.out.println("5) Sacar número automático (tómbola)");
            System.out.println("6) Desmarcar número (por error)");
            System.out.println("7) Cambiar modo de juego (Normal / Cuatro esquinas / Cartón lleno)");
            System.out.println("8) Verificar ganadores ahora");
            System.out.println("9) Reiniciar juego (limpia marcados y reinicia tómbola)");
            System.out.println("10) Eliminar cartón por ID");
            System.out.println("11) Mostrar números salidos y último número");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            int op = safeInt(sc);

            switch (op) {
                case 1 -> {
                    String id = "C" + (int)(Math.random() * 10000);
                    ctrl.agregarCartonAutomatico(id);
                    System.out.println("Cartón automático agregado: " + id);
                }
                case 2 -> {
                    System.out.print("Ingrese id para el cartón: ");
                    String id = sc.next();
                    int[][] nums = new int[5][5];
                    System.out.println("Ingrese 24 números (skip centro [2][2] que es LIBRE). " +
                            "Recuerde rangos por columna: col0 1-15, col1 16-30, col2 31-45, col3 46-60, col4 61-75");
                    for (int r = 0; r < 5; r++) {
                        for (int c = 0; c < 5; c++) {
                            if (r == 2 && c == 2) {
                                nums[r][c] = 0;
                                continue;
                            }
                            int min = c * 15 + 1;
                            int max = c * 15 + 15;
                            int val;
                            while (true) {
                                System.out.printf("Número para fila %d col %d (rango %d-%d): ", r, c, min, max);
                                val = safeInt(sc);
                                if (val >= min && val <= max) break;
                                System.out.println("Número fuera del rango. Intente otra vez.");
                            }
                            nums[r][c] = val;
                        }
                    }
                    boolean ok = ctrl.agregarCartonManual(id, nums);
                    System.out.println(ok ? "Cartón agregado correctamente: " + id : "Cartón inválido: no cumple validaciones.");
                }
                case 3 -> {
                    List<Carton> lista = ctrl.listarCartones();
                    if (lista.isEmpty()) {
                        System.out.println("No hay cartones.");
                        break;
                    }
                    for (Carton c : lista) {
                        imprimirCarton(c);
                    }
                }
                case 4 -> {
                    System.out.print("Número a ingresar manualmente en la tómbola (1-75): ");
                    int n = safeInt(sc);
                    boolean ok = ctrl.ingresarNumeroManual(n);
                    System.out.println(ok ? "Número ingresado a la tómbola: " + n : "Error: número inválido o ya salió.");
                    // marcar ya lo hace el juego internamente; comprobamos ganadores con el verificador local
                    var g = verificador.verificar(ctrl.listarCartones());
                    if (!g.isEmpty()) {
                        System.out.println("¡GANADOR(ES) tras ingreso manual!");
                        g.forEach(x -> System.out.println(" -> " + x.getId()));
                    }
                }
                case 5 -> {
                    int n = ctrl.sacarNumeroAuto();
                    if (n == -1) System.out.println("No hay más números disponibles.");
                    else System.out.println("Número sacado automáticamente: " + n);
                    var g = verificador.verificar(ctrl.listarCartones());
                    if (!g.isEmpty()) {
                        System.out.println("¡GANADOR(ES) tras extracción automática!");
                        g.forEach(x -> System.out.println(" -> " + x.getId()));
                    }
                }
                case 6 -> {
                    System.out.print("Número a desmarcar en todos los cartones: ");
                    int n = safeInt(sc);
                    ctrl.desmarcarNumero(n);
                    System.out.println("Se intentó desmarcar el número en todos los cartones (si existía).");
                }
                case 7 -> {
                    System.out.println("Elija modo: 1-NORMAL, 2-CUATRO_ESQUINAS, 3-CARTON_LLENO");
                    int m = safeInt(sc);
                    switch (m) {
                        case 1 -> {
                            ctrl.setModoJuego(ModoJuego.NORMAL);
                            verificador.setEstrategia(new Strategy());
                            System.out.println("Modo: NORMAL");
                        }
                        case 2 -> {
                            ctrl.setModoJuego(ModoJuego.CUATRO_ESQUINAS);
                            verificador.setEstrategia(new StrategyCuatroEsquinas());
                            System.out.println("Modo: CUATRO_ESQUINAS");
                        }
                        case 3 -> {
                            ctrl.setModoJuego(ModoJuego.CARTON_LLENO);
                            verificador.setEstrategia(new StrategyCartonLleno());
                            System.out.println("Modo: CARTON_LLENO");
                        }
                        default -> System.out.println("Opción inválida");
                    }
                }
                case 8 -> {
                    var gan = verificador.verificar(ctrl.listarCartones());
                    if (gan.isEmpty()) System.out.println("No hay ganadores actualmente.");
                    else {
                        System.out.println("GANADORES:");
                        gan.forEach(x -> System.out.println(" -> " + x.getId()));
                    }
                }
                case 9 -> {
                    ctrl.reiniciarJuego();
                    System.out.println("Juego reiniciado: cartones desmarcados y tómbola reiniciada.");
                }
                case 10 -> {
                    System.out.print("ID del cartón a eliminar: ");
                    String id = sc.next();
                    ctrl.eliminarCarton(id);
                    System.out.println("Si existía, el cartón fue eliminado.");
                }
                case 11 -> {
                    System.out.println("Números salidos: " + ctrl.getNumerosSalidos());
                    System.out.println("Último número: " + ctrl.getUltimoNumero());
                }
                case 0 -> {
                    running = false;
                    System.out.println("Saliendo pruebas.");
                }
                default -> System.out.println("Opción inválida.");
            }
        }

        sc.close();
    }

    // helper para lectura segura de enteros
    private static int safeInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Ingrese un número válido: ");
        }
        return sc.nextInt();
    }

    private static void imprimirCarton(Carton c) {
        System.out.println("\n--- Cartón: " + c.getId() + " ---");
        int[][] nums = c.getNumeros();
        boolean[][] marc = c.getMarcados();
        System.out.println("   B   I   N   G   O");
        for (int r = 0; r < 5; r++) {
            for (int co = 0; co < 5; co++) {
                if (r == 2 && co == 2) {
                    System.out.print("[FREE]");
                    continue;
                }
                String s = String.format("%02d", nums[r][co]);
                if (marc[r][co]) System.out.print("[" + s + "]");
                else System.out.print(" " + s + " ");
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
