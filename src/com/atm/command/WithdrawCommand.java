package com.atm.command;

import com.atm.CashMachine;
import com.atm.ConsoleHelper;
import com.atm.CurrencyManipulator;
import com.atm.CurrencyManipulatorFactory;
import com.atm.exception.InterruptOperationException;
import com.atm.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            String s = ConsoleHelper.readString();
            if (s == null) {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } else {
                try {
                    int amount = Integer.parseInt(s);
                    boolean isAmountAvailable = manipulator.isAmountAvailable(amount);
                    if (isAmountAvailable) {
                        Map<Integer, Integer> denominations = manipulator.withdrawAmount(amount);
                        for (Integer item : denominations.keySet()) {
                            ConsoleHelper.writeMessage("\t" + item + " - " + denominations.get(item));
                        }

                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
                        break;
                    } else {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    }
                } catch (NumberFormatException | NotEnoughMoneyException e) {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }
            }
        }
    }
}
