package com.atm.command;

import com.atm.exception.InterruptOperationException;

interface Command {
    void execute() throws InterruptOperationException, InterruptOperationException;
}
