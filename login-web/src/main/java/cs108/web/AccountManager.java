package cs108.web;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private final Map<String, String> account;

    public AccountManager() {
        account = new HashMap<>();
        account.put("Patrick", "1234");
        account.put("Molly", "FloPup");
    }

    public boolean exists(String name) {
        return account.containsKey(name);
    }

    public boolean matchesPassword(String name, String password) {
        return account.get(name).equals(password);
    }

    public void createNewAccount(String name, String password) {
        account.put(name, password);
    }

    // For testing
    public String getPassword(String name) {
        return account.get(name);
    }
}