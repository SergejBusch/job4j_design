package ru.job4j.solid.srp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SalaryFormats {
    public static final DecimalFormat DF_CANADA = new DecimalFormat("#",
            new DecimalFormatSymbols(Locale.CANADA));

    public static final DecimalFormat DF_CHINESE = new DecimalFormat("#,#.#",
            new DecimalFormatSymbols(Locale.CHINESE));
}
