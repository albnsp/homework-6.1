import java.util.Scanner;

public class Task05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите здоровье дракона: ");
        int dragonHealth = scanner.nextInt();

        System.out.print("Введите атаку дракона: ");
        int dragonAttack = scanner.nextInt();

        System.out.print("Введите здоровье одного копейщика: ");
        int knightHealth = scanner.nextInt();

        System.out.print("Введите атаку одного копейщика: ");
        int knightAttack = scanner.nextInt();

        int knightsNeeded = calculateKnightsNeeded(dragonHealth, dragonAttack, knightHealth, knightAttack);
        System.out.println("Минимальное количество копейщиков, необходимых для убийства дракона: " + knightsNeeded);
    }

    public static int calculateKnightsNeeded(int dragonHealth, int dragonAttack, int knightHealth, int knightAttack) {
        int knights = 0;

        while (dragonHealth > 0) {
            int knightsAttack = knights * knightAttack;
            int dragonAttackToKnight = Math.min(dragonAttack, knightHealth);

            if (knightsAttack >= dragonHealth) {
                break;
            }

            dragonHealth -= knightsAttack;

            int knightsLost = (int) Math.ceil((double) dragonAttackToKnight / knightAttack);
            knights = Math.max(0, knights - knightsLost);

            knights++;
        }

        return knights;
    }
}