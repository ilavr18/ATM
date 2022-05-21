package com.lavrus.atm.command;

import com.lavrus.atm.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException, InterruptOperationException;
}
