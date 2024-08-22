package MachineCoding.ExcelSheetImplementation;

public class DriverClass {
    public static void main(String[] args) {
        ExcelSheet sheet = new ExcelSheet();
        sheet.setCell("A1", "10");
        sheet.setCell("B1", "20");
        sheet.setCell("C1", "=A1 + B1");

        System.out.println("A1: " + sheet.getCell("A1")); // Output: 10
        System.out.println("B1: " + sheet.getCell("B1")); // Output: 20
        System.out.println("C1: " + sheet.getCell("C1")); // Output: 30
    }
}
