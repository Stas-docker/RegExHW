package controller;

import reader.ConsoleReader;
import reader.StringReader;
import utils.Utils;
import view.Menu;

import java.util.Scanner;

public class InformationAnalyzer {
    public void runAnalysis() {
        final ConsoleReader reader = new StringReader();
        Menu.startMenu();
        String text = reader.readText();
        showOrderUUID(text);
        showUserEmail(text);
        showOrderTimes(text);
    }

    private void showOrderUUID(final String text) {
        System.out.println(Utils.findAndReturnOrderUUID(text));
    }

    private void showUserEmail(final String text) {
        System.out.println(Utils.findAndReturnUserEmail(text));
    }

    private void showOrderTimes(final String text) {
        System.out.println(Utils.findAndReturnOrderTimesInfo(text));
    }
}
