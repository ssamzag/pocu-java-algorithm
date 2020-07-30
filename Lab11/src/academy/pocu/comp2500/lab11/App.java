package academy.pocu.comp2500.lab11;

import academy.pocu.comp2500.lab11.pocu.Department;
import academy.pocu.comp2500.lab11.pocu.Product;
import academy.pocu.comp2500.lab11.pocu.User;
import academy.pocu.comp2500.lab11.pocu.Wallet;
import academy.pocu.comp2500.lab11.pocu.Warehouse;
import academy.pocu.comp2500.lab11.pocu.WarehouseType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.UUID;

public class App {
    private static final String WELCOME_MESSAGE = "WAREHOUSE: %s%s";
    private static final String BALANCE_MESSAGE = "BALANCE: %s%s";
    private static final String PRODUCT_LIST_MESSAGE = "PRODUCT_LIST: %s%s";


    public void run(BufferedReader in, PrintStream out, PrintStream err) {
        String s = "";
        int depth = 1;
        UUID selectedItem = null;
        Warehouse warehouse = null;
        Wallet wallet = null;
        User user = new User("Jane", "Many", Department.HUMAN_RESOURCES);

        while(true) {
            int number = 1;
            if (s.equals("exit")) {
                return;
            }

            switch (depth) {
                case 1:
                    out.format(WELCOME_MESSAGE, "선택하거라. 흑우여!", System.lineSeparator());
                    for (var warehouseType : WarehouseType.values()) {
                        out.format("%d. %s%s", number++, warehouseType, System.lineSeparator());
                    }
                    depth = 2;
                    break;
                case 2:
                    try {
                        depth = 1;
                        s = in.readLine();

                        if (isNumeric(s)) {
                            int index = Integer.parseInt(s);
                            if (index >= 0 && index < WarehouseType.values().length) {
                                depth = 3;
                                warehouse = new Warehouse(WarehouseType.values()[Integer.parseInt(s) - 1]);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        depth = 4;
                        wallet = new SafeWallet(user);
                    } catch (IllegalAccessException e) {
                        err.format("AUTH_ERROR");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case 4:
                    out.format(String.format(BALANCE_MESSAGE, wallet.getAmount(), System.lineSeparator()));
                    depth = 5;
                    break;
                case 5:
                    out.format(String.format(PRODUCT_LIST_MESSAGE, "흑우야. 골라 봐라", System.lineSeparator()));
                    for(var product : warehouse.getProducts()) {
                        out.format("%d. %-20s%4d%s", number++, product.getName(), product.getPrice(), System.lineSeparator());
                    }
                    depth = 6;
                    break;
                case 6:
                    try {
                        depth = 4;
                        s = in.readLine();

                        if (isNumeric(s)) {
                            int index = Integer.parseInt(s);
                            ArrayList<Product> products = warehouse.getProducts();
                            if (index >= 1 && index <= products.size()) {
                                depth = 7;
                                selectedItem = products.get(index - 1).getId();
                            }
                        }
                    } catch (Exception e) {
                      e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        depth = 4;
                        ArrayList<Product> products = warehouse.getProducts();
                        for (Product product : products) {
                            if (product.getId().equals(selectedItem)) {
                                int price = product.getPrice();
                                if (wallet.withdraw(price)) {
                                    warehouse.removeProduct(selectedItem);
                                }

                                break;
                            }
                        }
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
