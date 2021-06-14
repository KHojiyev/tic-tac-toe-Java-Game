package module3.Lesson3_Date.ExtraTasks.TikTakToe;

import java.util.Scanner;

public class TikTakToe {
    public static String[][] tikTak = new String[3][3];
    public static int count = 0;
    public static int[] checkX = new int[5];
    public static int checkOCount = 0;
    public static int[] checkO = new int[5];
    public static int checkXCount = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("==TikTakToe==");
        System.out.println("1.Easy 2.Medium 3.Hard");
        int choice = scanner.nextInt();

        System.out.println("Example coordinates");
        System.out.println("1,1  1,2  1,3\n" +
                "2,1  2,2  2,3\n" +
                "3,1  3,2  3,3");
        System.out.println();
        while (true) {
            scanner = new Scanner(System.in);
            System.out.print("Enter Coordinates(like 1,2): ");
            String coord = scanner.nextLine();
            int row = Integer.parseInt(coord.substring(0, 1));
            int col = Integer.parseInt(coord.substring(2, 3));
            if (tikTak[row - 1][col - 1] == null) {
                tikTak[row - 1][col - 1] = "X";
                checkX[checkXCount] = row * 10 + col;
                checkXCount++;
                count++;
                switch (choice) {
                    case 1:
                        randomChoiceEasy();
                        break;
                    case 2:
                        randomChoiceMedium();
                        break;
                    case 3:
                        randomChoiceHard();
                        break;
                }
                for (int i = 0; i < tikTak.length; i++) {
                    for (int i1 = 0; i1 < tikTak.length; i1++) {
                        if (tikTak[i][i1] == null) {
                            System.out.print("*" + " ");
                        } else
                            System.out.print(tikTak[i][i1] + " ");
                    }
                    System.out.println();
                }

                if (count > 2) {
                    if (whoWon() != null && whoWon().equals("X")) {
                        System.out.println("You won!");
                        return;
                    }
                    if (whoWon() != null && whoWon().equals("O")) {
                        System.out.println("You lose!");
                        return;
                    }
                    if (count >= 4 && whoWon() == null) {
                        System.out.println("Agreement!!!");
                        return;
                    }
                }


            }
        }
    }

    private static String whoWon() {
        int count1XTrue = 0;
        int count2XTrue = 0;
        int diagonalX = 0;

        boolean a1 = checkX[0] / 10 == checkX[1] / 10;
        boolean b1 = checkX[0] / 10 == checkX[2] / 10;
        boolean c1 = checkX[0] / 10 == checkX[3] / 10;
        boolean d1 = checkX[0] / 10 == checkX[4] / 10;
        boolean e1 = checkX[1] / 10 == checkX[2] / 10;
        boolean f1 = checkX[1] / 10 == checkX[3] / 10;
        boolean g1 = checkX[1] / 10 == checkX[4] / 10;
        boolean h1 = checkX[2] / 10 == checkX[3] / 10;
        boolean i1 = checkX[2] / 10 == checkX[4] / 10;
        boolean j1 = checkX[3] / 10 == checkX[4] / 10;
        boolean[] count1X = {a1, b1, c1, d1, e1, f1, g1, h1, i1, j1};
        boolean a2 = checkX[0] % 10 == checkX[1] % 10;
        boolean b2 = checkX[0] % 10 == checkX[2] % 10;
        boolean c2 = checkX[0] % 10 == checkX[3] % 10;
        boolean d2 = checkX[0] % 10 == checkX[4] % 10;
        boolean e2 = checkX[1] % 10 == checkX[2] % 10;
        boolean f2 = checkX[1] % 10 == checkX[3] % 10;
        boolean g2 = checkX[1] % 10 == checkX[4] % 10;
        boolean h2 = checkX[2] % 10 == checkX[3] % 10;
        boolean i2 = checkX[2] % 10 == checkX[4] % 10;
        boolean j2 = checkX[3] % 10 == checkX[4] % 10;
        boolean[] count2X = {a2, b2, c2, d2, e2, f2, g2, h2, i2, j2};
        for (int m = 0; m < 10; m++) {
            if (count1X[m]) {
                count1XTrue++;
            }
            if (count1XTrue > 2) {
                return "X";
            }
            if (count2X[m]) {
                count2XTrue++;
            }
            if (count2XTrue > 2) {
                return "X";
            }
        }
        for (int j = 0; j < 5; j++) {
            if (checkX[j] != 0) {
                if (checkX[j] % 11 == 0) {
                    diagonalX++;
                }
            }
        }
        if (diagonalX > 2) {
            return "X";
        }
        // count of computer
        int computerCombTrue = 0;
        int count2OTrue = 0;
        int diagonalO = 0;

        boolean z1 = checkO[0] / 10 == checkO[1] / 10;
        boolean y1 = checkO[0] / 10 == checkO[2] / 10;
        boolean x1 = checkO[0] / 10 == checkO[3] / 10;
        boolean w1 = checkO[0] / 10 == checkO[4] / 10;
        boolean v1 = checkO[1] / 10 == checkO[2] / 10;
        boolean u1 = checkO[1] / 10 == checkO[3] / 10;
        boolean t1 = checkO[1] / 10 == checkO[4] / 10;
        boolean s1 = checkO[2] / 10 == checkO[3] / 10;
        boolean r1 = checkO[2] / 10 == checkO[4] / 10;
        boolean q1 = checkO[3] / 10 == checkO[4] / 10;
        boolean[] count1O = {z1, y1, x1, w1, v1, u1, t1, s1, r1, q1};
        boolean z2 = checkO[0] % 10 == checkO[1] % 10;
        boolean y2 = checkO[0] % 10 == checkO[2] % 10;
        boolean x2 = checkO[0] % 10 == checkO[3] % 10;
        boolean w2 = checkO[0] % 10 == checkO[4] % 10;
        boolean v2 = checkO[1] % 10 == checkO[2] % 10;
        boolean u2 = checkO[1] % 10 == checkO[3] % 10;
        boolean t2 = checkO[1] % 10 == checkO[4] % 10;
        boolean s2 = checkO[2] % 10 == checkO[3] % 10;
        boolean r2 = checkO[2] % 10 == checkO[4] % 10;
        boolean q2 = checkO[3] % 10 == checkO[4] % 10;
        boolean[] count2O = {z2, y2, x2, w2, v2, u2, t2, s2, r2, q2};
        for (int o = 0; o < 10; o++) {
            if (count1O[o]) {
                computerCombTrue++;
            }
            if (computerCombTrue > 2) {
                return "O";
            }
            if (count2O[o]) {
                count2OTrue++;
            }
            if (count2OTrue > 2) {
                return "O";
            }
        }
        for (int n = 0; n < 5; n++) {
            if (checkO[n] != 0) {
                if (checkO[n] % 11 == 0) {
                    diagonalO++;
                }
            }
        }
        if (diagonalO > 2) {
            return "O";
        }
        return null;
    }

    private static void randomChoiceEasy() {
        while (true) {
            if (count > 4) {
                return;
            }
            int rowRandom = (int) (Math.random() * 3);
            int colRandom = (int) (Math.random() * 3);
            if (tikTak[rowRandom][colRandom] == null) {
                // from easy to hard
                if (count > 1) {


                    if (tikTak[0][0] != null && tikTak[0][2] != null && tikTak[0][0].equals("X") && tikTak[0][2].equals("X") && tikTak[0][1] == null) {
                        tikTak[0][1] = "O";
                        checkO[checkOCount] = 12;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[0][2] != null && tikTak[0][1].equals("X") && tikTak[0][2].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[2][1] != null && tikTak[2][0].equals("X") && tikTak[2][1].equals("X") && tikTak[2][2] == null) {
                        tikTak[2][2] = "O";
                        checkO[checkOCount] = 33;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[2][2] != null && tikTak[2][0].equals("X") && tikTak[2][2].equals("X") && tikTak[2][1] == null) {
                        tikTak[2][1] = "O";
                        checkO[checkOCount] = 32;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][1] != null && tikTak[2][2] != null && tikTak[2][1].equals("X") && tikTak[2][2].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[1][0] != null && tikTak[0][0].equals("X") && tikTak[1][0].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[2][0] != null && tikTak[0][0].equals("X") && tikTak[2][0].equals("X") && tikTak[1][0] == null) {
                        tikTak[1][0] = "O";
                        checkO[checkOCount] = 21;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[0][2] != null && tikTak[1][1] != null && tikTak[0][2].equals("X") && tikTak[1][1].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    } else {
                        tikTak[rowRandom][colRandom] = "O";
                        checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                        checkOCount++;
                        return;
                    }
                } else {
                    tikTak[rowRandom][colRandom] = "O";
                    checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                    checkOCount++;
                    return;
                }
            }
        }
    }

    private static void randomChoiceMedium() {
        while (true) {
            if (count > 4) {
                return;
            }
            int rowRandom = (int) (Math.random() * 3);
            int colRandom = (int) (Math.random() * 3);
            if (tikTak[rowRandom][colRandom] == null) {
                // from easy to hard
                if (count > 1) {

                    if (tikTak[0][0] != null && tikTak[0][1] != null && tikTak[0][0].equals("X") && tikTak[0][1].equals("X") && tikTak[0][2] == null) {
                        tikTak[0][2] = "O";
                        checkO[checkOCount] = 13;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[0][2] != null && tikTak[0][0].equals("X") && tikTak[0][2].equals("X") && tikTak[0][1] == null) {
                        tikTak[0][1] = "O";
                        checkO[checkOCount] = 12;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[0][2] != null && tikTak[0][1].equals("X") && tikTak[0][2].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[1][0] != null && tikTak[1][1] != null && tikTak[1][0].equals("X") && tikTak[1][1].equals("X") && tikTak[1][2] == null) {
                        tikTak[1][2] = "O";
                        checkO[checkOCount] = 23;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[1][0] != null && tikTak[1][2] != null && tikTak[1][0].equals("X") && tikTak[1][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[2][0] != null && tikTak[2][2] != null && tikTak[2][0].equals("X") && tikTak[2][2].equals("X") && tikTak[2][1] == null) {
                        tikTak[2][1] = "O";
                        checkO[checkOCount] = 32;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][1] != null && tikTak[2][2] != null && tikTak[2][1].equals("X") && tikTak[2][2].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[1][0] != null && tikTak[0][0].equals("X") && tikTak[1][0].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[2][0] != null && tikTak[0][0].equals("X") && tikTak[2][0].equals("X") && tikTak[1][0] == null) {
                        tikTak[1][0] = "O";
                        checkO[checkOCount] = 21;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[1][0] != null && tikTak[2][0].equals("X") && tikTak[1][0].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[1][1] != null && tikTak[0][1].equals("X") && tikTak[1][1].equals("X") && tikTak[2][1] == null) {
                        tikTak[2][1] = "O";
                        checkO[checkOCount] = 32;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[2][1] != null && tikTak[0][1].equals("X") && tikTak[2][1].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][1] != null && tikTak[1][1] != null && tikTak[2][1].equals("X") && tikTak[1][1].equals("X") && tikTak[0][1] == null) {
                        tikTak[0][1] = "O";
                        checkO[checkOCount] = 12;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[2][2] != null && tikTak[1][2] != null && tikTak[2][2].equals("X") && tikTak[1][2].equals("X") && tikTak[0][2] == null) {
                        tikTak[0][2] = "O";
                        checkO[checkOCount] = 13;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[1][1] != null && tikTak[0][0].equals("X") && tikTak[1][1].equals("X") && tikTak[2][2] == null) {
                        tikTak[2][2] = "O";
                        checkO[checkOCount] = 33;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[2][2] != null && tikTak[0][0].equals("X") && tikTak[2][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][2] != null && tikTak[1][1] != null && tikTak[2][2].equals("X") && tikTak[1][1].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[0][2] != null && tikTak[2][0].equals("X") && tikTak[0][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[0][2] != null && tikTak[1][1] != null && tikTak[0][2].equals("X") && tikTak[1][1].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    } else {
                        tikTak[rowRandom][colRandom] = "O";
                        checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                        checkOCount++;
                        return;
                    }
                } else {
                    tikTak[rowRandom][colRandom] = "O";
                    checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                    checkOCount++;
                    return;
                }
            }
        }
    }

    private static void randomChoiceHard() {
        while (true) {
            if (count > 4) {
                return;
            }
            int rowRandom = (int) (Math.random() * 3);
            int colRandom = (int) (Math.random() * 3);
            if (tikTak[rowRandom][colRandom] == null) {
                // from easy to hard
                if (count > 1) {

                    if (tikTak[0][0] != null && tikTak[0][1] != null && tikTak[0][0].equals("X") && tikTak[0][1].equals("X") && tikTak[0][2] == null) {
                        tikTak[0][2] = "O";
                        checkO[checkOCount] = 13;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[0][2] != null && tikTak[0][0].equals("X") && tikTak[0][2].equals("X") && tikTak[0][1] == null) {
                        tikTak[0][1] = "O";
                        checkO[checkOCount] = 12;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[0][2] != null && tikTak[0][1].equals("X") && tikTak[0][2].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[1][0] != null && tikTak[1][1] != null && tikTak[1][0].equals("X") && tikTak[1][1].equals("X") && tikTak[1][2] == null) {
                        tikTak[1][2] = "O";
                        checkO[checkOCount] = 23;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[1][0] != null && tikTak[1][2] != null && tikTak[1][0].equals("X") && tikTak[1][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[1][1] != null && tikTak[1][2] != null && tikTak[1][1].equals("X") && tikTak[1][2].equals("X") && tikTak[1][0] == null) {
                        tikTak[1][0] = "O";
                        checkO[checkOCount] = 21;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[2][1] != null && tikTak[2][0].equals("X") && tikTak[2][1].equals("X") && tikTak[2][2] == null) {
                        tikTak[2][2] = "O";
                        checkO[checkOCount] = 33;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[2][2] != null && tikTak[2][0].equals("X") && tikTak[2][2].equals("X") && tikTak[2][1] == null) {
                        tikTak[2][1] = "O";
                        checkO[checkOCount] = 32;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][1] != null && tikTak[2][2] != null && tikTak[2][1].equals("X") && tikTak[2][2].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[1][0] != null && tikTak[0][0].equals("X") && tikTak[1][0].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[2][0] != null && tikTak[0][0].equals("X") && tikTak[2][0].equals("X") && tikTak[1][0] == null) {
                        tikTak[1][0] = "O";
                        checkO[checkOCount] = 21;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[1][0] != null && tikTak[2][0].equals("X") && tikTak[1][0].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[1][1] != null && tikTak[0][1].equals("X") && tikTak[1][1].equals("X") && tikTak[2][1] == null) {
                        tikTak[2][1] = "O";
                        checkO[checkOCount] = 32;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][1] != null && tikTak[2][1] != null && tikTak[0][1].equals("X") && tikTak[2][1].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][1] != null && tikTak[1][1] != null && tikTak[2][1].equals("X") && tikTak[1][1].equals("X") && tikTak[0][1] == null) {
                        tikTak[0][1] = "O";
                        checkO[checkOCount] = 12;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][2] != null && tikTak[1][2] != null && tikTak[0][2].equals("X") && tikTak[1][2].equals("X") && tikTak[2][2] == null) {
                        tikTak[2][2] = "O";
                        checkO[checkOCount] = 33;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][2] != null && tikTak[2][2] != null && tikTak[0][2].equals("X") && tikTak[2][2].equals("X") && tikTak[1][2] == null) {
                        tikTak[1][2] = "O";
                        checkO[checkOCount] = 23;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][2] != null && tikTak[1][2] != null && tikTak[2][2].equals("X") && tikTak[1][2].equals("X") && tikTak[0][2] == null) {
                        tikTak[0][2] = "O";
                        checkO[checkOCount] = 13;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[1][1] != null && tikTak[0][0].equals("X") && tikTak[1][1].equals("X") && tikTak[2][2] == null) {
                        tikTak[2][2] = "O";
                        checkO[checkOCount] = 33;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[0][0] != null && tikTak[2][2] != null && tikTak[0][0].equals("X") && tikTak[2][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][2] != null && tikTak[1][1] != null && tikTak[2][2].equals("X") && tikTak[1][1].equals("X") && tikTak[0][0] == null) {
                        tikTak[0][0] = "O";
                        checkO[checkOCount] = 11;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[1][1] != null && tikTak[2][0].equals("X") && tikTak[1][1].equals("X") && tikTak[0][2] == null) {
                        tikTak[0][2] = "O";
                        checkO[checkOCount] = 13;
                        checkOCount++;
                        return;
                    }
                    if (tikTak[2][0] != null && tikTak[0][2] != null && tikTak[2][0].equals("X") && tikTak[0][2].equals("X") && tikTak[1][1] == null) {
                        tikTak[1][1] = "O";
                        checkO[checkOCount] = 22;
                        checkOCount++;
                        return;
                    }

                    if (tikTak[0][2] != null && tikTak[1][1] != null && tikTak[0][2].equals("X") && tikTak[1][1].equals("X") && tikTak[2][0] == null) {
                        tikTak[2][0] = "O";
                        checkO[checkOCount] = 31;
                        checkOCount++;
                        return;
                    } else {
                        tikTak[rowRandom][colRandom] = "O";
                        checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                        checkOCount++;
                        return;
                    }
                } else {
                    tikTak[rowRandom][colRandom] = "O";
                    checkO[checkOCount] = (rowRandom + 1) * 10 + (1 + colRandom);
                    checkOCount++;
                    return;
                }
            }
        }
    }
}
