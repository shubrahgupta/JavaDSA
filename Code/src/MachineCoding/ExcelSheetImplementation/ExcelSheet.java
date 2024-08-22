package MachineCoding.ExcelSheetImplementation;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheet {

    private Map<String, String> cells;

    public ExcelSheet() {
        cells = new HashMap<>();
    }

    // Set a value or formula in a cell
    public void setCell(String cell, String value) {
        cells.put(cell, value);
    }

    // Get the value of a cell, evaluating formulas if needed
    public String getCell(String cell) {
        String value = cells.get(cell);
        if (value == null) {
            return "";
        }
        if (value.startsWith("=")) {
            return evaluateFormula(value.substring(1));
        }
        return value;
    }

    // Basic formula evaluation (supports addition of two cells)
    private String evaluateFormula(String formula) {
        String[] parts = formula.split("\\+");
        int result = 0;
        for (String part : parts) {
            part = part.trim();
            if (cells.containsKey(part)) {
                result += Integer.parseInt(getCell(part));
            } else {
                result += Integer.parseInt(part);
            }
        }
        return String.valueOf(result);
    }
}

