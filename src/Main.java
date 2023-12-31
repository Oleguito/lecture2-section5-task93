import java.util.Scanner;

/*  5.93. Дано натуральное число n. Вычислить:
    а) 1/sin(1) + 1/(sin(1)+sin(2) + ... + 1/(sin(1)+...sin(n)
    (в каждом слагаемом под единицей все синусы а не только первый)

    В принципе на все опции один и тот же алгоритм просто формулы меняются
    В опции "в" опечатка, там в конце должно быть n в знаменателе
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = 0;
        try {
            N = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(getResultA(1, N, 0));
    }

    /*  Не знаю насколько это можно считать извращением
        Это можно спокойно решить циклами
        Я хотел попрактиковаться в рекурсии
        Входные параметры:
            int n       - число синусов под единицей
            int N       - n по задаче
            double val  - тут я записываю возвращаемое значение
        Выходное значение:
            Совпадает с экселем, по крайней мере с N == 5 */
    static double getResultA(int n, int N, double val) {
        if (n <= N) {
            /*  Пока мы не превышаем N, считаем сумму синусов */
            double sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += Math.sin(i);
            }
            /*  Записываем в параметр-буфер единицу, деленную на полученную сумму
                СЛОЖЕННУЮ с предыдущим значением параметра-буфера */
            return getResultA(n + 1, N, val + 1 / sum);
        } else if (n == N + 1) {
            /*  В предыдущем запуске записали в val нужную сумму, выходим и возвращаем */
            return val;
        }
        /*  Ругаемся */
        return -1e9;
    }
}
