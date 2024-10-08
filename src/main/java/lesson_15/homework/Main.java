package lesson_15.homework;

import lesson_15.homework.exceptions.WrongAccountException;
import lesson_15.homework.exceptions.WrongCurrencyException;
import lesson_15.homework.exceptions.WrongOperationException;

public class Main
{
    // Поле BankApplication
    private static final BankApplication bankApplication = new BankApplication();


    static public void main(String[] args) {
        processWrapper("accountId000",50,"USD");
        processWrapper("accountId003",250,"HRV");
        processWrapper("accountId001",50,"EUR");
        processWrapper("accountId001",50,"USD");
        processWrapper("accountId001",2000,"USD");
    }

    // Метод processWrapper(String, int, String)
    public static void processWrapper(String accountId, int amount, String currency) {
        try {
            bankApplication.process(accountId, amount, currency);
        } catch (WrongAccountException e) {
            System.out.println("Такого акаунту не існує");
        } catch (WrongCurrencyException e) {
            System.out.println("Акаунт має рахунок в іншій валюті");
        } catch (WrongOperationException e) {
            System.out.println("Акаунт не має достатньо коштів");
        } catch (Exception e) {
            System.out.println("Сталася помилка під час процесингу, спробуйте ще раз");
        } finally {
            System.out.println("Дякуємо, що скористалися нашим сервісом");
        }
    }
}
