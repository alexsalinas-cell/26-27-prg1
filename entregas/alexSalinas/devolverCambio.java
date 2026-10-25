import java.util.Scanner;

public class devolverCambio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Cuantos euros debe pagar? (ej: 23,45)");
        int importe = aCentimos(sc.next());

        System.out.println("Con cuantos euros paga? (ej: 50,00)");
        int entregado = aCentimos(sc.next());

        if (entregado < importe) {
            System.out.println("Error: el importe entregado es insuficiente.");
            sc.close();
            return;
        }

        int cambio = entregado - importe;
        System.out.println("Cambio a devolver: " + cambio / 100 + "," + String.format("%02d", cambio % 100) + " euros");

        // Valores en centimos: 100 euros = 10000 centimos
        int[] valores = {10000, 5000, 2000, 1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        for (int i = 0; i < valores.length; i++) {
            int cantidad = cambio / valores[i];
            cambio = cambio % valores[i];

            if (cantidad > 0) {
                if (valores[i] >= 500) {
                    System.out.println(cantidad + " billete(s) de " + valores[i] / 100 + " euros");
                } else if (valores[i] >= 100) {
                    System.out.println(cantidad + " moneda(s) de " + valores[i] / 100 + " euros");
                } else {
                    System.out.println(cantidad + " moneda(s) de " + valores[i] + " centimos");
                }
            }
        }

        sc.close();
    }

    static int aCentimos(String texto) {
        double valor = Double.parseDouble(texto.replace(',', '.'));
        return (int) Math.round(valor * 100);
    }
}
