package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.PermanentlyClosedException;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.ProductNotFoundException;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

public class App {
    private static final String WELCOME_MESSAGE = "WAREHOUSE: %s%s";
    private static final String BALANCE_MESSAGE = "BALANCE: %s%s";
    private static final String PRODUCT_LIST_MESSAGE = "PRODUCT_LIST: %s%s";

    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        String s = "";
        int step = 1;
        UUID selectedItem = null;
        Warehouse warehouse = null;
        Wallet wallet = null;

        while (true) {
            int number = 1;
            if (s.equals("exit")) {
                return;
            }

            switch (step) {
                case 1:
                    out.format(WELCOME_MESSAGE, "선택하거라. 흑우여!", System.lineSeparator());
                    for (var warehouseType : WarehouseType.values()) {
                        out.format("%d. %s%s", number++, warehouseType, System.lineSeparator());
                    }
                    step = 2;
                    break;
                case 2:
                    try {
                        step = 1;
                        s = in.readLine();

                        if (isNumeric(s)) {
                            int index = Integer.parseInt(s);
                            if (index >= 0 && index <= WarehouseType.values().length) {
                                step = 3;
                                warehouse = new Warehouse(WarehouseType.values()[index - 1]);
                            }
                        } else {
                            step = 2;
                        }
                    } catch (PermanentlyClosedException e) {
                        err.print(e.getMessage() + System.lineSeparator());
                        throw e;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        step = 4;
                        wallet = new SafeWallet(new User());
                    } catch (IllegalAccessException e) {
                        err.format("AUTH_ERROR");
                        return;
                    } catch (Exception e) {
                        throw e;
                    }
                    break;
                case 4:
                    step = 5;
                    out.format(String.format(BALANCE_MESSAGE, wallet.getAmount(), System.lineSeparator()));
                    break;
                case 5:
                    step = 6;
                    out.format(String.format(PRODUCT_LIST_MESSAGE, "흑우야. 골라 봐라", System.lineSeparator()));
                    for (var product : warehouse.getProducts()) {
                        out.format("%d. %-20s%4d%s", number++, product.getName(), product.getPrice(), System.lineSeparator());
                    }
                    break;
                case 6:
                    try {
                        step = 4;
                        s = in.readLine();

                        if (isNumeric(s)) {
                            int index = Integer.parseInt(s);
                            ArrayList<Product> products = warehouse.getProducts();
                            if (index >= 1 && index <= products.size()) {
                                step = 7;
                                selectedItem = products.get(index - 1).getId();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    int price = 0;
                    try {
                        step = 4;

                        for (Product product : warehouse.getProducts()) {
                            if (product.getId().equals(selectedItem)) {
                                price = product.getPrice();
                                if (wallet.withdraw(price)) {
                                    warehouse.removeProduct(selectedItem);
                                }
                                break;
                            }
                        }
                    } catch (ProductNotFoundException e) {
                        wallet.deposit(price);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    assert false : "없으면 안 되는뎅...";
                    break;
            }

        }

    }
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
