package com.manager.minisalesmanager.commons;

import android.util.Log;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 * Created by charloq on 2/06/16.
 */
public class Utils {
    private static String LOGTAG = "Utils";

    public static String currencyFormat(BigDecimal n) {
        String formatted = "";
        try {
            formatted = NumberFormat.getCurrencyInstance().format(n);
        } catch (Exception e) {
            Log.e(LOGTAG, "Error number formatting", e);
        }
        return formatted;
    }
}
