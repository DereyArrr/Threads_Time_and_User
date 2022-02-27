/*Программа раз в секнду выводит число, пока пользователь не введет что-то(в двух потоках)*/
import java.util.Scanner;
import java.lang.*;

class Time extends Thread
{
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
            for (int i = 1; i < 100; i++) {
                System.out.println(i);
                try {
                    sleep(1000);
                } catch (Exception e) {
                }
            }
    }
}

class User extends Thread
{
    public void run()	//Этот метод будет выполнен в побочном потоке
    {
       /* System.out.println("Введите:");
        try {
            sleep(5000);
        } catch (Exception e){}
        System.out.println("Введите:");*/
        System.out.println("Введите: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.print("Вы ввели: ");
        System.out.println(s);
    }
}

public class Thread1 {
    public static void main(String[] args)
    {
        Time T = new Time();	//Создание потока
        User U = new User();
        T.setDaemon(true);//чтобы при завершении основного потока закончилось
        U.start();					//Запуск потока
        T.start();
    }
}