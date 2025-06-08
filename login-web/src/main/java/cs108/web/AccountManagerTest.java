package cs108.web;


import junit.framework.TestCase;

public class AccountManagerTest extends TestCase {

    // Testing initial condition
    public void test1() {
        AccountManager account = new AccountManager();
        assertEquals("1234", account.getPassword("Patrick"));
        assertEquals("FloPup", account.getPassword("Molly"));
    }

    // Testing creating account
    public void test2() {
        AccountManager account = new AccountManager();
        account.createNewAccount("Giorgi", "skami");
        assertTrue(account.exists("Giorgi"));
        assertEquals("skami", account.getPassword("Giorgi"));
        assertTrue(account.matchesPassword("Giorgi", "skami"));
    }

    // Testing creating account and false password
    public void test3() {
        AccountManager account = new AccountManager();
        account.createNewAccount("Jordan", "Peterson123");
        assertEquals("Peterson123", account.getPassword("Jordan"));

        assertFalse(account.matchesPassword("Jordan", "Michael123"));
    }
}
